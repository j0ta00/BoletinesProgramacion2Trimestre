package resguardos;

import clases.AfiliadoImp;
import enumerados.TypoActivity;

public class resguardosClub {

	/*
	 * Interfaz
	 * Nombre: generarListaAfiliado
	 * Comentario: Este subprograma genera automaticamente la lista de afiliados
	 * Cabecera: public AfiliadoImp[] generarListaAfiliado()
	 * Precondiciones: No hay
	 * Entrada: No hay
	 * Salida: AfiliadoImp[] afiliados //Lista con algunos afiliados por defecto
	 * E/S: No hay
	 * Postcondiciones: Asociado al nombre, se genera la lista de afiliados con algunos afiliados por defecto
	 */
	
	public AfiliadoImp[] generarListaAfiliado() {
		clases.AfiliadoImp[] afiliados = new AfiliadoImp[10];
		System.out.println("En resguardo");
		return afiliados;
	}
	
	/*
	 * Interfaz
	 * Nombre: introducirAfiliado
	 * Comentario: Este subprograma introduce en la lista el afiliado
	 * Cabecera: public void introducirAfiliado(AfiliadoImp afiliado, AfiliadoImp[] afiliados)
	 * Precondiciones: La lista no debe estar llena
	 * Entrada: AfiliadoImp afiliado //El afiliado ha introducir en la lista
	 * Salida: No hay
	 * E/S:  AfiliadoImp[] afiliados //La lista de afiliados
	 * Postcondiciones: La lista queda con el afiliado introducido
	 */
	public void introducirAfiliado(AfiliadoImp afiliado, AfiliadoImp[] afiliados) {
		boolean introducir = false;
		for(int i = 0; i < afiliados.length && introducir == false; i++) {
			if(afiliados[i] == null) {
				afiliados[i] = afiliado;
				introducir = true;
			}
		}
	}
	
	/*
	 * Interfaz
	 * Nombre: listaCompleta
	 * Comentario: Este subprograma informa de si la lista esta completa o no
	 * Cabecera: public boolean listaCompleta(AfiliadoImp[] afiliados)
	 * Precondiciones: La lista no debe estar llena
	 * Entrada: AfiliadoImp[] afiliados //La lista de afiliados
	 * Salida: boolean completa //Te informa si la lista esta completa o no
	 * E/S: No hay
	 * Postcondiciones: Asociado al nombre. Es true si la lista esta completa y false si no es asi
	 */
	public boolean listaCompleta(AfiliadoImp[] afiliados) {
		System.out.println("En resguardo");
		return false;
	}
	
	/*
	 * Interfaz
	 * Nombre: ListaMismaActividad
	 * Comentario: Este subprograma muestra una lista con los afiliados que estan en la misma actividad
	 * Cabecera: public void ListaMismaActividad(AfiliadoImp[] afiliados, TypoActivity actividad)
	 * Precondiciones: No hay
	 * Entrada: - AfiliadoImp[] afiliados //la lista de afiliados
	 * 			- TypoActivity actividad //El tipo de actividad que desea el usuario
	 * Salida: No hay
	 * E/S: No hay
	 * Postcondiciones: Pinta en pantalla las personas que estan en el mismo tipo de actividad
	 */
	public void ListaMismaActividad(AfiliadoImp[] afiliados, TypoActivity actividad){
		System.out.println("En resguardo");
	}
	
	/*
	 * Interfaz
	 * Nombre: CuantasPersonasActividad
	 * Comentario: Este subprograma cuenta los afiliados que estan en la misma actividad
	 * Cabecera: public int CuantasPersonasActividad(AfiliadoImp[] afiliados, TypoActivity actividad)
	 * Precondiciones: No hay
	 * Entrada: - AfiliadoImp[] afiliados //la lista de afiliados
	 * 			- TypoActivity actividad //El tipo de actividad que desea el usuario
	 * Salida: - int contPersonas
	 * E/S: No hay
	 * Postcondiciones: Asociado al nombre, el numero de personas que realizan esa actividad
	 */
	public int CuantasPersonasActividad(AfiliadoImp[] afiliados, TypoActivity actividad) {
		System.out.println("En resguardo");
		return 0;
	}
		
}
