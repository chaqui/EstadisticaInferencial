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
import android.widget.Toast;

import com.chaqui.calculos.EstadisticaInferencial;

public class PruebaHipotesis extends Activity {
	private Spinner sp;
	private String tipoDeHipo;
	private EditText hipNula;
	private EditText medMuestra;
	private EditText significanciatxt;
	private EditText txDesviacion;
	private EditText txtn;
	private EditText textN;
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
		txtn = (EditText) findViewById(R.id.txtn);
		textN = (EditText) findViewById(R.id.textN);
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
				try {
					if (hipNula.getText().toString().equals("") || medMuestra.getText().toString().equals("") || 
							significanciatxt.getText().toString().equals("") || txDesviacion.getText().toString().equals("")
							|| txtn.getText().toString().equals("")) {
							MessageBox("faltan datos");
					}
					else {
						double hipotesis= Double.valueOf(hipNula.getText().toString());
						double real= Double.valueOf(medMuestra.getText().toString());
						double significancia= Double.valueOf(significanciatxt.getText().toString());
						double desviacionEstandar= Double.valueOf(txDesviacion.getText().toString());
						double res=0;
						double n=  Double.valueOf(txtn.getText().toString());
						EstadisticaInferencial estadistica = new EstadisticaInferencial();
						if (textN.getText().toString().equals("")) {
							if (tipoDeHipo.equals("=")) {
								res=estadistica.pruebaDeHipotesisDosColasEstandarizada(hipotesis, desviacionEstandar, real, significancia, n, 0);
							
							}
							else if (tipoDeHipo.equals("menor que")) {
								res= estadistica.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(hipotesis, desviacionEstandar, real, significancia, n, 0);
								
							}
							else if (tipoDeHipo.equals("mayor que")) {
								res= estadistica.pruebaDeHipotesisUnaColasEstandarizadaDerecha(hipotesis, desviacionEstandar, real, significancia, n, 0);
							}
							respuesta.setText(String.valueOf(res));
						}
						else{
							double N=  Double.valueOf(textN.getText().toString());
							if (tipoDeHipo.equals("=")) {
								res=estadistica.pruebaDeHipotesisDosColasEstandarizada(hipotesis, desviacionEstandar, real, significancia, n, N);
							
							}
							else if (tipoDeHipo.equals("menor que")) {
								res= estadistica.pruebaDeHipotesisUnaColasEstandarizadaIzquierda(hipotesis, desviacionEstandar, real, significancia, n, N);
								
							}
							else if (tipoDeHipo.equals("mayor que")) {
								res= estadistica.pruebaDeHipotesisUnaColasEstandarizadaDerecha(hipotesis, desviacionEstandar, real, significancia, n, N);
							}
							respuesta.setText(String.valueOf(res));
						}
						
					}
					
					//if (res==1) {
					//respuesta.setText("aceptada");
					//}
					//else{
						//respuesta.setText("rechazada");
					//}
				} catch (Exception e) {
					// TODO: handle exception
					MessageBox("algo salio mal :(");
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
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
