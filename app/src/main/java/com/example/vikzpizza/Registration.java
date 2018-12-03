package com.example.vikzpizza;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends Activity {
	    

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		 MediaPlayer ourSong = MediaPlayer.create(Registration.this, R.raw.space);
	     ourSong.setLooping(true);
	     ourSong.start();
	     
		final EditText etFname=(EditText)findViewById(R.id.etfn);
		final EditText etLname=(EditText)findViewById(R.id.etln);
		final EditText etEmirate=(EditText)findViewById(R.id.etEm);
		final EditText etAddress=(EditText)findViewById(R.id.etAdd);
		final EditText etPhone=(EditText)findViewById(R.id.etPn);
		Button btn1=(Button)findViewById(R.id.btnToOrder);
		
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(Registration.this,Fill_order.class);
		        intent.putExtra("l1", etFname.getText().toString());
		        intent.putExtra("l2", etLname.getText().toString());
		        intent.putExtra("l3", etEmirate.getText().toString());
		        intent.putExtra("l4", etAddress.getText().toString());
		        intent.putExtra("l5", etPhone.getText().toString());
				startActivity(intent);
			}
		});
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registration, menu);
		return true;
	}

}
