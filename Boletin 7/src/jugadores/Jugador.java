package jugadores;

import java.util.Scanner;

import partida.Partida;

public class Jugador {
	//Objeto teclado
	Scanner teclado=new Scanner(System.in);
	//Atributos
	protected char ficha;
	protected String nombre;
	//Constructor por defecto
		public Jugador(){
			
			ficha=' ';
			nombre="";
			
		}
		//Constructor por par�metros
			public Jugador(char ficha,String nombre){
				
				this.ficha=ficha;
				this.nombre=nombre;;
				
			}
	//M�todos Fundamentales
	
	//Get Nombre
	public String getNombre() {
		return nombre;
	}
	//Get Ficha
		public char getFicha() {
			return ficha;
		}
	//Set Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	//Set Ficha
	public void setFicha(char ficha) {
		this.ficha = ficha;
	}
	/*
	 * Cabecera:public void colocarFicha(Partida partida)
	 * Proposito:M�todo para pedir al jugador en que casilla quiere colocar la ficha
	 * Entrada:Partida partida
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un procedimiento para pedir datos al usuario
	 * */
	public void colocarFicha(Partida partida){
		int casilla=0;
		boolean colocada=false;
		do {
			casilla=teclado.nextInt();
			switch(casilla) {//se�n la casilla introducida se le pasar� por par�metros una cosa u otra
				case 1->colocada=partida.colocarFichaEnElArray(0,0,getFicha());//llamada al m�todo de colocar ficha en el array 
				case 2->colocada=partida.colocarFichaEnElArray(0,1,getFicha());//llamada al m�todo de colocar ficha en el array
				case 3->colocada=partida.colocarFichaEnElArray(0,2,getFicha());//llamada al m�todo de colocar ficha en el array
				case 4->colocada=partida.colocarFichaEnElArray(1,0,getFicha());//llamada al m�todo de colocar ficha en el array
				case 5->colocada=partida.colocarFichaEnElArray(1,1,getFicha());//llamada al m�todo de colocar ficha en el array
				case 6->colocada=partida.colocarFichaEnElArray(1,2,getFicha());//llamada al m�todo de colocar ficha en el array
				case 7->colocada=partida.colocarFichaEnElArray(2,0,getFicha());//llamada al m�todo de colocar ficha en el array
				case 8->colocada=partida.colocarFichaEnElArray(2,1,getFicha());//llamada al m�todo de colocar ficha en el array
				case 9->colocada=partida.colocarFichaEnElArray(2,2,getFicha());//llamada al m�todo de colocar ficha en el array
			}
		}while(colocada==false);//mientras no se  haya colocado se repetira la entrada de la ficha y llamda  posterior al m�todo para introducirla en el array
	}
	/*
	 * Cabecera:public boolean salirDelJuego()
	 * Proposito:
	 * Entrada:Ninguna
	 * Salida:boolean reitrada
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un funci�n que devuelve un booleano retirada
	 * */
	public boolean salirDelJuego(){
		char respuesta=' ';
		boolean restirada=false;
		System.out.println("�Quieres seguir jugando? Introduce 'n' para salir o cualquier tecla para continuar jugando");
		respuesta = Character.toLowerCase(teclado.next().charAt(0));//convertimos a respuesta en min�scula
		if(respuesta=='n'){//si respuesta es n
			restirada=true;//la retirada ser� true y no se volver� a jugar
		}
		return restirada;
	}
}
