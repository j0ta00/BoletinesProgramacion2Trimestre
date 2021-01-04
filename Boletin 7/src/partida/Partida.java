package partida;

import java.util.Scanner;

import jugadores.Bot;
import jugadores.Jugador;

public class Partida {
	//Objeto teclado
	Scanner teclado=new Scanner(System.in);
	//Atributos
	private char[][] tablero;
	private int turno;
	//Constructor por defecto
	public Partida(){
		
		tablero=new char[3][3];
		turno=1;
		
	}
	//Constructor por par�metros
		public Partida(char[][] tablero,int turno){
			
			this.tablero=tablero;
			this.turno=turno;
			
		}
	
	
	//M�todos fundamentales
	
	//Get tablero
	public char[][] getTablero() {
		return tablero;
	}
	//Get turno
	public int getTurno() {
		return turno;
	}
	//Set tablero
	public void setTablero(char[][] tablero) {
		this.tablero=tablero;
	}
	//Set turno
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	/*
	 * Cabecera:public void imprimirTablero
	 * Proposito:Imprime el array bidimensional en forma de talero de tres en raya
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondici�n:El array no debe estar vacio para que el tablero sea imprimido de forma correcta
	 * Postcondici�n:Se trata de un procedimiento e imprime en pantalla un tablero
	 * */
	public void imprimirTablero(){
		System.out.println("-------------");//Imprime cr�cteres que formar�n el tablero
        for (int i=0; i<3; i++) {//for para recorrer las filas del array
            System.out.print("| ");//Imprime cr�cteres que formar�n el tablero
            for (int j=0; j<3; j++) {//for para recorrer las columnas del array
            	System.out.print(getTablero()[i][j]);//Imprime lo que hay en cada casilla del array
                System.out.print(" | ");//Imprime cr�cteres que formar�n el tablero
            }
            System.out.println();//Salto de l�nea
            System.out.println("-------------");//Imprime cr�cteres que formar�n el tablero
        }
        System.out.println();//Salto de l�nea
    }
	/*
	 * Cabecera:public void rellenarTablero()
	 * Proposito:Rellenar� el tablero de n�meros para que el usuario pueda elegir mejor que casilla desea seleccionar
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un procedimiento que rellena el atributo de la clase tablero de n�meros
	 * */
	
