package gestao_cinema.model;

public class Cliente {

    private long id;
    private String nome;
    private String email;
    private double saldoCarteira;

    public Cliente(long id, String nome, String email, double saldoCarteira) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.saldoCarteira = saldoCarteira;
    }

    public Cliente(String nome, String email, double saldoCarteira) {
        this.nome = nome;
        this.email = email;
        this.saldoCarteira = saldoCarteira;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldoCarteira() {
        return saldoCarteira;
    }

    public void setSaldoCarteira(double saldoCarteira) {
        this.saldoCarteira = saldoCarteira;
    }
}
