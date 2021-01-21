package principal;

import ejercicio3.Persona;
import ejercicio4.Piratagochi;
import ejercicio5.Hora;

public class Main {

	public static void main(String[] args) {
		Persona juanjo = new Persona();
		Persona Antonio = new Persona("Antonio","López",23,'H');
		juanjo.saludar(Antonio);
		Piratagochi p = new Piratagochi("Ramon");
		p.dormir(12);
		p.jugar(4);
		Hora horaActual = new Hora(14,1,20);
		horaActual.sumarSegundosALaHora(400);
		System.out.println(horaActual.toString());
	}
}
