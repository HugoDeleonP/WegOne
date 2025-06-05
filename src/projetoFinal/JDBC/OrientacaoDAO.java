package projetoFinal.JDBC;

import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class OrientacaoDAO {

    public static void readOrientacao(){
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM Orientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("ID Tipo: " + rs.getInt("id_tipo"));
                System.out.println("ID Título: " + rs.getInt("id_titulo"));
                System.out.println("ID Conteúdo: " + rs.getInt("id_conteudo"));
                System.out.println("-----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readOrientacaoCompleta(Scanner input, int idIdioma){
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM Orientacoes";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idIdioma);
            stmt.setInt(2, idIdioma);
            stmt.setInt(3, idIdioma);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Orientação ID: " + rs.getInt("id"));
                System.out.println("Tipo: " + rs.getString("tipo_traduzido"));
                System.out.println("Título: " + rs.getString("titulo_traduzido"));
                System.out.println("Conteúdo: " + rs.getString("conteudo_traduzido"));
                System.out.println("----------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int createOrientacao(Scanner input){
        int idGerado = 0;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID do Tipo:");
            int idTipo = input.nextInt();
            System.out.println("Digite o ID do Título:");
            int idTitulo = input.nextInt();
            System.out.println("Digite o ID do Conteúdo:");
            int idConteudo = input.nextInt();
            input.nextLine(); // limpar buffer

            String sql = "INSERT INTO Orientacao (id_tipo, id_titulo, id_conteudo) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idTipo);
            stmt.setInt(2, idTitulo);
            stmt.setInt(3, idConteudo);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println("Orientação criada com ID: " + idGerado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idGerado;
    }

    public static void deleteOrientacao(Scanner input){
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID da orientação para deletar:");
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM Orientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, "Deletado com sucesso", "ID ausente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
