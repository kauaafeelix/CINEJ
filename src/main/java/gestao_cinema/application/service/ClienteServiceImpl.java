package gestao_cinema.application.service;

import gestao_cinema.application.service.contracts.ClienteService;
import gestao_cinema.domain.model.Cliente;
import view.cliente.ClienteView;

public class ClienteServiceImpl implements ClienteService {

    ClienteView viewCliente = new ClienteView();

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {

        return cliente;
    }
}
