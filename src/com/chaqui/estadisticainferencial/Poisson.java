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

public class Poisson extends Activity {
	private TextView TextK, EditX,txtResultado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poisson);
		TextK = (TextView) this.findViewById(R.id.TextK);
		EditX = (TextView) this.findViewById(R.id.EditX);
		txtResultado = (TextView) this.findViewById(R.id.txtResultado);
		 TextView btAceptar = (TextView) this.findViewById(R.id.btAceptar);
		 btAceptar.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					if (TextK.getText().toString().equals("") || EditX.getText().toString().equals("")) {
						MessageBox("Ingrese Datos");
					}
					else{
					double k, ocurrencia;
					k = Double.parseDouble(String.valueOf(TextK.getText()));
					ocurrencia = Double.parseDouble(String.valueOf(EditX.getText()));
					Funciones funcion = new Funciones();
					DecimalFormat df = new DecimalFormat("0.0000");
					txtResultado.setText(String.valueOf(df.format(funcion.poisson(k, ocurrencia))));
				}
				}
		 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_poisson, menu);
		return true;
	}
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
}
