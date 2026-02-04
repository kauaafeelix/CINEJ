package gestao_cinema.application.service;

import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.repository.FilmeRepository;
import gestao_cinema.domain.utils.FilmeUtils;
import gestao_cinema.infrastructure.persistence.FilmeRepositoryImpl;
import gestao_cinema.view.filme.FilmeView;

import java.sql.SQLException;
import java.util.List;

public class FilmeServiceImpl {

    FilmeView filmeView = new FilmeView();
    FilmeRepositoryImpl filmeRepository = new FilmeRepositoryImpl();
    FilmeUtils filmeUtils = new FilmeUtils();

    public void cadastrarFilme(){
        var filme = new Filme();
        filme = filmeView.cadastrarFilmes();

        if (filme.getTitulo() == null || filme.getGenero() == null || filme.getDuracaoMinutos() <= 0){
            System.out.println("Dados inválidos! Por favor, tente novamente.");
            return;
        } else {
            try {
                filmeRepository.criarFilme(filme);
                System.out.println("Filme cadastrado com sucesso!\n");
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar o filme: \n" );
                e.printStackTrace();
            }
        }
    }

    public void listarFilmes(){
        try{
            List<Filme> filmes = filmeRepository.listarFilmes();
            if (filmes == null || filmes.isEmpty()){
                System.out.println("Nenhum filme cadastrado.");
            } else {
                filmeView.listarFilmes();
                filmeUtils.exibirFilmes(filmes);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void buscarFilmePorGenero(){
        String genero = filmeView.capturarGenero();

        try {
            List<Filme> filme = filmeRepository.buscarFilmePorGenero(genero);
            if (filme == null){
                System.out.println("Nenhum filme encontrado com o gênero: " + genero);
            } else {
                filmeUtils.exibirFilmes(filme);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o filme por gênero: " );
            e.printStackTrace();
        }
    }

    public void deletarFilme(){
        try {
            List<Filme>filmes = filmeRepository.listarFilmes();
            filmeUtils.exibirFilmes(filmes);

            long id = filmeView.deletarFilme();
            Filme filmeDeletado = filmeRepository.deletarFilme(id);
            if (filmeDeletado != null){
                System.out.println("Filme deletado com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar o filme: " );
            e.printStackTrace();
        }
    }

}
