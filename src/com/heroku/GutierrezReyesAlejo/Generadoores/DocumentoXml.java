package com.heroku.GutierrezReyesAlejo.Generadoores;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;

public class DocumentoXml {
	public static String deObjetosCifrado(List<Cifrado> objetos) {
		StringBuffer documento = new StringBuffer();
		
		documento.append("<Cifrado>");
		for (Cifrado objeto : objetos) {
			
			documento.append(objeto.toXml());
		}
		documento.append("</Cifrado>");
		
		return documento.toString();
	}
}
