package gestao_cinema.domain.model;

import gestao_cinema.domain.model.enums.StatusIngresso;
import gestao_cinema.domain.model.enums.TipoIngresso;

import java.time.LocalDate;
import java.util.Date;

public class Ingresso {
    private long id;
    private long idCliente;
    private long idSessao;
    private LocalDate dataCompra;
    private TipoIngresso tipoIngresso;
    private StatusIngresso statusIngresso;

    public Ingresso(long id, long idCliente, long idSessao, LocalDate dataCompra, TipoIngresso tipoIngresso, StatusIngresso statusIngresso) {
        this.id = id;
        this.idCliente = idCliente;
        this.idSessao = idSessao;
        this.dataCompra = dataCompra;
        this.tipoIngresso = tipoIngresso;
        this.statusIngresso = statusIngresso;
    }

    public Ingresso(long idCliente, long idSessao, LocalDate dataCompra, TipoIngresso tipoIngresso, StatusIngresso statusIngresso) {
        this.idCliente = idCliente;
        this.idSessao = idSessao;
        this.dataCompra = dataCompra;
        this.tipoIngresso = tipoIngresso;
        this.statusIngresso = statusIngresso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(long idSessao) {
        this.idSessao = idSessao;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public StatusIngresso getStatusIngresso() {
        return statusIngresso;
    }

    public void setStatusIngresso(StatusIngresso statusIngresso) {
        this.statusIngresso = statusIngresso;
    }
}
