package spring5_mybatis_webmvc_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.exception.MemberNotFoundException;
import spring5_mybatis_webmvc_study.mapper.MemberListMapper;

@Controller
public class MemberDetailController {
	
	@Autowired
	private MemberListMapper memListMapper;
	
	@GetMapping("/members/{id}")
	public ModelAndView detail(@PathVariable("id") Long memId) {
		Member member = memListMapper.selectById(memId);
		System.out.println("memberController:" + member);
		if(member==null) {
			throw new MemberNotFoundException();
		}
		ModelAndView mav = new ModelAndView();
		System.out.println("mav(view) : " + mav);
		mav.addObject("member", member);
		mav.setViewName("member/memberDetail");
		return mav;
		
	}
}
