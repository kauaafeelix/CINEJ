package gestao_cinema.domain.utils;

import gestao_cinema.domain.model.Filme;

import java.util.List;
import java.util.Scanner;

public class FilmeUtils {
    Scanner leiaNum = new Scanner(System.in);
    Scanner leiaStr = new Scanner(System.in);

    public void exibirFilmes(List<Filme>filmes){
        if (filmes!= null && !filmes.isEmpty()){
            System.out.println("===== Lista de Filmes =====");
            for (Filme filme : filmes) {
                System.out.println("ID: " + filme.getId());
                System.out.println("Título: " + filme.getTitulo());
                System.out.println("Gênero: " + filme.getGenero());
                System.out.println("Duração (minutos): " + filme.getDuracaoMinutos());
                System.out.println("Lançamento: " + (filme.getLancamento() ? "Sim" : "Não"));
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("\n[AVISO] Nenhum filme cadastrado.");
        }

    }
}
