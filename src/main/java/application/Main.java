package application;

import controller.Login;
import entity.Conteudos;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conteudos conteudos = new Conteudos();
        Login login = new Login();
        int escolha =0;

        while (escolha!=4){
            System.out.println("Menu incial: ");
            System.out.println("1. Login");
            System.out.println("2. Listar conteudos");
            System.out.println("4. Sair");
            escolha = scanner.nextInt();
            switch (escolha){
                case 1 : login.login(scanner.next(),scanner.next());
                    continue;
                case 2 :
                    System.out.println(conteudos.toString());
                    break;
                case 4 :
                    System.out.println("voce saiu");
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;

            }

        }

    }
}
