package jgonzalezca.src.mylistbetter;

import java.util.Iterator;

public class LinkedPositionList<E> implements MyListBetter<E> {
	
	private class LinkedNode<E> implements Position<E>{
        
        private E elem;
        private LinkedNode<E> prev;
        private LinkedNode<E> next;

        public E getElement() {
            return elem;
        }

        public void setElement(E elem) {
            this.elem = elem;
        }

        public LinkedNode<E> getNext() {
            return next;
        }
        
        
        public LinkedNode<E> getPrev() {
            return prev;
        }

        public void setNext(LinkedNode<E> next) {
            this.next = next;
        }
        
        public void setPrev(LinkedNode<E> prev) {
            this.prev = prev;
        }
        
        public LinkedNode(E e, LinkedNode<E> ant, LinkedNode<E> sig){
            this.elem = e;
            this.next = sig;
            this.prev = ant;
        }      
        
        public LinkedNode(E e) {
        	this(e, null, null);
        }
             
    }
	
	private LinkedNode<E> head;
	private int size;
	
	public LinkedPositionList() {
		this.head = null;
		this.size = 0;
	}
	
	private LinkedNode<E> checkPosition(Position<E> p) throws Exception{
		if (p == null || !(p instanceof LinkedNode)) {
			throw new Exception("Invalid position");
		}
		return (LinkedNode<E>) p;
	}

    public int size() {
    	return this.size;
    }
    
    public boolean isempty() {
    	return this.head==null;
    }
    
    public Position<E> add(E value) {
    	LinkedNode<E> newNode = new LinkedNode<E>(value, null, this.head);
    	if (!this.isempty()){
    		this.head.setPrev(newNode);
    	}
    	this.head = newNode;
    	size++;	
    	return (Position<E>) newNode; //el casteo es innecesario, LinkedNode implementa position
    }
    
    public Position<E> addAfter(Position<E> pos, E value){
    	try {
			LinkedNode<E> prevNode = this.checkPosition(pos);
			LinkedNode<E> newNode = new LinkedNode<>(value, prevNode, prevNode.getNext());
			prevNode.setNext(newNode);
			if (prevNode.getNext()!=null){
				prevNode.getNext().setPrev(newNode);
			}
			this.size++;
			return (Position<E>) newNode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  	
    }
    
    public Position<E> addBefore(Position<E> pos, E value){
    	try {
			LinkedNode<E> nextNode = this.checkPosition(pos);
			LinkedNode<E> newNode = new LinkedNode<>(value, nextNode.getPrev(), nextNode);
			if (this.head==nextNode)
				this.head = newNode;
			else if (nextNode.getPrev()!=null)
				nextNode.getPrev().setNext(newNode);
			nextNode.setPrev(newNode);
			this.size++;
			return (Position<E>) newNode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}  	
    }
    
    public E remove(Position<E> pos){
    	try {
			if (!this.isempty()){
				LinkedNode<E> ourNode = this.checkPosition(pos);
				E elem = ourNode.getElement();
				if ((ourNode.getNext()==null)&&(ourNode.getPrev()==null)) {
					this.head=null;
				}
				else if (ourNode.getPrev()==null) {
					ourNode.getNext().setPrev(null);
					this.head = ourNode.getNext();
				}
				else if (ourNode.getNext()==null) {
					ourNode.getPrev().setNext(null);
				}
				else {
					ourNode.getPrev().setNext(ourNode.getNext());
					ourNode.getNext().setPrev(ourNode.getPrev());
				}
				size--;
				return elem;
			}
			else
				throw new RuntimeException("Empty list!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public Position<E> get(){
    	if (!this.isempty())
    		return (Position<E>) this.head;
    	else
    		throw new RuntimeException("Empty list!");  	
    }
    
    public Position<E> set(Position<E> pos, E value){
    	try {
			LinkedNode<E> ourNode = this.checkPosition(pos);
			ourNode.setElement(value);
			return (Position<E>) ourNode;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }
    
    public Position<E> search(E value){
    	if (this.isempty()) {
    		return null;
    	}
    	else {
    	Iterator<Position<E>> it = this.iterator();
    	Position<E> pos = null;
    	while (it.hasNext()) {
    		pos = it.next();
    		if (pos.getElement().equals(value))
    			return pos;
    	}
    	return pos;
    	}
    }
    
    public boolean contains (E value) {
    	return (search(value)==null);
    }
    
    public Iterator<Position<E>> iterator(){
    	return new IteratorLinkedPosition<>(this);
    }
    
    public Position<E> getNextPosition(){
		try {
			return (Position<E>) this.checkPosition(head.getNext()); //redundante?
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
    }
    

}
