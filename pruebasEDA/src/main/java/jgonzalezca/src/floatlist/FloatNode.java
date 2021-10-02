package jgonzalezca.src.floatlist;

public class FloatNode{
	
	private Float element;
	private FloatNode next;
	
	
	public FloatNode(Float n, FloatNode node) {
		this.element = Float.valueOf(n);
		this.next = node;
	}
	
	public FloatNode(Float n) {
		this(n, null);
	}
	
	public FloatNode() {
		this(0f, null);
	}
	

	public void setElement(Float e) {
		this.element = e;
	}
	
	public Float getElem() {
		return element;
	}

	public FloatNode getNext() {
		return next;
	}

	public void setNext(FloatNode node) {
		this.next = node;
	}
	
	public FloatNode copy() {
		return new FloatNode(this.element, this.next);
	}
	
	public boolean isLast() {
		return next==null;
	}

}
