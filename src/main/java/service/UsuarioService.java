package service;

import entity.Conteudo;
import entity.Usuario;
import repository.PersistenciaConteudo;
import repository.PersistenciaUsuario;

import java.util.List;
import java.util.Objects;

public class UsuarioService {
    PersistenciaUsuario<Usuario> usuarioRepository;
    public Usuario login(String usuario, String senha) {
        Usuario abc = new Usuario();
        abc.setPassword("admin");
        abc.setUsername("admin");
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

    public UsuarioService(PersistenciaUsuario<Usuario> persistencia) {
        this.usuarioRepository = persistencia;
    }
    public void save(Usuario entidade) {
        usuarioRepository.save(entidade);
    }


    public void atualizar( String username, String password) {
        usuarioRepository.atualizar(new Usuario(username,password));
    }

    public List<Usuario> listar() {
        return usuarioRepository.listar();
    }

    public boolean remover(String username) {
        return usuarioRepository.remover(username);
    }
    public void alterarSenha(String username, String password){
        usuarioRepository.alterarSenha(new Usuario(username,password));
    }

}
