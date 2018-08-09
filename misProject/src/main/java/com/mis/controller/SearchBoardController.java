package com.mis.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mis.domain.BoardVO;
import com.mis.domain.Criteria;
import com.mis.domain.PageMaker;
import com.mis.domain.SearchCriteria;
import com.mis.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(131);
		
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri , Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
		
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
	public void modifyPage(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri,  Model model) throws Exception {
		
		model.addAttribute(service.read(bno));
		
	}
	
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPage(BoardVO board, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("mod Post.............");
		
		service.modify(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
	
	}
	
	@RequestMapping(value = "/removePage", method = RequestMethod.POST)
	public String removePage(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registGet() throws Exception {
		logger.info("regist get.......................");
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPost(BoardVO board, @ModelAttribute("cri") SearchCriteria cri, RedirectAttributes rttr) throws Exception {
		logger.info("regist post.......................");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
	}

}
