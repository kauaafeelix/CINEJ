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
                3 - Buscar Filmes por Gênero
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
        System.out.println("========= CADASTRO DE FILME ========\n");

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

    public void listarFilmes() {
        System.out.println("========= LISTA DE FILMES ========\n");
    }

    public String capturarGenero(){
        System.out.println("Digite o Gênero do Filme que deseja buscar: ");
        String genero = scStr.nextLine();
        return genero;
    }

    public long deletarFilme(){
        System.out.println("Digite o ID do Filme que deseja deletar: ");
        long id = scNum.nextLong();
        System.out.println("Esta ação é irreversível! Tem certeza que deseja deletar o filme de ID " + id + "? (S/N)");
        String confirmacao = scStr.nextLine();
        if (!confirmacao.equalsIgnoreCase("S")){
            System.out.println("Ação cancelada.");
            return -1;
        }
        return id;
    }






}

