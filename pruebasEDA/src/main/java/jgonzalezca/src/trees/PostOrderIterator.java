package jgonzalezca.src.trees;

import java.util.Iterator;

public class PostOrderIterator implements Iterator<Position<E>> {
	//una solucion es crear una pila en las que guardo las parejas [nodo iterador_hijos_del_nodo]
	/* la primera vez que creo el iterador me guardo el nodo raiz
	 * la primera vez que llamamos a next consulto el primer elemento de la pila y me quedo con sus hijos
	 * saco el iterador y le digo hasNext, si tiene hijos pues hago el mismo proceso
	 * todo esto en una llamada a next
	 * 
	 */

}
