package spring5_mybatis_webmvc_study.mapper;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_webmvc_study.config.ContextRoot;
import spring5_mybatis_webmvc_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
public class MemberListMapperTest {
	protected static final Log log = LogFactory.getLog(MemberListMapperTest.class);
	

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private MemberListMapper mapper;

	//@Test
	public void testSelectMemberList() {
		
	}

	@Test
	public void testSelectById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		long id = 43;
		Member list = mapper.selectById(id);
		System.out.println(list);
		log.debug(list.toString());
		Assert.assertNotNull(list);
		
	}

}
