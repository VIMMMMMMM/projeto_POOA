package repository;

import java.util.List;

public interface PersistenciaConteudo<Conteudo> {

    void save(Conteudo entidade);

    void atualizar(Conteudo entidade);

    List<Conteudo> listar();

    boolean remover(int id);
}
