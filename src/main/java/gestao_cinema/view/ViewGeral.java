package gestao_cinema.view;

import java.util.Scanner;

public class ViewGeral {

    Scanner leiaStr = new Scanner(System.in);
    Scanner leiaNum = new Scanner(System.in);

    public int menuPrincipal(){
        System.out.println("===== Gestão de Cinema =====");
        System.out.println("1. Gerenciar Filmes");
        System.out.println("2. Gerenciar Clientes");
        System.out.println("3. Gerenciar Sessões");
        System.out.println("4. Gerenciar Ingressos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leiaNum.nextInt();
        return opcao;
    }


    public void encerrando() {
        try {
            System.out.print("\nS");
            Thread.sleep(500);
            System.out.print("i");
            Thread.sleep(500);
            System.out.print("s");
            Thread.sleep(500);
            System.out.print("t");
            Thread.sleep(500);
            System.out.print("e");
            Thread.sleep(500);
            System.out.print("m");
            Thread.sleep(500);
            System.out.print("a");
            Thread.sleep(500);
            System.out.println("");
            Thread.sleep(500);
            System.out.print("E");
            Thread.sleep(500);
            System.out.print("n");
            Thread.sleep(500);
            System.out.print("c");
            Thread.sleep(500);
            System.out.print("e");
            Thread.sleep(500);
            System.out.print("r");
            Thread.sleep(500);
            System.out.print("r");
            Thread.sleep(500);
            System.out.print("a");
            Thread.sleep(500);
            System.out.print("d");
            Thread.sleep(500);
            System.out.print("o\n");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
