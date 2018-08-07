package com.mis.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.CustomerVO;
import com.mis.persistence.CustomerDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class CustomerDaoAllTest {
	
	@Inject
	private CustomerDAO dao;
	
//	@Test
	public void testInsertCustomer() {
		
		CustomerVO vo = new CustomerVO("gildong", "홍길동", 1993, "율도국", "010-1234-5678", "SILVER");
		
		dao.insertCustomer(vo);
	}
	
//	@Test
	public void testReadCustomer() throws Exception {

			System.out.println(dao.readCustomer("gildong"));
		
	}
	
//	@Test
	public void testUpdateCustomer() throws Exception {
		
		CustomerVO vo = new CustomerVO("gildong", "홍길동", 1993, "율도국", "010-1234-5678", "GOLD");
		
		dao.updateCustomer(vo);
	}
	
	@Test
	public void testDeleteCustomer() throws Exception {
		
		dao.deleteCustomer("gildong");
		
	}

}
