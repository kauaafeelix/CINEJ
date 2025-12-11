package gestao_cinema.domain.repository;

import gestao_cinema.application.dto.ingresso.EmitirIngressoDTO;
import gestao_cinema.domain.model.Ingresso;
import gestao_cinema.domain.model.enums.StatusIngresso;

import java.sql.SQLException;
import java.util.List;

public interface   IngressoRepository {

    public Ingresso criarIngresso(Ingresso ingresso) throws SQLException;

    public void alterarStatus (long id, StatusIngresso status) throws SQLException;

    public List<EmitirIngressoDTO> emitirIngresso() throws SQLException;
}
