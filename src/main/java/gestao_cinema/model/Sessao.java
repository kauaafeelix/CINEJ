package gestao_cinema.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Sessao {

    private long id;
    private long filmeId;
    private String sala;
    private int capacidadeMaxima;
    private LocalDateTime dataHora;
    private BigDecimal valorIngresso;

    public Sessao(long id, long filmeId, String sala, int capacidadeMaxima, LocalDateTime dataHora, BigDecimal valorIngresso) {
        this.id = id;
        this.filmeId = filmeId;
        this.sala = sala;
        this.capacidadeMaxima = capacidadeMaxima;
        this.dataHora = dataHora;
        this.valorIngresso = valorIngresso;
    }

    public Sessao(long filmeId, String sala, int capacidadeMaxima, LocalDateTime dataHora, BigDecimal valorIngresso) {
        this.filmeId = filmeId;
        this.sala = sala;
        this.capacidadeMaxima = capacidadeMaxima;
        this.dataHora = dataHora;
        this.valorIngresso = valorIngresso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFilmeId() {
        return filmeId;
    }

    public void setFilmeId(long filmeId) {
        this.filmeId = filmeId;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(BigDecimal valorIngresso) {
        this.valorIngresso = valorIngresso;
    }
}
