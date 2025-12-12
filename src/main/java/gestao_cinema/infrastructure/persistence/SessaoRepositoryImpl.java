package gestao_cinema.infrastructure.persistence;

import gestao_cinema.domain.model.Ingresso;
import gestao_cinema.domain.model.Sessao;
import gestao_cinema.domain.model.enums.StatusIngresso;
import gestao_cinema.domain.repository.IngressoRepository;
import gestao_cinema.domain.repository.SessaoRepository;
import gestao_cinema.infrastructure.database.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SessaoRepositoryImpl implements SessaoRepository {

    @Override
    public Sessao criarSessao(Sessao sessao) throws SQLException {

        String sql = """
                INSERT INTO Sessao
                (filme_id,
                sala,
                capacidade_maxima,
                data_hora,
                valor_ingresso )
                VALUES (?,?,?,?,?)
                """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setLong(1, sessao.getFilmeId());
            ps.setString(2, sessao.getSala());
            ps.setInt(3, sessao.getCapacidadeMaxima());
            ps.setTimestamp(4, Timestamp.valueOf(sessao.getDataHora()));
            ps.setBigDecimal(5, sessao.getValorIngresso());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                long idGerado = rs.getLong(1);
                sessao.setId(idGerado);
            }
        }
        return sessao;
    }

    @Override
    public List<Sessao> procurarSessoesPorFilme(String nomeFilme) throws SQLException {

        List<Sessao>sessoes = new ArrayList<>();

        String sql = """
                SELECT 
                s.id
                f.nome as nome_filme
                s.sala,
                s.capacidade_maxima
                s.data_hora
                s.valor_ingresso
                FROM Sessao s
                JOIN Filme f
                ON f.id = s.filme_id
                WHERE nome_filme = ?
                """;

        try (Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql)){

            ps.setString(1, nomeFilme);

            ResultSet rs = ps.executeQuery();

        }

        return sessoes;
    }
}
