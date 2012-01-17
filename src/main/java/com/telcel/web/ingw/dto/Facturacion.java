package com.telcel.web.ingw.dto;

public class Facturacion {

	private String fechaCorte;
	
	public Facturacion(){}

	public Facturacion(String fechaCorte) {
		super();
		this.fechaCorte = fechaCorte;
	}

	public String getFechaCorte() {
		return fechaCorte;
	}

	public void setFechaCorte(String fechaCorte) {
		this.fechaCorte = fechaCorte;
	}
	
}
