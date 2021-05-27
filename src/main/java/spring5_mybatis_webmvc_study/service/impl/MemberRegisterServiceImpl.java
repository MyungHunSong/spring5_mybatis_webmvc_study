package spring5_mybatis_webmvc_study.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.dto.RegisterRequest;
import spring5_mybatis_webmvc_study.exception.DuplicateMemberException;
import spring5_mybatis_webmvc_study.mapper.MemberMapper;
import spring5_mybatis_webmvc_study.service.MemberRegisterService;

@Service
public class MemberRegisterServiceImpl implements MemberRegisterService {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public Long regist(RegisterRequest req) {
		Member member = memberMapper.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(),req.getPassword(), req.getName(),LocalDateTime.now());
		return newMember.getId();
	}
}
