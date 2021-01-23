package clases;

import enumerados.TypoActivity;
import excepciones.ExcepcionAfiliados;
import interfaces.Afiliado;

/*
 * Tipo AfiliadoImp
 * Propiedades basicas
 * Code
 * Tipo: int
 * Cons: Si
 * Mod: No
 * 
 * Surname
 * Tipo: String
 * Cons: Si
 * Mod: Si
 * 
 * Date
 * Tipo: Fecha
 * Cons: Si
 * Mod: No
 * 
 * TypeActivity
 * Tipo: TypoActivity
 * Cons: Si
 * Mod: Si
 * 
 * Weight
 * Tipo: Double
 * Cons: Si
 * Mod: Si
 * 
 * Category
 * Tipo: int
 * Cons: Si
 * Mod: No
 * 
 * Propiedades derivadas
 * Calorimeter
 * Tipo: double
 * Cons: Si
 * Mod: No
 *
 * 
 * Propiedades compartidas
 * contadorAfiliados
 * Tipo: int
 * Cons: Si
 * Mod: No
 * 
 * Get and Set
 * Code
 * public int getCode()
 * 
 * Surname
 * public String getSurname()
 * 
 * Date
 * public FechaImp getDate()
 * 
 * TypeActivity
 * public TypeActivity getTypeActivity()
 * public void setTypeActivity(TypoActivity typeActivity)
 * 
 * Weight
 * public double getWeight ()
 * public void setWeight(double weight)
 * 
 * Category
 * public int getCategory()
 * 
 * Requisitos:
 * typeActivity es LOW, MEDIUM y HIGH
 * Category es del 1 al 6
 * 
 * Metodos anhadidos
 * public int calorimeter();
 * 
 */
public class AfiliadoImp implements Afiliado, Cloneable, Comparable<AfiliadoImp> {

	//Atributos
	private int code;
	private String surname;
	private Fecha date;
	private TypoActivity typeActivity;
	private int duracionActividad;
	private double weight;
	private int category;
	private static int contadorAfiliados = 1000;
	
	
	//Constructor
	public AfiliadoImp() { //Por Defecto
		code = contadorAfiliados++;
		surname = "NoDefinido";
		date = new Fecha();
		typeActivity = null;
		duracionActividad = 0;
		weight = 0.0;
		category = 0;
	}
	
	
	
	public AfiliadoImp(String surname, Fecha date, TypoActivity typeActivity, int duracionActividad, double weight, int category) { //Con parametros
		code = contadorAfiliados++;
		this.surname = surname;
		this.date = date;
		this.typeActivity = typeActivity;
		this.duracionActividad = duracionActividad;
		this.weight = weight;
		this.category = category;
	}



	public AfiliadoImp(String surname, Fecha date, double weight, int category) { //Con parametros
		code = contadorAfiliados++;
		this.surname = surname;
		this.date = date;
		this.weight = weight;
		this.category = category;
	}



	public AfiliadoImp(AfiliadoImp cop) { //De copia, es otro objeto por eso tiene un code diferente
		code = contadorAfiliados++;
		this.surname = cop.getSurname();
		this.date = cop.getDate();
		this.typeActivity = cop.getTypeActivity();
		this.weight = cop.getWeight();
		this.category = cop.getCategory();
	}

	//Get and Set
	//Code
	public int getCode() {
		return code;
	}
	
	//Surname
	public String getSurname() {
		return surname;
	}
	
	//Date
	public Fecha getDate() {
		return date;
	}
	
	//TypeActivity
	public TypoActivity getTypeActivity() {
		return typeActivity;
	}
	
	public void setTypeActivity(TypoActivity typeActivity) {
		this.typeActivity = typeActivity;
	}
	
	//duracionActividad
	
	public int getDuracionActividad() {
		return duracionActividad;
	}



	public void setDuracionActividad(int duracionActividad) throws ExcepcionAfiliados {
		if(duracionActividad >= 1) {
			this.duracionActividad = duracionActividad;
		}
		else {
			throw new ExcepcionAfiliados("La duracion tiene que ser mayor que 0");
		}
		
	}



	//Weight
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) throws ExcepcionAfiliados{
		if(weight >= 1)  {
			this.weight = weight;
		}
		else {
			throw new ExcepcionAfiliados("El peso tiene que ser mayor que 0");
		}
	}
	
	//Category
	public int getCategory() {
		return category;
	}
	
	//Metodos de la clase object
	//toString
	@Override
	public String toString() {
		return code + ", " + typeActivity;
	}
	
	//hashCode
	@Override
	public int hashCode() {
		return code * surname.hashCode() * 7;
	}
	
	//Equals
	//Criterio de igualdad: Son iguales si tienen el mismo code
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		
		if(this == obj) {
			res = true;
		}
		else if(obj != null && obj instanceof AfiliadoImp) {
			AfiliadoImp otro = (AfiliadoImp) obj;
			
			if(this.code == otro.getCode()) {
				res = true;
			}
		}
		return res;
	}
	
	//clone
	@Override
	public AfiliadoImp clone() {
		AfiliadoImp copia = null;
		
		try {
			copia = (AfiliadoImp) super.clone();
		}
		catch(CloneNotSupportedException err) {
			System.out.println("Objeto no clonado");
		}
		
		return copia;
	}
	
	//compareTo
	//Criterio de comparacion: Por su code
	//-1 Si el primer objeto es menor al segundo
	//0 Si tienen el mismo code
	//1 Si el primer objeto es mayor al segundo
	public int compareTo(AfiliadoImp otro) {
		int comparar = -1;
		
		if(this.code == otro.getCode()) {
			comparar = 0;
		}
		else if(this.code > otro.getCode()) {
			comparar = 1;
		}
		
		return comparar;
	}
	
	//Metodos anhadidos
	//Calorimeter
	public int calorimeter() {
		int resultado;
		if(typeActivity == typeActivity.LOW) {
			resultado = (int) (0.15 * duracionActividad * weight);
		}
		else if(typeActivity == typeActivity.MEDIUM) {
			resultado = (int) (0.25 * duracionActividad * weight);
		}
		else {
			resultado = (int) (0.35 * duracionActividad * weight);
		}
		
		return resultado;
	}
}
