package Ejercicio2;

public class Cuadrado {
	//Atributo
	private int lado;
	
	//Métodos constructores
	//Constructor por defecto
	public Cuadrado() {
		lado=5;
	}

	//Métodos fundamentales
	//Getters
	public int getLado() {
		return lado;
	}

	public int getArea(){
		return lado*=lado;
	}
	//Set
	public void setLado(int lado) {
		this.lado = lado;
	}
	//Métodos Adicionales
	public void printCuadrado(char caracter){
		llamarAlImprimirCaracteres(caracter);
	}
	//Métodos auxiliares
	private void llamarAlImprimirCaracteres(char caracter){
		imprimirCaracteres(lado,caracter);
		System.out.println();
		for(int i=0;i<lado-2;i++){
			imprimirCaracteres(1,caracter);
			imprimirCaracteres(lado-2,' ');
			imprimirCaracteres(1,caracter);
			System.out.println();
		}
		imprimirCaracteres(lado,caracter);
	}
	private void imprimirCaracteres(int indice,char caracter){
		for(int i=0;i<indice;i++){
			System.out.print(caracter+" ");
		}
	}
}
