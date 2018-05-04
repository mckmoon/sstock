package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.FinanceVO;


public interface FinanceService {
	
	// 년 재무지표 기준 종목 추출
	public List<FinanceVO> finance_year(FinanceVO vo) throws Exception;
	
	// 년 재무지표 기준 종목 추출
	public List<FinanceVO> finance_quarter(FinanceVO vo) throws Exception;

	// 년 재무지표 향상 종목 추출
	public List<FinanceVO> finance_year_improve(FinanceVO vo) throws Exception;
	
	// 분기 재무지표 향상 종목 추출
	public List<FinanceVO> finance_quarter_improve(FinanceVO vo) throws Exception;
}
