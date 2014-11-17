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
        Boton0.setOnClickListener((OnClickListener) this);
        Boton01.setOnClickListener((OnClickListener) this);
        Boton02.setOnClickListener((OnClickListener) this);
        Boton03.setOnClickListener((OnClickListener) this);
        Boton04.setOnClickListener((OnClickListener) this);
        Boton05.setOnClickListener((OnClickListener) this);
        Boton06.setOnClickListener((OnClickListener) this);
        Boton07.setOnClickListener((OnClickListener) this);
        Boton08.setOnClickListener((OnClickListener) this);
        Boton09.setOnClickListener((OnClickListener) this);
        BotonMas.setOnClickListener((OnClickListener) this);
        BotonMenos.setOnClickListener((OnClickListener) this);
        BotonAC.setOnClickListener((OnClickListener) this);
        BotonC.setOnClickListener((OnClickListener) this);
        BotonPunto.setOnClickListener((OnClickListener) this);
        BotonPow.setOnClickListener((OnClickListener) this);
        BotonRaiz.setOnClickListener((OnClickListener) this);
        BotonPor.setOnClickListener((OnClickListener) this);
        BotonDivision.setOnClickListener((OnClickListener) this);
        BotonIgual.setOnClickListener((OnClickListener) this);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calculadora, menu);
		return true;
	}
	  public void cargarnumero(String numero1)
	    {
	    	TextView numero = (TextView)findViewById(R.id.txtViewNumero);
			
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
	    
		public void onClick(View v) 
		{
			TextView numero = (TextView)findViewById(R.id.txtViewNumero);
			if(v.getId()==findViewById(R.id.BtAc).getId())
			{
				numero.setText(" ");
				total=0;
				totalr=0;
			}
			if(v.getId()==findViewById(R.id.Btigual).getId())
			{
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				bandera=true;
				total=0;
				totalr=0;
			}
			if(v.getId()==findViewById(R.id.BtC).getId())
			{
				num=numero.getText().toString();
				int a=num.length();
				a=a-1;
			}
			if(v.getId()==findViewById(R.id.Bt0).getId()){
					cargarnumero("0");			
			}
			if(v.getId()==findViewById(R.id.BtUno).getId()){
					cargarnumero("1");
				}	
			if(v.getId()==findViewById(R.id.Bt2).getId()){
					cargarnumero("2");
					}	
			if(v.getId()==findViewById(R.id.Bt03).getId())
			{
				cargarnumero("3");
			}	
						
			if(v.getId()==findViewById(R.id.Bt4).getId()){
				cargarnumero("4");
			}			
			if(v.getId()==findViewById(R.id.Bt5).getId()){
				cargarnumero("5");
			}			
			if(v.getId()==findViewById(R.id.Bt6).getId()){
				cargarnumero("6");
			}	
			if(v.getId()==findViewById(R.id.Bt7).getId()){
				cargarnumero("7");
			}
			if(v.getId()==findViewById(R.id.Bt8).getId()){
				cargarnumero("8");
			}	
			if(v.getId()==findViewById(R.id.Bt9).getId()){
				cargarnumero("9");
			}	
			if(v.getId()==findViewById(R.id.BtPunto).getId()){
				cargarnumero(".");
			}
			if(v.getId()==findViewById(R.id.IdMas).getId()){
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				suma=true;
				bandera=true;
			}
			if(v.getId()==findViewById(R.id.BtMenis).getId()){
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				resta=true;
				bandera=true;
			}
			if(v.getId()==findViewById(R.id.BtPor).getId())
			{
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				multiplicacion=true;
				bandera=true;
			}
			if(v.getId()==findViewById(R.id.BtDivision).getId())
			{
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				division=true;
				bandera=true;
			}
			if(v.getId()==findViewById(R.id.BtPo).getId())
			{
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				elevacion=true;
				bandera=true;
		}
			if(v.getId()==findViewById(R.id.BtRaiz).getId())
			{
				float num12;
				num12=Float.valueOf(numero.getText().toString());
				totalr=operacion(num12);
				numero.setText(String.valueOf(totalr));
				raiz=true;
				bandera=true;
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