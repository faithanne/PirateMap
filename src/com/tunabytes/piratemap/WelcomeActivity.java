package com.tunabytes.piratemap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Do not display the options menu on the login screen
		return false;
	}
	
	public void visitorLogin(View view) {
		// TODO: Send user directly to the map
		// TODO: Pass some indicator that will disable irrelevant map options (schedule, events etc.)
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra(MainActivity.NUM_TABS_EXTRA, 2);
		startActivity(intent);
	}
	
	public void prospectiveStudentLogin(View view) {
		// TODO: Pass some indicator that will disable irrelevant map options (schedule, events, etc.)
		// For now, this will immediately direct you to the map, in order to bypass the login screen
		Intent intent = new Intent(this, ChooseMajorActivity.class);
		startActivity(intent);
	}
	
	/**
	 * Directs the user to the current student login page
	 */
	public void currentStudentLogin(View view) {
		Intent intent = new Intent(this, StudentLoginActivity.class);
		startActivity(intent);
	}

}
