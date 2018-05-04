package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.FinanceVO;


public interface FinanceService {
	
	// �� �繫��ǥ ���� ���� ����
	public List<FinanceVO> finance_year(FinanceVO vo) throws Exception;
	
	// �� �繫��ǥ ���� ���� ����
	public List<FinanceVO> finance_quarter(FinanceVO vo) throws Exception;

	// �� �繫��ǥ ��� ���� ����
	public List<FinanceVO> finance_year_improve(FinanceVO vo) throws Exception;
	
	// �б� �繫��ǥ ��� ���� ����
	public List<FinanceVO> finance_quarter_improve(FinanceVO vo) throws Exception;
}
