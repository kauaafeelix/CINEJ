package gestao_cinema.view.cliente;

import gestao_cinema.domain.model.Cliente;

import java.util.Scanner;

public class ClienteView {

    Scanner scNum = new Scanner (System.in);
    Scanner scStr = new Scanner(System.in);


    public int menuCliente (){
        System.out.println("""
                ========= CLIENTE ==========
                1 - Cadastrar Cliente
                2 - Listar Clientes
                3 - Atualizar um Cliente
                4 - Deletar um Cliente
                0 - Voltar ao Menu Principal
                
                """);

        int opcao = capturarOpcao();

        return opcao;
    }

    public int capturarOpcao(){
        System.out.println("Digite sua Opção: ");
        return scNum.nextInt();
    }

    public Cliente cadastrarCliente(){
        System.out.println("""
                ==== CADASTRO DE CLIENTE ====
                """);
        System.out.println("Digite o Nome do Cliente: ");
        String nome = scStr.nextLine();

        System.out.println("Digite o Email do Cliente: ");
        String email = scStr.nextLine();

        System.out.println("Digite o Saldo da Carteira do Cliente: ");
        double saldo = scNum.nextDouble();

        Cliente novoCliente = new Cliente(nome, email, saldo);

        return novoCliente;

    }
}
