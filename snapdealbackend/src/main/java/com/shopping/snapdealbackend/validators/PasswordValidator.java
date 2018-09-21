package com.shopping.snapdealbackend.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.shopping.snapdealbackend.dto.User;


public class PasswordValidator implements Validator{

	public boolean supports(Class<?> classObj) {
		return User.class.isAssignableFrom(classObj);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"required.password", "Field name is required.");

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password2",
					"required.confirmPassword", "Field name is required.");

			User user = (User)target;

			if(!(user.getPassword().equals(user.getPassword2()))){
				errors.rejectValue("password", "notmatch.password");
			}

		}
		
	

}
