package concursoDeCanto;

import java.util.ArrayList;

public class CancionFinal extends Cancion {
	private int integrantesRequeridos;
	public CancionFinal(String titulo, String idioma, ArrayList<String> generos, ArrayList<String> instrumentos, int integrantes) {
		super(titulo, idioma, generos, instrumentos);
		integrantesRequeridos = integrantes;
	}

	public CancionFinal(String titulo, String idioma, int integrantes) {
		this(titulo, idioma, new ArrayList<String>(), new ArrayList<String>(), integrantes);
	}
	
	@Override
	public boolean interpretablePor(ElementoConcurso e) {
		boolean puedeInterpretar = super.interpretablePor(e);
		boolean cumpleCantidad = this.cumpleCantidad(e);
		return ( puedeInterpretar && cumpleCantidad );
	}
	
	private boolean cumpleCantidad(ElementoConcurso e) {
		ArrayList<Participante> participantes = new ArrayList<>();
		if (instrumentosNecesarios.size() == 0 ) {return true;}
		for (String instrumento : instrumentosNecesarios) {
			ArrayList<Participante> aux = e.integrantesQueTocan(instrumento);
			//Condicion necesaria para no agregar participantes repetidos.
			for (Participante p : aux) {
				if (!participantes.contains(p)) {participantes.add(p);}
			}
		}
		return (participantes.size()>= integrantesRequeridos);
	}

}
