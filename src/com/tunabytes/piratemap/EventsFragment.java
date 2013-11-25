package com.tunabytes.piratemap;

import java.util.LinkedList;

import android.app.ActionBar.LayoutParams;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventsFragment extends Fragment {

	private LinkedList<Event> events;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_events, container,
				false);
		LinearLayout layout = (LinearLayout) rootView
				.findViewById(R.id.event_layout);

		events = User.getEventList();

		if (events == null) {
			TextView header = (TextView) rootView
					.findViewById(R.id.event_header);
			header.setText(R.string.no_events);
		} else {
			for (Event event : events) {
				TextView courseView = new TextView(rootView.getContext());
				courseView.setText(event.toString());
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