package gestao_cinema.infrastructure.persistence;

import gestao_cinema.domain.model.Cliente;
import gestao_cinema.domain.repository.ClienteRepository;
import gestao_cinema.infrastructure.database.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepository {


    @Override
    public Cliente criarCliente(Cliente cliente)  throws SQLException {
        String sql = """
                INSERT INTO Cliente (
                nome,
                email,
                saldo_carteira
                ) VALUES (?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setDouble(3, cliente.getSaldoCarteira());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                long idGerado = rs.getLong(1);
                cliente.setId(idGerado);
            }
        }
        return cliente;
    }

    @Override
    public Cliente buscarClientePorId(long id)  throws SQLException{

        String sql = """
                SELECT 
                id, 
                nome, 
                email, 
                saldo_carteira
                FROM Cliente
                WHERE id = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                long idBanco = rs.getLong("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo_carteira");

                return new Cliente(id, nome, email, saldo);
            }
        }
        return null;
    }


    @Override
    public void atualizarCliente(Cliente cliente)  throws SQLException{
        String sql = """
                UPDATE Cliente
                SET 
                nome = ?,
                email = ?,
                saldo_carteira = ?
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setDouble(3, cliente.getSaldoCarteira());
            ps.setLong(4, cliente.getId());

            ps.executeUpdate();
        }

    }

    @Override
    public void deletarCliente(long id)  throws SQLException{
        String sql = """
                DELETE FROM Cliente
                WHERE id = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setLong(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Cliente> buscarClientePorNome(String nome)  throws SQLException{
        List<Cliente>clientes = new ArrayList<>();

        String sql = """
                SELECT 
                id, 
                nome, 
                email, 
                saldo_carteira
                WHERE nome LIKE = ?
                """;

        try(Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, nome + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String nomeBanco = rs.getString("nome");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo_carteira");

                Cliente cliente = new Cliente(id, nomeBanco, email, saldo);
                clientes.add(cliente);

            }
        }
        return clientes;
    }

}
