package projetoFinal.JDBC;

import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class OrientacaoDAO {

    public static void readOrientacao(Tradutor traducao){
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM Orientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(traducao.getProperty("campo.orientacao") + rs.getInt("id"));
                System.out.println(traducao.getProperty("campo.id.tipo") + rs.getInt("id_tipo"));
                System.out.println(traducao.getProperty("campo.id.titulo") + rs.getInt("id_titulo"));
                System.out.println(traducao.getProperty("campo.id.conteudo") + rs.getInt("id_conteudo"));
                System.out.println("-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readOrientacaoCompleta(Scanner input, int idIdioma, Tradutor traducao){
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM Orientacoes";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idIdioma);
            stmt.setInt(2, idIdioma);
            stmt.setInt(3, idIdioma);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(traducao.getProperty("campo.orientacao") + rs.getInt("id"));
                System.out.println(traducao.getProperty("campo.tipo") + rs.getString("tipo_traduzido"));
                System.out.println(traducao.getProperty("campo.titulo") + rs.getString("titulo_traduzido"));
                System.out.println(traducao.getProperty("campo.conteudo") + rs.getString("conteudo_traduzido"));
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int createOrientacao(Scanner input, Tradutor traducao){
        int idGerado = 0;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.tipo"));
            int idTipo = input.nextInt();
            System.out.println(traducao.getProperty("entrada.id.titulo"));
            int idTitulo = input.nextInt();
            System.out.println(traducao.getProperty("entrada.id.conteudo"));
            int idConteudo = input.nextInt();
            input.nextLine();

            String sql = "INSERT INTO Orientacao (id_tipo, id_titulo, id_conteudo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idTipo);
            stmt.setInt(2, idTitulo);
            stmt.setInt(3, idConteudo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println(traducao.getProperty("criado.orientacao") + idGerado);
            }

            System.out.println(traducao.getProperty("mensagem.sucesso"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteOrientacao(Scanner input, Tradutor traducao){
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.orientacao"));
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM Orientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, traducao.getProperty("mensagem.deletado"), traducao.getProperty("mensagem.id.ausente"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
