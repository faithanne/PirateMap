package com.tunabytes.piratemap;

import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.Locale;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the sections.
	 * We use a {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will keep every loaded
	 * fragment in memory. If this becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	// This custom ViewPager was designed so that horizontal scrolling would be disbaled between
	// the four fragments. I am not sure if this scroll disabling will have any effect on the
	// internal fragments, namely the map.
	private NoSwipeViewPager mViewPager;
	public final static String NUM_TABS_EXTRA = "com.tunabytes.piratemap.num_tabs";
	private int numTabs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		numTabs = getIntent().getExtras().getInt(NUM_TABS_EXTRA);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (NoSwipeViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});

		// For each of the sections in the app, add a tab to the action bar.
		for(int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
		}
		
		mViewPager.setCurrentItem(1);	// Defaults to the map tab for now
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    // Respond to the action bar's Up/Home button
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int index) {
			switch(index) {
			case 0:
				return new TourFragment();
			case 1:
				return new MapFragment();
			case 2:
				return new ScheduleFragment();
			case 3:
				return new EventsFragment();
			}
			return null;
		}

		@Override
		public int getCount() {
			// Tour, Map, Schedule, Events
			return numTabs;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch(position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			}
			return null;
		}
		
	}
	
	/**
	 * Add course button in the Schedule fragment
	 */
	public void addCourse(View view) {
		AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
		LayoutInflater inflater = getLayoutInflater();
		final View dialogView = inflater.inflate(R.layout.dialog_course_entry, null);
		builder.setView(dialogView);
		builder.setTitle(R.string.title_dialog_course_entry);
		
		
		builder.setPositiveButton(getString(R.string.add), new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				String coursePrefix = ((Spinner) dialogView.findViewById(
						R.id.course_prefix_spinner)).getSelectedItem().toString();
				String courseNumber = ((EditText) dialogView.findViewById(
						R.id.course_number_edittext)).getText().toString();
				String coursePostfix = ((Spinner) dialogView.findViewById(
						R.id.course_postfix_spinner)).getSelectedItem().toString();
				
				String building = ((Spinner) dialogView.findViewById(
						R.id.building_name_spinner)).getSelectedItem().toString();
				
				String roomNumber = ((EditText) dialogView.findViewById(
						R.id.course_room_edittext)).getText().toString();
				String roomPostfix = ((Spinner) dialogView.findViewById(
						R.id.room_postfix_spinner)).getSelectedItem().toString();
				
				String professor = ((EditText) dialogView.findViewById(
						R.id.course_professor_edittext)).getText().toString();
				
				String startHour = ((Spinner) dialogView.findViewById(
						R.id.start_hour_spinner)).getSelectedItem().toString();
				String startMinute = ((Spinner) dialogView.findViewById(
						R.id.start_minute_spinner)).getSelectedItem().toString();
				String startAmPm = ((Spinner) dialogView.findViewById(
						R.id.start_am_pm_spinner)).getSelectedItem().toString();
				
				String endHour = ((Spinner) dialogView.findViewById(
						R.id.end_hour_spinner)).getSelectedItem().toString();
				String endMinute = ((Spinner) dialogView.findViewById(
						R.id.end_minute_spinner)).getSelectedItem().toString();
				String endAmPm = ((Spinner) dialogView.findViewById(
						R.id.end_am_pm_spinner)).getSelectedItem().toString();
				
				String days = "";
				
				CheckBox mCheckBox = (CheckBox) dialogView.findViewById(R.id.m_checkedtext);
				if(mCheckBox != null && mCheckBox.isChecked()) {
					days += "M";
				}
				
				CheckBox tCheckBox = (CheckBox) dialogView.findViewById(R.id.t_checkedtext);
				if(tCheckBox != null && tCheckBox.isChecked()) {
					days += "T";
				}
				
				CheckBox wCheckBox = (CheckBox) dialogView.findViewById(R.id.w_checkedtext);
				if(wCheckBox != null && wCheckBox.isChecked()) {
					days += "W";
				}
				
				CheckBox hCheckBox = (CheckBox) dialogView.findViewById(R.id.h_checkedtext);
				if(hCheckBox != null && hCheckBox.isChecked()) {
					days += "H";
				}
				
				CheckBox fCheckBox = (CheckBox) dialogView.findViewById(R.id.f_checkedtext);
				if(fCheckBox != null && fCheckBox.isChecked()) {
					days += "F";
				}
				
				Course course = new Course(coursePrefix + " " + courseNumber + coursePostfix,
						building, roomNumber + roomPostfix, professor,
						startHour + ":" + startMinute + " " + startAmPm,
						endHour + ":" + endMinute + " " + endAmPm,
						days);
				
				updateCourseList(course);
				
				// Reset the page adapter to reload the Schedule fragment
				mViewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager()));
				mViewPager.setCurrentItem(2);
			}
		});
		
		builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}
	
	/**
	 * Adds the newly created course to the list of courses
	 */
	private void updateCourseList(Course newCourse) {
		LinkedList<Course> courseList;
		if(User.getCourseList() == null) {
			courseList = new LinkedList<Course>();
		} else {
			courseList = new LinkedList<Course>(User.getCourseList());
		}
		
		courseList.add(newCourse);
		User.setCourseList(courseList);
		
		String filename = User.getUsername() + "courselist";
		FileOutputStream fos;

		try {
		  fos = openFileOutput(filename, Context.MODE_PRIVATE);
		  for(Course course : courseList) {
			  fos.write((course.getId() + "*").getBytes());
			  fos.write((course.getBuilding() + "*").getBytes());
			  fos.write((course.getRoom() + "*").getBytes());
			  fos.write((course.getProfessor() + "*").getBytes());
			  fos.write((course.getStartTime() + "*").getBytes());
			  fos.write((course.getEndTime() + "*").getBytes());
			  fos.write((course.getDays() + "*").getBytes());
			  fos.write("\n".getBytes());
		  }
		  fos.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}

}
