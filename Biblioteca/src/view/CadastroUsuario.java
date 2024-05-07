package view;

import java.util.Scanner;
import Model.Biblioteca;
import Model.Usuario;
import util.Util;

public class CadastroUsuario {
    public static void main(String[] args, Scanner in, Biblioteca biblioteca) {

        try {
            System.out.println("\n----- Cadastro de Usuário -----");
            System.out.println("Por favor, insira as informações a seguir:");
            in.nextLine();

            // Solicitar informações do usuário
            System.out.print("Nome: ");
            String nome = in.nextLine();

            System.out.print("Telefone: ");
            String telefone = in.nextLine();

            System.out.print("Endereço: ");
            String endereco = in.nextLine();

            System.out.print("E-mail: ");
            String email = in.nextLine();

            // Criar um novo objeto Usuario com as informações fornecidas
            Usuario novoUsuario = new Usuario(Util.gerarIdUsuario(), nome, telefone, endereco, email);

            // Adicionar o usuário à lista de usuários da biblioteca
            biblioteca.adicionarUsuario(novoUsuario);

            System.out.println("Usuário cadastrado com sucesso! \nId do usuario:" + novoUsuario.getId());
        } catch (Exception e) {
            System.out.println(
                    "Não foi possível executar o Cadastro de Usuário. \nPor favor verifique os dados inseridos e tente novamente!");
        }

    }
}
