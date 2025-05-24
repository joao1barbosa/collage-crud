package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.CollageClass;
import model.Student;
import database.ConnectionFactory;

public class UserClassDAO {

    public void create(int userId, int classId) {
        String sql = "INSERT INTO user_class (user_id, class_id) VALUES (?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, classId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cadastrar aluno na turma: " + e.getMessage());
        }
    }

    public List<CollageClass> findClassesByUser(int userId) {
        List<CollageClass> collageClasses = new ArrayList<>();

        String sql = "SELECT c.id, c.name, c.shift, c.course FROM class c " +
                "JOIN user_class uc ON c.id = uc.class_id " +
                "WHERE uc.user_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CollageClass collageClass = new CollageClass();
                collageClass.setId(rs.getInt("id"));
                collageClass.setName(rs.getString("name"));
                collageClass.setShift(rs.getString("shift"));
                collageClass.setCourse(rs.getString("course"));
                collageClasses.add(collageClass);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar turmas de um aluno: " + e.getMessage());
        }

        return collageClasses;
    }

    public List<Student> findStudentsByClass(int classId) {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT s.id, s.registration, s.name, s.phone, s.birthdate, s.course, s.cpf FROM student s " +
                "JOIN \"user\" u ON s.registration = u.student_registration " +
                "JOIN user_class uc ON u.id = uc.user_id " +
                "WHERE uc.class_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, classId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setRegistration(rs.getInt("registration"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setBirthdate(rs.getDate("birthdate"));
                student.setCourse(rs.getString("course"));
                student.setCpf(rs.getString("cpf"));
                students.add(student);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar alunos de uma turma: " + e.getMessage());
        }

        return students;
    }

    public void delete(int userId, int classId) {
        String sql = "DELETE FROM user_class WHERE user_id = ? AND class_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, classId);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover aluno de uma turma: " + e.getMessage());
        }
    }
}
