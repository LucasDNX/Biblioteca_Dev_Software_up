package view;

import java.util.Scanner;
import Model.Biblioteca;
import Model.Livro;
import util.Util;

public class CadastroLivro {
    public static void main(String[] args, Scanner in, Biblioteca biblioteca) {

        try
        {
            // TESTE SE ESTA FUNCIONANDO KKKK
            /* 
             System.out.println("Digite alguma coisa");
             System.out.println("Você digitou: " + in.nextLine());
             System.out.println("\nRetornando para o Main\n");
             */
    
             System.out.println("\n----- Cadastro de Livro -----");
             System.out.println("Por favor, insira as informações a seguir:");
             in.nextLine();
    
            // Obtem os atributos autor, anoPublicacao, exemplaresDisponiveis;
             System.out.print("Título: ");
             String titulo = in.nextLine();
    
             System.out.print("Autor: ");
             String autor = in.nextLine();
    
             System.out.print("Ano de publicação: ");
             int anoPublicacao = Integer.parseInt(in.nextLine());
    
             System.out.print("Número de exemplares disponíveis: ");
             int exemplaresDisponiveis = Integer.parseInt(in.nextLine());
    
            // Criar um novo objeto Livro com as informações fornecidas
            Livro novoLivro = new Livro(Util.gerarIdLivro(), titulo, autor, anoPublicacao, exemplaresDisponiveis);
    
            biblioteca.adicionarLivro(novoLivro);
    
            System.out.println("Livro cadastrado com sucesso! \nId do livro:" + novoLivro.getId());
        }
        catch(Exception e)
        {
            System.out.println("Não foi possível executar o Cadastro de Livro, por favor tente novamente");
        }
    }
}

