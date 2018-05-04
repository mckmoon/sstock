package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface SmaService {

	// MA(5,20)
	public List<StockVO> ma520(StockVO vo) throws Exception;
	
	// MA(20,60)
	public List<StockVO> ma2060(StockVO vo) throws Exception;
	
	// MA(5, 20) M% 이상 강하게 상향돌파
	public List<StockVO> ma520UpwardMoreM(StockVO vo) throws Exception;

	// MA(5, 20) M% 이상 강하게 하향돌파
	public List<StockVO> ma520DownwardMoreM(StockVO vo) throws Exception;

	
	// MA 정/역 배열
	public List<StockVO> maArrange(StockVO vo) throws Exception;
	
	// MA(5,20) 수렴후 돌파
	public List<StockVO> convergentMa520(StockVO vo) throws Exception;
	
	// week MA(5,20)
	public List<StockVO> wma520(StockVO vo) throws Exception;
	
	// week (20,60)
	public List<StockVO> wma2060(StockVO vo) throws Exception;
	
	
	// MA(5, 20) K번 이상  돌파
	public List<StockVO> ma520MoreK(StockVO vo) throws Exception;
}
