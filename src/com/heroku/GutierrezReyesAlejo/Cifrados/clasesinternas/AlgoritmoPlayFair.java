package com.heroku.GutierrezReyesAlejo.Cifrados.clasesinternas;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
	 
public class AlgoritmoPlayFair {

	    
	    public static void main(String[] args) {
	            // TODO Auto-generated method stub

	            
	            System.out.println("\t   ---------------------");
	            System.out.println("\t  | *  CIFRADO PLAYFAIR * |");
	            System.out.println("\t   ---------------------");
	            Scanner sc = new Scanner(System.in);

	            System.out.println("Ingrese el Mensaje: ");
	            String mensaje  = sc.nextLine();
	            System.out.println("Ingrese la Clave:  ");
	            String clave  = sc.nextLine();
	                    
	            
	            String cipher = Cifrado_Playfair(mensaje,clave);
	            String mensaje2 = Descifrado_Playfair(cipher,clave);
	            
	            System.out.println("\nCipher: "+cipher);
	            System.out.println("Mensaje descifrado: "+mensaje2);
	            
	    }
	    

	    
	    
	    public static String Descifrado_Playfair(String cipher,String clave){
	            
	            String mensaje ="";
	            
	            char [][] matris= GenerarMatriz(clave);
	            char [][] parejas = GenerarParejas(cipher);
	            
	            int [] direcciones;
	            int [] direcciones2;
	            
	            int columnas=0;
	            for(int i=0;i<parejas.length;i++){
	                    
	                    
	                    direcciones= ObtenerPosicionCaracter(parejas[i][columnas],matris);
	                    columnas++;
	                    

	                    int fila1= direcciones[0];
	                    int columna1= direcciones[1];

	                    
	                    direcciones2= ObtenerPosicionCaracter(parejas[i][columnas],matris);
	                    if(columnas==1){columnas=0;}
	                    
	                    int fila2= direcciones2[0];
	                    int columna2= direcciones2[1];
	                    
	                    //Filas iguales ya no se suma , si no que ahora se resta -1 a la columna
	                    int fTemporal;
	                    if(fila1==fila2){
	                            fTemporal= columna1-1;
	                            if(fTemporal<0){
	                                    fTemporal=matris.length-1;
	                            }
	                            
	                            mensaje+=matris[fila1][fTemporal];
	                            
	                            
	                            fTemporal = columna2-1;
	                            if(fTemporal<0){
	                                    fTemporal=matris.length-1;
	                            }
	                            
	                            mensaje+=matris[fila2][fTemporal];
	                    }               
	                    
	                    
	                    int cTemporal;
	                    //Columnas iguales ya no se suma , si no que ahora se resta -1 a la fila

	                    if(columna1==columna2){
	                            
	                            cTemporal = fila1-1;
	                            
	                            if(cTemporal<0){
	                                    cTemporal=matris.length-1;
	                            }
	                            
	                            mensaje+= matris[cTemporal][columna1];
	                            
	                            cTemporal = fila2-1;
	                            
	                            if(cTemporal<0){
	                                    cTemporal=matris.length-1;
	                            }
	                            
	                            mensaje+= matris[cTemporal][columna2];
	                            
	                            
	                    }       
	                    
	                    //Si no se cumple ninguna se coloca la diagonal opuesta, esto no cambia
	                    if(fila1!=fila2 & columna1!=columna2){
	                            
	                            mensaje+=matris[fila1][columna2];
	                            mensaje+=matris[fila2][columna1];

	                    }
	                    
	            }
	            
	            return mensaje;
	    }
	    
	    
	    
	    public static String Cifrado_Playfair(String mensaje,String clave){

	            //Se genera la matriz
	            char [][] matris = GenerarMatriz(clave);
	            //Se generan las parejas de caracteres
	            char [][] parejaCaracteres = GenerarParejas(mensaje);
	            
	            System.out.println("\n \t Matriz");
	            //Imprimimos la matriz con la misma funcion que hemos utilizado 
	            //en todo el taller
	            Imprimir(matris);
	            
	            //Se imprimen las parejas de caracteres
	            System.out.println("\n \t Parejas de caracteres");
	            Imprimir(parejaCaracteres);
	            String cipher = "";
	            
	            //Los array de direcciones de las dos letras
	            int [] direcciones ;    
	            int [] direcciones2;
	            int columna =0;
	            //Se va por todas las parejas de caracteres
	            for(int i=0;i<parejaCaracteres.length;i++){
	            
	            
	                    // Se manda a obtener las posiciones de los caracteres
	                    direcciones= ObtenerPosicionCaracter(parejaCaracteres[i][columna],matris);
	                    columna++;
	                    direcciones2= ObtenerPosicionCaracter(parejaCaracteres[i][columna],matris);
	                    
	                    
	                    if(columna==1){
	                            columna=0;
	                    }
	                    
	                    // Se guardan en variables para asi comparar las reglas
	                    int fila1= direcciones[0];
	                    int columna1= direcciones[1];
	                    
	                    int fila2= direcciones2[0];
	                    int columna2= direcciones2[1];
	                    
	                    
	                    // Si estan en la misma fila se le suma +1 a la columna
	                    int fTemporal;
	                    if(fila1==fila2){
	                            fTemporal= columna1+1;
	                            if(fTemporal==matris.length){
	                                    fTemporal=0;
	                            }
	                            
	                            cipher+=matris[fila1][fTemporal];
	                            
	                            
	                            fTemporal = columna2+1;
	                            if(fTemporal==matris.length){
	                                    fTemporal=0;
	                            }
	                            
	                            cipher+=matris[fila2][fTemporal];
	                    }               
	                    
	                    
	                    // si estan en la misma columna se le suma +1 a la fila
	                    int cTemporal;
	                    if(columna1==columna2){
	                            
	                            cTemporal = fila1+1;
	                            
	                            if(cTemporal == matris.length){
	                                    cTemporal=0;
	                            }
	                            
	                            cipher+= matris[cTemporal][columna1];
	                            
	                            cTemporal = fila2+1;
	                            
	                            if(cTemporal == matris.length){
	                                    cTemporal=0;
	                            }
	                            
	                            cipher+= matris[cTemporal][columna2];
	                            
	                            
	                    }       
	                    
	                    // si no cumple ninguna de las anteriores
	                    // se coloca la diagonal opuesta, se invierten las columnas
	                    
	                    if(fila1!=fila2 & columna1!=columna2){
	                            
	                            cipher+=matris[fila1][columna2];
	                            cipher+=matris[fila2][columna1];
	                            

	                                            }
	            }
	            
	            // se retorna el cipher
	            return cipher;
	    }
	    
	    
	public static int[] ObtenerPosicionCaracter(char caracter,char [][] matris){
	            
	            int [] direccion = new int [2];
	            
	            
	            for(int i =0;i<matris.length;i++ ){
	                    
	                    for(int j=0;j<matris[i].length;j++){
	                            
	                            if(caracter == matris[i][j]){
	                                    direccion[0]=i;
	                                    direccion[1]=j;
	                            }
	                    }
	    
	            }
	    
	            return direccion;
	            
	    }
	    
