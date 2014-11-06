package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.chaqui.calculos.EstadisticaInferencial;

public class Intervalos extends Activity {
	private EditText media;
	private EditText z;
	private EditText desviacion;
	private EditText muestra;
	private TextView resultado;
	private Button aceptar;
	private EstadisticaInferencial estadistica= new EstadisticaInferencial();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intervalos);
		media = (EditText) this.findViewById(R.id.txtMedia);
		z = (EditText) this.findViewById(R.id.z);
		desviacion = (EditText) this.findViewById(R.id.desviacion);
		muestra = (EditText) this.findViewById(R.id.muestra);
		resultado= (TextView) this.findViewById(R.id.resultado);
		aceptar = (Button) this.findViewById(R.id.aceptar);
		
		aceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				double doubleMedia = Double.parseDouble(media.getText().toString());
				double doubleZ = Double.parseDouble(z.getText().toString());
				double doubledesviacion = Double.parseDouble(desviacion.getText().toString());
				double doublemuestra = Double.parseDouble(muestra.getText().toString());
				resultado.setText(String.valueOf(estadistica.calcularIntervalos(doubleMedia, doubleZ, doubledesviacion, doublemuestra)));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_intervalos, menu);
		return true;
	}

}
