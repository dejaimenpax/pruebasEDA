package jgonzalez.src.binarytrees;

import java.util.Iterator;



/**
 *
 * @author mayte
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>{
	
	private BTNode<E> raiz;
	
	private class BTNode<T> implements Position<T> {
		
		private T element;
		private BTNode<T> i;
		private BTNode<T> d;
		private BTNode<T> p;
		
		
		public BTNode(T ele){
			element = ele;
			i = null;
			d = null;
			p = null;
		}
		
		public BTNode<T> getI() {
			return i;
		}

		public void setI(BTNode<T> i) {
			this.i = i;
		}

		public BTNode<T> getD() {
			return d;
		}

		public void setD(BTNode<T> d) {
			this.d = d;
		}

		public BTNode<T> getP() {
			return p;
		}

		public void setP(BTNode<T> p) {
			this.p = p;
		}
		
		public T getElement() {
			return element;
		}
		
		public void setElement(T element) {
			this.element = element;
		}

 	} //BTNode

	private BTNode<E> checkPosition(Position<E> p) throws RuntimeException{
		if (p == null || !(p instanceof BTNode)) {
			throw new RuntimeException("Invalid position");
		}
		return (BTNode<E>) p;
	}
	
    public Position<E> left(Position<E> v) { //alternativa es primero hasLeft y luego left
    	BTNode<E> nodo;
		try {
			nodo = this.checkPosition(v);
			return nodo.getI();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    public Position<E> right(Position<E> v) { //alternativa es primero hasRight y luego right
       	BTNode<E> nodo;
		try {
			nodo = this.checkPosition(v);
			return nodo.getD(); //el BTNode cumple position, por eso el return esta bien
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    public boolean hasLeft(Position<E> v) {
       return left(v) != null;
       /* alternativa
        * 
        * 	BTNode<E> nodo;
		try {
			nodo = this.checkPosition(v);
			return nodo.getI()!=null;
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        * 
        * 
        */
    }

    
    public boolean hasRight(Position<E> v) {
    	return right(v) != null;
    }

    
    public boolean isInternal(Position<E> v) { //ideal: usar isLeaf para sacar isInternal
    	BTNode<E> nodo;
		try {
			nodo = this.checkPosition(v);
	    	return (nodo.getD()!=null) &&  (nodo.getP()!=null) &&  (nodo.getI()!=null);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		/*
		 * alternativa
		 * return !isLeaf(v);
		 */
    }

    
    public boolean isLeaf(Position<E> p) { //ideal: usar isLeaf para sacar isInternal
    	BTNode<E> nodo;
		try {
			nodo = this.checkPosition(p);
			return (nodo.getI()==null) && (nodo.getD()==null);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}  	
		
		/*alternativa 1
		 * 
		 * boolean is_not_hi = !hasLeft(p);      sin casteo
		 * boolean is_not_hd = !hasRight(p)
		 * return is_not_hi $$ is_not_hd;
		 * 
		 * 
		 * altrenativa 2
		 * return ! (hasLeft(p) || hasRight)
		 * 
		 */
    }

    public boolean isRoot(Position<E> p) { //este esta bien, pero ojo, ¿y si queremos limitar a que p tenga que ser la raiz de MI arbol?
    	BTNode<E> nodo;                    //asumimos que llamamos a la funcion con un position de nuestro arbol
		try {
			nodo = this.checkPosition(p);
			return (nodo.getP()==null);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
    }

    
    public Position<E> root() {
    	return raiz;
    }

    @Override
    public E replace(Position<E> p, E e) {
    	BTNode<E> nodo;
		try {
			nodo = this.checkPosition(p);
			E ele = nodo.getElement();
			nodo.setElement(e);
			return ele;	
		} catch (RuntimeException exce) {
			// TODO Auto-generated catch block
			exce.printStackTrace();
			return null;
		}
    }

    @Override
    public Position<E> sibling(Position<E> p) { //habria que comprobar que el nodo no sea raiz
    	BTNode<E> nodo;							//si soy la raiz, devuelvo excepcion. si no tengo hermano, devuelvo arbol vacio
		try {
			if (this.isRoot(p))
				throw new UnsupportedOperationException("Es raiz");
			nodo = this.checkPosition(p);
			BTNode<E> aux = nodo.getP();
			//si me preguntan hermano y no tengo, podria devolver arbol vacio
			if (right(aux).equals(nodo)){ //OJO DISTINTO DE AUX.GETD()
				return left(aux); //OJO, NO ES LO MISMO ESTO QUE AUX.GETI
			}
			else
				return right(aux);
			
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public Position<E> addRoot(E e) { //estaria bien comprobar que fuese vacio, solo deberia poder usarse si el arbol es vacio
    	this.raiz = new BTNode<>(e);
    	return raiz;	
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
    	BTNode<E> nodo;
    	BTNode<E> newChild;
		try {
			if (hasLeft(p))
				throw new UnsupportedOperationException();
			nodo = this.checkPosition(p);
			newChild = new BTNode<E>(e);
			nodo.setI(newChild);
			return newChild;
		} catch (RuntimeException exce) {
			// TODO Auto-generated catch block
			exce.printStackTrace();
			return null;
		}
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
    	BTNode<E> nodo;
    	BTNode<E> newChild;
		try {
			if (hasRight(p))
				throw new UnsupportedOperationException();
			nodo = this.checkPosition(p);
			newChild = new BTNode<E>(e);
			nodo.setD(newChild);
			return newChild;
		} catch (RuntimeException exce) {
			// TODO Auto-generated catch block
			exce.printStackTrace();
			return null;
		}
    }

    @Override
    public E remove(Position<E> p) {
    	/*
    	 * llamada recursiva para remove de los hijos
    	 */
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
    	/*
    	 * intercambia nodos pero no los hijos, por lo que es tan sencillo como cambiar el valor de los elements
    	 */
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean isEmpty() {
    	return raiz==null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
    	//sencillo, casting a nodo y preguntar por padre
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
    	//podriamos devolver siempre un arraylist de 2 elementos
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
    	//nos sirve el iterator implementado para n-arios
    	//podria reimplementarlo pero no hace falta
    	//ESTARIA BIEN IMPLEMENTAR EL INORDER
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void attachLeft(Position<String> h, LinkedBinaryTree<String> t1) {
    	//es como enganchar un hijo pero cambio su referencia para que enlace al padre
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void attachRight(Position<String> h, LinkedBinaryTree<String> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedBinaryTree<String> subTree(Position<String> h) {
    	//desengancho del arbol, lo convierto en la raiz de mi nuevo arbol
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

   
}
