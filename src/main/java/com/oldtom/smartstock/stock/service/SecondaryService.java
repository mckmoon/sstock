package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface SecondaryService {

	//  MACD + 전환
	public List<StockVO> macd_plus(StockVO vo) throws Exception;
	
	// MACD 기준선에서 지속 상승/하락
	public List<StockVO> macd_rising_falling(StockVO vo) throws Exception;
	
	// MACD 골든/데트 크로스 발생
	public List<StockVO> macd_golden_dead(StockVO vo) throws Exception;

	// RSI M% 이상/이하
	public List<StockVO> rsi(StockVO vo) throws Exception;

	// RSI 기준율 상향/하향 돌파
	public List<StockVO> rsi_updown(StockVO vo) throws Exception;	
	
	// 스토캐스틱 slowD M% 이상/이하
	public List<StockVO> stocastic_slow(StockVO vo) throws Exception;
	
	// 스토캐스틱 기준율 상향/하향 돌파
	public List<StockVO> stocastic_updown(StockVO vo) throws Exception;
	
	// 스토캐스틱 골든/데드 크로스 발생
	public List<StockVO> stocastic_golden_dead(StockVO vo) throws Exception;
	
	// 체결강도 M% 이상/이하
	public List<StockVO> deal_strength(StockVO vo) throws Exception;
	
	// 체결강도 전일대비 상승/하락
	public List<StockVO> deal_strength_rising_falling(StockVO vo) throws Exception;
		
	// 10일-투자심리선 M% 이상/이하
	public List<StockVO> psychology_line10(StockVO vo) throws Exception;
	
	// 10일-투자심리선 전환
	public List<StockVO> psychology_line10_updown(StockVO vo) throws Exception;
	
	// 이동평균선과 주가 이격률 M% 이상/이하
	public List<StockVO> seperation_rate(StockVO vo) throws Exception;

}
