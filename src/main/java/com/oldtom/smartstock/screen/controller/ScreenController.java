package com.oldtom.smartstock.screen.controller;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.ScreenDTO;
import com.oldtom.smartstock.screen.service.ScreenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/screen/*")

public class ScreenController {

	private static final Logger logger = LoggerFactory.getLogger(ScreenController.class);
	
	@Inject
	private ScreenService service;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public void test(
			Model model) throws Exception {
		
		logger.info("test...");
		
	}	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void getScreen(@RequestParam("sno") int sno, @ModelAttribute("dto") ScreenDTO dto, 
			Model model) throws Exception {
		
		dto.setSno(sno);
		
		logger.info(dto.toString());
		
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public void read(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() == 5) {
			
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setTotal(dto.getTotal());
			vo.setDuration(dto.getDuration());
			vo.setIc_rate(dto.getIc_rate());
			vo.setDy_rate(dto.getDy_rate());
			
			model.addAttribute("list",service.getScreen5(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen5(vo).toString());
		}
		
	}

	@RequestMapping(value = "/procedure", method = {RequestMethod.GET, RequestMethod.POST})
	public void procedure(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {

			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setTotal(dto.getTotal());
			vo.setDuration(dto.getDuration());
			vo.setIc_rate(dto.getIc_rate());
			vo.setDy_rate(dto.getDy_rate());
			
			model.addAttribute("list",service.getProdedure(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getProdedure(vo).toString());
		}
		dto.setSno(1);
	}
	
	@RequestMapping(value = "/screen1", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen1(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {

			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setDuration(dto.getDuration());
			vo.setRate(dto.getRef_rate());
			logger.debug(vo.toString());
			
			model.addAttribute("list",service.getScreen1(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen1(vo).toString());
		}
		dto.setSno(1);
	}
	
	@RequestMapping(value = "/screen2", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen2(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setDuration(dto.getDuration());
			vo.setRate(dto.getRef_rate());
			logger.debug(vo.toString());
			
			model.addAttribute("list",service.getScreen2(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen2(vo).toString());
		}
		dto.setSno(2);
	}

	@RequestMapping(value = "/screen3", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen3(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setRate(dto.getRef_rate());
			vo.setHolder(dto.getHolder());
			
			model.addAttribute("list",service.getScreen3(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen3(vo).toString());
		}
		dto.setSno(3);
	}

	@RequestMapping(value = "/screen4", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen4(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setRate(dto.getRef_rate());		// 공매도 증가율
			
			model.addAttribute("list",service.getScreen4(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen4(vo).toString());
		}
		dto.setSno(4);
	}
	
	@RequestMapping(value = "/screen5", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen5(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setRate(dto.getRef_rate());		// 공매도 증가율
			
			model.addAttribute("list",service.getScreen5(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen5(vo).toString());
		}
		dto.setSno(5);
	}
	
	@RequestMapping(value = "/screen6", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen6(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setDuration(dto.getDuration());
			vo.setRate(dto.getRef_rate());		// 주가 변동율
			
			model.addAttribute("list",service.getScreen6(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen6(vo).toString());
		}
		dto.setSno(6);
	}
	
	@RequestMapping(value = "/screen7", method = {RequestMethod.GET, RequestMethod.POST})
	public void screen7(@ModelAttribute("dto") ScreenDTO dto,
						Model model) throws Exception {
		
		logger.info(dto.toString());
		
		if (dto.getSno() != 0) {
			StockVO vo = new StockVO();
			vo.setBasedate(dto.getBasedate());
			vo.setDuration(dto.getDuration());

			logger.debug(vo.toString());
			
			model.addAttribute("list",service.getScreen7(vo));
			model.addAttribute("vo",vo);
			logger.info(service.getScreen7(vo).toString());
		}
		dto.setSno(7);
	}
}

