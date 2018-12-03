package com.example.vikzpizza;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Confirm extends Activity {
  
	Button btnCall;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm);
		
		final String l1 = getIntent().getExtras().getString("l1");
		final String l2 = getIntent().getExtras().getString("l2");
		final String l3 = getIntent().getExtras().getString("l3");
		final String l4 = getIntent().getExtras().getString("l4");
		final String l5 = getIntent().getExtras().getString("l5");
		final String l6 = getIntent().getExtras().getString("l6");
		final String l7 = getIntent().getExtras().getString("l7");
		
		final String message = l1+" "+l2+" "+l3+" "+l4+" "+l5+" "+l6+" "+l7;
		
		Button sms=(Button)findViewById(R.id.btnSms);
		btnCall=(Button)findViewById(R.id.btnPhone);
		
		
		sms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
               Intent sendSms = new Intent(Intent.ACTION_VIEW);
               sendSms.putExtra("sms_body", message); 
               sendSms .setType("vnd.android-dir/mms-sms");
               startActivity(sendSms );
			}
		});
		
		btnCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Intent callIntent = new Intent(Intent.ACTION_CALL);
				  callIntent.setData(Uri.parse("tel:00971505300393"));
			      startActivity(callIntent);
							
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.confirm, menu);
		return true;
	}

}