	public void rellenarTablero(){
		char numeros=49;//Inicializamos la variable n�meros que actuar� como contador de las posiciones en ASCII de los n�meros
        for (int i=0; i<tablero.clone().length; i++) {
            for (int j=0; j<tablero.clone().length; j++,numeros++) {
            	tablero.clone()[i][j]=numeros;//Se van asignando los car�cteres a las respectivas posiciones en el tablero 
            }  
        }
        setTablero(tablero.clone());//Le pasamos al m�todo set el clon del tablero lleno de n�meros
    }
	/*
	 * Cabecera:public boolean comprobarCasilla(int x,int y)
	 * Proposito:Comprobar� si en una casilla hay un n�mero y por lo tanto si esta vac�a (es decir tiene un car�cter num�rico) puede ser llenada
	 * Entrada:Ninguna
	 * Salida:boolean disponible
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que nos devolver� un booleano disponible
	 * */
	public boolean comprobarCasilla(int x,int y){
		boolean disponible=false;//variable local disponible nos dice si una casilla estar� disponible para ser rellenada
        if(Character.isDigit(getTablero()[x][y])){//Usando el m�todo isDigit de la clase Character comprobamos que en esa posici�n hay un n�mero
        	disponible=true;//si la condici�n se cumpliio asignamos a disponible el valor true
        }
        
		return disponible;
	}
	/*
	 * Cabecera:public boolean colocarFichaEnElArray(int x, int y,char ficha,Jugador jugador)
	 * Proposito:Colocar la ficha introducida por el usuario o cpu en el array(arreglo,matriz,etc)
	 * Entrada:int x, int y,char ficha,Jugador jugador
	 * Salida:boolean ficha colocada
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve si una ficha ha sido colocada o no
	 * */
	public boolean colocarFichaEnElArray(int x, int y,char ficha){
		boolean fichaColocada=false;//booleano que nos dir� si una ficha ha sido colocada satisfactoriamente o no
		if(comprobarCasilla(x,y)==true){//llamada al metodo comprobar casilla para que nos diga si dicha casilla esta vac�a o no
			tablero.clone()[x][y]=ficha;//la posici�n introducida es llenada con la ficha introducida por el usuario 
			setTablero(tablero.clone());//se llama al metodo set y se le pasa el clon del tablero
			fichaColocada=true;//se devuelve que la ficha ha sido colocada satisfactoriamente
		}else{//Si la comprobaci�n de la casilla ha devuelto falso
		System.out.println("Esa casilla ya est� ocupada por una ficha, selecciona otra que s� se encuentre vac�a");//Imprime un mensaje de que dicha casilla ya contiene una ficha
		}
		return fichaColocada;
	}
	/*
	 * Cabecera:public boolean nuevoTurno(Jugador jugador1,Partida partida)
	 * Proposito:Se comienza un nuevo turno para el jugador llamando a los m�todos necesarios para que se lleve a cabo dicho turno y devuelve si la partida debe continuar o no
	 * Entrada:Jugador jugador1,Partida partida
	 * Salida:boolean continuar
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano continuar
	 * */
	public boolean nuevoTurno(Jugador jugador1,Partida partida){
		boolean continuar=true;//booleano que se devolver� para saber si se continua o no la partida 
		System.out.println("\n"+jugador1.getNombre()+", es tu turno\nIntroduce el n�mero de la casilla donde quieres colocar tu ficha\n");//mensaje de que es el turno del jugador
		jugador1.colocarFicha(partida);//llamada al m�todo para colocar ficha
		if(comprobarSiTresEnRaya(jugador1.getFicha())){//Se comprueba si hay o no tres en raya
			continuar=false;//si lo hay se cambia el valor del booleano para confirmar que no se va a seguir con la partida
		}
		imprimirTablero();//se imprime el tablero con la ficha colocada
		return continuar;
	}
	/*
	 * Cabecera:public boolean nuevoTurnoCPU(Bot Ia,char ficha2,Partida partida)
	 * Proposito:Se trata de un m�todo que llama a los m�todos necesarios para que se juegue un turno por la IA y devuelve si la partida debe continuar o no
	 * Entrada:Bot Ia,char ficha2,Partida partida
	 * Salida:boolean continuar
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano continuar
	 * */
	public boolean nuevoTurnoCPU(Bot Ia,char ficha2,Partida partida){
		boolean continuar=true;//booleano que se devolver� para saber si se continua o no la partida 
		System.out.println(Ia.getNombre()+" ha colocado, ten cuidado...\n");//mensaje de que la IA ha colocado
		Ia.colocarFicha( ficha2, partida);//llamada al m�todo para colocar ficha
		if(comprobarSiTresEnRaya(Ia.getFicha())){//Se comprueba si hay o no tres en raya
			continuar=false;//si lo hay se cambia el valor del booleano para confirmar que no se va a seguir con la partida
		}
		imprimirTablero();//se imprime el tablero con la ficha colocada
		return continuar;
	}
	/*
	 * Cabecera:public boolean comprobarSiTresEnRaya(char ficha)
	 * Proposito:Comprueba si hay un tres en raya
	 * Entrada:char ficha
	 * Salida:boolean tresEnRaya
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano tresEnRaya
	 * */
	public boolean comprobarSiTresEnRaya(char ficha){
		boolean tresEnRaya=false;//booleano que se devolver� si hay o no tres en raya
		if(comprobarDiagonales(ficha) || comprobarHorizontales(ficha) || comprobarVerticales(ficha)){//llamada a los m�todos que van comprobando las filas,diagonales y columnas para ver si hay tres en raya
			tresEnRaya=true;//booleano que si hay tres en raya pues es asignado a true
		}
		return tresEnRaya;	
	}
	/*
	 * Cabecera:public boolean comprobarDiagonales(char ficha)
	 * Proposito:Comprueba si en alguna diagonal hay o no tres en raya
	 * Entrada:char ficha
	 * Salida:
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano diagonal
	 * */
	public boolean comprobarDiagonales(char ficha){
		boolean diagonal=false;
		if(comprobarTresCasillas(0,0,1,1,2,2,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas diagonales hay tres en raya
			diagonal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(0,2,1,1,2,0,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas diagonales hay tres en raya
			diagonal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}
		return diagonal;
	}
	/*
	 * Cabecera:public boolean comprobarHorizontales(char ficha)
	 * Proposito:Comprueba si en alguna horizontal hay o no tres en raya
	 * Entrada:char ficha
	 * Salida:boolean horizontal
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano horizontal
	 * */
	public boolean comprobarHorizontales(char ficha){
		boolean horizontal=false;
		if(comprobarTresCasillas(0,0,0,1,0,2,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas hay tres en raya
			horizontal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(1,0,1,1,1,2,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas horizontales hay tres en raya
			horizontal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(2,0,2,1,2,2,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas horizontales hay tres en raya
			horizontal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}
		return horizontal;
	}
	/*
	 * Cabecera:public boolean comprobarVerticales(char ficha)
	 * Proposito:Comprueba si en alguna vertical hay o no tres en raya
	 * Entrada:char ficha
	 * Salida:boolean vrtical
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano vertical
	 * */
	public boolean comprobarVerticales(char ficha){
		boolean vertical=false;
		if(comprobarTresCasillas(0,0,1,0,2,0,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas verticales hay tres en raya
			vertical=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(0,1,1,1,2,1,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas verticales hay tres en raya
			vertical=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(0,2,1,2,2,2,ficha)){//llamada al m�todo comprobar casillas para ver si en esas casillas verticales hay tres en raya
			vertical=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}
		return vertical;
	}
	/*
	 * Cabecera:public boolean comprobarTresCasillas(int casilla1x, int casilla1y,int casilla2x, int casilla2y,int casilla3x, int casilla3y,char ficha)
	 * Proposito:
	 * Entrada:int casilla1x, int casilla1y,int casilla2x, int casilla2y,int casilla3x, int casilla3y,char ficha
	 * Salida:boolean tresCasillasConLaMismaFicha
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano tresCasillasConLaMismaFicha
	 * */
	public boolean comprobarTresCasillas(int casilla1x, int casilla1y,int casilla2x, int casilla2y,int casilla3x, int casilla3y,char ficha){
		boolean tresCasillasConLaMismaFicha=false;
		if(getTablero()[casilla1x][casilla1y]==ficha){//comprobamos que la ficha pasada por par�metros es la misma que hay en esa casilla
			if(getTablero()[casilla2x][casilla2y]==ficha){//comprobamos que la ficha pasada por par�metros es la misma que hay en esa casilla
				if(getTablero()[casilla3x][casilla3y]==ficha){//comprobamos que la ficha pasada por par�metros es la misma que hay en esa casilla
					tresCasillasConLaMismaFicha=true;//si todo se ha cumplido devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
				}
			}
		}
		return tresCasillasConLaMismaFicha;
	}
	/*
	 * Cabecera:public void partida2Jugadores(Jugador jugador1,Jugador jugador2,Partida partida)
	 * Proposito:Se llamar�n a los m�todos necesarios para que se juegue la partida de tres en raya entre dos jugadores
	 * Entrada:Jugador jugador1,Jugador jugador2,Partida partida
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un procedimiento
	 * */
	public void partida2Jugadores(Jugador jugador1,Jugador jugador2,Partida partida){
		boolean turnoJ1=true,turnoJ2=true;
		int turnoPartida=1;
		if(decidirQuienEmpieza()){
			rellenarTablero();//llamada al m�todo rellenar tablero
			imprimirTablero();//llamada al m�todo imprimir tablero
			do{
				System.out.println("Turno "+getTurno());//imprime el turno actual
				if(turnoJ2) {// si debe continuar el turno
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al m�todo de nuevo turno
				}
				if(turnoJ1 && getTurno()!=5) {//si el turno no es 5 y turno debe continuar
					turnoJ2=nuevoTurno(jugador2,partida);//llamada al m�todo de nuevo turno
				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//llamamos al set de turno y le pasamos por par�metros el turno actual
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}else{
			rellenarTablero();//llamada al m�todo rellenar tablero
			imprimirTablero();//llamada al m�todo imprimir tablero
			do {
				System.out.println("Turno "+getTurno());//imprime el turno actual
				if(turnoJ1) {// si debe continuar el turno
					turnoJ2=nuevoTurno(jugador2,partida);//llamada al m�todo de nuevo turno
				}
				if(turnoJ2 && getTurno()!=5) {//si el turno no es 5 y turno debe continuar
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al m�todo de nuevo turno

				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//llamamos al set de turno y le pasamos por par�metros el turno actual
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}
		decidirQuienHaGanado(jugador1, jugador2);//llamada al m�todo decidir quien ha ganado si J1 o J2
	}
	/*
	 * Cabecera:public void partidaVSCPU(Jugador jugador1,Bot Ia,Partida partida)
	 * Proposito:Se llamar�n a los m�todos necesarios para que se juegue la partida de tres en raya un jugador contra la m�quina
	 * Entrada:Jugador jugador1,Bot Ia,Partida partid
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un pcrocedimiento 
	 * */
	public void partidaVSCPU(Jugador jugador1,Bot Ia,Partida partida){
		boolean turnoJ1=true,turnoJ2=true;
		int turnoPartida=1;
		char randomCaracter=' ';
		Ia.setNombre(Ia.eleccionRivalIa());//llamada al m�todo de selecci�n del rival seg�n dificultad y aleatoriedad
		System.out.println("�Quieres que la m�quina utilice un car�cter random o prefieres que escoja uno cl�sico(es decir X/O)?\nIntroduce r para que sea random o cualquier otra tecla para que no lo sea");
		randomCaracter=Character.toLowerCase(teclado.next().charAt(0));//conversi�n del caracter a min�scula
		if(randomCaracter=='r'){//si es r se llamar� al m�todo para generar aleatoriamente a un car�cter	
			do{Ia.setFicha(Ia.caracterAleatorio());//llamada al m�todo de generar un car�cter aleatorio
			}while(Ia.getFicha()==jugador1.getFicha());//mientras la ficha del jugador y la m�quina sea la misma se repetira
		}else{//si no es aleatorio
			Ia.setFicha('X');//selecciona la X como ficha
			if(Ia.getFicha()==jugador1.getFicha()){//si el jugador a elegido la X tambi�n
				Ia.setFicha('O');//selecciona O cmo ficha
			}
		}
		if(decidirQuienEmpieza()){//llamada al m�todo para decidir quien empieza
			rellenarTablero();//llamada al m�todo rellenar tablero
			imprimirTablero();//llamada al m�todo imprimir tablero
			do{
				if(turnoJ2) {// si debe continuar el turno
					System.out.println("Turno "+getTurno());//imprime el turno actual
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al m�todo de nuevo turno
				}
				if(turnoJ1 && getTurno()!=5){//si el turno no es 5 y turno debe continuar
					turnoJ2=nuevoTurnoCPU(Ia,jugador1.getFicha(),partida);//llamada al m�todo de nuevo turno CPU
				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//le pasamos al set de turno por par�metros el turno en el que nos encontramos
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}else{
			rellenarTablero();//llamada al m�todo rellenar tablero
			imprimirTablero();//llamada al m�todo imprimir tablero
			do{
				if(turnoJ1) {// si debe continuar el turno
					System.out.println("Turno "+getTurno());//imprime el turno actual
					turnoJ2=nuevoTurnoCPU(Ia,jugador1.getFicha(),partida);//llamada al m�todo de nuevo turno CPU
				}
				if(turnoJ2 && getTurno()!=5){// si el turno no es 5 y debe continuar el turno
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al m�todo de nuevo turno
				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//le pasamos al set de turno por par�metros el turno en el que nos encontramos
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}
		if(decidirQuienHaGanado(jugador1, Ia)){//llamada al m�todo decidir quien ha ganado y si ha ganado la m�quina
			Ia.comentarioSarcastico();//llamada al m�todo comentario sarc�stico
		}
	}
	/*
	 * Cabecera:public boolean decidirQuienEmpieza()
	 * Proposito:M�todo que se encarga de decidir que jugador colocar� primero con el juego de cara o cruz
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que imprimir� en pantalla qui�n colocara primero
	 * */
	public boolean decidirQuienEmpieza(){
		int respuesta=0,random = (int) Math.floor(Math.random()*2+1);
		boolean resultado=false;
		System.out.println("Echaremos a cara o cruz quien empezar�, Jugador1 introduce 1 para elegir cara o 2 para cruz y J2/CPU escoger� lo contrario");
		respuesta=teclado.nextInt();
		while(respuesta<1 || respuesta>2){//mientras no se introduzca cara o cruz se volver� a pedir la entrada
			System.out.println("Respuesta no v�lida, introduce 1 para elegir cara o 2 para cruz");
			respuesta=teclado.nextInt();
		}
		if(respuesta==1 && random==1){//si sale cara y has elegido cara empieza J1
			System.out.println("Ha salido cara has acertado, empiezas t� J1\n");
			resultado=true;
		}else if(respuesta==1 && random==2){//si sale cara y has elegido cruz empieza J2
			System.out.println("Ha salido cruz has fallado, empieza el J2/CPU\n");
		}else if(respuesta==2 && random==2){//si sale cruz y has elegido cruz empieza J1
			System.out.println("Ha salido cruz has acertado, empiezas t� J1\n");	
			resultado=true;
		}else if(respuesta==2 && random==1){//si sale cruz y has elegido cara empieza J2
			System.out.println("Ha salido cara has fallado, empieza el J2/CPU\n");	
		}
		return resultado;
	}
	/*
	 * Cabecera:public boolean decidirQuienHaGanado(Jugador jugador1,Jugador jugador2)
	 * Proposito:Saber que jugador(o Ia) ha ganado
	 * Entrada:Jugador jugador1,Jugador jugador2
	 * Salida:boolean cpuGanadoraOJ2
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano cpuGanadoraOJ2
	 * */
	public boolean decidirQuienHaGanado(Jugador jugador1,Jugador jugador2){
		boolean cpuGanadoraOJ2=false;
		if(comprobarSiTresEnRaya(jugador1.getFicha())){//comprueba si el que ha hecho tres en raya es J1 mirando su ficha
			System.out.println("��Enhorabuena "+jugador1.getNombre()+" has ganado!!");//mensaje de victoria J1
		}else if(comprobarSiTresEnRaya(jugador2.getFicha())){//comprueba si el que ha hecho tres en raya es J2/CPU mirando su ficha
			System.out.println("��Enhorabuena "+jugador2.getNombre()+" has ganado!!");//mensaje de victoria J2/CPU
			cpuGanadoraOJ2=true;
		}else{
			System.out.println("Vaya esto es un empate,ha sido una buena partida");//mensaje de empate
		}
		return cpuGanadoraOJ2;//devuelve si ha ganado la J2/CPU para saber si llamar posteriormente al m�todo comentario sarc�stico
	}
}


