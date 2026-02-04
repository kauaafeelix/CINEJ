package gestao_cinema.infrastructure.persistence;

import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.repository.FilmeRepository;
import gestao_cinema.infrastructure.database.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmeRepositoryImpl implements FilmeRepository {

    @Override
    public Filme criarFilme(Filme filme)  throws SQLException {

        String sql = """
                INSERT INTO Filme (
                titulo,
                genero,
                duracao_minutos,
                lancamento
                ) VALUES (?,?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setInt(3, filme.getDuracaoMinutos());
            ps.setBoolean(4, filme.getLancamento());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                long idGerado = rs.getLong(1);
                filme.setId(idGerado);
            }
        }
        return filme;
    }

    @Override
    public List<Filme> buscarFilmePorGenero(String genero) throws SQLException {

        List<Filme>filmes = new ArrayList<>();

        String sql = """
                SELECT 
                id, 
                titulo, 
                genero, 
                duracao_minutos, 
                lancamento
                FROM Filme
                WHERE genero LIKE ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, "%" +genero+"%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Filme filme = new Filme(
                        rs.getLong("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getInt("duracao_minutos"),
                        rs.getBoolean("lancamento")
                );
                filmes.add(filme);
            }
        }
        return filmes;
    }

    @Override
    public List<Filme>listarFilmes() throws SQLException {

        List<Filme>filmes = new ArrayList<>();

        String sql = """
                SELECT 
                id, 
                titulo, 
                genero, 
                duracao_minutos, 
                lancamento
                FROM Filme
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                long id = rs.getLong("id");
                String titulo = rs.getString("titulo");
                String generoFilme = rs.getString("genero");
                int duracaoMinutos = rs.getInt("duracao_minutos");
                boolean lancamento = rs.getBoolean("lancamento");

                Filme filme = new Filme(id, titulo, generoFilme, duracaoMinutos, lancamento);
                filmes.add(filme);
            }
            return filmes;
        }
    }


    @Override
    public Filme deletarFilme(long id) throws SQLException {
        String sql = """
                DELETE FROM Filme
                WHERE id = ?
                """;
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }
        return null;
    }
}
