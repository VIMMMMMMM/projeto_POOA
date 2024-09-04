package dao;

import entity.Conteudo;
import entity.Usuario;
import infra.ConnectionFactory;
import repository.Persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConteudoHSQL implements Persistencia<Conteudo> {


    public ConteudoHSQL() {
        criarTabela();
    }
    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Conteudo (" +
                "id INTEGER PRIMARY KEY, " +
                "titulo VARCHAR(255), " +
                "texto VARCHAR(10000), " +
                "autor VARCHAR(255))";

        try (Connection connection= ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Conteudo conteudo) {
        String sql = "INSERT INTO Conteudo (titulo, texto, autor) VALUES (?, ?, ?)";

        try(Connection connection= ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, conteudo.getTitulo());
            preparedStatement.setString(2, conteudo.getTexto());
            preparedStatement.setString(3, conteudo.getAutor().getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Conteudo> listar() {
        List<Conteudo> conteudos = new ArrayList<>();
        String sql = "SELECT * FROM Conteudo";

        try (Connection connection= ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Conteudo conteudo = new Conteudo();
                conteudo.setId(rs.getInt("id"));
                conteudo.setTitulo(rs.getString("titulo"));
                conteudo.setTexto(rs.getString("texto"));
                Usuario autor = new Usuario();
                autor.setUsername(rs.getString("autor"));
                conteudo.setAutor(autor);
                conteudos.add(conteudo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conteudos;
    }

    public void atualizar(Conteudo conteudo) {
        String sql = "UPDATE Conteudo SET titulo = ?, texto = ?, autor = ? WHERE id = ?";

        try (Connection connection= ConnectionFactory.getConnection()) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, conteudo.getTitulo());
            preparedStatement.setString(2, conteudo.getTexto());
            preparedStatement.setString(3, conteudo.getAutor().getUsername());
            preparedStatement.setInt(4, conteudo.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM Conteudo WHERE id = ?";
        boolean delete = false;
        try (Connection connection= ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            delete = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delete;
    }
}
