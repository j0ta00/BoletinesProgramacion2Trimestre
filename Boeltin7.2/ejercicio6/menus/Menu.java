package ejercicio6.menus;

public class Menu{
	public static void menuJuego(){
		System.out.println("*****************");
		System.out.println("1 - Nueva Carta");
		System.out.println("2 - Me planto");
		System.out.println("*****************");
		System.out.print("�Qu� opci�n desea realizar?:");
	}
	public static void presentacionJuego(){
		System.out.println("Bienvenido al juego de las 7 y media");
		System.out.println("Tu objetivo es intentar acercarte lo m�ximo posible al valor 7.5 sin pasarte");
		System.out.println("Se te dara una carta por turno y debes evitar pasarte de dicho valor, podr�s plantarte en cualquier momento");
	}
}