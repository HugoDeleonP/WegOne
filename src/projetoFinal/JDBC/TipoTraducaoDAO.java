package projetoFinal.JDBC;

import projetoFinal.Tradutor;

import java.sql.*;
import java.util.Scanner;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class TipoTraducaoDAO {

    public static void readTipoTraducao(Tradutor traducao) {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM TipoTraducao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println(traducao.getProperty("campo.id.tipo") + rs.getInt("id_tipo"));
                System.out.println(traducao.getProperty("campo.id.idioma") + rs.getInt("id_idioma"));
                System.out.println(traducao.getProperty("campo.tipo") + rs.getString("tipo"));
                System.out.println("---------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createTipoTraducao(Scanner input, Tradutor traducao) {
        int idGerado = -1;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("campo.id.tipo"));
            int idTipo = input.nextInt();
            input.nextLine();

            System.out.println(traducao.getProperty("campo.id.idioma"));
            int idIdioma = input.nextInt();
            input.nextLine();

            System.out.println(traducao.getProperty("campo.nome.exibicao"));
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
                System.out.println(traducao.getProperty("criado.tipotraducao") + idGerado);
            }

            System.out.println(traducao.getProperty("mensagem.sucesso"));;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteTipoTraducao(Scanner input, Tradutor traducao) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println(traducao.getProperty("entrada.id.tipotraducao"));
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM TipoTraducao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, traducao.getProperty("mensagem.deletado"), traducao.getProperty("mensagem.id.ausente"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

