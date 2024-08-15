package controller;

import entity.Conteudos;

import java.util.HashMap;
import java.util.Scanner;

public class Base {
   static Scanner scanner = new Scanner(System.in);
   static Conteudos conteudos = new Conteudos();
   static HashMap<Integer,String>listaConteudos = new HashMap<>();
   static Login login = new Login();
    public void menuInicial(){

        int escolha =0;

        while (escolha!=4){
            System.out.println("Menu incial: ");
            System.out.println("1. Login");
            System.out.println("2. Listar conteudos");
            System.out.println("4. Sair");
            escolha = scanner.nextInt();
            switch (escolha){
                case 1 : menuPos();
                continue;
                case 2 :
                    System.out.println(listaConteudos.toString());
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

    private void menuPos(){
        int escolha=0, idTemp;
        String alteracao;

        try{
            System.out.println("digite seu usuario e senha");
            if (login.login(scanner.next(), scanner.next())){
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
                            alteracao=scanner.next();
                            conteudos.setDetalhes(alteracao);
                            criador(conteudos.getId(),conteudos.getDetalhes());

                        }
                        case 2 ->{
                                System.out.println(listaConteudos.toString());
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
            }



        }catch (RuntimeException e){
            e.getMessage();
        }


    }
    private HashMap<Integer,String> criador(int id, String detalhes){
        try {
            listaConteudos.put(id,detalhes);
            return listaConteudos;
        }catch (RuntimeException e){
            e.getMessage();
            return null;
        }

    }
    private void alterador(int idTemp, String alteracao){
        try {
           if (listaConteudos.containsKey(idTemp))
               listaConteudos.replace(idTemp,alteracao);
           else {
               System.out.println("conteudo nao existe");
           }
        }catch (RuntimeException e){
            e.getMessage();
        }

    }
    private void removedor(int idTemp){
        try{
            if (listaConteudos.containsKey(idTemp))
                listaConteudos.remove(idTemp);
            else {
                System.out.println("conteudo nao exite");
            }
        }catch (RuntimeException e){
            e.getMessage();
        }
    }
}
