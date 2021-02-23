package cribaEratostenes;
/**
 * @author jjmza<br>
 * <p>
 * Nombre de la clase:CribaEratostenes<br>
 * Proposito: Se trata de una clase estática compuesta por varios métodos relacionados con la criba de Eratóstenes y funcionalidades con
 * números primos<br>
 * Propiedades:Ninguna se trata de una clase de utilidad que posee el método de la criba de eratostenes<br>
 * Métodos Accesores:Carece de estos<br>
 * Métodos Adicionales:
 * </p>
 * 	<table>
* 		<tr> 
* 			<td>-imprimirEratostenes(int[] array)</td>
* 		</tr>
* 		<tr>
* 			<td>-llenarArrayDeNumerosConsecutivos(int numero)</td>
* 		</tr>
* 		<tr>
* 			<td>-cribaEratostenes(int numero)</td>
*		</tr>
*	</table> 
 * */
public class CribaEratostenes{
	/**
	 * @author jjmza<br>
	 * Cabecera:private static void imprimirEratostenes(int[] array)<br>
	 * Proposito:Se trata de un método que imprime un array de números<br>
	 * Precondición:El array que se le pasa por parámetros no debe contener nulos<br>
	 * Postcondición:Se trata de un procedimiento que solamente imprime por pantalla<br>
	 *  @parama int[] array
	 *  @return Nada, solamente imprime
	 *  
	 */
	private static void imprimirEratostenes(int[] array){
		System.out.print("La lista de números primos tras el cribado es: ");
		for(int i:array){
			if(i!=0){
			System.out.print(" "+i+" ");	
			}
		}
	}
	/**
	 * @author jjmza<br>
	 * 
	 * Cabecera:private static int[] llenarArrayDeNumerosConsecutivos(int numeros)<br>
	 * Proposito:Se trata de un método que llena un array de números consecutivos<br>
	 * Precondición:El número pasado por parámetros debe ser positivo y mayor o igual que 2<br>
	 * Postcondición:Se trata de una función que llena un array de números consecutivos, tantos como le hayamos 
	 * indicado por parámetros<br>
	 *  @parama int numero
	 *  @return int[] array lleno de números consecutivos
	 *  
	 */
	private static int[] llenarArrayDeNumerosConsecutivos(int numero){
		int[] array= new int[numero-1];
		for(int i=0,auxiliar=2;i<array.length;i++){
			array[i]=i+auxiliar;
		}
		return array;
	}
	/**
	 * @author jjmza<br>
	 * Cabecera:public static void cribaEratostenes(int numero)<br>
	 * Proposito:Se trata de un método que realiza el proceso de cribado de eratostenes para
	 * conseguir los numeros primos desde 2 hasta int numero<br>
	 * Precondición:El número pasado por parámetros debe ser positivo y mayor o igual que 2<br>
	 * Postcondición:Se trata de un procedimiento que realiza la criba de eratostenes a una colección de
	 * enteros<br>
	 *  @parama int numeros
	 *  @return Nada solamente realiza el proceso de cribado y llama a otros métodos auxiliares privados
	 *  
	 */
	public static void cribaEratostenes(int numero){
		if(numero>=2){
			int[] array=llenarArrayDeNumerosConsecutivos(numero);
			for(int i=0;i<array.length && Math.pow(i, 2)<numero;i++){
				if(array[i]!=0){
					for(int j=i+1;j<array.length;j++){
						if(array[j]%array[i]==0 && array[j]!=0){
							array[j]=0;
						}
					}
				}	
			}
			imprimirEratostenes(array);
		}
	}
}
