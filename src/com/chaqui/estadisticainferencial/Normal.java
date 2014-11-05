package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import com.chaqui.calculos.EstadisticaInferencial;
import com.chaqui.calculos.tablas.TablaZ;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Normal extends Activity {
	private EditText txtMediaNorma;
	private EditText txtDesviacion;
	private EditText txtx;
	private EditText txtResultado;
	private Button button1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_normal);
		txtMediaNorma = (EditText) this.findViewById(R.id.txtMediaNorma);
		txtDesviacion = (EditText) this.findViewById(R.id.txtDesviacion);
		txtx = (EditText) this.findViewById(R.id.txtx);
		txtResultado = (EditText) this.findViewById(R.id.txtResultado);
		button1 = (Button) this.findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				double media = Double.valueOf(txtMediaNorma.getText().toString());
				double desviacion = Double.valueOf(txtDesviacion.getText().toString());
				double x = Double.valueOf(txtx.getText().toString());
				EstadisticaInferencial fn = new EstadisticaInferencial();
				TablaZ tabla = new TablaZ();
				double resultado=tabla.hallarArea(fn.estandatizarMediaMuestra(x, media, desviacion));
				txtResultado.setText(String.valueOf(resultado));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_normal, menu);
		return true;
	}

}
