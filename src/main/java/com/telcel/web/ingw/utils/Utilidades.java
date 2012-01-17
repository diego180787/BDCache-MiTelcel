package com.telcel.web.ingw.utils;

import java.util.StringTokenizer;
import java.util.Calendar;

import com.telcel.web.ingw.dto.*;

public class Utilidades {

	private StringBuffer aux = null;
	
	public Usuario separaValoresPostpago(String linea){
		StringTokenizer token = new StringTokenizer(linea,"|");
		StringTokenizer cuenta = new StringTokenizer(linea,"|");
		
		if(cuenta.countTokens() != 10)
			return null;
		
		Usuario usuario = new Usuario();
		Cuenta cuentaObj = new Cuenta();
		Facturacion facturacion = new Facturacion();
		
		//Guardar valores en DTO Telefono
		usuario.setTelefonoId(token.nextToken());
		usuario.setTelefono(usuario.getTelefonoId());
		//Cuenta
		cuentaObj.setCuenta(token.nextToken());
		//Es Consolidada
		cuentaObj.setCuentaConsolidada(token.nextToken());
		//RFC
		cuentaObj.setRfc(token.nextToken());
		//Plan
		cuentaObj.setPlan(token.nextToken());
		//Nombre Plan
		cuentaObj.setNombrePlan(token.nextToken());
		//Fecha de Addendum
		token.nextToken();
		//Ciclo de Facturacion
		token.nextToken();
		//Fecha de Corte 
		aux = new StringBuffer(token.nextToken());
		/*System.out.println("Linea: "+linea);
		System.out.println("Fecha de Corte: "+aux.toString());*/
		if(aux.toString().equals("-1") || aux.toString().equals("")){
			facturacion.setFechaCorte(aux.toString());
		}else{
			String temp = aux.toString();
			facturacion.setFechaCorte(temp.substring(6,8)+"/"+temp.substring(4,6)+"/"+temp.substring(0,4));
		}
		//Importe Facturado
		token.nextToken();
		//Region
		//usuario.setRegion(Integer.parseInt(token.nextToken()));
		//Perfil			
		//usuario.setPerfil(token.nextToken());
		usuario.setCuenta(cuentaObj);
		usuario.setFacturacion(facturacion);
		usuario.setPlataforma(2);
		return usuario;
	}
	
	public Usuario separaValoresPostpagoInformix(String linea){
		StringTokenizer token = new StringTokenizer(linea,"|");
		String perfil;
		//Inicializar Constructor con Valores Default
		Usuario usuario = new Usuario();
		//Guardar valores en DTO Telefono
		usuario.setTelefono(token.nextToken());
		//Region
		usuario.setRegion(Integer.parseInt(token.nextToken()));
		//Perfil
		perfil = token.nextToken();
		if(perfil.equals("MIXTO")){
			perfil = "MASIVOMIX";
		}
		usuario.setPerfil(perfil);
		return usuario;
	}
	
	public Usuario separaValoresPrepago(String linea){
		StringTokenizer token = new StringTokenizer(linea,"|");
		//Inicializar Constructor con Valores Default
		Usuario usuario = new Usuario();
		//Guardar valores en DTO Telefono
		usuario.setTelefonoId(token.nextToken());
		usuario.setTelefono(usuario.getTelefonoId());
		//Region
		usuario.setRegion(Integer.parseInt(token.nextToken()));
		//Perfil
		usuario.setPerfil("AMIGO");
		//Plataforma
		usuario.setPlataforma(1);
		return usuario;
	}
	
	public String obtieneTelefono(String datos){
		StringTokenizer token = new StringTokenizer(datos,"|");
		return token.nextToken();
	}
	
	public boolean validaInfo(String dato){
		if(!dato.equals("-1"))
			return true;
		return false;
	}
}
