package com.clase.maquina;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaquina {

	@Test
	public void ComprarRefrescoSumaConElDineroDeDentro() {
		
		Maquina2 maquina = new Maquina2(50);
		double cantidadIntroducida = 2;
		double cantidadEsperada = 52;
		
		maquina.comprarRefresco(cantidadIntroducida, 4);
		
		if(maquina.getDinero() != cantidadEsperada) {
			fail("Se ha echo mal la resta del dinero de la maquina");
		}
		
	}
	
	@Test
	public void ComprarRefrescoDevolviendoCambios() {
		
		Maquina2 maquina = new Maquina2(70);
		
		double cantidadIntroducida = 20;
		double cantidadEsperada = 18.3; //vuelta de cambios del refresco 3
		maquina.comprarRefresco(cantidadIntroducida, 3);
		if (maquina.getCambio() != cantidadEsperada) {
			fail("Se ha echo mal la devolucion de cambios");
		}
		
		
	}
	@Test
	public void TestToString(){
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

}
