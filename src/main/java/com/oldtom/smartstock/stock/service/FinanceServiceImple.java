package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.oldtom.smartstock.stock.model.FinanceVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;

@Service
public class FinanceServiceImple implements FinanceService{
	
	@Inject
	private StockDAO sdao;
	
	@Override
	public List<FinanceVO> finance_year(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.finance_year(vo);
	}

	@Override
	public List<FinanceVO> finance_quarter(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.finance_quarter(vo);
	}

	@Override
	public List<FinanceVO> finance_year_improve(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.finance_year_improve(vo);
	}

	@Override
	public List<FinanceVO> finance_quarter_improve(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.finance_quarter_improve(vo);
	}

}
