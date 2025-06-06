package projetoFinal.JDBC;

import projetoFinal.JDBC.*;
import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class IdiomaDAO {
    public static void readIdioma(Tradutor traducao){
        try(Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM IdiomaOrientacao ORDER BY id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println(traducao.getProperty("campo.idioma") + rs.getString("nome"));
            }

        }catch(Exception e){
                e.printStackTrace();
        }
    }

    public static int createIdioma(Scanner input, Tradutor traducao){
        int idGerado = 0;
        try(Connection conn = ConnectionDB.getConnection()){
            System.out.println(traducao.getProperty("campo.idioma"));
            String idioma = input.nextLine();

            String sql = "INSERT INTO IdiomaOrientacao (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, idioma);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println(traducao.getProperty("criado.idioma") + idGerado);
            }

            System.out.println(traducao.getProperty("mensagem.sucesso"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idGerado;
    }

    public static void deleteIdioma(Scanner input, Tradutor traducao){
        try(Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.idioma"));
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM IdiomaOrientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, traducao.getProperty("mensagem.deletado"), traducao.getProperty("mensagem.id.ausente"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
