package com.heroku.GutierrezReyesAlejo.Util.Parser;

import java.util.ArrayList;

import com.heroku.GutierrezReyesAlejo.Cifrados.Cifrado;
import com.heroku.GutierrezReyesAlejo.Cifrados.Polybios;

public class DeObject {
	
	private DeObject() {}
	
	/**
	 * 
	 * @param arg
	 * @return
	 */
	public static ArrayList<Cifrado> aArrayList(Object arg) {
		ArrayList<Cifrado> lista = null;
		
		try {
			if (arg!=null) {				
				ArrayList args = (ArrayList)arg;
				lista = new ArrayList<Cifrado>();
				
				for (Object obj: args) {
					Cifrado objCifrado = (Cifrado)obj;
					lista.add(objCifrado);
				}
			}			
		}catch(ClassCastException ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}
	
	public static Cifrado aCifrado(Object arg) {
		Cifrado cifrado = null;
		
		try {
			if (arg!=null) {				
				cifrado = (Cifrado)arg;				
			}			
		}catch(ClassCastException ex) {
			System.out.println(ex.getMessage());
		}
		return cifrado;
	}
	
	/**public static void main(String args[]) {
		ArrayList<Cifrado> array = new ArrayList<Cifrado>();
		
		Object obj = array;
		System.out.println(
				DeObject.aArrayList(obj));
		
	}*/
	
}
