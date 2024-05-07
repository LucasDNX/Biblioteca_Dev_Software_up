import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Biblioteca;

public class App {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Biblioteca UpBiblioteca = new Biblioteca();

        int opcao;

        do {
            System.out.println(); // Pulha linha
            System.out.println("----- Menu -----");
            System.out.println("1. Cadastro de livros");
            System.out.println("2. Pesquisa de livros");
            System.out.println("3. Cadastro de usuários");
            System.out.println("4. Empréstimo de livros");
            System.out.println("5. Devolução de livros");
            System.out.println("6. Relatório");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = in.nextInt();
                switch (opcao) {
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    case 1:
                        view.CadastroLivro.main(args, in, UpBiblioteca);
                        break;
                    case 2:
                        view.PesquisaLivros.main(args, in, UpBiblioteca);
                        break;
                    case 3:
                        view.CadastroUsuario.main(args, in, UpBiblioteca);
                        break;
                    case 4:
                        view.EmprestimoLivro.main(args, in, UpBiblioteca);
                        break;
                    case 5:
                        view.DevolucaoLivro.main(args, in, UpBiblioteca);
                        break;
                    case 6:
                        view.GerarRelatorio.main(args, UpBiblioteca);
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
            }

            catch (InputMismatchException e) {
                // Exceção para impedir a inserção de outros tipos de caracteres
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                in.nextLine();
                opcao = -1; // Reinicia a opcao
            }

        } while (opcao != 0);

        in.close();
    }
}