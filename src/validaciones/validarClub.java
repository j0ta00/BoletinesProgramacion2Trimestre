package validaciones;

import java.util.*;

import clases.AfiliadoImp;
import clases.Fecha;
import enumerados.TypoActivity;
import menus.menuClub;

public class validarClub {

	/*
	 * Interfaz
	 * Nombre: validarAfiliado
	 * Comentario: Este subprograma valida un afiliado que quiere introducirse en el club
	 * Cabecera: public AfiliadoImp validarAfilado()
	 * Precondiciones: No hay
	 * Entrada: No hay
	 * Salida: - AfiliadoImp afiliado //El afiliado que se introduce en el club
	 * E/S: No hay
	 * Postcondiciones: Asociado al nombre, el afiliado nuevo en el club con sus datos correctos
	 */
	
	public AfiliadoImp validarAfilado() {
		AfiliadoImp afiliado;
		Fecha fecha;
		int dia;
		int mes;
		int anio;
		String nombre;
		double peso;
		TypoActivity actividad;
		int categoria;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre");
		nombre = teclado.next();
		
		System.out.println("Introduzca su dia de nacimiento");
		dia = teclado.nextInt();
		System.out.println("Introduzca su mes de nacimiento");
		mes = teclado.nextInt();
		System.out.println("Introduzca su anho de nacimiento");
		anio = teclado.nextInt();
		fecha = new Fecha(anio, mes, dia);
		
		peso = validarPeso();
		
		categoria = validarCategoria();
		
		return afiliado = new AfiliadoImp(nombre, fecha, peso, categoria);
		
	}
	
		/*
		 * Interfaz
		 * Nombre: validarPeso
		 * Comentario: Este subprograma valida el peso que tiene un afiliado
		 * Cabecera: public double validarPeso()
		 * Precondiciones: No hay
		 * Entrada: No hay
		 * Salida: - double peso //El peso que tiene un afiliado
		 * E/S: No hay
		 * Postcondiciones: Asociado al nombre, El peso que tiene un afiliado
		 */
	 
	  public double validarPeso() {
		  double peso;
		  Scanner teclado = new Scanner(System.in);
		  do {
			  System.out.println("Introduzca su peso (Mayor que 0)");
			  peso = teclado.nextDouble();
		  }
		  while(peso < 1);
		  
		  return peso;
	  }
	  
	  /*
		 * Interfaz
		 * Nombre: validarOpcion
		 * Comentario: Este subprograma valida la opcion a elegir
		 * Cabecera: public int validarOpcion()
		 * Precondiciones: No hay
		 * Entrada: No hay
		 * Salida: - int opcion //La opcion ha elegir
		 * E/S: No hay
		 * Postcondiciones: Asociado al nombre, la opcion corecta
		 */
	 
	  public int validarOpcion() {
		  int opcion;
		  Scanner teclado = new Scanner(System.in);
		  do {
			  System.out.println("Introduzca su opcion (1 - 3)");
			  opcion = teclado.nextInt();
		  }
		  while(opcion < 1 || opcion > 3);
		  
		  return opcion;
	  }
	  
	  /*
			 * Interfaz
			 * Nombre: validarCategoria
			 * Comentario: Este subprograma valida la categoria a elegir
			 * Cabecera: public int validarCategoria()
			 * Precondiciones: No hay
			 * Entrada: No hay
			 * Salida: - int categoria //La categoria ha elegir
			 * E/S: No hay
			 * Postcondiciones: Asociado al nombre, la categoria corecta
			 */
		 
		  public int validarCategoria() {
			  int categoria;
			  Scanner teclado = new Scanner(System.in);
			  do {
				  System.out.println("Introduzca su categoria (1 - 6)");
				  categoria = teclado.nextInt();
			  }
			  while(categoria < 1 || categoria > 6);
			  
			  return categoria;
		  }
		  
			/*
			 * Interfaz
			 * Nombre: validarDuracion
			 * Comentario: Este subprograma valida la duracion que tarda en minutos una actividad
			 * Cabecera: public int validarDuracion()
			 * Precondiciones: No hay
			 * Entrada: No hay
			 * Salida: - double peso //la duracion que tarda en minutos una actividad
			 * E/S: No hay
			 * Postcondiciones: Asociado al nombre, la duracion es correcta
			 */
		 
		  public int validarDuracion() {
			  int duracion;
			  Scanner teclado = new Scanner(System.in);
			  do {
				  System.out.println("Introduzca su validarDuracion (Mayor que 0)");
				  duracion = teclado.nextInt();
			  }
			  while(duracion < 1);
			  
			  return duracion;
		  }
		  
		    /*
			 * Interfaz
			 * Nombre: validarOpcionListado
			 * Comentario: Este subprograma valida la opcion de listados a elegir
			 * Cabecera: public int validarOpcionListado()
			 * Precondiciones: No hay
			 * Entrada: No hay
			 * Salida: - int opcion //La opcion de listados ha elegir
			 * E/S: No hay
			 * Postcondiciones: Asociado al nombre, la opcion de listados corecta
			 */
		 
		  public int validarOpcionListados() {
			  int opcion;
			  Scanner teclado = new Scanner(System.in);
			  do {
				  System.out.println("Introduzca su opcion (1 - 2)");
				  opcion = teclado.nextInt();
			  }
			  while(opcion < 0 || opcion > 2);
			  
			  return opcion;
		  }
		  
		 /*
		 * Interfaz
		 * Nombre: validarActividad
		 * Comentario: Este subprograma valida la actividad que va a realizarse
		 * Cabecera: public TypoActivity validarActividad()
		 * Precondiciones: Opcion es un numero de 1 a 3
		 * Entrada: int opcion //la opcion que va a elegir la actividad
		 * Salida: TypoActividad type //Es la actividad elegidad
		 * E/S: No hay
		 * Postcondiciones: Asociado al nombre, la actividad elegida
		 */
			public TypoActivity validarActividad(int opcion) {
				TypoActivity type = null;
				switch(opcion)  {
				 	case 1:
				 		type = type.LOW;
				 	break;
				 		
				 	case 2:
				 		type = type.MEDIUM;
				 	break;
				 	
				 	case 3:
				 		type = type.HIGH;
				 	break;
				 }
				return type;
			  }
}
