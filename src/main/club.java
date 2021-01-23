package main;

import clases.AfiliadoImp;
import enumerados.TypoActivity;
import excepciones.ExcepcionAfiliados;
import gestora.gestoraClub;
import menus.menuClub;
import resguardos.resguardosClub;
import validaciones.validarClub;

/*
 * Nombre del programa: Club
 * Comentario: Este programa gestiona un club de deporte
 * 
 * Analisis
 * Entrada: - Opcion //Es la opcion de la lista de mostra
 * Salida: - Listado con aquellos de la misma actividad
 * 		   - Listado con cuantos de ellos han participado en esa actividad
 * 		   - Mensajes con el usuario
 * Requisitos:
 * 
 * PG level 0
 * Inicio
 * 	Repetir
 * 		IntroducirAfiliado
 * 		IntroducirActividad
 * 		IntroducirDuracionActividad
 * 	Mientras haya afiliados que anhadir
 * 	mostrarMenu
 * 	segun(opcion)
 * 		caso 1:
 * 			ListaMismaActividad
 * 		caso 2:
 * 			CuantasPersonasActividad
 * 	FinSegun
 * Fin
 */
public class club {

	public static void main(String[] args) {
		AfiliadoImp[] afiliados = new AfiliadoImp[10];
		resguardosClub resguardos = new resguardosClub();
		gestoraClub gestora = new gestoraClub();
		AfiliadoImp afiliado = new AfiliadoImp();
		menuClub menus = new menuClub();
		validarClub validar = new validarClub();
		int opcion;
		int opcionListado;
		int duracion;
		TypoActivity type = null;
		afiliados = gestora.generarListaAfiliado();
		do {
			//afiliados = resguardos.generarListaAfiliado();
			System.out.println("Bienvenido al club");
			
			//IntroducirAfiliado
			afiliado = validar.validarAfilado();
			
			
			//IntroducirActividad
			 menus.menuTipoActividad();
			 opcion = validar.validarOpcion();
			 type = validar.validarActividad(opcion);
			 afiliado.setTypeActivity(type);
			 
			 //IntroducirDuracionActividad
			 duracion = validar.validarDuracion();
			 try {
				 afiliado.setDuracionActividad(duracion);
			 }
			 catch(ExcepcionAfiliados err) {
				 System.out.println("ERROR: " + err);
			 }
			 
			 
			 //resguardos.introducirAfiliados(afiliado);
			 gestora.introducirAfiliado(afiliado, afiliados);
		}
		while(gestora.listaCompleta(afiliados) == false);

		do {
			menus.menuListados();
			opcionListado = validar.validarOpcionListados();
			
			switch(opcionListado) {
				case 1:
					menus.menuTipoActividad();
					opcion = validar.validarOpcion();
					type = validar.validarActividad(opcion);
					/*
					switch(opcion)  {
					 	case 1:
					 		type = type.LOW;
					 	break;
					 		
					 	case 2:
					 		type = type.MEDIUM;
					 	break;
					 	
					 	case 3:
					 		type =type.HIGH;
					 	break;
					 }
					 */
					//resguardos.ListaMismaActividad(afiliados, type);
					gestora.ListaMismaActividad(afiliados, type);
				break;
				
				case 2:
					menus.menuTipoActividad();
					opcion = validar.validarOpcion();
					type = validar.validarActividad(opcion);
					/*
					switch(opcion)  {
					 	case 1:
					 		type = type.LOW;
					 	break;
					 		
					 	case 2:
					 		type = type.MEDIUM;
					 	break;
					 	
					 	case 3:
					 		type =type.HIGH;
					 	break;
					 }
					 */
					//System.out.println(resguardos.CuantasPersonasActividad(afiliados, type));
					System.out.println(gestora.CuantasPersonasActividad(afiliados, type));
				break;
			}
			
		}
		while(opcionListado != 0);
		
	}

}
