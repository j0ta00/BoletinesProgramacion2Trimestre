package dni;
/**
 * @author jjmza<b><br>
 * Nombre de la clase:<b>Main<br>
 * Proposito: Se trata de la clase principal en la que se ejecutar� los m�todos referentes a la Clase Dni<br>
 */
public class Main {
	public static void main(String[] args) {
			Dni dni = new Dni();
			if(dni.comprobarSiDniValido()){
				System.out.println("Es v�lido");
			}else{
				System.out.println("Es incorrecto");
			}
	}

}
