package spring5_mybatis_webmvc_study.service;

import org.springframework.stereotype.Service;

import spring5_mybatis_webmvc_study.dto.RegisterRequest;

@Service
public interface MemberRegisterService {
	
	Long regist(RegisterRequest req);
}
