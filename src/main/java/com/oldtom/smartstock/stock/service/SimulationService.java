package com.oldtom.smartstock.stock.service;

import java.util.List;

import com.oldtom.smartstock.stock.model.StockVO;

public interface SimulationService {
	
	// 기준일, 목표일 KOSPI 변동률
	public float kospi_rate(StockVO vo) throws Exception;
	
	/*
	// 수렴상태에서 5일선이 20일선 상향돌파 종목
	public List<StockVO> convergent_ma5_20_sim(StockVO vo) throws Exception;
	
	// 이동평균선(5, 20, 60)과 주가 이격률이 M% 이상/이하인 종목
	public List<StockVO> seperation_rate_maN_sim(StockVO vo) throws Exception;	
	*/
	
	/* 기본 분석 */
	// 기간 상승/하락 종목
	public List<StockVO> risingFalling(StockVO vo) throws Exception;
	
	// N개장일 주가변동이 +- M% 이상/이하인 종목
	public List<StockVO> fluctuation(StockVO vo) throws Exception;
				
	// N거래일 동안 연속 상승/하락 종목
	public List<StockVO> contRisingFalling(StockVO vo) throws Exception;
	
	// 전일대비 공매도량/신용잔고가 M% 이상 증가한 종목
	public List<StockVO> gongsin(StockVO vo) throws Exception;
	
	// 기관투자자가 M% 이상 보유한 종목
	public List<StockVO> holder(StockVO vo) throws Exception;
	
	// N개장일 외국인 지분율이 M% 이상 증가/감소 종목
	public List<StockVO> foreignRate(StockVO vo) throws Exception;
	
	// N개장일 연속 외국인 매수/매도 종목
	public List<StockVO> foreignBuyingSelling(StockVO vo) throws Exception;
	
	// N개장일 연속 기관 매수/매도 종목
	public List<StockVO> companyBuyingSelling(StockVO vo) throws Exception;
	

	/* 이동평균선 분석 */
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

	
	/* 보조지표 분석 */
	//  MACD + 전환
	public List<StockVO> macd_plus(StockVO vo) throws Exception;
	
	// MACD 기준선에서 지속 상승/하락
	public List<StockVO> macd_rising_falling(StockVO vo) throws Exception;
	
	// MACD 골든/데트 크로스 발생
	public List<StockVO> macd_golden_dead(StockVO vo) throws Exception;

	// RSI M% 이상/이하
	public List<StockVO> rsi(StockVO vo) throws Exception;

	// RSI 기준율 상향/하향 돌파
	public List<StockVO> rsi_updown(StockVO vo) throws Exception;	
	
	// 스토캐스틱 slowD M% 이상/이하
	public List<StockVO> stocastic_slow(StockVO vo) throws Exception;
	
	// 스토캐스틱 기준율 상향/하향 돌파
	public List<StockVO> stocastic_updown(StockVO vo) throws Exception;
	
	// 스토캐스틱 골든/데드 크로스 발생
	public List<StockVO> stocastic_golden_dead(StockVO vo) throws Exception;
	
	// 체결강도 M% 이상/이하
	public List<StockVO> deal_strength(StockVO vo) throws Exception;
	
	// 체결강도 전일대비 상승/하락
	public List<StockVO> deal_strength_rising_falling(StockVO vo) throws Exception;
		
	// 10일-투자심리선 M% 이상/이하
	public List<StockVO> psychology_line10(StockVO vo) throws Exception;
	
	// 10일-투자심리선 전환
	public List<StockVO> psychology_line10_updown(StockVO vo) throws Exception;
	
	// 이동평균선과 주가 이격률 M% 이상/이하
	public List<StockVO> seperation_rate(StockVO vo) throws Exception;

	
	/* 고급 분석 */
	// N거래일 최저가보다 상승한 종목
	public List<StockVO> risingNdaysMin(StockVO vo) throws Exception;
	
	// N거래일 최고가보다 하락한 종목
	public List<StockVO> fallingNdaysMax(StockVO vo) throws Exception;	
	
	// N거래일 최고가보다 M%이상 하락한후 당일 K%이상 상승한 종목
	public List<StockVO> fallingNdaysMaxPositivePole(StockVO vo) throws Exception;
	
	// N거래일 최저가보다 M%이상 상승한후 당일 K%이상 하락한 종목
	public List<StockVO> risingNdaysMinNegativePole(StockVO vo) throws Exception;

	// N거래일 평균거래량 대비 M% 이상/이하인 종목
	public List<StockVO> volume_rate_ndays_avg(StockVO vo) throws Exception;
}
