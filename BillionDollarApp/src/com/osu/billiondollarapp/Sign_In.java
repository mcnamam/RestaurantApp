package com.osu.billiondollarapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Sign_In extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getActionBar().setDisplayShowTitleEnabled(false);
		setContentView(R.layout.activity_sign__in);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign__in, menu);
		return true;
	}

}
