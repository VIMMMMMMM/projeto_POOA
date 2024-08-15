package controller;

import entity.Conteudos;

import java.util.Objects;
import java.util.Scanner;

public class Login {
    private String usuario;
    private String senha;

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

    public boolean login(String usuario, String senha) {
        setUsuario("eduardo");
        setSenha("2005");
        try {

            if (!Objects.equals(this.usuario, usuario) || !Objects.equals(this.senha, senha)) {
                System.out.println("usuario e/ou senha invalido");
                return false;
            } else {
                return true;

            }
        } catch (RuntimeException e) {
            e.getMessage();
            return false;
        }

    }
}
