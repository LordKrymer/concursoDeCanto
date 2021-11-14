package concursoDeCanto.ComparatorBatallas;

import java.util.Comparator;

import concursoDeCanto.ElementoConcurso;

public class ComparadorEdad extends Comparador{
	public ComparadorEdad(Comparator<ElementoConcurso> ste) {
		super(ste);
	}


	@Override
	public int diferencia(ElementoConcurso o1, ElementoConcurso o2) {
		return o1.getEdad()- o2.getEdad();
	}

}
