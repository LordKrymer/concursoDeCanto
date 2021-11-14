package concursoDeCanto;

import java.util.ArrayList;

import concursoDeCanto.Filtros.Filtro;

public class Participante  extends ElementoConcurso{
	private String apellido;
	private int edad;
	private ArrayList<String> generosPreferidos;
	private ArrayList<String> idiomas;
	private ArrayList<String> instrumentos;
	
	public Participante(String nombre, String apellido, int edad) {
		super(nombre);
		this.apellido = apellido;
		this.edad = edad;
		this.generosPreferidos = new ArrayList<String>();
		this.idiomas = new ArrayList<String>();
		this.instrumentos = new ArrayList<String>();
	}
	
	public Participante(String nombre, String apellido, int edad, ArrayList<String> instrumentos, ArrayList<String> idiomas, ArrayList<String> generosPreferencia ) {
		super(nombre);
		this.apellido = apellido;
		this.edad = edad;
		this.generosPreferidos = new ArrayList<String>(generosPreferencia);
		this.idiomas = new ArrayList<String>(idiomas);
		this.instrumentos = new ArrayList<String>(instrumentos);
	}
	
	public void addGenero(String genero) {
		this.generosPreferidos.add(genero);
	}
	
	public void addIdioma(String idioma) {
		this.idiomas.add(idioma);
	}
	
	public void addInstrumento(String instrumento) {
		this.instrumentos.add(instrumento);
	}
	
	@Override
	public String getNombre() {
		return (nombre + " " + apellido);
	}
	@Override
	public int getEdad() {
		return this.edad;
	}
	@Override
	public ArrayList<String> getGenerosPreferentes() {
		return new ArrayList<String>(generosPreferidos);
	}
	@Override
	public ArrayList<String> getInstrumentos() {
		return new ArrayList<String>(instrumentos);
	}
	@Override
	public ArrayList<String> getIdiomas() {
		return new ArrayList<String>(idiomas);
	}
	
	@Override
	public ArrayList<Participante> integrantesQueTocan(String instrumento) {
		ArrayList<Participante> aux = new ArrayList<>();
		if(this.tocaInstrumento(instrumento)) {aux.add(this);}
		return aux;
	}
	
	public boolean equals(Object participante) {
		try {
			Participante p = (Participante) participante;
			boolean coincide = ( ( this.getNombre().equals(p.getNombre()) ) && ( this.getEdad() == p.getEdad()  ));
			return coincide;
		}catch(Throwable t){
			return false;
		}
	}
	@Override
	public ArrayList<ElementoConcurso> filtrarPor(Filtro f) {
		ArrayList<ElementoConcurso> participante = new ArrayList<>();
		if (f.cumple(this))
			participante.add(this);
		return participante;
	}
}
