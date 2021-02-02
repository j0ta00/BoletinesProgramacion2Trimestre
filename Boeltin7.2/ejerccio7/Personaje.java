package ejerccio7;

import ejerccio7.Enum.Armas;
import ejerccio7.Enum.Hechizos;

/*
 * .Nombre de la clase abstracta: Personaje
 * 
 * .Propiedades B�sicas:
 * 
 * -arma:Tipo enumerado consultable y modificable 
 * 
 * -raza:Tipo Cadena consultable y modificable
 * 
 * -profesion:Tipo Cadena consultable y modificable
 * 
 * -vida:Tipo Entero consultable y modificable 
 * 
 * -fuerza:Tipo Entero consultable y modificable
 * 
 * -destreza:Tipo Entero consultable y modificable
 * 
 * -velocidad:Tipo Entero consultable y modificable
 * 
 * -resistencia:Tipo Entero consultable y modificable
 * 
 * -fe:Tipo Entero consultable y modificable
 * 
 *.Propiedades Derivadas: public boolean GetVivo()-> Nos dice si el personaje esta vivo o no
 * 
 *.Propiedades Compartidas:Ninguna
 * 
 *.Metodos accesores Gets y Sets
 * 
 * 	public Enum getArma() 
 *	public void setArma(Enum arma)
 *	 
 *	public int getVida() 
 *	public void setVida(int vida)  
 *	
 *	public int getFuerza() 
 *	public void setFuerza(int fuerza)
 *	 
 *	public int getDestreza() 
 *	public void setDestreza(int destreza) 
 *	
 *	public int getVelocidad() 
 *	public void setVelocidad(int velocidad) 
 *
 *	public int getResistencia() 
 *	public void setResistencia(int resistencia) 
 *	
 *	public int getFe() 
 *	public void setFe(int fe) 
 *	
 *.Requisitos:Ninguno
 * 
 * M�todos a�adidos: 
 * 
 * */
public abstract class Personaje{
	
	//Atributos de la clase
		private Armas arma;
		private Hechizos hechizo;
		private String raza;
		private String profesion;
		private int vida;
		private int fuerza;
		private int destreza;
		private int velocidad;
		private int resistencia;
		private int fe;
		private int inteligencia;

		//M�todos constructores
		//Constructor por defecto
		public Personaje(){
		this.arma = Armas.Talisman;
		this.setHechizo(Hechizos.Sanacion);
		this.vida = 245;
		this.fuerza = 28;
		this.destreza = 14;
		this.velocidad = 21;
		this.resistencia = 27;
		this.fe = 36;
		this.inteligencia=8;
		}
		//Constructor por par�metros
		public Personaje(Armas arma,Hechizos hechizo,int vida, int fuerza, int destreza, int velocidad, int resistencia, int fe, int inteligencia){
			this.arma = arma;
			this.hechizo = hechizo;
			this.vida = vida;
			this.fuerza = fuerza;
			this.destreza = destreza;
			this.velocidad = velocidad;
			this.resistencia = resistencia;
			this.fe = fe;
			this.inteligencia=inteligencia;
		}
		
		//M�todos accesores
		//Getters
		public Armas getArma(){
			return arma;
		}
		public String getProfesion(){
			return profesion;
		}
		public String getRaza(){
			return raza;
		}
		public int getVida(){
			return vida;
		}
		public int getFuerza(){
			return fuerza;
		}
		public int getDestreza(){
			return destreza;
		}
		public int getVelocidad(){
			return velocidad;
		}
		public int getResistencia(){
			return resistencia;
		}
		public int getFe(){
			return fe;
		}
		public int getInteligencia() {
		return inteligencia;
		}
		public Hechizos getHechizo() {
			return hechizo;
		}
		//Setters
		public void setArma(Armas arma){
			this.arma = arma;
		}
		public void setProfesion(String profesion){
			this.profesion = profesion;
		}
		public void setRaza(String raza){
			this.raza = raza;
		}
		public void setVida(int vida){
			this.vida = vida;
		}
		public void setFuerza(int fuerza){
			this.fuerza = fuerza;
		}
		public void setDestreza(int destreza){
			this.destreza = destreza;
		}

		public void setVelocidad(int velocidad){
			this.velocidad = velocidad;
		}
		public void setResistencia(int resistencia){
			this.resistencia = resistencia;
		}
		public void setFe(int fe){
			this.fe = fe;
		}
		public void setInteligencia(int inteligencia) {
			this.inteligencia = inteligencia;
		}

		public void setHechizo(Hechizos hechizo) {
			this.hechizo = hechizo;
		}
		//Propiedad derivada
		
