package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
public class Inicio extends Activity {
	private TextView GrafCurva;
	private TextView TextView1;
	private TextView TextView2;
	private TextView TextView5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		 GrafCurva = (TextView) this.findViewById(R.id.GrafCurva);
		 GrafCurva.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View v) {
					Intent con = new Intent();
					con.setClass(getApplicationContext(), Graficar.class);
					startActivity(con);
				}
			});
		 TextView1 = (TextView) this.findViewById(R.id.textView1);
		 TextView1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), MenuEstadisticaBasica.class);
				startActivity(con);
				
			}
		});
		 TextView2 = (TextView) this.findViewById(R.id.textView2);
		 TextView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), MenuEstadisticaInferencial.class);
				startActivity(con);
				
			}
		});
		 TextView5 = (TextView) this.findViewById(R.id.textView5);
		 TextView5.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), RegresionLineal.class);
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
