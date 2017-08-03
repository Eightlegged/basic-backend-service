package com.eightlegged.smabackend.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.eightlegged.smabackend.model.SignupModel;
import com.eightlegged.smabackend.service.UserService;
import com.eightlegged.smabackend.util.SMAUtil;

@Component(value = "userValidator")
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(SignupModel.class);
	}

	@Override
	public void validate(Object arg0, Errors err) {
		// TODO Auto-generated method stub
		SignupModel signupmd = (SignupModel) arg0;
		if (!checkEmptyValue(err, signupmd)) {
			validatePasswords(err, signupmd);
			checkExistUserName(err, signupmd.getUserName());
			if (!SMAUtil.isValidEmailAddress(signupmd.getEmail())) {
				err.rejectValue("email", "error.email.not.valid");
			} else {
				checkExistUserEmail(err, signupmd.getEmail());
			}
		}
	}

	private boolean checkEmptyValue(Errors err, SignupModel signupmd) {
		boolean isError = false;
		if (signupmd.getEmail().isEmpty()) {
			err.rejectValue("userName", "error.username.not.empty");
			isError = true;
		}
		if (signupmd.getUserName().isEmpty()) {
			err.rejectValue("email", "error.email.not.empty");
			isError = true;
		}
		if (signupmd.getPassword().isEmpty()) {
			err.rejectValue("password", "error.password.not.empty");
			isError = true;
		}
		if (signupmd.getPasswordRepeated().isEmpty()) {
			err.rejectValue("passwordRepeated", "error.repeatpassword.not.empty");
			isError = true;
		}
		return isError;
	}

	private void checkExistUserName(Errors err, String userName) {
		if (userService.findByUsername(userName) != null) {
			err.rejectValue("userName", "error.username.exist");
		}
	}

	private void checkExistUserEmail(Errors err, String email) {
		if (userService.findByEmail(email) != null) {
			err.rejectValue("email", "error.email.exist");
		}
	}

	private void validatePasswords(Errors err, SignupModel signupmd) {
		if (!signupmd.getPassword().equals(signupmd.getPasswordRepeated())) {
			err.rejectValue("passwordRepeated", "error.passwords.notequal");
		}
	}
}
