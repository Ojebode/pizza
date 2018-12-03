package com.example.vikzpizza;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Fill_order extends Activity {

	Button btnOption;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fill_order);
		 MediaPlayer ourSong = MediaPlayer.create(Fill_order.this, R.raw.space);
	     ourSong.setLooping(true);
	     ourSong.start();
	     
		final String l1 = getIntent().getExtras().getString("l1");
		final String l2 = getIntent().getExtras().getString("l2");
		final String l3 = getIntent().getExtras().getString("l3");
		final String l4 = getIntent().getExtras().getString("l4");
		final String l5 = getIntent().getExtras().getString("l5");
		
			   
		btnOption=(Button)findViewById(R.id.btnToOpt);
		
		btnOption.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				RadioGroup rg = (RadioGroup) findViewById(R.id.rG1); 
				int selected = rg.getCheckedRadioButtonId();
				RadioButton rb = (RadioButton) findViewById(selected);
				final String r = rb.getText().toString();

				CheckBox supreme=(CheckBox)findViewById(R.id.cbSs);
			
				
		 	 final String y = supreme.getText().toString(); 
			
				// TODO Auto-generated method stub
				Intent intent= new Intent(Fill_order.this,Options.class);
				intent.putExtra("l1", l1);
		        intent.putExtra("l2", l2);
			    intent.putExtra("l3", l3);
			    intent.putExtra("l4", l4);
                intent.putExtra("l5", l5);
			    intent.putExtra("l6",  r);
			    intent.putExtra("l7",  y);
			    startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.fill_order, menu);
		return true;
	}

}
