package spring5_mybatis_webmvc_study.mapper;

import java.util.List;

import spring5_mybatis_webmvc_study.dto.Member;

public interface MemberMapper {
	List<Member> selectByAll();
	
	// count
	List<Member> selectByCount();
	
	// selectByEmail
	Member selectByEmail(String email);
	
	// insert
	int insertMember(Member member);
	// delete
	int deleteMember(Member member);
	
	//update
	int updateMember(Member member);
	
}
