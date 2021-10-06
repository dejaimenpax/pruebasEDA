package jgonzalezca.src.bingo;

import java.util.HashSet;

public class Bombo {
	
	private HashSet<Integer> bolas;
	
	public Bombo() {
		
	}
	
	
	public Integer sacaBola() {
		int numero =  (int) (Math.random()*6);
		bolas.remove(numero);
		return numero;
	}

}
