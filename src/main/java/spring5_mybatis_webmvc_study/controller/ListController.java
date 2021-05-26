package spring5_mybatis_webmvc_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import spring5_mybatis_webmvc_study.dto.ListCommand;
import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.mapper.MemberListMapper;

@Controller
public class ListController {
	@Autowired
	private MemberListMapper memberListMapper;
	
	@RequestMapping("/members")
	public String list(@ModelAttribute("cmd") ListCommand listCommand, Model model) {
		if(listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> members = memberListMapper.selectMemberList(listCommand);
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}
}
