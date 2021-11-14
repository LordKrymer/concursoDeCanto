package concursoDeCanto.ComparatorBatallas;

import java.security.SecureRandom;

import concursoDeCanto.ElementoConcurso;

public class ComparadorSuerte extends Comparador{

	public ComparadorSuerte() {
		super(null);
	}

	@Override
	public int diferencia(ElementoConcurso o1, ElementoConcurso o2) {
		SecureRandom sr = new SecureRandom();
		int fortuna = sr.nextInt(100);
		if (fortuna < 50)
			return 1;
		else
			return -1;
	}

}
