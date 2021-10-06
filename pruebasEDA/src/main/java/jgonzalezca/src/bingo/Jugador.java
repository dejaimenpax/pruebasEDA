package jgonzalezca.src.bingo;

import java.util.LinkedList;

public class Jugador {
	
	private LinkedList<Carton> cartones;
	private int ncartones;
	private static final int CARTONSIZE = 15;
	
	public Jugador() {
		
	}
	
	public void compraCarton() {
		cartones.add(generaCarton());
		ncartones++;
	}
	
	public Carton generaCarton() {
		Carton carton = new Carton();
		int numero;
		while (carton.size()<CARTONSIZE) {
			numero = (int) (Math.random()*6);
			carton.addNumero(numero);
		} 
		return carton;
	}

}
