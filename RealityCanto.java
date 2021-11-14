package concursoDeCanto;

import java.util.ArrayList;

import concursoDeCanto.ComparatorBatallas.Comparador;

public class RealityCanto {
	ArrayList<Coach> coaches;
	Comparador c;
	public RealityCanto(Comparador c) {
		this(new ArrayList<Coach>(), c);
	}
	
	public RealityCanto(ArrayList<Coach> coaches, Comparador c) {
		this.c = c;
		this.coaches = new ArrayList<>(coaches);
	}
	
	public void setComparador(Comparador c) {
		this.c = c;
	}
	
	public ElementoConcurso encuentro(int equipo1, int equipo2) {
		Coach coach1 = getCoach(equipo1);
		Coach coach2 = getCoach(equipo2);
		if (coach1.cantIntegrantes() == 0 && coach2.cantIntegrantes() == 0)
			return null;
		else if (coach1.cantIntegrantes() == 0)
			return coach2.mejorIntegrante(c);
		else if (coach2.cantIntegrantes() == 0)
			return coach1.mejorIntegrante(c);
			
		return Batalla.batallar(coach1.mejorIntegrante(c), coach2.mejorIntegrante(c), c);
	}
	
	public void add(Coach c) {
		coaches.add(c);
	}
	
	public Coach getCoach(int index) {
		try {
			return coaches.get(index);			
		} catch (Exception e) {
			return coaches.get(coaches.size() - 1);
		}
	}

}
