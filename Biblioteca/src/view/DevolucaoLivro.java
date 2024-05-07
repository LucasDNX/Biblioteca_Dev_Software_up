package view;

import java.util.Scanner;
import Model.Biblioteca;
import Model.Emprestimo;
import Model.Livro;

public class DevolucaoLivro {
    public static void main(String[] args, Scanner in, Biblioteca biblioteca) {

        try
        {   
           System.out.println("\n----- Devolução de Livro -----");
            
            // Solicitar o ID do empréstimo
            System.out.print("Digite o ID do empréstimo: ");
            int idEmprestimo = in.nextInt();
            
            // Realizar a devolução
            biblioteca.devolveLivro(idEmprestimo);
            
            Emprestimo emprestimo = biblioteca.buscaEmprestimoPorId(idEmprestimo);
            Livro livro = biblioteca.buscarLivro(emprestimo.getLivro().getId());
            
            livro.incrementarExemplaresDisponiveis();
            System.out.println("Livro devolvido com sucesso!");
        }
        catch(Exception e)
        {
            System.out.println("Não foi possível executar a Devolução de Livro, por favor tente novamente");
        }
    }
}
