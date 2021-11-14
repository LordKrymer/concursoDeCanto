package concursoDeCanto.Filtros;

import concursoDeCanto.ElementoConcurso;

public class FiltroNulo implements Filtro{

	@Override
	public boolean cumple(ElementoConcurso e) {
		return true;
	}
	
}
