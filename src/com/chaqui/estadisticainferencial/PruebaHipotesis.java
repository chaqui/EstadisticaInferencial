package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.chaqui.calculos.EstadisticaInferencial;

public class PruebaHipotesis extends Activity {
	private Spinner sp;
	private String tipoDeHipo;
	private EditText hipNula;
	private EditText medMuestra;
	private EditText significanciatxt;
	private EditText txDesviacion;
	private TextView respuesta;
	private Button aceptar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prueba_hipotesis);
		hipNula = (EditText) findViewById(R.id.hipNula);
		medMuestra = (EditText) findViewById(R.id.medMuestra);
		significanciatxt = (EditText) findViewById(R.id.NivelSIgnificancia);
		txDesviacion = (EditText) findViewById(R.id.txtDesviacion);
		respuesta = (TextView) findViewById(R.id.respuesta);
		sp = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter array= ArrayAdapter.createFromResource(this, R.array.hipo, android.R.layout.simple_spinner_item);
		array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(array);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentView, View selectedItemView,
					int position, long id) {
				tipoDeHipo= parentView.getItemAtPosition(position).toString();
				
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		aceptar =(Button) findViewById(R.id.btAceptar);
		aceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				double hipotesis= Double.valueOf(hipNula.getText().toString());
				double real= Double.valueOf(medMuestra.getText().toString());
				double significancia= Double.valueOf(significanciatxt.getText().toString());
				double desviacionEstandar= Double.valueOf(txDesviacion.getText().toString());
				double res=0;
				EstadisticaInferencial estadistica = new EstadisticaInferencial();
				if (tipoDeHipo=="=") {
					res=estadistica.pruebaDeHipotesisDosColasEstandarizada(hipotesis, desviacionEstandar, real, significancia);
					
				}
				else if (tipoDeHipo=="menor que ") {
					res= estadistica.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(hipotesis, desviacionEstandar, real, significancia);
			
				}
				else if (tipoDeHipo=="mayor que") {
					res= estadistica.pruebaDeHipotesisUnaColasEstandarizadaDerecha(hipotesis, desviacionEstandar, real, significancia);
				}
				if (res==0) {
					respuesta.setText("aceptada");
				}
				else{
					respuesta.setText("rechazada");
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_prueba_hipotesis, menu);
		return true;
	}

}
