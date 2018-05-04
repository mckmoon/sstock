package com.oldtom.smartstock.stock.persistence;

import java.util.List;

import com.oldtom.smartstock.stock.model.FinanceVO;
import com.oldtom.smartstock.stock.model.NoticeVO;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;

public interface StockDAO {

	// 종목 이름들
	public List<String> hnames() throws Exception;
	
	// 최근 n번째 거래일
	public String thedate(int day) throws Exception;
	
	// 기준일/목표일 KOSPI 변동률
	public float kospi_rate(StockVO vo) throws Exception;

	// 6개월내 악재 공시
	public List<NoticeVO> notice(StockVO vo) throws Exception;
	
	
	
	/* 업종 */
	// N거래일 동안 가장 많이 상승한 업종
	public List<UpjongVO> upjong_rising_most_dayN(UpjongVO vo) throws Exception;
	
	// N거래일 업종별 주가 변동률
	public List<StockVO> rising_falling_dayN_by_upjong(UpjongVO vo) throws Exception;
	
	
	
	
	
	/* 오늘의 종목 */
	
	// MA(5,20)
	public List<StockVO> ma520(String basedate) throws Exception;
	
	// MA(20,60)
	public List<StockVO> ma2060(String basedate) throws Exception;
	
	// MA(60,120)
	public List<StockVO> ma60120(String basedate) throws Exception;

	// 일목균형표(9,26)
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
	

	// N거래일 동안 가장 많이 상승한 종목
	public List<StockVO> rising_most_dayN(StockVO vo) throws Exception;
	
	// N거래일 동안 가장 많이 하락한 종목
	public List<StockVO> falling_most_dayN(StockVO vo) throws Exception;
	
	// 시초가 갭상승
	public List<StockVO> gap_rising_moreM(StockVO vo) throws Exception;
	
	// 시초가 갭하락
	public List<StockVO> gap_falling_moreM(StockVO vo) throws Exception;
	
	// N250일, 500일 최고가/최저가 갱신 종목
	public List<StockVO> renew_low_high(StockVO vo) throws Exception;
	
	// 전일 대비 거래량 급증 종목
	public List<StockVO> volume_rising_moreM(StockVO vo) throws Exception;
	
	// 전일 대비 거래량 급증 종목
	public List<StockVO> volume_falling_moreM(StockVO vo) throws Exception;
	
	
	
	/* 재무지표 */
	// 년 재무지표 기준 종목 추출
	public List<FinanceVO> finance_year(FinanceVO vo) throws Exception;
	
	// 분기 재무지표 기준 종목 추출
	public List<FinanceVO> finance_quarter(FinanceVO vo) throws Exception;
	
	// 년 재무지표 향상 종목 추출
	public List<FinanceVO> finance_year_improve(FinanceVO vo) throws Exception;
	
	// 분기 재무지표 향상 종목 추출
	public List<FinanceVO> finance_quarter_improve(FinanceVO vo) throws Exception;
	
	
	/* 기본 분석 */
	//N거래일 M% 이상 상승한 종목
	public List<StockVO> rising_dayN_moreM(StockVO vo) throws Exception;
	
	//N거래일 M% 이상 하락한 종목
	public List<StockVO> falling_dayN_moreM(StockVO vo) throws Exception;
	
	// N거래일 주가변동률이 M% 이상 증가 종목
	public List<StockVO> fluctuation_dayN_moreM(StockVO vo) throws Exception;
	
	// N거래일 주가변동률이 M% 이상 증가 종목
	public List<StockVO> fluctuation_dayN_lessM(StockVO vo) throws Exception;
	
	// N거래일 동안 연속 상승한 종목
	public List<StockVO> cont_rising_dayN(StockVO vo) throws Exception;
	
	// N거래일 동안 연속 하락한 종목
	public List<StockVO> cont_falling_dayN(StockVO vo) throws Exception;

	// 전일대비 공매도량이 M% 이상 증가 종목
	public List<StockVO> gongmaedo_rising_moreM(StockVO vo) throws Exception;
	
	// 전일대비 신용잔고가 M% 이상 증가 종목
	public List<StockVO> sinyong_rising_moreM(StockVO vo) throws Exception;
	
	// 주요기관 N이 M% 이상 보유 종목
	public List<StockVO> holderN_moreM(StockVO vo) throws Exception;
	
