package resource;

import entity.Conteudo;
import repository.PersistenciaConteudo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class ConteudoResource implements PersistenciaConteudo<Conteudo> {
    private List<Conteudo> conteudos = new ArrayList<>();
    private int count = 1;

    @Override
    public void save(Conteudo entidade) {
        if(entidade.getId() == null) {
            entidade.setId(count++);
        }
        conteudos.add(entidade);
    }

    @Override
    public void atualizar(Conteudo entidade) {
        for (Conteudo conteudo : conteudos) {
            if (conteudo.getId().equals(entidade.getId())) {

                conteudo.setTitulo(entidade.getTitulo());
                conteudo.setTexto(entidade.getTexto());
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
        return conteudos.removeIf(conteudo -> conteudo.getId()==id);
    }
}
