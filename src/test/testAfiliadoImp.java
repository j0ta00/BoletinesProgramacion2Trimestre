package test;

import clases.AfiliadoImp;
import clases.Fecha;
import enumerados.TypoActivity;
import excepciones.ExcepcionAfiliados;

public class testAfiliadoImp {

	public static void main(String[] args) {
		Fecha fecha = new Fecha(1995,6,23);
		TypoActivity act = null;
		AfiliadoImp a1 = new AfiliadoImp();
		AfiliadoImp a2 = new AfiliadoImp("Rafa", fecha, 100.0, 2);
		AfiliadoImp a3 = new AfiliadoImp("Pablo", fecha, 70.0, 1);
		AfiliadoImp a4 = new AfiliadoImp(a2);

		
		//Code
		System.out.println(a1.getCode());
		System.out.println(a2.getCode());
		System.out.println(a3.getCode());
		System.out.println(a4.getCode());
		
		//Surname
		System.out.println(a2.getSurname());
		System.out.println(a3.getSurname());
		
		//Date
		System.out.println(a2.getDate());
		
		//TypeActivity
		System.out.println(a2.getTypeActivity());
		a2.setTypeActivity(act.HIGH);
		System.out.println(a2.getTypeActivity());
		
		System.out.println(a3.getTypeActivity());
		a3.setTypeActivity(act.LOW);
		System.out.println(a3.getTypeActivity());
		
		System.out.println(a3.getDuracionActividad());
		try {
			a3.setDuracionActividad(-3);
		}
		catch(ExcepcionAfiliados err) {
			 System.out.println("ERROR: " + err);
		}
		
		try {
			a3.setDuracionActividad(75);
		}
		catch(ExcepcionAfiliados err) {
			 System.out.println("ERROR: " + err);
		 }
		
		System.out.println(a3.getDuracionActividad());
		
		System.out.println(a2.getDuracionActividad());
		try {
			a2.setDuracionActividad(75);
		}
		catch(ExcepcionAfiliados err) {
			 System.out.println("ERROR: " + err);
		 }
		System.out.println(a2.getDuracionActividad());
		
		//Weight
		System.out.println(a3.getWeight());
		try {
			a3.setWeight(-75.0);
		}
		catch(ExcepcionAfiliados err) {
			 System.out.println("ERROR: " + err);
		}
		
		try {
			a3.setWeight(75.0);
		}
		catch(ExcepcionAfiliados err) {
			 System.out.println("ERROR: " + err);
		}
		
		System.out.println(a3.getWeight());
		
		//Category
		System.out.println(a2.getCategory());
		System.out.println(a3.getCategory());
		
		//toString
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		
		//hashCode
		System.out.println(a2.hashCode());
		System.out.println(a3.hashCode());
		
		//equals
		System.out.println(a2.equals(a4));
		
		//clone
		AfiliadoImp a5 = a3.clone();
		
		System.out.println(a5.equals(a3));
		
		//compareTo
		System.out.println(a2.compareTo(a4));
		System.out.println(a2.compareTo(a1));
		System.out.println(a5.compareTo(a3));
		
		System.out.println(a3.calorimeter());
		System.out.println(a2.calorimeter());
	
	}

}
