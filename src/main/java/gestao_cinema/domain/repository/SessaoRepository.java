package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Sessao;

import java.sql.SQLException;
import java.util.List;

public interface SessaoRepository {

    public void criarSessao(Sessao sessao)  throws SQLException;

    public List<Sessao>procurarSessaoPorFilme() throws SQLException;
}
