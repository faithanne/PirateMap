package com.tunabytes.piratemap;

import android.annotation.SuppressLint;
import java.util.HashMap;

public class Course {

	private final HashMap<String, String> courseNames = new HashMap<String, String>() {
		private static final long serialVersionUID = 1290010190022325784L;

		{
			put("CHEM 1211", "Principles of Chemistry I");
			put("CHEM 1211L", "Principles of Chemistry I Lab");
			put("CSCI 3201", "Foundations of Digital Systems");
			put("CSCI 3321", "Intro to Software Systems");
			put("CSCI 3341", "Intro to Operating Systems");
			put("STAT 3211", "Probability & Statistics App I");
		}
	};
	
	private final String id, name, building, room, professor, startTime, endTime, days;
	
	@SuppressLint("DefaultLocale")
	public Course(String id, String building, String room, String professor, 
			String startTime, String endTime, String days) {
		this.id = id;
		this.name = courseNames.get(id);
		this.building = building;
		this.room = room;
		this.professor = professor;
		this.startTime = startTime;
		this.endTime = endTime;
		this.days = days;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getBuilding() {
		return building;
	}

	public String getRoom() {
		return room;
	}

	public String getProfessor() {
		return professor;
	}

	public String getStartTime() {
		return startTime;
	}

	public String getEndTime() {
		return endTime;
	}
	
	public String getDays() {
		return days;
	}
	
	public String toString() {
		return id + " " + name + "\n" + building + " " + room + "\n" + 
				professor + "\n" + startTime + " - " + endTime + " (" + days + ")";
	}
}
