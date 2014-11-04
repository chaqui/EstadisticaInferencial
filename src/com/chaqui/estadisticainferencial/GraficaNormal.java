package com.chaqui.estadisticainferencial;

import android.app.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;

import com.androidplot.xy.*;

import java.util.Arrays;
import com.chaqui.calculos.*;


public class GraficaNormal extends Activity {

	private double desviacion;
	private double media;
	private XYPlot plot;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
 
        // fun little snippet that prevents users from taking screenshots
        // on ICS+ devices :-)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                                 WindowManager.LayoutParams.FLAG_SECURE);
 
        setContentView(R.layout.activity_grafica_normal);
        Bundle recogerDatos = getIntent().getExtras();
        this.media = Double.valueOf(recogerDatos.getString("media"));
        this.desviacion = Double.valueOf(recogerDatos.getString("desviacion"));
        // initialize our XYPlot reference:
        plot = (XYPlot) findViewById(R.id.mySimpleXYPlot);
 
        // Create a couple arrays of y-values to plot:
        CampanaGauss campana = new CampanaGauss(this.media,this.desviacion);
        campana.calcular();
        Double[] x = campana.getDatosX();
        Double[] y = campana.getDatosY();
        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(x),          // SimpleXYSeries takes a List so turn our array into a List
                Arrays.asList(y), // Y_VALS_ONLY means use the element index as the x value
                "Campana");                             // Set the display title of the series
 
        // same as above
        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.GREEN, Color.BLUE, null);

 
        // add a new series' to the xyplot:
        plot.addSeries(series1, series1Format);
 
        // same as above:
        
        // reduce the number of range labels
        plot.setTicksPerRangeLabel(3);
        plot.getGraphWidget().setDomainLabelOrientation(-45);
 
    }

}
