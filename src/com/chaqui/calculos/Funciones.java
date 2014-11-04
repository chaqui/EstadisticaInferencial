//Funciones de  Distribuciones de Bonomial                    Terminada
//Funciones de  Distribuciones de Multinomial
//Funciones de  Distribuciones de Hipergeometrica             Terminada
//Funciones de  Distribuciones de Binomial Negativa           Terminada
//Funciones de  Distribuciones de Geometrica                  Terminada
//Funciones de  Distribuciones de poisson                     Terminada


package com.chaqui.calculos;

public class Funciones { 
     //n!
    public double vectorial(double e){
        double z=1;
        for (double i=e; i>1; i-- ){
              z= z * i ;
        }               
        return z;
    }
    //(n-1)!
    public double vec(double e){
    	double z=1;
    	for(double i=e;i>=1;i--)	{
    		z=z*i;
    	}             
        return z;
    }
    
       
    
    public double bimonial(double x, double n, double p){
        double res = 0, f=0,g=0,y=0, aux,pp=0;    
           if (p>1){
        	   System.out.println("");
           }  
           else if(x>n){
            	System.out.println("");
            }
           else { 
                //PERMUTACION [ n!/(n-r)! ]
                //(n-r)!
            	double s=n-x;                
            	pp = vectorial(n) / vec(s);                
                //COMBINACION 
            	y=pp/vectorial(x);
            double d=1-p;
            double e=n-x;
            f= Math.pow(p,x);
            g= Math.pow(d,e);                
                //BINOMIAL 
            res=y*f*g;          
           }
           aux = res;        
           return aux;
       }
    
   
       
   public double hipergeometrica(double x, double N, double n, double k ){
       double NN=0, nn=0, primero=0, segundo=0, tercero=0, uno=0, dos =0,tres=0,resultado=0, one=0, two=0, three=0;
       //combinacion de (k C x)   
       segundo = k-x;
       primero= vectorial(k)/vec(segundo);
       tercero= primero/vectorial(x);  
       //combinacion de ((N-k) C (n-x))   
       NN= (N-k);
       nn= (n-x);  
       dos = NN-nn;
       uno = vectorial(NN) / vec(dos);
       tres = uno/vectorial(nn);
       //combinacion de (N C n)   
       two = N-n;
       one = vectorial(N) / vec(two);
       three = one/vectorial(n);
       resultado= (tercero *tres)/three;
       
       return resultado;
   }
   
   public double bimonialnegativa(double x, double k, double p){
        double res = 0, f=0,g=0, aux,pp=0;    
           
	       if (p>1){
	    	   	System.out.println("");
	       }  
	       else if(k>x){
	              System.out.println("");       
	       }
	       else { 
	           //(x-1)
	           //(k-1)
	    	   double a = x-1;
	           double b= k-1;
	      
	           //((n-1)-(r-1)
	           double xx = a-b;
	       
	           //combinacion
	           //(n-1)! 	      
	           pp = vec(a) / vec(xx);        
	              
	           //((n-1)!/((n-1)-(r-1))!)/(r-1)
	           double d = pp / vec(b);             
	           double e = Math.pow(p, k);
	           f=1-p;
	           g=x-k;
	           double h=Math.pow(f,g);                 
	           res=h*d*e;          
	       }
	       aux =(res) ;        
	       return aux;
        }
   
   
   public double geometrica(double x, double p){
       double pp=0, q=0,xx=0, geo=0;
       q = 1- p;
       xx = x -1;
       geo = Math.pow(q, xx);
       pp= p*geo;
       
       return pp;
   }
   
   public double poisson(double l, double x){
       double e=2.71828;
       double p=0,g=0,resp=0;
       p=Math.pow(l, x);
       g= Math.pow(e, -l);    
       resp=((g*p)/ vectorial(x));   
       return resp;}

   
    
}
