package com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas;

public class AlgoritmoPolybios {
	/************************************
	 * <Generated Code>
	 ****************************************************/

	String tablaPolybios[][] = {
			{ "♙♟", "♙♞", "♙♝", "♙♛", "♙♚", "♖♜", "♖♞", "♖♝", "♖♛", "♘♟", "♘♜", "♘♞", "♘♝", "♘♛", "♗♟", "♗♞", "♗♝",
					"♗♛", "♗♚", "♕♟", "♕♜", "♕♛", "♕♚", "♔♟", "♔♜", "♔♞", "♙♜", "♖♟", "♖♚", "♘♚", "♗♜", "♕♞", "♕♝" },
			{ "♟♙", "♟♘", "♟♗", "♟♛", "♟♔", "♜♖", "♜♘", "♜♗", "♜♛", "♞♙", "♞♖", "♞♘", "♞♗", "♞♛", "♝♙", "♝♘", "♝♗",
					"♝♛", "♝♔", "♛♙", "♛♖", "♛♛", "♛♔", "♚♙", "♚♖", "♚♘", "♟♖", "♜♙", "♜♔", "♞♖", "♝♖", "♛♘", "♛♗" },
			{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
					"v", "w", "x", "y", "z", "á", "é", "í", "ñ", "ó", "ú", "ü" },
			{ "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
					"V", "W", "X", "Y", "Z", "Á", "É", "Í", "Ñ", "Ó", "Ú", "Ü" }, };

	
	  //public static void main(String[] args) { System.out .println(new
	//		  new Polybios().desencriptarTextoCifradoDeNumeros("♙♟♘♞♙♚♘♟♗♟ ♗♚♙♚ ♘♞♙♟ ♙♝♗♟♘♝♙♚")); 
	 // }
	 

	public String desencriptarTextoCifradoDeNumeros(String textoCifrado) {
		System.out.println(textoCifrado);
		String textoClaro = "";
		for (int i = 0; i < textoCifrado.length(); i++) {
			if (textoCifrado.charAt(i) != ' ') {
				textoClaro += this.getTextoClaroDeNumeros(textoCifrado.charAt(i) + "" + textoCifrado.charAt(i + 1));
				i++;
			} else {
				textoClaro += textoCifrado.charAt(i);
			}
		}
		return textoClaro;
	}

	public String getTextoClaroDeNumeros(String textoCifrado) {
		for (int i = 0; i < 33; i++) {
			if (textoCifrado.equals(tablaPolybios[0][i])) {
				return tablaPolybios[2][i] + "";
			}
		}
		for (int i = 0; i < 33; i++) {
			if (textoCifrado.equals(tablaPolybios[1][i])) {
				return tablaPolybios[3][i] + "";
			}
		}
		return textoCifrado;
	}

	/************************************
	 * <Generated Code>
	 ****************************************************/
	public String cifra(final String cadena) {

		final String tabla_min[] = { "♙♟", "♙♞", "♙♝", "♙♛", "♙♚", "♖♜", "♖♞", "♖♝", "♖♛", "♘♟", "♘♜", "♘♞", "♘♝", "♘♛",
				"♗♟", "♗♞", "♗♝", "♗♛", "♗♚", "♕♟", "♕♜", "♕♛", "♕♚", "♔♟", "♔♜", "♔♞" };
		final String tabla_may[] = { "♟♙", "♟♘", "♟♗", "♟♛", "♟♔", "♜♖", "♜♘", "♜♗", "♜♛", "♞♙", "♞♖", "♞♘", "♞♗", "♞♛",
				"♝♙", "♝♘", "♝♗", "♝♛", "♝♔", "♛♙", "♛♖", "♛♛", "♛♔", "♚♙", "♚♖", "♚♘" };

		char str[] = cadena.toCharArray();
		StringBuilder Result = new StringBuilder();

		for (int i = 0; i < str.length; i++) {
			char caracter = str[i];
			if ((caracter >= 'A' || caracter >= 'a') && (caracter <= 'Z' || caracter <= 'z')) {
				if (Character.isUpperCase(caracter)) {
					Result.append(tabla_may[caracter - 65]);
				} else
					Result.append(tabla_min[caracter - 97]);
				continue;
			}
			Result.append(especial(caracter));
			// Result.append(caracter);//si algun valor no esta en la tabla
		}
		return Result.toString();
	}

	public static String especial(char c) {
		switch (c) {
		case 'á':
			return "♙♜";
		case 'é':
			return "♖♟";
		case 'í':
			return "♖♚";
		case 'ñ':
			return "♘♚";
		case 'ó':
			return "♗♜";
		case 'ú':
			return "♕♞";
		case 'ü':
			return "♕♝";
		case 'Á':
			return "♟♖";
		case 'É':
			return "♜♙";
		case 'Í':
			return "♜♔";
		case 'Ñ':
			return "♞♖";
		case 'Ó':
			return "♝♖";
		case 'Ú':
			return "♛♘";
		case 'Ü':
			return "♛♗";

		}
		return c + "";
	}
}