	    public static char [][] GenerarParejas(String mensaje){
	            
	            int tam = mensaje.length();
	            
	            //Se revisa que no alla caracteres repetidos consecutivamente como "llave"
	            //tendria que queda lxlave
	            
	            char [] revision= mensaje.toCharArray();
	            ArrayList<Character> arrayRevision = new ArrayList<>();
	            for(int i=0;i<mensaje.length();i++){
	                    arrayRevision.add(revision[i]);
	            
	                    if(i+1<revision.length){
	                    if(revision[i]==revision[i+1]){
	                            arrayRevision.add('x');
	                            
	                                                                            }
	                                            }
	                            }
	            
	            //Revisamos que el mensaje quede de un tamaño par si no es asi agregamos x al final para volverlo par
	            if(arrayRevision.size()%2!=0){
	                    arrayRevision.add('x');
	            }
	            
	            
	            //Se forma una matris de 2 columnas para las parejas de caracteres
	            char [][] parejaCaracteres= new char [arrayRevision.size()/2][2];
	            int cont =0;
	            for(int i=0;i<parejaCaracteres.length;i++){
	                    for(int j=0;j<parejaCaracteres[1].length;j++){
	                            parejaCaracteres[i][j]=arrayRevision.get(cont);
	                            cont++;
	                    }
	            }
	            
	            return parejaCaracteres;
	    }
	    public static char [][] GenerarMatriz (String clave){
	        char [][] matris = new char [9][9];

	       char [] caracteresClave = clave.toCharArray();
	       //'0','1','2','3','4','5','6','7','8','9' '♘','♙','♚','♛','♞','♝','♜'
	       char [] numeros = {'♘','♙','♚','♛','♞','♝','♜'};
	       char [] letras = {'a','á','ä','b','c','d','e','é','ë','f','g','h','i','í','ï','j','k','l','m','n','ñ','o','ó','ö','p','q','r','s','t','u','ú','ü','v','w','x','y','z'};
	       //new char [26];
	       char [] letrasM =  {'A','Á','Ä','B','C','D','E','É','Ë','F','G','H','I','Í','Ï','J','K','L','M','N','Ñ','O','Ó','Ö','P','Q','R','S','T','U','Ú','Ü','V','W','X','Y','Z'};
	    		   
	    	LinkedHashSet<Character> caracteresMatriz = new LinkedHashSet<>();

	       //Eliminamos las letras repetidas de a clave
	       //Se ingresa la clave sin caracteres repetidos a la coleccion que tendra todos los caracteres de la matris
	       
	       for(int k=0;k<caracteresClave.length;k++){
	               caracteresMatriz.add(caracteresClave[k]);       
	       }
	       
	       //Se generan las letras del abecedario en base al codigo ASCII
	       
	       
	       //Se ingresa el resto del abecedario
	       for(int i=0;i<letras.length;i++){
	               caracteresMatriz.add(letras[i]);
	       }
	       
	       //Se ingresa el resto del abecedario
	       for(int i=0;i<letrasM.length;i++){
	               caracteresMatriz.add(letrasM[i]);
	       }
	       //Se ingresan los numeros
	       for(int i=0;i<numeros.length;i++){
	               caracteresMatriz.add(numeros[i]);
	       }
	       
	       
	       //Se convierte el linkedhashSet en un array para luego meterlo en la matriz
	       int cont;
	       char [] arrayTemporal = new char [caracteresMatriz.size()];
	       cont=0;
	       for(char caracter:caracteresMatriz){
	               arrayTemporal[cont]=caracter;
	               cont++;
	       }
	       
	       
	       
	       //Se ingresan a la matriz todos los caracteres (con esto tendriamos nuestra matriz lista)
	       cont=0;
	       for(int i=0;i<matris.length;i++){
	               for(int j=0;j<matris[0].length;j++){
	                       matris[i][j]=arrayTemporal[cont];
	                       cont++;
	               }
	               
	       }
	       
	       return matris;
	}

	public static void Imprimir(char [][] matris){
	       for(int i=0;i<matris.length;i++){
	               for(int j=0;j<matris[i].length;j++){
	                       System.out.print(matris[i][j]+" ");

	               }
	               System.out.println("");

	       }
	}



	}
