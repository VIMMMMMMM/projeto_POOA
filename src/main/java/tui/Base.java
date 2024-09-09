package tui;

import dao.ConteudoHSQL;
import dao.UsuarioHSQL;
import entity.Conteudo;
import entity.Usuario;
import service.ConteudoService;
import service.UsuarioService;

import java.util.Scanner;

import static java.lang.System.exit;

public class Base {
    static Scanner scanner = new Scanner(System.in);
    static ConteudoService conteudoService = new ConteudoService(new ConteudoHSQL());
    static UsuarioService usuarioService = new UsuarioService(new UsuarioHSQL());

    public Usuario menuInicial() {
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
                   Usuario usuario = usuarioService.login(scanner.next(),scanner.next());
                   if (usuario!= null){
                       return usuario;
                   }

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
        return null;
    }

    public Usuario menuPos(Usuario usuario) {
        int escolha = 0;
        try {
                while (escolha != 10) {
                    System.out.println("Menu incial: ");
                    System.out.println("1. Criar conteudo");
                    System.out.println("2. Listar conteudo");
                    System.out.println("3. Atualizar conteudo");
                    System.out.println("4. Excluir conteudo");
                    System.out.println("5. Criar usuario");
                    System.out.println("6. Listar usuario ");
                    System.out.println("7. Atualizar usuario");
                    System.out.println("8. Excluir usuaio ");
                    System.out.println("9. alterar senha ");
                    System.out.println("10. Logout");
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
                                if (!conteudoService.listar().isEmpty()){
                                    String ids = lerInfo("Digite o ID do conteudo para atualizar");
                                    String titulo = lerInfo("Digite o Titulo");
                                    String texto = lerInfo("Digite o Texto");
                                    int id = Integer.parseInt(ids);
                                    conteudoService.atualizar(id, titulo, texto, usuario);
                                    System.out.println("Conteudo Atualizado.");
                                }else {
                                    System.out.println("conteudo nao encontrado");
                                }
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
                            String username = lerInfo("Digite o Username");
                            String password = lerInfo("Digite a Password");
                            Usuario usuario1 = new Usuario(username,password);
                            usuarioService.save(usuario1);
                            System.out.println("Usuario criado!");
                        }
                        case 6 -> {
                            for (Usuario usuario1 : usuarioService.listar()) {
                                System.out.println(usuario1);
                            }
                        }
                        case 7 -> {
                            if (!usuarioService.listar().isEmpty()){
                                String username = lerInfo("Digite o Username do usuario para atualizar");
                                String newUsername = lerInfo("Digite o novo Username");
                                String newPassword = lerInfo("Digite a nova Password");
                                usuarioService.atualizar(newUsername,newPassword,username);
                                System.out.println("usuario Atualizado.");
                            }else {
                                System.out.println("usuario nao encontrado");
                            }

                        }
                        case 8 -> {
                            System.out.println("digite o username do usuario que quer remover");
                            String username = scanner.next();
                            boolean removido = usuarioService.remover(username);
                            if (removido) {
                                System.out.println("Usuario excluido.");
                            } else {
                                System.out.println("Usuario não encontrado.");
                            }
                        }
                        case 9 -> {
                            if (!usuarioService.listar().isEmpty()){
                                String username = lerInfo("Digite o Username do usuario para alterar senha");
                                String newPassword = lerInfo("Digite a nova password");
                                usuarioService.alterarSenha(username,newPassword);
                                System.out.println("senha Alterada.");
                            }else {
                                System.out.println("usuario nao encontrado");
                            }

                        }
                        case 10 -> {
                            usuario = null;
                            System.out.println("voce deslogou");
                        }
                        default -> System.out.println("opcao invalida");
                    }
                }

        } catch (RuntimeException e) {
            e.getMessage();
        }
        return usuario;
    }

    private String lerInfo(String label) {
        System.out.println(label + ": ");
        return scanner.next();
    }



}
