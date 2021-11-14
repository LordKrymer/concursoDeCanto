package concursoDeCanto;
import java.util.ArrayList;

import concursoDeCanto.Filtros.Filtro;
import concursoDeCanto.Filtros.FiltroGenero;
import concursoDeCanto.Filtros.FiltroIdioma;

public class Cancion {
	private String titulo;
	private String idioma;
	protected ArrayList<String> generos;
	protected ArrayList<String> instrumentosNecesarios;
	
	public Cancion(String titulo, String idioma, ArrayList<String> generos, ArrayList<String> instrumentos) {
		this.titulo=titulo;
		this.idioma=idioma;
		this.generos = new ArrayList<String>(generos);
		this.instrumentosNecesarios = new ArrayList<String>(instrumentos);
	}
	
	public Cancion(String titulo, String idioma) {
		this.titulo = titulo;
		this.idioma = idioma;
		this.generos = new ArrayList<String>();
		this.instrumentosNecesarios= new ArrayList<String>();
	}
	
	public void addGenero(String genero) {
		this.generos.add(genero);
	}
	
	public void addInstrumento(String instrumento) {
		this.instrumentosNecesarios.add(instrumento);
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getIdioma() {
		return this.idioma;
	}
	
	public ArrayList<String> getGeneros(){
		ArrayList<String> aux = new ArrayList<String>(generos);
		return aux;
	}
	public ArrayList<String> getInstrumentos(){
		return new ArrayList<String>(instrumentosNecesarios);
	}
	
	public boolean interpretablePor(ElementoConcurso e) {
		Filtro f1 = new FiltroIdioma(getIdioma());
		if (!f1.cumple(e))
			return false;
		else
			for (String g : generos)
				if ((new FiltroGenero(g)).cumple(e))
					return true;
		return false;
	}
	
}
