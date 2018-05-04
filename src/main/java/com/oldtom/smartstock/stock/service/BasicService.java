package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface BasicService {
	
	// �Ⱓ ���/�϶� ����
	public List<StockVO> risingFalling(StockVO vo) throws Exception;
	
	// N������ �ְ������� +- M% �̻�/������ ����
	public List<StockVO> fluctuation(StockVO vo) throws Exception;
				
	// N�ŷ��� ���� ���� ���/�϶� ����
	public List<StockVO> contRisingFalling(StockVO vo) throws Exception;
	
	// ���ϴ�� ���ŵ���/�ſ��ܰ� M% �̻� ������ ����
	public List<StockVO> gongsin(StockVO vo) throws Exception;
	
	// ��������ڰ� M% �̻� ������ ����
	public List<StockVO> holder(StockVO vo) throws Exception;
	
	// N������ �ܱ��� �������� M% �̻� ����/���� ����
	public List<StockVO> foreignRate(StockVO vo) throws Exception;
	
	// N������ ���� �ܱ��� �ż�/�ŵ� ����
	public List<StockVO> foreignBuyingSelling(StockVO vo) throws Exception;
	
	// N������ ���� ��� �ż�/�ŵ� ����
	public List<StockVO> companyBuyingSelling(StockVO vo) throws Exception;

	// ���� ���� ��ȸ
	public List<StockVO> viewStock(StockVO vo) throws Exception;
}
