package jgonzalezca.src.bingo;

import java.util.HashSet;

public class Carton {
	
	private HashSet<Integer> linea_1;
	private HashSet<Integer> linea_2; //no se hasta que punto deberia guardar tambien el tamaño de cada linea
	private HashSet<Integer> linea_3;
	
	private static final int LINESIZE = 5;
	
	public Carton() {
		linea_1 = new HashSet<Integer>();
		linea_2 = new HashSet<Integer>();
		linea_3 = new HashSet<Integer>();
	
	}
	
	public int tachaCarton(Integer num) {
		if (linea_1.contains(num)) {
			linea_1.remove(num);
			return linea_1.size(); //duda size
		}
		else if (linea_2.contains(num)) {
			linea_2.remove(num);
			return linea_2.size();
		}
		else if (linea_3.contains(num)) {
			linea_3.remove(num);
			return linea_3.size();
		}
		else
			return -1;
	}
	
	public boolean pertenece(Integer num) {
		boolean encontrado = false;
		if ((linea_1.contains(num))||(linea_2.contains(num))||(linea_3.contains(num))) 
			encontrado = true;
		return encontrado;
	}
	
	public int size() {
		return linea_1.size()+linea_2.size()+linea_3.size(); //hacerlo con atributos size_1 es mas eficiente?
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
