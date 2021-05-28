package spring5_mybatis_webmvc_study.service;

import java.util.List;

import spring5_mybatis_webmvc_study.dto.Member;

public interface RestMemberService{
	List<Member> selectByAll();
	Member selectById(Long memId);
}
