package view;

import java.time.LocalDate;
import java.util.List;
import Model.Biblioteca;
import Model.Emprestimo;

public class GerarRelatorio {

    public static void main(String[] args, Biblioteca biblioteca) {
        try {
            System.out.println("\n----- Relatório de Empréstimos -----");

            // Obtém a lista de empréstimos da biblioteca
            List<Emprestimo> emprestimos = biblioteca.getEmprestimos();

            System.out.println("\n--------- EMPRESTIMO(s) ---------");
            // Verifica se existem empréstimos
            if (emprestimos.isEmpty()) {
                System.out.println("Nenhum livro foi emprestado.");
            } else {
                for (Emprestimo emprestimo : emprestimos) {
                    System.out.println("Id Emprestimo: " + emprestimo.getId());
                    System.out.println("Data do emprestimo: " + emprestimo.getDataEmprestimo());
                    System.out.println("Livro: " + emprestimo.getLivro().getTitulo());
                    System.out.println("Usuario: " + emprestimo.getUsuario().getNome());
                    System.out.println("Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
                    System.out.println("Devolução real: " + emprestimo.getDataDevolucaoReal());
                }
            }

            // Verifica usuarios com livros emprestados
            System.out.println("\n--------- USUARIOS COM EMPRESTIMO ATIVO ---------");
            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getDataDevolucaoReal() == null) {
                    System.out.println("Id Emprestimo: " + emprestimo.getId());
                    System.out.println("Id Emprestimo: " + emprestimo.getDataCadastro());
                    System.out.println("Id Emprestimo: " + emprestimo.getUsuario());
                    System.out.println("Id Emprestimo: " + emprestimo.getLivro());
                    System.out.println("Id Emprestimo: " + emprestimo.getDataEmprestimo());
                    System.out.println("Id Emprestimo: " + emprestimo.getDataDevolucaoPrevista());
                }
            }

            // Verifica se existem atrasos
            System.out.println("\n--------- ATRASO(s) ---------");
            for (Emprestimo emprestimo : emprestimos) {

                if (emprestimo.getLivro().getDataDevolucaoPrevista().isBefore(LocalDate.now())
                        && emprestimo.getLivro().isEmprestado() == true) {
                    System.out.println("Id Emprestimo: " + emprestimo.getId());
                    System.out.println("Id Emprestimo: " + emprestimo.getUsuario());
                    System.out.println("Id Emprestimo: " + emprestimo.getLivro());
                    System.out.println("Id Emprestimo: " + emprestimo.getDataEmprestimo());
                    System.out.println("Id Emprestimo: " + emprestimo.getDataDevolucaoPrevista());
                }

            }

        } catch (Exception e) {
            System.out.println("Não foi possível executar a Geração de Relatório, por favor tente novamente");
        }

    }
}
