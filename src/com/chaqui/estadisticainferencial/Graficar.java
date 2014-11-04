package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Graficar extends Activity {
	private EditText editText1;
	private EditText txtMedia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_graficar);
		 editText1 = (EditText) this.findViewById(R.id.editText1);
		 txtMedia = (EditText) this.findViewById(R.id.TxtMedia);
		Button aceptar =(Button)this.findViewById(R.id.button1);
		aceptar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), GraficaNormal.class);
				con.putExtra("media", txtMedia.getText().toString());
				con.putExtra("desviacion", editText1.getText().toString());
				startActivity(con);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_graficar, menu);
		return true;
	}

}
