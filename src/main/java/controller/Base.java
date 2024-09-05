package controller;

import dao.ConteudoHSQL;
import entity.Conteudo;
import entity.Usuario;
import service.ConteudoService;
import service.UsuarioService;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

public class Base {
    static Scanner scanner = new Scanner(System.in);
    static ConteudoService conteudoService = new ConteudoService(new ConteudoHSQL());
    static UsuarioService usuarioService = new UsuarioService();

    public void menuInicial() {
        int escolha = 0;
        while (escolha != 4) {
            System.out.println("Menu incial: ");
            System.out.println("1. Login");
            System.out.println("2. Listar conteudos");
            System.out.println("3. Sair");
            escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("digite seu usuario e senha");
                    menuPos(usuarioService.login(scanner.next(),scanner.next()));
                    continue;
                case 2:
                    for (Conteudo conteudo : conteudoService.listar()) {
                        System.out.println(conteudo);
                    }
                    break;
                case 3:
                    System.out.println("voce saiu");
                    exit(0);
                    break;
                default:
                    System.out.println("opcao invalida");
                    break;
            }
        }
    }

    private void menuPos(Usuario usuario) {
        int escolha = 0,idTemp=0;
        try {
            if (usuario != null){
                while (escolha != 5) {
                    System.out.println("Menu incial: ");
                    System.out.println("1. Criar conteudo");
                    System.out.println("2. Listar conteudo");
                    System.out.println("3. Atualizar conteudo");
                    System.out.println("4. Excluir conteudo");
                    System.out.println("5. Logout");
                    escolha = scanner.nextInt();

                    switch (escolha) {
                        case 1 -> {
                            String titulo = lerInfo("Digite o Titulo");
                            String texto = lerInfo("Digite o Texto");
                            Conteudo conteudo = new Conteudo(null, titulo, texto, usuario);
                            conteudoService.save(conteudo);
                            System.out.println("Conteudo criado!");
                        }
                        case 2 -> {
                            for (Conteudo conteudo : conteudoService.listar()) {
                                System.out.println(conteudo);
                            }
                        }
                        case 3 -> {

                                String ids = lerInfo("Digite o ID do conteudo para atualizar");
                                String titulo = lerInfo("Digite o Titulo");
                                String texto = lerInfo("Digite o Texto");
                                int id = Integer.parseInt(ids);
                                conteudoService.atualizar(id, titulo, texto, usuario);
                                System.out.println("Conteudo Atualizado.");

                        }
                        case 4 -> {
                            System.out.println("digite o id do conteudo que quer remover");
                            int id = scanner.nextInt();
                            boolean removido = conteudoService.remover(id);
                            if (removido) {
                                System.out.println("Conteudo excluido.");
                            } else {
                                System.out.println("Conteudo não encontrado.");
                            }
                        }
                        case 5 -> {
                            usuario = null;
                        }
                        default -> {
                            System.out.println("opcao invalida");
                        }
                    }
                }
            }

        } catch (RuntimeException e) {
            e.getMessage();
        }
    }

    private String lerInfo(String label) {
        System.out.println(label + ": ");
        return scanner.next();
    }



}
