package gestao_cinema.application.service;

import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.repository.FilmeRepository;
import gestao_cinema.infrastructure.persistence.FilmeRepositoryImpl;
import gestao_cinema.view.filme.FilmeView;

public class FilmeServiceImpl {

    FilmeView filmeView = new FilmeView();
    FilmeRepositoryImpl filmeRepository = new FilmeRepositoryImpl();

    public void cadastrarFilme(){
        var filme = new Filme();
        filme = filmeView.cadastrarFilmes();

        if (filme.getTitulo() == null || filme.getGenero() == null || filme.getDuracaoMinutos() <= 0){
            System.out.println("Dados inválidos! Por favor, tente novamente.");
            return;
        } else {
            try {
                filmeRepository.criarFilme(filme);
                System.out.println("Filme cadastrado com sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar o filme: " );
                e.printStackTrace();
            }
        }
    }

}
