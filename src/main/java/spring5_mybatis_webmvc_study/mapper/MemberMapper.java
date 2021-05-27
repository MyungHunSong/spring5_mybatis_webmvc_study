package spring5_mybatis_webmvc_study.mapper;

import java.util.List;

import spring5_mybatis_webmvc_study.dto.Member;

public interface MemberMapper {
	List<Member> selectByAll();
	// count
	List<Member> selectByCount();
	// selectByEmail
	Member selectByEmail(String email);
	

	int insertMember(Member member);
	int deleteMember(Member member);
	int updateMember(Member member);
	
}
