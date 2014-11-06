package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MenuEstadisticaBasica extends Activity {
	TextView TextView01;
	TextView textHiper;
	TextView textLineal;
	TextView textBiNegativa;
	TextView textGeometrica;
	TextView TextPoisson;
	TextView textView1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_estadistica_basica);
        TextView01 = (TextView) this.findViewById(R.id.TextView01);
        TextView01.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Binomial.class);
				startActivity(con);
			}
		});
        textHiper = (TextView) this.findViewById(R.id.TextView03);
        textHiper.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Hipergeometrica.class);
				startActivity(con);
			}
		});
        textLineal = (TextView) this.findViewById(R.id.textView1);
        textLineal.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				
			}
		});
        textBiNegativa = (TextView) this.findViewById(R.id.TextView04);
        textBiNegativa.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), BinomialNegativa.class);
				startActivity(con);
			}
		});
        textGeometrica = (TextView) this.findViewById(R.id.TextView05);
        textGeometrica.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Geometrica.class);
				startActivity(con);
			}
		});
        TextPoisson = (TextView) this.findViewById(R.id.TextView06);
        TextPoisson.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Poisson.class);
				startActivity(con);
			}
		});
        textView1 = (TextView) this.findViewById(R.id.textView1);
        textView1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Intent con = new Intent();
				con.setClass(getApplicationContext(), Lineal.class);
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
