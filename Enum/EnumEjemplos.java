package ejemplosEnum;
import ejemplosEnum.Helado;
import ejemplosEnum.Enum.Smartphones;

enum Nota{ SUSPENSO("Ramón",2),SUFICIENTE("Gervasio",5),BIEN("Melania",6),NOTABLE("Isabel",8),SOBRESALIENTE("Jeremías",9);
		
		private String nombreAlumno;
		private int puntuacion;
		
		private Nota(String nombreAlumno, int puntuacion) {
			this.nombreAlumno=nombreAlumno;
			this.puntuacion=puntuacion;
		}
	
		public String getNombreAlumno() {
			return nombreAlumno;
		}
	
		public int getPuntuacion() {
			return puntuacion;
		}
	}
	public class EnumEjemplos {
	
	public static void main(String[] args){
		
		Nota notas = Nota.valueOf("NOTABLE");
		
		//if con enum
		if(notas.getPuntuacion()==5){
			System.out.println("Tienes un suficiente");
		}else if(notas.getPuntuacion()==6){
			System.out.println("Tienes un bien\n");
		}
		
		if(notas==Nota.BIEN){
			
			System.out.println(notas.getNombreAlumno()+" tiene un bien\n");
		}
		
		//switch enum
		switch(notas){
			case SUSPENSO->System.out.println(notas.getNombreAlumno()+" tu nota es un suspenso");
			case SUFICIENTE->System.out.println(notas.getNombreAlumno()+" tu nota es un suficiente");
			case BIEN->System.out.println(notas.getNombreAlumno()+" tu nota es un bien");
			case NOTABLE->System.out.println(notas.getNombreAlumno()+" tu nota es un notable");
			case SOBRESALIENTE->System.out.println(notas.getNombreAlumno()+" tu nota es un sobresaliente");
			default->System.out.println(notas.getNombreAlumno()+" tu nota no esta registrada");
		}
		
		/*
		//for each para recorrer valores e imprimirlos
		for(Nota notasDelAlumnado:Nota.values()){
			
			System.out.println("\n"+notasDelAlumnado.getNombreAlumno()+" tienes un "+notasDelAlumnado.getPuntuacion());
		}
		*/
		
		Smartphones movilJuanJose = Smartphones.XIAOMI;
		Smartphones movilMaria = Smartphones.OPPO;
		Smartphones movilRamon = Smartphones.APPLE;
		Smartphones movilSalomon = Smartphones.SONY;
		Smartphones movilFrumencio = Smartphones.HUAWEI;
		Smartphones movilMariano = Smartphones.SAMSUNG;
		Smartphones movilMatias = Smartphones.APPLE;
		int auxiliar=1, auxiliar2=0;
		
		switch(movilMatias.getCapacidad()){
			case 64->System.out.println("La capacidad de tu m�vil es de 64 Gb"); 
			case 128->System.out.println("La capacidad de tu m�vil es de 128 Gb");
			case 256->System.out.println("La capacidad de tu m�vil es de 256 Gb");
		}
		Sabores sabor =  Sabores.CHOCOLATE;
		Helado helado = new Helado(sabor);
		helado.ConocerPrecioHelado();
		helado.pagarHelado(3);
		/*
		//Orden de los móviles
		System.out.println(movilJuanJose.compareTo(movilMariano));
		System.out.println(movilRamon.compareTo(movilMatias));
		System.out.println(movilSalomon.compareTo(movilRamon)+"\n");
		//Moviles son iguales o no
		System.out.println(movilJuanJose.equals(movilMariano));
		System.out.println(movilRamon.equals(movilMatias)+"\n");
		
		//Que móviles tiene nfc
		Smartphones[] moviles = Smartphones.values();
		for(int i=0;i<moviles.length;i++){
			System.out.println(moviles[i].getModelo());
			if(moviles[i].getNfc()==true){
				System.out.println("-Tiene NFC");
			}else{
				System.out.println("-No Tiene NFC");
			}
		}
		//Móvil más caro
		while(auxiliar<moviles.length){
			
			if(moviles[auxiliar].getPrecio()>moviles[auxiliar2].getPrecio()){
				
				auxiliar2++;
			}else{
				
				auxiliar++;
			}
			
		}
		System.out.println("\nEl móvil más caro es el "+moviles[auxiliar2].getModelo());
		*/	
	}
		 	
}
