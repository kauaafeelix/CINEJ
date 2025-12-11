package gestao_cinema.infrastructure.persistence;

import gestao_cinema.application.dto.ingresso.EmitirIngressoDTO;
import gestao_cinema.domain.model.Cliente;
import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.model.Ingresso;
import gestao_cinema.domain.model.Sessao;
import gestao_cinema.domain.model.enums.StatusIngresso;
import gestao_cinema.domain.model.enums.TipoIngresso;
import gestao_cinema.domain.repository.IngressoRepository;
import gestao_cinema.infrastructure.database.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngressoRepositoryImpl implements IngressoRepository {
    @Override
    public Ingresso criarIngresso(Ingresso ingresso)  throws SQLException {

        String sql = """
                INSERT INTO Ingresso (
                cliente_id, 
                sessao_id, 
                data_compra, 
                tipo_ingresso, 
                status
                ) VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setLong(1, ingresso.getIdCliente());
            ps.setLong(2, ingresso.getIdSessao());
            ps.setDate(3, Date.valueOf(ingresso.getDataCompra()));
            ps.setString(4, String.valueOf(ingresso.getTipoIngresso()));
            ps.setString(5, String.valueOf(ingresso.getStatusIngresso()));
        }
        return ingresso;
    }

    @Override
    public void alterarStatus(long id, StatusIngresso status)  throws SQLException{

        String sql = """
                UPDATE Ingresso
                SET status = ?
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(status));
            ps.setLong(2, id);
            ps.executeUpdate();
        }

    }

    @Override
    public List<EmitirIngressoDTO> emitirIngresso() throws SQLException {

        List<EmitirIngressoDTO> ingressos = new ArrayList<>();

        String sql = """
            SELECT
                i.id,
                c.nome AS cliente_nome,
                s.sala AS sala_sessao,
                f.titulo AS filme_titulo,
                i.data_compra,
                i.tipo_ingresso,
                i.status
            FROM Ingresso i
            INNER JOIN Cliente c ON i.cliente_id = c.id
            INNER JOIN Sessao s ON i.sessao_id = s.id
            INNER JOIN Filme f ON s.filme_id = f.id
            ORDER BY c.nome
            """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery() ;
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String clienteNome = rs.getString("cliente_nome");
                    String salaSessao = rs.getString("sala_sessao");
                    String filmeTitulo = rs.getString("filme_titulo");
                    Date dataCompra = rs.getDate("data_compra");
                    TipoIngresso tipoIngresso = TipoIngresso.valueOf(rs.getString("tipo_ingresso"));
                    StatusIngresso status = StatusIngresso.valueOf(rs.getString("status"));

                    EmitirIngressoDTO dto = new EmitirIngressoDTO(
                            id,
                            clienteNome,
                            salaSessao,
                            filmeTitulo,
                            dataCompra,
                            tipoIngresso,
                            status
                    );

                    ingressos.add(dto);
                }
            }
        return ingressos;
    }
}
