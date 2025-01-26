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
        this.verificarNome(nome);
        this.verificarSenha(senha);
    }

    private void verificarNome(String nome) {
        if (nome.isEmpty()) throw new IllegalArgumentException("Erro: Nome inválido, nome não pode estar vazio.");
    }

    private void verificarSenha(String senha) {
        if (senha.isEmpty()) throw new IllegalArgumentException("Erro: Senha inválida, senha não pode ser um campo vazio.");
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
