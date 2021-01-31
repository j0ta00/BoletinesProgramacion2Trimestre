package ejercicio6.gestora;

import ejercicio6.carta.Carta;
import ejercicio6.menus.Menu;
import ejercicio6.validaciones.Validaciones;

public class Gestora {
	
	public void partida(){
		boolean plantar=false;
		int respuesta=0;
		Menu.presentacionJuego();
		Carta carta = null;
		do{
			carta=new Carta();
			Menu.menuJuego();
			respuesta = Validaciones.validarRespuesta();
			if(respuesta==1){
				System.out.println(carta.toString());
				System.out.println("Total = "+carta.consultarTotal());
			}
			if(respuesta==2){
				plantar=true;
			}
		}while((!plantar && carta.consultarTotal()<7.5));
		decicidirResultado(plantar,carta);
	}
	
	private void decicidirResultado(boolean plantar,Carta carta){
		if(carta==null) {
			throw new IllegalArgumentException("Error los parámetros introducidos no son válidos");
		}
		if(!plantar){
			if(carta.consultarTotal()==7.5){
				System.out.println("Ha ganado!!!");
			}else{
				System.out.println("Ha perdido!!!");
			}
		}else{
			System.out.println("La siguiente carta habría sido un: ");
			System.out.println(carta.toString());
		}
	}
}
