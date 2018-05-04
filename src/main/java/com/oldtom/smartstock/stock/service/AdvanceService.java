package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface AdvanceService {
	
	// N거래일 최저가보다 상승한 종목
	public List<StockVO> risingNdaysMin(StockVO vo) throws Exception;
	
	// N거래일 최고가보다 하락한 종목
	public List<StockVO> fallingNdaysMax(StockVO vo) throws Exception;	

	
	// N거래일 최고가보다 M%이상 하락한후 당일 K%이상 상승한 종목
	public List<StockVO> fallingNdaysMaxPositivePole(StockVO vo) throws Exception;
	
	// N거래일 최저가보다 M%이상 상승한후 당일 K%이상 하락한 종목
	public List<StockVO> risingNdaysMinNegativePole(StockVO vo) throws Exception;

	// N거래일 평균거래량 대비 M% 이상/이하인 종목
	public List<StockVO> volume_rate_ndays_avg(StockVO vo) throws Exception;
	
	// 패턴분석
	public List<StockVO> pattern_analysis(StockVO vo) throws Exception;
}
