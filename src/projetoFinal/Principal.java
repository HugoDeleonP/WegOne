package projetoFinal;

import java.util.Scanner;

public class Principal {

    static String tituloTexto[] = new String[100];
    static String conteudoTexto[] = new String[100];
    static String tipoTextoEscolhido[] = new String[100];
    
    
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
                	
                	System.out.println("Segue todos os textos registrados: ");
                	mostrarTextos();
                	
                    cadastrarOrientacao(input, tipoTexto);
                    
                    System.out.println("");
                    break;
                case 2:
                    // Pesquisar Orientação
                    break;
                case 3:
                    // Editar Orientação
                    break;
                case 4:
                    // Excluir Orientação
                    break;

                case 5:

                    System.out.println("Programa encerrado.");
                    break;

                default:

                    System.out.println("Número inválido.");
                    break;
            }

        } while (escolhaNumero != 5);

        String mostrarTexto;

        do{
            System.out.println("Gostaria de ter acesso a todos os textos? (Sim/Não)");
            mostrarTexto = input.nextLine();

            if(!mostrarTexto.equalsIgnoreCase("Sim") && !mostrarTexto.equalsIgnoreCase("Não")){
                System.out.println("Resposta inválida");
            }

            if(mostrarTexto.equalsIgnoreCase("Sim")){
            	mostrarTextos();
            }

            
        }while (!mostrarTexto.equalsIgnoreCase("Sim") && !mostrarTexto.equalsIgnoreCase("Não"));
    }

    // Método para cadastrar uma nova orientação
    private static void cadastrarOrientacao(Scanner input, String[] tipoTexto) {
		String repeticaoCadastro;
		int escolhaTipoTexto;
		
        int index = 10;

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

    static void mostrarTextos(){

        for(int index = 0; index < tituloTexto.length && index < conteudoTexto.length && index < tipoTextoEscolhido.length; index++){
            
            if(tituloTexto[index] != null && conteudoTexto[index] != null && tipoTextoEscolhido[index] != null){
                System.out.println("ID " + (index + 1) + " -");
                System.out.println("Título: " + tituloTexto[index]);
                System.out.println("Conteúdo: " + conteudoTexto[index]);
                System.out.println("Tipo: " + tipoTextoEscolhido[index]);
            }
        }
    }

}