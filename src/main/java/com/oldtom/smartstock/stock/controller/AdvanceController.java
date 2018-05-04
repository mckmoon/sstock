package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import com.oldtom.smartstock.account.service.SecurityService;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.AdvanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/advance/*")
public class AdvanceController {

	private static final Logger logger = LoggerFactory.getLogger(AdvanceController.class);
	
	@Inject
	private AdvanceService service;

	@Inject
	private StockDAO sdao;
	
	@RequestMapping(value = "/rising_ndays_min", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_ndays_min(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {
			/*
			DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
				cal.add(Calendar.DATE, -3);
			else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				cal.add(Calendar.DATE, -2);
			else
				cal.add(Calendar.DATE, -1);
			
			vo.setBasedate(dtf.format(cal.getTime()));
			*/
			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(10); 		// default, 7일
			vo.setRateM(30);				// 상승률
			vo.setSign("1");			// default, 이상
		}
		
		model.addAttribute("list",service.risingNdaysMin(vo));


	}
	
	@RequestMapping(value = "/falling_ndays_max", method = {RequestMethod.GET, RequestMethod.POST})
	public void falling_ndays_max(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(10); 		// default, 7일
			vo.setRateM(20);				// 상승률
			vo.setSign("1");			// default, 이상
		}
		
		model.addAttribute("list",service.fallingNdaysMax(vo));


	}	

	
	@RequestMapping(value = "/falling_ndays_max_positive_pole", method = {RequestMethod.GET, RequestMethod.POST})
	public void falling_ndays_max_positive_pole(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(30); 		// default, 7일
			vo.setRateM(20);				// 기간 하락률
			vo.setRateK(5);				// 당일 상승률
		}
		
		model.addAttribute("list",service.fallingNdaysMaxPositivePole(vo));

	}
	
	@RequestMapping(value = "/rising_ndays_min_negative_pole", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_ndays_min_negative_pole(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(30); 		// default, 7일
			vo.setRateM(20);			// 기간 상승률
			vo.setRateK(5);				// 당일 하락률

		}
		
		model.addAttribute("list",service.risingNdaysMinNegativePole(vo));

	}
	
	@RequestMapping(value = "/volume_rate_ndays_avg", method = {RequestMethod.GET, RequestMethod.POST})
	public void volume_rate_ndays_avg(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(30); 		// default, 7일
			vo.setRateM(300);				// 상승률
			vo.setSign("1");			// default, 이상
		}
		
		model.addAttribute("list",service.volume_rate_ndays_avg(vo));

	}

	@RequestMapping(value = "/pattern_analysis", method = {RequestMethod.GET, RequestMethod.POST})
	public void pattern_analysis(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setSign("1");					// default, 장기 하락 추세_단기 반등
		}
		
		model.addAttribute("list",service.pattern_analysis(vo));

	}
}

