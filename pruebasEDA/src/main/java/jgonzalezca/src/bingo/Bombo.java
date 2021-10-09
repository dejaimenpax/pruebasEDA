package jgonzalezca.src.bingo;

import java.util.HashSet;

public class Bombo {
	
	private HashSet<Integer> bolas;
	private int nbolas;
	private final int MAXSIZE = 90;
	
	public Bombo() {
		bolas = new HashSet<Integer>();
		nbolas = 0;
		int numero;
		while (nbolas<MAXSIZE) {
			numero = (int)  Math.floor(Math.random() * MAXSIZE + 1);
			if (!bolas.contains(numero)) {
				bolas.add(numero);		
				nbolas++;
			}
		}
	}
	
	
	public Integer sacaBola() {
		int numero =  (int) (Math.random() * MAXSIZE + 1);
		bolas.remove(numero);
		return numero;
	}
	
	public int getNbolas() {
		return nbolas;
	}

	public void setNbolas(int nbolas) {
		this.nbolas = nbolas;
	}

}
