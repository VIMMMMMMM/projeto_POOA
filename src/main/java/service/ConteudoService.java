package service;

import entity.Conteudo;
import entity.Usuario;
import repository.PersistenciaConteudo;

import java.util.List;

public class ConteudoService {
    PersistenciaConteudo<Conteudo> conteudoRepository;

    public ConteudoService(PersistenciaConteudo<Conteudo> persistencia) {
        this.conteudoRepository = persistencia;
    }
    public void save(Conteudo entidade) {
        conteudoRepository.save(entidade);
    }


    public void atualizar(int id, String titulo, String texto, Usuario autor) {
        conteudoRepository.atualizar(new Conteudo(id, titulo, texto, autor));
    }

    public List<Conteudo> listar() {

        return conteudoRepository.listar();
    }

    public boolean remover(int id) {
        return conteudoRepository.remover(id);
    }
}
