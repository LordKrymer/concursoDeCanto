package concursoDeCanto.ComparatorBatallas;

import java.util.Comparator;

import concursoDeCanto.ElementoConcurso;

public abstract class Comparador implements Comparator<ElementoConcurso>{

	private Comparator<ElementoConcurso> siguiente;
	public Comparador(Comparator<ElementoConcurso> ste) {
		siguiente = ste;
	}
	
	public abstract int diferencia(ElementoConcurso o1, ElementoConcurso o2);

	@Override
	public int compare(ElementoConcurso o1, ElementoConcurso o2) {
		int aux = diferencia(o1, o2);
		if(aux == 0) {
			if (siguiente != null)
				return siguiente.compare(o1, o2);
		}
		else if (aux > 0 ) {return 1;}
		else if (aux < 0 ) {return -1;}
		return 0;
	}
}
