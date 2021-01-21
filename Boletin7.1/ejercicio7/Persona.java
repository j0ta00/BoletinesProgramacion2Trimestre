package ejercicio7;

import java.util.Scanner;

public class Persona{
	static Scanner teclado=new Scanner(System.in);
	//Atributos
	private String nombre;
	private String apellidos;
	private int edad;
	private char sexo;
	private Cuenta cuenta;
	
	//Métodos constructores
	//Constructor por defecto
	public Persona(){
		setNombre("");
		setApellidos("");
		setEdad(0);
		setSexo(' ');
		cuenta=null;
	}
	//Constructor por parámetros
	public Persona(String nombre,String apellidos,int edad,char sexo){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.sexo=sexo;
		cuenta=null;
	}
	//Métodos fundamentales
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getEdad() {
		return edad;
	}
	public char getSexo() {
		return sexo;
	}
	//Setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	//Métodos delegados la clase cuenta se encarga de ellos
	public String getIban() {
		return cuenta.getIban();
	}
	public int getNumeroCuenta() {
		return cuenta.getNumeroCuenta();
	}
	public double getSaldo() {
		return cuenta.getSaldo();
	}
	public double getInteresMensual() {
		return cuenta.getInteresMensual();
	}
	public boolean getDescubierta() {
		return cuenta.getDescubierta();
	}
	public void setIban(String iban) {
		cuenta.setIban(iban);
	}
	public void setNumeroCuenta(int numeroCuenta) {
		cuenta.setNumeroCuenta(numeroCuenta);
	}
	public void setSaldo(double saldo) {
		cuenta.setSaldo(saldo);
	}
	public void setInteresMensual(double interesMensual) {
		cuenta.setInteresMensual(interesMensual);
	}
	public String toString() {
		return cuenta.toString();
	}
	public void ingresar(double dinero) {
		cuenta.ingresar(dinero);
	}
	public boolean retirar(double dinero) {
		return cuenta.retirar(dinero);
	}
	public boolean hacerTransferencia(Persona persona, double cantidad) {
		return cuenta.hacerTransferencia(persona.cuenta, cantidad);
	}
	public double beneficiosFuturos(int numMeses) {
		return cuenta.beneficiosFuturos(numMeses);
	}
	public void imprimirSaldo(double dinero) {
		cuenta.imprimirSaldo(dinero);
	}
	//Métodos adicionales/añadidos
	public void saludar(Persona persona){
		System.out.println("¡Hola "+persona.getNombre()+" !");
		System.out.println("¡Hola "+getNombre()+" ! que pasa, ¿cómo estás?");
	}
	
	public void crearCuenta(){
		if(cuenta==null){
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
			cuenta = new Cuenta(iban, numeroCuenta, saldo, interesMensual);
			System.out.println("Cuenta creada con éxito");
		}
	}
	public void cerrarCuenta(){
		if(cuenta!=null){
			cuenta=null;
			System.out.println("Cuenta cerra");
		}
	}
}


