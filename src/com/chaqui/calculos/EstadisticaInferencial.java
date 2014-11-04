package com.chaqui.calculos;
public class EstadisticaInferencial {
	
	
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

public double[] calcularIntervalos(double media, double z,double desviacionEstandar, double N, double n){
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
	return nivelSignificancia/2;
}
public double pruebaDeHipotesisDosColasEstandarizada(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia){
	double estandarizacion= this.estandatizarMediaMuestra(valorCorrector, mediaH0, desviacionEstandar);
	double z = nivelDeSignificanciaEnLaNormal(nivelSignificancia);
	if (estandarizacion < z || z < estandarizacion   ) {
		return 1;
	}
	return 0;	
}
public double pruebaDeHipotesisUnaColasEstandarizadaIzquierda(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia){
	double estandarizacion= this.estandatizarMediaMuestra(valorCorrector, mediaH0, desviacionEstandar);
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
public double pruebaDeHipotesisUnaColasEstandarizadaDerecha(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia){
	double estandarizacion= this.estandatizarMediaMuestra(valorCorrector, mediaH0, desviacionEstandar);
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

public double pruebaDeHipotesisUnaColasEstandarizada(double mediaH0, double desviacionEstandar, double valorCorrector, double nivelSignificancia, double cola, String lado){
	if (lado=="menor que") {
		return this.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(mediaH0, desviacionEstandar, valorCorrector, nivelSignificancia);
	}
	return this.pruebaDeHipotesisUnaColasEstandarizadaDerecha(mediaH0, desviacionEstandar, valorCorrector, nivelSignificancia);
}

public double pruebaDeHipotesisUnaColasEstandarizadaProporcion(double pH0, double valorCorrector, double nivelSignificancia, double cola, String lado, double n){
	if (lado=="menor que") {
		return this.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(pH0, this.calculoDelErrorEstandarDeLaProporcion(pH0, 1-pH0, n), valorCorrector, nivelSignificancia);
	}
	return this.pruebaDeHipotesisUnaColasEstandarizadaDerecha(pH0, this.calculoDelErrorEstandarDeLaProporcion(pH0, 1-pH0, n), valorCorrector, nivelSignificancia);
}
public double pruebaDeHipotesisDosColasEstandarizadaProp(double pH0, double n, double valorCorrector, double nivelSignificancia){
	return this.pruebaDeHipotesisDosColasEstandarizada(pH0, this.calculoDelErrorEstandarDeLaProporcion(pH0, 1-pH0, n), valorCorrector, nivelSignificancia);
}
//Funciones Auxiliares ////

//Calculo del error estandar 
private double calcularMultiplicador(double n, double N){
	
	return Math.sqrt((N-n)/(N-1)); //sqrt((N-n)/(N-1))
}

}
