package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Cliente;

public interface ClienteRepository {

    public void criarCliente(Cliente cliente);

    public Cliente buscarClientePorId(Long id);

    public void atualizarCliente(Cliente cliente);

    public void deletarCliente(Long id);

    public Cliente buscarClientePorNome(String nome);
}
