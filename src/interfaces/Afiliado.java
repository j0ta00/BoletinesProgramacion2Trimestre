package interfaces;

import clases.Fecha;
import enumerados.TypoActivity;
import excepciones.ExcepcionAfiliados;

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
public interface Afiliado {

	 //Code
	  public int getCode();
	  
	  //Surname
	  public String getSurname();
	  
	  //Date
	  public Fecha getDate();
	  
	  //TypeActivity
	  public TypoActivity getTypeActivity();
	  public void setTypeActivity(TypoActivity typeActivity);
	  
	  //duracionActividad
	  public int getDuracionActividad();
	  public void setDuracionActividad(int duracionActividad)throws ExcepcionAfiliados;
	  
	  //Weight
	  public double getWeight ();
	  public void setWeight(double weight)throws ExcepcionAfiliados;
	  
	  //Category
	  public int getCategory();
}
