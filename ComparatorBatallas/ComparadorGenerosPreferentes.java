package concursoDeCanto.ComparatorBatallas;

import java.util.Comparator;

import concursoDeCanto.ElementoConcurso;

public class ComparadorGenerosPreferentes extends Comparador{
	
	public ComparadorGenerosPreferentes(Comparator<ElementoConcurso> ste) {
		super(ste);
	}

	@Override
	public int diferencia(ElementoConcurso o1, ElementoConcurso o2) {
		return o1.cantGenerosPreferentes() - o2.cantGenerosPreferentes();
	}

	
}
