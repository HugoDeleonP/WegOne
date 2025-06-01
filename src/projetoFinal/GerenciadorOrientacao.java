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
        int index;
        
        if (!mostrarTextos(traducao)) {
            System.out.println(traducao.getProperty("semTextoEdicao"));
            return;
        }
        boolean editarMais = true;
        while (editarMais) {
            System.out.print(traducao.getProperty("digitarID"));
            int id;
            if (input.hasNextInt()) {
                id = input.nextInt();
                input.nextLine(); 
            } else {
                System.out.println(traducao.getProperty("numeroInvalido"));
                input.nextLine(); 
                continue;
            }

            Orientacao orientacaoEncontrada = null;
            for (index = 0; index < quantidadeTexto; index++) {
                if (orientacoes[index] != null && orientacoes[index].getId() == id) {
                    orientacaoEncontrada = orientacoes[index];
                    break;
                }
            }
            if (orientacaoEncontrada == null) {
                System.out.println(traducao.getProperty("semOrientacao"));
                continue;
            }

            exibirOrientacaoPesquisada(orientacaoEncontrada, traducao);

            boolean continuarEditando = true;
            while (continuarEditando) {
                System.out.println(traducao.getProperty("oQueEditar"));
                System.out.println("1 - " + traducao.getProperty("tipo"));
                System.out.println("2 - " + traducao.getProperty("titulo"));
                System.out.println("3 - " + traducao.getProperty("conteudo"));
                int opcaoEditar;
                if (input.hasNextInt()) {
                    opcaoEditar = input.nextInt();
                    input.nextLine(); 
                } else {
                    System.out.println(traducao.getProperty("numeroInvalido"));
                    input.nextLine(); 
                    continue;
                }
                if (opcaoEditar < 1 || opcaoEditar > 3) {
                    System.out.println(traducao.getProperty("respostaInvalida"));
                    continue;
                }
                switch (opcaoEditar) {
                case 1:
                    String tipoTextoEscolhido = "";

                    System.out.println(traducao.getProperty("tipoOrientacao"));
                    int escolhaTipoTexto = input.nextInt();
                    input.nextLine();

                    while (escolhaTipoTexto <= 5 && escolhaTipoTexto >= 1) {
                        
                        if (escolhaTipoTexto > 5 && escolhaTipoTexto < 1) {
                            System.out.println(traducao.getProperty("numeroInvalido"));
                        }

                        if (escolhaTipoTexto == 1) {
                            tipoTextoEscolhido = traducao.getProperty("tipoManualOperacao");
                        } else if (escolhaTipoTexto == 2) {
                            tipoTextoEscolhido = traducao.getProperty("tipoProcedimentoSeguranca");
                        } else if (escolhaTipoTexto == 3) {
                            tipoTextoEscolhido = traducao.getProperty("tipoManutencaoReparo");
                        } else if (escolhaTipoTexto == 4) {
                            tipoTextoEscolhido = traducao.getProperty("tipoTesteDiagnostico");
                        } else {
                            tipoTextoEscolhido = traducao.getProperty("tipoCondutaOperacoesSetoriais");
                        }

                        break;
                    }
                    orientacaoEncontrada.setTipo(tipoTextoEscolhido);

                    break;

                    case 2:
                        System.out.println(traducao.getProperty("titulo"));
                        orientacaoEncontrada.setTitulo(input.nextLine());
                        break;
                    case 3:
                        System.out.println(traducao.getProperty("conteudo"));
                        orientacaoEncontrada.setConteudo(input.nextLine());
                        break;

                    default:
                        System.out.println("respostaInvalida");
                        break;
                }

                do {
                    System.out.println(traducao.getProperty("continuarEditar"));
                    String resposta = input.nextLine().trim();
                    if (resposta.equalsIgnoreCase(traducao.getProperty("negativo"))) {
                        continuarEditando = false;
                        break;
                    } else if (resposta.equalsIgnoreCase(traducao.getProperty("positivo"))) {
                        break;
                    } else {
                        System.out.println(traducao.getProperty("respostaInvalida"));
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
                    if (!mostrarTextos(traducao)) {
                        System.out.println(traducao.getProperty("semTextoEdicao"));
                        return;
                    }
                    editarMais = true;
                    break;
                } else {
                    System.out.println(traducao.getProperty("respostaInvalida"));
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

        if(!presencaTexto) {
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
