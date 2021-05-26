package spring5_mybatis_webmvc_study.mapper;

import java.util.List;

import spring5_mybatis_webmvc_study.dto.ListCommand;
import spring5_mybatis_webmvc_study.dto.Member;

public interface MemberListMapper {
	List<Member> selectMemberList(ListCommand command);
	// 생각없는 받아쓰기의 페혜 localdatime ~, localdatime ~ 두개를 써주고 
	// mapperxml 파라미터 타입에는 하나만 써주니까 애새끼가 알아먹지를 못햇네.
	// 슈발~ 타입 잘보자 정신차리자.
	
	/** selectDetail **/
	Member selectById(Long memId);
}
