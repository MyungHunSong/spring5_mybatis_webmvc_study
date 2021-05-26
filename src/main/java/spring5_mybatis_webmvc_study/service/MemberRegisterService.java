package spring5_mybatis_webmvc_study.service;

import java.time.LocalDateTime;
import java.util.DuplicateFormatFlagsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.dto.RegisterRequest;
import spring5_mybatis_webmvc_study.mapper.MemberMapper;

@Service
public class MemberRegisterService {
	
	@Autowired
	private MemberMapper memMapper;
		
	public Long regist(RegisterRequest req) {
		Member member = memMapper.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateFormatFlagsException("dup email" + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(),req.getName(), req.getPassword(),  LocalDateTime.now()); 
		memMapper.insertMember(newMember);
		return newMember.getId();
	}
}
