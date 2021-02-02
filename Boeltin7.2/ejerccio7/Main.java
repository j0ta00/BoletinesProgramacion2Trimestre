package ejerccio7;

import ejerccio7.Enum.Armas;

public class Main {

	public static void main(String[] args) {
		Clerigo clerigo1 = new Clerigo();
		Clerigo clerigo2 =new Clerigo();
		clerigo2.setArma(Armas.LanzaAsesinoDragones);
		while(clerigo1.getVivo()){
			System.out.println(clerigo1.getVida());
			clerigo1.recibirDanho(clerigo2.atacarCuerpoACuerpo());
		}
		Menu.ataqueRealizado(clerigo1, clerigo2);
		
	}

}
