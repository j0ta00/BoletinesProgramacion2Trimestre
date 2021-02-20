/**
 * @author jjmza<br>
 * <p>
 * Nombre de la clase:CribaEratostenes<br>
 * Proposito: Se trata de una clase est�tica compuesta por varios m�todos relacionados con la criba de Erat�stenes y funcionalidades con
 * n�meros primos<br>
 * Propiedades:Ninguna se trata de una clase de utilidad que posee el m�todo de la criba de eratostenes<br>
 * M�todos Accesores:Carece de estos<br>
 * M�todos Adicionales:
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
	public static void main(String[] args) {
		cribaEratostenes(30);
	}
	/**
	 * @author jjmza<br>
	 * Cabecera:private static void imprimirEratostenes(int[] array)<br>
	 * Proposito:Se trata de un m�todo que imprime un array de n�meros<br>
	 * Precondici�n:El array que se le pasa por par�metros no debe contener nulos<br>
	 * Postcondici�n:Se trata de un procedimiento que solamente imprime por pantalla<br>
	 *  @parama int[] array
	 *  @return Nada, solamente imprime
	 *  
	 */
	private static void imprimirEratostenes(int[] array){
		System.out.print("La lista de n�meros primos tras el cribado es: ");
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
	 * Proposito:Se trata de un m�todo que llena un array de n�meros consecutivos<br>
	 * Precondici�n:El n�mero pasado por par�metros debe ser positivo y mayor o igual que 2<br>
	 * Postcondici�n:Se trata de una funci�n que llena un array de n�meros consecutivos, tantos como le hayamos 
	 * indicado por par�metros<br>
	 *  @parama int numero
	 *  @return int[] array lleno de n�meros consecutivos
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
	 * Proposito:Se trata de un m�todo que realiza el proceso de cribado de eratostenes para
	 * conseguir los numeros primos desde 2 hasta int numero<br>
	 * Precondici�n:El n�mero pasado por par�metros debe ser positivo y mayor o igual que 2<br>
	 * Postcondici�n:Se trata de un procedimiento que realiza la criba de eratostenes a una colecci�n de
	 * enteros<br>
	 *  @parama int numeros
	 *  @return Nada solamente realiza el proceso de cribado y llama a otros m�todos auxiliares privados
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