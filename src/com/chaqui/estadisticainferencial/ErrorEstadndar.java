package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.chaqui.calculos.EstadisticaInferencial;

public class ErrorEstadndar extends Activity {
	private EditText desviacion;
	private EditText n;
	private EditText N;
	private EditText resultado;
	private Button boton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_error_estadndar);
		desviacion = (EditText) this.findViewById(R.id.TextDesviacion);
		n = (EditText) this.findViewById(R.id.txtn);
		N = (EditText) this.findViewById(R.id.txtN);
		boton =(Button) this.findViewById(R.id.btAceptar);
		resultado = (EditText) this.findViewById(R.id.txtResultado);
		boton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EstadisticaInferencial inferencial  = new EstadisticaInferencial();
				if (n.getText().toString()=="" && N.getText().toString()=="") {
					MessageBox("Porfavor ingrese la muestra y/o la poblacion");
				}
				else{
					if(n.getText().toString()!=""){
						double nDoble = Double.valueOf(n.getText().toString());
						if (N.getText().toString()!="") {
							double NDoble =Double.valueOf(n.getText().toString());
							double desDoble = Double.valueOf(desviacion.getText().toString());
							double res =inferencial.calcularErrorEstandar(desDoble, nDoble, NDoble);
							resultado.setText(String.valueOf(res));
						}
						else{
							double desDoble = Double.valueOf(desviacion.getText().toString());
							double res =inferencial.calcularErrorEstandar(desDoble, nDoble);
							resultado.setText(String.valueOf(res));
						}
					}
					else{
						MessageBox("Porfavor ingrese la muestra");
					}
				}
			}


		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_error_estadndar, menu);
		return true;
	}
	public void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
		}

}
