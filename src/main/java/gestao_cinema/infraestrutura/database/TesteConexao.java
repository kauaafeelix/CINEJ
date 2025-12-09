package gestao_cinema.infraestrutura.database;

import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        try{
            Conexao.conectar();
            System.out.println("Conexão feita com sucesso!");
        } catch (SQLException e) {
            System.err.println("Falha na conexão: " + e.getMessage());
        }
    }
}
