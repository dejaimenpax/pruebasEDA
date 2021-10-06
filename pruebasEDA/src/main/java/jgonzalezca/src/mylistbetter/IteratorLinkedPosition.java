package jgonzalezca.src.mylistbetter;

import java.util.Iterator;

public class IteratorLinkedPosition<E> implements Iterator<Position<E>> {
	
	private Position<E> pos;
	private LinkedPositionList<E> list;
	
	public IteratorLinkedPosition(LinkedPositionList<E> l){
		this.pos = list.get();
		this.list = l;
	}
	
	public boolean hasNext() {
		return (this.list.getNextPosition() != null);
	}
	
	public Position<E> next(){
		Position<E> aux = this.pos;
		this.pos = this.list.getNextPosition();
		return aux;
	}
	

}
