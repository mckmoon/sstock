package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;

public interface UpjongService {
	
	// �Ⱓ ���/�϶� ����
	public List<UpjongVO> rising_most_dayN(UpjongVO vo) throws Exception;
	
	// N�ŷ��� ������ �ְ� ������
	public List<StockVO> rising_falling_dayN_by_upjong(UpjongVO vo) throws Exception;

}
