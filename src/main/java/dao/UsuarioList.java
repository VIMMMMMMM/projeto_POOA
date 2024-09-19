package dao;


import entity.Usuario;
import entity.Usuario;
import repository.PersistenciaConteudo;
import repository.PersistenciaUsuario;
import service.UsuarioService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class UsuarioList  implements PersistenciaUsuario<Usuario>  {
    private int count=1;
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public void save(Usuario entity) {
        usuarios.add(entity);
    }

    @Override
    public void atualizar(Usuario entity) {
        for (Usuario usuario : usuarios) {
            if (Objects.equals(usuario.getId(), entity.getId())) {
                usuario.setUsername(entity.getUsername());
                usuario.setPassword(entity.getPassword());
                break;
            }
        }
    }

    @Override
    public List<Usuario> listar() {
        return Collections.unmodifiableList(usuarios);
    }

    @Override
    public boolean remover(String id) {
        return usuarios.removeIf(usuario -> Objects.equals(usuario.getId(), id));
    }

    @Override
    public void alterarSenha(Usuario entidade) {
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(entidade.getUsername())) {
                usuario.setPassword(entidade.getPassword());
                break;
            }
        }
    }

}

