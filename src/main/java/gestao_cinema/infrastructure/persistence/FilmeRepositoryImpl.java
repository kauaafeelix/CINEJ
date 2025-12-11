package gestao_cinema.infrastructure.persistence;

import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.repository.FilmeRepository;

import java.sql.SQLException;
import java.util.List;

public class FilmeRepositoryImpl implements FilmeRepository {

    @Override
    public void criarFilme(Filme filme)  throws SQLException {

    }

    @Override
    public List<Filme> buscarFilmePorGenero(String genero) throws SQLException {
        return null;
    }
}
