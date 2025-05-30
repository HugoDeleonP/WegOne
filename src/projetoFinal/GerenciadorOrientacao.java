package projetoFinal;

import java.util.Scanner;

public class GerenciadorOrientacao {

    private Orientacao[] orientacoes;
    private int quantidadeTexto;
    private int proximoId;

    public GerenciadorOrientacao(){
        this.orientacoes = new Orientacao[100];
        this.quantidadeTexto = 0;
        this.proximoId = 1;
    }

    public void adicionarOrientacaoPreDefinida(String tipo, String titulo, String conteudo){
        if(quantidadeTexto < orientacoes.length){
            orientacoes[quantidadeTexto] = new Orientacao(proximoId++, tipo, titulo, conteudo);
            quantidadeTexto++;
        } else {
            System.out.println("Limite de orientações ultrapassado");
        }
    }

    public void cadastrarOrientacao(Scanner input, Tradutor traducao) {
        String repeticaoCadastro;
        int escolhaTipoTexto;


        String tituloDigitado;
        String conteudoDigitado;
        String tipoTextoEscolhido = null;

        do{
            do{

                System.out.println(traducao.getProperty("tipoOrientacao"));

                escolhaTipoTexto = input.nextInt();
                input.nextLine();

                if(escolhaTipoTexto > 5 || escolhaTipoTexto < 1){
                    System.out.println(traducao.getProperty("numeroInvalido"));
                }
            } while (escolhaTipoTexto > 5 || escolhaTipoTexto < 1);

            if(escolhaTipoTexto == 1){
                tipoTextoEscolhido = traducao.getProperty("tipoManualOperacao");
            }
            else if(escolhaTipoTexto == 2){
                tipoTextoEscolhido = traducao.getProperty("tipoProcedimentoSeguranca");
            }
            else if (escolhaTipoTexto == 3) {
                tipoTextoEscolhido = traducao.getProperty("tipoManutencaoReparo");
            }
            else if (escolhaTipoTexto == 4){
                tipoTextoEscolhido = traducao.getProperty("tipoTesteDiagnostico");
            }
            else {
                tipoTextoEscolhido = traducao.getProperty("tipoCondutaOperacoesSetoriais");
            }

            System.out.println(traducao.getProperty("comandoDigitoTitulo"));
            tituloDigitado = input.nextLine();

            System.out.println(traducao.getProperty("comandoDigitoConteudo"));
            conteudoDigitado = input.nextLine();

            orientacoes[quantidadeTexto] = new Orientacao(proximoId++, tipoTextoEscolhido, tituloDigitado, conteudoDigitado);
            quantidadeTexto++;

            do{
                System.out.println(traducao.getProperty("perguntaRepeticaoCadastro"));
                repeticaoCadastro = input.nextLine();

                if(!repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("negativo"))){
                    System.out.println(traducao.getProperty("respostaInvalida"));
                }

            }while(!repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("negativo")));
        }while(repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")));

    }

    public void pesquisarOrientacao(Scanner input, Tradutor traducao) {
        String repeticaoPesquisa;

        do {
            System.out.println(traducao.getProperty("perguntaPesquisaTipo"));
            int opcao = input.nextInt();
            input.nextLine();

            boolean encontrado = false;
            switch (opcao) {
                case 1:
                    System.out.println(traducao.getProperty("qualOrientacao"));
                    String titulo = input.nextLine();
                    for (int index = 0; index < quantidadeTexto; index++) {
                        if (orientacoes[index] != null && orientacoes[index].getTitulo().equalsIgnoreCase(titulo)) {
                            Orientacao orientacaoEncontrada = orientacoes[index];
                            exibirOrientacaoPesquisada(orientacaoEncontrada, traducao);
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println(traducao.getProperty("semOrientacao"));
                        break;
                    }

                    break;

                case 2:
                    System.out.println(traducao.getProperty("digitarID"));
                    int idDigitado = input.nextInt();
                    input.nextLine();
                    for(int index = 0; index< quantidadeTexto; index++) {
                        if (orientacoes[index].getId() == idDigitado) {
                            Orientacao orientacaoEncontrada = orientacoes[index];
                            exibirOrientacaoPesquisada(orientacaoEncontrada, traducao);
                            encontrado = true;
                        }
                    }

                    if (!encontrado){
                        System.out.println(traducao.getProperty("semID"));
                        break;
                    }

                    break;

                default:
                    System.out.println(traducao.getProperty("respostaInvalida"));
                    break;
            }
            do {
                System.out.println(traducao.getProperty("perguntaPesquisa"));
                repeticaoPesquisa = input.nextLine();

                if (!repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                    System.out.println(traducao.getProperty("invalida"));
                }
            } while (!repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("negativo")));
        } while (repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")));

    }
    
    public void editarOrientacao(Scanner input, Tradutor traducao) {
        if (!mostrarTextos(traducao)) {
            System.err.println(traducao.getProperty("semTextoEdicao"));
            return;
        }
        boolean editarMais = true;
        while (editarMais) {
            System.out.print(traducao.getProperty("digitarID"));
            int id = -1;
            if (input.hasNextInt()) {
                id = input.nextInt();
                input.nextLine(); 
            } else {
                System.err.println(traducao.getProperty("numeroInvalido"));
                input.nextLine(); 
                continue;
            }

            Orientacao orientacaoEncontrada = null;
            for (int i = 0; i < quantidadeTexto; i++) {
                if (orientacoes[i] != null && orientacoes[i].getId() == id) {
                    orientacaoEncontrada = orientacoes[i];
                    break;
                }
            }
            if (orientacaoEncontrada == null) {
                System.err.println(traducao.getProperty("semOrientacao"));
                continue;
            }

            exibirOrientacaoPesquisada(orientacaoEncontrada, traducao);

            boolean continuarEditando = true;
            while (continuarEditando) {
                System.out.println(traducao.getProperty("oQueEditar"));
                System.out.println("1 - " + traducao.getProperty("tipo"));
                System.out.println("2 - " + traducao.getProperty("titulo"));
                System.out.println("3 - " + traducao.getProperty("conteudo"));
                int opcaoEditar = -1;
                if (input.hasNextInt()) {
                    opcaoEditar = input.nextInt();
                    input.nextLine(); 
                } else {
                    System.err.println(traducao.getProperty("numeroInvalido"));
                    input.nextLine(); 
                    continue;
                }
                if (opcaoEditar < 1 || opcaoEditar > 3) {
                    System.err.println(traducao.getProperty("respostaInvalida"));
                    continue;
                }
                switch (opcaoEditar) {
                case 1:
                    System.out.println(traducao.getProperty("selecaoTipo"));
                    String resposta = input.nextLine().trim();
                    if (resposta.equalsIgnoreCase(traducao.getProperty("positivo"))) {
                       
                        System.out.println(traducao.getProperty("selecaoTipo"));
                        for (int i = 0; i < 1; i++) {
                            if (orientacoes[i] != null) {
                                System.out.println(traducao.getProperty("tipoOrientacao"));
                            }
                        }
                        System.out.print((traducao.getProperty("digitarIDTipo")));
                        int idTipoSelecionado = -1;
                        if (input.hasNextInt()) {
                            idTipoSelecionado = input.nextInt();
                            input.nextLine();
                        } else {
                            System.out.println(traducao.getProperty("numeroInvalido"));
                            input.nextLine();
                            break;
                        }
                       
                        boolean tipoEncontrado = false;
                        for (int i = 0; i < quantidadeTexto; i++) {
                            if (orientacoes[i] != null && orientacoes[i].getId() == idTipoSelecionado) {
                                orientacaoEncontrada.setTipo(orientacoes[i].getTipo());
                                tipoEncontrado = true;
                                System.out.println((traducao.getProperty("tipoSelecionado")) + orientacoes[i].getTipo());
                                break;
                            }
                        }
                        if (!tipoEncontrado) {
                            System.out.println("ID inválido. Nenhum tipo alterado.");
                        }
                    } else if (resposta.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                        System.out.println(traducao.getProperty("adicionarTipo"));
                        String novoTipo = input.nextLine();
                        orientacaoEncontrada.setTipo(novoTipo);
                    } else {
                        System.out.println(traducao.getProperty("respostaInvalida"));
                    }
                    break;

                    case 2:
                        System.out.println(traducao.getProperty("titulo"));
                        orientacaoEncontrada.setTitulo(input.nextLine());
                        break;
                    case 3:
                        System.out.println(traducao.getProperty("conteudo"));
                        orientacaoEncontrada.setConteudo(input.nextLine());
                        break;
                }

                do {
                    System.out.println(traducao.getProperty("continuarEditar"));
                    String resposta = input.nextLine().trim();
                    if (resposta.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                        continuarEditando = false;
                        break;
                    } else if (resposta.equalsIgnoreCase(traducao.getProperty("positivo"))) {
                        continuarEditando = true;
                        break;
                    } else {
                        System.err.println(traducao.getProperty("respostaInvalida"));
                    }
                } while (true);
            }

            do {
                System.out.println(traducao.getProperty("editarOutra"));
                String resposta = input.nextLine().trim();
                if (resposta.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                    editarMais = false;
                    break;
                } else if (resposta.equalsIgnoreCase(traducao.getProperty("positivo"))) {
                    editarMais = true;
                    break;
                } else {
                    System.err.println(traducao.getProperty("respostaInvalida"));
                }
            } while (true);
        }
    }
    
    public void excluirOrientacao(Scanner input, Tradutor traducao) {

        String repeticaoExclusao;

        do {

            if(!mostrarTextos(traducao)) {
                System.out.println(traducao.getProperty("semTextoExclusao"));
                return;
            }

            System.out.println(traducao.getProperty("digitarTextoExclusao"));
            int idDigitado = input.nextInt();
            input.nextLine();

            boolean encontrado = false;
            for(int index = 0; index < quantidadeTexto; index++){
                if (orientacoes[index] != null && orientacoes[index].getId() == idDigitado) {

                    orientacoes[quantidadeTexto] = null;

                    for(int indiceDeslocamento = index; indiceDeslocamento < quantidadeTexto - 1; indiceDeslocamento++) {
                        orientacoes[indiceDeslocamento] = orientacoes[indiceDeslocamento + 1];
                    }
                    orientacoes[quantidadeTexto - 1] = null;
                    quantidadeTexto--;

                    System.out.println(traducao.getProperty("sucessoExcluir"));
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado){
                System.out.println(traducao.getProperty("textoNãoExiste"));
            }
            do {
                System.out.println(traducao.getProperty("querExcluir"));
                repeticaoExclusao = input.nextLine();

                if(!repeticaoExclusao.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoExclusao.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                    System.out.println(traducao.getProperty("respostaInvalida"));
                }

            }while(!repeticaoExclusao.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoExclusao.equalsIgnoreCase(traducao.getProperty("negativo")));

        } while (repeticaoExclusao.equalsIgnoreCase(traducao.getProperty("positivo")));

    }

    public boolean mostrarTextos(Tradutor traducao){

        boolean presencaTexto = false;

        int index = 0;


        while(index < quantidadeTexto){

            if(orientacoes[index] != null){
                System.out.println("ID " + (orientacoes[index].getId()) + " -");
                System.out.println(traducao.getProperty("titulo") + " " + orientacoes[index].getTitulo() + "\n");
                System.out.println(traducao.getProperty("conteudo") + " "+ orientacoes[index].getConteudo() + "\n");
                System.out.println(traducao.getProperty("tipo") + " " + orientacoes[index].getTipo() + "\n");
                System.out.println("----------------------------------------------");
                presencaTexto = true;
            }

            index++;
        }

        if(presencaTexto == false) {
            System.out.println(traducao.getProperty("semRegistro"));
        }

        return presencaTexto;
    }

    public static void exibirOrientacaoPesquisada(Orientacao orientacaoEncontrada, Tradutor traducao){
        System.out.println(traducao.getProperty("orientacaoEncontrada"));
        System.out.println("ID " + orientacaoEncontrada.getId());
        System.out.println(traducao.getProperty("titulo") + orientacaoEncontrada.getTitulo());
        System.out.println(traducao.getProperty("conteudo") + orientacaoEncontrada.getConteudo());
        System.out.println(traducao.getProperty("tipo")+ orientacaoEncontrada.getTipo());
        System.out.println("----------------------------------------------");
    }
}
