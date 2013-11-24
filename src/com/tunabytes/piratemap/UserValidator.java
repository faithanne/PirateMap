package com.tunabytes.piratemap;

import java.util.HashMap;

public class UserValidator {

	private static UserValidator instance = null;
	private static final HashMap<String, String> credentials = new HashMap<String, String>() {
		private static final long serialVersionUID = 7808348819747061331L;
		{
			put("ma5668@stu.armstrong.edu", "pass");
			put("ds8864@stu.armstrong.edu", "pass");
			put("fk4687@stu.armstrong.edu", "pass");
			put("ab4478@stu.armstrong.edu", "pass");
			put("test", "pass");
		}
	};
	
	private UserValidator() {
		
	}
	
	public static UserValidator getInstance() {
		if(instance == null) {
			instance = new UserValidator();
		}
		return instance;
	}

	public boolean validate(String email, String password) {
		String pass = credentials.get(email);
		
		if(pass == null) {
			return false;
		}
		
		return pass.equals(password);
	}
	
}
