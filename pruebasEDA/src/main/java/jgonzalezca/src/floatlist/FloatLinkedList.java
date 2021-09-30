package jgonzalezca.src.floatlist;

public class FloatLinkedList implements FloatList{
	
	private FloatNode head;
	private int size;
	
	public FloatLinkedList() {
		this.head = null;
		this.size = 0;
	}

    public int size() {
    	return this.size;
    }

    public boolean isempty() {
    	return this.head==null;
    }


    public void add(Float value) {
    	if (value != null) {
    		FloatNode newNode = new FloatNode(value);
    		newNode.setNext(this.head);
    		this.head = newNode;
    		size++;
    	}
    }


    public void add(int index, Float value){
    	if ((index>=1)&&(index<=size)&&(!this.isempty())) {
    		if (index==1) {
    			FloatNode newNode = new FloatNode(value, this.head);
    			this.head = newNode;
    		}
    		else {
    			FloatNode prev = this.head;
    			FloatNode follow = prev.getNext();
    			for (int pos = 1; pos<index; pos++) {
    				prev = follow;
    				follow = prev.getNext();
    			}
    			FloatNode newNode = new FloatNode(value, follow);
    			prev.setNext(newNode);		
    		}
    		size++;
    	}
    }

    
    public Float remove() {
    	if (!this.isempty()){
    		Float first = this.head.getElem();
    		this.head = this.head.getNext();
    		size--;
    		return first;
    	}
    	else
    		return null;  	
    }

   
    public Float remove(int index) {
    	if ((index>=1)&&(index<=size)&&(!this.isempty())) {
    		size--;
    		if (index==1) {
    			Float first = this.head.getElem();
        		this.head = this.head.getNext();
        		return first;
    		}
    		else {
       			FloatNode prev = this.head;
    			FloatNode follow = prev.getNext();
    			for (int pos = 1; pos<index; pos++) {
    				prev = follow;
    				follow = prev.getNext();
    			}
    			Float ele = prev.getElem();
    			prev.setNext(follow.getNext());	
    			return ele;
    		}
    	}
    	else
    		return null;
    }

    
    public Float get() {
    	return this.head.getElem();
    }

    
    public Float get(int index) {
    	if ((index>=1)&&(index<=size)&&(!this.isempty())) {
    		if (index==1) {
    			return this.head.getElem();
    		}
    		else {
    			FloatNode follow = this.head;
    			for (int pos = 1; pos<index; pos++) {
    				follow = follow.getNext();
    			}
    			return follow.getElem();
    		}
    	}
    	else
    		return null;
    }

    
    public int search(Float value) {
    	if (this.isempty()) 
    		return 0;
    	else if (this.head.getElem().equals(value))
    		return 1;
    	else {
    		int pos = 1;
    		FloatNode follow = this.head;
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

    
    public boolean contains(Float value) {
    	if (this.isempty()) 
    		return false;
    	else if (this.head.getElem().equals(value))
    		return true;
    	else {
    		int pos = 1;
    		FloatNode follow = this.head;
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
