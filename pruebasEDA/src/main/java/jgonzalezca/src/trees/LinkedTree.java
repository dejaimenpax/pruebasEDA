package jgonzalezca.src.trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author mayte
 * @param <E>
 */
public class LinkedTree<E> implements NAryTree<E> {
	
	private TreeNode<E> root;

    private class TreeNode<T> implements Position<T>{
    	
    	private T element;
    	private TreeNode<T> parent;
		private List<TreeNode<T>> children;
		LinkedTree a; //la recomendacio del profesor para evitar problemas con remove es no poner esto
    	

		TreeNode(LinkedTree a, T element, TreeNode<T> parent){
    		this.element = element;
    		this.parent = parent;
    		this.children = new LinkedList<TreeNode<T>>();
    		this.a = a; //la recomendacio del profesor para evitar problemas con remove es no poner esto, po
    	}
    	

        @Override
        public T getElement() {
        	return this.element;
        }
        
        public TreeNode<T> getParent() {
			return parent;
		}

    	public LinkedTree getA() {
			return a;
		}

		public void setParent(TreeNode<T> parent) {
			this.parent = parent;
		}


		public List<TreeNode<T>> getChildren() {
			return children;
		}


		public void setChildren(List<TreeNode<T>> children) {
			this.children = children;
		}


		public void setElement(T element) {
			this.element = element;
		}
		
		public void newChild(TreeNode<T> child) {
			this.children.add(child);
		}

    }
    
    public LinkedTree(){
    	root = null; //hacemos esto porque hemos visto que existe el metodo addroot
    }
    
	private TreeNode<E> checkPosition(Position<E> p) throws RuntimeException{
		if (p == null || !(p instanceof TreeNode)) {
			throw new RuntimeException("Invalid position");
		}
		TreeNode n = (TreeNode<E>) p;
		if (!n.getA().equals(this)) { //la recomendacio del profesor para evitar problemas con attach y subtree es no poner esto
			throw new RuntimeException("Invalid position"); //compruebo si el getA es igual a mi arbol, esto e simportante. si le paso un position incorrecto al remove de otro arbol daria excepcion
		}
		return n;
	}
    
    @Override
    public Position<E> addRoot(E e) {
    	root = new TreeNode<E>(this, e, null); //el padre es null!
    	return root; //el casteo es innecesario, LinkedNode implementa position, no hay que poner (Position<E>) root
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
    	TreeNode<E> parent;
		try {
			parent = this.checkPosition(p);
	    	TreeNode<E> newNode = new TreeNode<E>(this, element, parent);
	        List<TreeNode<E>> l = parent.getChildren();
	        l.add(newNode);
	        return newNode;	
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
    	
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
		try {
	    	TreeNode<E> origen = this.checkPosition(p1); //esto es lo primero que hago siempre que me den positions
			TreeNode<E> destino = this.checkPosition(p2);
	    	E newElement = origen.getElement();
	    	origen.setElement(destino.getElement());
	    	destino.setElement(newElement);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public E replace(Position<E> p, E e) {
    	TreeNode<E> node;
		try {
			node = checkPosition(p);
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
        E temp = p.getElement();
        node.setElement(e);
        return temp;
    }

    @Override
    public void remove(Position<E> p) { //no sirve con esto, como tengo referencia al padre y me convierto a null, mi padre sigue teniendo una referencia a mi (soy un nodo), asiq hay que recorrer
		try {
	    	TreeNode<E> node = checkPosition(p);
	    	if (node.getParent() == null) {
	    		this.root=null;
	    	}
	    	else {
	    		node.getParent().getChildren().remove(node);	
	    	}  	
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
    	try {
	    	TreeNode<E> node = checkPosition(v);
	    	LinkedTree<E> salida = new LinkedTree<>();
	    	salida.addRoot(v.getElement());
	    	return salida;
		} catch (RuntimeException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
    	
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
    	if (t == null || (t instanceof LinkedTree)) { //redundante? ya se hace una comprobacion de que la raiz de t sea del mismo tipo justo debajo
    		try{
    	
    		TreeNode<E> treeRoot = t.checkPosition(t.root()); //ojo, aqui hay problemas, como casteamos a position la raiz de t?
    		TreeNode<E> anclaje = this.checkPosition(p);
    		treeRoot.setParent(anclaje);
    		anclaje.getChildren().add(treeRoot);
    		} catch (RuntimeException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
    	}
    }

    @Override
    public boolean isEmpty() {
    	return (root==null);
    }

    @Override
    public Position<E> root() {
    	return root;
    }

    @Override
    public Position<E> parent(Position<E> v) {
		TreeNode<E> nodo;
		try {
			nodo = this.checkPosition(v);
			return nodo.getParent();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
    	
    }
 
    public int size(){
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
}
