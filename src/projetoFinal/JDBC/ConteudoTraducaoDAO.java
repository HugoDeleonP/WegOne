package projetoFinal.JDBC;

import java.sql.*;
import java.util.Scanner;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class ConteudoTraducaoDAO {

    public static void readConteudoTraducao() {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM ConteudoTraducao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("ID Conteudo: " + rs.getInt("id_conteudo"));
                System.out.println("ID Idioma: " + rs.getInt("id_idioma"));
                System.out.println("Conteúdo: " + rs.getString("conteudo"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createConteudoTraducao(Scanner input) {
        int idGerado = -1;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("ID do Conteúdo:");
            int idConteudo = input.nextInt();
            input.nextLine();

            System.out.println("ID do Idioma:");
            int idIdioma = input.nextInt();
            input.nextLine();

            System.out.println("Conteúdo:");
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
                System.out.println("ConteudoTraducao criado com ID: " + idGerado);
            }

            System.out.println("ConteudoTraducao adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteConteudoTraducao(Scanner input) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID do ConteudoTraducao para deletar:");
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM ConteudoTraducao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, "Deletado com sucesso", "ID ausente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
