package com.telcel.web.ingw.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;

import com.telcel.web.ingw.dto.*;
import com.telcel.web.ingw.utils.*;

public class CacheMain{

	private static final Log logger = LogFactory.getLog(CacheMain.class);
	
	public static void main (String []args) throws Exception{
	
		Usuario usuario = null;
		PropertyConfigurator.configure("/home/root2/bdcache/log4jMiTelcel.properties");
		BufferedReader br = null;
		Utilidades util = new Utilidades();
		HashMap mapa = new HashMap();
		MongoOperations mongoOps = new MongoTemplate(new SimpleMongoDbFactory(new Mongo("168.143.161.136", 27017), "MiTelcel"));
	
		//Borramos la colección existente en Mongo
		mongoOps.dropCollection(Usuario.class);
		
		/*
		 * Insertamos los registros de Postpago
		 */
		//Leemos el archivo de Dataware House y lo guardamos en una lista
		String linea;
		try {
			br = new BufferedReader(new FileReader("/home/root2/bdcache/postpagodwh.txt"));
	        while((linea=br.readLine())!=null){
	        	linea = linea.trim();
	           	if(linea.equals(""))continue;
	        	usuario = util.separaValoresPostpago(linea);
	        	if(usuario != null)
	        		mapa.put(usuario.getTelefono(), usuario);
	        }	
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        try{
	        	br.close();
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	}	  
	    }
		
		//Buscamos en la colección de Dataware House los valores que vayamos leyendo del archivo de usuariopago
		int resultado = 0;
		Usuario aux = new Usuario();
		try {
	    	//br = new BufferedReader(new FileReader("/home/root2/bdcache/usuariopago.txt"));
			br = new BufferedReader(new FileReader("/home/root2/bdcache/postpago.txt"));
	        while((linea=br.readLine())!=null){
	        	usuario = (Usuario) mapa.get(util.obtieneTelefono(linea));
	        	if(usuario != null){
	        		aux = util.separaValoresPostpagoInformix(linea);
	        		//System.out.println("Inserte en Mongo!");
	        		usuario.setRegion(aux.getRegion());
	        		usuario.setPerfil(aux.getPerfil());
	        		logger.info("Telefono insertado: "+usuario.getTelefono());
	        		mongoOps.insert(usuario);
	        	}
	        }	
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        try{
	        	br.close();
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	}	  
	    }
		
		/*
		 * Insertamos los registros de Prepago
		 */
		try {
	    	br = new BufferedReader(new FileReader("/home/root2/bdcache/prepago.txt"));
	        while((linea=br.readLine())!=null){
	        	usuario = util.separaValoresPrepago(linea);
	        	mongoOps.insert(usuario);
	        	logger.info("Telefono Insertado: "+usuario.getTelefono());
	        }	
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }finally{
	        try{
	        	br.close();
	    	}catch(IOException ioe){
	    		ioe.printStackTrace();
	    	}	  
	    }	
	}
}
