package Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends NovoRegistro {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private List<Livro> livrosEmprestados;

    public Usuario(int id, String nome, String telefone, String endereco, String email) {
        super(id);
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.livrosEmprestados = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    public void setLivrosEmprestados(List<Livro> livrosEmprestados) {
        this.livrosEmprestados = livrosEmprestados;
    }

    public void adicionarLivroEmprestado(Livro livro) {
        livrosEmprestados.add(livro);
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email
                + ", livrosEmprestados=" + livrosEmprestados + "]";
    }

}
