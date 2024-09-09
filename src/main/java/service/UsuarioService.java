package service;


import entity.Usuario;
import repository.PersistenciaUsuario;

import java.util.List;


public class UsuarioService {
    PersistenciaUsuario<Usuario> usuarioRepository;
    public Usuario login(String usuario, String senha) {
        Usuario abc = new Usuario();
        abc.setPassword("admin");
        abc.setUsername("admin");
        try {
            if (abc.getUsername().equals(usuario) && abc.getPassword().equals(senha)) {
                return abc;
            } else {
                System.out.println("usuario e/ou senha invalido");
            }
        } catch (RuntimeException e) {
            e.getMessage();
        }
        return null;
    }

    public UsuarioService(PersistenciaUsuario<Usuario> persistencia) {
        this.usuarioRepository = persistencia;
    }
    public void save(Usuario entidade) {
        usuarioRepository.save(entidade);
    }


    public void atualizar( String newUsername, String newPassword, String id) {
        usuarioRepository.atualizar(new Usuario(newUsername,newPassword,id));
    }

    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }

    public boolean remover(String username) {
        return usuarioRepository.remover(username);
    }
    public void alterarSenha(String username,String newPassword){
        usuarioRepository.alterarSenha(new Usuario(username,newPassword));
    }

}
