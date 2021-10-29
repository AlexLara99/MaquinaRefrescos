package com.clase.maquina;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaquina {

	@Test
	public void testComprarRefrescoSumaConElDineroDeDentro() {
		
		Maquina2 maquina = new Maquina2(50);
		double cantidadIntroducida = 2;
		double cantidadEsperada = 52;
		
		maquina.comprarRefresco(cantidadIntroducida, 4);
		
		if(maquina.getDinero() != cantidadEsperada) {
			fail("Se ha echo mal la resta del dinero de la maquina");
		}
		
	}
	
	@Test
	public void testComprarRefrescoDevolviendoCambios() {
		
		Maquina2 maquina = new Maquina2(70);
		
		double cantidadIntroducida = 20;
		double cantidadEsperada = 18.3; //vuelta de cambios del refresco 3
		maquina.comprarRefresco(cantidadIntroducida, 3);
		if (maquina.getCambio() != cantidadEsperada) {
			fail("Se ha echo mal la devolucion de cambios");
		}
		
		
	}
	@Test
	public void testToString(){
		Maquina2 maquina = new Maquina2(70);
		System.out.println(maquina.toString());
	}
	
	@Test
	public void testVenderSinStock() {
		Maquina2 maquina = new Maquina2(500);
		for(int i = 0; i< 17; i++) {
			maquina.comprarRefresco(2, 4);
		}
		
		if(maquina.tieneRefresco(4)) {
			fail("Se ha echo mal la maquina tema cantidad de refrescos");
		}
		
	}
	@Test
	public void testInformeDeUnRefresco() {
		
		Maquina2 maquina = new Maquina2(500);
		maquina.comprarRefresco(13, 2);
		System.out.println(maquina.informeRefrescosVendidos());
		
		if(maquina.getDinero() == 500) {
			fail("Se ha generado mal el informe");
		}
		
		
	}
	
	@Test 
	public void testVenderRefrescoSinDineroEnMaquina() {
		System.out.println("Prueba deposito dinero");
		double dineroIntroducido = 13;
		double dineroMaquina = 0.5;
		Maquina2 maquina = new Maquina2(dineroMaquina);
		maquina.comprarRefresco(dineroIntroducido, 2);
		if(maquina.getDinero() != dineroMaquina) {
			fail("Se ha producido un error con el dinero del deposito");
		}
		
	}
	
	@Test
	public void testComprarRefrescoConInsuficienteDinero() {
		
		double dineroIntroducido = 0.1;
		Maquina2 maquina = new Maquina2(100);
		
		if(maquina.conCambiosSuficiente(dineroIntroducido, 0) != false)
		{
			fail("Se ha producido un error con el dinero del deposito");
		}	
		
	}
	
	@Test
	public void tesQuePasaSiPasoUnaPosicionNoExistente() {
		int position = -1;
		Maquina2 maquina = new Maquina2(100);
		try {
			maquina.comprarRefresco(1, position);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			
			fail("Se ha producido un error con la posicion");
		}
	}

}
