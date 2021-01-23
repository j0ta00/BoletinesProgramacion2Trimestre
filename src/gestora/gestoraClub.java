package gestora;

import clases.AfiliadoImp;
import clases.Fecha;
import enumerados.TypoActivity;

public class gestoraClub {

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
		AfiliadoImp[] afiliados = new AfiliadoImp[10];
		Fecha fecha = new Fecha(1998,11,15);
		TypoActivity act = null;
		afiliados[0] = new AfiliadoImp("Rafa", fecha, act.LOW, 30, 100.0, 1);
		afiliados[1] = new AfiliadoImp("Yeray", fecha, act.MEDIUM, 60, 75.0, 1);
		afiliados[2] = new AfiliadoImp("Manuel", fecha, act.LOW, 30, 83.0, 1);
		afiliados[3] = new AfiliadoImp("Victor", fecha, act.HIGH, 120, 72.0, 1);
		afiliados[4] = new AfiliadoImp("Pablo", fecha, act.LOW, 30, 68.0, 1);
		afiliados[5] = new AfiliadoImp("Dani", fecha, act.HIGH, 100, 85.0, 1);
		afiliados[6] = new AfiliadoImp("Alejandro", fecha, act.MEDIUM, 55, 68.0, 1);
		afiliados[7] = new AfiliadoImp("Angela", fecha, act.MEDIUM, 50, 50.0, 1);
		
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
	
	//TODO sdfsdf
	
	public boolean listaCompleta(AfiliadoImp[] afiliados) {
		boolean completa = true;
		for(int i = 0; i < afiliados.length && completa == true; i++) {
			if(afiliados[i] == null) {
				completa = false;
			}
		}
		
		return completa;
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
		for(int i = 0; i < afiliados.length; i++) {
			if(afiliados[i].getTypeActivity() == actividad) {
				System.out.println(afiliados[i].toString());
			}
		}
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
		int contPersonas = 0;
		for(int i = 0; i < afiliados.length; i++) {
			if(afiliados[i].getTypeActivity() == actividad) {
				contPersonas++;
			}
		}
		return contPersonas++;
	}
	
}
