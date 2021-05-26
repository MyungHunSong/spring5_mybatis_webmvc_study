package spring5_mybatis_webmvc_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring5_mybatis_webmvc_study.dto.RegisterRequest;
import spring5_mybatis_webmvc_study.exception.DuplicateMemberException;
import spring5_mybatis_webmvc_study.service.MemberRegisterService;
import spring5_mybatis_webmvc_study.validator.RegisterRequestValidator;

@Controller
public class RegisterController {
	
	@Autowired
	private MemberRegisterService service;

	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "/register/step1";
	}
	@PostMapping("/register/step2")
	public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree, RegisterRequest registerRequest) {
		if(!agree) {
			return "register/step1";
		}

		return "register/step2";
		}
	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}
	
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if(errors.hasErrors())
			return "register/step2";
		try {
			service.regist(regReq);
			return "register/step3";
		}catch (DuplicateMemberException ex) {
			return "register/step2";
		}	
	}
}