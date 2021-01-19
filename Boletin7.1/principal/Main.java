package principal;

import ejercicio3.Persona;
import ejercicio4.Piratagochi;

public class Main {

	public static void main(String[] args) {
		Persona juanjo = new Persona();
		Persona Antonio = new Persona("Antonio","López",23,'H');
		juanjo.saludar(Antonio);
		Piratagochi p = new Piratagochi("Ramon");
		p.dormir(12);
		p.jugar(4);
	}
}
