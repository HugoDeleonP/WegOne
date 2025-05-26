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
}