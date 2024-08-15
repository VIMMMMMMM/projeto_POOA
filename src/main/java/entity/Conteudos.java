package entity;

import java.util.Objects;

public class Conteudos {
    private int Id;
    private String detalhes;

    public Conteudos() {

    }

    public Conteudos(int id, String detalhes) {
        Id = id;
        this.detalhes = detalhes;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudos conteudos = (Conteudos) o;
        return Id == conteudos.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Conteudos{" +
                "Id=" + Id +
                ", detalhes='" + detalhes + '\'' +
                '}';
    }
}
