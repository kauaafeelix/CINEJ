package gestao_cinema.domain.repository;

import gestao_cinema.domain.model.Filme;

public interface FilmeRepository {

    public void criarFilme(Filme filme);

    public Filme buscarFilmePorGenero(long ig);



}
