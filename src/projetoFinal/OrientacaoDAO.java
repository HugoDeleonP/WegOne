package projetoFinal;

import projetoFinal.JDBC.ConnectionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrientacaoDAO {

    public static void readOrientacoes(){
        try(Connection conn = ConnectionDB.getConnection()){
            String sql = "SELECT * FROM Orientacao";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("ID do tipo: " + rs.getInt("id_tipo"));
                System.out.println("ID do Título: " + rs.getInt("id_titulo"));
                System.out.println("ID do conteúdo: " + rs.getInt("id_conteudo"));
                System.out.println("------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
