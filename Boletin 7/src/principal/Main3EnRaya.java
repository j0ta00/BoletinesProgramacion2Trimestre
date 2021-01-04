package principal;
import java.util.Scanner;

import jugadores.Bot;
import jugadores.Jugador;
import partida.Partida;
/*Clases: Main: CLASE PRINCIPAL
 * 
 * Clases: Partida:
 * 
 * Atributos:Tablero,Turno
 * 
 * M�todos:nuevoTurno(),imprimirTablero(),comprobarSiTresEnRaya(),
 * 
 * Clase: Jugador:
 * 
 * 
 * Atributo:Ficha,Nombre
 * 
 * M�todos:colocarFicha(),retirarse()
 * 
 * 
 * Subclase de Jugador: IA
 * 
 * Atributo:Dificultad,Nombre
 * 
 * M�todos:colocarFicha(),comentarioSarcastico()
 * */
public class Main3EnRaya {
	//Objeto teclado
	static Scanner teclado=new Scanner(System.in);
	
	public static void main(String[] args) {	
		menu();//llamada al m�todo men� del juego	
	}
	
	/*
	 * Cabecera:public static void menu()
	 * Proposito:Muestra un men� al usuario con las distintas opciones a las que puede jugar el usuario
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un procedimiento e imprime en pantalla un men�
	 * */
	public static void menu(){
		int respuesta=0;
		String nombreJugador="";
		char ficha=' ';
		Jugador j1 = new Jugador();//creaci�n objeto j1(Jugador 1) se crea antes para poder llamar al m�todo retirada
		do{
			System.out.println("Bienvenido al juego del tres en raya,introduce el modo de juego al que desea jugar:");
			System.out.println("1) Modo dos jugadores");
			System.out.println("2) Modo contra la CPU");
			respuesta=teclado.nextInt();
			while(respuesta<1 || respuesta>2){//mientras no se introduzca un modo de juego v�lido
				System.out.println("Introduce un modo de juego existente");
				respuesta=teclado.nextInt();
			}
			Partida partida = new Partida();//creaci�n objeto partida
			System.out.println("Introduce tu nombre Jugador 1");
			j1.setNombre(teclado.next());//elecci�n del nombre del j1
			System.out.println("Introduce un car�cter y ser� tu ficha");
			j1.setFicha(teclado.next().charAt(0));//elecci�n de la ficha del j1
			switch(respuesta){//segun la respuesta se entra a un modo de juego u otro
				case 1->{
					System.out.println("Introduce tu nombre Jugador 2");
					nombreJugador=teclado.next();//elecci�n del nombre del j2
					System.out.println("Introduce un car�cter y ser� tu ficha");
					ficha=teclado.next().charAt(0);//elecci�n de la ficha del j1
					while(ficha==j1.getFicha() || Character.isDigit(j1.getFicha()) || Character.isDigit(ficha)){//mientras la ficha sea iguales en los dos jugadores o alguna de las fichas sea un n�mero se volver� a pedir los datos de ambos jugadores
						System.out.println("Introduce un car�cter distinto al de t� compa�ero y adem�s que no sea un n�mero Jugador 1");
						j1.setFicha(teclado.next().charAt(0));
						System.out.println("Introduce un car�cter distinto al de t� compa�ero y adem�s que no sea un n�mero Jugador 2");
						ficha=teclado.next().charAt(0);
					}
					Jugador j2 = new Jugador(ficha,nombreJugador);//creaci�n del objeto j2(Jugador 2)
					partida.partida2Jugadores(j1,j2,partida);//llamada al m�todo partida entre dos jugadores
				}
				case 2->{
					Bot Ia = new Bot();//creaci�n del objeto Ia
					partida.partidaVSCPU(j1, Ia, partida);//llamada al m�todo partida contra la CPU
				}
			}
		}while(j1.salirDelJuego()==false);//mientras quieran seguir jugando es decir no se retiren
	}
}