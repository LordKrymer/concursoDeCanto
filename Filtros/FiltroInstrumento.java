package concursoDeCanto.Filtros;

import concursoDeCanto.ElementoConcurso;

public class FiltroInstrumento implements Filtro{
	private String instrumento;
	
	public FiltroInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	@Override
	public boolean cumple(ElementoConcurso e) {
		return e.tocaInstrumento(instrumento);
	}
}
