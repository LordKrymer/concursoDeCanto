package concursoDeCanto.Filtros;

import concursoDeCanto.Cancion;
import concursoDeCanto.ElementoConcurso;

public class FiltroCancion implements Filtro{
	Cancion cancion;
	public FiltroCancion(Cancion c) {
		cancion = c;
	}

	@Override
	public boolean cumple(ElementoConcurso e) {
		return cancion.interpretablePor(e);
	}

}
