package projetoFinal.JDBC;

import projetoFinal.JDBC.*;
import java.sql.*;
import java.util.Scanner;
import projetoFinal.*;
import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class IdiomaDAO {
    public static void readIdioma(){
        try(Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT * FROM IdiomaOrientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Idioma: " + rs.getString("nome"));
            }

        }catch(Exception e){
                e.printStackTrace();
        }
    }

    public static int createIdioma(Scanner input){
        int idGerado = -1;
        try(Connection conn = ConnectionDB.getConnection()){
            System.out.println("Idioma: ");
            String idioma = input.nextLine();

            String sql = "INSERT INTO IdiomaOrientacao (nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, idioma);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println("Idioma criado com ID: " + idGerado);
            }

            System.out.println("Idioma adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idGerado;
    }

    public static void deleteIdioma(Scanner input){
        try(Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID da orientação para deletar:");
            int id = input.nextInt();
            input.nextLine();

            String sql = "DELETE FROM IdiomaOrientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, "Deletado com sucesso", "ID ausente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
