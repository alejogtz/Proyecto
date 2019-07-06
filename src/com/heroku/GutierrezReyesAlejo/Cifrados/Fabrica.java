package com.heroku.GutierrezReyesAlejo.Cifrados;

import com.heroku.GutierrezReyesAlejo.Util.Parser.DeString;

public class Fabrica {
	private Fabrica() {}
	public static Cifrado deObjetoCifrado(String tipoCifrado, String textoPlano, boolean cifrar, String param_key) {
		Cifrado obj = null;
		String _key = DeString.aString(param_key);
		
		
		if (textoPlano.replaceAll(" ", "").equals("")) return null;
		switch (tipoCifrado) {
			case "polybios":
				obj = new Polybios(textoPlano, cifrar);
				break;
				
				
			case "desplazamiento":
				int r = DeString.aInt(param_key, 13);
				
				obj = new Desplazamiento(textoPlano, cifrar, r);
				break;
				
				
			case "playfair":
				
				obj = new Playfair(textoPlano, cifrar, _key);
				break;
				
				
			case "hill":
				
				obj = new Hill(textoPlano, cifrar, _key);
				break;
				
				
			case "vernarm":
				obj = new Vernarm(textoPlano, cifrar, _key);
				break;
				
				
			default: break;
		}
		return obj;
	}
}
