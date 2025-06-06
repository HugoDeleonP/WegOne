package projetoFinal.JDBC;

import projetoFinal.Tradutor;

import java.sql.*;
import java.util.Scanner;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class TituloTraducaoDAO {

    public static void readTituloTraducao(Tradutor traducao) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM TituloTraducao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println(traducao.getProperty("campo.id.titulo") + rs.getInt("id_titulo"));
                System.out.println(traducao.getProperty("campo.id.idioma") + rs.getInt("id_idioma"));
                System.out.println(traducao.getProperty("campo.titulo") + rs.getString("titulo"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createTituloTraducao(Tradutor traducao, int idTitulo, int idIdioma, String titulo) {
        int idGerado = 0;
        try (Connection conn = ConnectionDB.getConnection()) {

            String sql = "INSERT INTO TituloTraducao (id_titulo, id_idioma, titulo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idTitulo);
            stmt.setInt(2, idIdioma);
            stmt.setString(3, titulo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println(traducao.getProperty("criado.titulotraducao") + idGerado);
            }

            System.out.println(traducao.getProperty("mensagem.sucesso"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteTituloTraducao(Scanner input, Tradutor traducao) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.titulotraducao"));
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM TituloTraducao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, traducao.getProperty("mensagem.deletado"), traducao.getProperty("mensagem.id.ausente"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
