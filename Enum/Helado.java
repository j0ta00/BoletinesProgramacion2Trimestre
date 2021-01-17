package ejemplosEnum;

enum Sabores{CHOCOLATE(2),CHOCOMENTA(2.10),VAINILLA(1.90),CARAMELO(2.20);
	
	private double precio;
	
	private Sabores(double precio){
	
		this.precio=precio;
	}
	public double getPrecio() {
		return precio;
	}
}


public class Helado{
	
	Sabores sabor;
	
	
	public Helado(Sabores sabor){
		this.sabor=sabor;
	}
	
	public void ConocerPrecioHelado(){
		System.out.println("Ese helado vale "+sabor.getPrecio());
	}
	
	public void pagarHelado(int dinero){
		if(dinero>=sabor.getPrecio()){
			System.out.println("Aquí tiene su helado gracias por la compra");
		}else{
			System.out.println("Vaya parece que no tienes suficiente dinero, lo siento pero no fiamos :(");
		} 		
	}
	
}
