package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Ingresso;
import gestao_cinema.domain.model.enums.StatusIngresso;

import java.sql.SQLException;
import java.util.List;

public interface IngressoRepository {

    public void criarIngresso(Ingresso ingresso) throws SQLException;

    public Ingresso alterarStatus (StatusIngresso status) throws SQLException;

    public List<Ingresso> listarTodosIngressosPorCliente() throws SQLException;
}