	// 국내/국외 기관투자자들이 M% 이상 보유 종목
	public List<StockVO> holderKK_moreM(StockVO vo) throws Exception;

	// N거래일 외국인 지분률이 M% 이상 증가한 종목
	public List<StockVO> foreign_rate_rising_dayN_moreM(StockVO vo) throws Exception;
	
	// N거래일 외국인 지분률이 M% 이상 하락한 종목
	public List<StockVO> foreign_rate_falling_dayN_lessM(StockVO vo) throws Exception;
	
	// N거래일 연속 외국인 매수 종목
	public List<StockVO> foreign_cont_buying_dayN(StockVO vo) throws Exception;
	
	// N거래일 연속 외국인 매도 종목
	public List<StockVO> foreign_cont_selling_dayN(StockVO vo) throws Exception;
	
	// N거래일 연속 기관 매수 종목
	public List<StockVO> company_cont_buying_dayN(StockVO vo) throws Exception;
	
	// N거래일 연속 기관 매도 종목
	public List<StockVO> company_cont_selling_dayN(StockVO vo) throws Exception;
	
	// 종목 정보 조회
	public List<StockVO> view_stock(StockVO vo) throws Exception;
	
	
	/* 이동 평균선 */
	// 5일선이 20일선 상향돌파 종목
	public List<StockVO> ma5_20_upward(StockVO vo) throws Exception;
	
	// 5일선이 20일선 하향돌파 종목
	public List<StockVO> ma5_20_downward(StockVO vo) throws Exception;
	
	// 20일선이 60일선 상향돌파 종목
	public List<StockVO> ma20_60_upward(StockVO vo) throws Exception;
	
	// 20일선이 60일선 하향돌파 종목
	public List<StockVO> ma20_60_downward(StockVO vo) throws Exception;
	
	// 주가 정배열 종목
	public List<StockVO> ma_arrange_positive(StockVO vo) throws Exception;
	
	// 주가 역배열 종목
	public List<StockVO> ma_arrange_negative(StockVO vo) throws Exception;
	
	// 수렴상태에서 5일선이 20일선 상향돌파 종목
	public List<StockVO> convergent_ma5_20_upward(StockVO vo) throws Exception;
	
	// 수렴상태에서 5일선이 20일선 하향돌파 종목
	public List<StockVO> convergent_ma5_20_downward(StockVO vo) throws Exception;

	// 주봉 5일선이 20일선 상향돌파 종목
	public List<StockVO> week_ma5_20_upward(StockVO vo) throws Exception;
	
	// 주봉 5일선이 20일선 하향돌파 종목
	public List<StockVO> week_ma5_20_downward(StockVO vo) throws Exception;
	
	// 주봉 20일선이 60일선 상향돌파 종목
	public List<StockVO> week_ma20_60_upward(StockVO vo) throws Exception;
	
	// 주봉 20일선이 60일선 하향돌파 종목
	public List<StockVO> week_ma20_60_downward(StockVO vo) throws Exception;
	
	// 5일선이 20일선 강하게 상향돌파 종목
	public List<StockVO> ma5_20_upward_rising_moreM(StockVO vo) throws Exception;
	
	// 5일선이 20일선 강하게 하향돌파 종목
	public List<StockVO> ma5_20_downward_falling_moreM(StockVO vo) throws Exception;
	
	// N개장일동안 5일선이 20일선을 K번 이상 상향돌파 종목
	public List<StockVO> ma5_20_upward_dayN_moreK(StockVO vo) throws Exception;
	
	// N개장일동안 5일선이 20일선을 K번 이상 하향돌파 종목
	public List<StockVO> ma5_20_downward_dayN_moreK(StockVO vo) throws Exception;	

	
	
	/* 보조지표 기준 */
	// MACD(12,26,9) + 전환
	public List<StockVO> macd_plus(StockVO vo) throws Exception;

	// MACD(12,26,9) 상승추세
	public List<StockVO> macd_rising_trend(StockVO vo) throws Exception;

	// MACD(12,26,9) 하락추세
	public List<StockVO> macd_falling_trend(StockVO vo) throws Exception;

	// MACD(12,26,9) 골든크로스
	public List<StockVO> macd_golden_cross(StockVO vo) throws Exception;

	// MACD(12,26,9) 데드크로스
	public List<StockVO> macd_dead_cross(StockVO vo) throws Exception;	

