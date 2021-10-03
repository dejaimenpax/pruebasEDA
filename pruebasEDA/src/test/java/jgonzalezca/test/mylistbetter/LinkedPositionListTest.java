package jgonzalezca.test.mylistbetter;

import org.junit.Test;

import jgonzalezca.src.genericlist.LinkedList;
import jgonzalezca.src.mylistbetter.LinkedPositionList;
import jgonzalezca.src.mylistbetter.Position;

import static org.junit.Assert.*;

public class LinkedPositionListTest<E> {
	
	public LinkedPositionListTest() {
    }
	
	 public LinkedPositionList<Integer> inicializa(){
	       
	        LinkedPositionList<Integer> instance = new LinkedPositionList<>();
	        
	        instance.add(new Integer(3));
	        instance.add(new Integer(8));
	        instance.add(new Integer(12));
	        
	        return instance; //[12, 8, 3]
	    }
	    /**
	     * Test of size method, of class FloatLinkedList.
	     */
	    @Test
	    public void testSize() {
	        System.out.println("size");
	        LinkedPositionList<Integer> instance = inicializa();
	              
	        int expResult = 3;
	        int result = instance.size();
	        assertEquals(expResult, result);
	    }

	    /**
	     * Test of isempty method, of class FloatLinkedList.
	     */
	    @Test
	    public void testIsempty1() {
	        System.out.println("isempty");
	        LinkedPositionList<Integer> instance = inicializa();
	        boolean expResult = false;
	        boolean result = instance.isempty();
	        assertEquals(expResult, result);
	       
	    }

	    /**
	     * Test of isempty method, of class FloatLinkedList.
	     */
	    @Test
	    public void testIsempty2() {
	        System.out.println("isempty");
	        LinkedPositionList<Integer> instance = new LinkedPositionList<>();
	        boolean expResult = true;
	        boolean result = instance.isempty();
	        assertEquals(expResult, result);
	       
	    }
	    
	    /**
	     * Test of add method, of class FloatLinkedList.
	     */
	    @Test
	    public void testAdd_Float() {
	        System.out.println("add");
	        Integer value = null;
	        LinkedPositionList<Integer> instance = new LinkedPositionList<>();
	        assertTrue(instance.isempty());
	        Position<Integer> pos = instance.add(new Integer(2));
	        assertFalse(instance.isempty());
	        assertEquals(instance.size(),1);
	        assertEquals(pos.getElement(), 2, 0.01);
	    }
	   
	     
	    /**
	     * Test of add and remove methods, of class FloatLinkedList.
	     * @throws Exception 
	     */
	    
	    @Test
	    public void testAddBefore_int_Remove() throws Exception {
	        System.out.println("addBefore");
	        Integer value = new Integer(5);
	        LinkedPositionList<Integer> instance = inicializa(); // [12, 8, 3]
	        Position<Integer> index = instance.get();
	        instance.addBefore(index, value); // [5, 12, 8, 3]
	        assertEquals(instance.size(),4); 
	        Integer remove = instance.remove(instance.get()); //12 8 3
	        assertEquals(5.0,remove,0.01); 
	        index = instance.get(); //index esta en 12
	        Position<Integer> pos2 = instance.addAfter(index, 1); //12 1 8 3, pos esta en 1
	        assertEquals(pos2.getElement(), 1, 0.01);
	        remove = instance.remove(instance.get()); //1 8 3
	        assertEquals(12.0,remove,0.01);
	        remove = instance.remove(instance.get()); //8 3
	        assertEquals(1.0,remove,0.01);
	        remove = instance.remove(instance.get()); //3
	        assertEquals(8.0,remove,0.01);
	        remove = instance.remove(instance.get()); //null
	        assertEquals(3.0,remove,0.01);
	        assertTrue(instance.isempty());
	    }

	    /**
	     * Test of remove method, of class FloatLinkedList.
	     * @throws Exception 
	     */
	     
	    @Test
	    public void testRemove_int() throws Exception {
	        System.out.println("remove");
	        LinkedPositionList<Integer> instance = inicializa(); // [12, 8, 3]
	        Position<Integer> index = instance.addAfter(instance.get(), 4); // 12 4 8 3
	        Integer result = instance.remove(index);// 4
	        assertEquals(4.0, result,0.01);
	       
	    }

	    /**
	     * Test of get method, of class FloatLinkedList.
	     */
	    @Test
	    public void testGet_0args() {
	        System.out.println("get");
	        LinkedPositionList<Integer> instance = inicializa(); // [12, 8, 3]
	        Position<Integer> result = instance.get();//12
	        assertEquals(12.0, result.getElement(),0.01);
	        
	    }

	  

	    /**
	     * Test of search method, of class FloatLinkedList.
	     */
	    @Test
	    public void testSearch() {
	        System.out.println("search");
	        Integer value = new Integer(5);
	        LinkedPositionList<Integer> instance = inicializa();// [12, 8, 3]
	        int expResult = 0;
	        Position<Integer> result = instance.search(value);
	        assertEquals(expResult, result.getElement(), 0.001);
	        value = new Integer(3);
	        expResult = 3;
	        result = instance.search(value);
	        assertEquals(expResult, result.getElement(), 0.001);
	    }

	    /**
	     * Test of contains method, of class FloatLinkedList.
	     
	    
	    @Test
	    public void testContains() {
	        System.out.println("contains");
	        Integer value = new Integer(5);
	        LinkedList<Integer> instance = inicializa();// [12, 8, 3]
	        boolean result = instance.contains(value);
	        assertFalse(result);
	        value = new Integer(12);
	        result = instance.contains(value);
	        assertTrue(result);
	    }
	
*/
}
