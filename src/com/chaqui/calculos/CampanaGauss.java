package com.chaqui.calculos;

public class CampanaGauss {
	private Double media;
    private Double desviacionEstandar;
    private Double[] datosX= new Double[13];
    private Double[] datosY= new Double[13];
    public CampanaGauss(Double media, Double desviacionEstandar){
        this.media=media;
        this.desviacionEstandar=desviacionEstandar;
    }
    
    public void calcular(){
        int i=0;
        Double xInicial=this.desviacionEstandar/2;
        Double x=media-(3*this.desviacionEstandar);
        do {
            this.datosX[i]=x;
            this.datosY[i]=this.calcularFuncion(x);
            x=x+xInicial;
            i++;
            
        } while (x<= media+(3*this.desviacionEstandar));
        
    }
    private Double calcularElevacion(Double x){
        Double mediamenosdesviacion= x-this.media;
        Double division = (mediamenosdesviacion/this.desviacionEstandar);
        Double elevacion = Math.pow(division, 2);
        return -0.5*elevacion;
    }
    public Double calcularFuncion(Double x){
        Double divisor= Math.sqrt(2*Math.PI)*this.desviacionEstandar;
        Double multiplicador = Math.exp(this.calcularElevacion(x));
        System.out.println(1/divisor);
        System.out.println(multiplicador);
        return (1/divisor)*multiplicador;
    }        
    /**
     * @return the datosX
     */
    public Double[] getDatosX() {
        return datosX;
    }

    /**
     * @return the datosY
     */
    public Double[] getDatosY() {
        return datosY;
    }
}
