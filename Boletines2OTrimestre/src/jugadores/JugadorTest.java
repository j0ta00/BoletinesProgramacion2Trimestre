package jugadores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

class JugadorTest {
	
private Jugador jugador = new Jugador();
private Jugador jugador2 = new Jugador('P',"Esto es una prueba");
Scanner teclado = new Scanner(System.in);

	@Test
	public void getNombreTest() {
		assertEquals(jugador.getNombre(),"");
		assertEquals(jugador2.getNombre(),"Esto es una prueba");
		assertTrue(jugador2.getNombre()!="");
		assertFalse(jugador.getNombre()=="Esto es una prueba");

	}
	@Test
	public void getFicha() {
		assertEquals(jugador.getFicha(),' ');
		assertEquals(jugador2.getFicha(),'P');
		assertTrue(jugador2.getFicha()!=' ');
		assertFalse(jugador.getFicha()=='P');
	}
	@Test
	public void setNombreTest() {
		jugador2.setNombre("Papa");
		assertFalse(jugador2.getNombre()!="Papa");
		jugador.setNombre("Mama");
		assertFalse(jugador.getNombre()!="Mama");
		jugador.setNombre("");
		assertTrue(jugador.getNombre()=="");
		jugador.setNombre("Esto es una prueba");
		assertTrue(jugador.getNombre()=="Esto es una prueba");
	}
	@Test
	public void setFichaTest() {
		jugador2.setFicha('X');
		assertFalse(jugador2.getFicha()!='X');
		jugador.setFicha('O');
		assertFalse(jugador.getFicha()!='O');
		jugador2.setFicha('P');
		assertTrue(jugador2.getFicha()=='P');
		jugador.setFicha(' ');
		assertTrue(jugador.getFicha()==' ');
	}
	
	@Test
	public void colocarFicha(){
		
		teclado.nextInt(0);
		
		
	}


}
