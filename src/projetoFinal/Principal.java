
package projetoFinal;

import java.util.Scanner;

public class Principal {

	static int ids[] = new int[100];
	static String tituloTexto[] = new String[100];
	static String conteudoTexto[] = new String[100];
	static String tipoTextoEscolhido[] = new String[100];
	static int index;
	static int quantidadeTexto = 0;
	static int proximoId = 1;
	
	
	
	public static void main(String [] args) {       

		Scanner input = new Scanner(System.in);
		/*Texto[] textos = new Texto [100];

        // Método construtor
        Texto texto1 = new Texto("Português", "Manual de operação", "titulo1", "conteudo1" );
        textos[0] = texto1;*/

		System.out.println("┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("│I8,        8        ,8I  88888888888  ,ad8888ba,           ,ad8888ba,                                   │");
		System.out.println("│ 8b       d8b       d8   88          d8        8b         d8        8b                                  │");
		System.out.println("│  8,     ,8 8,     ,8    88         d8'                  d8'        `8b                                 │");
		System.out.println("│  Y8     8P Y8     8P    88aaaaaa   88                   88          88  8b,dPPYba,    ,adPPYba,        │");
		System.out.println("│  `8b   d8' `8b   d8'    88         88      88888        88          88  88P'     8a  a8P_____88        │");
		System.out.println("│   `8a a8'   `8a a8'     88         Y8,        88        Y8,        ,8P  88       88  8PP               │");
		System.out.println("│    `8a8'     `8a8'      88          Y8a.    .a88         Y8a.    .a8P   88       88   8b   ,aa         │");
		System.out.println("│      8         8        88888888888  `AY88888P              Y8888Y      88       88     Ybbd8          │");
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────┘");

		String idioma = null;
		int lingua;
		do {
			
			System.out.println("	PT-BR----Antes de começar,adicione seu idioma!(1)(escolha o número representante dessa língua)");
			System.out.println("	ES-------¡Antes de empezar, añade tu idioma!(2)(Elige el número que representa este idioma.)");
			System.out.println("	EN-USA---Before you start, add your language!(3)(Choose the number that represents this language.)");
			System.out.println("	DIE------Bevor Sie beginnen, fügen Sie Ihre Sprache hinzu!(4)(Wähle die Zahl, die diese Sprache repräsentiert.)");
			lingua=input.nextInt();

		
			switch(lingua){

			case 1:
				System.out.println("Língua escolhida com sucesso!");
				idioma = "pt";
				break;
			case 2:
				System.out.println("¡Idioma seleccionado con éxito!");
				idioma="es";
				break;
			case 3:
				System.out.println("Language selected successfully!");
				idioma = "en";
				break;
			case 4:
				System.out.println("Sprache erfolgreich ausgewählt!");
				idioma = "de";
				break;

			default:
				System.out.println("Idioma indisponível");
				break;			
			}

		}while(lingua > 4);
		Tradutor traducao = Tradutor.getInstance(idioma);

		String tipoTexto[] = { "Manual de operação", "Procedimentos de segurança", "Manutenção e reparos", "Testes e diagnósticos", "Manual de conduta e Operações Setoriais" };
		String opcoesMenu[] = { "Cadastrar Orientação", "Pesquisar Orientação", "Editar Orientação", "Excluir Orientação", "Sair" };
		int escolhaNumero;
		int selecao = 0;
		do {
			
				
			// Exibe o menu principal
			System.out.println(traducao.getProperty("menu"));

			escolhaNumero = input.nextInt();
			input.nextLine(); // Limpa o buffer do Scanner

			switch (escolhaNumero) {
			case 1:
				// Cadastrar Orientação

				cadastrarOrientacao(input, tipoTexto, traducao);
				break;
			case 2:
				// Pesquisar Orientação
				pesquisarOrientacao(input, tituloTexto, traducao);

				break;
			case 3:
				// Editar Orientação
				System.out.println("Funcionalidade em manutenção!");
				break;
			case 4:
				// Excluir Orientação
				System.out.println(traducao.getProperty("listagemTextos"));
				

				excluirOrientacao(input,traducao);
				break;
			case 5:
			do{
            System.out.println(traducao.getProperty("tipoOrientacao"));
        	selecao = input.nextInt();
            if (selecao==1){
				System.out.print("1-");
                     System.out.println(traducao.getProperty("mo1Titulo"));
					 System.out.print("2-");
                    System.out.println(traducao.getProperty("mo2Titulo"));
                    selecao = input.nextInt();
                    if (selecao==1){
                        System.out.println(traducao.getProperty("mo1Conteudo"));
                    }
					else if (selecao==2){
						System.out.println(traducao.getProperty("mo2Conteudo"));
					}else {
						System.out.println(traducao.getProperty("numeroInvalido"));
						break;
					}
            }
			else if(selecao==2){
				System.out.print("1-");
					System.out.println(traducao.getProperty("ps1Titulo"));
					System.out.print("2-");
                    System.out.println(traducao.getProperty("ps2Titulo"));
                    selecao = input.nextInt();
                    if (selecao==1){
                       System.out.println(traducao.getProperty("ps1Conteudo"));
                    }
					else if (selecao==2){
						System.out.println(traducao.getProperty("ps2Conteudo"));
					}else {
						System.out.println(traducao.getProperty("numeroInvalido"));
						break;
					}
			}
			else if(selecao==3){
				System.out.print("1-");
					System.out.println(traducao.getProperty("mr1Titulo"));
					System.out.print("2-");
                    System.out.println(traducao.getProperty("mr2Titulo"));
                    selecao = input.nextInt();
                    if (selecao==1){
                        System.out.println(traducao.getProperty("mr1Conteudo"));
                    }
					else if (selecao==2){
						System.out.println(traducao.getProperty("mr2Conteudo"));
					}else {
						System.out.println(traducao.getProperty("numeroInvalido"));
						break;
					}
			}
			else if(selecao==4){
				System.out.print("1-");
					System.out.println(traducao.getProperty("td1Titulo"));
					System.out.print("2-");
                    System.out.println(traducao.getProperty("td2Titulo"));
                    selecao = input.nextInt();
                    if (selecao==1){
                       System.out.println(traducao.getProperty("td1Conteudo"));
                    }
					else if (selecao==2){
						System.out.println(traducao.getProperty("td2Conteudo"));
					}else {
						System.out.println(traducao.getProperty("numeroInvalido"));
						break;
					}
			}
			else if(selecao==5){
					System.out.print("1-");
					System.out.println(traducao.getProperty("mcos1Titulo"));
					System.out.print("2-");
                    System.out.println(traducao.getProperty("mcos2Titulo"));
                    selecao = input.nextInt();
                    if (selecao==1){
                        System.out.println(traducao.getProperty("mcos1Conteudo"));
                    }
					else if (selecao==2){
						System.out.println(traducao.getProperty("mcos2Conteudo"));
					}else {
						System.out.println(traducao.getProperty("numeroInvalido"));
						break;
					}
			}
			break; 
			}while( selecao != 5);
			break;
				case 6:

					System.out.println(traducao.getProperty("encerramento"));
					break;

				default:

					System.out.println(traducao.getProperty("numeroInvalido"));
					break;
				}

		
	}while(escolhaNumero != 6);
	}

	// Método para cadastrar uma nova orientação
	private static void cadastrarOrientacao(Scanner input, String[] tipoTexto, Tradutor traducao) {
		String repeticaoCadastro;
		int escolhaTipoTexto;

		String tituloDigitado;
		String conteudoDigitado;

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
				tipoTextoEscolhido[index] = traducao.getProperty("tipoManualOperacao");
			}
			else if(escolhaTipoTexto == 2){
				tipoTextoEscolhido[index] = traducao.getProperty("tipoProcedimentoSeguranca");
			}
			else if (escolhaTipoTexto == 3) {
				tipoTextoEscolhido[index] = traducao.getProperty("tipoManutencaoReparo");
			}
			else if (escolhaTipoTexto == 4){
				tipoTextoEscolhido[index] = traducao.getProperty("tipoTesteDiagnostico");
			}
			else if(escolhaTipoTexto == 5){
				tipoTextoEscolhido[index] = traducao.getProperty("tipoCondutaOperacoesSetoriais");
			}

			System.out.println(traducao.getProperty("comandoDigitoTitulo"));
			tituloDigitado = input.nextLine();
			tituloTexto[quantidadeTexto] = tituloDigitado;

			tituloTexto[quantidadeTexto] = tituloDigitado;

			System.out.println(traducao.getProperty("comandoDigitoConteudo"));
			conteudoDigitado = input.nextLine();
			conteudoTexto[quantidadeTexto] = conteudoDigitado;
			
			ids[quantidadeTexto] = proximoId++;
			quantidadeTexto++;

			do{
				System.out.println(traducao.getProperty("perguntaRepeticaoCadastro"));
				repeticaoCadastro = input.nextLine();

				if(repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo"))){
					index++;
				}

				if(!repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("negativo"))){
					System.out.println(traducao.getProperty("respostaInvalida"));
				}

			}while(!repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("negativo")));
		}while(repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")));

	}

	private static void pesquisarOrientacao(Scanner input, String tituloTexto[],Tradutor traducao) {
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
				for (int i = 0; i < tituloTexto.length; i++) {
					if (tituloTexto[i] != null && tituloTexto[i].equalsIgnoreCase(titulo)) {
						System.out.println(traducao.getProperty("orientacaoEncontrada"));
						System.out.println("ID " + ids[i]);
						System.out.println(traducao.getProperty("titulo") + tituloTexto[i]);
						System.out.println(traducao.getProperty("conteudo") + conteudoTexto[i]);
						System.out.println(traducao.getProperty("tipo")+ tipoTextoEscolhido[i]);
						System.out.println("----------------------------------------------");
						encontrado = true;
					}
				}

				if (!encontrado) {
					System.out.println(traducao.getProperty("semOrientacao"));
				}

				break;

			case 2:
				System.out.println(traducao.getProperty("digitarID"));
				int id = input.nextInt();
				input.nextLine();
				encontrado = false;
				for(int i = 0; i< quantidadeTexto; i++) {
					if (ids[i] == id) {
						System.out.println(traducao.getProperty("orientacaoEncontrada"));
						System.out.println("ID " + ids[i]);
						System.out.println(traducao.getProperty("titulo") + tituloTexto[i]);
						System.out.println(traducao.getProperty("conteudo") + conteudoTexto[i]);
						System.out.println(traducao.getProperty("tipo")+ tipoTextoEscolhido[i]);
						System.out.println("----------------------------------------------");
						encontrado = true;
						break;
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

				if (!repeticaoPesquisa.equalsIgnoreCase("positivo") && !repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("negativo"))) {
					System.out.println(traducao.getProperty("invalida"));
				}
			} while (!repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("negativo")));
		} while (repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")));

	}

	private static void excluirOrientacao(Scanner input,Tradutor traducao) {

		String repeticaoExclusao;

		do {
			
			if(!mostrarTextos(traducao)) {
				System.out.println(traducao.getProperty("semTextoExclusao"));
	            return;

			}
			
			System.out.println(traducao.getProperty("digitarTextoExclusao"));
			int idDigitado = input.nextInt();
			input.nextLine();
			
			index = idDigitado - 1;

			if (tituloTexto[index] != null && conteudoTexto[index] != null && tipoTextoEscolhido[index] != null) {

				tituloTexto[index] = null;
				conteudoTexto[index] = null;
				tipoTextoEscolhido[index] = null;

				System.out.println(traducao.getProperty("sucessoExcluir"));
				
				for(int indiceDeslocamento = index; indiceDeslocamento < quantidadeTexto - 1; indiceDeslocamento++) {
					tituloTexto[indiceDeslocamento] = tituloTexto[indiceDeslocamento + 1];
					conteudoTexto[indiceDeslocamento] = conteudoTexto[indiceDeslocamento + 1];
					tipoTextoEscolhido[indiceDeslocamento] = tipoTextoEscolhido[indiceDeslocamento + 1];
					ids[indiceDeslocamento] = ids[indiceDeslocamento + 1];
				}
				tituloTexto[quantidadeTexto - 1] = null;
				conteudoTexto[quantidadeTexto - 1] = null;
				tipoTextoEscolhido[quantidadeTexto - 1] = null;
				ids[quantidadeTexto - 1] = 0;
				quantidadeTexto--;
				
			}

			else {
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


	static boolean mostrarTextos(Tradutor traducao){
		
		boolean presencaTexto = false;
		
		index = 0;
		
		while(index < tituloTexto.length && index < conteudoTexto.length && index < tipoTextoEscolhido.length){

			if(tituloTexto[index] != null && conteudoTexto[index] != null && tipoTextoEscolhido[index] != null){
				System.out.println(traducao.getProperty("espaco") + (index + 1) + "\n");
				System.out.println(traducao.getProperty("ID") + (ids[index]) + " -");
				System.out.println(traducao.getProperty("tipo") + tituloTexto[index]);
				System.out.println(traducao.getProperty("conteudo") + conteudoTexto[index]);
				System.out.println(traducao.getProperty("tipo") + tipoTextoEscolhido[index]);
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

}
