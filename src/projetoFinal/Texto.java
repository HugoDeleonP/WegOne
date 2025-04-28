package projetoFinal;

public class Texto{

	String idioma;
	String tipo;
	String titulo;
	String conteudo;
	
	public Texto(String idioma, String tipo, String titulo, String conteudo) {
		this.idioma = idioma;
		this.titulo = titulo;
		this.conteudo = conteudo;
	}

	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
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
	
	public void setConteúdo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	
}