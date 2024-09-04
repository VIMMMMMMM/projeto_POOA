package service;

import entity.Usuario;

import java.util.Objects;

public class UsuarioService {
    public Usuario login(String usuario, String senha) {
        Usuario abc = new Usuario();
        abc.setPassword("2005");
        abc.setUsername("eduardo");
        try {
            if (!Objects.equals(abc.getUsername(), usuario) || !Objects.equals(abc.getPassword(), senha)) {
                System.out.println("usuario e/ou senha invalido");
               return null;
            } else {
                return abc;

            }
        } catch (RuntimeException e) {
            e.getMessage();
        }

        return abc;
    }
}
