package projetoFinal;

import java.util.Scanner;

public class Orientacao{

	private int id;
	private String tipo;
	private String titulo;
	private String conteudo;

	public Orientacao(int id, String tipo, String titulo, String conteudo){
		this.id = id;
		this.tipo = tipo;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public Orientacao(){

	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}
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
	
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	// Método para cadastrar uma nova orientação
	public void cadastrarOrientacao(Scanner input, Orientacao[] orientacoes, Tradutor traducao, int index, int quantidadeTexto, int proximoId) {
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

				if(repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo"))){
					index++;
				}

				if(!repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("negativo"))){
					System.out.println(traducao.getProperty("respostaInvalida"));
				}

			}while(!repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")) && !repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("negativo")));
		}while(repeticaoCadastro.equalsIgnoreCase(traducao.getProperty("positivo")));

	}

	public void pesquisarOrientacao(Scanner input, Orientacao orientacoes[], Tradutor traducao, int index, int quantidadeTexto, int proximoId) {
		String repeticaoPesquisa;

		int id = orientacoes[index].id;
		String tituloOrientacao = orientacoes[index].titulo;

		do {
			System.out.println(traducao.getProperty("perguntaPesquisaTipo"));
			int opcao = input.nextInt();
			input.nextLine();

			boolean encontrado = false;
			switch (opcao) {
			case 1:
				System.out.println(traducao.getProperty("qualOrientacao"));
				String titulo = input.nextLine();
				for (index = 0; index < orientacoes.length; index++) {
					if (orientacoes[index] != null && tituloOrientacao.equalsIgnoreCase(titulo)) {
						exibirOrientacaoPesquisada(traducao, orientacoes, index);
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
                for(index = 0; index< quantidadeTexto; index++) {
					if (id == idDigitado) {
						exibirOrientacaoPesquisada(traducao, orientacoes, index);
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

	public void excluirOrientacao(Scanner input, Orientacao orientacoes[], Tradutor traducao, int index, int quantidadeTexto, int proximoId) {

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

	public boolean mostrarTextos( Tradutor traducao, Orientacao orientacoes[], int index, int quantidadeTexto, int[] ids){
	
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

	public static void exibirOrientacaoPesquisada(Tradutor traducao, Orientacao orientacoes[], int index){
		System.out.println(traducao.getProperty("orientacaoEncontrada"));
		System.out.println("ID " + orientacoes[index].getId());
		System.out.println(traducao.getProperty("titulo") + orientacoes[index].getTitulo());
		System.out.println(traducao.getProperty("conteudo") + orientacoes[index].getConteudo());
		System.out.println(traducao.getProperty("tipo")+ orientacoes[index].getTipo());
		System.out.println("----------------------------------------------");
	}
}