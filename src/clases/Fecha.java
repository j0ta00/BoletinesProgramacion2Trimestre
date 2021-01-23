/* Nombre de la clase: Fecha
 * 
 * propiedades basicas
 * 
 * 			dia: tipo entero,consultable, modificable
 * 			mes: tipo entero,consultable, modificable
 * 			anio: tipo entero,consultable, modificable
 * 
 * propiedades compartidas: no hay
 * 
 * propiedades derivadas: no hay
 * 
 * 
 * INTERFAZ
 * 
 * getters y setters
 * 
 * int getDia()
 * void setDia(int dia)
 * 
 * int getMes()
 * void setMes(int mes)
 * 
 * int getAnio()
 * void setAnio(int anio)
 * 
 * Restricciones: anio>1851
 * 
 * metodos añadidos:
 * 
 * 		esBisiesto()
 * 		validarFecha()
 */
package clases;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.ExcepcionFecha;

public class Fecha implements Cloneable,Comparable <Fecha>
{
	private int dia;
	private int mes;
	private int anio;
	
	//constructores
	//por defecto
	public Fecha() 
	{
		anio=0;
		mes=0;
		dia=0;
	}
	
	//con parametros
	public Fecha(int anio,int mes,int dia) 
	{
		this.anio=anio;
		this.mes=mes;
		this.dia=dia;
	}
	
	//de copia
	public Fecha(Fecha fecha) 
	{
		this.anio=fecha.anio;
		this.mes=fecha.mes;
		this.dia=fecha.dia;
	}

	//getters y setters
	public int getDia()
	{
		return dia;
	}

	public void setDia(int dia)
	{
		this.dia = dia;
	}

	public int getMes() 
	{
		return mes;
	}

	public void setMes(int mes)
	{
		this.mes = mes;
	}

	public int getAnio()
	{
		return anio;
	}

	public void setAnio(int anio)
	{
		this.anio = anio;
	}
	
	@Override
	public String toString() 
	{
		return (anio+", "+mes+", "+dia);
	}
	
	@Override
	public int hashCode() 
	{
		return(((anio+mes+dia)*1991)/1000);
	}
	
	@Override
	public Fecha clone() 
	{
		Fecha clon=null;
		
		try 
		{
			clon=(Fecha)super.clone();
		}catch(CloneNotSupportedException err) 
		{
			System.out.println("No se ha clonado");
		}
		return clon;
	}
	
	
	//criterio de igualdad: anio,mes y dia
	@Override
	public boolean equals(Object o) 
	{
		boolean res=false;
		
		if(this==o) 
		{
			res=true;
		}else 
		{
			if(o!=null && o instanceof Fecha) 
			{
				Fecha f=(Fecha) o;
				
				if(this.getAnio()==f.getAnio() && this.getMes()==f.getMes() 
				   && this.getDia()==f.getDia()) 
				{
					res=true;
				}
			}
		}
		return res;
	}
	
	
	//criterio de igualdad: 
				
				//devuelve 1 si el primero es mayor 
				//devuelve -1 si el primero es menor
				//devuelve 0 si son iguales
	@Override
	public int compareTo(Fecha f)
	{
		int res=0;
		
		if((this.getAnio()>f.getAnio()) || (this.getAnio()==f.getAnio() && this.getMes()>f.getMes()) || 
		   (this.getAnio()==f.getAnio() && this.getMes()==f.getMes() && this.getDia()>f.getDia())) 
		{
			res=1;
		}
		else
		{
			if((this.getAnio()<f.getAnio()) || (this.getAnio()==f.getAnio() && this.getMes()<f.getMes()) || 
					   (this.getAnio()==f.getAnio() && this.getMes()==f.getMes() && this.getDia()<f.getDia())) 
			{
				res=(-1);
			}
		}
		
		return res;
	}
	
	/*
		prototipo: public boolean esBisiesto()
		comentarios: metodo para averiguar si el año es bisiesto o no
		precondiciones: no hay
		entradas: no hay
		salidas: un logico
		entr/sal: no hay
		postcondiciones: AN devolvera true si es bisiesto y false si no 
	*/
	
//	 public boolean esBisiesto() 
//	 {
//		 boolean res=false;
//		 System.out.println("En resguardo");
//		 return res;
//	 }
	
	public boolean esBisiesto() 
	{
		 boolean res=false;
		 
		 if ((this.getAnio()>1581) && (this.getAnio() % 400 == 0) || 
					((this.getAnio() % 4 == 0) && (this.getAnio() % 100 != 0)))
		 {
			if (this.getDia () > 0 && this.getDia () < 30)
			{
				res = true;
			}
		 }
		
		 return res;
	}

}
