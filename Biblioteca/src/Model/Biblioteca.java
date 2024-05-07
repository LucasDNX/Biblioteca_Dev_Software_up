package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Biblioteca implements OperacoesBiblioteca {

    // ATRIBUTOS
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    // CONSTRUTOR
    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    // GETTERS E SETTERS
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    // MÉTODOS
    @Override
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Livro> pesquisarLivros(int filtro, String pesquisaLivro) {
        List<Livro> livrosEncontrados = new ArrayList<>();

        for (Livro livro : livros) {
            switch (filtro) {
                case 1:
                    if (String.valueOf(livro.getId()).equalsIgnoreCase(pesquisaLivro)) {
                        livrosEncontrados.add(livro);
                    }
                    break;
                case 2:
                    if (livro.getTitulo().toUpperCase().equalsIgnoreCase(pesquisaLivro.toUpperCase())) {
                        livrosEncontrados.add(livro);
                    }
                    break;
                case 3:
                    if (livro.getAutor().toUpperCase().equalsIgnoreCase(pesquisaLivro.toUpperCase())) {
                        livrosEncontrados.add(livro);
                    }
                    break;
                case 4:
                    if (String.valueOf(livro.getAnoPublicacao()).equalsIgnoreCase(pesquisaLivro)) {
                        livrosEncontrados.add(livro);
                    }
                    break;

                default:
                    System.out.println("Tipo de pesquisa inválido.");
                    break;
            }
        }

        return livrosEncontrados;
    }

    @Override
    public Emprestimo emprestaLivro(Livro livro, Usuario usuario) {
        if (!livro.isEmprestado() && livro.getExemplaresDisponiveis() > 0) {
            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucaoPrevista = dataEmprestimo.plusDays(7);

            Emprestimo emprestimo = new Emprestimo(Util.gerarIdEmprestimo(), livro, usuario, dataEmprestimo,
                    dataDevolucaoPrevista);
            emprestimos.add(emprestimo);

            // setar
            livro.setEmprestado(true);
            livro.setDataEmprestimo(dataEmprestimo);
            livro.setDataDevolucaoPrevista(dataDevolucaoPrevista);
            livro.decrementaExemplaresDisponiveis();

            usuario.adicionarLivroEmprestado(livro);

            return emprestimo;
        } else {
            return null;
        }
    }

    public Livro buscarLivro(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro; // Retorna o livro encontrado
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo() == titulo) {
                return livro; // Retorna o livro encontrado
            }
        }
        return null; // Retorna null se o livro não for encontrado
    }

    public Usuario buscarUsuarioPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void devolveLivro(int idEmprestimo) {

        // Busca o empréstimo pelo ID
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.buscaEmprestimoPorId(idEmprestimo)) {

                // Atualiza a data de devolução real para a data atual
                emprestimo.setDataDevolucaoReal(LocalDate.now());
                return;

            }
        }
    }

    public Emprestimo buscaEmprestimoPorId(int id) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getId() == id) {
                return emprestimo;
            }
        }
        return null; // Retorna null se nenhum empréstimo for encontrado com o ID fornecido
    }

    @Override
    public String toString() {
        return "Biblioteca [livros=" + livros + ", usuarios=" + usuarios + ", emprestimos=" + emprestimos + "]";
    }

}
