package com.heroku.GutierrezReyesAlejo.Util.Parser;

public class DeString {
	private DeString() {}
	
	public static String aString(String arg) {
		try {
			return String.valueOf(arg);			
		}catch(ClassCastException ex) {
			return null;
		}catch(Exception ex) {
			return null;
		}
		
	}
	
	public static String aString(String arg, String _default) {
		try {
			if (arg.replace(" ", "").isEmpty()) {return _default;}
			return String.valueOf(arg);			
		}catch(ClassCastException ex) {
			return _default;
		}catch(Exception ex) {
			return _default;
		}
	}
	
	public static int aInt(String arg, int _default) {
		int value = _default;
		try {
			value = Integer.parseInt(arg);
		}catch(NullPointerException | ClassCastException ex) {
			System.out.println("[DeString.java] Linea [33] -> No se pudo castear el valor" + arg);
		}
		catch(Exception ex) {
			System.out.println("[DeString.java] Linea [36] -> No se pudo castear el valor" + arg);
			System.out.println("[DeString.java] Linea [37](Throwable -> cause:) -> " + ex.getMessage());
		}
		return value;
	}
	
	public static boolean aBoolean(String arg) {return false;}
	
	public static boolean aBoolean(String arg, boolean _default) {		
		
		try {
			return Boolean.parseBoolean(arg);
		}catch(ClassCastException ex) {
			
		}catch(Exception ex) {
			
		}
		return false;
	}
	
	
}
