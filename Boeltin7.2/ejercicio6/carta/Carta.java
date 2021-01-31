package ejercicio6.carta;

import ejercicio6.enums.Enums;
import ejercicio6.enums.Enums.Palo;
import ejercicio6.enums.Enums.Valor;

public class Carta {
	//Atributos
	private Palo palo;
	private Valor valor;
	private static float sumaTotal=0f;

	//Métodos accesores
	//GETTERS
	public float consultarTotal(){
		return sumaTotal;
	}
	public Palo getPalo() {
		return palo;
	}
	public Valor getValor() {
		return valor;
	}
	//Métodos constructores
	//Constructor por defecto
	public Carta(){
		String NombrePalo=PaloAleatorio();
		String NombreValor=ValorAleatorio();
		palo =  Palo.valueOf(NombrePalo);
		valor = Valor.valueOf(NombreValor);
		sumaTotal=sumaTotal+valor.getValorEnElJuego(); 
	}

	private String ValorAleatorio() {
		int valor = (int)Math.floor(Math.random()*10 + 1);
		String NombreDelValor="";
		switch(valor){
		case 1->NombreDelValor="AS";
		case 2->NombreDelValor="DOS";
		case 3->NombreDelValor="TRES";
		case 4->NombreDelValor="CUATRO";
		case 5->NombreDelValor="CINCO";
		case 6->NombreDelValor="SEIS";
		case 7->NombreDelValor="SIETE";
		case 8->NombreDelValor="SOTA";
		case 9->NombreDelValor="CABALLO";
		case 10->NombreDelValor="REY";
		}
		return NombreDelValor;
	}
	@Override
	public String toString() {
		return valor.name()+" de "+palo.name();
	}
	private String PaloAleatorio(){
		int palo = (int)Math.floor(Math.random()*4 + 1);
		String NombreDelPalo="";
		switch(palo){
		case 1->NombreDelPalo="COPAS";
		case 2->NombreDelPalo="ESPADAS";
		case 3->NombreDelPalo="BASTOS";
		case 4->NombreDelPalo="OROS";
		}
		return NombreDelPalo;
	}
}
