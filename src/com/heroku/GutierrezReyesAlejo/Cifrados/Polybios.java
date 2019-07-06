package com.heroku.GutierrezReyesAlejo.Cifrados;

import com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas.AlgoritmoPolybios;

public class Polybios extends Cifrado {


	public Polybios(String texto, boolean cifrar) {
		super("Polybios", texto, cifrar);
		
		if (cifrar) {
			this.textoPlano = texto;
			this.textoCifrado = cifrar(texto);
		}else {
			this.textoCifrado = texto;
			this.textoPlano = descifrar(texto);	
		}
	}

	@Override
	public String cifrar(String text) {
		return new AlgoritmoPolybios().cifra(text);
	}

	@Override
	public String descifrar(String text) {
		return new AlgoritmoPolybios().desencriptarTextoCifradoDeNumeros(text);
	}	
}
