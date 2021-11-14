package concursoDeCanto.Filtros;

import concursoDeCanto.ElementoConcurso;

public class FiltroGenero implements Filtro{
	
	private String genero;
	
	public FiltroGenero(String genero) {
		this.genero= genero;
	}
	@Override
	public boolean cumple(ElementoConcurso e) {
		return e.prefiereGenero(genero);
	}

}
