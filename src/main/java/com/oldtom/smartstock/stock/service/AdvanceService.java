package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface AdvanceService {
	
	// N�ŷ��� ���������� ����� ����
	public List<StockVO> risingNdaysMin(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ����� �϶��� ����
	public List<StockVO> fallingNdaysMax(StockVO vo) throws Exception;	

	
	// N�ŷ��� �ְ����� M%�̻� �϶����� ���� K%�̻� ����� ����
	public List<StockVO> fallingNdaysMaxPositivePole(StockVO vo) throws Exception;
	
	// N�ŷ��� ���������� M%�̻� ������� ���� K%�̻� �϶��� ����
	public List<StockVO> risingNdaysMinNegativePole(StockVO vo) throws Exception;

	// N�ŷ��� ��հŷ��� ��� M% �̻�/������ ����
	public List<StockVO> volume_rate_ndays_avg(StockVO vo) throws Exception;
	
	// ���Ϻм�
	public List<StockVO> pattern_analysis(StockVO vo) throws Exception;
}
