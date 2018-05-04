package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;

public interface UpjongService {
	
	// 기간 상승/하락 업종
	public List<UpjongVO> rising_most_dayN(UpjongVO vo) throws Exception;
	
	// N거래일 업종별 주가 변동률
	public List<StockVO> rising_falling_dayN_by_upjong(UpjongVO vo) throws Exception;

}
