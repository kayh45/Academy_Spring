package com.mis.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mis.domain.ProductVO;

@Controller
public class SampleController5 {

	@RequestMapping("doJSON")
	public @ResponseBody ProductVO doJSON() {
		

		ProductVO vo = new ProductVO("���� ��ǰ", 30000);
		
		return vo;
		
	}
	
}
