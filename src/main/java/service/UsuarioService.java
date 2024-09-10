package service;


import entity.Usuario;
import repository.PersistenciaUsuario;

import java.util.List;


public class UsuarioService {
    PersistenciaUsuario<Usuario> usuarioRepository;
    public Usuario login(String usuario, String senha) {
        try {
            if (listar().isEmpty()){
                Usuario usuario1 =new Usuario(usuario,senha);
                save(usuario1);
                System.out.println("usuario criado");
                return usuario1;
            }else {
                for (Usuario usuario1 : listar()) {
                    if (usuario1.getUsername().equals(usuario) || usuario1.getPassword().equals(senha)) {
                        System.out.println("seja bem vindo");
                        return usuario1;
                    }
                }
                    }

            }
        catch (RuntimeException e) {
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
