package com.workout.utility;

import org.apache.commons.validator.routines.EmailValidator;

public class UserUtils {

	public boolean verifyEmail(String email){
				
		EmailValidator ev = EmailValidator.getInstance();
		return ev.isValid(email);
		
	}
	
	
}
