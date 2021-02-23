package cribaEratostenes;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int numero=0;
		Scanner teclado = new Scanner(System.in);
		while(numero<2 || numero>9999){
			System.out.println("Introduce el número hasta el que cribaremos, recuerda no debe ser menor que 2 ni mayor que 9999");
			numero=teclado.nextInt();
		}
	CribaEratostenes.cribaEratostenes(numero);
	}
}
