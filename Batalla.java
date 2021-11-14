package concursoDeCanto;

import concursoDeCanto.ComparatorBatallas.*;

public class Batalla {

	public Batalla() {
		
	}
	
	public static ElementoConcurso batallar(ElementoConcurso e1, ElementoConcurso e2, Comparador c) {
		int aux = c.compare(e1, e2);
		if (aux > 0)
			return e1;
		else if (aux < 0)
			return e2;
		return Batalla.batallar(e1, e2, new ComparadorSuerte());
	}

}
