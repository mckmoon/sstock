package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;

@Service
public class SmaServiceImpl implements SmaService{

	@Inject
	private StockDAO sdao;
	
	@Override
	public List<StockVO> ma520(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma5_20_upward(vo);
		}
		return sdao.ma5_20_downward(vo);
	}

	@Override
	public List<StockVO> ma2060(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma20_60_upward(vo);
		}
		return sdao.ma20_60_downward(vo);
	}

	@Override
	public List<StockVO> ma520UpwardMoreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma5_20_upward_rising_moreM(vo);
	}

	@Override
	public List<StockVO> ma520DownwardMoreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma5_20_downward_falling_moreM(vo);
	}
	
	@Override
	public List<StockVO> ma520MoreK(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma5_20_upward_dayN_moreK(vo);
		}
		return sdao.ma5_20_downward_dayN_moreK(vo);
	}

	@Override
	public List<StockVO> maArrange(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma_arrange_positive(vo);
		}
		return sdao.ma_arrange_negative(vo);
	}

	@Override
	public List<StockVO> convergentMa520(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.convergent_ma5_20_upward(vo);
		}
		return sdao.convergent_ma5_20_downward(vo);
	}

	@Override
	public List<StockVO> wma520(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.week_ma5_20_upward(vo);
		}
		return sdao.week_ma5_20_downward(vo);
	}

	@Override
	public List<StockVO> wma2060(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.week_ma20_60_upward(vo);
		}
		return sdao.week_ma20_60_downward(vo);
	}

}
