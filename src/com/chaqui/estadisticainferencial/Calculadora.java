package com.chaqui.estadisticainferencial;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Calculadora extends Activity {
	boolean suma=true;
	boolean resta;
	boolean multiplicacion;
	boolean division;
	boolean raiz;
	boolean elevacion;
	boolean bandera=true;
	boolean otro;
	float total=0;
	String num;
	String num2;
	float totalr;
	float base;
	double total2;
	private TextView numero = (TextView)findViewById(R.id.txtViewNumero);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculadora);
	     //----Conexion con las vistas-----
        //Boton 0---
        View Boton0=findViewById(R.id.Bt0);
        //Boton 1---
        View Boton01=findViewById(R.id.BtUno);
        //Boton 2---
        View Boton02=findViewById(R.id.Bt2);
        //Boton 3---
        View Boton03=findViewById(R.id.Bt03);
        //Boton 4---
        View Boton04=findViewById(R.id.Bt4);
        //Boton 5---
        View Boton05=findViewById(R.id.Bt5);
        //Boton 6---
        View Boton06=findViewById(R.id.Bt6);
        //Boton 7---
        View Boton07=findViewById(R.id.Bt7);
        //Boton 8---
        View Boton08=findViewById(R.id.Bt8);
        //Boton 9---
        View Boton09=findViewById(R.id.Bt9);
        //Boton +---
        View BotonMas=findViewById(R.id.IdMas);
        //Boton ----
        View BotonMenos=findViewById(R.id.BtMenis);
        //Boton *---
        View BotonPor=findViewById(R.id.BtPor);
        //Boton /---
        View BotonDivision=findViewById(R.id.BtDivision);
      //Boton .---
        View BotonPunto=findViewById(R.id.BtPunto);
      //Boton Ac---
        View BotonAC=findViewById(R.id.BtAc);
      //Boton C---
        View BotonC=findViewById(R.id.BtC);
      //Boton Pow---
        View BotonPow=findViewById(R.id.BtPo);
      //Boton R---
        View BotonRaiz=findViewById(R.id.BtRaiz);
      //Boton Igual
        View BotonIgual=findViewById(R.id.Btigual);
        //Conexiones con los botones
        Boton0.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("0");	
				
			}
		});
        Boton01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("1");	
				
			}
		});
        Boton02.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("2");	
				
			}
		});
        Boton03.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("3");	
				
			}
		});
        Boton04.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("4");	
				
			}
		});
        Boton05.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("5");	
				
			}
		});
        Boton06.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("6");	
				
			}
		});
        Boton07.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("7");	
				
			}
		});
        Boton08.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("8");	
				
			}
		});
        Boton09.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero("9");	
				
			}
		});
        BotonMas.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				suma=true;
				bandera=true;
			}
		});
        BotonMenos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				resta=true;
				bandera=true;
			}
		});
        BotonAC.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				numero.setText(" ");
				total=0;
				totalr=0;
			}
		});
        BotonC.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				num=numero.getText().toString();
				int a=num.length();
				a=a-1;
			}
		});
        BotonPunto.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cargarnumero(".");	
				
			}
		});
        BotonPow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				elevacion=true;
				bandera=true;
			}
		});
        BotonRaiz.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				raiz=true;
				bandera=true;
			}
		});
        BotonPor.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				multiplicacion=true;
				bandera=true;
			}
		});
        BotonDivision.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				division=true;
				bandera=true;
			}
		});
        BotonIgual.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				bandera=true;
				total=0;
				totalr=0;
			}
		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculadora, menu);
		return true;
	}
	  public void cargarnumero(String numero1)
	    {
	    	
			
			if (bandera==false)
			{
				num=numero.getText().toString();
				num2=num.concat(numero1);
				numero.setText(String.valueOf(num2));
			}
	    	if(bandera)
			{
				numero.setText(String.valueOf(numero1) );
				bandera=false;
			}
	    }
	    
		
		
		public float operacion(float num)
		{

			if (suma==true)
			{
				total= total+num;
			}
			else
			{
				if(resta==true)
				{
					total=total-num;
				}
				else
				{
					if(multiplicacion==true)
					{
						total=total*num;
					}
					else
					{
						if(division==true)
						{
							total=total/num;
						}
						else
						{
							if(raiz==true)
							{
								double numd=Double.valueOf(num);
								double totalq=(Math.sqrt(numd));
								total=Double.valueOf(totalq).floatValue();
							}
							else
							{
								if(elevacion=true)
								{
									total=Double.valueOf(Math.pow(Float.valueOf(total).doubleValue(),Float.valueOf(num).doubleValue())).floatValue();
								}
								else
								{
									if (total==0)
									{
										total=num;
									}
								}
							}
						}
					}
				}
			}
			suma=false;
			resta=false;
			multiplicacion=false;
			division=false;
			raiz=false;
			elevacion=false;
			return total;
			
		}
	    
	}