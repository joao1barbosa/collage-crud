package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5332/faculdade";
    private static final String USER = "postgres";
    private static final String PASSWORD = "adm";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("Erro na conexão com o banco" + e.getMessage());
        }
    }
}
