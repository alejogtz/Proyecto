package com.heroku.GutierrezReyesAlejo.Cifrados;

import com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas.AlgoritmoPlayFair;

public class Playfair extends Cifrado {

	public Playfair(String texto, boolean cifrar, String llave) {
		super("Playfair", texto, cifrar);
		this.key = llave;

		if (cifrar) {
			this.textoPlano = texto;
			this.textoCifrado = cifrar(texto);
		} else {
			this.textoCifrado = texto;
			this.textoPlano = descifrar(texto);
		}

	}

	private String key = "ProyectoFinal";

	@Override
	public String cifrar(String text) {
		// TODO Auto-generated method stub
		return AlgoritmoPlayFair.Cifrado_Playfair(text, key);
	}

	@Override
	public String descifrar(String text) {
		// TODO Auto-generated method stub
		return AlgoritmoPlayFair.Descifrado_Playfair(text, key);
	}

}
