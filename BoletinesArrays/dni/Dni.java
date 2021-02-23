package dni;
import java.util.Scanner;
/**
 * @author jjmza<b><br>
 * Nombre de la clase:<b>Dni<br>
 * Proposito:<b> Se trata de una clase compuesta por varios métodos relacionados con los objetos Dni<br>
 * Propiedades:<b><br>
 * -private int numerosDni;<br>
 * -private char letraDni;<br>
 * Propiedades Compartidas:<b><br>
 * Métodos Accesores:<b><br>
 * -public int getNumerosDni()<br> 
 * -public char getLetraDni()<br>
 * Métodos Adicionales:<b><br>
 *-public boolean comprobarSiDniValido()
 * */
public class Dni{
	//Objeto estático teclado
	static Scanner teclado=new Scanner(System.in);
	//Atributo Compartido
	private char[] tablaDeCaracters={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	//Atributos
	private int numerosDni;
	private char letraDni;

	//Métodos accesores
	//Getters
	public int getNumerosDni() {
		return numerosDni;
	}
	public char getLetraDni() {
		return letraDni;
	}
	//Método constructor
	//Por defecto
	public Dni(){
		while(numerosDni>99999999|| numerosDni<10000000){
			System.out.println("Introduce solo el número de tu dni");
			numerosDni = teclado.nextInt();
		}
		while(!Character.isLetter(letraDni)){
			System.out.println("Introduce la letra de tú dni");
			this.letraDni = teclado.next().toUpperCase().charAt(0);
		}
	}
	/**
	 * @author jjmza<br>
	 * Cabecera:public boolean comprobarSiDniValido()<br>
	 * Proposito:Se trata de un método que comprueba si la letra de un Dni es la adecuada<br>
	 * y por lo tanto es un dni válido<br>
	 * Precondición:El objeto Dni debe ser creado con anterioridad<br>
	 * Postcondición:Se trata de una función que devuelve un booleano<br>
	 *  @parama Ninguno
	 *  @return booleano indicando sí la letra del Dni es la letra que le corresponde y por lo tanto es válido o no
	 *  
	 */
	public boolean comprobarSiDniValido(){
		return tablaDeCaracters[numerosDni%23]==letraDni;
	}
	
	
	
	
}
