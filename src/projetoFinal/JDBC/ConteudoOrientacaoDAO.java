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

    public static int createConteudo(Tradutor traducao){
        int idGerado = 0;
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "INSERT INTO ConteudoOrientacao DEFAULT VALUES";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println(traducao.getProperty("mensagem.criado") + idGerado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;

    }

    public static void deleteConteudo(Tradutor traducao, Scanner input){
        try (Connection conn = ConnectionDB.getConnection()){
            System.out.println(traducao.getProperty("entrada.id.conteudo"));
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM ConteudoOrientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, traducao.getProperty("mensagem.deletado"), traducao.getProperty("mensagem.id.ausente"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
