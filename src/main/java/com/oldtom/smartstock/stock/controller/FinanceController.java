package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import com.oldtom.smartstock.account.service.SecurityService;
import com.oldtom.smartstock.stock.model.FinanceVO;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.AdvanceService;
import com.oldtom.smartstock.stock.service.FinanceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/finance/*")
public class FinanceController {

	private static final Logger logger = LoggerFactory.getLogger(FinanceController.class);
	
	@Inject
	private FinanceService service;
	
	@RequestMapping(value = "/year", method = {RequestMethod.GET, RequestMethod.POST})
	public void year(@ModelAttribute("vo") FinanceVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			Calendar cal = Calendar.getInstance();
			
			vo.setBasedate(String.valueOf(cal.get(Calendar.YEAR)-1) + "1201");
			vo.setSales(800);
			vo.setOp_profit_rate(10);
			vo.setDebt_rate(100);
			vo.setCash_divided_yield_rate(1);
			vo.setRoe(10);
		}
		vo.setBasedate1(vo.getBasedate().substring(0,4) + "0901");
		vo.setBasedate2(vo.getBasedate().substring(0,4) + "0601");
		vo.setBasedate3(vo.getBasedate().substring(0,4) + "0301");
		
		logger.debug(vo.toString());
		model.addAttribute("list",service.finance_year(vo));
	}
	
	@RequestMapping(value = "/quarter", method = {RequestMethod.GET, RequestMethod.POST})
	public void quarter(@ModelAttribute("vo") FinanceVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			Calendar cal = Calendar.getInstance();
			
			vo.setBasedate(String.valueOf(cal.get(Calendar.YEAR)-1) + "0901");
			vo.setSales(200);
			vo.setOp_profit_rate(10);
			vo.setDebt_rate(100);
			vo.setCash_divided_yield_rate(0);
			vo.setRoe(10);
		}
		
		logger.debug(vo.toString());
		model.addAttribute("list",service.finance_quarter(vo));
	}

	@RequestMapping(value = "/year_improve", method = {RequestMethod.GET, RequestMethod.POST})
	public void year_improve(@ModelAttribute("vo") FinanceVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			Calendar cal = Calendar.getInstance();
			
			vo.setBasedate(String.valueOf(cal.get(Calendar.YEAR)-1) + "1201");
			vo.setDuration(1);
			vo.setSales(800);
			vo.setOp_profit_rate(10);
			vo.setDebt_rate(100);
			vo.setCash_divided_yield_rate(1);
			vo.setRoe(10);
			vo.setRate(10);		// 매출액
			vo.setRate1(5);		// 영업이익률
			vo.setRate2(5);
		}
		vo.setBasedate1(vo.getBasedate().substring(0,4) + "0901");
		vo.setBasedate2(vo.getBasedate().substring(0,4) + "0601");
		vo.setBasedate3(vo.getBasedate().substring(0,4) + "0301");
		
		logger.debug(vo.toString());
		model.addAttribute("list",service.finance_year_improve(vo));
	}
	
	@RequestMapping(value = "/quarter_improve", method = {RequestMethod.GET, RequestMethod.POST})
	public void quarter_improve(@ModelAttribute("vo") FinanceVO vo,
						Model model) throws Exception {
		
		Calendar cal = Calendar.getInstance();
		if (vo.getBasedate() == null) {
				
			vo.setBasedate(String.valueOf(cal.get(Calendar.YEAR)-1) + "1201");
			vo.setDuration(1);
			vo.setSales(200);
			vo.setOp_profit_rate(10);
			vo.setDebt_rate(100);
			vo.setCash_divided_yield_rate(0);
			vo.setRoe(10);
			vo.setRate(10);		// 매출액
			vo.setRate1(2);		// 영업이익률
			vo.setRate2(1);		// 부채비율
		}
		
		logger.debug(vo.toString());
		model.addAttribute("list",service.finance_quarter_improve(vo));
		

	}


}

