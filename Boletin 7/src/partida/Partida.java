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
	//Constructor por parámetros
		public Partida(char[][] tablero,int turno){
			
			this.tablero=tablero;
			this.turno=turno;
			
		}
	
	
	//Métodos fundamentales
	
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
	 * Precondición:El array no debe estar vacio para que el tablero sea imprimido de forma correcta
	 * Postcondición:Se trata de un procedimiento e imprime en pantalla un tablero
	 * */
	public void imprimirTablero(){
		System.out.println("-------------");//Imprime crácteres que formarán el tablero
        for (int i=0; i<3; i++) {//for para recorrer las filas del array
            System.out.print("| ");//Imprime crácteres que formarán el tablero
            for (int j=0; j<3; j++) {//for para recorrer las columnas del array
            	System.out.print(getTablero()[i][j]);//Imprime lo que hay en cada casilla del array
                System.out.print(" | ");//Imprime crácteres que formarán el tablero
            }
            System.out.println();//Salto de línea
            System.out.println("-------------");//Imprime crácteres que formarán el tablero
        }
        System.out.println();//Salto de línea
    }
	/*
	 * Cabecera:public void rellenarTablero()
	 * Proposito:Rellenará el tablero de números para que el usuario pueda elegir mejor que casilla desea seleccionar
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondición:Ninguna
	 * Postcondición:Se trata de un procedimiento que rellena el atributo de la clase tablero de números
	 * */
	
	public void rellenarTablero(){
		char numeros=49;//Inicializamos la variable números que actuará como contador de las posiciones en ASCII de los números
        for (int i=0; i<tablero.clone().length; i++) {
            for (int j=0; j<tablero.clone().length; j++,numeros++) {
            	tablero.clone()[i][j]=numeros;//Se van asignando los carácteres a las respectivas posiciones en el tablero 
            }  
        }
        setTablero(tablero.clone());//Le pasamos al método set el clon del tablero lleno de números
    }
	/*
	 * Cabecera:public boolean comprobarCasilla(int x,int y)
	 * Proposito:Comprobará si en una casilla hay un número y por lo tanto si esta vacía (es decir tiene un carácter numérico) puede ser llenada
	 * Entrada:Ninguna
	 * Salida:boolean disponible
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que nos devolverá un booleano disponible
	 * */
	public boolean comprobarCasilla(int x,int y){
		boolean disponible=false;//variable local disponible nos dice si una casilla estará disponible para ser rellenada
        if(Character.isDigit(getTablero()[x][y])){//Usando el método isDigit de la clase Character comprobamos que en esa posición hay un número
        	disponible=true;//si la condición se cumpliio asignamos a disponible el valor true
        }
        
		return disponible;
	}
	/*
	 * Cabecera:public boolean colocarFichaEnElArray(int x, int y,char ficha,Jugador jugador)
	 * Proposito:Colocar la ficha introducida por el usuario o cpu en el array(arreglo,matriz,etc)
	 * Entrada:int x, int y,char ficha,Jugador jugador
	 * Salida:boolean ficha colocada
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve si una ficha ha sido colocada o no
	 * */
	public boolean colocarFichaEnElArray(int x, int y,char ficha){
		boolean fichaColocada=false;//booleano que nos dirá si una ficha ha sido colocada satisfactoriamente o no
		if(comprobarCasilla(x,y)==true){//llamada al metodo comprobar casilla para que nos diga si dicha casilla esta vacía o no
			tablero.clone()[x][y]=ficha;//la posición introducida es llenada con la ficha introducida por el usuario 
			setTablero(tablero.clone());//se llama al metodo set y se le pasa el clon del tablero
			fichaColocada=true;//se devuelve que la ficha ha sido colocada satisfactoriamente
		}else{//Si la comprobación de la casilla ha devuelto falso
		System.out.println("Esa casilla ya está ocupada por una ficha, selecciona otra que sí se encuentre vacía");//Imprime un mensaje de que dicha casilla ya contiene una ficha
		}
		return fichaColocada;
	}
	/*
	 * Cabecera:public boolean nuevoTurno(Jugador jugador1,Partida partida)
	 * Proposito:Se comienza un nuevo turno para el jugador llamando a los métodos necesarios para que se lleve a cabo dicho turno y devuelve si la partida debe continuar o no
	 * Entrada:Jugador jugador1,Partida partida
	 * Salida:boolean continuar
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano continuar
	 * */
	public boolean nuevoTurno(Jugador jugador1,Partida partida){
		boolean continuar=true;//booleano que se devolverá para saber si se continua o no la partida 
		System.out.println("\n"+jugador1.getNombre()+", es tu turno\nIntroduce el número de la casilla donde quieres colocar tu ficha\n");//mensaje de que es el turno del jugador
		jugador1.colocarFicha(partida);//llamada al método para colocar ficha
		if(comprobarSiTresEnRaya(jugador1.getFicha())){//Se comprueba si hay o no tres en raya
			continuar=false;//si lo hay se cambia el valor del booleano para confirmar que no se va a seguir con la partida
		}
		imprimirTablero();//se imprime el tablero con la ficha colocada
		return continuar;
	}
	/*
	 * Cabecera:public boolean nuevoTurnoCPU(Bot Ia,char ficha2,Partida partida)
	 * Proposito:Se trata de un método que llama a los métodos necesarios para que se juegue un turno por la IA y devuelve si la partida debe continuar o no
	 * Entrada:Bot Ia,char ficha2,Partida partida
	 * Salida:boolean continuar
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano continuar
	 * */
	public boolean nuevoTurnoCPU(Bot Ia,char ficha2,Partida partida){
		boolean continuar=true;//booleano que se devolverá para saber si se continua o no la partida 
		System.out.println(Ia.getNombre()+" ha colocado, ten cuidado...\n");//mensaje de que la IA ha colocado
		Ia.colocarFicha( ficha2, partida);//llamada al método para colocar ficha
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
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano tresEnRaya
	 * */
	public boolean comprobarSiTresEnRaya(char ficha){
		boolean tresEnRaya=false;//booleano que se devolverá si hay o no tres en raya
		if(comprobarDiagonales(ficha) || comprobarHorizontales(ficha) || comprobarVerticales(ficha)){//llamada a los métodos que van comprobando las filas,diagonales y columnas para ver si hay tres en raya
			tresEnRaya=true;//booleano que si hay tres en raya pues es asignado a true
		}
		return tresEnRaya;	
	}
	/*
	 * Cabecera:public boolean comprobarDiagonales(char ficha)
	 * Proposito:Comprueba si en alguna diagonal hay o no tres en raya
	 * Entrada:char ficha
	 * Salida:
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano diagonal
	 * */
	public boolean comprobarDiagonales(char ficha){
		boolean diagonal=false;
		if(comprobarTresCasillas(0,0,1,1,2,2,ficha)){//llamada al método comprobar casillas para ver si en esas casillas diagonales hay tres en raya
			diagonal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(0,2,1,1,2,0,ficha)){//llamada al método comprobar casillas para ver si en esas casillas diagonales hay tres en raya
			diagonal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}
		return diagonal;
	}
	/*
	 * Cabecera:public boolean comprobarHorizontales(char ficha)
	 * Proposito:Comprueba si en alguna horizontal hay o no tres en raya
	 * Entrada:char ficha
	 * Salida:boolean horizontal
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano horizontal
	 * */
	public boolean comprobarHorizontales(char ficha){
		boolean horizontal=false;
		if(comprobarTresCasillas(0,0,0,1,0,2,ficha)){//llamada al método comprobar casillas para ver si en esas casillas hay tres en raya
			horizontal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(1,0,1,1,1,2,ficha)){//llamada al método comprobar casillas para ver si en esas casillas horizontales hay tres en raya
			horizontal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(2,0,2,1,2,2,ficha)){//llamada al método comprobar casillas para ver si en esas casillas horizontales hay tres en raya
			horizontal=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}
		return horizontal;
	}
	/*
	 * Cabecera:public boolean comprobarVerticales(char ficha)
	 * Proposito:Comprueba si en alguna vertical hay o no tres en raya
	 * Entrada:char ficha
	 * Salida:boolean vrtical
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano vertical
	 * */
	public boolean comprobarVerticales(char ficha){
		boolean vertical=false;
		if(comprobarTresCasillas(0,0,1,0,2,0,ficha)){//llamada al método comprobar casillas para ver si en esas casillas verticales hay tres en raya
			vertical=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(0,1,1,1,2,1,ficha)){//llamada al método comprobar casillas para ver si en esas casillas verticales hay tres en raya
			vertical=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}else if(comprobarTresCasillas(0,2,1,2,2,2,ficha)){//llamada al método comprobar casillas para ver si en esas casillas verticales hay tres en raya
			vertical=true;//si se cumple devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
		}
		return vertical;
	}
	/*
	 * Cabecera:public boolean comprobarTresCasillas(int casilla1x, int casilla1y,int casilla2x, int casilla2y,int casilla3x, int casilla3y,char ficha)
	 * Proposito:
	 * Entrada:int casilla1x, int casilla1y,int casilla2x, int casilla2y,int casilla3x, int casilla3y,char ficha
	 * Salida:boolean tresCasillasConLaMismaFicha
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano tresCasillasConLaMismaFicha
	 * */
	public boolean comprobarTresCasillas(int casilla1x, int casilla1y,int casilla2x, int casilla2y,int casilla3x, int casilla3y,char ficha){
		boolean tresCasillasConLaMismaFicha=false;
		if(getTablero()[casilla1x][casilla1y]==ficha){//comprobamos que la ficha pasada por parámetros es la misma que hay en esa casilla
			if(getTablero()[casilla2x][casilla2y]==ficha){//comprobamos que la ficha pasada por parámetros es la misma que hay en esa casilla
				if(getTablero()[casilla3x][casilla3y]==ficha){//comprobamos que la ficha pasada por parámetros es la misma que hay en esa casilla
					tresCasillasConLaMismaFicha=true;//si todo se ha cumplido devovelvemos que en esas tres casillas esta la misma ficha por eso lo igualamos a true
				}
			}
		}
		return tresCasillasConLaMismaFicha;
	}
	/*
	 * Cabecera:public void partida2Jugadores(Jugador jugador1,Jugador jugador2,Partida partida)
	 * Proposito:Se llamarán a los métodos necesarios para que se juegue la partida de tres en raya entre dos jugadores
	 * Entrada:Jugador jugador1,Jugador jugador2,Partida partida
	 * Salida:Ninguna
	 * Precondición:Ninguna
	 * Postcondición:Se trata de un procedimiento
	 * */
	public void partida2Jugadores(Jugador jugador1,Jugador jugador2,Partida partida){
		boolean turnoJ1=true,turnoJ2=true;
		int turnoPartida=1;
		if(decidirQuienEmpieza()){
			rellenarTablero();//llamada al método rellenar tablero
			imprimirTablero();//llamada al método imprimir tablero
			do{
				System.out.println("Turno "+getTurno());//imprime el turno actual
				if(turnoJ2) {// si debe continuar el turno
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al método de nuevo turno
				}
				if(turnoJ1 && getTurno()!=5) {//si el turno no es 5 y turno debe continuar
					turnoJ2=nuevoTurno(jugador2,partida);//llamada al método de nuevo turno
				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//llamamos al set de turno y le pasamos por parámetros el turno actual
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}else{
			rellenarTablero();//llamada al método rellenar tablero
			imprimirTablero();//llamada al método imprimir tablero
			do {
				System.out.println("Turno "+getTurno());//imprime el turno actual
				if(turnoJ1) {// si debe continuar el turno
					turnoJ2=nuevoTurno(jugador2,partida);//llamada al método de nuevo turno
				}
				if(turnoJ2 && getTurno()!=5) {//si el turno no es 5 y turno debe continuar
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al método de nuevo turno

				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//llamamos al set de turno y le pasamos por parámetros el turno actual
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}
		decidirQuienHaGanado(jugador1, jugador2);//llamada al método decidir quien ha ganado si J1 o J2
	}
	/*
	 * Cabecera:public void partidaVSCPU(Jugador jugador1,Bot Ia,Partida partida)
	 * Proposito:Se llamarán a los métodos necesarios para que se juegue la partida de tres en raya un jugador contra la máquina
	 * Entrada:Jugador jugador1,Bot Ia,Partida partid
	 * Salida:Ninguna
	 * Precondición:Ninguna
	 * Postcondición:Se trata de un pcrocedimiento 
	 * */
	public void partidaVSCPU(Jugador jugador1,Bot Ia,Partida partida){
		boolean turnoJ1=true,turnoJ2=true;
		int turnoPartida=1;
		char randomCaracter=' ';
		Ia.setNombre(Ia.eleccionRivalIa());//llamada al método de selección del rival según dificultad y aleatoriedad
		System.out.println("¿Quieres que la máquina utilice un carácter random o prefieres que escoja uno clásico(es decir X/O)?\nIntroduce r para que sea random o cualquier otra tecla para que no lo sea");
		randomCaracter=Character.toLowerCase(teclado.next().charAt(0));//conversión del caracter a minúscula
		if(randomCaracter=='r'){//si es r se llamará al método para generar aleatoriamente a un carácter	
			do{Ia.setFicha(Ia.caracterAleatorio());//llamada al método de generar un carácter aleatorio
			}while(Ia.getFicha()==jugador1.getFicha());//mientras la ficha del jugador y la máquina sea la misma se repetira
		}else{//si no es aleatorio
			Ia.setFicha('X');//selecciona la X como ficha
			if(Ia.getFicha()==jugador1.getFicha()){//si el jugador a elegido la X también
				Ia.setFicha('O');//selecciona O cmo ficha
			}
		}
		if(decidirQuienEmpieza()){//llamada al método para decidir quien empieza
			rellenarTablero();//llamada al método rellenar tablero
			imprimirTablero();//llamada al método imprimir tablero
			do{
				if(turnoJ2) {// si debe continuar el turno
					System.out.println("Turno "+getTurno());//imprime el turno actual
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al método de nuevo turno
				}
				if(turnoJ1 && getTurno()!=5){//si el turno no es 5 y turno debe continuar
					turnoJ2=nuevoTurnoCPU(Ia,jugador1.getFicha(),partida);//llamada al método de nuevo turno CPU
				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//le pasamos al set de turno por parámetros el turno en el que nos encontramos
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}else{
			rellenarTablero();//llamada al método rellenar tablero
			imprimirTablero();//llamada al método imprimir tablero
			do{
				if(turnoJ1) {// si debe continuar el turno
					System.out.println("Turno "+getTurno());//imprime el turno actual
					turnoJ2=nuevoTurnoCPU(Ia,jugador1.getFicha(),partida);//llamada al método de nuevo turno CPU
				}
				if(turnoJ2 && getTurno()!=5){// si el turno no es 5 y debe continuar el turno
					turnoJ1=nuevoTurno(jugador1,partida);//llamada al método de nuevo turno
				}
				turnoPartida++;//aumenta el turno es decir pasamos de turno
				setTurno(turnoPartida);//le pasamos al set de turno por parámetros el turno en el que nos encontramos
			}while(turnoJ1 && turnoJ2 && getTurno()<=5);//mientras ambos turnos deben continuar y el turno sea menor o igual que 5
		}
		if(decidirQuienHaGanado(jugador1, Ia)){//llamada al método decidir quien ha ganado y si ha ganado la máquina
			Ia.comentarioSarcastico();//llamada al método comentario sarcástico
		}
	}
	/*
	 * Cabecera:public boolean decidirQuienEmpieza()
	 * Proposito:Método que se encarga de decidir que jugador colocará primero con el juego de cara o cruz
	 * Entrada:Ninguna
	 * Salida:Ninguna
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que imprimirá en pantalla quién colocara primero
	 * */
	public boolean decidirQuienEmpieza(){
		int respuesta=0,random = (int) Math.floor(Math.random()*2+1);
		boolean resultado=false;
		System.out.println("Echaremos a cara o cruz quien empezará, Jugador1 introduce 1 para elegir cara o 2 para cruz y J2/CPU escogerá lo contrario");
		respuesta=teclado.nextInt();
		while(respuesta<1 || respuesta>2){//mientras no se introduzca cara o cruz se volverá a pedir la entrada
			System.out.println("Respuesta no válida, introduce 1 para elegir cara o 2 para cruz");
			respuesta=teclado.nextInt();
		}
		if(respuesta==1 && random==1){//si sale cara y has elegido cara empieza J1
			System.out.println("Ha salido cara has acertado, empiezas tú J1\n");
			resultado=true;
		}else if(respuesta==1 && random==2){//si sale cara y has elegido cruz empieza J2
			System.out.println("Ha salido cruz has fallado, empieza el J2/CPU\n");
		}else if(respuesta==2 && random==2){//si sale cruz y has elegido cruz empieza J1
			System.out.println("Ha salido cruz has acertado, empiezas tú J1\n");	
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
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano cpuGanadoraOJ2
	 * */
	public boolean decidirQuienHaGanado(Jugador jugador1,Jugador jugador2){
		boolean cpuGanadoraOJ2=false;
		if(comprobarSiTresEnRaya(jugador1.getFicha())){//comprueba si el que ha hecho tres en raya es J1 mirando su ficha
			System.out.println("¡¡Enhorabuena "+jugador1.getNombre()+" has ganado!!");//mensaje de victoria J1
		}else if(comprobarSiTresEnRaya(jugador2.getFicha())){//comprueba si el que ha hecho tres en raya es J2/CPU mirando su ficha
			System.out.println("¡¡Enhorabuena "+jugador2.getNombre()+" has ganado!!");//mensaje de victoria J2/CPU
			cpuGanadoraOJ2=true;
		}else{
			System.out.println("Vaya esto es un empate,ha sido una buena partida");//mensaje de empate
		}
		return cpuGanadoraOJ2;//devuelve si ha ganado la J2/CPU para saber si llamar posteriormente al método comentario sarcástico
	}
}


