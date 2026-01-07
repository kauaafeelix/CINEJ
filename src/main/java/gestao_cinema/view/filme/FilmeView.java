package gestao_cinema.view.filme;

import gestao_cinema.domain.model.Filme;

import java.util.Scanner;

public class FilmeView {
    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner (System.in);


    public int menuFilme(){
        System.out.println("""
                ======== FILMES ========
                1 - Cadastrar Filme
                2 - Listar Filmes
                3 - Atualizar Filmes
                4 - Deletar um Filme
                0 - Voltar ao Menu Principal
                """);

        int opcao = capturarOpcao();
        return opcao;
    }

    public int capturarOpcao(){
        System.out.println("Digite sua opcao: ");
        return scNum.nextInt();
    }

    public Filme cadastrarFilmes(){
        System.out.println("""
                ==== CADASTRO DE FILME ====
                
        \n        """);

        System.out.println("Digite o Titulo do Filme:");
        String titulo = scStr.nextLine();

        System.out.println("Digite o Gênero do Filme: ");
        String genero = scStr.nextLine();

        System.out.println("Digite a Duração do Filme (em minutos): ");
        int duracaoMinutos = scNum.nextInt();

        System.out.println("O Filme é um Lançamento? Digite True ou False:");
        boolean isLancamento = scStr.nextBoolean();

        var novoFilme = new Filme(titulo, genero, duracaoMinutos, isLancamento);
        return novoFilme;
    }


}

