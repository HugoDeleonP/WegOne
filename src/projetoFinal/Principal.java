package projetoFinal;
import java.util.Scanner;
public class Principal {
	Scanner imput=new Scanner(System.in);
	public static void main(String [] args) {



		System.out.println("	┌────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("	│I8,        8        ,8I  88888888888  ,ad8888ba,           ,ad8888ba,                                   │");
		System.out.println("	│ 8b       d8b       d8   88          d8        8b         d8        8b                                  │");
		System.out.println("	│  8,     ,8 8,     ,8    88         d8'                  d8'        `8b                                 │");
		System.out.println("	│  Y8     8P Y8     8P    88aaaaaa   88                   88          88  8b,dPPYba,    ,adPPYba,        │");
		System.out.println("	│  `8b   d8' `8b   d8'    88         88      88888        88          88  88P'     8a  a8P_____88        │");
		System.out.println("	│   `8a a8'   `8a a8'     88         Y8,        88        Y8,        ,8P  88       88  8PP               │");
		System.out.println("	│    `8a8'     `8a8'      88          Y8a.    .a88         Y8a.    .a8P   88       88   8b   ,aa         │");
		System.out.println("	│      8         8        88888888888  `AY88888P              Y8888Y      88       88     Ybbd8          │");
		System.out.println("	└────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
		System.out.println("");


    static String tituloTexto[] = new String[100];
    static String conteudoTexto[] = new String[100];
    static String tipoTextoEscolhido[] = new String[100];
    static int index;

    public static void main(String[] args) {
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

		System.out.println("	PT-BR----Antes de começar,adicione seu idioma!(1)(escolha o número representante dessa língua)");
		System.out.println("	ES-------¡Antes de empezar, añade tu idioma!(2)(Elige el número que representa este idioma.)");
		System.out.println("	EN-USA---Before you start, add your language!(3)(Choose the number that represents this language.)");
		System.out.println("	DIE------Bevor Sie beginnen, fügen Sie Ihre Sprache hinzu!(4)(Wähle die Zahl, die diese Sprache repräsentiert.)");
		int lingua=imput.nextInt();

		switch(lingua){

			case 1:
				System.out.println("Língua escolhida com sucesso!");
				break;
			case 2:
				System.out.println("¡Idioma seleccionado con éxito!");
				break;
			case 3:
				System.out.println("Language selected successfully!");
				break;
			case 4:
				System.out.println("Sprache erfolgreich ausgewählt!");


		}

	}
		String tipoTexto[] = {"Manual de operação", "Procedimentos de segurança", "Manutenção e reparos", "Testes e diagnósticos", "Manual de conduta e Operações Setoriais"};
        String opcoesMenu[] = {"Cadastrar Orientação", "Pesquisar Orientação", "Editar Orientação", "Excluir Orientação", "Sair"};
        int escolhaNumero;

        do {
            // Exibe o menu principal
            for (int contador = 0; contador < opcoesMenu.length; contador++) {
                System.out.print((contador + 1)  + "- ");
                System.out.println(opcoesMenu[contador]);
            }

            escolhaNumero = input.nextInt();
            input.nextLine(); // Limpa o buffer do Scanner

            switch(escolhaNumero){
                case 1:
                    // Cadastrar Orientação

                    cadastrarOrientacao(input, tipoTexto);
                    break;
                case 2:
                    // Pesquisar Orientação

                    break;
                case 3:
                    // Editar Orientação

                    break;
                case 4:
                    // Excluir Orientação
                	System.out.println("Segue todos os textos registrados: \n");
                	mostrarTextos();

                	excluirOrientacao(input);
                    break;

                case 5:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println("Número inválido.");
                    break;
            }

        } while (escolhaNumero != 5);

    }

    // Método para cadastrar uma nova orientação
    private static void cadastrarOrientacao(Scanner input, String[] tipoTexto) {
		String repeticaoCadastro;
		int escolhaTipoTexto;

		index = 0;

        String tituloDigitado;
        String conteudoDigitado;

        do{
            do{
                for(int contador = 0; contador < 5; contador++) {

                    System.out.print((contador+1) + "- ");
                    System.out.println(tipoTexto[contador]);
                }

                escolhaTipoTexto = input.nextInt();
                input.nextLine();

                if(escolhaTipoTexto > 5 || escolhaTipoTexto < 1){
                    System.out.println("Número inválido");
                }
            }while(escolhaTipoTexto > 5 || escolhaTipoTexto < 1);

            if(escolhaTipoTexto == 1){
                tipoTextoEscolhido[index] = "Manual de operação";
            }
            else if(escolhaTipoTexto == 2){
                tipoTextoEscolhido[index] = "Procedimentos de segurança";
            }
            else if (escolhaTipoTexto == 3) {
                tipoTextoEscolhido[index] = "Manutenção e reparos";
            }
            else if (escolhaTipoTexto == 4){
                tipoTextoEscolhido[index] = "Testes e diagnósticos";
            }
            else if(escolhaTipoTexto == 5){
                tipoTextoEscolhido[index] = "Manual de conduta e Operações Setoriais";
            }

            System.out.println("Digite o título: ");
            tituloDigitado = input.nextLine();

            tituloTexto[index] = tituloDigitado;

            System.out.println("Digite o conteúdo: ");
            conteudoDigitado = input.nextLine();

            conteudoTexto[index] = conteudoDigitado;

            do{
                System.out.println("Pretende cadastrar mais orientações?(Sim/Não)");
                repeticaoCadastro = input.nextLine();

                if(repeticaoCadastro.equalsIgnoreCase("Sim")){
                    index++;
                }

                if(!repeticaoCadastro.equalsIgnoreCase("Sim") && !repeticaoCadastro.equalsIgnoreCase("Não")){
                    System.out.println("Resposta inválida");
                }

            }while(!repeticaoCadastro.equalsIgnoreCase("Sim") && !repeticaoCadastro.equalsIgnoreCase("Não"));
        }while(repeticaoCadastro.equalsIgnoreCase("Sim"));

    }

    private static void excluirOrientacao(Scanner input) {

    	String repeticaoExclusao;

    	do {
	        	System.out.println("Digite o id da orientação que deseja excluir: ");
	        	int idDigitado = input.nextInt();
	        	input.nextLine();

	        	index = idDigitado - 1;

            	if(tituloTexto[index] != null && conteudoTexto[index] != null && tipoTextoEscolhido[index] != null) {

            		tituloTexto[index] = null;
            		conteudoTexto[index] = null;
            		tipoTextoEscolhido[index] = null;

            		System.out.println("O texto foi excluído com sucesso!");
            	}

            	else if(tituloTexto[index] == null && conteudoTexto[index] == null && tipoTextoEscolhido[index] == null){
            		System.out.println("O texto não existe.");
            	}



        	do {
	        	System.out.println("Gostaria de excluir outro texto?(Sim/Não)");
	        	repeticaoExclusao = input.nextLine();

	        	if(repeticaoExclusao.equalsIgnoreCase("Não")) {
	        		break;
	        	}

	        	if(!repeticaoExclusao.equalsIgnoreCase("Sim") && !repeticaoExclusao.equalsIgnoreCase("Não")) {
	        		System.out.println("Resposta inválida");
	        	}

        	}while(!repeticaoExclusao.equalsIgnoreCase("Sim") && !repeticaoExclusao.equalsIgnoreCase("Não"));

    	}while(repeticaoExclusao.equalsIgnoreCase("Sim"));

    }


    static void mostrarTextos(){

    	index = 0;
    	int verificacaoListaVazia = 0;

        while(index < tituloTexto.length && index < conteudoTexto.length && index < tipoTextoEscolhido.length){

            if(tituloTexto[index] != null && conteudoTexto[index] != null && tipoTextoEscolhido[index] != null){
                System.out.println("ID " + (index + 1) + " -");
                System.out.println("Título: " + tituloTexto[index]);
                System.out.println("Conteúdo: " + conteudoTexto[index]);
                System.out.println("Tipo: " + tipoTextoEscolhido[index]);
                System.out.println("----------------------------------------------");
            }

            else {
            	verificacaoListaVazia++;
            }

            if(verificacaoListaVazia == 100) {
            	System.out.println("Não há texto registrado.");
            }
            index++;
        }
    }

}