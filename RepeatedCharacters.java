package com.baufest.ingreso.strings;

import java.util.ArrayList;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     *     Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     *     Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {



String cadenafinal =cadena.replaceAll("\\s",""); //elimino espacios 
char[]Arraycadena;
char caracter;
int contador = 0;
Arraycadena =cadenafinal.toCharArray();  // Convierto la cadena en una Array de tipo char
int tam= Arraycadena.length;
int Arraycontador []; 
Arraycontador = new int [tam];
ArrayList<Integer> control = new ArrayList<Integer>(); // Creo una lista para guardar valores de caracteres repetidos
int enviar = 0;//sirve como swuich 

	for (int i = 0; i <= Arraycadena.length -1 ; i++) {
		//System.out.println(Arraycadena);
		//System.out.println(Arraycadena.length);
		caracter = Arraycadena[i];
		for (int j = 0; j <= Arraycadena.length -1; j++) {
			//System.out.println(Arraycadena);
			//System.out.println(Arraycadena.length);
			if (Arraycadena[j]== caracter) {
				
				contador++;
				
			}
	    }
		control.add(contador);  //Guardo valores del contador en la lista "control"
		
		
		//CUENTO LA SEPARACIÓN QUE HAY ENTRE UNA REPETICIÓN Y OTRA
		//SI UN CARACTER SE REPITE 3 VECES Y OTRA 4 ESTÁ TODO BIEN
		//PERO SI SE SEPARAN MÁS DE UN NÚMERO DE VECES DEBO RETORNAR FALSE
		int mayor, menor;
	    mayor = menor = control.get(i);
		for (int k = 0; k < control.size()-1 -1; k++) {
            if(control.get(k) > mayor) {
                mayor = control.get(k) ;
            }
            if(control.get(k) <menor) {
                menor = control.get(k) ;
            }
        }
		//System.out.println("El mayor valor es: "+mayor);
        //System.out.println("El menor valor es: "+menor);
        if( mayor - menor >=2) {
        	enviar++;
			}else {}
        
		contador=0;
		if(enviar>=1) { 
		return false;  }
    }
	
	   /**  ESTA ERA LA PRIMERA MANERA QUE TUVE DE RESOLVER LOS
	    *  PLANTEAMIENTOS HASTA QUE ME TOPÉ CON EL ÚLTIMO PUNTO
	
	System.out.println("ELEMENTOS EN LA LISTA control");
	//control.forEach(System.out::println);
	int cuentaexcepciones = 0 ;
	for(int i=0; i < control.size()-1; i++){
		  System.out.println(control.get(i)-1);
		  System.out.println(control.get(i));
		  System.out.println(control.get(i)+1);
		  for(int y=1; y < control.size()-1; y++){
			  //int cuentaexcepciones = 0 ;
			  
			  if(control.get(i)==control.get(y)) {
				  System.out.println("El número de caracteres es igual  " +control.get(i)+" "+ control.get(y)+" ");
				  
			  }
			  // acá se establece el umbral de diferencia
			  else if(control.get(i)==(control.get(y)-1)|| control.get(i)==(control.get(y)+1)) {
				  System.out.println("El número de caracteres es igual +/- 1 " +control.get(i)+" "+ control.get(y)+" ");
				  cuentaexcepciones ++;
				  if(cuentaexcepciones >= 2) {
				    System.out.println("Excepciones "+ cuentaexcepciones );
				    cuentaexcepciones = 0;
					return false;  
				  	}
			  }
			  else {
				  System.out.println("El número de caracteres  NO es igual  "+control.get(i)+" "+ control.get(y)+" ");
				  return false;
			  }
		   }
		}    */
	
	
	
    return true;
			

    }

}
