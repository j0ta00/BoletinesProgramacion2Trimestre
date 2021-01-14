package jugadores;

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
}
}
