package spring5_mybatis_webmvc_study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring5_mybatis_webmvc_study.dto.Member;
import spring5_mybatis_webmvc_study.mapper.MemberListMapper;
import spring5_mybatis_webmvc_study.mapper.MemberMapper;
import spring5_mybatis_webmvc_study.service.RestMemberService;
@Service
public class RestMemberServiceImpl implements RestMemberService {

	@Autowired
	private MemberMapper memMapper;
	@Autowired
	private MemberListMapper memListMapper;
	
	@Override
	public List<Member> selectByAll() {
		return memMapper.selectByAll();
	}

	@Override
	public Member selectById(Long memId) {
		return memListMapper.selectById(memId);
	}

}
