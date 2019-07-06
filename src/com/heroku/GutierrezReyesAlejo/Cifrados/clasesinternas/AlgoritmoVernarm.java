package com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas;

public class AlgoritmoVernarm {
    public String cifrar(String palabra, String llave){
        String key = toBinary(generateKey(palabra.length(),llave));
        palabra = toBinary(palabra);
       
        String cifrado = "";
        for(int i=0; i<palabra.length(); i++){
            if(palabra.charAt(i) != ' '){
                cifrado += xor(palabra.charAt(i), key.charAt(i));
            }
            else cifrado += ' ';
        }

        return cifrado;
    }
    
    public String descifrar(String palabra, String llave){
        String [] entrada = palabra.split(" ");
        String key = toBinary(generateKey(entrada.length, llave));
        
        String descifrado = "";
        for(int i=0; i<palabra.length(); i++){
            if(palabra.charAt(i) != ' '){
                descifrado += xor(palabra.charAt(i), key.charAt(i));
            }
            else descifrado += ' ';
        }
        
        String [] des = descifrado.split(" ");
        String d = "";
        for(int i=0; i<des.length; i++){
            int ch = Integer.valueOf(des[i],2);
            d += (char) ch;
        }
        return d;
    }
    
    private String generateKey(int palabra, String llave){
        String key = "";
        if(palabra > key.length()){
            while(key.length() <= palabra){
                key += llave;
            }
            return key.substring(0,palabra);
        }
        else if(palabra > key.length()){
            return llave.substring(0, palabra);
        }
        else return llave;
        
    }
    
    private String toBinary(String palabra){
        String acum = "";
        for(int i=0; i<palabra.length(); i++){
            String t = Integer.toString((int)(palabra.charAt(i)), 2);
            String t2 = "";
            if(t.length()!=7) for(int j=t.length(); j<7; j++) t2 += "0";
            t =  t2 + t;
            if(i == palabra.length()-1)
            acum += t;
            else
            acum += t + " ";
        }
        return acum;
    }
    
    private char xor(char uno, char dos){
        if(uno != dos) return '1';
        else return '0';
    }
    
}
