package com.tunabytes.piratemap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapFragment extends Fragment {

	public static final int OVERVIEW_TYPE = 0;
	public static final int EVENT_TYPE = 1;
	public static final int SCHEDULE_TYPE = 2;
	public static final int TOUR_TYPE = 3;
	
	private static final LatLng AASU_LAT_LNG = new LatLng(31.98098, -81.16263);
	private static final int OPTIMAL_ZOOM = 17;
	private static final int OPTIMAL_BEARING = 320;
	private static final int OPTIMAL_TILT = 30;
	
	private static int mapType = OVERVIEW_TYPE;
	private SupportMapFragment fragment;
	private GoogleMap map;
	
	public static void setMapType(int type) {
		mapType = type;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_map, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		FragmentManager fm = getChildFragmentManager();
		fragment = (SupportMapFragment) fm.findFragmentById(R.id.aasu_map);
		if (fragment == null) {
			fragment = SupportMapFragment.newInstance();
			fm.beginTransaction().replace(R.id.aasu_map, fragment).commit();
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		if (map == null) {
			getCampusMap();
			MapLabeler.labelMap(map, mapType);
		}
	}
	
	private GoogleMap getCampusMap() {
		CameraPosition position = getCampusCameraPosition();
		map = fragment.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
		return map;
	}
	
	private static CameraPosition getCampusCameraPosition() {
		return new CameraPosition.Builder()
		.target(AASU_LAT_LNG)
		.zoom(OPTIMAL_ZOOM)
		.bearing(OPTIMAL_BEARING)
		.tilt(OPTIMAL_TILT)
		.build();
	}
}