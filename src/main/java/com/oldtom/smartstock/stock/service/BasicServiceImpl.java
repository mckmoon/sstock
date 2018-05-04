package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import org.springframework.stereotype.Service;

@Service
public class BasicServiceImpl implements BasicService {

	@Inject
	private StockDAO sdao;

	
	@Override
	public List<StockVO> risingFalling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rising_dayN_moreM(vo);
		}
		return sdao.falling_dayN_moreM(vo);
	}

	@Override
	public List<StockVO> fluctuation(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.fluctuation_dayN_moreM(vo);
		}
		return sdao.fluctuation_dayN_lessM(vo);
	}


	@Override
	public List<StockVO> contRisingFalling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.cont_rising_dayN(vo);
		}
		return sdao.cont_falling_dayN(vo);
	}
	
	@Override
	public List<StockVO> holder(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getHolder().equals("KK")) {
			return sdao.holderKK_moreM(vo);
		}
		return sdao.holderN_moreM(vo);
	}


	@Override
	public List<StockVO> foreignRate(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.foreign_rate_rising_dayN_moreM(vo);
		}
		return sdao.foreign_rate_falling_dayN_lessM(vo);
	}
	
	@Override
	public List<StockVO> gongsin(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.gongmaedo_rising_moreM(vo);
		}
		return sdao.sinyong_rising_moreM(vo);
	}

	@Override
	public List<StockVO> foreignBuyingSelling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.foreign_cont_buying_dayN(vo);
		}
		return sdao.foreign_cont_selling_dayN(vo);
	}

	@Override
	public List<StockVO> companyBuyingSelling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.company_cont_buying_dayN(vo);
		}
		return sdao.company_cont_selling_dayN(vo);
	}

	@Override
	public List<StockVO> viewStock(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.view_stock(vo);
	}

}
