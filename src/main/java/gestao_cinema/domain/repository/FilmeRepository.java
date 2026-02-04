package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Filme;

import java.sql.SQLException;
import java.util.List;

public interface FilmeRepository {

    public Filme criarFilme(Filme filme ) throws SQLException;

    public List<Filme> buscarFilmePorGenero(String genero)  throws SQLException;

    public List<Filme> listarFilmes() throws SQLException;

    public Filme deletarFilme(long id) throws SQLException;

}
