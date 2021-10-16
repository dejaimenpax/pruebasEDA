package jgonzalezca.src.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PreOrderIterator<E> implements Iterator<Position<E>>{
	
	private List<Position<E>> list = new LinkedList<>();
	private Tree<E> a; //a este atributo hemos llegado tratando de implmentar el primer next()
	
	public PreOrderIterator(Position<E> root) {
		this.list.add(root);	
	}
	
	
	public PreOrderIterator(Tree<E> a, Position<E> root) {
		this.list.add(root);	
		this.a = a;
	}
	
	public PreOrderIterator(Tree<E> a) {
		this(a, a.root());	
	}
	


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !list.isEmpty();
		//tambien sirve l.size()>0;
	}

	@Override
	public Position<E> next() {
		// TODO Auto-generated method stub
		Position<E> p = this.list.remove(0);
		
		//el iterador va a necesitar conocer el arbol, esto nos lleva a un segundo atributo
		
		for(Position<E> q : a.children(p)) //si no tengo el atributo arbol, no puedo hacer esto
			list.add(q);
		
		return p;
	}
	
	//esta mal! hemos elegido una lista de hijos, nos hemos equivocado. veremos por que
	//------------------------------------------------------------------
	private List<Position<E>> list = new LinkedList<>();
	private Tree<E> a; //a este atributo hemos llegado tratando de implmentar el primer next()
	
	public PreOrderIterator(Position<E> root) {
		this.list.add(root);	
	}
	
	
	public PreOrderIterator(Tree<E> a, Position<E> root) {
		this.list.add(root);	
		this.a = a;
	}
	
	public PreOrderIterator(Tree<E> a) {
		this(a, a.root());	
	}
	


	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !list.isEmpty();
		//tambien sirve l.size()>0;
	}

	@Override
	public Position<E> next() {
		// TODO Auto-generated method stub
		Position<E> p = this.list.remove(0);
		
		//el iterador va a necesitar conocer el arbol, esto nos lleva a un segundo atributo
		
		for(Position<E> q : a.children(p)) //si no tengo el atributo arbol, no puedo hacer esto
			list.add(q);
		
		return p;
	
	
	
	
}
