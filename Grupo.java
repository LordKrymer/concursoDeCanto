package concursoDeCanto;

import java.util.ArrayList;
import java.util.HashMap;

import concursoDeCanto.Filtros.Filtro;

public class Grupo extends ElementoConcurso{
	
	private ArrayList<ElementoConcurso> integrantes;
	
	public Grupo(String nombre) {
		this(nombre, new ArrayList<ElementoConcurso>());
	}
	
	public Grupo(String nombre,ArrayList<ElementoConcurso> integrantes) {
		super(nombre);
		this.integrantes = new ArrayList<ElementoConcurso>(integrantes);
	}

	@Override
	public String getNombre() {
		return nombre;
	}


	@Override
	public ArrayList<String> getGenerosPreferentes() {
		HashMap<String, Integer> actual =  new HashMap<String, Integer>();
		for (ElementoConcurso e: integrantes) {
			ArrayList<String> aux = e.getGenerosPreferentes();
			for (String s: aux) {
				if (!actual.containsKey(s)) {actual.put(s, 0);}
				actual.put(s, (actual.get(s)+1));
			}
		}
		ArrayList<String> resultado = new ArrayList<String>();
		for (String i : actual.keySet()) {
			if(actual.get(i) == integrantes.size()) { resultado.add(i);}
		}
		return resultado;
	}
	

	@Override
	public ArrayList<String> getInstrumentos() {
		ArrayList<String> instrumentos = new ArrayList<>();
		for (ElementoConcurso e : integrantes) {
			ArrayList<String> aux = e.getInstrumentos();
			for (String s : aux)
				if (!instrumentos.contains(s))
					instrumentos.add(s);
		}
		return instrumentos;
	}

	@Override
	public ArrayList<String> getIdiomas() {
		ArrayList<String> idiomas = new ArrayList<>();
		for (ElementoConcurso e : integrantes) {
			ArrayList<String> aux = e.getIdiomas();
			for (String s : aux)
				if (!idiomas.contains(s))
					idiomas.add(s);
		}
		return idiomas;
	}
	@Override
	public int getEdad() {
		if (cantIntegrantes() == 0 )
			return 0;
		
		double edad= 0.0;
		for (ElementoConcurso e : integrantes)
			edad += e.getEdad();
		return (int) edad/cantIntegrantes();
	}
	
	public void add(ElementoConcurso e) {
		integrantes.add(e);
	}
	
	public int cantIntegrantes() {
		return integrantes.size();
	}

	
	public ArrayList<Participante> integrantesQueTocan(String instrumento) {
		ArrayList<Participante> aux = new ArrayList<>();
		for (ElementoConcurso e : integrantes)
			aux.addAll(e.integrantesQueTocan(instrumento));
		return aux;
	}

	@Override
	public ArrayList<ElementoConcurso> filtrarPor(Filtro f) {
		ArrayList<ElementoConcurso> aux = new ArrayList<>();
		if (f.cumple(this))
			aux.add(this);
		else
			for (ElementoConcurso e : integrantes)
				aux.addAll(e.filtrarPor(f));
		return aux;
	}
}
