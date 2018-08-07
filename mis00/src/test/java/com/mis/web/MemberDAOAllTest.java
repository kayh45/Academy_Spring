package com.mis.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.MemberVO;
import com.mis.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOAllTest {

	
	@Inject
	private MemberDAO dao;
	
	@Test
	public void testUpdateMember() throws Exception {
		MemberVO vo = new MemberVO("user00", "user11", "USER00", "user00@aaa.com");
		
		dao.updateMember(vo);
			
	}
	
//	@Test
//	public void testDeleteMember() throws Exception {
//
//		dao.deleteMember("user00", "user00");
//
//	}
}
