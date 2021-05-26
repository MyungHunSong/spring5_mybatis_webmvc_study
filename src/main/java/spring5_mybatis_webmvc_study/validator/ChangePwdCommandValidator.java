package spring5_mybatis_webmvc_study.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring5_mybatis_webmvc_study.dto.ChangePwdCommand;

public class ChangePwdCommandValidator implements Validator {
	

	@Override
	public boolean supports(Class<?> clazz) {	
		return ChangePwdCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPasswordf", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}

}
