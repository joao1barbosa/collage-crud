package dao;

import model.CollageClass;
import database.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollageClassDAO {
    public void create(CollageClass collageClass) {
        String sql = "INSERT INTO class (name, shift, course) VALUES (?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, collageClass.getName());
            stmt.setString(2, collageClass.getShift());
            stmt.setString(3, collageClass.getCourse());

            stmt.executeUpdate();

        } catch (SQLException e){
            throw new RuntimeException("Erro ao inserir turma: " + e.getMessage());
        }
    }

    public List<CollageClass> findAll() {
        List<CollageClass> collageClasses = new ArrayList<>();
        String sql = "SELECT * FROM class";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CollageClass collageClass = new CollageClass();
                collageClass.setId(rs.getInt("id"));
                collageClass.setName(rs.getString("name"));
                collageClass.setShift(rs.getString("shift"));
                collageClass.setCourse(rs.getString("course"));
                collageClasses.add(collageClass);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar turmas: " + e.getMessage());
        }

        return collageClasses;
    }

    public CollageClass findById(int id) {
        String sql = "SELECT * FROM class WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    CollageClass collageClass = new CollageClass();
                    collageClass.setId(rs.getInt("id"));
                    collageClass.setName(rs.getString("name"));
                    collageClass.setShift(rs.getString("shift"));
                    collageClass.setCourse(rs.getString("course"));
                    return collageClass;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar turma pelo ID: " + e.getMessage());
        }

        return null;
    }

    public void update(int id, CollageClass collageClass) {
        String sql = "UPDATE class SET name = ?, shift = ?, course = ? WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, collageClass.getName());
            stmt.setString(2, collageClass.getShift());
            stmt.setString(3, collageClass.getCourse());
            stmt.setInt(4, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar turma: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM class WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar turma: " + e.getMessage());
        }
    }
}
