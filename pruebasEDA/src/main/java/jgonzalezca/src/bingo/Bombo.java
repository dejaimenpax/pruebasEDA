package jgonzalezca.src.bingo;

import java.util.HashSet;
import java.util.Random;

public class Bombo {
	
	private HashSet<Integer> bolas;
	private int nbolas;
	private static final int MAXSIZE = 90;
	
	public static int getMaxsize() {
		return MAXSIZE;
	}

	public Bombo() {
		bolas = new HashSet<>();
		nbolas = 0;
		int numero;
		while (nbolas<MAXSIZE) {
			Random r = new Random();
			numero = r.nextInt(MAXSIZE) + 1;
			if (!bolas.contains(numero)) {
				bolas.add(numero);		
				nbolas++;
			}
		}
	}
	
	
	public Integer sacaBola() {
		Random r = new Random();
		int numero = r.nextInt(MAXSIZE) + 1;
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
