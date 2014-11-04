package com.chaqui.estadisticainferencial;

import java.text.DecimalFormat;

import com.chaqui.calculos.Funciones;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Hipergeometrica extends Activity {

	private TextView TextN, TextX,Textk,txtResultado,BtAceptar,Textn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hipergeometrica);
		TextN = (TextView) this.findViewById(R.id.TextN);
		TextX = (TextView) this.findViewById(R.id.TextX);
		Textk = (TextView) this.findViewById(R.id.Textk);
		Textn = (TextView) this.findViewById(R.id.Textn);
		txtResultado = (TextView) this.findViewById(R.id.txtResultado);
		BtAceptar = (TextView) this.findViewById(R.id.BtAceptar);
		BtAceptar.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					if (TextN.getText().toString().equals("") || TextX.getText().toString().equals("") || Textk.getText().toString().equals("") || Textn.getText()=="") {
						MessageBox("Ingrese Datos");
					}
					else{
					double k,n,N,X;
					k = Double.parseDouble(String.valueOf(Textk.getText()));
					n = Double.parseDouble(String.valueOf(Textn.getText()));
					N = Double.parseDouble(String.valueOf(TextN.getText()));
					X = Double.parseDouble(String.valueOf(TextX.getText()));
					Funciones funcion = new Funciones();
					MessageBox("click()");
					DecimalFormat df = new DecimalFormat("0.0000"); 
					txtResultado.setText(String.valueOf(df.format(funcion.hipergeometrica(X, N, n, k))));
				}
				}
		 });
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_hipergeometrica, menu);
		return true;
	}
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
