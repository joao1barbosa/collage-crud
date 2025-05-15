package dao;

import model.User;
import database.ConnectionFactory;

import java.sql.*;

public class UserDAO {
    public User findByUsernameAndPassword(String username, String password) {
        String sql = "SELECT * FROM \"user\" WHERE username = ? AND password = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()){
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setRole(rs.getString("role"));
                    user.setStudentRegistration(rs.getInt("student_registration"));
                    return user;
                }

                return null;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar usuário no banco" + e.getMessage());
        }
    }
}

