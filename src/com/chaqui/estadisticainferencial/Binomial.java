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

public class Binomial extends Activity {

	private TextView TextPb, editNb,EditXb,txtResultado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_binomial);
		 TextPb = (TextView) this.findViewById(R.id.TextPb);
		 editNb = (TextView) this.findViewById(R.id.editNb);
		 EditXb = (TextView) this.findViewById(R.id.EditXb);
		 txtResultado = (TextView) this.findViewById(R.id.txtResultado);
		 TextView btAceptar = (TextView) this.findViewById(R.id.btAceptar);
		 btAceptar.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					double p,N,x;
					if (TextPb.getText().toString().equals("")|| editNb.getText().toString().equals("") || EditXb.getText().toString().equals("")) {
						MessageBox("Ingrese Datos");
					}
					else{
					p = Double.parseDouble(String.valueOf(TextPb.getText()));
					N = Double.parseDouble(String.valueOf(editNb.getText()));
					
					x = Double.parseDouble(String.valueOf(EditXb.getText()));
					MessageBox(String.valueOf(x));
					if (p>1) {
						MessageBox("p no puede ser mayor a 1");
					}
					else if(x>N){
						MessageBox("x no puede ser mayor a N");
		            }
					else{
						Funciones funcion = new Funciones();
						DecimalFormat df = new DecimalFormat("0.0000"); 
						txtResultado.setText(String.valueOf(df.format(funcion.bimonial(x, N, p))));
					}
//					ps=String.valueOf(TextPb.getText());
//					txtResultado.setText(ps+" "+editNb.getText()+" "+EditXb.getText());
					
				}
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_binomial, menu);
		return true;
	}
	
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}
}
