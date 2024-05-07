package view;

import java.util.List;
import java.util.Scanner;
import Model.Biblioteca;
import Model.Livro;

public class PesquisaLivros {

    public static void main(String[] args, Scanner in, Biblioteca biblioteca) {
        try
        {

                System.out.println("\n----- Pesquisa de Livros -----");
        
                // Solicitar o filtro de pesquisa ao usuário
                System.out.print("Informe o filtro da pesquisa \n(1- Id / 2- Titulo / 3- Autor / 4- Ano / 0- Todos): \n");
                int filtro = in.nextInt();
        
                in.nextLine();
        
                if (filtro == 0 && !biblioteca.getLivros().isEmpty()) 
                {
                    List<Livro> livrosEncontrados = biblioteca.getLivros();
                    
                    System.out.println("Livros encontrados:");
        
                    for (Livro livro : livrosEncontrados) {
        
                        //Verifica se o livro esta disponivel
                        if (livro.isEmprestado() == false) {
                            System.out.println(livro);
                        }
        
                    }
        
                }
                else 
                {
                    // Solicitar a busca ao usuário
                    System.out.print("Digite a sua pesquisa: ");
                    String pesquisa = in.nextLine();
            
                    List<Livro> livrosEncontrados = biblioteca.pesquisarLivros(filtro, pesquisa);
            
                    if (livrosEncontrados.isEmpty()) {
                        System.out.println("Nenhum livro encontrado com o termo de pesquisa informado.");
                    } else {
                        System.out.println("Livros encontrados:");
        
                        for (Livro livro : livrosEncontrados) {
                            //Verifica se o livro esta disponivel
                            if (livro.isEmprestado() == false) {
                                System.out.println(livro);
                            }
                        }
                    }
        
                }
    
        }catch(Exception e)
        {
        System.out.println("Não foi possível executar o Cadastro de Livro, por favor tente novamente");
        }
    }
}
