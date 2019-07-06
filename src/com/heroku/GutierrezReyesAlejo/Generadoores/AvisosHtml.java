package com.heroku.GutierrezReyesAlejo.Generadoores;

public class AvisosHtml {
	

	public static String aviso(String tipo, String aviso) {
		// tipos warning
		//	success
		// danger
		  String msje = "<div class=\"alert alert-"+ tipo +"\""+
	                "<strong>Info: !</strong> " + aviso + 
	                "</div> ";
		  
		  return msje;
	}
	
	
	public static String avisoAdvertencia(String texto) {
		return aviso("warning", texto);
	}
	
	

}
