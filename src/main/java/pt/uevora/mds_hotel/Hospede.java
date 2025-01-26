package pt.uevora.mds_hotel;

public class Hospede {
    private static int genId = 0;
    private int id;
    private String nome, email, senha;

    public Hospede(String nome, String email, String senha) {
        this.id = ++genId;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getId() {
        return id;
    }
}
