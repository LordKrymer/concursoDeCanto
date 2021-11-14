package concursoDeCanto;

import java.util.ArrayList;

import concursoDeCanto.Filtros.Filtro;

public abstract class ElementoConcurso {
	protected  String nombre;
	
	public ElementoConcurso(String nombre) {
		this.nombre = nombre;
	}
	
	public abstract String getNombre();
	public abstract int getEdad();
	public abstract ArrayList<String> getGenerosPreferentes();
	public abstract ArrayList<String> getInstrumentos();
	public abstract ArrayList<String> getIdiomas();
	public abstract ArrayList<Participante> integrantesQueTocan(String instrumento);
	public abstract ArrayList<ElementoConcurso> filtrarPor(Filtro f);
	
	public int cantGenerosPreferentes() {
		return this.getGenerosPreferentes().size();
	}
	
	public boolean tocaInstrumento(String instrumento) {
		return this.getInstrumentos().contains(instrumento);
	}
	
	public boolean cantaIdioma(String idioma) {
		return this.getIdiomas().contains(idioma);
	}
	
	
	public  boolean prefiereGenero(String genero) {
		return this.getGenerosPreferentes().contains(genero);
	}
	
	public  int cantidadInstrumentos() {
		return this.getInstrumentos().size();
	};
	
	@Override
	public String toString() {
		return getNombre();
	}
}
