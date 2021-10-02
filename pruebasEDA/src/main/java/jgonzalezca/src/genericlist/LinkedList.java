package jgonzalezca.src.genericlist;



public class LinkedList<E> implements GenericList<E> {
	
    private class Node<E>{
        
        private E elem;
        private Node<E> next;

        public E getElem() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
        
        public Node(E e, Node<E> sig){
            this.elem = e;
            this.next = sig;
        }      
        
        public Node(E e) {
        	this(e, null);
        }
             
    }
    
    private Node<E> head;
	private int size;
	
	public LinkedList() {
		this.head = null;
		this.size = 0;
	}

    public int size() {
    	return this.size;
    }

    public boolean isempty() {
    	return this.head==null;
    }


    public void add(E value) {
    	if (value != null) {
    		Node<E> newNode = new Node<E>(value);
    		newNode.setNext(this.head);
    		this.head = newNode;
    		size++;
    	}
    }


    public void add(int index, E value){
    	if ((index>=1)&&(index<=size)&&(!this.isempty())) {
    		if (index==1) {
    			Node<E> newNode = new Node<E>(value, this.head);
    			this.head = newNode;
    		}
    		else {
    			Node<E> prev = this.head;
    			Node<E> follow = prev.getNext();
    			for (int pos = 1; pos<index; pos++) {
    				prev = follow;
    				follow = prev.getNext();
    			}
    			Node<E> newNode = new Node<E>(value, follow);
    			prev.setNext(newNode);		
    		}
    		size++;
    	}
    }

    
    public E remove() {
    	if (!this.isempty()){
    		E first = this.head.getElem();
    		this.head = this.head.getNext();
    		size--;
    		return first;
    	}
    	else
    		return null;  	
    }

   
    public E remove(int index) {
    	if ((index>=1)&&(index<=size)&&(!this.isempty())) {
    		size--;
    		if (index==1) {
    			E first = this.head.getElem();
        		this.head = this.head.getNext();
        		return first;
    		}
    		else {
       			Node<E> prev = this.head;
    			Node<E> follow = prev.getNext();
    			for (int pos = 1; pos<index; pos++) {
    				prev = follow;
    				follow = prev.getNext();
    			}
    			E ele = prev.getElem();
    			prev.setNext(follow.getNext());	
    			return ele;
    		}
    	}
    	else
    		return null;
    }

    
    public E get() {
    	return this.head.getElem();
    }

    
    public E get(int index) {
    	if ((index>=1)&&(index<=size)&&(!this.isempty())) {
    		if (index==1) {
    			return this.head.getElem();
    		}
    		else {
    			Node<E> follow = this.head;
    			for (int pos = 1; pos<index; pos++) {
    				follow = follow.getNext();
    			}
    			return follow.getElem();
    		}
    	}
    	else
    		return null;
    }

    
    public int search(E value) {
    	if (this.isempty()) 
    		return 0;
    	else if (this.head.getElem().equals(value))
    		return 1;
    	else {
    		int pos = 1;
    		Node<E> follow = this.head;
    		while (pos<size) {
    			follow = follow.getNext();
    			pos++;
    			if (follow.getElem().equals(value)) {
    				return pos;
    			}
    		}
    	}
    	return 0;			
    }

    
    public boolean contains(E value) {
    	if (this.isempty()) 
    		return false;
    	else if (this.head.getElem().equals(value))
    		return true;
    	else {
    		int pos = 1;
    		Node<E> follow = this.head;
    		boolean encontrado = false;
    		while ((pos<size)&&(!encontrado)) {
    			follow = follow.getNext();
    			pos++;
    			if (follow.getElem().equals(value)) {
    				encontrado = true;
    			}
    		}
    		return encontrado;
    	}
    }

}
