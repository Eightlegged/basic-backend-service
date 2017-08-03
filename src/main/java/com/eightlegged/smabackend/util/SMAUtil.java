package com.eightlegged.smabackend.util;

import org.apache.commons.validator.routines.EmailValidator;

public class SMAUtil {

	public static boolean isValidEmailAddress(String email) {
		return EmailValidator.getInstance().isValid(email);
	}

}