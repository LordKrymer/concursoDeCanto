package concursoDeCanto;

import java.util.ArrayList;
import java.util.Collections;
import concursoDeCanto.ComparatorBatallas.Comparador;
import concursoDeCanto.Filtros.*;

public class Coach {
	private ArrayList<ElementoConcurso> integrantes;
	//Atributo que nos permite utilizar el patron Strategy, por lo que no requerimos la clase CoachExigente.
	private Filtro criterioAceptacion;

	public Coach(String nombre) {
		this(new ArrayList<ElementoConcurso>(), nombre, new FiltroNulo());
	}
	
	public Coach(Filtro f, String nombre) {
		this(new ArrayList<ElementoConcurso>(), nombre, f);
	}
	
	public Coach(ArrayList<ElementoConcurso> integrantes, String nombre, Filtro f) {
		this.integrantes = new ArrayList<>(integrantes);
		this.criterioAceptacion = f;
	}
	
	public boolean add(ElementoConcurso e) {
		if (criterioAceptacion.cumple(e)) {
			this.integrantes.add(e);
			return true;
		}
		return false;
	}
	
	public ElementoConcurso mejorIntegrante(Comparador c){
		ArrayList<ElementoConcurso> aux = getIntegrantes();
		Collections.sort(aux, c);
		return aux.get(0);
	}
	
	
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
	
	public ArrayList<String> getGeneros() {
		ArrayList<String> generos = new ArrayList<>();
		for (ElementoConcurso e : integrantes) {
			ArrayList<String> aux = e.getGenerosPreferentes();
			for (String s : aux)
				if (!generos.contains(s))
					generos.add(s);
	
		}
		Collections.sort(generos);
		return generos;
	}
	
	public double getPromedioEdad() {
		double promedio = 0.0;
		for (ElementoConcurso e : integrantes)
			promedio += e.getEdad();
		return promedio/cantIntegrantes();
	}
	
	public int cantIntegrantes() {
		return integrantes.size();
	}
	
	public ArrayList<ElementoConcurso> getIntegrantes(){
		return new ArrayList<>(integrantes);
	}
}
