package dao;


import entity.Conteudo;
import repository.PersistenciaConteudo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConteudoList implements PersistenciaConteudo<Conteudo> {
    private int count=1;
    private List<Conteudo> conteudos = new ArrayList<>();

    @Override
    public void save(Conteudo entity) {
        if(entity.getId() == null) {
            entity.setId(count++);
        }
        conteudos.add(entity);
    }

    @Override
    public void atualizar(Conteudo entity) {
        for (Conteudo conteudo : conteudos) {
            if (Objects.equals(conteudo.getId(), entity.getId())) {
                conteudo.setTitulo(entity.getTitulo());
                conteudo.setTexto(entity.getTexto());
                break;
            }
        }
    }

    @Override
    public List<Conteudo> listar() {
        return Collections.unmodifiableList(conteudos);
    }

    @Override
    public boolean remover(int id) {
        return conteudos.removeIf(conteudo -> conteudo.getId() == id);
    }
}