	// RSI(상대적주가강도) M% 이상인 종목
	public List<StockVO> rsi_moreM(StockVO vo) throws Exception;

	// RSI(상대적주가강도) M% 이하인 종목
	public List<StockVO> rsi_lessM(StockVO vo) throws Exception;

	// RSI(상대적주가강도) M% 상향 돌파
	public List<StockVO> rsi_upwardM(StockVO vo) throws Exception;

	//  RSI(상대적주가강도) M% 하향 돌파
	public List<StockVO> rsi_downwardM(StockVO vo) throws Exception;

	//  스토캐스틱 slow(10,5,5) slowD M% 이상
	public List<StockVO> stocastic_moreM(StockVO vo) throws Exception;

	//  스토캐스틱 slow(10,5,5) slowD M% 이하
	public List<StockVO> stocastic_lessM(StockVO vo) throws Exception;
	
	//  스토캐스틱 slow(10,5,5) slowD M% 상향 돌파
	public List<StockVO> stocastic_upwardM(StockVO vo) throws Exception;
	
	//  스토캐스틱 slow(10,5,5) slowD M% 하향 돌파
	public List<StockVO> stocastic_downwardM(StockVO vo) throws Exception;

	// 스토캐스틱  slow(10,5,5) %K가 %D를 골든크로스
	public List<StockVO> stocastic_golden_cross(StockVO vo) throws Exception;

	// 스토캐스틱  slow(10,5,5) %K가 %D를 데드크로스
	public List<StockVO> stocastic_dead_cross(StockVO vo) throws Exception;		

	// 체결강도가 M% 이하인 종목 (당일체결강도, 5일평균 강도, 10일 평균 강도, 20일 평균 강도)
	public List<StockVO> deal_strength_moreM(StockVO vo) throws Exception;		

	// 체결강도가 M% 이하인 종목 (당일체결강도, 5일평균 강도, 10일 평균 강도, 20일 평균 강도)
	public List<StockVO> deal_strength_lessM(StockVO vo) throws Exception;	
	
	// 체결강도가 전일대비 M% 이상 증가한 종목
	public List<StockVO> deal_strength_rising_moreM(StockVO vo) throws Exception;	
	
	// 체결강도가 전일대비 M% 이상 하락한 종목
	public List<StockVO> deal_strength_falling_moreM(StockVO vo) throws Exception;	

	
	// 이동평균선(5, 20, 60)과 주가 이격률이 M% 이상인 종목
	public List<StockVO> seperation_rate_maN_moreM(StockVO vo) throws Exception;	
	
	// 이동평균선(5, 20, 60)과 주가 이격률이 M% 이하인 종목
	public List<StockVO> seperation_rate_maN_lessM(StockVO vo) throws Exception;

	
	// 10일 투자심리선 M% 이상인 종목
	public List<StockVO> psychology_line10_moreM(StockVO vo) throws Exception;	
	
	// 10일 투자심리선 M% 이하인 종목
	public List<StockVO> psychology_line10_lessM(StockVO vo) throws Exception;
	
	// 10일 투자심리선 M% 아래에서 상승 반전 종목
	public List<StockVO> psychology_line10_upwardM(StockVO vo) throws Exception;	
	
	// 10일 투자심리선 M% 위에서 하락 반전 종목
	public List<StockVO> psychology_line10_downwardM(StockVO vo) throws Exception;


	
	/* 고급 분석 */
	//5. N거래일 최저점대비 M%이하 상승한 종목
	public List<StockVO> rising_dayN_min_lessM(StockVO vo) throws Exception;
	
	//6: N거래일 최저점대비 M%이상 상승한 종목
	public List<StockVO> rising_dayN_min_moreM(StockVO vo) throws Exception;
		
	//7. N거래일 최고점대비 M%이하 하락한 종목
	public List<StockVO> falling_dayN_max_lessM(StockVO vo) throws Exception;
	
	//8. N거래일 최고점대비 M%이상 하락한 종목
	public List<StockVO> falling_dayN_max_moreM(StockVO vo) throws Exception;
	
	// N거래일 최고가에서 M% 이상 하락후, 당일 K% 이상 상승한 종목 (장대 양봉 종목)
	public List<StockVO> rising_moreK_after_falling_dayN_max_moreM(StockVO vo) throws Exception;

