package ejercicio7;
import java.util.Scanner;
public class Cuenta {
	//Atributos
	private String iban;
	private int numeroCuenta;
	private double saldo;
	private double interesMensual;
	//Métodos constructores
	//Constructor por parámtros
	public Cuenta(String iban, int numeroCuenta, double saldo,double interesMensual) {
		this.iban = iban;
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.interesMensual = interesMensual;
	}
	//Métodos fundamentales
	//Getters
	public String getIban() {
		return iban;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public double getInteresMensual() {
		return interesMensual;
	}
	public boolean getDescubierta(){
		boolean descubierta=false;
		if(saldo<0){
			descubierta=true;
		}
		return descubierta;
	}
	//Setters
	public void setIban(String iban) {
		this.iban = iban;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setInteresMensual(double interesMensual) {
		this.interesMensual = interesMensual;
	}
	//Métodos añadidos
	@Override
	public String toString(){
		
		return iban+","+numeroCuenta+","+saldo+","+interesMensual;
	}
	public void ingresar(double dinero){
		saldo+=dinero;
		imprimirSaldo(0);
	}
	public boolean retirar(double dinero){
		boolean dineroRetirado=false;
		if(!getDescubierta()){
		dineroRetirado=true;
		saldo-=dinero;
		}
		imprimirSaldo(0);
		return dineroRetirado;
	}
	public boolean hacerTransferencia(Cuenta c, double cantidad){
		boolean transferenciaRealizada=false;
		if(!getDescubierta()){
			c.saldo+=cantidad;
			saldo-=cantidad;
			transferenciaRealizada=true;
		}
		imprimirSaldo(0);
		return transferenciaRealizada;
	}
	public double beneficiosFuturos(int numMeses){
		double dinero=0;
		if(!getDescubierta() && numMeses>0) {
			 dinero=saldo*interesMensual/100;
		}
		imprimirSaldo(dinero);
		return dinero;
	}
	public void imprimirSaldo(double dinero){
		if(dinero!=0){
		System.out.println("Tu saldo tras esos meses será de "+(dinero+=saldo));
		}else{
		System.out.println("Tu saldo tras la operación actual es de"+saldo);
		}
	}
	public void crearCuenta(){
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
	}
}
