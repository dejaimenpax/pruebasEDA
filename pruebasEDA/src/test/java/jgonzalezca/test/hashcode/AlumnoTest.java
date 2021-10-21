package jgonzalezca.test.hashcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;


import org.junit.Test;

import jgonzalezca.src.hashcode.Alumno;

public class AlumnoTest {


	HashMap<Alumno, Float> map = new HashMap<Alumno, Float>();
	

	@Test
	public void givenEmptyMap_whenPut_thenAllOkay() {
		map.clear();
		assertEquals(true,map.isEmpty());
		Alumno juan = new Alumno("76067040A", "Juan y Medio", 50);
		Float result = map.put(juan, new Float(7.5f)); //devuelve null
		result = map.put(juan, new Float(8.5f)); //devuelve 7.5
		assertEquals(false,map.isEmpty());
		assertEquals(new Float(7.5f), result);
	}
	
	
	@Test
	public void givenMap_whenGet_thenAllOkay() {
		map.clear();
		map.put(new Alumno("55444555A", "Pepe Palacios", 19), 7.5f);
		map.put(new Alumno("55555555A", "John Travolta", 21), 0.2f);
		map.put(new Alumno("11111111A", "Austin Powers", 19), 10.0f);
		map.put(new Alumno("55576543A", "Arisu Borderlo", 20), 4.99f);
		Alumno juan = new Alumno("76067040A", "Juan y Medio", 50);
		map.put(juan, 5.5f);
		map.put(new Alumno("99965143A", "Esteban Trabajos", 24), 4.75f);
		map.put(new Alumno("01345279B", "Guillermo Puertas", 21), 2.4f);
		map.put(new Alumno("55555555A", "Pepe Palacios", 19), 9.99f);
		float nota = map.get(juan);
		assertEquals(5.5f, nota, 0.0001);
	} 
	
	

}
