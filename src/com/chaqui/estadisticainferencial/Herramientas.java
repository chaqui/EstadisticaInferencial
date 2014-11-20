package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Herramientas extends Activity {
	TextView textView1;
	TextView textView2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_herramientas);
		textView1 = (TextView) this.findViewById(R.id.textView1);
		textView1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Graficar.class);
				startActivity(con);
			}
		});
		textView2 = (TextView) this.findViewById(R.id.textView2);
		textView2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Calculadora.class);
				startActivity(con);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_herramientas, menu);
		return true;
	}

}