	// N거래일 최저가에서 M% 이상 상승후, 당일 K% 이상 하락한 종목 (장대 음봉 종목)
	public List<StockVO> falling_moreK_after_rising_dayN_min_moreM(StockVO vo) throws Exception;	

	// 기간 평균거래량 대비 M% 이하인 종목
	public List<StockVO> volume_downrate_dayN_lessM(StockVO vo) throws Exception;
	
	// 기간 평균거래량 대비 M% 이상인 종목
	public List<StockVO> volume_uprate_dayN_moreM(StockVO vo) throws Exception;
	
	// 패턴 분석:  250일 하락 추세, 최근5일 단기 상승 종목
	public List<StockVO> day250_decline_day5_rebound(StockVO vo) throws Exception;
	
	// 패턴 분석:  120일 하락 추세, 최근5일 단기 상승 종목
	public List<StockVO> day120_decline_day5_rebound(StockVO vo) throws Exception;

	// 패턴 분석:  30일 하락 추세, 최근5일 단기 상승 종목
	public List<StockVO> day30_decline_day5_rebound(StockVO vo) throws Exception;

	// 패턴 분석:  250일 횡보 추세, 최근5일 단기 상승 종목
	public List<StockVO> day250_flat_day5_rebound(StockVO vo) throws Exception;
	
	// 패턴 분석:  120일 횡보 추세, 최근5일 단기 상승 종목
	public List<StockVO> day120_flat_day5_rebound(StockVO vo) throws Exception;

	// 패턴 분석:  30일 횡보 추세, 최근5일 단기 상승 종목
	public List<StockVO> day30_flat_day5_rebound(StockVO vo) throws Exception;
	
	
	
	
	
	
	
	/* 시뮬레이션 */
	// 수렴상태에서 5일선이 20일선 상향/하향 돌파 종목
	//public List<StockVO> convergent_ma5_20_sim(StockVO vo) throws Exception;
	
	// 이동평균선(5, 20, 60)과 주가 이격률이 M% 이상/이하인 종목
	//public List<StockVO> seperation_rate_maN_sim(StockVO vo) throws Exception;	
	
	// N거래일 최고가에서 M% 이상 하락후, 당일 K% 이상 상승한 종목 (장대 양봉 종목)
	//public List<StockVO> rising_moreK_after_falling_dayN_max_moreM_sim(StockVO vo) throws Exception;
	
	/* 시뮬레이션 - 기본 분석 */
	//N거래일 M% 이상 상승한 종목
	public List<StockVO> rising_dayN_moreM_sim(StockVO vo) throws Exception;
	
	//N거래일 M% 이상 하락한 종목
	public List<StockVO> falling_dayN_moreM_sim(StockVO vo) throws Exception;
	
	// N거래일 주가변동률이 M% 이상 증가 종목
	public List<StockVO> fluctuation_dayN_moreM_sim(StockVO vo) throws Exception;
	
	// N거래일 주가변동률이 M% 이상 증가 종목
	public List<StockVO> fluctuation_dayN_lessM_sim(StockVO vo) throws Exception;
	
	// N거래일 동안 연속 상승한 종목
	public List<StockVO> cont_rising_dayN_sim(StockVO vo) throws Exception;
	
	// N거래일 동안 연속 하락한 종목
	public List<StockVO> cont_falling_dayN_sim(StockVO vo) throws Exception;

	// 전일대비 공매도량이 M% 이상 증가 종목
	public List<StockVO> gongmaedo_rising_moreM_sim(StockVO vo) throws Exception;
	
	// 전일대비 신용잔고가 M% 이상 증가 종목
	public List<StockVO> sinyong_rising_moreM_sim(StockVO vo) throws Exception;
	
	// 주요기관 N이 M% 이상 보유 종목
	public List<StockVO> holderN_moreM_sim(StockVO vo) throws Exception;
	
	// 국내/국외 기관투자자들이 M% 이상 보유 종목
	public List<StockVO> holderKK_moreM_sim(StockVO vo) throws Exception;

	// N거래일 외국인 지분률이 M% 이상 증가한 종목
	public List<StockVO> foreign_rate_rising_dayN_moreM_sim(StockVO vo) throws Exception;
	
	// N거래일 외국인 지분률이 M% 이상 하락한 종목
	public List<StockVO> foreign_rate_falling_dayN_lessM_sim(StockVO vo) throws Exception;
	
	// N거래일 연속 외국인 매수 종목
	public List<StockVO> foreign_cont_buying_dayN_sim(StockVO vo) throws Exception;
	
