package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class Inicio extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		 TextView GrafCurva = (TextView) this.findViewById(R.id.GrafCurva);
		 GrafCurva.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent con = new Intent();
					con.setClass(getApplicationContext(), Graficar.class);
					startActivity(con);
				}
			});
		 TextView TextView01 = (TextView) this.findViewById(R.id.TextView01);
		 TextView01.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent con = new Intent();
					con.setClass(getApplicationContext(), MenuEstadisticaBasica.class);
					startActivity(con);
				}
			});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inicio, menu);
		return true;
	}
}
