package ejerccio7;

import ejerccio7.Enum.Armas;

public class Gestora {
	
	public void combateEntreDosPersonajes(){
		
		Clerigo clerigo1 = new Clerigo();
		Clerigo clerigo2 =new Clerigo();
		clerigo2.setArma(Armas.LanzaAsesinoDragones);
		System.out.println(clerigo1.getVida());
		clerigo1.recibirDanho(clerigo2.atacarCuerpoACuerpo());
		System.out.println(clerigo1.getVida());
	}

}
