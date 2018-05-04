package com.oldtom.smartstock.stock.persistence;

import java.util.List;

import com.oldtom.smartstock.stock.model.FinanceVO;
import com.oldtom.smartstock.stock.model.NoticeVO;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;

public interface StockDAO {

	// ���� �̸���
	public List<String> hnames() throws Exception;
	
	// �ֱ� n��° �ŷ���
	public String thedate(int day) throws Exception;
	
	// ������/��ǥ�� KOSPI ������
	public float kospi_rate(StockVO vo) throws Exception;

	// 6������ ���� ����
	public List<NoticeVO> notice(StockVO vo) throws Exception;
	
	
	
	/* ���� */
	// N�ŷ��� ���� ���� ���� ����� ����
	public List<UpjongVO> upjong_rising_most_dayN(UpjongVO vo) throws Exception;
	
	// N�ŷ��� ������ �ְ� ������
	public List<StockVO> rising_falling_dayN_by_upjong(UpjongVO vo) throws Exception;
	
	
	
	
	
	/* ������ ���� */
	
	// MA(5,20)
	public List<StockVO> ma520(String basedate) throws Exception;
	
	// MA(20,60)
	public List<StockVO> ma2060(String basedate) throws Exception;
	
	// MA(60,120)
	public List<StockVO> ma60120(String basedate) throws Exception;

	// �ϸ����ǥ(9,26)
	public List<StockVO> ilmok(String basedate) throws Exception;
	
	// Stochastic slow(10,5,5)
	public List<StockVO> slow(String basedate) throws Exception;
	
	// MACD(12,26,9)
	public List<StockVO> macd(String basedate) throws Exception;
	
	// CCI(9)
	public List<StockVO> cci(String basedate) throws Exception;
	
	// RSI(14,9)
	public List<StockVO> rsi(String basedate) throws Exception;
	
	// Sonar(10,5)
	public List<StockVO> sonar(String basedate) throws Exception;
	
	// volume increasing
	public List<StockVO> volume(String basedate) throws Exception;
	

