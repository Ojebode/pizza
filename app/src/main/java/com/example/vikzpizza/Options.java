package com.example.vikzpizza;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Options extends Activity {
	
    Button btnConfirm ,btnSubmit, btnDisplay;
	TextView tvError;
	SQLiteDatabase db;
	Cursor c;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options);
		
		 MediaPlayer ourSong = MediaPlayer.create(Options.this, R.raw.space);
	     ourSong.setLooping(true);
	     ourSong.start();
	     
		final String l1 = getIntent().getExtras().getString("l1");
		final String l2 = getIntent().getExtras().getString("l2");
		final String l3 = getIntent().getExtras().getString("l3");
		final String l4 = getIntent().getExtras().getString("l4");
		final String l5 = getIntent().getExtras().getString("l5");
		final String l6 = getIntent().getExtras().getString("l6");
		final String l7 = getIntent().getExtras().getString("l7");
		
		btnConfirm = (Button) findViewById(R.id.btnConf);
		btnSubmit = (Button) findViewById(R.id.btnSub);
		btnDisplay = (Button) findViewById(R.id.btnDisplay);
		
		tvError = (TextView)findViewById(R.id.tvError);
		
		
        db = openOrCreateDatabase("Vikz", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS CUSTOMERS (FNAME VARCHAR, LNAME VARCHAR, EMIRATE VARCHAR, ADDRESS VARCHAR,PHONE VARCHAR, Pizza_SIZE VARCHAR, Pizza_TYPE VARCHAR);");
		
        btnSubmit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AddCustomerInformation (l1,l2,l3,l4,l5,l6,l7);
			}
		});
        
        btnConfirm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent= new Intent(Options.this, Confirm.class);
				intent.putExtra("l1", l1);
		        intent.putExtra("l2", l2);
			    intent.putExtra("l3", l3);
			    intent.putExtra("l4", l4);
                intent.putExtra("l5", l5);
			    intent.putExtra("l6", l6);
			    intent.putExtra("l7", l7);
			    startActivity(intent);
				
			}
		});
        
        btnDisplay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tvError.setText( DisplayCustomerInformation ());
				
			}
		});
		
	}

	String DisplayCustomerInformation(){
		
       String strResult  = "";
       try {
			
            c = db.rawQuery("SELECT * FROM CUSTOMERS" , null);
            c.moveToFirst();
			
       do {
            strResult =strResult+c.getString(c.getColumnIndex("FNAME"))+"\n"+ c.getString(c.getColumnIndex("LNAME"))+"\n"+ c.getString(c.getColumnIndex("EMIRATE"))+"\n"+c.getString(c.getColumnIndex("ADDRESS"))+"\n"+ c.getString(c.getColumnIndex("PHONE"))+"\n"+c.getString(c.getColumnIndex("Pizza_SIZE"))+"\n"+c.getString(c.getColumnIndex("Pizza_TYPE"))+"\n";
		    c.moveToNext();
        } while (c.moveToNext());
					
			
		}
		catch (Exception ex)
		{
			 tvError.setText( ex.getMessage());
		}
		
		return (strResult);
	}

	void AddCustomerInformation(String l1, String l2, String l3, String l4, String l5, String l6, String l7) {
		// TODO Auto-generated method stub
		try {
			db.execSQL("INSERT INTO CUSTOMERS VALUES ('" + l1 + "','" + l2 +"','"+ l3 +"','"+ l4 +"','"+ l5 +"','"+ l6+"','"+ l7 + "');");			
		}
	catch (Exception ex)
		{
			tvError.setText( ex.getMessage());
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}

}
