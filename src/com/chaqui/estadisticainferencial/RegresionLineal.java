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
				char[] cadenaX = x.getText().toString().toCharArray();
				char[] cadenaY = y.getText().toString().toCharArray();
				String[] resultadoCor =regresion.calcularRegresionyCorrelacion(obtenerDatos(cadenaX), obtenerDatos(cadenaY));
				String res = "regresion:"+resultadoCor[0]+" correlacion:"+resultadoCor[1];
				resultado.setText(res);
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_regresion_lineal, menu);
		return true;
	}
	private double[] obtenerDatos(char[] cadena ){
		String numero = "";
		int n=0;
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i]==',') {
				n++;
			}
		}
		double[] lista = new double[n+1];
		n=0;
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i]==',') {
				lista[n]=Double.parseDouble(numero);
				numero="";
				n++;
			}
			else{
				numero.concat(String.valueOf(cadena[i]));
			}
		}
		lista[n]=Double.parseDouble(numero);
		return lista;
	}

}
