package ejercicio5;

public class Hora{
	//Atributos
	private int horas;
	private int minutos;
	private int segundos;
	//Métodos Constructores
	//Constructor por defecto
	public Hora(int horas, int minutos, int segundos) {
		this.horas = horas;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	//Métodos fudamentales
	//Getters
	public int getHoras(){
		return horas;
	}
	public int getMinutos(){
		return minutos;
	}
	public int getSegundos(){
		return segundos;
	}
	//Setters
	public void setHoras(int horas){
		if(horas>23){
			horas=0;
		}else{
			this.horas = horas;
		}
	}
	public void setMinutos(int minutos){
		while(minutos>60){
			minutos-=60;
			setHoras(horas+1);
		}
		this.minutos = minutos;
	}
	public void setSegundos(int segundos){
		while(segundos>60){
			segundos-=60;
			setMinutos(minutos+1);
		}
		this.segundos=segundos;
	}
	//Métodos añadidos
	public void sumarSegundosALaHora(int segundosASumar){
		setSegundos(segundos+=segundosASumar);
	}
	@Override
	public String toString(){
		String toMinutos=""+minutos,toSegundos=""+segundos,toHoras=""+horas;
		if(minutos<10){
		toMinutos="0"+minutos;
		}
		if(segundos<10){
			toSegundos="0"+segundos;
		}
		if(horas<10){
			toHoras="0"+horas;
		}
		return toHoras+":"+toMinutos+":"+toSegundos;
	}
}
