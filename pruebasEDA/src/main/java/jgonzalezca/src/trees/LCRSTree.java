package jgonzalezca.src.trees;


import java.util.Iterator;

import com.sun.tools.javac.util.List;



/**
 *
 * @author mayte
 * @param <E>
 */
public class LCRSTree<E> implements NAryTree<E> {
	
	private LCRSnode<E> root;
	private int size; //ojo esto da problemas con subtree
    
    private class LCRSnode<T> implements Position<T>{
    	private T element;
    	private LCRSnode<T> parent;
		private LCRSnode<T> lchild;
    	private LCRSnode<T> sibling;
    	//el atributo size podria estar aqui, cuesta sus hermanos

    	public LCRSnode<T> getParent() {
			return parent;
		}

		public void setParent(LCRSnode<T> parent) {
			this.parent = parent;
		}

		public LCRSnode<T> getLchild() {
			return lchild;
		}

		public void setLchild(LCRSnode<T> lchild) {
			this.lchild = lchild;
		}

		public LCRSnode<T> getSibling() {
			return sibling;
		}

		public void setSibling(LCRSnode<T> sibling) {
			this.sibling = sibling;
		}

		public void setElement(T element) {
			this.element = element;
		}

        @Override
        public T getElement() {
            throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        public LCRSnode(T element) {
        	this.element=element;
        	this.lchild = null;
        	this.sibling = null;
        	this.parent = null;
        }
    
    }

    public LCRSTree() {
    	this.root=null;
    }
    
    @Override
    public Position<E> addRoot(E e) {
    	this.root = new LCRSnode(e);
    	return this.checkPosition(root);
    }
    
    private LCRSnode<E> checkPosition(Position<E> p) throws RuntimeException{
		if (p == null || !(p instanceof LCRSnode)) {
			throw new RuntimeException("Invalid position");
		}
		return (LCRSnode<E>) p;
	}

    @Override
    public Position<E> add(E element, Position<E> p) {
    	//debo preguntar si el nodo p tiene hijo izquierdo, si no tiene es bien sencillo (creo un nodo y se lo engancho como hijo izquierdo al position casteado)
    	//si tiene, tengo que ir a su hijo izquierdo y engancharselo como hermano, recomendable crear una funcion interna "añadir hermano" (si es vacio le pego el hermano recursivamente)
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
    	//aqui es mejor recorrer por los hermanos no con la funcion recursiva añadir hermano, sino con un bucle (para recorrer los n primeros). si no, usar una funcion recursiva con una n que va restando
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Position<E> p, E e) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Position<E> p) { //asumimos que pasamos un position de arbol
    	//en el linked tree iba al padre, em daba la lista de hijos y tenia que recoirrerla para borrarme
    	//aqui no hay lista de hijos, es tan sencillo como ir al padre y ver si soy su hijo izquierdo, si no lo soy buscar en los siblings "borrarhermano"
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
    	//si es un attach sin posicion puedo hacerlo en O(1), ya que voy a mi padre, voy a su hijo izquierdo, su hijo izquierdo actual se convierte en mi hermano y el nuevo nodo pasa a ser el hijo izquierdo
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> root() {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> parent(Position<E> v) { //podria ser static
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /* Y si quiero un getChildren?
     * tengo que construir una lista de nodos preguntado por todos los hermanos
     * si me pidiesen un orden haria una cola
     * 
     */

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
    	LCRSnode<E> n = this.checkPosition(v);
    	List<LCRSnode<E>> h = new LinkedList<LCRSnode<E>>();
    	if (n.hasLChild()) //si tiene hijos izquierdos llamo a la funcion aux que añade hermanos
    		addSibling(h,n.getLchild());
    	return h;
    }
    
    private void addSibling(List<LCRSnode<E>> h, LCRSnode<E> n) {
    	h.add(n);
    	if (n.hasSibling()) then
    		addSibling(h, n.getSibling());
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
    public boolean isRoot(Position<E> v) {  //podria ser static
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() { //si nuestro preorderiterator estuviese bien hecho nos serviria
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int size() {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}