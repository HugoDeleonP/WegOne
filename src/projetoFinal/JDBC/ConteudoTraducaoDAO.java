package projetoFinal.JDBC;

import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class ConteudoTraducaoDAO {

    public static void readConteudoTraducao(Tradutor traducao) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM ConteudoTraducao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println(traducao.getProperty("campo.id.conteudo") + rs.getInt("id_conteudo"));
                System.out.println(traducao.getProperty("campo.id.idioma") + rs.getInt("id_idioma"));
                System.out.println(traducao.getProperty("campo.conteudo") + rs.getString("conteudo"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createConteudoTraducao(Scanner input, Tradutor traducao) {
        int idGerado = 0;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.conteudo"));
            int idConteudo = input.nextInt();
            input.nextLine();

            System.out.println(traducao.getProperty("entrada.id.idioma"));
            int idIdioma = input.nextInt();
            input.nextLine();

            System.out.println("campo.conteudo");
            String conteudo = input.nextLine();

            String sql = "INSERT INTO ConteudoTraducao (id_conteudo, id_idioma, conteudo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idConteudo);
            stmt.setInt(2, idIdioma);
            stmt.setString(3, conteudo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println(traducao.getProperty("criado.conteudotraducao") + idGerado);
            }

            System.out.println(traducao.getProperty("mensagem.sucesso"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteConteudoTraducao(Scanner input, Tradutor traducao) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.conteudotraducao"));
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM ConteudoTraducao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, traducao.getProperty("mensagem.deletado"), traducao.getProperty("mensagem.id.ausente"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
