package ejercicio6.enums;

public class Enums{
	public enum Palo{COPAS,ESPADAS,BASTOS,OROS}
	public enum Valor{AS(1f),DOS(2f),TRES(3f),CUATRO(4f),CINCO(5f),SEIS(6f),SIETE(7f),SOTA(0.5f),CABALLO(0.5f),REY(0.5f);
		private float valorEnElJuego;
		private Valor(float valorEnElJuego){
			this.valorEnElJuego = valorEnElJuego;
		}
		public float getValorEnElJuego(){
			return valorEnElJuego;
		}
	}
}
