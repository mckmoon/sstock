package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface SmaService {

	// MA(5,20)
	public List<StockVO> ma520(StockVO vo) throws Exception;
	
	// MA(20,60)
	public List<StockVO> ma2060(StockVO vo) throws Exception;
	
	// MA(5, 20) M% �̻� ���ϰ� ���⵹��
	public List<StockVO> ma520UpwardMoreM(StockVO vo) throws Exception;

	// MA(5, 20) M% �̻� ���ϰ� ���⵹��
	public List<StockVO> ma520DownwardMoreM(StockVO vo) throws Exception;

	
	// MA ��/�� �迭
	public List<StockVO> maArrange(StockVO vo) throws Exception;
	
	// MA(5,20) ������ ����
	public List<StockVO> convergentMa520(StockVO vo) throws Exception;
	
	// week MA(5,20)
	public List<StockVO> wma520(StockVO vo) throws Exception;
	
	// week (20,60)
	public List<StockVO> wma2060(StockVO vo) throws Exception;
	
	
	// MA(5, 20) K�� �̻�  ����
	public List<StockVO> ma520MoreK(StockVO vo) throws Exception;
}
