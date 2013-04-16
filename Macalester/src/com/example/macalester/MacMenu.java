package com.example.macalester;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MacMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mac_menu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mac_menu, menu);
		return true;
	}

}
