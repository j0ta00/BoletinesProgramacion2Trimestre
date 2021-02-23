package dni;
import java.util.Scanner;
/**
 * @author jjmza<b><br>
 * Nombre de la clase:<b>Dni<br>
 * Proposito:<b> Se trata de una clase compuesta por varios m�todos relacionados con los objetos Dni<br>
 * Propiedades:<b><br>
 * -private int numerosDni;<br>
 * -private char letraDni;<br>
 * Propiedades Compartidas:<b><br>
 * M�todos Accesores:<b><br>
 * -public int getNumerosDni()<br> 
 * -public char getLetraDni()<br>
 * M�todos Adicionales:<b><br>
 *-public boolean comprobarSiDniValido()
 * */
public class Dni{
	//Objeto est�tico teclado
	static Scanner teclado=new Scanner(System.in);
	//Atributo Compartido
	private char[] tablaDeCaracters={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	//Atributos
	private int numerosDni;
	private char letraDni;

	//M�todos accesores
	//Getters
	public int getNumerosDni() {
		return numerosDni;
	}
	public char getLetraDni() {
		return letraDni;
	}
	//M�todo constructor
	//Por defecto
	public Dni(){
		while(numerosDni>99999999|| numerosDni<10000000){
			System.out.println("Introduce solo el n�mero de tu dni");
			numerosDni = teclado.nextInt();
		}
		while(!Character.isLetter(letraDni)){
			System.out.println("Introduce la letra de t� dni");
			this.letraDni = teclado.next().toUpperCase().charAt(0);
		}
	}
	/**
	 * @author jjmza<br>
	 * Cabecera:public boolean comprobarSiDniValido()<br>
	 * Proposito:Se trata de un m�todo que comprueba si la letra de un Dni es la adecuada<br>
	 * y por lo tanto es un dni v�lido<br>
	 * Precondici�n:El objeto Dni debe ser creado con anterioridad<br>
	 * Postcondici�n:Se trata de una funci�n que devuelve un booleano<br>
	 *  @parama Ninguno
	 *  @return booleano indicando s� la letra del Dni es la letra que le corresponde y por lo tanto es v�lido o no
	 *  
	 */
	public boolean comprobarSiDniValido(){
		return tablaDeCaracters[numerosDni%23]==letraDni;
	}
	
	
	
	
}
