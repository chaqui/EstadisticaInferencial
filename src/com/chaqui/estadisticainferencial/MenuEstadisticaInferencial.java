package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MenuEstadisticaInferencial extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_estadistica_inferencial);
		TextView EstMedia = (TextView) findViewById(R.id.estMedia);
		EstMedia.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent con = new Intent();
				con.setClass(getApplicationContext(), EstimacionDeLaMedia.class);
				startActivity(con);
			}
		});
		
		TextView distNormal = (TextView) findViewById(R.id.distNormal);
		distNormal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Normal.class);
				startActivity(con);
			}
		});
		
		TextView errorEstanda = (TextView) findViewById(R.id.errorEstanda);
		errorEstanda.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent con = new Intent();
				con.setClass(getApplicationContext(), ErrorEstadndar.class);
				startActivity(con);
			}
		});
		
		TextView EstProp = (TextView) findViewById(R.id.EstProp);
		EstProp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent con = new Intent();
				con.setClass(getApplicationContext(), EstimacionPorProporcion.class);
				startActivity(con);
			}
		});
		
		TextView Intervalos = (TextView) findViewById(R.id.Intervalos);
		Intervalos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Intervalos.class);
				startActivity(con);
			}
		});
		
		TextView PHipotesis = (TextView) findViewById(R.id.PHipotesis);
		PHipotesis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent con = new Intent();
				con.setClass(getApplicationContext(), PruebaHipotesis.class);
				startActivity(con);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_menu_estadistica_inferencial,
				menu);
		return true;
	}

}
