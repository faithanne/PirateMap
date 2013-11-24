package com.tunabytes.piratemap;

import java.util.LinkedList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class ScheduleFragment extends Fragment {

	private LinkedList<Course> courses;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_schedule, container, false);
        LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.schedule_layout);	
        
        courses = User.getCourseList();
        
        if(courses == null) {
        	TextView header = (TextView) rootView.findViewById(R.id.schedule_header);
        	header.setText(R.string.no_schedule);
        } else {
        	for(Course course : courses) {
        		TextView courseView = new TextView(rootView.getContext());
        		courseView.setText(course.toString());
        		LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        				LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        		params.setMargins(0, 0, 0, 20);
        		courseView.setLayoutParams(params);
        		layout.addView(courseView);
        	}
        }

        return rootView;
    }
	
}
