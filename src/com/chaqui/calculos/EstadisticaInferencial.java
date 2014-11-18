package com.chaqui.calculos;

import com.chaqui.calculos.tablas.TablaZ;
public class EstadisticaInferencial {
	TablaZ tablaz = new TablaZ();
	
public double calcularMedia(double[] datos){
	
	if (datos.length==0){
		return 0;
	}

	double suma=0;
	for (int i = 0; i < datos.length; i++) {
		suma = suma +datos[i];
	}
	return suma/Double.parseDouble(String.valueOf(datos.length));
	
}
///////////////////Errores Estandar////////////////////////////
//Calcular el error estandar cuando no se conoce la poblacion
public double calcularErrorEstandar(double desviacionEstandar, double n){
	System.out.println(String.valueOf(Math.sqrt(n)));
	return desviacionEstandar/(Math.sqrt(n));
	
}


//Calculo del error estandar conociendo la poblacion
public double calcularErrorEstandar(double desviacionEstandar, double n, double N){
	
	if(n/N < 0.05 ){	
		return calcularErrorEstandar(desviacionEstandar, n);
	}
	
	return calcularErrorEstandar(desviacionEstandar, n)*calcularMultiplicador(n,N);
}

///error estandar de la proporcion 
public double calculoDelErrorEstandarDeLaProporcion(double p, double q, double n){
	return Math.sqrt((p*q)/n);
}

///////////Estandarizaciòn de la media de la muestra es decir z //////////////////

///cuando se conoce el error estandar
public double estandatizarMediaMuestra(double x, double media, double errorEstandar){
	
	return (x-media)/errorEstandar;
}


//sin conocer el error estandar y tampoco la poblacion
public double estandatizarMediaMuestra(double x, double media, double desviacionEstandar, double n ){
	
	return estandatizarMediaMuestra(x,media,this.calcularErrorEstandar(desviacionEstandar, n));
}


// sin conocer el error estandar y si conocemos la poblacion
public double estandatizarMediaMuestra(double x, double media, double desviacionEstandar, double n ,double N){
	
	return estandatizarMediaMuestra(x,media,this.calcularErrorEstandar(desviacionEstandar, n, N));
}

public double[] calcularIntervalos(double media, double z,double desviacionEstandar, double n, double N){
	double[] retorno = new double[2];
	retorno[0]= media+(z*this.calcularErrorEstandar(desviacionEstandar, N, n));
	retorno[1]=media-(z*this.calcularErrorEstandar(desviacionEstandar, N, n));
	return retorno;
}
public double[] calcularIntervalos(double media, double z,double desviacionEstandar, double n){
	double[] retorno = new double[2];
	retorno[0]= media+(z*this.calcularErrorEstandar(desviacionEstandar,  n));
	retorno[1]=media-(z*this.calcularErrorEstandar(desviacionEstandar, n));
	return retorno;
}
public double distribucionT(double intervaloDeConfianza, double n){
	//double gradosDeLibertad=n-1;
	return 0;
}
public double nivelDeSignificanciaEnLaNormal(double nivelSignificancia ){
	if(100<nivelSignificancia*100){
		nivelSignificancia=nivelSignificancia/100;
	}
	return tablaz.hallarZ(nivelSignificancia);
}
public double pruebaDeHipotesisDosColasEstandarizada(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia, double n, double N){
	double estandarizacion;
	if (N==0) {
		estandarizacion= this.estandatizarMediaMuestra(mediaH0, valorCorrector, desviacionEstandar,n);
	}
	else{
		estandarizacion= this.estandatizarMediaMuestra(mediaH0, valorCorrector, desviacionEstandar,n,N);
	}

	double z = nivelDeSignificanciaEnLaNormal(nivelSignificancia/2);
	if (z*-1 < estandarizacion || estandarizacion < z   ) {
		return z;
	}
	return 0;	
}
public double pruebaDeHipotesisUnaColasEstandarizadaIzquierda(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia, double n, double N){
	double estandarizacion;
	if (N==0) {
		estandarizacion= this.estandatizarMediaMuestra(mediaH0, valorCorrector, desviacionEstandar,n);
	}
	else{
		estandarizacion= this.estandatizarMediaMuestra(mediaH0, valorCorrector, desviacionEstandar,n,N);
	}
	if (nivelSignificancia < 0.5) {
		double z = nivelDeSignificanciaEnLaNormal(0.5-nivelSignificancia);
		if (z < estandarizacion   ) {
			return 1;
		} 
		return 0;
	}
	else{
		double z = nivelDeSignificanciaEnLaNormal(1-nivelSignificancia);
		if (z < estandarizacion   ) {
			return 1;
		} 
		return 0;
	}
		
}
public double pruebaDeHipotesisUnaColasEstandarizadaDerecha(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia, double n, double N){
	double estandarizacion;
	if (N==0) {
		estandarizacion= this.estandatizarMediaMuestra(mediaH0, valorCorrector, desviacionEstandar,n);
	}
	else{
		estandarizacion= this.estandatizarMediaMuestra(mediaH0, valorCorrector, desviacionEstandar,n,N);
	}
	if (0.5 < nivelSignificancia ) {
		double z = nivelDeSignificanciaEnLaNormal(0.5-nivelSignificancia);
		if (   z < estandarizacion) {
			return 1;
		} 
		return 0;
	}
	else{
		double z = nivelDeSignificanciaEnLaNormal(1-nivelSignificancia);
		if (z < estandarizacion   ) {
			return 1;
		} 
		return 0;
	}
		
}
public double usarMultiplicacion(double n, double N){
	return n/N;
}
public double pruebaDeHipotesisUnaColasEstandarizada(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia, double cola, String lado, double n, double N){
	if (lado=="menor que") {
		
		
		return this.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(mediaH0, desviacionEstandar, valorCorrector, nivelSignificancia,n,N);
	}
	return this.pruebaDeHipotesisUnaColasEstandarizadaDerecha(mediaH0, desviacionEstandar, valorCorrector, nivelSignificancia,n,N);
}

public double pruebaDeHipotesisUnaColasEstandarizadaProporcion(double pH0, double valorCorrector, double nivelSignificancia, double cola, String lado, double n){
	if (lado=="menor que") {
		return this.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(pH0, this.calculoDelErrorEstandarDeLaProporcion(pH0, 1-pH0, n), valorCorrector, nivelSignificancia,n,0);
	}
	return this.pruebaDeHipotesisUnaColasEstandarizadaDerecha(pH0, this.calculoDelErrorEstandarDeLaProporcion(pH0, 1-pH0, n), valorCorrector, nivelSignificancia,n,0);
}
public double pruebaDeHipotesisDosColasEstandarizadaProp(double pH0, double n, double valorCorrector, double nivelSignificancia,   double N){
	return this.pruebaDeHipotesisDosColasEstandarizada(pH0, this.calculoDelErrorEstandarDeLaProporcion(pH0, 1-pH0, n), valorCorrector, nivelSignificancia,n,N);
}
//Funciones Auxiliares ////
public double estandatizarMediaMuestraProporcion(double p, double P, double n, double N ){
	double errorEstandar=calculoDelErrorEstandarDeLaProporcion(p,1-p,n,N);
	return this.estandatizarMediaMuestra(p, P, errorEstandar);
	
}
public double estandatizarMediaMuestraProporcion(double p, double P, double n ){
	double errorEstandar=calculoDelErrorEstandarDeLaProporcion(p,1-p,n);
	return this.estandatizarMediaMuestra(p, P, errorEstandar);
	
}
private double calculoDelErrorEstandarDeLaProporcion(double p, double q, double n, double N) {
	if(n/N < 0.05 ){
		return Math.sqrt((p*q)/n);
	}
	return  Math.sqrt((p*q)/n)*this.calcularMultiplicador(n, N);
}
//Calculo del error estandar 
private double calcularMultiplicador(double n, double N){
	double dividendo=N-n;
	double divisor= N-1;
	double division = dividendo/divisor;
	//return Math.sqrt(division); //sqrt((N-n)/(N-1))
	return division;
}

}
