package projetoFinal.JDBC;

import projetoFinal.Tradutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GerenciadorDB {

    private final Tradutor traducao;
    private final Scanner input;

    public GerenciadorDB(Scanner input, Tradutor traducao) {
        this.input = input;
        this.traducao = traducao;
    }

    public void cadastrarOrientacao() {
        String repetirCadastro;

        do {
            System.out.println(traducao.getProperty("tipoOrientacao"));
            int tipoId = input.nextInt();

            System.out.println(traducao.getProperty("comandoDigitoTitulo"));
            String titulo = input.nextLine();
            int idTitulo = TituloTraducaoDAO.createTituloTraducao(traducao, 0, tipoId, titulo); // Ajuste o id_titulo conforme necessidade

            System.out.println(traducao.getProperty("comandoDigitoConteudo"));
            String conteudo = input.nextLine();
            int idConteudo = ConteudoTraducaoDAO.createConteudoTraducao(traducao, 0, tipoId, conteudo); // Ajuste id_conteudo

            int idOrientacao = OrientacaoDAO.createOrientacao(traducao, tipoId, idTitulo, idConteudo);

            System.out.println(traducao.getProperty("criado.orientacao") + idOrientacao);

            do {
                System.out.println(traducao.getProperty("perguntaRepeticaoCadastro"));
                repetirCadastro = input.nextLine();

                if (!repetirCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) &&
                        !repetirCadastro.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                    System.out.println(traducao.getProperty("respostaInvalida"));
                }

            } while (!repetirCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) &&
                    !repetirCadastro.equalsIgnoreCase(traducao.getProperty("negativo")));

        } while (repetirCadastro.equalsIgnoreCase(traducao.getProperty("positivo")));
    }

    public void editarOrientacao() {
        System.out.println(traducao.getProperty("digitarID"));
        int id = input.nextInt();

        if (id == 0) {
            System.out.println(traducao.getProperty("respostaInvalida"));
            return;
        }

        try (Connection conn = ConnectionDB.getConnection()) {

            // Verifica se a orientação existe
            PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM Orientacao WHERE id = ?");
            selectStmt.setInt(1, id);
            ResultSet rs = selectStmt.executeQuery();

            if (!rs.next()) {
                System.out.println(traducao.getProperty("semOrientacao"));
                return;
            }

            int idTipoAtual = rs.getInt("id_tipo");
            int idTituloAtual = rs.getInt("id_titulo");
            int idConteudoAtual = rs.getInt("id_conteudo");

            boolean continuarEditando = true;
            while (continuarEditando) {
                System.out.println(traducao.getProperty("oQueEditar"));
                System.out.println("1 - " + traducao.getProperty("tipo"));
                System.out.println("2 - " + traducao.getProperty("titulo"));
                System.out.println("3 - " + traducao.getProperty("conteudo"));

                int opcaoEditar = input.nextInt();

                switch (opcaoEditar) {
                    case 1:
                        System.out.println(traducao.getProperty("tipoOrientacao"));
                        int novoTipoId = input.nextInt();

                        PreparedStatement updateTipo = conn.prepareStatement("UPDATE Orientacao SET id_tipo = ? WHERE id = ?");
                        updateTipo.setInt(1, novoTipoId);
                        updateTipo.setInt(2, id);
                        updateTipo.executeUpdate();
                        break;

                    case 2:
                        System.out.println(traducao.getProperty("titulo"));
                        String novoTitulo = input.nextLine();

                        PreparedStatement updateTitulo = conn.prepareStatement("UPDATE TituloTraducao SET titulo = ? WHERE id = ?");
                        updateTitulo.setString(1, novoTitulo);
                        updateTitulo.setInt(2, idTituloAtual);
                        updateTitulo.executeUpdate();
                        break;

                    case 3:
                        System.out.println(traducao.getProperty("conteudo"));
                        String novoConteudo = input.nextLine();

                        PreparedStatement updateConteudo = conn.prepareStatement("UPDATE ConteudoTraducao SET conteudo = ? WHERE id = ?");
                        updateConteudo.setString(1, novoConteudo);
                        updateConteudo.setInt(2, idConteudoAtual);
                        updateConteudo.executeUpdate();
                        break;

                    default:
                        System.out.println(traducao.getProperty("respostaInvalida"));
                        continue;
                }

                System.out.println(traducao.getProperty("continuarEditar"));
                String resposta = input.nextLine().trim();
                if (resposta.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                    continuarEditando = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}