// INTEGRANTES DEL GRUPO  :  MARCOS FERNANDEZ SOLER  |  AGUSTIN CARRETTO

package concursoDeCanto;

import concursoDeCanto.ComparatorBatallas.ComparadorCantInstrumentos;
import concursoDeCanto.ComparatorBatallas.*;
import concursoDeCanto.Filtros.*;

public class Main {
	
	public static void main(String[] args) {
		Cancion song = new CancionFinal("Yoru ni kakeru", "japones", 2);
		song.addGenero("jpop");
		song.addInstrumento("violin");
		Grupo grupo1 = new Grupo("las rodesias"); 
		Grupo grupo2 = new Grupo("zeppelin");
		Participante participante1 = new Participante("agustin", "carretto", 21);
		Participante participante2 = new Participante("marcos", "fernandez soler", 21);
		participante1.addIdioma("japones");
		grupo2.add(participante2);
		grupo1.add(participante1);
		grupo2.add(grupo1);
		participante2.addInstrumento("violin");
		participante1.addInstrumento("violin");
		participante1.addGenero("rock");
		participante1.addGenero("jazz");
		participante1.addGenero("pop");
		participante1.addGenero("jpop");
		participante2.addGenero("jpop");
		participante2.addGenero("rock");
		participante2.addGenero("jazz");
		participante2.addGenero("pop");
		System.out.println("Prueba cancion final " + song.interpretablePor(grupo2));
		System.out.println("Prueba interseccion " + grupo2.getGenerosPreferentes());
		Coach coach1 = new Coach("marcos coach");
		Coach coach2 = new Coach(new FiltroInstrumento("violin"), "agus coach");
		coach1.add(grupo2);
		coach2.add(participante1);
		Comparador c = new ComparadorCantInstrumentos(new ComparadorGenerosPreferentes( new ComparadorEdad(null) ));
		RealityCanto reality = new RealityCanto(c);
		reality.add(coach2);
		reality.add(coach1);
		ElementoConcurso ganador = reality.encuentro(0, 1);
		System.out.println("El proximo gran kazekage es " + ganador);
	}

}
