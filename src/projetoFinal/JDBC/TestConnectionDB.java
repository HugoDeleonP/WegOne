package projetoFinal.JDBC;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnectionDB {
    public static void main(String[] args) {
        try(Connection conn = ConnectionDB.getConnection();) {
            if(conn != null){
                System.out.println("Conexão realizada com sucesso!");
            }
        } catch (Exception e){
            System.out.println("Conexão não correspondida.");
            e.printStackTrace();
        }
    }
}
