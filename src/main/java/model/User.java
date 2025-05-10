package model;

public class User {
    private int id;
    private String username;
    private String password;
    private String role; // "ADMIN" ou "USER"
    private Integer studentRegistration;

    public User() {}

    public User(String username, String password, String role, Integer studentRegistration) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.studentRegistration = studentRegistration;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Integer getStudentRegistration() {
        return studentRegistration;
    }
    public void setStudentRegistration(Integer studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public boolean isAdmin() {
        return "ADMIN".equals(this.role);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", studentRegistration=" + studentRegistration +
                '}'+ '\n';
    }
}
