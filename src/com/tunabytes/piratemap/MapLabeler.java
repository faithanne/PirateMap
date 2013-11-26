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
		for (Attraction attraction : attractions) {
			addOverviewAttraction(map, attraction);
		}
		attractions.clear();
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
			addOtherAttraction(map, attraction);
		}
		return map;
	}
	
	private static List<Attraction> getOverviewLabels() {
		List<Attraction> overview = new ArrayList<Attraction>();
		overview.add(new Attraction(new LatLng(31.981102513454655,-81.16238817572594), "Burnett Hall", "Administration/Bursar"));
		overview.add(new Attraction(new LatLng(31.980791675898626,-81.16108495742083), "Victor Hall", "Registration"));
		overview.add(new Attraction(new LatLng(31.9806261608692,-81.16172634065151), "Gamble Hall", "Dept of Languages, Literature, and Philosophy"));
		overview.add(new Attraction(new LatLng(31.979894990388402,-81.16136290133), "Jenkins Hall", "College of Fine Arts"));
		overview.add(new Attraction(new LatLng(31.9795181694098,-81.16065345704556), "Science Center", "College of Science and Technology"));
		overview.add(new Attraction(new LatLng(31.979135658984834,-81.16182021796703), "Lane Library", "Library"));
		
		overview.add(new Attraction(new LatLng(31.979481198211563,-81.16277039051056), "Learning Commons", "Mac and PC Labs"));
		overview.add(new Attraction(new LatLng(31.979324781438844,-81.16340607404709), "Memorial College Center", "Career Services"));
		overview.add(new Attraction(new LatLng(31.980262140510153,-81.16300776600838), "Hawes Hall", "Departments of History and Economics"));
		overview.add(new Attraction(new LatLng(31.980184501606104,-81.16333466023207), "International Garden", "Garden"));
		overview.add(new Attraction(new LatLng(31.979985711585332,-81.1636608839035), "Solms Hall", "Department of Health Sciences"));
		overview.add(new Attraction(new LatLng(31.978897335698246,-81.1630292236805), "Student Union", "Student Union"));
		
		overview.add(new Attraction(new LatLng(31.978852969958428,-81.16326861083508), "University Bookstore", "Within Student Union"));
		overview.add(new Attraction(new LatLng(31.97828645170282,-81.16335913538933), "Residential Plaza", "Plaza"));
		overview.add(new Attraction(new LatLng(31.9791234300007,-81.16263460367918), "Compass Plaza", "Plaza"));
		overview.add(new Attraction(new LatLng(31.9802740849511,-81.16515453904867), "Fine Arts Hall", "College of Fine Arts"));
		overview.add(new Attraction(new LatLng(31.9791234300007,-81.16446018218994), "Ashmore Hall", "College of Health Sciences"));
		overview.add(new Attraction(new LatLng(31.978349019151857,-81.16457048803568), "University Hall", "College of Education, and Department of Mathematics"));
		
		overview.add(new Attraction(new LatLng(31.977177009988395,-81.16471868008375), "Compass Point Student Residence", "Student Residence"));
		overview.add(new Attraction(new LatLng(31.97771253556659,-81.16324078291655), "Main Housing Office", "Housing Office"));
		overview.add(new Attraction(new LatLng(31.979104944323925,-81.15975391119719), "University Police", "Police Station"));
		overview.add(new Attraction(new LatLng(31.978393385135302,-81.16057064384222), "Student Recreation Center", "Gym"));
		overview.add(new Attraction(new LatLng(31.97816103227884,-81.16096559911966), "Aquatic and Recreation Center", "Water Gym"));
		overview.add(new Attraction(new LatLng(31.977086001613458,-81.16071213036776), "Sports Center", "Old Gym"));

		overview.add(new Attraction(new LatLng(31.97549959738049,-81.15934520959854), "Athletic Fields/Tennis Courts", "Baseball Field, Soccer Field, and Tennis Court"));
		overview.add(new Attraction(new LatLng(31.974912581047167,-81.16177529096603), "Recreation and Wellness Intramural Fields", "Intramural Fields"));
		overview.add(new Attraction(new LatLng(31.979492573966457,-81.16826556622982), "Armstrong Center", "Special Event Location, Payroll, IT Services, GPB"));
		overview.add(new Attraction(new LatLng(31.97831147868756,-81.16847209632397), "University Crossings", "Student Residence"));
		overview.add(new Attraction(new LatLng(31.97749809819029,-81.16884894669056), "University Terrace", "Student Residence"));
		overview.add(new Attraction(new LatLng(31.976636646439346,-81.16363137960434), "Windward Commons", "Student Residence"));
		
		return overview;
	}
	
	private static List<Attraction> getEventLabels() {
		List<Attraction> eventLabels = new ArrayList<Attraction>();
		return eventLabels;
	}
	
	private static List<Attraction> getScheduleLabels() {
		List<Attraction> scheduleLabels = new ArrayList<Attraction>();
		return scheduleLabels;
	}
	
	private static List<Attraction> getTourLabels() {
		List<Attraction> tourLabels = new ArrayList<Attraction>();
		tourLabels.add(new Attraction(new LatLng(31.97988731178767,-81.16074029356241), "SC202 - Department of Computer Science and Information Technology", "SC202"));
		tourLabels.add(new Attraction(new LatLng(31.97981223210229,-81.1606490984559), "SC121 - ACM Lab", "SC121"));
		tourLabels.add(new Attraction(new LatLng(31.980097762093468,-81.16078555583954), "SC129 - Computer Lab", "Computer Lab"));
		tourLabels.add(new Attraction(new LatLng(31.979494564723417,-81.1609360948205), "SC2506 - Classroom", "Classroom"));
		tourLabels.add(new Attraction(new LatLng(31.979433704419677,-81.16112049669027), "SC1503A - Computer Lab", "Computer Lab"));
		tourLabels.add(new Attraction(new LatLng(31.9794305760852,-81.16121873259544), "SC1503B - Computer Lab", "Computer Lab"));
		return tourLabels;
	}
	
	private static void addOverviewAttraction(GoogleMap map, Attraction attraction) {
		map.addMarker(new MarkerOptions()
				.position(attraction.getLatLng())
				.title(attraction.getName())
				.snippet(attraction.getDescription())
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
	}
	
	private static void addOtherAttraction(GoogleMap map, Attraction attraction) {
		map.addMarker(new MarkerOptions()
				.position(attraction.getLatLng())
				.title(attraction.getName())
				.snippet(attraction.getDescription())
				.icon(BitmapDescriptorFactory
						.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
	}
	
	
}