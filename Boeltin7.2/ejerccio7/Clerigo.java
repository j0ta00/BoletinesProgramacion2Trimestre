package ejerccio7;

import ejerccio7.Enum.Armas;
import ejerccio7.Enum.Hechizos;

/*
 * .Nombre de la clase:Clerigo
 * 
 * .Propiedades Básicas:
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
 *.Propiedades Derivadas: public boolean getVivo()-> Nos dice si el personaje esta vivo o no
 * 
 *.Propiedades Compartidas:Ninguna
 * 
 *.Metodos accesores Gets y Sets
 * 
 * 	public Enum getArma() 
 *	public void setArma(Enum arma)
 *	 
 *  public String getRaza()
 *  public void setRaza(String raza)
 *  
 *  public String getProfesion()
 *  public void setProfesion(String profesion)
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
 *public void setInteligencia(int inteligencia) 
 *public int getInteligencia();
 *
 *public void setHechizo(Hechizos hechizo)
 *public Hechizos getHechizo();
 *
 *.Requisitos:Ninguno
 * 
 * Métodos añadidos: 
 * 
 * */
public class Clerigo extends Personaje{
	
	//Métodos constructores
	//Constructor por defecto
	public Clerigo(){
		super();
		setRaza("Catarino");
		setProfesion("Clerigo de la Blanca Vía");	
	}
	//Constructor por parámetros
	public Clerigo(Armas arma,Hechizos hechizo,int vida, int fuerza, int destreza, int velocidad, int resistencia, int fe, int inteligencia){
		super(arma,hechizo,vida,fuerza,destreza,velocidad,resistencia,fe,inteligencia);
		setRaza("Catarino");
		setProfesion("Clerigo de la Blanca Vía");	
	}
	//Métodos accesores
	//Getters
	public Armas getArma(){
		return super.getArma();
	}
	public String getProfesion(){
		return super.getProfesion();
	}
	public String getRaza(){
		return super.getRaza();
	}
	public int getVida(){
		return super.getVida();
	}
	public int getFuerza(){
		return super.getDestreza();
	}
	public int getDestreza(){
		return super.getDestreza();
	}
	public int getVelocidad(){
		return super.getVelocidad();
	}
	public int getResistencia(){
		return super.getResistencia();
	}
	public int getFe(){
		return super.getFe();
	}
	public int getInteligencia() {
	return super.getInteligencia();
	}
	public Hechizos getHechizo() {
		return super.getHechizo();
	}
	//Setters
	public void setArma(Armas arma){
		super.setArma(arma);
	}
	public void setProfesion(String profesion){
		super.setProfesion(profesion); 
	}
	public void setRaza(String raza){
		super.setRaza(raza);
	}
	public void setVida(int vida){
		super.setVida(vida);
	}
	public void setFuerza(int fuerza){
		super.setFuerza(fuerza);
	}
	public void setDestreza(int destreza){
		super.setDestreza(destreza);
	}

	public void setVelocidad(int velocidad){
		super.setVelocidad(velocidad);
	}
	public void setResistencia(int resistencia){
		super.setResistencia(resistencia);
	}
	public void setFe(int fe){
		super.setFe(fe);
	}
	public void setInteligencia(int inteligencia) {
		super.setInteligencia(inteligencia);
	}

	public void setHechizo(Hechizos hechizo) {
		super.setHechizo(hechizo);
	}
	//Propiedad derivada
	public boolean getVivo(){
		return super.getVivo();
	}
	//Métodos añadidos
	@Override
	public int atacarCuerpoACuerpo() {
		return super.atacarCuerpoACuerpo();
	}
	@Override
	public void recibirDanho(int danho) {
		super.recibirDanho(danho);
	}
	@Override
	public int lanzarHechizo() {
		return super.lanzarHechizo();
	}
	public void intercambiarArma(Armas arma){
		super.setArma(arma);
	}
	
	public void intercambiarHechizos(Hechizos hechizo){
		super.setHechizo(hechizo);
	}
	
	/*
	 * Cabecera:public void desempenharProfesion()
	 * Proposito:Aumenta las carácterísticas del personaje según la clase del personaje es decir este método será diferente según la instancia de la clase que lo llame
	 * Entrada:Ninguna
	 *Salida:Ninguna
	 *Precondición:Ninguna
	 *Postcondición:Se trata de un procedimiento que no devuelve nada simplemente aumenta ciertas características del personaje
	 * */
	@Override
	public void desempenharProfesion(){
	setFe(getFe()+15);//Aumenta la fe en 15 debido a que es un clerigo afín a las deidades
	setResistencia(getResistencia()+5);//Aumenta su resistencia debido a su dura y austera vida
	setVida(getVida()+35);//Aumenta su salud gracias a que los dioses le recompensan por su devoción
	}

	
	
	

}
