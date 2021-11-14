package concursoDeCanto.Filtros;

import concursoDeCanto.ElementoConcurso;

public class FiltroIdioma implements Filtro{
	private String idioma;
	
	public FiltroIdioma(String idioma) {
		this.idioma = idioma;
	}
	@Override
	public boolean cumple(ElementoConcurso e) {
		return e.cantaIdioma(idioma);
	}

}
