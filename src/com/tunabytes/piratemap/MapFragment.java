package com.tunabytes.piratemap;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.maps.SupportMapFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {

	private GoogleMap map;
	private static final LatLng aasu = new LatLng(31.98098, -81.16263);
	private static final CameraPosition POSITION = new CameraPosition.Builder()
			.target(aasu).zoom(17).bearing(320).tilt(30).build();
	private UiSettings mUiSettings;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_map, container,
				false);

		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();

		setUpMapIfNeeded();
	}

	private void setUpMapIfNeeded() {
		if (map == null) {
			map = ((SupportMapFragment) getFragmentManager().findFragmentById(
					R.id.googleMap)).getMap();
			if (map != null) {
				setUpMap();
			}
		}
	}

	private void setUpMap() {
		map.setMyLocationEnabled(false);
		mUiSettings = map.getUiSettings();
		mUiSettings.setCompassEnabled(true);
		map.moveCamera(CameraUpdateFactory.newCameraPosition(POSITION));
	}
}