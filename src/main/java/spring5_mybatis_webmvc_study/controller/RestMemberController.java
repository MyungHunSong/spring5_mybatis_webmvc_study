package spring5_mybatis_webmvc_study.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.mapper.MemberListMapper;
import spring5_mybatis_webmvc_study.mapper.MemberMapper;
import spring5_mybatis_webmvc_study.service.RestMemberService;

@RestController
public class RestMemberController {
	@Autowired
	private RestMemberService RmemberService;
	
	@GetMapping("/api/members")
	public List<Member> members(){
		return RmemberService.selectByAll();
	}
	
	@GetMapping("/api/members/{id}")
	public Member member(@PathVariable Long id, HttpServletResponse response) throws IOException {
		Member member = RmemberService.selectById(id);
		if(member == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return member;
	}
}
