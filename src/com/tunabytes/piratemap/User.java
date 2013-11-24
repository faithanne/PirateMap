package com.tunabytes.piratemap;

import java.util.LinkedList;

public class User {

	private static User instance = null;
	private static LinkedList<Course> courseList;
	private static String username;
	
	protected User() {
		
	}
	
	public static User instanceOf() {
		if(instance == null) {
			instance = new User();
		}
		return instance;
	}
	
	public static LinkedList<Course> getCourseList() {
		return courseList;
	}
	
	public static void setCourseList(LinkedList<Course> courseList) {
		User.courseList = courseList;
	}

	public static String getUsername() {
		return username;
	}
	
	public static void setUsername(String username) {
		User.username = username;
	}

}
