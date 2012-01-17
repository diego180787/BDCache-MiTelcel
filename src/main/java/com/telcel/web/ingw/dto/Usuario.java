package com.telcel.web.ingw.dto;

import org.springframework.data.annotation.Id;

public class Usuario {

	@Id
	private String telefonoId;
	private String telefono;
	private int region;
	private String perfil;
	private int plataforma;
	private Cuenta cuenta;
	private Facturacion facturacion;
	
	public Usuario(){}

	public Usuario(String telefonoId, String telefono, int region, String perfil, Cuenta cuenta,
			Facturacion facturacion, int plataforma) {
		super();
		this.telefonoId = telefonoId;
		this.telefono = telefono;
		this.region = region;
		this.perfil = perfil;
		this.cuenta = cuenta;
		this.facturacion = facturacion;
		this.plataforma = plataforma;
	}

	public String getTelefonoId(){
		return telefonoId;
	}
	
	public void setTelefonoId(String telefonoId){
		this.telefonoId = telefonoId;
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getRegion() {
		return region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}
	
	public int getPlataforma(){
		return plataforma;
	}
	
	public void setPlataforma(int plataforma){
		this.plataforma = plataforma;
	}
}
