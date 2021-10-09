package jgonzalezca.src.bingo;

import java.util.Iterator;
import java.util.LinkedList;

public class Jugador {
	
	private String dni;
	private LinkedList<Carton> cartones;
	private int ncartones = 0;
	private static final int CARTONSIZE = 15;
	
	public Jugador() {
		ncartones = 0;
		dni = null;
		cartones = new LinkedList<Carton>();
	}
	
	public Jugador(String id) {
		this();
		this.dni=id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public LinkedList<Carton> getCartones() {
		return cartones;
	}
	
	public void compraCarton() {
		cartones.add(generaCarton());
		ncartones++;
	}
	
	public void setCartones(LinkedList<Carton> cartones) {
		this.cartones = cartones;
	}

	public int getNcartones() {
		return ncartones;
	}

	public void setNcartones(int ncartones) {
		this.ncartones = ncartones;
	}
	
	public Carton generaCarton() {
		Carton carton = new Carton();
		int numero;
		while (carton.size()<CARTONSIZE) { //aqui ya comprueba si el carton esta lleno, cosa que no hace addnumero. deberia optimizar carton.size()?
			numero = (int)  Math.floor(Math.random() * 90 + 1);
			if (!carton.pertenece(numero)) //un carton puede tener numeros repetidos? si es as�, borrar el if
				carton.addNumero(numero);
		} 
		return carton;
	}
	
	public int compruebaCarton(int numero, boolean modoBingo) { //modo false para linea, modo true para bingo
		Iterator<Carton> it = this.cartones.iterator();
		int lineaobingo = -1; //0 para linea, 1 para bingo
		while (it.hasNext()) { //no hay condicion de parada aunque haga linea, tiene que tachar el num en todos sus cartones
			int restantesEnLinea = it.next().tachaCarton(numero);
			if ((restantesEnLinea==0)&&(!modoBingo))
				lineaobingo = 0;
			else if (restantesEnLinea==0)
				lineaobingo = 1;	
		}
		return lineaobingo;
	}

}
