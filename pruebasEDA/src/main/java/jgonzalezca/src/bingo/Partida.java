package jgonzalezca.src.bingo;

import java.util.HashSet;
import java.util.Iterator;


public class Partida {
	
	private HashSet<Jugador> jugadores; //hashset porque me da igual el orden y cada jugador es unico
	private HashSet<Jugador> ganadores;
	private int totaljugadores;
	private int totalcartones = 0;
	private static final int PRECIOCARTON = 2;


	public Partida() {
		totalcartones=0;
		totaljugadores=0;
		jugadores=null;
		ganadores=null;
	}
	
	public int getTotalcartones() {
		return totalcartones;
	}

	public void setTotalcartones(int totalcartones) {
		this.totalcartones = totalcartones;
	}
	
	public int getTotaljugadores() {
		return totaljugadores;
	}

	public void setTotaljugadores(int totaljugadores) {
		this.totaljugadores = totaljugadores;
	}
	
	public void nuevoJugador(Jugador player) {
		this.jugadores.add(player);
		this.totaljugadores++;
	}
	
	private double calculaPremio() {
		return ((PRECIOCARTON*totalcartones)*(1/2));
	}
	
	public void vendeCarton(Jugador player){
		player.compraCarton();
		this.totalcartones++;
	}
	
	public Partida(HashSet<Jugador> listaJugadores){
		//Inicializamos lo necesario
		this.ganadores = new HashSet<Jugador>();
		this.jugadores = listaJugadores;
		this.totalcartones=0;
		this.totaljugadores=0;
		Bombo bombo = new Bombo();
		for (Jugador player : listaJugadores) {
			this.totalcartones = player.getNcartones() + this.totalcartones;
			this.totaljugadores++;
		}
		System.out.println("¡Comienza la partida! Hoy el premio es de "+ this.calculaPremio() + "€");
		//Ya tenemos a los jugadores que previamente han comprado sus cartones. Comienza el juego.
		int lineaobingo = -1;
		int cantadores = 0;
		int bolasacada;
		Jugador person;
		while ((lineaobingo!=0)&&(cantadores==0)) {
			System.out.println("Sacando bola...");
			bolasacada = bombo.sacaBola();
			System.out.println("¡Ha salido el " + bolasacada+"!");
			Iterator<Jugador> itjugador = listaJugadores.iterator(); //iterador y no foreach pq modifico los elementos
			while(itjugador.hasNext()) { //no hay condicion de parada, todos deben tachar sus numeros
				person = itjugador.next();
				lineaobingo = person.compruebaCarton(bolasacada, false);
				if (lineaobingo==0) {
					cantadores++;
					ganadores.add(person);
				}
			}
		}
		for (Jugador win : ganadores) {
			System.out.println("¡El jugador con DNI " + win.getDni() + " ha cantado línea!"); //se lleva premio? o solo el ganador final?
		}
		
		//Han cantado linea, ahora a por bingo
		this.ganadores = new HashSet<Jugador>();
		cantadores=0;
		while ((lineaobingo!=1)&&(cantadores==0)) {
			System.out.println("Sacando bola...");
			bolasacada = bombo.sacaBola();
			System.out.println("¡Ha salido el " + bolasacada+"!");
			Iterator<Jugador> itjugador = listaJugadores.iterator(); //iterador y no foreach pq modifico los elementos
			while(itjugador.hasNext()) { //no hay condicion de parada, todos deben tachar sus numeros
				person = itjugador.next();
				lineaobingo = person.compruebaCarton(bolasacada, true);
				if (lineaobingo==1) {
					cantadores++;
					ganadores.add(person);
				}
			}
		}
		
		for (Jugador win : ganadores) {
			System.out.println("¡El jugador con DNI " + win.getDni() + " ha cantado bingo, enhorabuena!\n"+
								"¡Se lleva un premio de " + this.calculaPremio()/cantadores + "€!"); //premio entre personas que cantaron
		}
		System.out.println("\nFIN DE LA PARTIDA. GRACIAS POR JUGAR");
	}
	
	
	

}
