package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import com.oldtom.smartstock.account.service.SecurityService;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.BasicService;
import com.oldtom.smartstock.stock.service.UpjongService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/upjong/*")
public class UpjongController {

	private static final Logger logger = LoggerFactory.getLogger(UpjongController.class);
	
	@Inject
	private UpjongService service;

	@Inject
	private StockDAO sdao;
	
	@RequestMapping(value = "/rising_most", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_falling(@ModelAttribute("vo") UpjongVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
		}
		
		vo.setDuration(5); 						// 5거래일
		vo.setGubun("1");
		model.addAttribute("kospi5",service.rising_most_dayN(vo));
		vo.setGubun("2");
		model.addAttribute("kosdaq5",service.rising_most_dayN(vo));

		vo.setDuration(20); 						// 20거래일
		vo.setGubun("1");
		model.addAttribute("kospi20",service.rising_most_dayN(vo));
		vo.setGubun("2");
		model.addAttribute("kosdaq20",service.rising_most_dayN(vo));

		vo.setDuration(60); 						// 60거래일
		vo.setGubun("1");
		model.addAttribute("kospi60",service.rising_most_dayN(vo));
		vo.setGubun("2");
		model.addAttribute("kosdaq60",service.rising_most_dayN(vo));	

		vo.setDuration(120); 						// 60거래일
		vo.setGubun("1");
		model.addAttribute("kospi120",service.rising_most_dayN(vo));
		vo.setGubun("2");
		model.addAttribute("kosdaq120",service.rising_most_dayN(vo));	


		vo.setDuration(250); 						// 60거래일
		vo.setGubun("1");
		model.addAttribute("kospi250",service.rising_most_dayN(vo));
		vo.setGubun("2");
		model.addAttribute("kosdaq250",service.rising_most_dayN(vo));
	}
		
	@RequestMapping(value = "/rising_falling_kospi", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_falling_kospi(@ModelAttribute("vo") UpjongVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(5); 
			vo.setUpcode("005");
		}
		
		model.addAttribute("list",service.rising_falling_dayN_by_upjong(vo));
	
	}
	
	@RequestMapping(value = "/rising_falling_kosdaq", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_falling_kosdaq(@ModelAttribute("vo") UpjongVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(5); 
			vo.setUpcode("304");
		}
		
		model.addAttribute("list",service.rising_falling_dayN_by_upjong(vo));
	
	}
}

