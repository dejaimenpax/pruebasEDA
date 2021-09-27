/**
 * 
 */
package jgonzalezca.test.complexnumber;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import jgonzalezca.src.complexnumber.ComplexNumber;


public class ComplexNumberTest {

	@Test
	public void realPartTest() {
		//Given
		ComplexNumber c = new ComplexNumber(2.3, 5);
		//When & Then
		Assert.assertEquals("Real part should be 2.3", 2.3, c.realPart(), 0.001);
	}
	
	@Test
	public void imaginaryPartTest() {
		//Given
		ComplexNumber c = new ComplexNumber(2.3, 5);
		//When & Then
		Assert.assertEquals("Imaginary part should be 5" , 5, c.imaginaryPart(), 0.001);
	}
	
	@Test
	public void addTest() {
		//Given
		ComplexNumber c1 = new ComplexNumber(2.3, 5);
		ComplexNumber c2 = new ComplexNumber(4.5, 2.1);
		//When & Then
		Assert.assertEquals("Imaginary part should be 6.8" , 6.8, c1.add(c2).realPart(), 0.001);
		Assert.assertEquals("Imaginary part should be 7.1" , 7.1, c1.add(c2).imaginaryPart(), 0.001);
	}
	
	@Test
	public void subtractTest() {
		//Given
		ComplexNumber c1 = new ComplexNumber(2.3, 5);
		ComplexNumber c2 = new ComplexNumber(4.5, 2.1);
		//When & Then
		Assert.assertEquals("Real part should be -2.2" , -2.2, c1.subtract(c2).realPart(), 0.001);
		Assert.assertEquals("Imaginary part should be 2.9" , 2.9, c1.subtract(c2).imaginaryPart(), 0.001);
	}
	
	
	@Test
	public void multiply() {
		//Given
		ComplexNumber c1 = new ComplexNumber(3, 2);
		ComplexNumber c2 = new ComplexNumber(7, -4);
		//When & Then
		Assert.assertEquals("Real part should be 29" , 29, c1.multiply(c2).realPart(), 0.001);
		Assert.assertEquals("Imaginary part should be 2" , 2, c1.multiply(c2).imaginaryPart(), 0.001);
	}
	
	@Test
	public void division() {
		//Given
		ComplexNumber c1 = new ComplexNumber(3, 1);
		ComplexNumber c2 = new ComplexNumber(4, -2);
		//When & Then
		Assert.assertEquals("Real part should be 0.5" , 0.5, c1.division(c2).realPart(), 0.001);
		Assert.assertEquals("Imaginary part should be 0.5" , 0.5, c1.division(c2).imaginaryPart(), 0.001);
	}
	
	@Test
	public void conjugateTest() {
		//Given
		ComplexNumber c = new ComplexNumber(8, -2);
		//When
		ComplexNumber cc = c.conjugate();
		//Then
		assertEquals("Real part should be 8", c.realPart(), cc.realPart(), 0.001);
		assertEquals("Imaginary part should be 2", -c.imaginaryPart(), cc.imaginaryPart(), 0.001);
	}
	
	@Test
	public void module() {
		//Given
		ComplexNumber c = new ComplexNumber(3, 4);
		//When & Then
		Assert.assertEquals("Module should be 5", 5, c.module(), 0.001);
	}
	

}
