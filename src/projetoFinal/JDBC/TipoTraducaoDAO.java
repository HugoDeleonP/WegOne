package projetoFinal.JDBC;

import java.sql.*;
import java.util.Scanner;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class TipoTraducaoDAO {

    public static void readTipoTraducao() {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM TipoTraducao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("ID Tipo: " + rs.getInt("id_tipo"));
                System.out.println("ID Idioma: " + rs.getInt("id_idioma"));
                System.out.println("Nome Exibição: " + rs.getString("tipo"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createTipoTraducao(Scanner input) {
        int idGerado = -1;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("ID do Tipo:");
            int idTipo = input.nextInt();
            input.nextLine();

            System.out.println("ID do Idioma:");
            int idIdioma = input.nextInt();
            input.nextLine();

            System.out.println("Nome de Exibição:");
            String nomeExibicao = input.nextLine();

            String sql = "INSERT INTO TipoTraducao (id_tipo, id_idioma, nome_exibicao) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idTipo);
            stmt.setInt(2, idIdioma);
            stmt.setString(3, nomeExibicao);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println("TipoTraducao criado com ID: " + idGerado);
            }

            System.out.println("TipoTraducao adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteTipoTraducao(Scanner input) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID do TipoTraducao para deletar:");
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM TipoTraducao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, "Deletado com sucesso", "ID ausente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

