package projetoFinal.JDBC;
import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class TituloOrientacaoDAO {
    public static void readTitulo(){
        try(Connection conn = ConnectionDB.getConnection()){
            String sql = "SELECT * FROM TituloOrientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTitulo(){
        try(Connection conn = ConnectionDB.getConnection()) {
            String sql = "INSERT INTO TituloOrientacao (id) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            System.out.println("ID adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTitulo(){
        try (Connection conn = ConnectionDB.getConnection()){
            String sql = "DELETE FROM TituloOrientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            executeUpdateMessage(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
