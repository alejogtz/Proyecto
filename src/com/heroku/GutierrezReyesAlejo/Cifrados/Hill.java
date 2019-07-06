package com.heroku.GutierrezReyesAlejo.Cifrados;

import com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas.AlgoritmoHill;
import com.heroku.GutierrezReyesAlejo.Util.Console;

public class Hill extends Cifrado{
	
	private String key = "mble";

	public Hill(String texto, boolean cifrar, String llave) {
		super("Hill", texto, cifrar);
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
	public String cifrar(String text) {
		// TODO Auto-generated method stub
		return new AlgoritmoHill().encripta(text, key);
	}

	@Override
	public String descifrar(String text) {
		// TODO Auto-generated method stub
		return new AlgoritmoHill().desencripta(text, key);
	}
	
	public static void main(String [] args) {
		String c = new AlgoritmoHill().encripta("alejo", "arre");
		
		String x = new AlgoritmoHill().desencripta(c, "arre");
		
		
		Console.println("Linea [42]", c);
		Console.println("Linea [43]", x);
		
	}

}
