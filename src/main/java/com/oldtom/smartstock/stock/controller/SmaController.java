package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.SmaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/sma/*")
public class SmaController {

	private static final Logger logger = LoggerFactory.getLogger(SmaController.class);
	
	@Inject
	private SmaService service;

	@Inject
	private StockDAO sdao;
	
	@RequestMapping(value = "/ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setSign("1");		// default, 상향돌파
		}
		
		model.addAttribute("list",service.ma520(vo));

	}
	
	@RequestMapping(value = "/ma20_60", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma20_60(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setSign("1");		// default, 상향돌파
		}
		
		model.addAttribute("list",service.ma2060(vo));

	}	
	

	
	@RequestMapping(value = "/ma5_20_upward_more_m", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20_upward_more_m(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일

			vo.setRateM(5);			//default, 5% 상승

		}
		
		model.addAttribute("list",service.ma520UpwardMoreM(vo));

	}

	
	@RequestMapping(value = "/ma5_20_downward_more_m", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20_downward_more_m(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setRateM(5);			//default, 5% 하락
		}
		
		model.addAttribute("list",service.ma520DownwardMoreM(vo));

	}
	
	@RequestMapping(value = "/ma_arrange", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma_arrange(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일

			vo.setSign("1");		// default, 정배열
		}
		
		model.addAttribute("list",service.maArrange(vo));

	}

	@RequestMapping(value = "/convergent_ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void convergent_ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일

			vo.setSign("1");		// default, 상향돌파
		}
		
		model.addAttribute("list",service.convergentMa520(vo));

	}

	@RequestMapping(value = "/week_ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void week_ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일

			vo.setSign("1");		// default, 상향
		}
		
		model.addAttribute("list",service.wma520(vo));

	}	

	@RequestMapping(value = "/week_ma20_60", method = {RequestMethod.GET, RequestMethod.POST})
	public void week_ma20_60(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일

			vo.setSign("1");		// default, 상향
		}
		
		model.addAttribute("list",service.wma2060(vo));

	}


	@RequestMapping(value = "/ma5_20_more_k", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20_more_k(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//최근 거래일
			vo.setDuration(30); 		// default, 7일
			vo.setCount(3);
			vo.setSign("1");		// default, 상향
		}
		
		model.addAttribute("list",service.ma520MoreK(vo));

	}
	
}

