package j.gonzalezca.main;

public class ComplexNumber {
	
	private double real;
	private double imag;

    public ComplexNumber(double a, double b){
    	this.real = a;
    	this.imag = b;
    
    }

	public void setReal(double real) {
		this.real = real;
	}


	public void setImag(double imag) {
		this.imag = imag;
	}


    public double realPart(){
       return real;
    }
    
    
    public double imaginaryPart(){
    	return imag;
    }
 
    public ComplexNumber add (ComplexNumber c){
    	return new ComplexNumber(this.real + c.realPart(), this.imag + c.imaginaryPart());
    }
    
    public ComplexNumber subtract (ComplexNumber c){
    	return new ComplexNumber(this.real - c.realPart(), this.imag - c.imaginaryPart());
    }
    
   
    public ComplexNumber multiply (ComplexNumber c){
    	return new ComplexNumber(this.real*c.realPart() - this.imag*c.imaginaryPart(), 
    							this.imag*c.realPart()+ this.real*c.imaginaryPart());
    }
    
  
    public ComplexNumber division (ComplexNumber c){
    	double denominator = Math.pow(c.realPart(), 2) + Math.pow(c.imaginaryPart(), 2);
    	return new ComplexNumber(
    			(this.realPart()*c.realPart()+this.imaginaryPart()*c.imaginaryPart())/denominator,
    			(this.imaginaryPart()*c.realPart()-this.realPart()*c.imaginaryPart())/denominator);
    } 
   
    public ComplexNumber conjugate (){
    	return new ComplexNumber(this.real, -this.imag);
    } 
    

    public double module (){
    	return Math.sqrt(this.realPart()*this.realPart() + this.imaginaryPart()*this.imaginaryPart());
    } 
}
