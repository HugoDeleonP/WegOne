
package projetoFinal;

import java.util.Scanner;

public class Principal {

	static Orientacao orientacoes[] = new Orientacao[100];

	static int index = 0;
	static int quantidadeTexto = 0;
	static int proximoId = 1;
	
	public static void main(String [] args) {       

		Scanner input = new Scanner(System.in);

		Orientacao managerOrientacao = new Orientacao();

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

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoManualOperacao"), traducao.getProperty("mo1Titulo"), traducao.getProperty("mo1Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoManualOperacao"), traducao.getProperty("mo2Titulo"), traducao.getProperty("mo2Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoProcedimentoSeguranca"), traducao.getProperty("ps1Titulo"), traducao.getProperty("ps1Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoProcedimentoSeguranca"), traducao.getProperty("ps2Titulo"), traducao.getProperty("ps2Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoManutencaoReparo"), traducao.getProperty("mr1Titulo"), traducao.getProperty("mr1Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoManutencaoReparo"), traducao.getProperty("mr2Titulo"), traducao.getProperty("mr2Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoTesteDiagnostico"), traducao.getProperty("td1Titulo"), traducao.getProperty("td1Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoTesteDiagnostico"), traducao.getProperty("td2Titulo"), traducao.getProperty("td2Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoCondutaOperacoesSetoriais"), traducao.getProperty("mcos1Titulo"), traducao.getProperty("mcos1Conteudo") );
		quantidadeTexto++;
		index++;

		orientacoes[quantidadeTexto] = new Orientacao(proximoId++, traducao.getProperty("tipoCondutaOperacoesSetoriais"), traducao.getProperty("mcos2Titulo"), traducao.getProperty("mcos2Conteudo") );
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

				managerOrientacao.cadastrarOrientacao(input, orientacoes, traducao, index, quantidadeTexto, proximoId);
				break;
			case 2:
				// Pesquisar Orientação
				managerOrientacao.pesquisarOrientacao(input, orientacoes, traducao, index, quantidadeTexto, proximoId);

				break;
			case 3:
				// Editar Orientação
				System.out.println("Funcionalidade em manutenção!");
				break;
			case 4:
				// Excluir Orientação
				System.out.println(traducao.getProperty("listagemTextos"));
				managerOrientacao.excluirOrientacao(input, orientacoes, traducao, index, quantidadeTexto, proximoId);
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
}