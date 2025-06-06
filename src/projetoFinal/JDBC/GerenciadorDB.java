package projetoFinal.JDBC;

import projetoFinal.Tradutor;
import java.util.Scanner;
import static projetoFinal.GerenciadorOrientacao.*;
import projetoFinal.JDBC.InterfaceDB;

public class GerenciadorDB {

    // OrdemEntidades: **IdiomaOrientacao(id, nome), **TipoOrientacao(id, nome), TipoTraducao(), TituloTraducao(), ConteudoTraducao(), TituloOrientacao(id), ConteudoOrientacao(id), Orientacao().
    // ** pré-configurado.

    private OrientacaoDAO orientacao = new OrientacaoDAO();
    private TipoTraducaoDAO tipo = new TipoTraducaoDAO();
    private TituloOrientacaoDAO titulo = new TituloOrientacaoDAO();
    private ConteudoOrientacaoDAO conteudo = new ConteudoOrientacaoDAO();
    private TituloTraducaoDAO tituloReceber = new TituloTraducaoDAO();
    private ConteudoTraducaoDAO conteudoReceber = new ConteudoTraducaoDAO();

    public void cadastrarOrientacao(Tradutor traducao, Scanner input){
        System.out.println(traducao.getProperty("tipoOrientacao"));
        int tipoTextoEscolhido = escolherTipoTexto(input, traducao);

        System.out.println(traducao.getProperty("comandoDigitoTitulo"));
        String tituloDigitado = input.nextLine();

        System.out.println(traducao.getProperty("comandoDigitoConteudo"));
        String conteudoDigitado = input.nextLine();

        int idTitulo = titulo.createTitulo(traducao);
        int idConteudo = conteudo.createConteudo(traducao);

        orientacao.createOrientacao(traducao, tipoTextoEscolhido, idTitulo, idConteudo);

        tituloReceber.createTituloTraducao(traducao, idTitulo, lingua, tituloDigitado);
        conteudoReceber.createConteudoTraducao(traducao, idConteudo, lingua, conteudoDigitado);
    }

    public void listarOrientacao(Scanner input, Tradutor traducao){
        // JOIN
        orientacao.readOrientacaoCompleta(input, 1, traducao);
    }

    public void editarOrientacao(){
        //acrescentar
    }

    public void deletarOrientacao(){
        //deletar pelo id
    }

    public void pesquisarOrientacao(){
        
    }

    private int escolherTipoTexto(Scanner input, Tradutor traducao){

        int escolhaTipoTexto;
        do {
            if (input.hasNextInt()) {
                System.out.println(traducao.getProperty("tipoOrientacao"));
                escolhaTipoTexto = input.nextInt();
                input.nextLine();
                return escolhaTipoTexto;
            } else {
                System.out.println("respostaInvalida");
                input.nextLine();
            }
        } while (true);

    }

}
