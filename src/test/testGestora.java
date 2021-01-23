package test;

import clases.AfiliadoImp;
import gestora.gestoraClub;

public class testGestora {

	public static void main(String[] args) {
		AfiliadoImp[] a1 = new AfiliadoImp[8];
		AfiliadoImp[] a2 = new AfiliadoImp[9];
		gestoraClub gestora = new gestoraClub();
		

		a1 = gestora.generarListaAfiliado();
		a2 = gestora.generarListaAfiliado();
		
		
		System.out.println(gestora.listaCompleta(a1));
		System.out.println(gestora.listaCompleta(a2));
	}

}
