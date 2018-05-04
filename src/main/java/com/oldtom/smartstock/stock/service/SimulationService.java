package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface SimulationService {
	
	// ������, ��ǥ�� KOSPI ������
	public float kospi_rate(StockVO vo) throws Exception;
	
	/*
	// ���Ż��¿��� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> convergent_ma5_20_sim(StockVO vo) throws Exception;
	
	// �̵���ռ�(5, 20, 60)�� �ְ� �̰ݷ��� M% �̻�/������ ����
	public List<StockVO> seperation_rate_maN_sim(StockVO vo) throws Exception;	
	*/
	
	/* �⺻ �м� */
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
	

	/* �̵���ռ� �м� */
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

	
	/* ������ǥ �м� */
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

	
	/* ��� �м� */
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
}
