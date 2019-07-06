package com.heroku.GutierrezReyesAlejo.Generadoores;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;


public class DocumentoJson {
	public static String deObjetosCifrado(List<Cifrado> objetos) {
		StringBuffer documento = new StringBuffer();
		
		documento.append("{");
		documento.append("\"ObjetosCifrado\": [");
		for (Cifrado obj : objetos) {
			documento.append(obj.toJson());
			if (objetos.indexOf(obj) != (objetos.size() - 1)) {
				documento.append(",");
			}
		}
		documento.append("]");
		documento.append("}");
		
		return documento.toString();
	}
}
