package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.account.service.SecurityService;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.BasicService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/basic/*")
public class BasicController {

	private static final Logger logger = LoggerFactory.getLogger(BasicController.class);
	
	@Inject
	private BasicService service;

	@Inject
	private StockDAO sdao;
	
	@RequestMapping(value = "/rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(20); 	// default, 20����ռ�
			vo.setRateM(30); 		// default, 30%
			vo.setSign("1");		// default, ���
		}
		
		model.addAttribute("list",service.risingFalling(vo));

	}
		

	
	@RequestMapping(value = "/fluctuation", method = {RequestMethod.GET, RequestMethod.POST})
	public void fluctuation(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(30); 	// default, 30����ռ�
			vo.setRateM(3); 		// default, 0%
			vo.setSign("2");		// default, ����
		}
		
		model.addAttribute("list",service.fluctuation(vo));

	}


	@RequestMapping(value = "/cont_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void cont_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(5); 		// default, 7�ŷ���
			vo.setSign("1");		// default, ���
		}
		
		model.addAttribute("list",service.contRisingFalling(vo));

	}


	
	@RequestMapping(value = "/holder", method = {RequestMethod.GET, RequestMethod.POST})
	public void holder(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setHolder("���ο���"); 		// default, 7�ŷ���
			vo.setRateM(13);		// default, ���
		}
		
		model.addAttribute("list",service.holder(vo));

	}
	
	@RequestMapping(value = "/gongsin", method = {RequestMethod.GET, RequestMethod.POST})
	public void gongsin(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setRateM(500); 		// default, 500%
			vo.setSign("1");		// default, ���ŵ�
		}
		
		model.addAttribute("list",service.gongsin(vo));

	}
	
	
	@RequestMapping(value = "/foreign_buying_selling", method = {RequestMethod.GET, RequestMethod.POST})
	public void foreign_buying_selling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(7); 		// default, 7��
			vo.setSign("1");		// default, �ż�
		}
		
		model.addAttribute("list",service.foreignBuyingSelling(vo));

	}
	
	
	@RequestMapping(value = "/company_buying_selling", method = {RequestMethod.GET, RequestMethod.POST})
	public void company_buying_selling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(7); 		// default, 7��
			vo.setSign("1");		// default, �ż�
		}
		
		model.addAttribute("list",service.companyBuyingSelling(vo));

	}
	
	@RequestMapping(value = "/foreign_rate", method = {RequestMethod.GET, RequestMethod.POST})
	public void foreign_rate(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(30); 		// default, 7��
			vo.setRateM(5);
			vo.setSign("1");		// default, �ż�
		}
		
		model.addAttribute("list",service.foreignRate(vo));

	}


	@RequestMapping(value = "/modal_notice", method = {RequestMethod.GET, RequestMethod.POST})
	public void modal_notice(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		logger.info("basedate: " + vo.getBasedate());
		model.addAttribute("list", sdao.notice(vo));

	}	
	
	@RequestMapping(value = "/view_stock", method = {RequestMethod.GET, RequestMethod.POST})
	public void view_stock(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(0));	//�ֱ� �ŷ���
			vo.setDuration(5);
			vo.setHname("�Ｚ����");
		}
		
		vo.setStartdate(sdao.thedate(vo.getDuration()-1));		
		model.addAttribute("list",service.viewStock(vo));

	}
	
	// ������� �������� ���� �޽��
	@RequestMapping(value = "/get_hnames", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<List<String>> get_hnames() throws Exception {
		
		List<String> data = sdao.hnames();
		return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);

	}
}

