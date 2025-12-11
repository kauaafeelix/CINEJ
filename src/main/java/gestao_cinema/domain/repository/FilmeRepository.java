package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Filme;

import java.sql.SQLException;
import java.util.List;

public interface FilmeRepository {

    public void criarFilme(Filme filme ) throws SQLException;

    public List<Filme> buscarFilmePorGenero(String genero)  throws SQLException;



}
