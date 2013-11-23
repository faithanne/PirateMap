package com.tunabytes.piratemap;

import com.google.android.gms.maps.model.LatLng;

public class Attraction {

	private LatLng latLng;
	private String name;
	private String description;
	
	public Attraction(LatLng latLng, String name, String description) {
		super();
		this.latLng = latLng;
		this.name = name;
		this.description = description;
	}

	public LatLng getLatLng() {
		return latLng;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "Attraction [latLng=" + latLng + ", name=" + name
				+ ", description=" + description + "]";
	}
	
}