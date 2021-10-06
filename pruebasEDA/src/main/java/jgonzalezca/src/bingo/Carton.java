package jgonzalezca.src.bingo;

import java.util.HashSet;

public class Carton {
	
	private HashSet<Integer> linea_1;
	private HashSet<Integer> linea_2;
	private HashSet<Integer> linea_3;
	
	private static final int LINESIZE = 5;
	private static final int PRECIO = 2;
	
	public Carton() {
	
	}
	
	public boolean tachaCarton(Integer num) {
		if (linea_1.contains(num)) {
			linea_1.remove(num);
			return true;
		}
		else if (linea_2.contains(num)) {
			linea_2.remove(num);
			return true;
		}
		else if (linea_3.contains(num)) {
			linea_3.remove(num);
			return true;
		}
		else
			return false;
	}
	
	public boolean pertenece(Integer num) {
		boolean encontrado = false;
		if ((linea_1.contains(num))||(linea_2.contains(num))||(linea_3.contains(num))) 
			encontrado = true;
		return encontrado;
	}
	
	public int size() {
		return linea_1.size()+linea_2.size()+linea_3.size();
	}
	
	public void addNumero(Integer num){ //no comprueba si el carton esta lleno
		if (!pertenece(num)) {
			if (linea_1.size()<LINESIZE)
				linea_1.add(num);
			else if (linea_2.size()<LINESIZE)
				linea_2.add(num);
			else 
				linea_3.add(num);
		}	
	}
	


}
