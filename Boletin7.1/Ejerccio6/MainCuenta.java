package Ejerccio6;

import java.util.Scanner;

public class MainCuenta {
	static Scanner teclado=new Scanner(System.in);
	public static void main(String[] args){
		int respuesta=0,cantidadDeCuentas=0,respuesta2=0,meses=0;
		Cuenta cuenta1=null,cuenta2 = null;
		double dinero=0;
		boolean salir=false;
		do{
			System.out.println("Hola bienvenido al sistema bancario que operación desea hacer:\n 1)Crear cuenta corriente \n 2)Ingresar dinero \n 3)Retirar dinero \n 4)Hacer una transferencia \n 5)Calcular beneficios futuros \n 6)Salir");
			respuesta=teclado.nextInt();
			switch(respuesta){
			case 1->{
				if(cantidadDeCuentas<=0){
					cuenta1=crearCuenta();
					cuenta2=crearCuenta();
					cantidadDeCuentas+=2;
				}
			}
			case 2->{
				if(cantidadDeCuentas>0) {
					do{
						System.out.println("A que cuenta quieres introducirlo a la cuenta 1 o 2");
						respuesta2=teclado.nextInt();
					}while(respuesta2<1 || respuesta2>2);
					System.out.println("Introduce el dinero a ingresar");
					if(respuesta2==1){
						dinero=teclado.nextDouble();
						cuenta1.ingresar(dinero);
					}else if(respuesta2==2){
						dinero=teclado.nextDouble();
						cuenta2.ingresar(dinero);
					}
				}
			}
			case 3->{
				if(cantidadDeCuentas>0) {
					do{
						System.out.println("A que cuenta quieres retirarselo a la cuenta 1 o 2");
						respuesta2=teclado.nextInt();
					}while(respuesta2<1 || respuesta2>2);
					System.out.println("Introduce el dinero a retirar");
					if(respuesta2==1){
						dinero=teclado.nextDouble();
						cuenta1.retirar(dinero);
					}else if(respuesta2==2){
						dinero=teclado.nextDouble();
						cuenta2.retirar(dinero);
					}
				}
			}
			case 4->{if(cantidadDeCuentas>0) {
				do{
					System.out.println("De que cuenta a que cuenta quieres hacer la transferencia de la 1 a la 2(introduce 1) o de la 2 a la 1(introduce 2)");
					respuesta2=teclado.nextInt();
				}while(respuesta2<1 || respuesta2>2);
				System.out.println("Introduce la cantidad de la transferencia");
				if(respuesta2==1){
					dinero=teclado.nextDouble();
					cuenta1.hacerTransferencia(cuenta2, dinero);
				}else if(respuesta2==2){
					dinero=teclado.nextDouble();
					cuenta2.hacerTransferencia(cuenta1, dinero);
				}
			}}
			case 5->{
				if(cantidadDeCuentas>0) {
					do{
						System.out.println("De que cuenta quieres calcular los beneficos de la cuenta 1 o 2");
						respuesta2=teclado.nextInt();
					}while(respuesta2<1 || respuesta2>2);
					System.out.println("Introduce los meses");
					if(respuesta2==1){
						meses=teclado.nextInt();
						cuenta1.beneficiosFuturos(meses);
					}else if(respuesta2==2){
						meses=teclado.nextInt();
						cuenta2.beneficiosFuturos(meses);
					}
				}
			}
			case 6->salir=true;
			default->System.out.println("Opción incorrecta introduce una válida");
			}
		}while(!salir);
	}
	public static Cuenta crearCuenta(){
		int numeroCuenta=0;
		double saldo=0,interesMensual=0;
		String iban="";
		System.out.println("Introduce el IBAN de la cuenta a crear");
		iban=teclado.next();
		System.out.println("Introduce el número de la cuenta a crear");
		numeroCuenta=teclado.nextInt();
		System.out.println("Introduce el número del saldo de esta cuenta");
		saldo=teclado.nextDouble();
		System.out.println("Introduce el interés de esta cuenta");
		interesMensual=teclado.nextDouble();
		Cuenta cuenta = new Cuenta(iban, numeroCuenta, saldo, interesMensual);
		System.out.println("Cuenta creada con éxito");
		return cuenta;
	}

}
