package com.oldtom.smartstock.stock.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.account.service.SecurityService;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import com.oldtom.smartstock.stock.service.AdvanceService;
import com.oldtom.smartstock.stock.service.SimulationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/simulation/*")
public class SimulationController {

	private static final Logger logger = LoggerFactory.getLogger(SimulationController.class);
	
	@Inject
	private SimulationService service;

	@Inject
	private StockDAO sdao;

	@RequestMapping(value = "/notice", method = {RequestMethod.GET, RequestMethod.POST})
	public void notice(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		logger.info("basedate: " + vo.getBasedate());
		model.addAttribute("list", sdao.notice(vo));

	}
	
	// �⺻�м�
	@RequestMapping(value = "/basic/rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(20); 	// default, 20����ռ�
			vo.setRateM(30); 		// default, 30%
			vo.setSign("1");		// default, ���	
		}
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.risingFalling(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);

	}
		

	
	@RequestMapping(value = "/basic/fluctuation", method = {RequestMethod.GET, RequestMethod.POST})
	public void fluctuation(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(30); 	// default, 30����ռ�
			vo.setRateM(3); 		// default, 0%
			vo.setSign("2");		// default, ����
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.fluctuation(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}


	@RequestMapping(value = "/basic/cont_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void cont_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(5); 		// default, 7�ŷ���
			vo.setSign("1");		// default, ���
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.contRisingFalling(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}


	
	@RequestMapping(value = "/basic/holder", method = {RequestMethod.GET, RequestMethod.POST})
	public void holder(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setHolder("���ο���"); 		// default, 7�ŷ���
			vo.setRateM(13);		// default, ���
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.holder(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/basic/gongsin", method = {RequestMethod.GET, RequestMethod.POST})
	public void gongsin(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(500); 		// default, 500%
			vo.setSign("1");		// default, ���ŵ�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.gongsin(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	
	@RequestMapping(value = "/basic/foreign_buying_selling", method = {RequestMethod.GET, RequestMethod.POST})
	public void foreign_buying_selling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(7); 		// default, 7��
			vo.setSign("1");		// default, �ż�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.foreignBuyingSelling(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	
	@RequestMapping(value = "/basic/company_buying_selling", method = {RequestMethod.GET, RequestMethod.POST})
	public void company_buying_selling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(7); 		// default, 7��
			vo.setSign("1");		// default, �ż�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.companyBuyingSelling(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/basic/foreign_rate", method = {RequestMethod.GET, RequestMethod.POST})
	public void foreign_rate(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(30); 		// default, 7��
			vo.setRateM(5);
			vo.setSign("1");		// default, �ż�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.foreignRate(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	
	// �̵���ռ� �м�
	@RequestMapping(value = "/sma/ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ���⵹��
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.ma520(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/sma/ma20_60", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma20_60(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ���⵹��
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.ma2060(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}	
	
	@RequestMapping(value = "/sma/ma5_20_upward_more_m", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20_upward_more_m(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(5);			//default, 5% ���

		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.ma520UpwardMoreM(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}

	
	@RequestMapping(value = "/sma/ma5_20_downward_more_m", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20_downward_more_m(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(5);			//default, 5% �϶�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.ma520DownwardMoreM(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/sma/ma_arrange", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma_arrange(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ���迭
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.maArrange(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/sma/convergent_ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void convergent_ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ���⵹��
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.convergentMa520(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/sma/week_ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void week_ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ����
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.wma520(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}	

	@RequestMapping(value = "/sma/week_ma20_60", method = {RequestMethod.GET, RequestMethod.POST})
	public void week_ma20_60(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ����
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.wma2060(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}

	@RequestMapping(value = "/sma/ma5_20_more_k", method = {RequestMethod.GET, RequestMethod.POST})
	public void ma5_20_more_k(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(30); 		// default, 7��
			vo.setCount(3);
			vo.setSign("1");		// default, ����
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.ma520MoreK(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}

	
	
	
	// ���� ��ǥ
	@RequestMapping(value = "/secondary/macd_plus", method = {RequestMethod.GET, RequestMethod.POST})
	public void macd_plus(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));			
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.macd_plus(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/macd_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void macd_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.macd_rising_falling(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/macd_golden_dead", method = {RequestMethod.GET, RequestMethod.POST})
	public void macd_golden_dead(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.macd_golden_dead(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}	
	
	@RequestMapping(value = "/secondary/rsi", method = {RequestMethod.GET, RequestMethod.POST})
	public void rsi(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(80);		// default, 70%
			vo.setSign("1");		// default, �̻�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.rsi(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/rsi_updown", method = {RequestMethod.GET, RequestMethod.POST})
	public void rsi_updown(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(30);		// default, RSI = 30%
			vo.setSign("1");		// default, ���⵹��
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.rsi_updown(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/stocastic_slow", method = {RequestMethod.GET, RequestMethod.POST})
	public void stocastic_slow(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(80);		// default, slowD = 80%
			vo.setSign("1");		// default, �̻�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.stocastic_updown(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/stocastic_updown", method = {RequestMethod.GET, RequestMethod.POST})
	public void stocastic_updown(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(80);		// default, slowD = 80%
			vo.setSign("1");		// default, ���⵹��
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.stocastic_updown(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/stocastic_golden_dead", method = {RequestMethod.GET, RequestMethod.POST})
	public void stocastic_golden_dead(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ���ũ�ν�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.stocastic_golden_dead(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/deal_strength", method = {RequestMethod.GET, RequestMethod.POST})
	public void deal_strength(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(1); 		// default, ����
			vo.setRateM(500); 		// default, 500%
			vo.setSign("1");		// default, �̻�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.deal_strength(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/deal_strength_rising_falling", method = {RequestMethod.GET, RequestMethod.POST})
	public void deal_strength_rising_falling(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(1000); 		// default, 200%
			vo.setSign("1");		// default, ����
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.deal_strength_rising_falling(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}	
	
	@RequestMapping(value = "/secondary/psychology_line10", method = {RequestMethod.GET, RequestMethod.POST})
	public void psychology_line10(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(80); 		// default, 80%
			vo.setSign("1");		// default, �̻�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.psychology_line10(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/secondary/psychology_line10_updown", method = {RequestMethod.GET, RequestMethod.POST})
	public void psychology_line10_updown(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setRateM(20); 		// default, 20%
			vo.setSign("1");		// default, ��� ��ȯ
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.psychology_line10_updown(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}	
	
	@RequestMapping(value = "/secondary/seperation_rate", method = {RequestMethod.GET, RequestMethod.POST})
	public void seperation_rate(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(20); 	// default, 20����ռ�
			vo.setRateM(120); 		// default, 120%
			vo.setSign("1");		// default, �̻�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.seperation_rate(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}	

	
	
	
	// ��޺м�
	@RequestMapping(value = "/advance/rising_ndays_min", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_ndays_min(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(10); 		// default, 7��
			vo.setRateM(30);				// ��·�
			vo.setSign("1");			// default, �̻�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.risingNdaysMin(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);

	}
	
	@RequestMapping(value = "/advance/falling_ndays_max", method = {RequestMethod.GET, RequestMethod.POST})
	public void falling_ndays_max(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(10); 		// default, 7��
			vo.setRateM(20);				// ��·�
			vo.setSign("1");			// default, �̻�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.fallingNdaysMax(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);

	}	

	
	@RequestMapping(value = "/advance/falling_ndays_max_positive_pole", method = {RequestMethod.GET, RequestMethod.POST})
	public void falling_ndays_max_positive_pole(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(30); 		// default, 7��
			vo.setRateM(20);				// �Ⱓ �϶���
			vo.setRateK(5);				// ���� ��·�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.fallingNdaysMaxPositivePole(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/advance/rising_ndays_min_negative_pole", method = {RequestMethod.GET, RequestMethod.POST})
	public void rising_ndays_min_negative_pole(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(30); 		// default, 7��
			vo.setRateM(20);			// �Ⱓ ��·�
			vo.setRateK(5);				// ���� �϶���

		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.risingNdaysMinNegativePole(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/advance/volume_rate_ndays_avg", method = {RequestMethod.GET, RequestMethod.POST})
	public void volume_rate_ndays_avg(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setDuration(30); 		// default, 7��
			vo.setRateM(300);				// ��·�
			vo.setSign("1");			// default, �̻�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.volume_rate_ndays_avg(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);
	}
	/*
	@RequestMapping(value = "/convergent_ma5_20", method = {RequestMethod.GET, RequestMethod.POST})
	public void convergent_ma5_20(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			vo.setSign("1");		// default, ���⵹��		
		}
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.convergent_ma5_20(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		model.addAttribute("list", list);

	}

	@RequestMapping(value = "/seperation_rate", method = {RequestMethod.GET, RequestMethod.POST})
	public void seperation_rate(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			
			vo.setDuration(20); 	// default, 20����ռ�
			vo.setRateM(120); 		// default, 120%
			vo.setSign("1");		// default, �̻�
		}

		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.seperation_rate_maN(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		
		model.addAttribute("list",list);
	}
	
	@RequestMapping(value = "/falling_ndays_max_positive_pole", method = {RequestMethod.GET, RequestMethod.POST})
	public void falling_ndays_max_positive_pole(@ModelAttribute("vo") StockVO vo,
						Model model) throws Exception {
		
		if (vo.getBasedate() == null) {

			vo.setBasedate(sdao.thedate(5));
			vo.setTargetdate(sdao.thedate(0));
			
			vo.setDuration(30); 		// default, 7��
			vo.setRateM(20);				// �Ⱓ �϶���
			vo.setRateK(5);				// ���� ��·�
		}
		
		int plus = 0;
		int equal = 0;
		int minus = 0;
		
		List<StockVO> list = service.rising_moreK_after_falling_dayN_max_moreM(vo);
		for (StockVO stock : list) {
			if (stock.getTargetprice1() > stock.getPrice1()) {
				plus++;
			}
			else if (stock.getTargetprice1() == stock.getPrice1()) {
				equal++;
			}
			else {
				minus++;
			}
		}
		
		float kospi_rate = service.kospi_rate(vo);
		model.addAttribute("kospi_rate", kospi_rate);
		model.addAttribute("plus", plus);
		model.addAttribute("equal", equal);
		model.addAttribute("minus", minus);
		
		model.addAttribute("list",list);

	}
	*/
	
}

