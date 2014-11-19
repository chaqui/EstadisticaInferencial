package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class Inicio extends TabActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inicio);
		TabHost tabs= getTabHost();
		tabs.setup();
		
		Intent intent	 = new Intent().setClass(this, MenuEstadisticaBasica.class);
		TabHost.TabSpec spec = tabs.newTabSpec("Probabilidad");
		spec.setIndicator("Probabilidad");
		spec.setContent(intent);
		tabs.addTab(spec);
		
		intent = new Intent().setClass(this, MenuEstadisticaInferencial.class);
		spec = tabs.newTabSpec("Inferencial");
		spec.setIndicator("Inferencial");
		spec.setContent(intent);
		tabs.addTab(spec);
		
		intent = new Intent().setClass(this, EstadisticaDescriptiva.class);
		spec = tabs.newTabSpec("Descriptiva");
		spec.setIndicator("Descriptiva");
		spec.setContent(intent);
		tabs.addTab(spec);
		
		intent = new Intent().setClass(this, Herramientas.class);
		spec = tabs.newTabSpec("Herramientas");

		spec.setIndicator("Herramientas");
		spec.setContent(intent);
		tabs.addTab(spec);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_inicio, menu);
		return true;
	}
}
