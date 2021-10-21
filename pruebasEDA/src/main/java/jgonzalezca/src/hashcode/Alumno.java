package jgonzalezca.src.hashcode;

public class Alumno {
	
	private String dni;
	private String nombre;
	private int edad;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Alumno() {
		dni = null;
		nombre = null;
		edad = 0;
	}
	
	public Alumno(String dni, String nombre, int edad) {
		this.dni = dni;
		this.nombre=nombre;
		this.edad = edad;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o)
			return true;
		else if (o==null)
			return false;
		else if (getClass() != o.getClass())
			return false;
		else {
			Alumno alu = (Alumno) o;
			return ( (this.nombre.equals(alu.getNombre())) &&
					(this.dni.equals(alu.getDni())) );
		}
			
	}
	
	@Override
	public int hashCode() {
		int code1 = Integer.parseInt(this.dni.substring(0,8));
		int code2 = 0;
		for (int i = 0; i < this.nombre.length(); i++) {
		    code2 = code2*17 + this.nombre.charAt(i);
		}
		return code1+code2;
		/*consejo, convertimos a enteros como queramos los campos y lo mejor para fusionarlas es sort
		 * cojo todas las cifras de uno y de otro y las ordeno con sort
		 */
	}

}
