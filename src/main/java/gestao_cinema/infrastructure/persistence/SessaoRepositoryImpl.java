package gestao_cinema.infrastructure.persistence;

import gestao_cinema.domain.model.Ingresso;
import gestao_cinema.domain.model.Sessao;
import gestao_cinema.domain.model.enums.StatusIngresso;
import gestao_cinema.domain.repository.IngressoRepository;
import gestao_cinema.domain.repository.SessaoRepository;

import java.sql.SQLException;
import java.util.List;

public class SessaoRepositoryImpl implements SessaoRepository {

    @Override
    public void criarSessao(Sessao sessao) throws SQLException {

    }

    @Override
    public List<Sessao> procurarSessaoPorFilme() throws SQLException {
        return List.of();
    }
}
