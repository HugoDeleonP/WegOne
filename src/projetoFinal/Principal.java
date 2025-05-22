
package projetoFinal;

import java.util.Scanner;

public class Principal {

	static int ids[] = new int[100];
	static String tituloTexto[] = new String[100];
	static String conteudoTexto[] = new String[100];
	static String tipoTextoEscolhido[] = new String[100];
	static int index = 0;
	static int quantidadeTexto = 0;
	static int proximoId = 1;
	
	public static void main(String [] args) {       

		Scanner input = new Scanner(System.in);
		
		Orientacao managerOrientacao = new Orientacao();

        // Método construtor
        /*Texto[] textos = new Texto [100];
        
        Texto textoPredefinido = new Texto(traducao.getProperty("tipoManualOperacao"), traducao.getProperty("mo1Titulo"), traducao.getProperty("mo1Conteudo"));
        textos[0] = textoPredefinido;
        */

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
		
		tituloTexto[0] = traducao.getProperty("mo1Titulo");
		conteudoTexto[0] = traducao.getProperty("mo1Conteudo");
		tipoTextoEscolhido[0] = traducao.getProperty("tipoManualOperacao");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;
		
		tituloTexto[1] = traducao.getProperty("mo2Titulo");
		conteudoTexto[1] = traducao.getProperty("mo2Conteudo");
		tipoTextoEscolhido[1] = traducao.getProperty("tipoManualOperacao");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		
		tituloTexto[2] = traducao.getProperty("ps1Titulo");
		conteudoTexto[2] = traducao.getProperty("ps1Conteudo");
		tipoTextoEscolhido[2] = traducao.getProperty("tipoProcedimentoSeguranca");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[3] = traducao.getProperty("ps2Titulo");
		conteudoTexto[3] = traducao.getProperty("ps2Conteudo");
		tipoTextoEscolhido[3] = traducao.getProperty("tipoProcedimentoSeguranca");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[4] = traducao.getProperty("mr1Titulo");
		conteudoTexto[4] = traducao.getProperty("mr1Conteudo");
		tipoTextoEscolhido[4] = traducao.getProperty("tipoManutencaoReparo");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[5] = traducao.getProperty("mr2Titulo");
		conteudoTexto[5] = traducao.getProperty("mr2Conteudo");
		tipoTextoEscolhido[5] = traducao.getProperty("tipoManutencaoReparo");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[6] = traducao.getProperty("td1Titulo");
		conteudoTexto[6] = traducao.getProperty("td1Conteudo");
		tipoTextoEscolhido[6] = traducao.getProperty("tipoTesteDiagnostico");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[7] = traducao.getProperty("td2Titulo");
		conteudoTexto[7] = traducao.getProperty("td2Conteudo");
		tipoTextoEscolhido[7] = traducao.getProperty("tipoTesteDiagnostico");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[8] = traducao.getProperty("mcos1Titulo");
		conteudoTexto[8] = traducao.getProperty("mcos1Conteudo");
		tipoTextoEscolhido[8] = traducao.getProperty("tipoCondutaOperacoesSetoriais");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		tituloTexto[9] = traducao.getProperty("mcos2Titulo");
		conteudoTexto[9] = traducao.getProperty("mcos2Conteudo");
		tipoTextoEscolhido[9] = traducao.getProperty("tipoCondutaOperacoesSetoriais");
		ids[quantidadeTexto] = proximoId++;
		quantidadeTexto++;
		index++;

		int escolhaNumero;
		do {
			// Exibe o menu principal
			System.out.println(traducao.getProperty("menu"));

			escolhaNumero = input.nextInt();
			input.nextLine(); // Limpa o buffer do Scanner

			switch (escolhaNumero) {
			case 1:
				// Cadastrar Orientação

				managerOrientacao.cadastrarOrientacao(input, tipoTexto, traducao);
				break;
			case 2:
				// Pesquisar Orientação
				managerOrientacao.pesquisarOrientacao(input, tituloTexto, traducao);

				break;
			case 3:
				// Editar Orientação
				System.out.println("Funcionalidade em manutenção!");
				break;
			case 4:
				// Excluir Orientação
				System.out.println(traducao.getProperty("listagemTextos"));
				managerOrientacao.excluirOrientacao(input,traducao);
				break;
			case 5:

				System.out.println(traducao.getProperty("encerramento"));
				return;

			default:

				System.out.println(traducao.getProperty("numeroInvalido"));
				break;
				}

		
		}while(escolhaNumero != 6);
	}

	public boolean mostrarTextos(Tradutor traducao){
	
	boolean presencaTexto = false;
	
	index = 0;
	
	while(index < tituloTexto.length && index < conteudoTexto.length && index < tipoTextoEscolhido.length){

		if(tituloTexto[index] != null && conteudoTexto[index] != null && tipoTextoEscolhido[index] != null){
			System.out.println(traducao.getProperty("espaco") + " "  + (index + 1) + "\n");
			System.out.println("ID " + (ids[index]) + " -");
			System.out.println(traducao.getProperty("titulo") + " " + tituloTexto[index] + "\n");
			System.out.println(traducao.getProperty("conteudo") + " "+ conteudoTexto[index] + "\n");
			System.out.println(traducao.getProperty("tipo") + " " + tipoTextoEscolhido[index] + "\n");
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