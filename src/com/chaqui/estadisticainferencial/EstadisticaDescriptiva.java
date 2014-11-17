package com.chaqui.estadisticainferencial;

import com.chaqui.calculos.CalEstadisticaDescriptiva;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EstadisticaDescriptiva extends Activity {
	private EditText txContenido;
	private TextView resultado;
	private Button btAceptar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_estadistica_descriptiva);
		txContenido = (EditText) this.findViewById(R.id.txContenido);
		resultado =(TextView) this.findViewById(R.id.resultado);
		btAceptar= (Button) this.findViewById(R.id.btAceptar);
		btAceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				CalEstadisticaDescriptiva estadistica = new CalEstadisticaDescriptiva();
				try {
					String contenido = txContenido.getText().toString();
					resultado.setText(estadistica.calcular(contenido));
				} catch (Exception e) {
					// TODO: handle exception
					MessageBox("algo paso mal retifique datos");
				}
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.activity_estadistica_descriptiva, menu);
		return true;
	}
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
