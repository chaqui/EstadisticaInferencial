package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaqui.calculos.EstadisticaInferencial;
import com.chaqui.calculos.tablas.TablaZ;

public class EstimacionPorProporcion extends Activity {
	private EditText textP;
	private EditText textp;
	private EditText txtn;
	private EditText TextN;
	private Button btAceptar;
	private TextView respuesta;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estimacion_por_proporcion);
		textP = (EditText) findViewById(R.id.textP);
		textp = (EditText) findViewById(R.id.textp);
		txtn = (EditText) findViewById(R.id.txtn);
		TextN = (EditText) findViewById(R.id.TextN);
		respuesta = (TextView) findViewById(R.id.respuesta);
		btAceptar = (Button) findViewById(R.id.btAceptar);
		btAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {		
				if (textP.getText().toString()=="" || textp.getText().toString()=="" || txtn.getText().toString()==""){
					MessageBox("Hacen falta datos para el calculo");
				}
				else{
					EstadisticaInferencial inferencial = new EstadisticaInferencial();
					TablaZ tabla = new TablaZ();
					double P = Double.parseDouble(textP.getText().toString());
					double p = Double.parseDouble(textp.getText().toString());
					double n = Double.parseDouble(txtn.getText().toString());
					
					if (TextN.getText().toString()=="") {
						double res=inferencial.estandatizarMediaMuestraProporcion(P, p, n);
						respuesta.setText(String.valueOf(tabla.hallarArea(res)));
					}
					else{
						double N = Double.parseDouble(TextN.getText().toString());
						double res=inferencial.estandatizarMediaMuestraProporcion(P, p, n,N);
						respuesta.setText(String.valueOf(tabla.hallarArea(res)));
					}
				}
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_estimacion_por_proporcion,
				menu);
		return true;
	}
	public void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		}
}
