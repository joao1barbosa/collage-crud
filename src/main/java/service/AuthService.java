package service;

import dao.UserDAO;
import model.User;

public class AuthService {
    private final UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = new UserDAO();
    }

    public User authenticate(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Usuário/senha não podem ser nulos");
        }

        User user = userDAO.findByUsernameAndPassword(username, password);

        if (user == null) {
            throw new RuntimeException("Credenciais inválidas");
        }

        return user;
    }
}
