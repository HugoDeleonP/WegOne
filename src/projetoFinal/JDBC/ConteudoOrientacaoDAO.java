package projetoFinal.JDBC;
import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class ConteudoOrientacaoDAO {
    public static void readConteudo(){
        try(Connection conn = ConnectionDB.getConnection()){
            String sql = "SELECT * FROM ConteudoOrientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createConteudo(){
        try(Connection conn = ConnectionDB.getConnection()) {
            String sql = "INSERT INTO ConteudoOrientacao (id) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            System.out.println("ID adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteConteudo(){
        try (Connection conn = ConnectionDB.getConnection()){
            String sql = "DELETE FROM ConteudoOrientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            executeUpdateMessage(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
