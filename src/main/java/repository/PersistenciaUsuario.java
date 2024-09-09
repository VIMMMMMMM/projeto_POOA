package repository;

import entity.Usuario;

import java.util.List;

public interface PersistenciaUsuario<Usuario> {

    void save(Usuario entidade);

    void atualizar(Usuario entidade);

    List<Usuario> listar();

    boolean remover(String username);

    void alterarSenha(Usuario entidade);
}
