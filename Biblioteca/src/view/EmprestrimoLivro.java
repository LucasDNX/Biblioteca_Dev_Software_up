package view;

import java.util.Scanner;
import Model.Biblioteca;
import Model.Emprestimo;
import Model.Livro;
import Model.Usuario;

public class EmprestrimoLivro {
    public static void main(String[] args, Scanner in, Biblioteca biblioteca) {
        try 
        {
            System.out.println("\n----- Empréstimo de Livro -----");
    
            // Solicitar o ID do livro
            System.out.print("Digite o ID do livro: ");
            int idLivro = in.nextInt();
    
            Livro livro = biblioteca.buscarLivro(idLivro);
    
            if (livro == null) {
                System.out.println("Livro não encontrado.");
                return; 
            }
    
            // Solicitar o nome do usuário
            in.nextLine();
            System.out.print("Digite o nome do usuário: ");
            String nomeUsuario = in.nextLine();
    
            // Buscar o usuário na biblioteca
            Usuario usuario = biblioteca.buscarUsuarioPorNome(nomeUsuario);
    
            if (usuario == null) {
                System.out.println("Usuário não encontrado.");
                return; 
            }
    
            // Realizar o empréstimo
            Emprestimo emprestimo = biblioteca.emprestaLivro(livro, usuario);
    
            if (emprestimo != null) 
            {
                livro.decrementaExemplaresDisponiveis();
    
                System.out.println("Livro emprestado com sucesso!");
                System.out.println("Id do emprestimo: " + emprestimo.getId() + 
                    "\nData de devolução prevista: " + emprestimo.getDataDevolucaoPrevista());
            } 
            else 
            {
                System.out.println("O livro não está disponível para empréstimo no momento.");
            }

        }
        catch(Exception e)
        {
            System.out.println("Não foi possível executar o Empréstimo de Livro, por favor tente novamente");
        }
    }
}
