package spring5_mybatis_webmvc_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.exception.MemberNotFoundException;
import spring5_mybatis_webmvc_study.mapper.MemberMapper;

@Service
public class ChangePasswordService {
	@Autowired
	private MemberMapper memMapper;
	
	@Transactional
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memMapper.selectByEmail(email);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		member.changePassword(oldPwd, newPwd);
		memMapper.updateMember(member);		// 원래 true 면 업데이트 해야한다.
	}	
}
