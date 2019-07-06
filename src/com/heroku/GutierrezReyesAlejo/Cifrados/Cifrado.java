package com.heroku.GutierrezReyesAlejo.Cifrados;

import java.io.Serializable;

public abstract class Cifrado implements Serializable{
	public static int Id = 0;
	protected String tipoCifrado; // Rot13,
	protected String textoPlano;
	protected String textoCifrado;
	
	protected int id;
	
	public Cifrado(String tipo, String texto, boolean cifrar) {
		Id = ((Id + 1)%100);
		id = Id;
		this.tipoCifrado = tipo;	
	}
	
	public String getId() {return String.valueOf(Id);}
	
	public String getTextoCifrado(){return textoCifrado;}
	
	public String getTextoPlano() {return textoPlano;}
	
	public String toCsv() {
		StringBuffer representacion = new StringBuffer();
		representacion.append(id + "|");
		representacion.append(tipoCifrado + "|");
		representacion.append(formato(textoPlano) + "|");
		representacion.append(formato(textoCifrado));
		return representacion.toString();
		
	}

	
	public String toXml(){
		StringBuffer representacion = new StringBuffer();
		representacion.append("<Cifrado id=\"" + id + "\">");
		representacion.append("<tipoCifrado>" + tipoCifrado + "</tipoCifrado>");
		representacion.append("<textoPlano>" + formato(textoPlano) + "</textoPlano>");
		representacion.append("<textocifrado>" + formato(textoCifrado) + "</textocifrado>");
		representacion.append("</Cifrado>");
		return representacion.toString();
	}
	
	public String toJson(){
		StringBuffer representacion = new StringBuffer();
		representacion.append("{");
		representacion.append("\"id\": \"" + id + "\",");
		representacion.append("\"tipoCifrado\": \"" + tipoCifrado + "\",");
		representacion.append("\"textoPlano\": \"" + formato(textoPlano) + "\",");
		representacion.append("\"textocifrado\": \"" + formato(textoCifrado) + "\"");		
		representacion.append("}");
		return representacion.toString();
	}
	
	public String getTipoCifrado() {return tipoCifrado; }
	
	protected String formato(String cadena){
		String nueva = cadena;
		nueva = nueva.replaceAll("\n", "[/n]");
		nueva = nueva.replaceAll("\r","");
		return nueva;
	}
	
	public abstract String cifrar(String texto);
	
	public abstract String descifrar(String texto);
	 
}
