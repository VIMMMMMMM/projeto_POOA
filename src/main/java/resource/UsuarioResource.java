package resource;


import entity.Usuario;

import repository.PersistenciaUsuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsuarioResource implements PersistenciaUsuario<Usuario> {
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void save(Usuario entidade) {
        usuarios.add(entidade);
    }
    @Override
    public void atualizar(Usuario entidade) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(entidade.getId())) {
                usuario.setUsername(entidade.getUsername());
                usuario.setPassword(entidade.getPassword());
                break;
            }
        }
    }
    @Override
    public List<Usuario> listar() {
        return Collections.unmodifiableList(usuarios);
    }
    @Override
    public boolean remover(String username) {
        return usuarios.removeIf(usuario -> usuario.getUsername().contains(username));
    }
    public void alterarSenha(Usuario entidade){
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(entidade.getUsername())) {
                usuario.setPassword(entidade.getPassword());
                break;
            }
        }
    }
}
