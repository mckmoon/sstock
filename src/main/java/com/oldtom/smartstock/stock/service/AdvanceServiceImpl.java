package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import org.springframework.stereotype.Service;

@Service
public class AdvanceServiceImpl implements AdvanceService {

	@Inject
	private StockDAO sdao;


	@Override
	public List<StockVO> risingNdaysMin(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rising_dayN_min_moreM(vo);
		}
		return sdao.rising_dayN_min_lessM(vo);
	}

	@Override
	public List<StockVO> fallingNdaysMax(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.falling_dayN_max_moreM(vo);
		}
		return sdao.falling_dayN_max_lessM(vo);
	}

	@Override
	public List<StockVO> fallingNdaysMaxPositivePole(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.rising_moreK_after_falling_dayN_max_moreM(vo);
	}

	@Override
	public List<StockVO> risingNdaysMinNegativePole(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.falling_moreK_after_rising_dayN_min_moreM(vo);
		
	}

	@Override
	public List<StockVO> volume_rate_ndays_avg(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.volume_uprate_dayN_moreM(vo);
		}
		return sdao.volume_downrate_dayN_lessM(vo);
	}

	@Override
	public List<StockVO> pattern_analysis(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		String pattern = vo.getSign();
		
		if (pattern.equals("1")) {
			return sdao.day250_decline_day5_rebound(vo);
		} else if (pattern.equals("2")) {
			return sdao.day120_decline_day5_rebound(vo);
		} else if (pattern.equals("3")) {
			return sdao.day30_decline_day5_rebound(vo);
		} else if (pattern.equals("4")) {
			return sdao.day250_flat_day5_rebound(vo);
		} else if (pattern.equals("5")) {
			return sdao.day120_flat_day5_rebound(vo);
		} 
			
		return sdao.day30_flat_day5_rebound(vo);
	
	}


}
