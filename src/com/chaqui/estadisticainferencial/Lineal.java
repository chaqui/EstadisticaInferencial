package com.chaqui.estadisticainferencial;

import java.text.DecimalFormat;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Lineal extends Activity {
	private TextView EditXb,txtResultado;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lineal);
		EditXb = (TextView) this.findViewById(R.id.EditXb);
		txtResultado = (TextView) this.findViewById(R.id.txtResultado);
		 TextView btAceptar = (TextView) this.findViewById(R.id.btAceptar);
		 btAceptar.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					if (EditXb.getText().toString().equals("") ) {
						MessageBox("Ingrese Datos");
					}
					else{
						DecimalFormat df = new DecimalFormat("0.0000");
					txtResultado.setText(String.valueOf(df.format(1/Double.parseDouble(String.valueOf(EditXb.getText())))));
					}
					
				}
		 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lineal, menu);
		return true;
	}
	private void MessageBox(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

}
