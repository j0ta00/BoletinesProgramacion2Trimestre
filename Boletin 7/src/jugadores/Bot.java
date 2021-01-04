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
	//Constructor por parámetros
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
	 * Proposito:Es el método que usará la Ia para colocar las fichas siguiendo un algoritmo de colocación
	 * Entrada:char ficha,Partida partida
	 * Salida:Ninguna
	 * Precondición:Ninguna
	 * Postcondición:Se trata de un procedimiento que llamará a otros métodos para realizar distintas funciones
	 * */
	public void colocarFicha(char ficha,Partida partida){
		int casilla=0,probabilidadDeFallo=getDificultad(),random = (int) Math.floor(Math.random()*probabilidadDeFallo+1),//random 2 para la probabilidad de fallo de la Ia
		randomFallo = (int) Math.floor(Math.random()*probabilidadDeFallo+1);//random 1 para la probabilidad de fallo de la Ia
		if(random==randomFallo){//si ambos random coinciden la Ia colocará aleatoriamente 
			colocarFichaAleatoriamente(partida);//llamada al método de colocar aleatoriamente de esta forma la Ia fallará por así decirlo al no actuar de forma "inteligente"
		}else{
			casilla=colocarFichaDiagonal(partida,getFicha());//llamada al método de colocar ficha con la ficha de la Ia es decir atacamos
			if(casilla==0){
				casilla=colocarFichaHorizontal(partida,getFicha());//llamada al método de colocar ficha con la ficha de la Ia es decir atacamos
				if(casilla==0){
					casilla=colocarFichaVertical(partida,getFicha());//llamada al método de colocar ficha con la ficha de la Ia es decir atacamos
				}if(casilla==0){
					casilla=colocarFichaDiagonal(partida,ficha);//llamada al método de colocar ficha con la ficha del Jugador es decir defendemos
					if(casilla==0){
						casilla=colocarFichaHorizontal(partida,ficha);//llamada al método de colocar ficha con la ficha del Jugador es decir defendemos
						if(casilla==0){
							casilla=colocarFichaVertical(partida,ficha);//llamada al método de colocar ficha con la ficha del Jugador es decir defendemos
						}
					}
				}
			}
			switch(casilla){//según la casilla devuelta
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
	 * Precondición:Ninguna
	 * Postcondición:Se trata de una función que devuelve un booleano dosCasillasConLaMismaFicha
	 * */
		public boolean comprobarSiCercaDelTresEnRaya(Partida partida,int casilla1x, int casilla1y,int casilla2x, int casilla2y,char ficha){
			boolean dosCasillasConLaMismaFicha=false;
			if(partida.getTablero()[casilla1x][casilla1y]==ficha){//si la ficha introducida por parámetros es igual a la que hay en el tablero
				if(partida.getTablero()[casilla2x][casilla2y]==ficha ){//si la ficha introducida por parámetros es igual a la que hay en el tablero
						dosCasillasConLaMismaFicha=true;//devolverá que ambas casillas tienen la misma ficha
				}
			}
			return dosCasillasConLaMismaFicha;
	}
		/*
		 * Cabecera:public int colocarFichaDiagonal(Partida partida,char ficha)
		 * Proposito:Comprueba si en alguna diagonal hay dos fichas iguales y devuelve la casilla donde debe colocarse plara evitar el tres en raya
		 * Entrada:Partida partida,char ficha
		 * Salida:int casilla
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que devuelve un int casilla
		 * */
		public int colocarFichaDiagonal(Partida partida,char ficha){
			int casilla=0;
			if(comprobarSiCercaDelTresEnRaya(partida,1,1,0,0,ficha) && partida.comprobarCasilla(2,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse 
				casilla=9;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,1,2,2,ficha) && partida.comprobarCasilla(0,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=1;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,1,0,2,ficha) && partida.comprobarCasilla(2,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=7;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,1,2,0,ficha) && partida.comprobarCasilla(0,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=3;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,0,2,2,ficha) || comprobarSiCercaDelTresEnRaya(partida,2,0,0,2,ficha) && partida.comprobarCasilla(1,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=5;	
			}
			return casilla;
			
		}
		/*
		 * Cabecera:public int colocarFichaVertical(Partida partida,char ficha)
		 * Proposito:Comprueba si en alguna vertical hay dos fichas iguales y devuelve la casilla donde debe colocarse plara evitar el tres en raya
		 * Entrada:Partida partida,char ficha
		 * Salida:int casilla
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que devuelve un int casilla
		 * */
		public int colocarFichaVertical(Partida partida,char ficha){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
			int casilla=0;
			if(comprobarSiCercaDelTresEnRaya(partida,0,0,1,0,ficha) && partida.comprobarCasilla(2,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=7;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,1,1,1,ficha) && partida.comprobarCasilla(2,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=8;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,1,2,ficha) && partida.comprobarCasilla(2,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=9;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,0,1,0,ficha) && partida.comprobarCasilla(0,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=1;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,1,1,1,ficha) && partida.comprobarCasilla(0,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=2;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,2,1,2,ficha) && partida.comprobarCasilla(0,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=3;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,0,2,0,ficha) && partida.comprobarCasilla(1,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=4;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,1,2,1,ficha) && partida.comprobarCasilla(1,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=5;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,2,2,ficha) && partida.comprobarCasilla(1,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=6;
			}
			return casilla;
		}
		/*
		 * Cabecera:public int colocarFichaHorizontal(Partida partida,char ficha)
		 * Proposito:Comprueba si en alguna horizontal hay dos fichas iguales y devuelve la casilla donde debe colocarse plara evitar el tres en raya
		 * Entrada:Partida partida,char ficha
		 * Salida:int casilla
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que devuelve un int casilla
		 * */
		public int colocarFichaHorizontal(Partida partida,char ficha){
			int casilla=0;
			if(comprobarSiCercaDelTresEnRaya(partida,0,0,0,1,ficha) && partida.comprobarCasilla(0,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=3;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,0,1,1,ficha) && partida.comprobarCasilla(1,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=6;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,0,2,1,ficha) && partida.comprobarCasilla(2,2)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=9;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,0,1,ficha) && partida.comprobarCasilla(0,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=1;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,2,1,1,ficha) && partida.comprobarCasilla(1,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=4;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,2,2,1,ficha) && partida.comprobarCasilla(2,0)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=7;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,2,0,2,2,ficha) && partida.comprobarCasilla(2,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=8;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,1,0,1,2,ficha) && partida.comprobarCasilla(1,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=5;	
			}else if(comprobarSiCercaDelTresEnRaya(partida,0,2,0,0,ficha) && partida.comprobarCasilla(0,1)){//si en estas dos casillas esta la misma ficha se entra en el si y se devoelverá en que casilla debe colocarse
				casilla=2;	
			}
			return casilla;
		}
		/*
		 * Cabecera:public int selectorDeDificultad()
		 * Proposito:Este método permite al usuario elegir la dificultad que desea que tenga la Ia
		 * Entrada:Ninguna
		 * Salida:int respuesta
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que devolverá un entero respuesta
		 * */
		public int selectorDeDificultad(){
			int respuesta=0;
			System.out.println("INTRODUCE LA DIFICULTAD QUE DESEAS QUE TENGA LA IA:");
			System.out.println("1) Fácil");
			System.out.println("2) Normal");
			System.out.println("3) Difícil");
			System.out.println("4) Iván(Leyenda de Nervionia)");
			System.out.println("5) Entiendo el significado de las canciones de Tool");
			respuesta=teclado.nextInt();//lectura de la dificultad elegida por el usuario
			switch(respuesta){//según la dificultad elegida
			case 1->setDificultad(3);//según la dificultad elegida anteriormente le paso estas posibilidades al set
			case 2->setDificultad(5);//según la dificultad elegida anteriormente le paso estas posibilidades al set
			case 3->setDificultad(7);//según la dificultad elegida anteriormente le paso estas posibilidades al set
			case 4->setDificultad(10);//según la dificultad elegida anteriormente le paso estas posibilidades al set
			case 5->setDificultad(100);//según la dificultad elegida anteriormente le paso estas posibilidades al set
			}
			return respuesta;
		}
		/*
		 * Cabecera:public void colocarFichaAleatoriamente(Partida partida)
		 * Proposito:Se trata de un método que colocará aleatoriamente una ficha en el tablero
		 * Entrada:Partida partida
		 * Salida:Ninguna
		 * Precondición:Ninguna
		 * Postcondición:Se trata de un procedimiento que colocará aleatoriamente una ficha en el tablero
		 * */
		public void colocarFichaAleatoriamente(Partida partida){
			boolean fichaColocada=false;
			do {
				int randomx = (int) Math.floor(Math.random()*3),//random eje x del array
						randomy = (int) Math.floor(Math.random()*3);//random eje y del array
				if(Character.isDigit(partida.getTablero()[randomx][randomy])){//si en dicha casilla hay un dígito podemos colocar
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
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que devuelve un booleano fichaColocada
		 * */
		public void colocarEstrategicamente(Partida partida){
			boolean fichaColocada=false;
			do {
				if(Character.isDigit(partida.getTablero()[1][1])){//si dicha casilla del tablero tiene un número podemos colocar ahí
					partida.colocarFichaEnElArray(1, 1, getFicha());//llamamos al método para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[0][0])){//si dicha casilla del tablero tiene un número podemos colocar ahí
					partida.colocarFichaEnElArray(0, 0, getFicha());//llamamos al método para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[0][2])){//si dicha casilla del tablero tiene un número podemos colocar ahí
					partida.colocarFichaEnElArray(0, 2, getFicha());//llamamos al método para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[2][2])){//si dicha casilla del tablero tiene un número podemos colocar ahí
					partida.colocarFichaEnElArray(2, 2, getFicha());//llamamos al método para colocarla en el array
					fichaColocada=true;
				}else if(Character.isDigit(partida.getTablero()[2][0])){//si dicha casilla del tablero tiene un número podemos colocar ahí
					partida.colocarFichaEnElArray(2, 0, getFicha());//llamamos al método para colocarla en el array
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
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que deuvelve un char caracter
		 * */
		public char caracterAleatorio(){
			char caracter=' ';
			int random = (int) Math.floor(Math.random()*(60-126+1)+126);//random entre las posiciones de los caracteres en ascii
			caracter=(char) random;//casteo del int a char para devoler carácter
			return caracter;
		}
		/*
		 * Cabecera:public String eleccionRivalIa()
		 * Proposito:Seleccionará al rival según la dificultad
		 * Entrada:Ninguna
		 * Salida:Ninguna
		 * Precondición:Ninguna
		 * Postcondición:Se trata de una función que devolverá elnombre de quien será el rival de J1
		 * */
		public String eleccionRivalIa(){
			String nombre="";
			int random = (int) Math.floor(Math.random()*3+1);//aleatorio para que sea un rival aleatorio de los tres posibles en cada dificultad
			switch(selectorDeDificultad()){//se comprabará la dificultad y según esta será un rival u otro
				case 1->{
					switch(random){
					case 1-> nombre="Pedro Sánchez";
					case 2-> nombre="Santiago Abascal";
					case 3-> nombre="Mariano Rajoy";
					}	
				}
				case 2->{
					switch(random){
					case 1-> nombre="Pedro";
					case 2-> nombre="Juan José";
					case 3-> nombre="La dependienta del polvillo";
					}	
				}
				case 3->{
					switch(random){
					case 1-> nombre="Raúl";
					case 2-> nombre="Leo";
					case 3-> nombre="Miguel Ángel";
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
					case 1-> nombre="Espíritu de Stephen Hawking";
					case 2-> nombre="Latinoamericano con un canal de tutoriales";
					case 3-> nombre="GLaDOS";
					}
				}
			}
			return nombre;
		}
		/*
		 * Cabecera:comentarioSarcastico()
		 * Proposito:Según el rival cuando este gane imprimira un texto u otro
		 * Entrada:Ninguna
		 * Salida:Ninguna
		 * Precondición:El método solo será llamado cuando el ganador sea la CPU
		 * Postcondición:Se trata de un procedimiento que imprime un comentario jocoso
		 * */
		public void comentarioSarcastico(){
			int random = (int) Math.floor(Math.random()*3+1);//aleatorio para que diga una de las tres posibles frases de cada personajes
			switch(getNombre()){//se mira el nombre y se comparara en este switch pues cada rival tiene frases propias
				case"Pedro Sánchez"->{
					switch(random){
						case 1->System.out.println("Nadie ha hecho tanto daño a las instituciones catalanas como el independentismo\n(Un año después pactó con partidos independentistas...)");
						case 2->System.out.println("Este escenario de la segunda ola con la llegada del frío lo habíamos previsto y ha llegado por desgracia");
						case 3->System.out.println("Sabemos cuál es el origen de los rebrotes\n(Frase pronuncida en Noviembre y se aproxima un tercera ola...)");
					}
				}
				case"Santiago Abascal"->{
					switch(random){
						case 1->System.out.println("Jajajaja has perdido vuelve a tu país");
						case 2->System.out.println("Mi victoria demuestra que hay que derogar las leyes del 3 en raya");
						case 3->System.out.println("Para celebrarlo un puro y una copa de whiskey,¡mujer ya me has oído!");
					}
				}
				case"Mariano Rajoy"->{
					switch(random){
						case 1->System.out.println("Dije que te ganaría y he perdido");
						case 2->System.out.println("Una raya es una raya y un tres es un tres");
						case 3->System.out.println("Me gustan los programadores porque hacen cosas");
					}
				}
				case"Pedro"->{
					switch(random){
						case 1->System.out.println("Toma te he ganado y además tengo más que tú en el examen");
						case 2->System.out.println("Si hubieras programado en el bloc de notas me habrías ganado");
						case 3->System.out.println("Si no le contesto se desespera...");
					}
				}
				case"Juan José"->{
					switch(random){
						case 1->System.out.println("Te explicaría como te he ganado pero lo ha hecho Alejandro");
						case 2->System.out.println("Espérate un segundo,Leo ven tengo una duda");
						case 3->System.out.println("Yo si quieres expongo el ejercicio");
					}
				}
				case"La dependienta del polvillo"->{
					switch(random){
						case 1->System.out.println("Uno del número 2 marchando");
						case 2->System.out.println("Toma un sobrecito de mayonesa y un bocadillo para aliviar la derrota");
						case 3->System.out.println("¿Con o sin bebida?");
					}
				}
				case"Raúl"->{
					switch(random){
						case 1->System.out.println("Subiré al GitHub esta victoria");
						case 2->System.out.println("Vale tenéis que hacer un nuevo boletín el 5.9.9.9.1");
						case 3->System.out.println("Si te supieras los dispositivos de entrada y salida me habrías vencido");
					}
				}
				case"Leo"->{
					switch(random){
						case 1->System.out.println("A si,¿tu crees?");
						case 2->System.out.println("Espera un segundo ahora vuelvo contigo que me está llamando Tomás");
						case 3->System.out.println("Bueno como te iba contando el imperialismo,a si es cierto estabamos hablando de un ejercicio,bueno por donde ibamos,los ingleses en el siglo XVII...");
					}
				}
				case"julioprofe"->{
					switch(random){
						case 1->System.out.println("Te vencí aplicando la regla de Ruffini");
						case 2->System.out.println("Ya tengo vídeo, como vencerte en el tres en raya");
						case 3->System.out.println("Apliqué la fórmula de Riemann para calcular la probabilidad de mi victoria y acerté,era un 100%");
					}
				}
				case"QuantumFracture"->{
					switch(random){
						case 1->System.out.println("La respuesta de mi victoria se encuentra en los átomos, te lo explicaría pero no lo entenderías");
						case 2->System.out.println("Soy mejor que Javier Santaolalla y acabas de presenciarlo");
						case 3->System.out.println("El mismisimo universo ha conspirado para que yo ganara, sabe quien de los dos es físico y quien no");
					}
				}
				case"Miguel Ángel"->{
					switch(random){
						case 1->System.out.println("Esta partida ha estado muy bien pero te pongo un 4,perdón quiero decir te he ganadao");
						case 2->System.out.println("Si usamos el debugger podemos ver los valores que tomaban las variables en mi victoria");
						case 3->System.out.println("(SILENCIO INCÓMODO)");
					}
				}
				case"Jaime Altozano"->{
					switch(random){
						case 1->System.out.println("No has escuchado lo suficiente a Rosalía como para vencerme");
						case 2->System.out.println("Según la escala Frigia Dominante esta victoria sonaría muy hermosa");
						case 3->System.out.println("Dejame deleitarte con una hermosa sinfonía para celebrar mi victoria");
					}
				}
				case"Espíritu de Stephen Hawking"->{
					switch(random){
						case 1->System.out.println("Anda que invocarme para que te venza...");
						case 2->System.out.println("SKDJFNSLLFDSFLMD Perdón el mecanismo para comunicarme de esta silla fantasmal a veces falla");
						case 3->System.out.println("Te preguntarás como he colocado las fichas si soy un espectro y además padezco ELA, eso mismo me pregunto yo también.");
					}
				}
				case"Latinoamericano con un canal de tutoriales"->{
					switch(random){
						case 1->System.out.println("Yo no lo descargo porque ya lo tengo");
						case 2->System.out.println("(Procede a abrir el bloc de notas y a escribir algo en él)");
						case 3->System.out.println("(Pone su intro de Dubstep del 2012)");
					}
				}
				case"GLaDOS"->{
					switch(random){
						case 1->System.out.println("Bien los resultados de esta partida demuestran que los humanos sois muy inferiores en intelecto a los cubos de compañía, no lo digo yo lo dice la ciencia");
						case 2->System.out.println("Como recompensa por esta partida te invito a los laboratorios de Aperture Science allí te invitaré a un pastel y disfrutaremos de las pruebas");
						case 3->System.out.println("Si tuvieras el dispositivo de crear portales hubieras tenido alguna posibilidad");
					}
				}
			
			}
			
		}
}
