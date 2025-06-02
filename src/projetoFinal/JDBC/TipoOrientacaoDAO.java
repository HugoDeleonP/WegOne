package projetoFinal.JDBC;
import java.sql.*;
import java.util.Scanner;

import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class TipoOrientacaoDAO {
    public static void readTipo(){
        try(Connection conn = ConnectionDB.getConnection()){
            String sql = "SELECT * FROM TipoOrientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTipo(Scanner input){
        try(Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Nome: ");
            String nome = input.nextLine();

            String sql = "INSERT INTO TipoOrientacao (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);

            System.out.println("Nome adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteTipo(Scanner input){
        try (Connection conn = ConnectionDB.getConnection()){
            System.out.println("Digite o ID da orientação para deletar:");
            int id = input.nextInt();

            String sql = "DELETE FROM TipoOrientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
