package spring5_mybatis_webmvc_study.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import spring5_mybatis_webmvc_study.dto.AnseredData;
import spring5_mybatis_webmvc_study.dto.Question;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
//	@GetMapping
//	public String form(Model model) {
//		List<Question> questions = createQuestion(); 
//		model.addAttribute("questions",questions);
//		return "survey/surveyForm";
//	}
	
	// 위에 방법도 괜찬고 밑에 방법도 상당히 괜찬타.
	@GetMapping
	public ModelAndView form() {
		List<Question> questions = createQuestion();
		ModelAndView mav = new ModelAndView();
		mav.addObject("questions", questions);
		mav.setViewName("survey/surveyForm");
		
		return mav;
	}
	
	private List<Question> createQuestion() {
		Question q1 = new Question("당신의 역할은 무엇입니까?",Arrays.asList("서버","프론트","풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?",Arrays.asList("이클립스","인텔리J","서브라임"));
		Question q3 = new Question("하고 싶은 말을 적어주세요.");
		return Arrays.asList(q1,q2,q3);
	}

	@PostMapping
	public String submit(@ModelAttribute("ansData") AnseredData data) {
		return "survey/submitted";
	}

}