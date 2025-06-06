package projetoFinal.JDBC;

import projetoFinal.GerenciadorOrientacao;
import projetoFinal.Tradutor;
import projetoFinal.*;

import java.util.Scanner;

public class InterfaceDB {
    public static void main(String [] args) {

        Scanner input = new Scanner(System.in);



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
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("| Código  | Idioma            | Mensagem em Língua Nativa                         |");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("| 1       | Português (PT-BR) | Antes de começar, adicione seu idioma!            |");
            System.out.println("| 2       | Español (ES)      | ¡Antes de empezar, añade tu idioma!               |");
            System.out.println("| 3       | English (EN-USA)  | Before you start, add your language!              |");
            System.out.println("| 4       | Deutsch (DE)      | Bevor Sie beginnen, fügen Sie Ihre Sprache hinzu! |");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.print("Digite o número do seu idioma: ");


            while (!input.hasNextInt()) {
                System.out.println("Por favor, digite um número válido.");
                input.next(); // limpa a entrada inválida
                System.out.print("Digite o número do seu idioma: ");
            }

            lingua=input.nextInt();
            input.nextLine();

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

        }while(idioma == null);
        Tradutor traducao = Tradutor.getInstance(idioma);

        GerenciadorDB manager = new GerenciadorDB(input, traducao);
        int escolhaNumero;
        do {
            // Exibe o menu principal
            System.out.println(traducao.getProperty("menu"));

            escolhaNumero = input.nextInt();
            input.nextLine();

            switch (escolhaNumero) {
                case 1:
                    // Cadastrar Orientação

                    manager.cadastrarOrientacao();
                    break;
                case 2:
                    // Pesquisar Orientação

                    
                    break;
                case 3:
                    // Editar Orientação
                    manager.editarOrientacao();
                    break;
                case 4:
                    // Excluir Orientação
                    System.out.println(traducao.getProperty("listagemTextos"));
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
