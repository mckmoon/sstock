package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import org.springframework.stereotype.Service;

@Service
public class SecondaryServiceImpl implements SecondaryService {

	@Inject
	private StockDAO sdao;

	@Override
	public List<StockVO> macd_plus(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.macd_plus(vo);
	}

	@Override
	public List<StockVO> macd_rising_falling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.macd_rising_trend(vo);
		}
		return sdao.macd_falling_trend(vo);
	}

	@Override
	public List<StockVO> macd_golden_dead(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.macd_golden_cross(vo);
		}
		return sdao.macd_dead_cross(vo);
	}

	@Override
	public List<StockVO> rsi(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rsi_moreM(vo);
		}
		return sdao.rsi_lessM(vo);
	}

	@Override
	public List<StockVO> rsi_updown(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rsi_upwardM(vo);
		}
		return sdao.rsi_downwardM(vo);
	}

	@Override
	public List<StockVO> stocastic_slow(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.stocastic_moreM(vo);
		}
		return sdao.stocastic_lessM(vo);
	}

	@Override
	public List<StockVO> stocastic_updown(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.stocastic_upwardM(vo);
		}
		return sdao.stocastic_downwardM(vo);
	}

	@Override
	public List<StockVO> stocastic_golden_dead(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.stocastic_golden_cross(vo);
		}
		return sdao.stocastic_dead_cross(vo);
	}

	@Override
	public List<StockVO> deal_strength(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.deal_strength_moreM(vo);
		}
		return sdao.deal_strength_lessM(vo);
	}

	@Override
	public List<StockVO> deal_strength_rising_falling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.deal_strength_rising_moreM(vo);
		}
		return sdao.deal_strength_falling_moreM(vo);
	}

	@Override
	public List<StockVO> psychology_line10(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.psychology_line10_moreM(vo);
		}
		return sdao.psychology_line10_lessM(vo);
	}

	@Override
	public List<StockVO> psychology_line10_updown(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.psychology_line10_upwardM(vo);
		}
		return sdao.psychology_line10_downwardM(vo);
	}

	@Override
	public List<StockVO> seperation_rate(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.seperation_rate_maN_moreM(vo);
		}
		return sdao.seperation_rate_maN_lessM(vo);
	}

	
	
}