	// N거래일 연속 외국인 매도 종목
	public List<StockVO> foreign_cont_selling_dayN_sim(StockVO vo) throws Exception;
	
	// N거래일 연속 기관 매수 종목
	public List<StockVO> company_cont_buying_dayN_sim(StockVO vo) throws Exception;
	
	// N거래일 연속 기관 매도 종목
	public List<StockVO> company_cont_selling_dayN_sim(StockVO vo) throws Exception;
	
	
	
	/* 이동 평균선 */
	// 5일선이 20일선 상향돌파 종목
	public List<StockVO> ma5_20_upward_sim(StockVO vo) throws Exception;
	
	// 5일선이 20일선 하향돌파 종목
	public List<StockVO> ma5_20_downward_sim(StockVO vo) throws Exception;
	
	// 20일선이 60일선 상향돌파 종목
	public List<StockVO> ma20_60_upward_sim(StockVO vo) throws Exception;
	
	// 20일선이 60일선 하향돌파 종목
	public List<StockVO> ma20_60_downward_sim(StockVO vo) throws Exception;
	
	// 주봉 5일선이 20일선 상향돌파 종목
	public List<StockVO> week_ma5_20_upward_sim(StockVO vo) throws Exception;
	
	// 주봉 5일선이 20일선 하향돌파 종목
	public List<StockVO> week_ma5_20_downward_sim(StockVO vo) throws Exception;
	
	// 주봉 20일선이 60일선 상향돌파 종목
	public List<StockVO> week_ma20_60_upward_sim(StockVO vo) throws Exception;
	
	// 주봉 20일선이 60일선 하향돌파 종목
	public List<StockVO> week_ma20_60_downward_sim(StockVO vo) throws Exception;
	
	// 5일선이 20일선 강하게 상향돌파 종목
	public List<StockVO> ma5_20_upward_rising_moreM_sim(StockVO vo) throws Exception;
	
	// 5일선이 20일선 강하게 하향돌파 종목
	public List<StockVO> ma5_20_downward_falling_moreM_sim(StockVO vo) throws Exception;
	
	// N개장일동안 5일선이 20일선을 K번 이상 상향돌파 종목
	public List<StockVO> ma5_20_upward_dayN_moreK_sim(StockVO vo) throws Exception;
	
	// N개장일동안 5일선이 20일선을 K번 이상 하향돌파 종목
	public List<StockVO> ma5_20_downward_dayN_moreK_sim(StockVO vo) throws Exception;
	
	// 주가 정배열 종목
	public List<StockVO> ma_arrange_positive_sim(StockVO vo) throws Exception;
	
	// 주가 역배열 종목
	public List<StockVO> ma_arrange_negative_sim(StockVO vo) throws Exception;
	
	// 수렴상태에서 5일선이 20일선 상향돌파 종목
	public List<StockVO> convergent_ma5_20_upward_sim(StockVO vo) throws Exception;
	
	// 수렴상태에서 5일선이 20일선 하향돌파 종목
	public List<StockVO> convergent_ma5_20_downward_sim(StockVO vo) throws Exception;

	
	
