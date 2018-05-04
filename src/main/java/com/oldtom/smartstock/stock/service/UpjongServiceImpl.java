package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;
import org.springframework.stereotype.Service;

@Service
public class UpjongServiceImpl implements UpjongService {

	@Inject
	private StockDAO sdao;

	
	@Override
	public List<UpjongVO> rising_most_dayN(UpjongVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.upjong_rising_most_dayN(vo);
	}


	@Override
	public List<StockVO> rising_falling_dayN_by_upjong(UpjongVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.rising_falling_dayN_by_upjong(vo);
	}


}