	// N�ŷ��� ���� ���� ���� ����� ����
	public List<StockVO> rising_most_dayN(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ���� ���� �϶��� ����
	public List<StockVO> falling_most_dayN(StockVO vo) throws Exception;
	
	// ���ʰ� �����
	public List<StockVO> gap_rising_moreM(StockVO vo) throws Exception;
	
	// ���ʰ� ���϶�
	public List<StockVO> gap_falling_moreM(StockVO vo) throws Exception;
	
	// N250��, 500�� �ְ�/������ ���� ����
	public List<StockVO> renew_low_high(StockVO vo) throws Exception;
	
	// ���� ��� �ŷ��� ���� ����
	public List<StockVO> volume_rising_moreM(StockVO vo) throws Exception;
	
	// ���� ��� �ŷ��� ���� ����
	public List<StockVO> volume_falling_moreM(StockVO vo) throws Exception;
	
	
	
	/* �繫��ǥ */
	// �� �繫��ǥ ���� ���� ����
	public List<FinanceVO> finance_year(FinanceVO vo) throws Exception;
	
	// �б� �繫��ǥ ���� ���� ����
	public List<FinanceVO> finance_quarter(FinanceVO vo) throws Exception;
	
	// �� �繫��ǥ ��� ���� ����
	public List<FinanceVO> finance_year_improve(FinanceVO vo) throws Exception;
	
	// �б� �繫��ǥ ��� ���� ����
	public List<FinanceVO> finance_quarter_improve(FinanceVO vo) throws Exception;
	
	
	/* �⺻ �м� */
	//N�ŷ��� M% �̻� ����� ����
	public List<StockVO> rising_dayN_moreM(StockVO vo) throws Exception;
	
	//N�ŷ��� M% �̻� �϶��� ����
	public List<StockVO> falling_dayN_moreM(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ��������� M% �̻� ���� ����
	public List<StockVO> fluctuation_dayN_moreM(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ��������� M% �̻� ���� ����
	public List<StockVO> fluctuation_dayN_lessM(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ���� ����� ����
	public List<StockVO> cont_rising_dayN(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ���� �϶��� ����
	public List<StockVO> cont_falling_dayN(StockVO vo) throws Exception;

	// ���ϴ�� ���ŵ����� M% �̻� ���� ����
	public List<StockVO> gongmaedo_rising_moreM(StockVO vo) throws Exception;
	
	// ���ϴ�� �ſ��ܰ� M% �̻� ���� ����
	public List<StockVO> sinyong_rising_moreM(StockVO vo) throws Exception;
	
	// �ֿ��� N�� M% �̻� ���� ����
	public List<StockVO> holderN_moreM(StockVO vo) throws Exception;
	
	// ����/���� ��������ڵ��� M% �̻� ���� ����
	public List<StockVO> holderKK_moreM(StockVO vo) throws Exception;

	// N�ŷ��� �ܱ��� ���з��� M% �̻� ������ ����
	public List<StockVO> foreign_rate_rising_dayN_moreM(StockVO vo) throws Exception;
	
	// N�ŷ��� �ܱ��� ���з��� M% �̻� �϶��� ����
	public List<StockVO> foreign_rate_falling_dayN_lessM(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� �ܱ��� �ż� ����
	public List<StockVO> foreign_cont_buying_dayN(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� �ܱ��� �ŵ� ����
	public List<StockVO> foreign_cont_selling_dayN(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ��� �ż� ����
	public List<StockVO> company_cont_buying_dayN(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ��� �ŵ� ����
	public List<StockVO> company_cont_selling_dayN(StockVO vo) throws Exception;
	
	// ���� ���� ��ȸ
	public List<StockVO> view_stock(StockVO vo) throws Exception;
	
	
	/* �̵� ��ռ� */
	// 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> ma5_20_upward(StockVO vo) throws Exception;
	
	// 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> ma5_20_downward(StockVO vo) throws Exception;
	
	// 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> ma20_60_upward(StockVO vo) throws Exception;
	
	// 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> ma20_60_downward(StockVO vo) throws Exception;
	
	// �ְ� ���迭 ����
	public List<StockVO> ma_arrange_positive(StockVO vo) throws Exception;
	
	// �ְ� ���迭 ����
	public List<StockVO> ma_arrange_negative(StockVO vo) throws Exception;
	
	// ���Ż��¿��� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> convergent_ma5_20_upward(StockVO vo) throws Exception;
	
	// ���Ż��¿��� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> convergent_ma5_20_downward(StockVO vo) throws Exception;

	// �ֺ� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> week_ma5_20_upward(StockVO vo) throws Exception;
	
	// �ֺ� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> week_ma5_20_downward(StockVO vo) throws Exception;
	
	// �ֺ� 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> week_ma20_60_upward(StockVO vo) throws Exception;
	
	// �ֺ� 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> week_ma20_60_downward(StockVO vo) throws Exception;
	
	// 5�ϼ��� 20�ϼ� ���ϰ� ���⵹�� ����
	public List<StockVO> ma5_20_upward_rising_moreM(StockVO vo) throws Exception;
	
	// 5�ϼ��� 20�ϼ� ���ϰ� ���⵹�� ����
	public List<StockVO> ma5_20_downward_falling_moreM(StockVO vo) throws Exception;
	
	// N�����ϵ��� 5�ϼ��� 20�ϼ��� K�� �̻� ���⵹�� ����
	public List<StockVO> ma5_20_upward_dayN_moreK(StockVO vo) throws Exception;
	
	// N�����ϵ��� 5�ϼ��� 20�ϼ��� K�� �̻� ���⵹�� ����
	public List<StockVO> ma5_20_downward_dayN_moreK(StockVO vo) throws Exception;	

	
	
	/* ������ǥ ���� */
	// MACD(12,26,9) + ��ȯ
	public List<StockVO> macd_plus(StockVO vo) throws Exception;

	// MACD(12,26,9) ����߼�
	public List<StockVO> macd_rising_trend(StockVO vo) throws Exception;

	// MACD(12,26,9) �϶��߼�
	public List<StockVO> macd_falling_trend(StockVO vo) throws Exception;

	// MACD(12,26,9) ���ũ�ν�
	public List<StockVO> macd_golden_cross(StockVO vo) throws Exception;

	// MACD(12,26,9) ����ũ�ν�
	public List<StockVO> macd_dead_cross(StockVO vo) throws Exception;	

	// RSI(������ְ�����) M% �̻��� ����
	public List<StockVO> rsi_moreM(StockVO vo) throws Exception;

	// RSI(������ְ�����) M% ������ ����
	public List<StockVO> rsi_lessM(StockVO vo) throws Exception;

	// RSI(������ְ�����) M% ���� ����
	public List<StockVO> rsi_upwardM(StockVO vo) throws Exception;

	//  RSI(������ְ�����) M% ���� ����
	public List<StockVO> rsi_downwardM(StockVO vo) throws Exception;

	//  ����ĳ��ƽ slow(10,5,5) slowD M% �̻�
	public List<StockVO> stocastic_moreM(StockVO vo) throws Exception;

	//  ����ĳ��ƽ slow(10,5,5) slowD M% ����
	public List<StockVO> stocastic_lessM(StockVO vo) throws Exception;
	
	//  ����ĳ��ƽ slow(10,5,5) slowD M% ���� ����
	public List<StockVO> stocastic_upwardM(StockVO vo) throws Exception;
	
	//  ����ĳ��ƽ slow(10,5,5) slowD M% ���� ����
	public List<StockVO> stocastic_downwardM(StockVO vo) throws Exception;

	// ����ĳ��ƽ  slow(10,5,5) %K�� %D�� ���ũ�ν�
	public List<StockVO> stocastic_golden_cross(StockVO vo) throws Exception;

	// ����ĳ��ƽ  slow(10,5,5) %K�� %D�� ����ũ�ν�
	public List<StockVO> stocastic_dead_cross(StockVO vo) throws Exception;		

	// ü�ᰭ���� M% ������ ���� (����ü�ᰭ��, 5����� ����, 10�� ��� ����, 20�� ��� ����)
	public List<StockVO> deal_strength_moreM(StockVO vo) throws Exception;		

	// ü�ᰭ���� M% ������ ���� (����ü�ᰭ��, 5����� ����, 10�� ��� ����, 20�� ��� ����)
	public List<StockVO> deal_strength_lessM(StockVO vo) throws Exception;	
	
	// ü�ᰭ���� ���ϴ�� M% �̻� ������ ����
	public List<StockVO> deal_strength_rising_moreM(StockVO vo) throws Exception;	
	
	// ü�ᰭ���� ���ϴ�� M% �̻� �϶��� ����
	public List<StockVO> deal_strength_falling_moreM(StockVO vo) throws Exception;	

	
	// �̵���ռ�(5, 20, 60)�� �ְ� �̰ݷ��� M% �̻��� ����
	public List<StockVO> seperation_rate_maN_moreM(StockVO vo) throws Exception;	
	
	// �̵���ռ�(5, 20, 60)�� �ְ� �̰ݷ��� M% ������ ����
	public List<StockVO> seperation_rate_maN_lessM(StockVO vo) throws Exception;

	
	// 10�� ���ڽɸ��� M% �̻��� ����
	public List<StockVO> psychology_line10_moreM(StockVO vo) throws Exception;	
	
	// 10�� ���ڽɸ��� M% ������ ����
	public List<StockVO> psychology_line10_lessM(StockVO vo) throws Exception;
	
	// 10�� ���ڽɸ��� M% �Ʒ����� ��� ���� ����
	public List<StockVO> psychology_line10_upwardM(StockVO vo) throws Exception;	
	
	// 10�� ���ڽɸ��� M% ������ �϶� ���� ����
	public List<StockVO> psychology_line10_downwardM(StockVO vo) throws Exception;


	
	/* ��� �м� */
	//5. N�ŷ��� ��������� M%���� ����� ����
	public List<StockVO> rising_dayN_min_lessM(StockVO vo) throws Exception;
	
	//6: N�ŷ��� ��������� M%�̻� ����� ����
	public List<StockVO> rising_dayN_min_moreM(StockVO vo) throws Exception;
		
	//7. N�ŷ��� �ְ������ M%���� �϶��� ����
	public List<StockVO> falling_dayN_max_lessM(StockVO vo) throws Exception;
	
	//8. N�ŷ��� �ְ������ M%�̻� �϶��� ����
	public List<StockVO> falling_dayN_max_moreM(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ����� M% �̻� �϶���, ���� K% �̻� ����� ���� (��� ��� ����)
	public List<StockVO> rising_moreK_after_falling_dayN_max_moreM(StockVO vo) throws Exception;

	// N�ŷ��� ���������� M% �̻� �����, ���� K% �̻� �϶��� ���� (��� ���� ����)
	public List<StockVO> falling_moreK_after_rising_dayN_min_moreM(StockVO vo) throws Exception;	

	// �Ⱓ ��հŷ��� ��� M% ������ ����
	public List<StockVO> volume_downrate_dayN_lessM(StockVO vo) throws Exception;
	
	// �Ⱓ ��հŷ��� ��� M% �̻��� ����
	public List<StockVO> volume_uprate_dayN_moreM(StockVO vo) throws Exception;
	
	// ���� �м�:  250�� �϶� �߼�, �ֱ�5�� �ܱ� ��� ����
	public List<StockVO> day250_decline_day5_rebound(StockVO vo) throws Exception;
	
	// ���� �м�:  120�� �϶� �߼�, �ֱ�5�� �ܱ� ��� ����
	public List<StockVO> day120_decline_day5_rebound(StockVO vo) throws Exception;

	// ���� �м�:  30�� �϶� �߼�, �ֱ�5�� �ܱ� ��� ����
	public List<StockVO> day30_decline_day5_rebound(StockVO vo) throws Exception;

	// ���� �м�:  250�� Ⱦ�� �߼�, �ֱ�5�� �ܱ� ��� ����
	public List<StockVO> day250_flat_day5_rebound(StockVO vo) throws Exception;
	
	// ���� �м�:  120�� Ⱦ�� �߼�, �ֱ�5�� �ܱ� ��� ����
	public List<StockVO> day120_flat_day5_rebound(StockVO vo) throws Exception;

	// ���� �м�:  30�� Ⱦ�� �߼�, �ֱ�5�� �ܱ� ��� ����
	public List<StockVO> day30_flat_day5_rebound(StockVO vo) throws Exception;
	
	
	
	
	
	
	
	/* �ùķ��̼� */
	// ���Ż��¿��� 5�ϼ��� 20�ϼ� ����/���� ���� ����
	//public List<StockVO> convergent_ma5_20_sim(StockVO vo) throws Exception;
	
	// �̵���ռ�(5, 20, 60)�� �ְ� �̰ݷ��� M% �̻�/������ ����
	//public List<StockVO> seperation_rate_maN_sim(StockVO vo) throws Exception;	
	
	// N�ŷ��� �ְ����� M% �̻� �϶���, ���� K% �̻� ����� ���� (��� ��� ����)
	//public List<StockVO> rising_moreK_after_falling_dayN_max_moreM_sim(StockVO vo) throws Exception;
	
	/* �ùķ��̼� - �⺻ �м� */
	//N�ŷ��� M% �̻� ����� ����
	public List<StockVO> rising_dayN_moreM_sim(StockVO vo) throws Exception;
	
	//N�ŷ��� M% �̻� �϶��� ����
	public List<StockVO> falling_dayN_moreM_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ��������� M% �̻� ���� ����
	public List<StockVO> fluctuation_dayN_moreM_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ��������� M% �̻� ���� ����
	public List<StockVO> fluctuation_dayN_lessM_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ���� ����� ����
	public List<StockVO> cont_rising_dayN_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ���� �϶��� ����
	public List<StockVO> cont_falling_dayN_sim(StockVO vo) throws Exception;

	// ���ϴ�� ���ŵ����� M% �̻� ���� ����
	public List<StockVO> gongmaedo_rising_moreM_sim(StockVO vo) throws Exception;
	
	// ���ϴ�� �ſ��ܰ� M% �̻� ���� ����
	public List<StockVO> sinyong_rising_moreM_sim(StockVO vo) throws Exception;
	
	// �ֿ��� N�� M% �̻� ���� ����
	public List<StockVO> holderN_moreM_sim(StockVO vo) throws Exception;
	
	// ����/���� ��������ڵ��� M% �̻� ���� ����
	public List<StockVO> holderKK_moreM_sim(StockVO vo) throws Exception;

	// N�ŷ��� �ܱ��� ���з��� M% �̻� ������ ����
	public List<StockVO> foreign_rate_rising_dayN_moreM_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� �ܱ��� ���з��� M% �̻� �϶��� ����
	public List<StockVO> foreign_rate_falling_dayN_lessM_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� �ܱ��� �ż� ����
	public List<StockVO> foreign_cont_buying_dayN_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� �ܱ��� �ŵ� ����
	public List<StockVO> foreign_cont_selling_dayN_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ��� �ż� ����
	public List<StockVO> company_cont_buying_dayN_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� ���� ��� �ŵ� ����
	public List<StockVO> company_cont_selling_dayN_sim(StockVO vo) throws Exception;
	
	
	
	/* �̵� ��ռ� */
	// 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> ma5_20_upward_sim(StockVO vo) throws Exception;
	
	// 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> ma5_20_downward_sim(StockVO vo) throws Exception;
	
	// 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> ma20_60_upward_sim(StockVO vo) throws Exception;
	
	// 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> ma20_60_downward_sim(StockVO vo) throws Exception;
	
	// �ֺ� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> week_ma5_20_upward_sim(StockVO vo) throws Exception;
	
	// �ֺ� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> week_ma5_20_downward_sim(StockVO vo) throws Exception;
	
	// �ֺ� 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> week_ma20_60_upward_sim(StockVO vo) throws Exception;
	
	// �ֺ� 20�ϼ��� 60�ϼ� ���⵹�� ����
	public List<StockVO> week_ma20_60_downward_sim(StockVO vo) throws Exception;
	
	// 5�ϼ��� 20�ϼ� ���ϰ� ���⵹�� ����
	public List<StockVO> ma5_20_upward_rising_moreM_sim(StockVO vo) throws Exception;
	
	// 5�ϼ��� 20�ϼ� ���ϰ� ���⵹�� ����
	public List<StockVO> ma5_20_downward_falling_moreM_sim(StockVO vo) throws Exception;
	
	// N�����ϵ��� 5�ϼ��� 20�ϼ��� K�� �̻� ���⵹�� ����
	public List<StockVO> ma5_20_upward_dayN_moreK_sim(StockVO vo) throws Exception;
	
	// N�����ϵ��� 5�ϼ��� 20�ϼ��� K�� �̻� ���⵹�� ����
	public List<StockVO> ma5_20_downward_dayN_moreK_sim(StockVO vo) throws Exception;
	
	// �ְ� ���迭 ����
	public List<StockVO> ma_arrange_positive_sim(StockVO vo) throws Exception;
	
	// �ְ� ���迭 ����
	public List<StockVO> ma_arrange_negative_sim(StockVO vo) throws Exception;
	
	// ���Ż��¿��� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> convergent_ma5_20_upward_sim(StockVO vo) throws Exception;
	
	// ���Ż��¿��� 5�ϼ��� 20�ϼ� ���⵹�� ����
	public List<StockVO> convergent_ma5_20_downward_sim(StockVO vo) throws Exception;

	
	
	/* ������ǥ ���� */
	// MACD(12,26,9) + ��ȯ
	public List<StockVO> macd_plus_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) ����߼�
	public List<StockVO> macd_rising_trend_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) �϶��߼�
	public List<StockVO> macd_falling_trend_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) ���ũ�ν�
	public List<StockVO> macd_golden_cross_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) ����ũ�ν�
	public List<StockVO> macd_dead_cross_sim(StockVO vo) throws Exception;	

	// RSI(������ְ�����) M% �̻��� ����
	public List<StockVO> rsi_moreM_sim(StockVO vo) throws Exception;

	// RSI(������ְ�����) M% ������ ����
	public List<StockVO> rsi_lessM_sim(StockVO vo) throws Exception;

	// RSI(������ְ�����) M% ���� ����
	public List<StockVO> rsi_upwardM_sim(StockVO vo) throws Exception;

	//  RSI(������ְ�����) M% ���� ����
	public List<StockVO> rsi_downwardM_sim(StockVO vo) throws Exception;

	//  ����ĳ��ƽ slow(10,5,5) slowD M% �̻�
	public List<StockVO> stocastic_moreM_sim(StockVO vo) throws Exception;

	//  ����ĳ��ƽ slow(10,5,5) slowD M% ����
	public List<StockVO> stocastic_lessM_sim(StockVO vo) throws Exception;
	
	//  ����ĳ��ƽ slow(10,5,5) slowD M% ���� ����
	public List<StockVO> stocastic_upwardM_sim(StockVO vo) throws Exception;
	
	//  ����ĳ��ƽ slow(10,5,5) slowD M% ���� ����
	public List<StockVO> stocastic_downwardM_sim(StockVO vo) throws Exception;

	// ����ĳ��ƽ  slow(10,5,5) %K�� %D�� ���ũ�ν�
	public List<StockVO> stocastic_golden_cross_sim(StockVO vo) throws Exception;

	// ����ĳ��ƽ  slow(10,5,5) %K�� %D�� ����ũ�ν�
	public List<StockVO> stocastic_dead_cross_sim(StockVO vo) throws Exception;		

	// ü�ᰭ���� M% ������ ���� (����ü�ᰭ��, 5����� ����, 10�� ��� ����, 20�� ��� ����)
	public List<StockVO> deal_strength_moreM_sim(StockVO vo) throws Exception;		

	// ü�ᰭ���� M% ������ ���� (����ü�ᰭ��, 5����� ����, 10�� ��� ����, 20�� ��� ����)
	public List<StockVO> deal_strength_lessM_sim(StockVO vo) throws Exception;	
	
	// ü�ᰭ���� ���ϴ�� M% �̻� ������ ����
	public List<StockVO> deal_strength_rising_moreM_sim(StockVO vo) throws Exception;	
	
	// ü�ᰭ���� ���ϴ�� M% �̻� �϶��� ����
	public List<StockVO> deal_strength_falling_moreM_sim(StockVO vo) throws Exception;	

	
	// �̵���ռ�(5, 20, 60)�� �ְ� �̰ݷ��� M% �̻��� ����
	public List<StockVO> seperation_rate_maN_moreM_sim(StockVO vo) throws Exception;	
	
	// �̵���ռ�(5, 20, 60)�� �ְ� �̰ݷ��� M% ������ ����
	public List<StockVO> seperation_rate_maN_lessM_sim(StockVO vo) throws Exception;

	
	// 10�� ���ڽɸ��� M% �̻��� ����
	public List<StockVO> psychology_line10_moreM_sim(StockVO vo) throws Exception;	
	
	// 10�� ���ڽɸ��� M% ������ ����
	public List<StockVO> psychology_line10_lessM_sim(StockVO vo) throws Exception;
	
	// 10�� ���ڽɸ��� M% �Ʒ����� ��� ���� ����
	public List<StockVO> psychology_line10_upwardM_sim(StockVO vo) throws Exception;	
	
	// 10�� ���ڽɸ��� M% ������ �϶� ���� ����
	public List<StockVO> psychology_line10_downwardM_sim(StockVO vo) throws Exception;


	
	/* ��� �м� */
	//5. N�ŷ��� ��������� M%���� ����� ����
	public List<StockVO> rising_dayN_min_lessM_sim(StockVO vo) throws Exception;
	
	//6: N�ŷ��� ��������� M%�̻� ����� ����
	public List<StockVO> rising_dayN_min_moreM_sim(StockVO vo) throws Exception;
		
	//7. N�ŷ��� �ְ������ M%���� �϶��� ����
	public List<StockVO> falling_dayN_max_lessM_sim(StockVO vo) throws Exception;
	
	//8. N�ŷ��� �ְ������ M%�̻� �϶��� ����
	public List<StockVO> falling_dayN_max_moreM_sim(StockVO vo) throws Exception;
	
	// N�ŷ��� �ְ����� M% �̻� �϶���, ���� K% �̻� ����� ���� (��� ��� ����)
	public List<StockVO> rising_moreK_after_falling_dayN_max_moreM_sim(StockVO vo) throws Exception;

	// N�ŷ��� ���������� M% �̻� �����, ���� K% �̻� �϶��� ���� (��� ���� ����)
	public List<StockVO> falling_moreK_after_rising_dayN_min_moreM_sim(StockVO vo) throws Exception;	

	// �Ⱓ ��հŷ��� ��� M% ������ ����
	public List<StockVO> volume_downrate_dayN_lessM_sim(StockVO vo) throws Exception;
	
	// �Ⱓ ��հŷ��� ��� M% �̻��� ����
	public List<StockVO> volume_uprate_dayN_moreM_sim(StockVO vo) throws Exception;
}
