package com.clase.maquina;

public class Maquina2 {
	/**
	 * Clase que representa la maquina que contiene refrescos que estos
	 * mismos estaran guardados dentro de un array
	 * 
	 * @author Alexander Lara
	 * @since 29/10/2021
	 */
	private Refresco[] refrescos;
	private double dinero;
	private double cambio;
	
	//constructor
	public Maquina2(double dinero) {
		this.dinero = dinero;
		refrescos = new Refresco[5];
		refrescos[0] = new Refresco("Coca Cola", 1.2, 20);
		refrescos[1] = new Refresco("Fanta de naranja", 0.8, 15);
		refrescos[2] = new Refresco("Agua mineral", 1.3, 12);
		refrescos[3] = new Refresco("Nesti", 1.7, 72);
		refrescos[4] = new Refresco("Redbull", 2.0, 17);
		
	}
	//getters y setters	
	public double getDinero() {
		return dinero;
	}

	public void setDinero(double dinero) {
		this.dinero = dinero;
	}

	public double getCambio() {
		return cambio;
	}

	public Refresco[] getRefresco(){
		return refrescos;
	}
	
	
	//informe de cantidad de refrescos y la cantidad de dinero 
	@Override
	public String toString() {
		String montador = "";
		for (int i = 0; i < refrescos.length; i++) {
			montador = montador + "Maquina [cantidad del refresco " +refrescos[i].getTipo()+ " = " + refrescos[i].getCantidad() + ", dinero dentro de la maquina=" + dinero + "] \n";
		}
		return montador;
	}

	
	
	public String informeRefrescosVendidos() {
		String montador="";
		for(int i = 0; i < refrescos.length; i++) {
			montador = montador + "Informe de ventas " + refrescos[i].getTipo() + "---> Cantidad vendida: " + refrescos[i].getRefrescosVendidos() + ", dinero ganado: " + (refrescos[i].getRefrescosVendidos() * refrescos[i].getPrecio()) + " \n";
		}
		//return "Informe de ventas " + refrescos[3].getTipo() + "---> Cantidad vendida: " + refrescos[3].getRefrescosVendidos() + ", dinero ganado: " + (refrescos[3].getRefrescosVendidos() * refrescos[3].getPrecio()) + " /n";
		return montador;
	}

	
	public void comprarRefresco(double dineroIntroducido, int posicion) {
	
		if(posicion >= 0 && posicion < refrescos.length) {
			
			if (tieneRefresco(posicion)) {
				
				if(conCambiosSuficiente(dineroIntroducido,posicion)) {
						
					cambio = dineroIntroducido - refrescos[posicion].getPrecio();			
					refrescos[posicion].setCantidad(refrescos[posicion].getCantidad() - 1);
					setDinero(getDinero() + refrescos[posicion].getPrecio());
					refrescos[posicion].setRefrescosVendidos(refrescos[posicion].getRefrescosVendidos() + 1);
					
					System.out.println("Has comprado el refresco " +  refrescos[posicion].getTipo() +" , vuelva otra vez");
					
					if(cambio != 0) {
						System.out.println("Tome su cambio " + cambio);
					}
					
				}
				
			}
		}else {
			System.out.println("No has introducido bien la posicion del refresco");
		}
				
		
	}
	
	//validaciones
	public boolean tieneRefresco(int posicion) {
		
		if(refrescos[posicion].getCantidad()<=0) {
			System.out.println("MAQUINA SIN REFRESCOS");
			return false;
		}else {
			return true;
		}
	}
	
	public boolean conCambiosSuficiente(double entradaDinero, int posicion) {
		if(getDinero() - entradaDinero <= 0) {
			System.out.println("MAQUINA SIN DINERO");
			return false;
		}else if (entradaDinero < refrescos[posicion].getPrecio()){
			System.out.println("NO HAS METIDO DINERO SUFICIENTE");
			return false;
		}else {
			return true;
		}
		
		
	}
	
	//menu
	
	public void menu() {
		
		System.out.println("Seleccione uno de los refrescos");
		for (int i = 0; i < refrescos.length; i++) {
			System.out.println(1 + i + "- " + refrescos[i].getTipo());
		}
		System.out.println("*****");
		System.out.println("98- Informe maquina");
		System.out.println("99- Informe refrescos");
		
		
	}
	
}
