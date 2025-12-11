package gestao_cinema.application.dto.ingresso;

import gestao_cinema.domain.model.Cliente;
import gestao_cinema.domain.model.Filme;
import gestao_cinema.domain.model.Sessao;

public class EmitirIngressoDTO {
    private Cliente cliente;
    private Sessao sessao;
    private Filme filme;

    public EmitirIngressoDTO(Cliente cliente, Sessao sessao, Filme filme) {
        this.cliente = cliente;
        this.sessao = sessao;
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }
}
