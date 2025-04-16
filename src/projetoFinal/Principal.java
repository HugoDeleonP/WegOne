package projetoFinal;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int escolhaNumero;
		
		String tituloTexto[] = new String [100];
		String conteudoTexto[] = new String[100];
		String tipoTexto[] = {"Manual de operação", "Procedimentos de segurança", "Manutenção e reparos", "Testes e diagnósticos", "Manual de conduta e Operações Setoriais"};
		
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
		
		do {
			
			System.out.println("0- Sair");
			for(int contador = 0; contador < 5; contador++) {
				
				System.out.print((contador+1) + "- ");
				System.out.println(tipoTexto[contador]);
			}
			
			escolhaNumero = input.nextInt();
			
			if(escolhaNumero > 5) {
				System.out.println("Número inválido.");
				continue;
			}
		}
		while(escolhaNumero != 0);
	}

}
