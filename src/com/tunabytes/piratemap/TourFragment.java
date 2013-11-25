package com.tunabytes.piratemap;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        
        if (major == "CS") {
        	MapLabeler.labelMap(3);
        }
        else {
        	MapLabeler.labelMap(0);
        }
        
        setRetainInstance(true);
        return rootView;
    }
	
}
