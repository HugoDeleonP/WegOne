package projetoFinal;
import java.util.Scanner;
public class Principal {
	
	public static void main(String [] args) {
	Scanner input=new Scanner(System.in);


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


		System.out.println("	PT-BR----Antes de começar,adicione seu idioma!(1)(escolha o número representante dessa língua)");
		System.out.println("	ES-------¡Antes de empezar, añade tu idioma!(2)(Elige el número que representa este idioma.)");
		System.out.println("	EN-USA---Before you start, add your language!(3)(Choose the number that represents this language.)");
		System.out.println("	DIE------Bevor Sie beginnen, fügen Sie Ihre Sprache hinzu!(4)(Wähle die Zahl, die diese Sprache repräsentiert.)");
		int lingua=input.nextInt();

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
				break;

		}

	}

}
