package ejercicio3;

public class Persona{
	//Atributos
	private String nombre;
	private String apellidos;
	private int edad;
	private char sexo;
	
	//M�todos constructores
	//Constructor por defecto
	public Persona(){
		setNombre("");
		setApellidos("");
		setEdad(0);
		setSexo(' ');
	}
	//Constructor por par�metros
	public Persona(String nombre,String apellidos,int edad,char sexo){
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.sexo=sexo;
	}
	//M�todos fundamentales
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
	//M�todos adicionales
	public void saludar(Persona persona){
		System.out.println("�Hola "+persona.getNombre()+" !");
		System.out.println("�Hola "+getNombre()+" ! que pasa, �c�mo est�s?");
	}
}


