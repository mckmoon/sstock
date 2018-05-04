package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface TodayService {

	// MA(5,20)
	public List<StockVO> ma520(String basedate) throws Exception;
	
	// MA(20,60)
	public List<StockVO> ma2060(String basedate) throws Exception;
	
	// MA(60,120)
	public List<StockVO> ma60120(String basedate) throws Exception;

	// �ϸ����ǥ(9,26)
	public List<StockVO> ilmok(String basedate) throws Exception;
	
	// Stochastic slow(10,5,5)
	public List<StockVO> slow(String basedate) throws Exception;
	
	// MACD(12,26,9)
	public List<StockVO> macd(String basedate) throws Exception;
	
	// CCI(9)
	public List<StockVO> cci(String basedate) throws Exception;
	
	// RSI(14,9)
	public List<StockVO> rsi(String basedate) throws Exception;

	// Sonar(10,5)
	public List<StockVO> sonar(String basedate) throws Exception;
	
	// volume increasing
	public List<StockVO> volume(String basedate) throws Exception;
	

	// ���� ��� ���� ���� ���/�϶��� ����
	public List<StockVO> rising_falling_most(StockVO vo) throws Exception;
	
	
	// ���ʰ� �� ���/�϶�
	public List<StockVO> open_gap_moreM(StockVO vo) throws Exception;	
	
	
	// 250��, 500�� ����/�ְ� ���� ����
	public List<StockVO> renewLowHigh(StockVO vo) throws Exception;
	
	// ���� ��� �ŷ��� 200% �̻� ����/�ް�
	public List<StockVO> volume_rising_falling(StockVO vo) throws Exception;
	
}