	/* 보조지표 기준 */
	// MACD(12,26,9) + 전환
	public List<StockVO> macd_plus_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) 상승추세
	public List<StockVO> macd_rising_trend_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) 하락추세
	public List<StockVO> macd_falling_trend_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) 골든크로스
	public List<StockVO> macd_golden_cross_sim(StockVO vo) throws Exception;

	// MACD(12,26,9) 데드크로스
	public List<StockVO> macd_dead_cross_sim(StockVO vo) throws Exception;	

	// RSI(상대적주가강도) M% 이상인 종목
	public List<StockVO> rsi_moreM_sim(StockVO vo) throws Exception;

	// RSI(상대적주가강도) M% 이하인 종목
	public List<StockVO> rsi_lessM_sim(StockVO vo) throws Exception;

	// RSI(상대적주가강도) M% 상향 돌파
	public List<StockVO> rsi_upwardM_sim(StockVO vo) throws Exception;

	//  RSI(상대적주가강도) M% 하향 돌파
	public List<StockVO> rsi_downwardM_sim(StockVO vo) throws Exception;

	//  스토캐스틱 slow(10,5,5) slowD M% 이상
	public List<StockVO> stocastic_moreM_sim(StockVO vo) throws Exception;

	//  스토캐스틱 slow(10,5,5) slowD M% 이하
	public List<StockVO> stocastic_lessM_sim(StockVO vo) throws Exception;
	
	//  스토캐스틱 slow(10,5,5) slowD M% 상향 돌파
	public List<StockVO> stocastic_upwardM_sim(StockVO vo) throws Exception;
	
	//  스토캐스틱 slow(10,5,5) slowD M% 하향 돌파
	public List<StockVO> stocastic_downwardM_sim(StockVO vo) throws Exception;

	// 스토캐스틱  slow(10,5,5) %K가 %D를 골든크로스
	public List<StockVO> stocastic_golden_cross_sim(StockVO vo) throws Exception;

	// 스토캐스틱  slow(10,5,5) %K가 %D를 데드크로스
	public List<StockVO> stocastic_dead_cross_sim(StockVO vo) throws Exception;		

	// 체결강도가 M% 이하인 종목 (당일체결강도, 5일평균 강도, 10일 평균 강도, 20일 평균 강도)
	public List<StockVO> deal_strength_moreM_sim(StockVO vo) throws Exception;		

	// 체결강도가 M% 이하인 종목 (당일체결강도, 5일평균 강도, 10일 평균 강도, 20일 평균 강도)
	public List<StockVO> deal_strength_lessM_sim(StockVO vo) throws Exception;	
	
	// 체결강도가 전일대비 M% 이상 증가한 종목
	public List<StockVO> deal_strength_rising_moreM_sim(StockVO vo) throws Exception;	
	
	// 체결강도가 전일대비 M% 이상 하락한 종목
	public List<StockVO> deal_strength_falling_moreM_sim(StockVO vo) throws Exception;	

	
	// 이동평균선(5, 20, 60)과 주가 이격률이 M% 이상인 종목
	public List<StockVO> seperation_rate_maN_moreM_sim(StockVO vo) throws Exception;	
	
	// 이동평균선(5, 20, 60)과 주가 이격률이 M% 이하인 종목
	public List<StockVO> seperation_rate_maN_lessM_sim(StockVO vo) throws Exception;

	
	// 10일 투자심리선 M% 이상인 종목
	public List<StockVO> psychology_line10_moreM_sim(StockVO vo) throws Exception;	
	
	// 10일 투자심리선 M% 이하인 종목
	public List<StockVO> psychology_line10_lessM_sim(StockVO vo) throws Exception;
	
	// 10일 투자심리선 M% 아래에서 상승 반전 종목
	public List<StockVO> psychology_line10_upwardM_sim(StockVO vo) throws Exception;	
	
	// 10일 투자심리선 M% 위에서 하락 반전 종목
	public List<StockVO> psychology_line10_downwardM_sim(StockVO vo) throws Exception;


	
	/* 고급 분석 */
	//5. N거래일 최저점대비 M%이하 상승한 종목
	public List<StockVO> rising_dayN_min_lessM_sim(StockVO vo) throws Exception;
	
	//6: N거래일 최저점대비 M%이상 상승한 종목
	public List<StockVO> rising_dayN_min_moreM_sim(StockVO vo) throws Exception;
		
	//7. N거래일 최고점대비 M%이하 하락한 종목
	public List<StockVO> falling_dayN_max_lessM_sim(StockVO vo) throws Exception;
	
	//8. N거래일 최고점대비 M%이상 하락한 종목
	public List<StockVO> falling_dayN_max_moreM_sim(StockVO vo) throws Exception;
	
	// N거래일 최고가에서 M% 이상 하락후, 당일 K% 이상 상승한 종목 (장대 양봉 종목)
	public List<StockVO> rising_moreK_after_falling_dayN_max_moreM_sim(StockVO vo) throws Exception;

	// N거래일 최저가에서 M% 이상 상승후, 당일 K% 이상 하락한 종목 (장대 음봉 종목)
	public List<StockVO> falling_moreK_after_rising_dayN_min_moreM_sim(StockVO vo) throws Exception;	

	// 기간 평균거래량 대비 M% 이하인 종목
	public List<StockVO> volume_downrate_dayN_lessM_sim(StockVO vo) throws Exception;
	
	// 기간 평균거래량 대비 M% 이상인 종목
	public List<StockVO> volume_uprate_dayN_moreM_sim(StockVO vo) throws Exception;
}
