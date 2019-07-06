package com.heroku.GutierrezReyesAlejo.Generadoores;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;

public class DocumentoCsv {
	
		public static String deObjetosCifrado(List<Cifrado> objs) {
			StringBuffer documento = new StringBuffer();
			
			documento.append("id|tipoCifrado|textoPlano|textoCifrado\n");
			for (Cifrado obj : objs) {
				documento.append(obj.toCsv());
				documento.append("\n");
			}
			return documento.toString();
			
		}
}
