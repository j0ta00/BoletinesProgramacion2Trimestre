package dni;

public class Main {

	public static void main(String[] args) {
			Dni dni = new Dni();
			if(dni.comprobarSiDniValido()){
				System.out.println("Es v�lido");
			}else{
				System.out.println("Es incorrecto");
			}
	}

}
