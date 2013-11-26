package com.tunabytes.piratemap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TourFragment extends Fragment {

	private String major;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_tour, container, false);
         
        Activity parent = getActivity();
        major = ((MainActivity) parent).getMajor();
        
        if (major.equals("CS")) {
        	MapFragment.setMapType(MapFragment.TOUR_TYPE);
        	MapLabeler.labelMap(MapFragment.TOUR_TYPE);
        }
        else {
        	MapFragment.setMapType(MapFragment.OVERVIEW_TYPE);
           	MapLabeler.labelMap(MapFragment.OVERVIEW_TYPE);
        }
        
        setRetainInstance(true);
        return rootView;
    }
	
}
