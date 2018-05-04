package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import com.oldtom.smartstock.account.service.SecurityService;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.SecondaryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/secondary/*")
public class SecondaryController {

	private static final Logger logger = LoggerFactory.getLogger(SecondaryController.class);
	
	@Inject
	private SecondaryService service;

	@Inject
	private StockDAO sdao;
	
	@RequestMapping(value = "/macd_plus", method = {RequestMethod.GET, RequestMethod.POST})
	public void macd_plus(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			
		}

		model.addAttribute("list",service.macd_plus(vo));

	}
	
	@RequestMapping(value = "/macd_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void macd_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setSign("1");
		}

		model.addAttribute("list",service.macd_rising_falling(vo));
	}
	
	@RequestMapping(value = "/macd_golden_dead", method = {RequestMethod.GET, RequestMethod.POST})
	public void macd_golden_dead(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setSign("1");
		}

		model.addAttribute("list",service.macd_golden_dead(vo));
	}	
	
	@RequestMapping(value = "/rsi", method = {RequestMethod.GET, RequestMethod.POST})
	public void rsi(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(80);		// default, 70%
			vo.setSign("1");		// default, 이상
		}

		model.addAttribute("list",service.rsi(vo));
	}
	
	@RequestMapping(value = "/rsi_updown", method = {RequestMethod.GET, RequestMethod.POST})
	public void rsi_updown(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(30);		// default, RSI = 30%
			vo.setSign("1");		// default, 상향돌파
		}

		model.addAttribute("list",service.rsi_updown(vo));
	}
	
	@RequestMapping(value = "/stocastic_slow", method = {RequestMethod.GET, RequestMethod.POST})
	public void stocastic_slow(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(80);		// default, slowD = 80%
			vo.setSign("1");		// default, 이상
		}

		model.addAttribute("list",service.stocastic_slow(vo));
	}
	
	@RequestMapping(value = "/stocastic_updown", method = {RequestMethod.GET, RequestMethod.POST})
	public void stocastic_updown(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(80);		// default, slowD = 80%
			vo.setSign("1");		// default, 상향돌파
		}

		model.addAttribute("list",service.stocastic_updown(vo));
	}
	
	@RequestMapping(value = "/stocastic_golden_dead", method = {RequestMethod.GET, RequestMethod.POST})
	public void stocastic_golden_dead(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setSign("1");		// default, 골든크로스
		}

		model.addAttribute("list",service.stocastic_golden_dead(vo));
	}
	
	@RequestMapping(value = "/deal_strength", method = {RequestMethod.GET, RequestMethod.POST})
	public void deal_strength(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(1); 		// default, 당일
			vo.setRateM(500); 		// default, 500%
			vo.setSign("1");		// default, 이상
		}

		model.addAttribute("list",service.deal_strength(vo));
	}
	
	@RequestMapping(value = "/deal_strength_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void deal_strength_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(1000); 		// default, 200%
			vo.setSign("1");		// default, 증가
		}

		model.addAttribute("list",service.deal_strength_rising_falling(vo));
	}	
	
	@RequestMapping(value = "/psychology_line10", method = {RequestMethod.GET, RequestMethod.POST})
	public void psychology_line10(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(80); 		// default, 80%
			vo.setSign("1");		// default, 이상
		}

		model.addAttribute("list",service.psychology_line10(vo));
	}
	
	@RequestMapping(value = "/psychology_line10_updown", method = {RequestMethod.GET, RequestMethod.POST})
	public void psychology_line10_updown(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(20); 		// default, 20%
			vo.setSign("1");		// default, 상승 전환
		}

		model.addAttribute("list",service.psychology_line10_updown(vo));
	}	
	
	@RequestMapping(value = "/seperation_rate", method = {RequestMethod.GET, RequestMethod.POST})
	public void seperation_rate(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(20); 	// default, 20일평균선
			vo.setRateM(120); 		// default, 120%
			vo.setSign("1");		// default, 이상
		}

		model.addAttribute("list",service.seperation_rate(vo));
	}	

}

