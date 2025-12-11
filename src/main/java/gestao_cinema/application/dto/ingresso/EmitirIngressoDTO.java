package gestao_cinema.application.dto.ingresso;

import gestao_cinema.domain.model.Cliente;
import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.model.Sessao;
import gestao_cinema.domain.model.enums.StatusIngresso;
import gestao_cinema.domain.model.enums.TipoIngresso;

import java.util.Date;

public class EmitirIngressoDTO {
    private long id;
    private String clienteNome;
    private String salaSessao;
    private String filmeTitulo;
    private Date dataCompra;
    private TipoIngresso tipoIngresso;
    private StatusIngresso status;

    public EmitirIngressoDTO(Long id, String clienteNome, String salaSessao, String filmeTitulo, Date dataCompra, TipoIngresso tipoIngresso, StatusIngresso status) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.salaSessao = salaSessao;
        this.filmeTitulo = filmeTitulo;
        this.dataCompra = dataCompra;
        this.tipoIngresso = tipoIngresso;
        this.status = status;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getSalaSessao() {
        return salaSessao;
    }

    public void setSalaSessao(String salaSessao) {
        this.salaSessao = salaSessao;
    }

    public String getFilmeTitulo() {
        return filmeTitulo;
    }

    public void setFilmeTitulo(String filmeTitulo) {
        this.filmeTitulo = filmeTitulo;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public StatusIngresso getStatus() {
        return status;
    }

    public void setStatus(StatusIngresso status) {
        this.status = status;
    }
}


