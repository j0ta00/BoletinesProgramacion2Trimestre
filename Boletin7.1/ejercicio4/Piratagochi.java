package ejercicio4;
import java.util.Random;

public class Piratagochi {
	//Objeto random
	Random random= new Random();
	//Atributos estáticos
	private static final int MAXIMODELOSATRIBUTOS = 10;
	private static final int MINIMODELOSATRIBUTOS = 0;
	//Atributos
	private String nombre;
	private int energia;
	private boolean estaHambriento;
	private int nivelFelicidad;
	
	//Métodos constructores
	//Constructor por parámetros
	public Piratagochi(String nombre){
		this.nombre=nombre;
		double random1=Math.random()*11;
		energia=(int)random1;
		estaHambriento=random.nextBoolean();
		random1=Math.random()*11;
		nivelFelicidad=(int)random1;
 	}
	//Métodos fundamentales
	//Getters
	public String getNombre() {
		return nombre;
	}
	public int getEnergia() {
		return energia;
	}
	public int getNivelFelicidad() {
		return nivelFelicidad;
	}
	public boolean isEstaHambriento() {
		return estaHambriento;
	}
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
		if(energia>MAXIMODELOSATRIBUTOS){
			energia=MAXIMODELOSATRIBUTOS;
		}else if(energia<MINIMODELOSATRIBUTOS){
			energia=MINIMODELOSATRIBUTOS;
		}
	}
	public void setNivelFelicidad(int nivelFelicidad) {
		this.nivelFelicidad = nivelFelicidad;
		if(nivelFelicidad>MAXIMODELOSATRIBUTOS){
			nivelFelicidad=MAXIMODELOSATRIBUTOS;
		}else if(nivelFelicidad<MINIMODELOSATRIBUTOS){
			nivelFelicidad=MINIMODELOSATRIBUTOS;
		}
	}
	
	public void setEstaHambriento(boolean estaHambriento) {
		this.estaHambriento = estaHambriento;
	}
	
	//Métodos adicionales
	public void comer(){
		if(estaHambriento){
			estaHambriento=false;
		}else{
			setNivelFelicidad(nivelFelicidad-1);
		}
	}
	public void dormir(int horasDurmiendo){
		if(energia+horasDurmiendo>MAXIMODELOSATRIBUTOS){
			setNivelFelicidad(nivelFelicidad-(MAXIMODELOSATRIBUTOS-energia));
			energia=MAXIMODELOSATRIBUTOS;
		}else{
			energia+=horasDurmiendo;
		}
	}
	public void jugar(int horasJugando){
		if(!estaHambriento){
			setNivelFelicidad(nivelFelicidad+horasJugando);
			setEnergia(energia-horasJugando);
			estaHambriento=true;
		}else{
			setNivelFelicidad(nivelFelicidad-horasJugando);
			setEnergia(energia-horasJugando);
		}
	}
	public String getNecesidades(){
		String necesidad="";
		if(energia<5){
			System.out.println("La energía de "+nombre+" es muy baja dejale descansar");
		}else if(estaHambriento){
			System.out.println("El hambre de "+nombre+" es muy grande dale de comer");
		}else if(nivelFelicidad<5){
			System.out.println("El nivel de felicidad de "+nombre+" esta bajo juega un poco con él");
		}
		return necesidad;	
	}
}