package spring5_mybatis_webmvc_study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring5_mybatis_webmvc_study.dto.AuthInfo;
import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.exception.WrongIdPasswordException;
import spring5_mybatis_webmvc_study.mapper.MemberMapper;

// 이메일&비밀번호가 일치하는지 확인해서 AutoInfo 객체를 생성 해주는 클래스.
@Component
public class AuthService {
	
	@Autowired
	private MemberMapper memMapper;
	
	public AuthInfo authenicate(String email, String password) {
		Member member = memMapper.selectByEmail(email);
		
		if(member == null) {
			throw new WrongIdPasswordException();
		}
		
		if(!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		
		return new AuthInfo(member.getId(), member.getEmail(),member.getName());
	}
}
