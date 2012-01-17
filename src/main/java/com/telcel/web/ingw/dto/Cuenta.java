package com.telcel.web.ingw.dto;

public class Cuenta {

	private String cuenta;
	private String cuentaConsolidada;
	private String rfc;
	private String plan;
	private String nombrePlan;
	
	public Cuenta(){}

	public Cuenta(String cuenta, String cuentaConsolidada, String rfc,
			String plan, String nombrePlan) {
		super();
		this.cuenta = cuenta;
		this.cuentaConsolidada = cuentaConsolidada;
		this.rfc = rfc;
		this.plan = plan;
		this.nombrePlan = nombrePlan;
	}

	public String getCuenta() {
		return cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCuentaConsolidada() {
		return cuentaConsolidada;
	}

	public void setCuentaConsolidada(String cuentaConsolidada) {
		this.cuentaConsolidada = cuentaConsolidada;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}
}
