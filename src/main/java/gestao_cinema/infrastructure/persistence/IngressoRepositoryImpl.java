package gestao_cinema.infrastructure.persistence;

import gestao_cinema.domain.model.Ingresso;
import gestao_cinema.domain.model.enums.StatusIngresso;
import gestao_cinema.domain.repository.IngressoRepository;

import java.sql.SQLException;
import java.util.List;

public class IngressoRepositoryImpl implements IngressoRepository {
    @Override
    public void criarIngresso(Ingresso ingresso)  throws SQLException {

    }

    @Override
    public Ingresso alterarStatus(StatusIngresso status)  throws SQLException{
        return null;
    }

    @Override
    public List<Ingresso> listarTodosIngressosPorCliente()  throws SQLException{
        return List.of();
    }
}
