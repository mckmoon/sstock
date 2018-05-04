package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface BasicService {
	
	// 기간 상승/하락 종목
	public List<StockVO> risingFalling(StockVO vo) throws Exception;
	
	// N개장일 주가변동이 +- M% 이상/이하인 종목
	public List<StockVO> fluctuation(StockVO vo) throws Exception;
				
	// N거래일 동안 연속 상승/하락 종목
	public List<StockVO> contRisingFalling(StockVO vo) throws Exception;
	
	// 전일대비 공매도량/신용잔고가 M% 이상 증가한 종목
	public List<StockVO> gongsin(StockVO vo) throws Exception;
	
	// 기관투자자가 M% 이상 보유한 종목
	public List<StockVO> holder(StockVO vo) throws Exception;
	
	// N개장일 외국인 지분율이 M% 이상 증가/감소 종목
	public List<StockVO> foreignRate(StockVO vo) throws Exception;
	
	// N개장일 연속 외국인 매수/매도 종목
	public List<StockVO> foreignBuyingSelling(StockVO vo) throws Exception;
	
	// N개장일 연속 기관 매수/매도 종목
	public List<StockVO> companyBuyingSelling(StockVO vo) throws Exception;

	// 종목 정보 조회
	public List<StockVO> viewStock(StockVO vo) throws Exception;
}
