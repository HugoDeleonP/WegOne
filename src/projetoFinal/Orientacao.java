package projetoFinal;

import java.util.Scanner;

public class Orientacao{

	String tipo;
	String titulo;
	String conteudo;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getConteudo() {
		return conteudo;
	}
	
	public void setConteúdo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	// Método para cadastrar uma nova orientação
	public void cadastrarOrientacao(Scanner input, String[] tituloTexto, String[] conteudoTexto, String[] tipoTexto, Tradutor traducao, String[] tipoTextoEscolhido, int index, int quantidadeTexto, int[] ids, int proximoId) {
		String repeticaoCadastro;
		int escolhaTipoTexto;

		String tituloDigitado;
		String conteudoDigitado;
		index = 10;

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

	public void pesquisarOrientacao(Scanner input, String[] tituloTexto, String[] conteudoTexto, String[] tipoTexto, Tradutor traducao, String[] tipoTextoEscolhido, int index, int quantidadeTexto, int[] ids, int proximoId) {
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

				if (!repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("negativo"))) {
					System.out.println(traducao.getProperty("invalida"));
				}
			} while (!repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("negativo")));
		} while (repeticaoPesquisa.equalsIgnoreCase(traducao.getProperty("positivo")));

	}

	public void excluirOrientacao(Scanner input, String[] tituloTexto, String[] conteudoTexto, String[] tipoTexto, Tradutor traducao, String[] tipoTextoEscolhido, int index, int quantidadeTexto, int[] ids, int proximoId) {

		String repeticaoExclusao;

		do {
			
			if(!mostrarTextos(traducao, tituloTexto, conteudoTexto, tipoTextoEscolhido, index, quantidadeTexto, ids)) {
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

	public boolean mostrarTextos( Tradutor traducao, String[] tituloTexto, String[] conteudoTexto, String[] tipoTextoEscolhido, int index, int quantidadeTexto, int[] ids){
	
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