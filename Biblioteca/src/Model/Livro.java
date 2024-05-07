package Model;

import java.time.LocalDate;

public class Livro extends NovoRegistro{
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int exemplaresDisponiveis;
    private boolean emprestado;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Livro(int id, String titulo, String autor, int anoPublicacao, int exemplaresDisponiveis) {
        super(id);
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.emprestado = false;
        this.dataEmprestimo = null;
        this.dataDevolucaoPrevista = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public void decrementaExemplaresDisponiveis() {
        this.exemplaresDisponiveis--;
    }
    
    public void incrementarExemplaresDisponiveis() {
        this.exemplaresDisponiveis++;
    }
    
    @Override
    public String toString() {
        return "Livro [Id=" + getId() +  ", titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao
                + ", exemplaresDisponiveis=" + exemplaresDisponiveis + "]";
    }
    
}
