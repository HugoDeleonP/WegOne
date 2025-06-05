package projetoFinal.JDBC;

import java.sql.*;
import java.util.Scanner;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class TituloTraducaoDAO {

    public static void readTituloTraducao() {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM TituloTraducao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("ID Titulo: " + rs.getInt("id_titulo"));
                System.out.println("ID Idioma: " + rs.getInt("id_idioma"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createTituloTraducao(Scanner input) {
        int idGerado = 0;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("ID do Título:");
            int idTitulo = input.nextInt();
            input.nextLine();

            System.out.println("ID do Idioma:");
            int idIdioma = input.nextInt();
            input.nextLine();

            System.out.println("Título:");
            String titulo = input.nextLine();

            String sql = "INSERT INTO TituloTraducao (id_titulo, id_idioma, titulo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idTitulo);
            stmt.setInt(2, idIdioma);
            stmt.setString(3, titulo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println("TituloTraducao criado com ID: " + idGerado);
            }

            System.out.println("TituloTraducao adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteTituloTraducao(Scanner input) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID do TituloTraducao para deletar:");
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM TituloTraducao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, "Deletado com sucesso", "ID ausente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
