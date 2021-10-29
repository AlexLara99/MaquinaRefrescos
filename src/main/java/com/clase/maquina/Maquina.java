package com.clase.maquina;

public class Maquina {
	/**
	 * Esta clase esta anticuada, mejor version en
	 * @deprecated@Maquina2
	 */
	private Refresco refresco;
	private double dinero;
	private double cambio;
	
	// version anterior de 1 refresco
	public Maquina(double dinero) {
		this.dinero = dinero;
		refresco = new Refresco("Coca cola", 1.20, 50);
		
	}
		
	public double getDinero() {
		return dinero;
	}



	public void setDinero(double dinero) {
		this.dinero = dinero;
	}


	//informe de cantidad de refrescos y la cantidad de dinero 
	@Override
	public String toString() {
		return "Maquina [cantidad de refrescos=" + refresco.getCantidad() + ", dinero=" + dinero + "]";
	}

	public String informeRefrescosVendidos() {
		return "Informe de ventas---> Cantidad vendida: " + refresco.getRefrescosVendidos() + ", dinero ganado: " + (refresco.getRefrescosVendidos() * refresco.getPrecio());
	}

	public void comprarRefresco(double dineroIntroducido) {
		
		
		if (!sinRefresco()) {
			if(!sinCambiosInsuficiente(dineroIntroducido)) {
				
				
				cambio = dineroIntroducido - refresco.getPrecio();
				refresco.setCantidad(refresco.getCantidad() - 1);
				setDinero(getDinero() + refresco.getPrecio());
				refresco.setRefrescosVendidos(refresco.getRefrescosVendidos() + 1);
				System.out.println("Has comprado un refresco, vuelva otra vez");
				if(cambio != 0) {
					System.out.println("Tome su cambio " + cambio);
				}
				
			}
			
		}	
		
	}
	
	
	public boolean sinRefresco() {
		
		if(refresco.getCantidad()<=0) {
			System.out.println("MAQUINA SIN REFRESCOS");
			return true;
		}else {
			return false;
		}
	}
	
	public boolean sinCambiosInsuficiente(double entradaDinero) {
		if(getDinero() - entradaDinero <= 0) {
			System.out.println("MAQUINA SIN DINERO");
			return true;
		}else if (entradaDinero < refresco.getPrecio()){
			System.out.println("NO HAS METIDO DINERO SUFICIENTE");
			return true;
		}else {
			return false;
		}
		
		
	}
}
