package com.heroku.GutierrezReyesAlejo.Cifrados;

public class Desplazamiento extends Cifrado {

	private int desplazamiento = 13;
	
	public Desplazamiento(String texto, boolean cifrar, int dezp) {
		super("Desplazamiento", texto, cifrar);
		this.desplazamiento = dezp;
		
		if (cifrar) {
			this.textoPlano = texto;
			this.textoCifrado = cifrar(texto);
		}else {
			this.textoCifrado = texto;
			this.textoPlano = descifrar(texto);	
		}		
	}
	

	public String cifrar(String texto) {
		return desplazamiento(texto, desplazamiento);
	}

	public String descifrar(String text) {
		return desdesplazamiento(text, desplazamiento);
	}

	public static String desplazamiento(String cad, int x) {
		String abcd = "aábcdeéfghiíjklmnñoópqrstuúüvwxyz";
		String ABCD = "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZ";
		int pos = 0;
		char c;
		String des = "";
		if (cad == null)
			return des;
		else {
			for (int i = 0; i < cad.length(); i++) {
				if (abcd.indexOf(cad.charAt(i)) == -1 && ABCD.indexOf(cad.charAt(i)) == -1) {
					des = des + cad.charAt(i);
				} else {
					if (abcd.indexOf(cad.charAt(i)) != -1) {
						pos = abcd.indexOf(cad.charAt(i)) + x;
						if (pos >= abcd.length())
							pos = (pos - abcd.length());
						c = abcd.charAt(pos);
					} else {
						pos = ABCD.indexOf(cad.charAt(i)) + x;
						if (pos >= ABCD.length())
							pos = (pos - ABCD.length());
						c = ABCD.charAt(pos);
					}
					des = des + c;
				}
			}
		}

		return des;
	}

	public static String desdesplazamiento(String cad, int x) {
		String abcd = "aábcdeéfghiíjklmnñoópqrstuúüvwxyz";
		String ABCD = "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZ";
		int pos = 0;
		char c;
		String des = "";
		if (cad == null)
			return des;
		else {
			for (int i = 0; i < cad.length(); i++) {
				if (abcd.indexOf(cad.charAt(i)) == -1 && ABCD.indexOf(cad.charAt(i)) == -1) {
					des = des + cad.charAt(i);
				} else {
					if (abcd.indexOf(cad.charAt(i)) != -1) {
						pos = abcd.indexOf(cad.charAt(i)) - x;
						if (pos < 0) {
							pos = (abcd.length() + pos);
						}
						c = abcd.charAt(pos);
					} else {
						pos = ABCD.indexOf(cad.charAt(i)) - x;
						if (pos < 0)
							pos = (ABCD.length() + pos);
						c = ABCD.charAt(pos);
					}
					des = des + c;
				}
			}
		}

		return des;
	}
	
	
	  public static void main (String []arfs){
	    	System.out.println(desplazamiento("hola",13));
	    	System.out.println(desdesplazamiento("hola",13));	
	    }

}
