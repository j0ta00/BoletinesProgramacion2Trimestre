package principal;
import java.util.Scanner;
import partida.Partida;
/*Clases: Main: CLASE PRINCIPAL
 * 
 * Clases: Partida:
 * 
 * Atributos:Tablero,Turno
 * 
 * Métodos:nuevoTurno(),imprimirTablero(),comprobarSiTresEnRaya(),
 * 
 * Clase: Jugador:
 * 
 * 
 * Atributo:Ficha,Nombre
 * 
 * Métodos:colocarFicha(),retirarse()
 * 
 * 
 * Subclase de Jugador: IA
 * 
 * Atributo:Dificultad,Nombre
 * 
 * Métodos:colocarFicha(),comentarioSarcastico()
 * */
public class Main3EnRaya {
	//Objeto teclado
	static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {	
		menu();//llamada al método menú del juego	
	}
	
	/*
	 * Cabecera:public static void menu()
	 * Proposito:Muestra un menú al usuario con las distintas opciones a las que puede jugar el usuario
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondición:Ninguna
	 * Postcondición:Se trata de un procedimiento e imprime en pantalla un menú
	 * */
	public static void menu(){
		int respuesta=0;
		Partida partida = new Partida();//creación objeto partida
		do{
			System.out.println("Bienvenido al juego del tres en raya,introduce el modo de juego al que desea jugar:");
			System.out.println("1) Modo dos jugadores");
			System.out.println("2) Modo contra la CPU");
			respuesta=teclado.nextInt();
			while(respuesta<1 || respuesta>2){//mientras no se introduzca un modo de juego válido
				System.out.println("Introduce un modo de juego existente");
				respuesta=teclado.nextInt();
			}
			System.out.println("Introduce tu nombre Jugador 1");
			partida.getJugador().setNombre(teclado.next());//elección del nombre del j1
			System.out.println("Introduce un carácter y será tu ficha");
			partida.getJugador().setFicha(teclado.next().charAt(0));//elección de la ficha del j1
			switch(respuesta){//según la respuesta se entra a un modo de juego u otro
				case 1->{
					System.out.println("Introduce tu nombre Jugador 2");
					partida.getJugador2().setNombre(teclado.next());//elección del nombre del j2
					System.out.println("Introduce un carácter y será tu ficha");
					partida.getJugador2().setFicha(teclado.next().charAt(0));//elección de la ficha del j1
					while(partida.getJugador2().getFicha()==partida.getJugador().getFicha()|| Character.isDigit(partida.getJugador().getFicha()) || Character.isDigit(partida.getJugador2().getFicha())){//mientras la ficha sea iguales en los dos jugadores o alguna de las fichas sea un número se volverá a pedir los datos de ambos jugadores
						System.out.println("Introduce un carácter distinto al de tú compañero y además que no sea un número Jugador 1");
						partida.getJugador().setFicha(teclado.next().charAt(0));
						System.out.println("Introduce un carácter distinto al de tú compañero y además que no sea un número Jugador 2");
						partida.getJugador2().setFicha(teclado.next().charAt(0));
					}
					partida.partida2Jugadores(partida);//llamada al método partida entre dos jugadores
				}
				case 2->{
					while( Character.isDigit(partida.getJugador().getFicha())){//mientras la ficha sea un número se volverá a pedir los datos
						System.out.println("Introduce un carácter que no sea un número Jugador 1");
						partida.getJugador().setFicha(teclado.next().charAt(0));
					}
					partida.partidaVSCPU(partida);//llamada al método partida contra la CPU
				}
			}
			partida.setTurno(1);
		}while(partida.getJugador().salirDelJuego()==false);//mientras quieran seguir jugando es decir no se retiren
	}
}