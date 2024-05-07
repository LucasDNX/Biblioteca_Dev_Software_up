package view;

import java.time.LocalDate;
import java.util.List;
import Model.Biblioteca;
import Model.Emprestimo;

public class GerarRelatorio {

    public static void main(String[] args, Biblioteca biblioteca) {
        try
        {
            System.out.println("\n----- Relatório de Empréstimos -----");
    
            // Obtém a lista de empréstimos da biblioteca
            List<Emprestimo> emprestimos = biblioteca.getEmprestimos();
    
            System.out.println("\n--------- EMPRESTIMO(s) ---------");
            // Verifica se existem empréstimos
            if (emprestimos.isEmpty()) {
                System.out.println("Nenhum livro foi emprestado.");
            } 
            else 
            {
                for (Emprestimo emprestimo : emprestimos) {
                    System.out.println(emprestimo.getId());
                    System.out.println(emprestimo.getDataEmprestimo());
                    System.out.println(emprestimo.getLivro().getTitulo());
                    System.out.println(emprestimo.getUsuario().getNome());
                    System.out.println(emprestimo.getDataDevolucaoPrevista());
                    System.out.println(emprestimo.getDataDevolucaoReal());
                }
            }

            // Verifica se existem atrasos
            System.out.println("\n--------- ATRASO(s) ---------");
            for (Emprestimo emprestimo : emprestimos) {

                if (emprestimo.getLivro().getDataDevolucaoPrevista().isBefore(LocalDate.now()) 
                    && emprestimo.getLivro().isEmprestado() == true) {
                    System.out.println(emprestimo.getUsuario());
                    System.out.println(emprestimo.getLivro());
                    System.out.println(emprestimo.getDataEmprestimo());
                    System.out.println(emprestimo.getDataDevolucaoPrevista());
                }

            }
    
        }
        catch(Exception e)
        {
            System.out.println("Não foi possível executar o Cadastro de Livro, por favor tente novamente");
        }
        
    }
}
