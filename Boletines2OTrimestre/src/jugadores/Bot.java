package jugadores;

import java.util.Scanner;
import partida.Partida;

public class Bot extends Jugador{
	//Objeto teclado
	Scanner teclado=new Scanner(System.in);
	//Atributos
	private int dificultad;
	public Bot(){
		ficha='*';
		nombre="Ia";
		dificultad=0;
	}
	//Constructor por par�metros
		public Bot(char ficha,String nombre,int dificultad){
			
			this.ficha=ficha;
			this.nombre=nombre;
			this.dificultad=dificultad;
			
		}

	//Get Dificultad
	public int getDificultad() {
		return dificultad;
	}

	//Set Dificultad
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	/*
	 * Cabecera:public void colocarFicha(char ficha,Partida partida)
	 * Proposito:Es el m�todo que usar� la Ia para colocar las fichas siguiendo un algoritmo de colocaci�n
	 * Entrada:char ficha,Partida partida
	 * Salida:Ninguna
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de un procedimiento que llamar� a otros m�todos para realizar distintas funciones
	 * */
	public void colocarFicha(char ficha,Partida partida){
		int casilla=0,probabilidadDeFallo=getDificultad(),random = (int) Math.floor(Math.random()*probabilidadDeFallo+1),//random 2 para la probabilidad de fallo de la Ia
		randomFallo = (int) Math.floor(Math.random()*probabilidadDeFallo+1);//random 1 para la probabilidad de fallo de la Ia
		if(random==randomFallo){//si ambos random coinciden la Ia colocar� aleatoriamente 
			colocarFichaAleatoriamente(partida);//llamada al m�todo de colocar aleatoriamente de esta forma la Ia fallar� por as� decirlo al no actuar de forma "inteligente"
		}else{
			casilla=colocarFichaDiagonal(partida,getFicha());//llamada al m�todo de colocar ficha con la ficha de la Ia es decir atacamos
			if(casilla==0){
				casilla=colocarFichaHorizontal(partida,getFicha());//llamada al m�todo de colocar ficha con la ficha de la Ia es decir atacamos
				if(casilla==0){
					casilla=colocarFichaVertical(partida,getFicha());//llamada al m�todo de colocar ficha con la ficha de la Ia es decir atacamos
				}if(casilla==0){
					casilla=colocarFichaDiagonal(partida,ficha);//llamada al m�todo de colocar ficha con la ficha del Jugador es decir defendemos
					if(casilla==0){
						casilla=colocarFichaHorizontal(partida,ficha);//llamada al m�todo de colocar ficha con la ficha del Jugador es decir defendemos
						if(casilla==0){
							casilla=colocarFichaVertical(partida,ficha);//llamada al m�todo de colocar ficha con la ficha del Jugador es decir defendemos
						}
					}
				}
			}
			switch(casilla){//seg�n la casilla devuelta
				case 0->colocarEstrategicamente(partida);//se coloca estrategicamente en alguna esquina o en el medio	
				case 1->partida.colocarFichaEnElArray(0, 0, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 2->partida.colocarFichaEnElArray(0, 1, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 3->partida.colocarFichaEnElArray(0, 2, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 4->partida.colocarFichaEnElArray(1, 0, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 5->partida.colocarFichaEnElArray(1, 1, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 6->partida.colocarFichaEnElArray(1, 2, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 7->partida.colocarFichaEnElArray(2, 0, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 8->partida.colocarFichaEnElArray(2, 1, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
				case 9->partida.colocarFichaEnElArray(2, 2, getFicha());//se coloca la ficha de la Ia en el array llamando al colocar ficha
			}
		}
	}
	/*
	 * Cabecera:public boolean comprobarSiCercaDelTresEnRaya(Partida partida,int casilla1x, int casilla1y,int casilla2x, int casilla2y,char ficha)
	 * Proposito:Comparar si en dos casillas del tablero hay o no las mismas fichas
	 * Entrada:Partida partida,int casilla1x, int casilla1y,int casilla2x, int casilla2y,char ficha
	 * Salida:boolean dosCasillasConLaMismaFicha
	 * Precondici�n:Ninguna
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano dosCasillasConLaMismaFicha
	 * */
		public boolean comprobarSiCercaDelTresEnRaya(Partida partida,int casilla1x, int casilla1y,int casilla2x, int casilla2y,char ficha){
			boolean dosCasillasConLaMismaFicha=false;
			if(partida.getTablero()[casilla1x][casilla1y]==ficha){//si la ficha introducida por par�metros es igual a la que hay en el tablero
				if(partida.getTablero()[casilla2x][casilla2y]==ficha ){//si la ficha introducida por par�metros es igual a la que hay en el tablero
						dosCasillasConLaMismaFicha=true;//devolver� que ambas casillas tienen la misma ficha
				}
			}
			return dosCasillasConLaMismaFicha;
	}
		/*
		 * Cabecera:public int colocarFichaDiagonal(Partida partida,char ficha)
		 * Proposito:Comprueba si en alguna diagonal hay dos fichas iguales y devuelve la casilla donde debe colocarse plara evitar el tres en raya
		 * Entrada:Partida partida,char ficha
		 * Salida:int casilla
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que devuelve un int casilla
		 * */
		public int colocarFichaDiagonal(Partida partida,char ficha){
			int casilla=0;
			if(comprobarSiCercaDelTresEnRaya(partida,1,1,0,0,ficha) && partida.comprobarCasilla(2,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse 
				casilla=9;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,1,2,2,ficha) && partida.comprobarCasilla(0,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=1;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,1,0,2,ficha) && partida.comprobarCasilla(2,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=7;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,1,2,0,ficha) && partida.comprobarCasilla(0,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=3;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,0,2,2,ficha) || comprobarSiCercaDelTresEnRaya(partida,2,0,0,2,ficha) && partida.comprobarCasilla(1,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=5;	
			}
			return casilla;
			
		}
		/*
		 * Cabecera:public int colocarFichaVertical(Partida partida,char ficha)
		 * Proposito:Comprueba si en alguna vertical hay dos fichas iguales y devuelve la casilla donde debe colocarse plara evitar el tres en raya
		 * Entrada:Partida partida,char ficha
		 * Salida:int casilla
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que devuelve un int casilla
		 * */
		public int colocarFichaVertical(Partida partida,char ficha){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
			int casilla=0;
			if(comprobarSiCercaDelTresEnRaya(partida,0,0,1,0,ficha) && partida.comprobarCasilla(2,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=7;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,1,1,1,ficha) && partida.comprobarCasilla(2,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=8;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,1,2,ficha) && partida.comprobarCasilla(2,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=9;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,0,1,0,ficha) && partida.comprobarCasilla(0,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=1;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,1,1,1,ficha) && partida.comprobarCasilla(0,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=2;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,2,1,2,ficha) && partida.comprobarCasilla(0,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=3;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,0,2,0,ficha) && partida.comprobarCasilla(1,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=4;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,1,2,1,ficha) && partida.comprobarCasilla(1,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=5;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,2,2,ficha) && partida.comprobarCasilla(1,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=6;
			}
			return casilla;
		}
		/*
		 * Cabecera:public int colocarFichaHorizontal(Partida partida,char ficha)
		 * Proposito:Comprueba si en alguna horizontal hay dos fichas iguales y devuelve la casilla donde debe colocarse plara evitar el tres en raya
		 * Entrada:Partida partida,char ficha
		 * Salida:int casilla
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que devuelve un int casilla
		 * */
		public int colocarFichaHorizontal(Partida partida,char ficha){
			int casilla=0;
			if(comprobarSiCercaDelTresEnRaya(partida,0,0,0,1,ficha) && partida.comprobarCasilla(0,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=3;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,0,1,1,ficha) && partida.comprobarCasilla(1,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=6;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,0,2,1,ficha) && partida.comprobarCasilla(2,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=9;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,0,1,ficha) && partida.comprobarCasilla(0,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=1;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,2,1,1,ficha) && partida.comprobarCasilla(1,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=4;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,2,2,1,ficha) && partida.comprobarCasilla(2,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=7;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,0,2,2,ficha) && partida.comprobarCasilla(2,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=8;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,0,1,2,ficha) && partida.comprobarCasilla(1,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=5;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,0,0,ficha) && partida.comprobarCasilla(0,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelver� en que casilla debe colocarse
				casilla=2;	
			}
			return casilla;
		}
		/*
		 * Cabecera:public int selectorDeDificultad()
		 * Proposito:Este m�todo permite al usuario elegir la dificultad que desea que tenga la Ia
		 * Entrada:Ninguna
		 * Salida:int respuesta
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que devolver� un entero respuesta
		 * */
		public int selectorDeDificultad(){
			int respuesta=0;
			System.out.println("INTRODUCE LA DIFICULTAD QUE DESEAS QUE TENGA LA IA:");
			System.out.println("1) F�cil");
			System.out.println("2) Normal");
			System.out.println("3) Dif�cil");
			System.out.println("4) Iv�n(Leyenda de Nervionia)");
			System.out.println("5) Entiendo el significado de las canciones de Tool");
			respuesta=teclado.nextInt();//lectura de la dificultad elegida por el usuario
			switch(respuesta){//seg�n la dificultad elegida
			case 1->setDificultad(3);//seg�n la dificultad elegida anteriormente le paso estas posibilidades al set
			case 2->setDificultad(5);//seg�n la dificultad elegida anteriormente le paso estas posibilidades al set
			case 3->setDificultad(7);//seg�n la dificultad elegida anteriormente le paso estas posibilidades al set
			case 4->setDificultad(10);//seg�n la dificultad elegida anteriormente le paso estas posibilidades al set
			case 5->setDificultad(100);//seg�n la dificultad elegida anteriormente le paso estas posibilidades al set
			}
			return respuesta;
		}
		/*
		 * Cabecera:public void colocarFichaAleatoriamente(Partida partida)
		 * Proposito:Se trata de un m�todo que colocar� aleatoriamente una ficha en el tablero
		 * Entrada:Partida partida
		 * Salida:Ninguna
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de un procedimiento que colocar� aleatoriamente una ficha en el tablero
		 * */
		public void colocarFichaAleatoriamente(Partida partida){
			boolean fichaColocada=false;
			do {
				int randomx = (int) Math.floor(Math.random()*3),//random eje x del array
						randomy = (int) Math.floor(Math.random()*3);//random eje y del array
				if(Character.isDigit(partida.getTablero()[randomx][randomy])){//si en dicha casilla hay un d�gito podemos colocar
					partida.colocarFichaEnElArray(randomx, randomy, getFicha());//colocamos la ficha en dicha casilla
					fichaColocada=true;
				}
	        }while(fichaColocada==false);//mientras la ficha no haya sido colocada
		}
		/*
		 * Cabecera:public void colocarEstrategicamente(Partida partida)
		 * Proposito:
		 * Entrada:Partida partida
		 * Salida:boolean fichaColocada
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que devuelve un booleano fichaColocada
		 * */
		public void colocarEstrategicamente(Partida partida){
			boolean fichaColocada=false;
			do {
				if(Character.isDigit(partida.getTablero()[1][1])){//si dicha casilla del tablero tiene un n�mero podemos colocar ah�
					partida.colocarFichaEnElArray(1, 1, getFicha());//llamamos al m�todo para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[0][0])){//si dicha casilla del tablero tiene un n�mero podemos colocar ah�
					partida.colocarFichaEnElArray(0, 0, getFicha());//llamamos al m�todo para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[0][2])){//si dicha casilla del tablero tiene un n�mero podemos colocar ah�
					partida.colocarFichaEnElArray(0, 2, getFicha());//llamamos al m�todo para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[2][2])){//si dicha casilla del tablero tiene un n�mero podemos colocar ah�
					partida.colocarFichaEnElArray(2, 2, getFicha());//llamamos al m�todo para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[2][0])){//si dicha casilla del tablero tiene un n�mero podemos colocar ah�
					partida.colocarFichaEnElArray(2, 0, getFicha());//llamamos al m�todo para colocarla en el array
					fichaColocada=true;
				}else{
					colocarFichaAleatoriamente(partida);//si no colocamos la ficha aleatoriamente
					fichaColocada=true;
				}
	        }while(fichaColocada==false);//repetir mientras la ficha no se haya colocado
		}
		/*
		 * Cabecera:public char caracterAleatorio()
		 * Proposito:Imprime  aleatoriamente un caracter entre algunos de los recogidos en ASCII
		 * Entrada:Ninguna
		 * Salida:Ninguna
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que deuvelve un char caracter
		 * */
		public char caracterAleatorio(){
			char caracter=' ';
			int random = (int) Math.floor(Math.random()*(60-126+1)+126);//random entre las posiciones de los caracteres en ascii
			caracter=(char) random;//casteo del int a char para devoler car�cter
			return caracter;
		}
		/*
		 * Cabecera:public String eleccionRivalIa()
		 * Proposito:Seleccionar� al rival seg�n la dificultad
		 * Entrada:Ninguna
		 * Salida:Ninguna
		 * Precondici�n:Ninguna
		 * Postcondici�n:Se trata de una funci�n que devolver� elnombre de quien ser� el rival de J1
		 * */
		public String eleccionRivalIa(){
			String nombre="";
			int random = (int) Math.floor(Math.random()*3+1);//aleatorio para que sea un rival aleatorio de los tres posibles en cada dificultad
			switch(selectorDeDificultad()){//se comprabar� la dificultad y seg�n esta ser� un rival u otro
				case 1->{
					switch(random){
					case 1-> nombre="Pedro S�nchez";
					case 2-> nombre="Santiago Abascal";
					case 3-> nombre="Mariano Rajoy";
					}	
				}
				case 2->{
					switch(random){
					case 1-> nombre="Pedro";
					case 2-> nombre="Juan Jos�";
					case 3-> nombre="La dependienta del polvillo";
					}	
				}
				case 3->{
					switch(random){
					case 1-> nombre="Ra�l";
					case 2-> nombre="Leo";
					case 3-> nombre="Miguel �ngel";
					}	
				}
				case 4->{
					switch(random){
					case 1-> nombre="julioprofe";
					case 2-> nombre="QuantumFracture";
					case 3-> nombre="Jaime Altozano";
					}
					
				}
				case 5->{
					switch(random){
					case 1-> nombre="Esp�ritu de Stephen Hawking";
					case 2-> nombre="Latinoamericano con un canal de tutoriales";
					case 3-> nombre="GLaDOS";
					}
				}
			}
			return nombre;
		}
		/*
		 * Cabecera:comentarioSarcastico()
		 * Proposito:Seg�n el rival cuando este gane imprimira un texto u otro
		 * Entrada:Ninguna
		 * Salida:Ninguna
		 * Precondici�n:El m�todo solo ser� llamado cuando el ganador sea la CPU
		 * Postcondici�n:Se trata de un procedimiento que imprime un comentario jocoso
		 * */
		public void comentarioSarcastico(){
			int random = (int) Math.floor(Math.random()*3+1);//aleatorio para que diga una de las tres posibles frases de cada personajes
			switch(getNombre()){//se mira el nombre y se comparara en este switch pues cada rival tiene frases propias
				case"Pedro S�nchez"->{
					switch(random){
						case 1->System.out.println("Nadie ha hecho tanto da�o a las instituciones catalanas como el independentismo\n(Un a�o despu�s pact� con partidos independentistas...)");
						case 2->System.out.println("Este escenario de la segunda ola con la llegada del fr�o lo hab�amos previsto y ha llegado por desgracia");
						case 3->System.out.println("Sabemos cu�l es el origen de los rebrotes\n(Frase pronuncida en Noviembre y se aproxima un tercera ola...)");
					}
				}
				case"Santiago Abascal"->{
					switch(random){
						case 1->System.out.println("Jajajaja has perdido vuelve a tu pa�s");
						case 2->System.out.println("Mi victoria demuestra que hay que derogar las leyes del 3 en raya");
						case 3->System.out.println("Para celebrarlo un puro y una copa de whiskey,�mujer ya me has o�do!");
					}
				}
				case"Mariano Rajoy"->{
					switch(random){
						case 1->System.out.println("Dije que te ganar�a y he perdido");
						case 2->System.out.println("Una raya es una raya y un tres es un tres");
						case 3->System.out.println("Me gustan los programadores porque hacen cosas");
					}
				}
				case"Pedro"->{
					switch(random){
						case 1->System.out.println("Toma te he ganado y adem�s tengo m�s que t� en el examen");
						case 2->System.out.println("Si hubieras programado en el bloc de notas me habr�as ganado");
						case 3->System.out.println("Si no le contesto se desespera...");
					}
				}
				case"Juan Jos�"->{
					switch(random){
						case 1->System.out.println("Te explicar�a como te he ganado pero lo ha hecho Alejandro");
						case 2->System.out.println("Esp�rate un segundo,Leo ven tengo una duda");
						case 3->System.out.println("Yo si quieres expongo el ejercicio");
					}
				}
				case"La dependienta del polvillo"->{
					switch(random){
						case 1->System.out.println("Uno del n�mero 2 marchando");
						case 2->System.out.println("Toma un sobrecito de mayonesa y un bocadillo para aliviar la derrota");
						case 3->System.out.println("�Con o sin bebida?");
					}
				}
				case"Ra�l"->{
					switch(random){
						case 1->System.out.println("Subir� al GitHub esta victoria");
						case 2->System.out.println("Vale ten�is que hacer un nuevo bolet�n el 5.9.9.9.1");
						case 3->System.out.println("Si te supieras los dispositivos de entrada y salida me habr�as vencido");
					}
				}
				case"Leo"->{
					switch(random){
						case 1->System.out.println("A si,�tu crees?");
						case 2->System.out.println("Espera un segundo ahora vuelvo contigo que me est� llamando Tom�s");
						case 3->System.out.println("Bueno como te iba contando el imperialismo,a si es cierto estabamos hablando de un ejercicio,bueno por donde ibamos,los ingleses en el siglo XVII...");
					}
				}
				case"julioprofe"->{
					switch(random){
						case 1->System.out.println("Te venc� aplicando la regla de Ruffini");
						case 2->System.out.println("Ya tengo v�deo, como vencerte en el tres en raya");
						case 3->System.out.println("Apliqu� la f�rmula de Riemann para calcular la probabilidad de mi victoria y acert�,era un 100%");
					}
				}
				case"QuantumFracture"->{
					switch(random){
						case 1->System.out.println("La respuesta de mi victoria se encuentra en los �tomos, te lo explicar�a pero no lo entender�as");
						case 2->System.out.println("Soy mejor que Javier Santaolalla y acabas de presenciarlo");
						case 3->System.out.println("El mismisimo universo ha conspirado para que yo ganara, sabe quien de los dos es f�sico y quien no");
					}
				}
				case"Miguel �ngel"->{
					switch(random){
						case 1->System.out.println("Esta partida ha estado muy bien pero te pongo un 4,perd�n quiero decir te he ganadao");
						case 2->System.out.println("Si usamos el debugger podemos ver los valores que tomaban las variables en mi victoria");
						case 3->System.out.println("(SILENCIO INC�MODO)");
					}
				}
				case"Jaime Altozano"->{
					switch(random){
						case 1->System.out.println("No has escuchado lo suficiente a Rosal�a como para vencerme");
						case 2->System.out.println("Seg�n la escala Frigia Dominante esta victoria sonar�a muy hermosa");
						case 3->System.out.println("Dejame deleitarte con una hermosa sinfon�a para celebrar mi victoria");
					}
				}
				case"Esp�ritu de Stephen Hawking"->{
					switch(random){
						case 1->System.out.println("Anda que invocarme para que te venza...");
						case 2->System.out.println("SKDJFNSLLFDSFLMD Perd�n el mecanismo para comunicarme de esta silla fantasmal a veces falla");
						case 3->System.out.println("Te preguntar�s como he colocado las fichas si soy un espectro y adem�s padezco ELA, eso mismo me pregunto yo tambi�n.");
					}
				}
				case"Latinoamericano con un canal de tutoriales"->{
					switch(random){
						case 1->System.out.println("Yo no lo descargo porque ya lo tengo");
						case 2->System.out.println("(Procede a abrir el bloc de notas y a escribir algo en �l)");
						case 3->System.out.println("(Pone su intro de Dubstep del 2012)");
					}
				}
				case"GLaDOS"->{
					switch(random){
						case 1->System.out.println("Bien los resultados de esta partida demuestran que los humanos sois muy inferiores en intelecto a los cubos de compa��a, no lo digo yo lo dice la ciencia");
						case 2->System.out.println("Como recompensa por esta partida te invito a los laboratorios de Aperture Science all� te invitar� a un pastel y disfrutaremos de las pruebas");
						case 3->System.out.println("Si tuvieras el dispositivo de crear portales hubieras tenido alguna posibilidad");
					}
				}
			
			}
			
		}
}
