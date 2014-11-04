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

public class Geometrica extends Activity {
	private TextView TextP;
	private TextView EditX;
	private TextView txtResultado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_geometrica);
		TextP = (TextView) this.findViewById(R.id.TextP);
		EditX = (TextView) this.findViewById(R.id.EditX);
		txtResultado = (TextView) this.findViewById(R.id.txtResultado);
		TextView btAceptar = (TextView) this.findViewById(R.id.btAceptar);
		 btAceptar.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					if (TextP.getText().toString().equals("") || EditX.getText().toString().equals("")) {
						MessageBox("Ingrese Datos");
					}
					else{
					double p;
					double x;
					p = Double.parseDouble(String.valueOf(EditX.getText()));
					x = Double.parseDouble(String.valueOf(TextP.getText()));
					 if (p>1){
						  MessageBox("p no puede ser mayor a 1");
					       }
					 else{
						 Funciones funcion = new Funciones();
						 DecimalFormat df = new DecimalFormat("0.0000"); 
						txtResultado.setText(String.valueOf(df.format(funcion.geometrica(p, x))));
					 }
					}
				}
			});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_geometrica, menu);
		return true;
	}
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
