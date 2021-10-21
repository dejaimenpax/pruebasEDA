package jgonzalez.src.binarytrees;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author mayte
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {
	
	private ArrayList<Node<E>> tree;
	
	private class Node<T> implements Position<T> {
		
		private T element;
		private boolean valid;
		private int n; //en que indice esta el position
		
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		
		public T getElement() {
			return element;
		}
		public void setElement(T e) {
			this.element = e;
		}
		public boolean isValid() {
			return valid;
		}
		public void setValid(boolean valid) {
			this.valid = valid;
		}

	}

    @Override
    public Position<E> left(Position<E> v) {
    	Node<E> node = checkPosition(v);
    	int index = node.getN() * 2 + 1;
    	return tree.get(index);
    }

    @Override
    public Position<E> right(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasRight(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isInternal(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position<E> p) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> root() {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Position<E> p, E e) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> addRoot(E e) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(Position<E> p) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> parent(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachLeft(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachRight(Position<String> h, BinaryTree<String> t1) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BinaryTree<String> subTree(Position<String> h) {
        throw new UnsupportedOperationRuntimeException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
