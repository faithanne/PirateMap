package com.tunabytes.piratemap;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLoadedCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MapFragment extends Fragment {

	public static final int OVERVIEW_TYPE = 0;
	public static final int EVENT_TYPE = 1;
	public static final int SCHEDULE_TYPE = 2;
	public static final int TOUR_TYPE = 3;
	
	private static final LatLng ZOOMOUT = new LatLng(31.97827, -81.16330);
	private static final float ZOOMOUT_ZOOM = 15.1856F;
	private static final float ZOOMOUT_BEARING = 164.0089F;
	
	private static final LatLng AASU = new LatLng(31.97979, -81.16277);
	private static final float AASU_ZOOM = 16.9669F;
	private static final float AASU_BEARING = 252.5195F;
	
	private static final float TILT = 3.2886F;
	
	private static int mapType = OVERVIEW_TYPE;
	private static SupportMapFragment fragment;
	private static GoogleMap map;
	
	public static void setMapType(int type) {
		mapType = type;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("MapFragment", "onCreateView");
		return inflater.inflate(R.layout.fragment_map, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.i("MapFragment", "onActivityCreated");
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
		Log.i("MapFragment", "onResume");
		if (map == null) {
			getCampusMap();
			MapLabeler.labelMap(mapType);
		}
	}
	
	private GoogleMap getCampusMap() {
		map = fragment.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		addDebugInfo();
		if (mapType == MapFragment.OVERVIEW_TYPE) {
			executeArmstrongFlyIn();
		}
		return map;
	}
	
	private static CameraPosition getZoomOutCameraPosition() {
		return new CameraPosition.Builder()
		.target(ZOOMOUT)
		.zoom(ZOOMOUT_ZOOM)
		.bearing(ZOOMOUT_BEARING)
		.tilt(TILT)
		.build();
	}
	
	private static CameraPosition getCampusCameraPosition() {
		return new CameraPosition.Builder()
		.target(AASU)
		.zoom(AASU_ZOOM)
		.bearing(AASU_BEARING)
		.tilt(TILT)
		.build();
	}
	
	private static void executeArmstrongFlyIn() {
		CameraPosition position = getZoomOutCameraPosition();
		map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
		map.setOnMapLoadedCallback(new OnMapLoadedCallback() {
			@Override
			public void onMapLoaded() {
				CameraPosition aasuPosition = getCampusCameraPosition();
				CameraUpdate update = CameraUpdateFactory.newCameraPosition(aasuPosition);
				map.animateCamera(update);
			}
		});
	}
	
	private void addDebugInfo() {
		map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
			@Override
			public void onMapClick(LatLng latlng) {
				Log.i("MapFragment", "onClick: " + latlng);
			}
		});
		map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
			
			@Override
			public void onCameraChange(CameraPosition position) {
				Log.i("MapFragment", "onCameraChange: " + position);
			}
		});
	}
	
	public static GoogleMap getMap(){
		map = fragment.getMap();
		map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		executeArmstrongFlyIn();
		return map;
	}
}