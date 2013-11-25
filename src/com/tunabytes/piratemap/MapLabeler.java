package com.tunabytes.piratemap;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapLabeler {
	
	private MapLabeler() {
		// Exists only to defeat instantiation.
	}

	public static GoogleMap labelMap(int mapType) {
		GoogleMap map = MapFragment.getMap();
		map.clear();
		List<Attraction> attractions = getOverviewLabels();
		if (mapType == MapFragment.EVENT_TYPE) {
			attractions.addAll(getEventLabels());
		}
		else if (mapType == MapFragment.SCHEDULE_TYPE) {
			attractions.addAll(getScheduleLabels());
		}
		else if (mapType == MapFragment.TOUR_TYPE) {
			attractions.addAll(getTourLabels());
		}
		for (Attraction attraction : attractions) {
			addAttraction(map, attraction);
		}
		return map;
	}
	
	private static List<Attraction> getOverviewLabels() {
		List<Attraction> overview = new ArrayList<Attraction>();
		overview.add(new Attraction(new LatLng(31.981102513454655,-81.16238817572594), "Burnett Hall", "Test-Description-Building1"));
		overview.add(new Attraction(new LatLng(31.980791675898626,-81.16108495742083), "Victor Hall", "Test-Description-Building2"));
		overview.add(new Attraction(new LatLng(31.98097, -81.16262), "Gamble Hall", "Test-Description-Building3"));
		return overview;
	}
	
	private static List<Attraction> getEventLabels() {
		List<Attraction> eventLabels = new ArrayList<Attraction>();
		eventLabels.add(new Attraction(new LatLng(31.98095, -81.16260), "Test-Name-Event1", "Test-Description-Event1"));
		eventLabels.add(new Attraction(new LatLng(31.98096, -81.16261), "Test-Name-Event2", "Test-Description-Event2"));
		eventLabels.add(new Attraction(new LatLng(31.98097, -81.16262), "Test-Name-Event3", "Test-Description-Event3"));
		return eventLabels;
	}
	
	private static List<Attraction> getScheduleLabels() {
		List<Attraction> scheduleLabels = new ArrayList<Attraction>();
		scheduleLabels.add(new Attraction(new LatLng(31.98095, -81.16260), "Test-Name-Schedule1", "Test-Description-Schedule1"));
		scheduleLabels.add(new Attraction(new LatLng(31.98096, -81.16261), "Test-Name-Schedule2", "Test-Description-Schedule2"));
		scheduleLabels.add(new Attraction(new LatLng(31.98097, -81.16262), "Test-Name-Schedule3", "Test-Description-Schedule3"));
		return scheduleLabels;
	}
	
	private static List<Attraction> getTourLabels() {
		List<Attraction> tourLabels = new ArrayList<Attraction>();
		tourLabels.add(new Attraction(new LatLng(31.98095, -81.16260), "Test-Name-Tour1", "Test-Description-Tour1"));
		tourLabels.add(new Attraction(new LatLng(31.98096, -81.16261), "Test-Name-Tour2", "Test-Description-Tour2"));
		tourLabels.add(new Attraction(new LatLng(31.98097, -81.16262), "Test-Name-Tour3", "Test-Description-Tour3"));
		return tourLabels;
	}
	
	private static void addAttraction(GoogleMap map, Attraction attraction) {
		map.addMarker(new MarkerOptions()
				.position(attraction.getLatLng())
				.title(attraction.getName())
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
	}
}