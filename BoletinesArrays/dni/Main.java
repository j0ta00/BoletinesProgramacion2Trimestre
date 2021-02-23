package dni;

public class Main {

	public static void main(String[] args) {
			Dni dni = new Dni();
			if(dni.comprobarSiDniValido()){
				System.out.println("Es válido");
			}else{
				System.out.println("Es incorrecto");
			}
	}

}
