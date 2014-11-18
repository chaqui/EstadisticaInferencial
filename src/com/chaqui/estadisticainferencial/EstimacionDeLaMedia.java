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

public class EstimacionDeLaMedia extends Activity {
	private	EditText txtmuestra;
	private	EditText txtpoblacion;
	private	EditText txtMediaMuestral;
	private	EditText txtMediaPoblacional;
	private	EditText txtDesvMuestral;
	private TextView lbResultado;
	EstadisticaInferencial estadistica = new EstadisticaInferencial();
	TablaZ tabla = new TablaZ();
	private Button botonAceptar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estimacion_de_la_media);
		txtmuestra = (EditText) this.findViewById(R.id.muestra);
		txtpoblacion = (EditText) this.findViewById(R.id.poblacion);
		txtMediaMuestral = (EditText) this.findViewById(R.id.medMuestra);
		txtMediaPoblacional = (EditText) this.findViewById(R.id.mePoblacion);
		txtDesvMuestral = (EditText) this.findViewById(R.id.desvPoblacional);
		botonAceptar = (Button) this.findViewById(R.id.btAceptar);
		lbResultado = (TextView) this.findViewById(R.id.lbResultado);
		botonAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if(txtmuestra.getText().toString().equals("")  ||
						txtMediaMuestral.getText().equals("") || txtMediaPoblacional.getText().equals("") || txtDesvMuestral.getText().toString().equals("") ){
					MessageBox("Porfavor ingrese los valores");
				}
				else{
					double dbMuestra = Double.valueOf(txtmuestra.getText().toString());
					double dbMediaMuestral = Double.valueOf(txtMediaMuestral.getText().toString());
					double dbMediaPoblacional = Double.valueOf(txtMediaPoblacional.getText().toString());
					double dbDesvMuestral = Double.valueOf(txtmuestra.getText().toString());
					if (!txtpoblacion.getText().toString().equals("")) {
						double dbPoblacion = Double.valueOf(txtpoblacion.getText().toString());
								
						double resultado = estadistica.estandatizarMediaMuestra(dbMediaMuestral, dbMediaPoblacional, dbDesvMuestral, dbMuestra, dbPoblacion);
						lbResultado.setText(String.valueOf(tabla.hallarArea(resultado)));
					}
					else{
						double resultado = estadistica.estandatizarMediaMuestra(dbMediaMuestral, dbMediaPoblacional, dbDesvMuestral, dbMuestra);
						lbResultado.setText(String.valueOf(tabla.hallarArea(resultado)));
					}
				}
			}

			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_estimacion_de_la_media, menu);
		return true;
	}
	public void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		}

}
