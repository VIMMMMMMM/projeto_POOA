package application;


import entity.Usuario;
import tui.Base;

public class Main {
    public static void main(String[] args) {
        Usuario login=null;
        Base base = new Base();

        while (true){
            if (login==null){
               login= base.menuInicial();
            }else {
                login=base.menuPos(login);
            }
        }

        }

    }

