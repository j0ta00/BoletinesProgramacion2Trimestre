package Ejercicio1;

public class Triangulo {
	//Atributos
	private double base;
	private double altura;

	//M�todos fundamentales
	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	//M�todos construcotores
	//Constructor por defecto
	public Triangulo(){
		base=3;
		altura=3;
	}

}
