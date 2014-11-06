package com.chaqui.calculos;

public class RegresionLinealCalculos {
	public String calcularRegresion(double[] x, double[] y){
		double b= (sumatoriaMultiplicarXY( x,y)-this.nPorMediaXPorMediaY(x, y))/(this.sumatoriaXCuadrado(x)-this.mediaXalCuadradoPorN(x));
		double a= this.mediaY(y)-(b*this.mediaX(x));
		return String.valueOf(a)+"x+"+String.valueOf(b);
	}
	public double calcularDeterminacion(double a, double b, double[] x, double[] y){
		double dividendo = (a*this.sumatoriaYCuadrado(y))+(b*this.sumatoriaMultiplicarXY(x, y)-this.mediaYalCuadradoPorN(y));
		double divisor =(this.sumatoriaYCuadrado(y)-this.mediaYalCuadradoPorN(y));
		return dividendo/divisor;
	}
	public double calcularCorrelacion(double a, double b, double[] x, double[] y){
		return Math.sqrt(this.calcularDeterminacion(a, b, x, y));
	}
	public String[] calcularRegresionyCorrelacion(double[] x, double[] y){
		String[] resultado = new String[2];
		String resultadoReg= this.calcularRegresion(x, y);
		String a;
		String b=a="";
		for (int i = 0; i < resultadoReg.length(); i++) {
			if ( resultadoReg.charAt(i) == 'x') {
				for (int j = 0; j < i; j++) {
					a=a+resultadoReg.charAt(j);
				}	
				i=i+2;
			}
				b=b+resultadoReg.charAt(i);
			
		}
		String resCorrelacion = String.valueOf(calcularCorrelacion(Double.valueOf(a),Double.valueOf(b),x,y));
		resultado[0]=resultadoReg;
		resultado[1]=resCorrelacion;
		return resultado;
	}
	private double sumatoriaMultiplicarXY(double[] x, double[] y){
		double suma=0;
			for (int i = 0; i < y.length; i++) {
				suma = suma+(x[i]*y[i]);
			}
		return suma;
	}
	private double mediaX(double[] x){
		double suma=0;
		for (int i = 0; i < x.length; i++) {
			suma=suma+x[i];
		}
		return suma/(x.length-1);
	}
	private double mediaY(double[] y){
		double suma=0;
		for (int i = 0; i < y.length; i++) {
			suma=suma+y[i];
		}
		return suma/(y.length-1);
	}
	private double nPorMediaXPorMediaY(double[] x, double[] y){
		return x.length*this.mediaX(x)*this.mediaY(y);
	}
	private double sumatoriaXCuadrado(double[] x){
		double suma=0;
		for (int i = 0; i < x.length; i++) {
			suma=suma+Math.pow(x[i], 2) ;
		}
		return suma;
	}
	private double mediaXalCuadradoPorN(double[] x){
		return Math.pow(this.mediaX(x), 2)*x.length;
	}
	private double mediaYalCuadradoPorN(double[] y){
		return mediaXalCuadradoPorN(y);
	}
	private double sumatoriaYCuadrado(double[] y){
		return  sumatoriaXCuadrado(y);
	}
}
