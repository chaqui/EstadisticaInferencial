package com.chaqui.calculos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CalEstadisticaDescriptiva {
	 public String moda(String Val){

	        String cad1 = Val.trim();
	        String cad2 = cad1.replace(" ", "");
	        String elementos[][];
	        String G  = "";
	        StringTokenizer st = new StringTokenizer(cad2,",");
	        ArrayList<String> list = new ArrayList<String>();
	         while(st.hasMoreTokens()){
	            G = st.nextToken();
	        list.add(G);
	        }
	        
	        Set<String> quipu = new HashSet<String>(list);
	        elementos = new String[quipu.size()][2];
	        int i =0;
	        for (String key : quipu) {
	            elementos[i][0]=key;
	            elementos[i][1]=String.valueOf(Collections.frequency(list, key));
	            i++;
	        }
	        int mayor[][]= new int[1][2];
	        ArrayList<Integer> mayores = new ArrayList<Integer>();
	        for (int j = 0; j < elementos.length; j++) {
	        	
	        	if (j==0) {
	        		mayor[0][1]=Integer.valueOf(elementos[j][1]);
					mayor[0][0]=Integer.valueOf(elementos[j][0]);
					mayores.add(mayor[0][0]);
				}
	        	else{
	       		
	        		if (mayor[0][1]<Integer.valueOf(elementos[j][1])) {
						mayor[0][0]=Integer.valueOf(elementos[j][0]);
						mayor[0][1]=Integer.valueOf(elementos[j][1]);
						mayores.clear();
						mayores.add(mayor[0][0]);
					}
	        		else if (mayor[0][1]==Integer.valueOf(elementos[j][1])) {
	        			mayores.add(Integer.valueOf(elementos[j][0]));
					}
	        	}
				
			}
	        String retorno="";
	        for (Integer valor : mayores) {
	        	retorno= retorno+valor+", ";
			}
	        
	        return retorno;
	    }
	 public double media(String Cadena){
		 String c = Cadena.trim();
	        String c1 = c.replace(" ", "");
	        String G = "";
	        int suma = 0;
	        double val;
	        double Sum1=0.0;
	        StringTokenizer st = new StringTokenizer(c1,",");
	        while(st.hasMoreTokens()){
	            G = st.nextToken();
	        val= Double.parseDouble(G);
	        Sum1 = Sum1+val;
	        suma++;
	        }
	        return  Sum1/suma;
	    
	 }
	 public double varianza(String Cadena, double v){
	        String c = Cadena.trim();
	        String c1 = c.replace(" ", "");
	        String G = "";
	        int suma = 0;
	        double suma1=0;
	        double val;
	        double Sum1=0.0;
	        StringTokenizer st = new StringTokenizer(c1,",");
	        while(st.hasMoreTokens()){
	            G = st.nextToken();
	        val= Double.parseDouble(G);
	        suma1 = Math.pow((val - v),2);
	        Sum1 = (Sum1+suma1);
	        suma++;
	        }
	    return  Sum1/(suma-1);
	    
	    }
	 public String calcular(String cadena){
		 String retorno="";
		 String moda = moda(cadena);
		 double media= media(cadena);
		 double varianza = varianza(cadena,media);
		 retorno="moda:"+moda+"\n media:"+String.valueOf(media)+"\n varianza:"+
				 String.valueOf(varianza);
		return retorno;
		 
	 }
}
