package ejemplosEnum;

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
	};
	public class Enum {
	
		enum Smartphones{XIAOMI("T10 Pro",536.36f,256,8,true),APPLE("iPhone 12",900,256,6,true),SAMSUNG("Galaxy S20 FE",550,128,6,true),HUAWEI("P40 Lite",229,128,6,true),OPPO("A52",149,128,4,false),SONY("Xperia 5",450,128,6,true);
			
			private String modelo;
			private float precio;
			private int capacidad;
			private int memoriaRam;
			private boolean nfc;
			
			Smartphones(String modelo, float precio, int capacidad, int memoriaRam, boolean nfc){
				this.modelo=modelo;
				this.precio=precio;
				this.capacidad=capacidad;
				this.memoriaRam=memoriaRam;
				this.nfc=nfc;
			}
	
			public String getModelo() {
				return modelo;
			}
	
			public float getPrecio() {
				return precio;
			}
	
			public int getCapacidad() {
				return capacidad;
			}
	
			public int getMemoriaRam() {
				return memoriaRam;
			}
	
			public boolean getNfc() {
				return nfc;
			}
	};
	
	public static void main(String[] args){
		
		Nota notas = Nota.valueOf("BIEN");
		
		//if con enum
		if(notas.getPuntuacion()==5){
			System.out.println("Tienes un suficiente");
		}else if(notas.getPuntuacion()==6){
			System.out.println("Tienes un bien\n");
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
		
		//for each para recorrer valores e imprimirlos
		for(Nota notasDelAlumnado:Nota.values()){
			
			System.out.println("\n"+notasDelAlumnado.getNombreAlumno()+" tienes un "+notasDelAlumnado.getPuntuacion());
		}
		
		Smartphones movilJuanJose = Smartphones.XIAOMI;
		Smartphones movilMaria = Smartphones.OPPO;
		Smartphones movilRamon = Smartphones.APPLE;
		Smartphones movilSalomon = Smartphones.SONY;
		Smartphones movilFrumencio = Smartphones.HUAWEI;
		Smartphones movilMariano = Smartphones.SAMSUNG;
		Smartphones movilMatias = Smartphones.APPLE;
		int auxiliar=1, auxiliar2=0;
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
		
	}
}
