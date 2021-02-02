package ejerccio7;
//CLASE DE ENUMERADORES
/*Debido a que las armas son las mismas y poseen los mismos atributos durante todo el juego lo ideal ha sido usar enumerados*/
public class Enum {
	
	public enum Armas{Talisman("Talisman Luna Oscura",'N',0.2f,2.5f),Uchigatana("Ágil Catana desarrollada en las tierras del este",'A',3.2f,0f),EspadonDelReyCaballero("Espada empuñada por los antiguos caballeros leales a Gwyn",'F',4.4f,0f),EspadonDeLuzDeLuna("Espada extraída de la cola del mismisimo Seath el descamado",'M',1.8f,1.3f),
		LanzaAsesinoDragones("Lanza que pertenecio a Ornstein antiguo caza dragones y fiel caballero de Gwyn",'D',2.1f,1.4f),CatalizadorDeCristal("Catalizador que pertenecio a Logan antiguo maestro hechicero",'N',1f,3f);
		//Atributos de los enumerados
		private String nombre;
		private char tipo;
		private float multiplicadorDanhoFisico;
		private float multiplicadorDanhoMagico;
		//Constructor de los enumerados
		private Armas(String nombre, char tipo, float multiplicadorDañoFisico , float multiplicadorDañoMagico ){
			this.nombre=nombre;
			this.tipo=tipo;
			this.multiplicadorDanhoFisico=multiplicadorDañoFisico;
			this. multiplicadorDanhoMagico=multiplicadorDañoMagico;
		}
		//Métdos accesores de los enumerados
		public String getNombre() {
			return nombre;
		}
		public char getTipo() {
			return tipo;
		}
		public float getMultiplicadorDanhoFisico() {
			return multiplicadorDanhoFisico;
		}

		public float getMultiplicadorDanhoMagico() {
			return multiplicadorDanhoMagico;
		}

	}
	public enum Hechizos{Sanacion("Sana al usuario dependiendo de la fe de este",'C','F',0.9f),EspadaDeCristal("Aumenta el poder de la característica más elevada del personaje",'A','A',0.0f),BolaDeFuego("Lanza una gran bola de fuego",'P','N',21f),
		AzoteDeFuegDelCaos("Arte de las Llamas del Caos, que engulleron a la bruja de Izalith y a sus hijas",'P','N',28f),GranFlechaDeAlma("Dispara una Gran flecha de Alma",'A','I',1.4f),AlientoDeDragon("Antiguo poder de los dragones ancestrales",'A','I',2.1f);
		//Atributos de los enumerados
		private String descripcion;
		private char tipo;
		private char caracteristicaConLaQueEscala;
		private float multiplicadorDanho;
		//Constructor de los enumerados
		private Hechizos(String descripcion, char tipo, char caracteristicaConLaQueEscala,float multiplicadorDanho) {
			this.descripcion=descripcion;
			this.tipo=tipo;
			this.caracteristicaConLaQueEscala=caracteristicaConLaQueEscala;
			this.multiplicadorDanho=multiplicadorDanho;
		}
		//Métdos accesores de los enumerados
		public String getDescripcion() {
			return descripcion;
		}
		public char getTipo() {
			return tipo;
		}
		public char getCaracteristicaConLaQueEscala() {
			return caracteristicaConLaQueEscala;
		}
		public float getMultiplicadorDanho() {
			return multiplicadorDanho;
		}
	}

}