		public boolean getVivo(){
			boolean vivo=true;
			if(vida<=0){
				vivo=false;
			}
			return vivo;
		}
/*
 * Cabecera:public int AtacarCuerpoACuerpo()
 * Proposito:El personaje que llame a este m�todo atacar� en base a sus caracter�sticas devolviendo este el valor del da�o que ha realizado
 * Entrada:Ninguna
 * Salida:Entero danhoRealizado
 *Precondici�n:Los atributos del personaje no deben ser nulos o valer 0
 *Postcondici�n:Se trata de una funci�n que devuelve un entero con el da�o que realizo nuestro personaje
 * */
		public int atacarCuerpoACuerpo(){
			int danhoRealizado=0;//el da�o realizado depender� de los atributos del personaje y del tipo de arma
			switch(arma.getTipo()){//sabiendo el tipo de arma sabemos con que caracter�stica escala
			case 'M'->danhoRealizado=(int) Math.floor(inteligencia*arma.getMultiplicadorDanhoMagico());//Si es un arma m�gica escalar� con inteligencia
			case 'F'->danhoRealizado=(int) Math.floor(fuerza*arma.getMultiplicadorDanhoFisico());//Si es un arma f�sica escalar� con la fuerza
			case 'A'->danhoRealizado=(int) Math.floor(destreza*arma.getMultiplicadorDanhoFisico());//Si es un arma �gil escalar� con la destreza
			case 'D'->danhoRealizado=(int) Math.floor(fe*arma.getMultiplicadorDanhoMagico());//Si es un arma divina escalar� con la fe
			case 'N'->danhoRealizado=(int) Math.floor(fuerza*arma.getMultiplicadorDanhoMagico());//Si es un arma nula no es un arma para atacar cuerpo a cuerpo y realizar� un da�o min�sculo
		}
			return danhoRealizado;
		}
		/*
		 * Cabecera:public void RecibirDanho(int ataque)
		 * Proposito:El personaje recibe un ataque y por lo tanto pierde cierta cantidad de vida a consecuencia de esto
		 * Entrada:Entero ataque
		 * Salida:Ninguna
		 *Precondici�n:Ninguna
		 *Postcondici�n:Se trata de un procedimiento que no devuelve nada
		 * */
		public void recibirDanho(int ataque){
			vida-=ataque;
		}
		/*
		 * Cabecera:public int LanzarHechizo()
		 * Proposito:El personaje lanza un hechizo que hiere al rival
		 * Entrada:Ninguna
		 * Salida:Entero lanzar hechizo
		 *Precondici�n:Ninguna
		 *Postcondici�n:Se trata de un procedimiento que no devuelve nada
		 * */
		public int lanzarHechizo(){
			int poderDelHechizo=determinarTipoHechizo();
			return poderDelHechizo;
		}
		/*
		 * Cabecera:private int DeterminarTipoHechizo()
		 * Proposito:Determina que tipo de hechizo es el que ha realizado el personaje y el efecto que tendr� sobre este
		 * Entrada:Ninguna
		 * Salida:Entero danho del hechizo
		 *Precondici�n:Ninguna
		 *Postcondici�n:Se trata de una funci�n que devuelve un entero con el da�o que realiza el hechizo
		 * */
		private int determinarTipoHechizo(){
			int danhoDelHechizo=0;
			if(arma.getTipo()!='F' || arma.getTipo()!='A' ){//determinamos primero si es un arma apta para lanzar hechizos
				switch(hechizo.getTipo()){//determinar que tipo de hechizo ser�
				case 'C'->{danhoDelHechizo=(int) Math.floor(determinarConQueEscalaHechizo()*hechizo.getMultiplicadorDanho()*arma.getMultiplicadorDanhoMagico());
				vida+=danhoDelHechizo;
				danhoDelHechizo=0;
				}//Los hechizos curativos restaurar�n salud al personaje que los realice
				case 'A'->danhoDelHechizo=(int) Math.floor(determinarConQueEscalaHechizo()*hechizo.getMultiplicadorDanho()*arma.getMultiplicadorDanhoMagico());//Los hechizos de ataque realizan da�o a tu rival
				case 'P'->danhoDelHechizo=(int) Math.floor(arma.getMultiplicadorDanhoMagico()*hechizo.getMultiplicadorDanho());//Las piromancias no escalan con nada
				}
		}
			return danhoDelHechizo;
		}
		/*
		 * Cabecera:private int DeterminarConQueEscalaHechizo()
		 * Proposito:Determina con que atributo del personaje escala el hechizo
		 * Entrada:Ninguna
		 * Salida:Entero danho del hechizo
		 *Precondici�n:Ninguna
		 *Postcondici�n:Se trata de una funci�n que devuelve un entero con el da�o que realiza el hechizo
		 * */
		private int  determinarConQueEscalaHechizo(){
			int valorEscalado=0;
			switch(hechizo.getCaracteristicaConLaQueEscala()){//Si un hechizo no escala con nada como por ejemplo las piromancias su valor de escalado ser� 0
				case 'F'-> valorEscalado=fe;//Escala con fe es decir usa su fe para conjurar hechizos
				case 'I'-> valorEscalado=inteligencia;//Escala con inteligencia es decir usa su inteligencia para conjurar hechizos
				case 'A'->{//Aumento, esto quiere decir que potencia la mejor caracter�stica del personaje
					if(fuerza>=destreza){
						fuerza*=2;
					}else{
						destreza*=2;
					}
				}
			}
			return valorEscalado ;
		}
		/*
		 * Cabecera:public void intercambiarArma(Armas arma)
		 * Proposito:Cambia el arma que porta el personaje por la introducida por par�metros
		 * Entrada:Armas arma
		 * Salida:Ninguna
		 *Precondici�n:Ninguna
		 *Postcondici�n:Se trata de un procedimiento que no devuelve nada solo intercambia el arma que lleva el personaje por otra
		 * */
		public void intercambiarArma(Armas arma){
			setArma(arma);
		}
		/*
		 * Cabecera:public void intercambiarHechizos(Hechizos hechizo)
		 * Proposito:Cambia el hechizo que porta el personaje por el introducida por par�metros
		 * Entrada:Hechizos hechizo
		 * Salida:Ninguna
		 *Precondici�n:Ninguna
		 *Postcondici�n:Se trata de un procedimiento que no devuelve nada solo intercambia el hechizo que lleva el personaje por otro
		 * */
		public void intercambiarHechizos(Hechizos hechizo){
			setHechizo(hechizo);
		}
		//M�todo abstracto se explica en cada una de las clase que lo heredan y por lo tanto construyen su cuerpo
		public abstract void desempenharProfesion();
}
