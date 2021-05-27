package spring5_mybatis_webmvc_study.service;

import org.springframework.stereotype.Service;

import spring5_mybatis_webmvc_study.dto.AuthInfo;

// 이메일&비밀번호가 일치하는지 확인해서 AutoInfo 객체를 생성 해주는 interface
@Service
public interface AuthService {
	
	AuthInfo authenicate(String email, String password);
}
