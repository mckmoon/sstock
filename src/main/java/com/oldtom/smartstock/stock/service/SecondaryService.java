package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface SecondaryService {

	//  MACD + ��ȯ
	public List<StockVO> macd_plus(StockVO vo) throws Exception;
	
	// MACD ���ؼ����� ���� ���/�϶�
	public List<StockVO> macd_rising_falling(StockVO vo) throws Exception;
	
	// MACD ���/��Ʈ ũ�ν� �߻�
	public List<StockVO> macd_golden_dead(StockVO vo) throws Exception;

	// RSI M% �̻�/����
	public List<StockVO> rsi(StockVO vo) throws Exception;

	// RSI ������ ����/���� ����
	public List<StockVO> rsi_updown(StockVO vo) throws Exception;	
	
	// ����ĳ��ƽ slowD M% �̻�/����
	public List<StockVO> stocastic_slow(StockVO vo) throws Exception;
	
	// ����ĳ��ƽ ������ ����/���� ����
	public List<StockVO> stocastic_updown(StockVO vo) throws Exception;
	
	// ����ĳ��ƽ ���/���� ũ�ν� �߻�
	public List<StockVO> stocastic_golden_dead(StockVO vo) throws Exception;
	
	// ü�ᰭ�� M% �̻�/����
	public List<StockVO> deal_strength(StockVO vo) throws Exception;
	
	// ü�ᰭ�� ���ϴ�� ���/�϶�
	public List<StockVO> deal_strength_rising_falling(StockVO vo) throws Exception;
		
	// 10��-���ڽɸ��� M% �̻�/����
	public List<StockVO> psychology_line10(StockVO vo) throws Exception;
	
	// 10��-���ڽɸ��� ��ȯ
	public List<StockVO> psychology_line10_updown(StockVO vo) throws Exception;
	
	// �̵���ռ��� �ְ� �̰ݷ� M% �̻�/����
	public List<StockVO> seperation_rate(StockVO vo) throws Exception;

}
