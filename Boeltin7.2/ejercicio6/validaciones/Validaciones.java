package ejercicio6.validaciones;

import java.util.Scanner;

public class Validaciones{
	
	static Scanner teclado= new Scanner(System.in);
	
	public static int validarRespuesta() throws IllegalArgumentException{
		int respuesta=0;
		respuesta=teclado.nextInt();
		while(respuesta!=1 && respuesta!=2){
			System.out.println("Opci�n erronea, introduzca solo 1 o 2 seg�n la opci�n que desee:");
			respuesta=teclado.nextInt();
		}
		return respuesta;
	}

}
