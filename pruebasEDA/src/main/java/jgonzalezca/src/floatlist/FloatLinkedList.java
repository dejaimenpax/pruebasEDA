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
    	return size==0;
    }


    public void add(Float value) {
    	if (value != null) {
    		FloatNode newNode = new FloatNode(value);
    		newNode.setNext(this.head);
    		this.head = newNode;
    		size++;
    	}
    }


    public void add(int index, Float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Float remove() {
    	Float first = this.head.getElem();
    	this.head = this.head.getNext();
    	return first;
    }

   
    public Float remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Float get() {
    	return this.head.getElem();
    }

    
    public Float get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int search(Float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean contains(Float value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
