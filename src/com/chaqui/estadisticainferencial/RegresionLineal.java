package com.chaqui.estadisticainferencial;

import com.chaqui.calculos.RegresionLinealCalculos;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegresionLineal extends Activity {
	private EditText x;
	private  EditText y;
	private TextView resultado;
	private Button aceptar;
	private int tamanox, tamanoy;
	private int tamano;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regresion_lineal);
		x = (EditText) this.findViewById(R.id.x);
		y = (EditText) this.findViewById(R.id.y);
		resultado = (TextView) this.findViewById(R.id.resultado);
		aceptar = (Button) this.findViewById(R.id.button1);
		aceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				RegresionLinealCalculos regresion = new RegresionLinealCalculos();
				String cadenaX = x.getText().toString();
				String cadenaY = y.getText().toString();
				double[] x =obtenerDatos(cadenaX);
				tamanox=tamano;
				double[] y =obtenerDatos(cadenaY);
				tamanoy=tamano;
				if(tamanox==tamanoy){
				String[] resultadoCor =regresion.calcularRegresionyCorrelacion(x, y);
				String res = "regresion:"+resultadoCor[0]+" correlacion:"+resultadoCor[1];
				resultado.setText(res);
				}
				
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_regresion_lineal, menu);
		return true;
	}
	private double[] obtenerDatos(String cadena ){
		try{
		 int a=0;
	        int n=0;
	        String numero ="a";
	        char[] cadenaArray=cadena.toCharArray();
	        for (int i = 0; i < cadenaArray.length; i++) {
	            if(cadenaArray[i] == ','){
	                n++;
	            }
	        }
	        n++;
	        tamano=n;
	        double[] numeros=new double[n];
	        n=0;
	        for (int i = 0; i < cadenaArray.length; i++) {
	            if(cadenaArray[i] != ','){
	                System.out.println(cadenaArray[i]);
	                if(a==0){
	                numero=String.valueOf(cadenaArray[i]);
	                a=1;
	                }
	                else{
	                     numero=numero+String.valueOf(cadenaArray[i]);
	                }
	                
	            }
	            else{
	                System.out.println("else");
	                System.out.println(numero);
	                numeros[n]=Double.valueOf(numero);
	                n++;
	                numero="";
	                a=0;
	            }
	        }
	        return numeros;
		}catch(Exception e) {
			return null;
		}
	}

}
