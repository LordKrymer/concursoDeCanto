package concursoDeCanto.Filtros;

import concursoDeCanto.ElementoConcurso;

public class FiltroNOT implements Filtro{
	private Filtro aNegar;
	
	public FiltroNOT(Filtro f) {
		aNegar = f;
	}

	@Override
	public boolean cumple(ElementoConcurso e) {
		return !aNegar.cumple(e);
	}
	
	
}
