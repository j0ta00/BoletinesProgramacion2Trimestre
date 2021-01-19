package Ejercicio1;

public class Triangulo {
	//Atributos
	private double base;
	private double altura;
	
	//Métodos construcotores
		//Constructor por defecto
		public Triangulo(){
			base=3;
			altura=3;
		}

	//Métodos fundamentales
	//Getters
	public double getBase() {
		return base;
	}
	public double getAltura() {
		return altura;
	}
	//Setters
	public void setBase(double base) {
		this.base = base;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}

}
