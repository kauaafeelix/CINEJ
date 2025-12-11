package gestao_cinema.domain.model;

public class Filme  {

    private long id;
    private String titulo;
    private String genero;
    private int duracaoMinutos;
    private boolean lancamento;

    public Filme(long id, String titulo, String genero, int duracaoMinutos, boolean lancamento) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoMinutos = duracaoMinutos;
        this.lancamento = lancamento;
    }

    public Filme(String titulo, String genero, int duracaoMinutos, boolean lancamento) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoMinutos = duracaoMinutos;
        this.lancamento = lancamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public boolean getLancamento() {
        return lancamento;
    }

    public void setLancamento(boolean lancamento) {
        this.lancamento = lancamento;
    }
}
