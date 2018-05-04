package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import org.springframework.stereotype.Service;

@Service
public class TodayServiceImpl implements TodayService {

	@Inject
	private StockDAO sdao;

	@Override
	public List<StockVO> ma520(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma520(basedate);
	}

	@Override
	public List<StockVO> ma2060(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma2060(basedate);
	}

	@Override
	public List<StockVO> ma60120(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma60120(basedate);
	}

	@Override
	public List<StockVO> ilmok(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ilmok(basedate);
	}

	@Override
	public List<StockVO> slow(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.slow(basedate);
	}

	@Override
	public List<StockVO> macd(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.macd(basedate);
	}

	@Override
	public List<StockVO> cci(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.cci(basedate);
	}

	@Override
	public List<StockVO> rsi(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.rsi(basedate);
	}

	@Override
	public List<StockVO> sonar(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.sonar(basedate);
	}

	@Override
	public List<StockVO> volume(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.volume(basedate);
	}


	@Override
	public List<StockVO> open_gap_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.gap_rising_moreM(vo);
		}
		return sdao.gap_falling_moreM(vo);			
	}
	

	@Override
	public List<StockVO> renewLowHigh(StockVO vo) throws Exception {
		// TODO Auto-generated method stub

		return sdao.renew_low_high(vo);
	}

	@Override
	public List<StockVO> rising_falling_most(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rising_most_dayN(vo);
		}
		return sdao.falling_most_dayN(vo);		
	}

	@Override
	public List<StockVO> volume_rising_falling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.volume_rising_moreM(vo);
		}
		return sdao.volume_falling_moreM(vo);	
	}

}
