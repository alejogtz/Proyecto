package com.heroku.GutierrezReyesAlejo.Cifrados;

import com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas.AlgoritmoVernarm;

public class Vernarm extends Cifrado {

	private String key;
	
	public Vernarm(String texto, boolean cifrar, String llave) {
		super("Vernarm", texto, cifrar);
		
		this.key = llave;
		
		if (cifrar) {
			this.textoPlano = texto;
			this.textoCifrado = cifrar(texto);
		}else {
			this.textoCifrado = texto;
			this.textoPlano = descifrar(texto);	
		}
	}	
	
	
	@Override
	public String cifrar(String texto) {	
		
		return new AlgoritmoVernarm().cifrar(texto, key);
	}

	@Override
	public String descifrar(String texto) {
		
		return new AlgoritmoVernarm().descifrar(texto, key);
	}
}
