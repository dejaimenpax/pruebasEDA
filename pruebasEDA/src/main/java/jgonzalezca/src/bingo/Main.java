package jgonzalezca.src.bingo;

import java.util.HashSet;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		int id = 30000000;
		HashSet<Jugador> listaplayers = new HashSet<>();
		for (int i=1;i<=10;i++) {
			listaplayers.add(new Jugador(String.valueOf(id)));
			id++;
		}
		listaplayers.add(new Jugador("44569015Y"));
		Iterator<Jugador> it = listaplayers.iterator();
		while (it.hasNext()) {
			Jugador jug = it.next();
			jug.compraCarton(); //pongamos que cada uno compra 2
			jug.compraCarton();
		}
		new Partida(listaplayers);
	}

}
