package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import com.oldtom.smartstock.account.model.LoginUser;
import com.oldtom.smartstock.account.service.SecurityService;
import com.oldtom.smartstock.stock.model.ScreenDTO;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.service.TodayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/today/*")
public class TodayController {

	private static final Logger logger = LoggerFactory.getLogger(TodayController.class);
	
	@Inject
	private TodayService service;

	@RequestMapping(value = "/summary", method = {RequestMethod.GET, RequestMethod.POST})
	public String summary(@ModelAttribute("basedate") String basedate, Model model, Authentication auth) throws Exception {

		// 회원 가입후, 아직 이메일 인증을 받지 않은 회원일 경우.. 이메일 인증 페이지로 이동시킨다
		/*
	    LoginUser loginUser = (LoginUser) auth.getPrincipal();	    
	    if ("n".equals(loginUser.getEmail_conf())) {
	    	logger.debug("email is not confirmed");
	    	model.addAttribute("emailconf", false);
	    	model.addAttribute("email", loginUser.getUsername());
	    	//return "redirect:/welcome";
	    	return "/welcome";
	    }
		*/
		if (basedate.isEmpty()) {
			logger.info("basedate is ''");
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				cal.add(Calendar.DATE, -2);
			else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
				cal.add(Calendar.DATE, -1);
			
			basedate = dtf.format(cal.getTime());
			model.addAttribute("basedate", basedate);
			logger.info("basedate: " + basedate);
		}	
		
		model.addAttribute("ma520",service.ma520(basedate));
		logger.debug(service.ma520(basedate).toString());

		model.addAttribute("ma2060",service.ma2060(basedate));
		logger.debug(service.ma2060(basedate).toString());		

		model.addAttribute("ma60120",service.ma60120(basedate));
		logger.debug(service.ma60120(basedate).toString());
		
		model.addAttribute("ilmok",service.ilmok(basedate));
		logger.debug(service.ilmok(basedate).toString());
		
		model.addAttribute("macd",service.macd(basedate));
		logger.debug(service.macd(basedate).toString());
		
		model.addAttribute("slow",service.slow(basedate));
		logger.debug(service.slow(basedate).toString());
		
		model.addAttribute("sonar",service.sonar(basedate));
		logger.debug(service.sonar(basedate).toString());
		
		model.addAttribute("cci",service.cci(basedate));
		logger.debug(service.cci(basedate).toString());
		
		model.addAttribute("rsi",service.rsi(basedate));
		logger.debug(service.rsi(basedate).toString());
		
		model.addAttribute("volume",service.volume(basedate));
		logger.info(service.volume(basedate).toString());
		
		return "today/summary";
	}



	@RequestMapping(value = "/rising_falling_most", method = {RequestMethod.GET, RequestMethod.POST})
	public void most_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			logger.info("basedate is ''");
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
				cal.add(Calendar.DATE, -3);
			else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				cal.add(Calendar.DATE, -2);
			else
				cal.add(Calendar.DATE, -1);
			
			vo.setBasedate(dtf.format(cal.getTime()));
			vo.setSign("1");
			
		}

		vo.setDuration(2);
		model.addAttribute("list",service.rising_falling_most(vo));
	}



	@RequestMapping(value = "/open_gap", method = {RequestMethod.GET, RequestMethod.POST})
	public void open_gap(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			logger.info("basedate is ''");
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
				cal.add(Calendar.DATE, -3);
			else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				cal.add(Calendar.DATE, -2);
			else
				cal.add(Calendar.DATE, -1);
			
			vo.setBasedate(dtf.format(cal.getTime()));
			vo.setSign("1");
			vo.setRateM(5);
		}
		

		model.addAttribute("list",service.open_gap_moreM(vo));

	}

	@RequestMapping(value = "/renew_low_high", method = {RequestMethod.GET, RequestMethod.POST})
	public void renew_low_high(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			logger.info("basedate is ''");
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
				cal.add(Calendar.DATE, -3);
			else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				cal.add(Calendar.DATE, -2);
			else
				cal.add(Calendar.DATE, -1);
			
			vo.setBasedate(dtf.format(cal.getTime()));
			vo.setDuration(250);
			vo.setSign("1");
		}
		
		model.addAttribute("list",service.renewLowHigh(vo));

	}
	
	@RequestMapping(value = "/volume_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void volume_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			logger.info("basedate is ''");
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
				cal.add(Calendar.DATE, -3);
			else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				cal.add(Calendar.DATE, -2);
			else
				cal.add(Calendar.DATE, -1);
			
			vo.setBasedate(dtf.format(cal.getTime()));
			vo.setSign("1");
			vo.setRateM(200);
		}
		
		model.addAttribute("list",service.volume_rising_falling(vo));

	}
}

