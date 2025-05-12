package dao;

import dto.StudentPublicDTO;
import model.Student;
import database.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {

    public void create(Student student) {
        String sql = "INSERT INTO student (registration, name, phone, birthdate, course, cpf) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, student.getRegistration());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getPhone());
            stmt.setDate(4, student.getBirthdate());
            stmt.setString(5, student.getCourse());
            stmt.setString(6, student.getCpf());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno: " + e.getMessage());
        }
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

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
            throw new RuntimeException("Erro ao buscar alunos: " + e.getMessage());
        }

        return students;
    }

    public StudentPublicDTO findOwnDataByRegistration(int registration){
        String sql = "SELECT * FROM student WHERE registration = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registration);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    StudentPublicDTO student = new StudentPublicDTO();
                    student.setRegistration(rs.getInt("registration"));
                    student.setName(rs.getString("name"));
                    student.setPhone(rs.getString("phone"));
                    student.setBirthdate(rs.getDate("birthdate"));
                    student.setCourse(rs.getString("course"));
                    return student;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar dados do aluno: " + e.getMessage());
        }

        return null;
    }

    public Student findByRegistration(int registration) {
        String sql = "SELECT * FROM student WHERE registration = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registration);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setRegistration(rs.getInt("registration"));
                    student.setName(rs.getString("name"));
                    student.setPhone(rs.getString("phone"));
                    student.setBirthdate(rs.getDate("birthdate"));
                    student.setCourse(rs.getString("course"));
                    student.setCpf(rs.getString("cpf"));
                    return student;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aluno pela matrícula: " + e.getMessage());
        }

        return null;
    }

    public Student findByName(String name) {
        String sql = "SELECT * FROM student WHERE name = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id"));
                    student.setRegistration(rs.getInt("registration"));
                    student.setName(rs.getString("name"));
                    student.setPhone(rs.getString("phone"));
                    student.setBirthdate(rs.getDate("birthdate"));
                    student.setCourse(rs.getString("course"));
                    student.setCpf(rs.getString("cpf"));
                    return student;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar aluno pelo nome: " + e.getMessage());
        }

        return null;
    }

    public void update(Student student) {
        String sql = "UPDATE student SET name = ?, phone = ?, birthdate = ?, course = ?, cpf = ? WHERE registration = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getPhone());
            stmt.setDate(3, student.getBirthdate());
            stmt.setString(4, student.getCourse());
            stmt.setString(5, student.getCpf());
            stmt.setInt(6, student.getRegistration());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    public void delete(int registration) {
        String sql = "DELETE FROM student WHERE registration = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registration);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar aluno: " + e.getMessage());
        }
    }
}
