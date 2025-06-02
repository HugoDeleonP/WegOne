package projetoFinal.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static projetoFinal.JDBC.ConnectionDB.executeUpdateMessage;

public class OrientacaoDAO {
    public static void readOrientacao() {
        try (Connection conn = ConnectionDB.getConnection()) {
            String sql = "SELECT " +
                    "orientacao.id AS orientacao_id, " +
                    "tit.titulo AS titulo_orientacao, " +
                    "cont.conteudo AS conteudo_orientacao, " +
                    "tt.nome_exibicao AS tipo_orientacao " +
                    "FROM Orientacao o " +
                    "JOIN TituloTraducao tit ON o.id_titulo = tit.id_titulo " +
                    "JOIN ConteudoTraducao cont ON o.id_conteudo = cont.id_conteudo " +
                    "JOIN TipoTraducao tt ON o.id_tipo = tt.id_tipo " +
                    "JOIN IdiomaOrientacao io ON tit.id_idioma = io.id " +
                    "                       AND cont.id_idioma = io.id " +
                    "                       AND tt.id_idioma = io.id " +
                    "WHERE io.nome = ? AND o.id = ?";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Orientação ID: " + rs.getInt("id"));
                System.out.println("Tipo: " + rs.getString("id_tipo"));
                System.out.println("Título ID: " + rs.getInt("id_titulo"));
                System.out.println("Conteúdo ID: " + rs.getInt("id_conteudo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int createOrientacao(Scanner input) {
        int idGerado = -1;
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Nome: ");
            String nome = input.nextLine();

            String sql = "INSERT INTO Orientacao(nome) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, nome);
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
                System.out.println("Título criado com ID: " + idGerado);
            }

            System.out.println("Nome adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idGerado;
    }

    public static void deleteOrientacao(Scanner input) {
        try (Connection conn = ConnectionDB.getConnection()) {
            System.out.println("Digite o ID da orientação para deletar:");
            int id = input.nextInt();

            String sql = "DELETE FROM Orientacao WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            executeUpdateMessage(stmt, "Deletado com sucesso", "ID ausente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


