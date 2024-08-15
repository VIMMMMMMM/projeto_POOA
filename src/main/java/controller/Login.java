package controller;

import entity.Conteudos;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String usuario;
    private String senha;
    Conteudos conteudos = new Conteudos();
    public void login(String usuario, String senha){
       setUsuario("eduardo");
       setSenha("2005");
       try {

           if (!Objects.equals(this.usuario, usuario) || !Objects.equals(this.senha, senha)){
               System.out.println("usuario e/ou senha invalido");
           } else {
               menuPos();
           }
       }catch (RuntimeException e){
           e.getMessage();
       }

    }
    private void menuPos(){
        Scanner scanner = new Scanner(System.in);

        int escolha=0, idTemp;
        String alteracao;

        try{
            while (escolha!= 5){
                System.out.println("Menu incial: ");
                System.out.println("1. Criar conteudo");
                System.out.println("2. Listar conteudo");
                System.out.println("3. Atualizar conteudo");
                System.out.println("4. Excluir conteudo");
                System.out.println("5. Logout");
                escolha = scanner.nextInt();
                switch (escolha){
                    case 1 -> {
                        System.out.println("digite o id do conteudo");
                        conteudos.setId(scanner.nextInt());
                        System.out.println("digite a descricao do conteudo");
                        alteracao = scanner.next();
                        conteudos.setDetalhes(alteracao);

                    }
                    case 2 ->{
                        for (int i = 0; i < conteudos.getId(); i++) {
                            System.out.println(conteudos.toString());
                        }

                    }

                    case 3 ->{
                        System.out.println("digite o id do conteudo que quer mudar");
                        idTemp = scanner.nextInt();
                        System.out.println("digite a alteracao");
                        alteracao = scanner.next();
                        alterador(idTemp,alteracao);

                    }
                    case 4 ->{
                        System.out.println("digite o id do conteudo que quer remover");
                        idTemp = scanner.nextInt();
                        removedor(idTemp);
                    }
                    case 5 -> {
                        System.out.println("voce deslogou");
                    }
                    default-> {
                        System.out.println("opcao invalida");
                    }
                }
            }


        }catch (RuntimeException e){
            e.getMessage();
        }

    }
    private void alterador(int idTemp, String alteracao){
        try {
            for (int i = 0; i <= conteudos.getId(); i++) {
                if (conteudos.getId() == idTemp)  {
                    conteudos.setDetalhes(alteracao);
                }else {
                    System.out.println("id invalido");
                }

            }
        }catch (RuntimeException e){
            e.getMessage();
        }

    }
    private void removedor(int idTemp){
        try{
            for (int i = 0; i <= conteudos.getId(); i++) {
                if (conteudos.getId()==idTemp) {
                    conteudos =null;
                }
            }
        }catch (RuntimeException e){
            e.getMessage();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
