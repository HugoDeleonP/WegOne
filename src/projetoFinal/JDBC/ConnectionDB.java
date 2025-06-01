package projetoFinal.JDBC;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public class ConnectionDB {
    private static final String URL = "jdbc:mysql://root:beQwLQrVagQlJWUjWkSvIMrrTtOhiXuW@ballast.proxy.rlwy.net:43059/railway";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "beQwLQrVagQlJWUjWkSvIMrrTtOhiXuW";
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", e);
        }

    }
}
