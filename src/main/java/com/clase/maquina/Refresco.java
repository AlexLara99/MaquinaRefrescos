package com.clase.maquina;

public class Refresco {

	private String tipo;
	private double precio;
	private int cantidad;
	private int refrescosVendidos;
	//constructor
	public Refresco() {
		tipo = "";
		precio = 0;
		cantidad = 0;
	}
	
	public Refresco(String tipo, double precio, int cantidad) {
		
		this.tipo = tipo;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	//getters and setters
	public String getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getRefrescosVendidos() {
		return refrescosVendidos;
	}

	public void setRefrescosVendidos(int refrescosVendidos) {
		this.refrescosVendidos = refrescosVendidos;
	}
	
	//metodos
	
	public void reponerRefresco(int cantidadReponer) {
		
		System.out.println("Has introducido " + cantidadReponer + " refrescos");
		this.setCantidad(this.getCantidad() + cantidadReponer);
		System.out.println("Actualmente tienes " + this.getCantidad());
		
	}
	
	
	
}
