package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteRepository {

    public Cliente criarCliente(Cliente cliente) throws SQLException;

    public Cliente buscarClientePorId(long id)  throws SQLException;

    public void atualizarCliente(Cliente cliente)  throws SQLException;

    public void deletarCliente(Long id)  throws SQLException;

    public List<Cliente> buscarClientePorNome(String nome)  throws SQLException;
}
