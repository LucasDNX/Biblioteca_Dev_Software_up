package Model;

public interface OperacoesBiblioteca {

    void adicionarLivro(Livro livro);

    void adicionarUsuario(Usuario usuario);

    Emprestimo emprestaLivro(Livro livro, Usuario usuario);

    void devolveLivro(int idLivro);
}
