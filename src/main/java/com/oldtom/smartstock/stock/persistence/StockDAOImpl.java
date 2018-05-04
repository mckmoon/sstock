package com.oldtom.smartstock.stock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.oldtom.smartstock.stock.model.FinanceVO;
import com.oldtom.smartstock.stock.model.NoticeVO;
import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.model.UpjongVO;

import org.springframework.stereotype.Repository;

@Repository
public class StockDAOImpl implements StockDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.oldtom.smartstock.mapper.StockMapper";


	@Override
	public List<String> hnames() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".hnames");
	}
	
	@Override
	public String thedate(int day) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".thedate", day);
	}
	
	@Override
	public float kospi_rate(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".kospi_rate", vo);
	}

	@Override
	public List<NoticeVO> notice(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".notice", vo);
	}

	
	
	/* 업종 */
	// N거래일 동안 가장 많이 상승한 업종
	public List<UpjongVO> upjong_rising_most_dayN(UpjongVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".upjong_rising_most_dayN", vo);
	}

	@Override
	public List<StockVO> rising_falling_dayN_by_upjong(UpjongVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_falling_dayN_by_upjong", vo);
	}
	
	
	
	/* 오늘의 종목 */
	@Override
	public List<StockVO> ma520(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma520", basedate);
	}

	@Override
	public List<StockVO> ma2060(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma2060", basedate);
	}

	@Override
	public List<StockVO> ma60120(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma60120", basedate);
	}

	@Override
	public List<StockVO> ilmok(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ilmok", basedate);
	}

	@Override
	public List<StockVO> slow(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".slow", basedate);
	}

	@Override
	public List<StockVO> macd(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd", basedate);
	}

	@Override
	public List<StockVO> cci(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".cci", basedate);
	}

	@Override
	public List<StockVO> rsi(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi", basedate);
	}

	@Override
	public List<StockVO> sonar(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".sonar", basedate);
	}

	@Override
	public List<StockVO> volume(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume", basedate);
	}

	
	@Override
	public List<StockVO> rising_most_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_most_dayN", vo);
	}

	@Override
	public List<StockVO> falling_most_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_most_dayN", vo);
	}
	
	@Override
	public List<StockVO> gap_rising_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".gap_rising_moreM", vo);
	}

	@Override
	public List<StockVO> gap_falling_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".gap_falling_moreM", vo);
	}

	@Override
	public List<StockVO> renew_low_high(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".renew_low_high", vo);
	}

	@Override
	public List<StockVO> volume_rising_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume_rising_moreM", vo);
	}

	@Override
	public List<StockVO> volume_falling_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume_falling_moreM", vo);
	}	
	
	@Override
	public List<StockVO> view_stock(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".view_stock", vo);
	}
	
	

	/* 재무 지표 */
	
	@Override
	public List<FinanceVO> finance_year(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".finance_year", vo);
	}

	@Override
	public List<FinanceVO> finance_quarter(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".finance_quarter", vo);
	}

	@Override
	public List<FinanceVO> finance_year_improve(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		String sql_func = namespace + ".finance_year_improve" + String.valueOf(vo.getDuration());
		return session.selectList(sql_func, vo);
	}

	@Override
	public List<FinanceVO> finance_quarter_improve(FinanceVO vo) throws Exception {
		// TODO Auto-generated method stub
		String sql_func = namespace + ".finance_quarter_improve" + String.valueOf(vo.getDuration());
		return session.selectList(sql_func, vo);
	}

	
	
	
	/* 기본 분석 */
	
	@Override
	public List<StockVO> rising_dayN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_dayN_moreM", vo);
	}

	@Override
	public List<StockVO> falling_dayN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_dayN_moreM", vo);
	}
	
	@Override
	public List<StockVO> fluctuation_dayN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".fluctuation_dayN_moreM", vo);
	}
	
	@Override
	public List<StockVO> fluctuation_dayN_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".fluctuation_dayN_lessM", vo);
	}

	@Override
	public List<StockVO> cont_rising_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".cont_rising_dayN", vo);
	}

	@Override
	public List<StockVO> cont_falling_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".cont_falling_dayN", vo);
	}

	@Override
	public List<StockVO> gongmaedo_rising_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".gongmaedo_rising_moreM", vo);
	}

	@Override
	public List<StockVO> sinyong_rising_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".sinyong_rising_moreM", vo);
	}

	@Override
	public List<StockVO> holderN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".holderN_moreM", vo);
	}

	@Override
	public List<StockVO> holderKK_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".holderKK_moreM", vo);
	}


	@Override
	public List<StockVO> foreign_rate_rising_dayN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_rate_rising_dayN_moreM", vo);
	}

	@Override
	public List<StockVO> foreign_rate_falling_dayN_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_rate_falling_dayN_lessM", vo);
	}

	@Override
	public List<StockVO> foreign_cont_buying_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_cont_buying_dayN", vo);
	}

	@Override
	public List<StockVO> foreign_cont_selling_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_cont_selling_dayN", vo);
	}

	@Override
	public List<StockVO> company_cont_buying_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".company_cont_buying_dayN", vo);
	}

	@Override
	public List<StockVO> company_cont_selling_dayN(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".company_cont_selling_dayN", vo);
	}

	
	
	
	/* 이동 평균선 */
	
	@Override
	public List<StockVO> ma5_20_upward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_upward", vo);
	}

	@Override
	public List<StockVO> ma5_20_downward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_downward", vo);
	}

	@Override
	public List<StockVO> ma20_60_upward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma20_60_upward", vo);
	}

	@Override
	public List<StockVO> ma20_60_downward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma20_60_downward", vo);
	}

	@Override
	public List<StockVO> ma5_20_upward_rising_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_upward_rising_moreM", vo);
	}

	@Override
	public List<StockVO> ma5_20_downward_falling_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_downward_falling_moreM", vo);
	}


	@Override
	public List<StockVO> ma_arrange_positive(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma_arrange_positive", vo);
	}

	@Override
	public List<StockVO> ma_arrange_negative(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma_arrange_negative", vo);
	}

	@Override
	public List<StockVO> convergent_ma5_20_upward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".convergent_ma5_20_upward", vo);
	}

	@Override
	public List<StockVO> convergent_ma5_20_downward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".convergent_ma5_20_downward", vo);
	}

	@Override
	public List<StockVO> week_ma5_20_upward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma5_20_upward", vo);
	}

	@Override
	public List<StockVO> week_ma5_20_downward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma5_20_downward", vo);
	}

	@Override
	public List<StockVO> week_ma20_60_upward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma20_60_upward", vo);
	}

	@Override
	public List<StockVO> week_ma20_60_downward(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma20_60_downward", vo);
	}


	@Override
	public List<StockVO> ma5_20_upward_dayN_moreK(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_upward_dayN_moreK", vo);
	}

	@Override
	public List<StockVO> ma5_20_downward_dayN_moreK(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_downward_dayN_moreK", vo);
	}
	
	
	
	
	/* 보조 지표 */
	@Override
	public List<StockVO> macd_plus(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_plus", vo);
	}

	@Override
	public List<StockVO> macd_rising_trend(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_rising_trend", vo);
	}

	@Override
	public List<StockVO> macd_falling_trend(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_falling_trend", vo);
	}

	@Override
	public List<StockVO> macd_golden_cross(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_golden_cross", vo);
	}

	@Override
	public List<StockVO> macd_dead_cross(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_dead_cross", vo);
	}

	@Override
	public List<StockVO> rsi_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_moreM", vo);
	}

	@Override
	public List<StockVO> rsi_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_lessM", vo);
	}

	@Override
	public List<StockVO> rsi_upwardM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_upwardM", vo);
	}

	@Override
	public List<StockVO> rsi_downwardM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_downwardM", vo);
	}

	@Override
	public List<StockVO> stocastic_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_moreM", vo);
	}

	@Override
	public List<StockVO> stocastic_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_lessM", vo);
	}

	@Override
	public List<StockVO> stocastic_upwardM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_upwardM", vo);
	}

	@Override
	public List<StockVO> stocastic_downwardM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_downwardM", vo);
	}

	@Override
	public List<StockVO> stocastic_golden_cross(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_golden_cross", vo);
	}

	@Override
	public List<StockVO> stocastic_dead_cross(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_dead_cross", vo);
	}

	@Override
	public List<StockVO> deal_strength_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_moreM", vo);
	}

	@Override
	public List<StockVO> deal_strength_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_lessM", vo);
	}
	
	@Override
	public List<StockVO> deal_strength_rising_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_rising_moreM", vo);
	}

	@Override
	public List<StockVO> deal_strength_falling_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_falling_moreM", vo);
	}


	@Override
	public List<StockVO> psychology_line10_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_moreM", vo);
	}

	@Override
	public List<StockVO> psychology_line10_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_lessM", vo);
	}

	@Override
	public List<StockVO> psychology_line10_upwardM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_upwardM", vo);
	}

	@Override
	public List<StockVO> psychology_line10_downwardM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_downwardM", vo);
	}


	@Override
	public List<StockVO> seperation_rate_maN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".seperation_rate_maN_moreM", vo);
	}
	
	@Override
	public List<StockVO> seperation_rate_maN_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".seperation_rate_maN_lessM", vo);
	}

	
	

	
	/* 고급 분석 */
	@Override
	public List<StockVO> rising_dayN_min_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_dayN_min_moreM", vo);
	}

	@Override
	public List<StockVO> rising_dayN_min_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_dayN_min_lessM", vo);
	}
	
	@Override
	public List<StockVO> falling_dayN_max_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_dayN_max_lessM", vo);
	}

	@Override
	public List<StockVO> falling_dayN_max_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_dayN_max_moreM", vo);
	}

	@Override
	public List<StockVO> rising_moreK_after_falling_dayN_max_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_moreK_after_falling_dayN_max_moreM", vo);
	}

	@Override
	public List<StockVO> falling_moreK_after_rising_dayN_min_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_moreK_after_rising_dayN_min_moreM", vo);
	}
	

	@Override
	public List<StockVO> volume_downrate_dayN_lessM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume_downrate_dayN_lessM", vo);
	}

	@Override
	public List<StockVO> volume_uprate_dayN_moreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume_uprate_dayN_moreM", vo);
	}
	
	
	// 패턴분석: 하락 추세, 단기 반등
	@Override
	public List<StockVO> day250_decline_day5_rebound(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".day250_decline_day5_rebound", vo);
	}

	@Override
	public List<StockVO> day120_decline_day5_rebound(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".day120_decline_day5_rebound", vo);
	}

	@Override
	public List<StockVO> day30_decline_day5_rebound(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".day30_decline_day5_rebound", vo);
	}	

	@Override
	public List<StockVO> day250_flat_day5_rebound(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".day250_flat_day5_rebound", vo);
	}

	@Override
	public List<StockVO> day120_flat_day5_rebound(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".day120_flat_day5_rebound", vo);
	}

	@Override
	public List<StockVO> day30_flat_day5_rebound(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".day30_flat_day5_rebound", vo);
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/* 시뮬레이션 */

	@Override
	public List<StockVO> rising_dayN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_dayN_moreM_sim", vo);
	}

	@Override
	public List<StockVO> falling_dayN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_dayN_moreM_sim", vo);
	}

	@Override
	public List<StockVO> fluctuation_dayN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".fluctuation_dayN_moreM_sim", vo);
	}

	@Override
	public List<StockVO> fluctuation_dayN_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".fluctuation_dayN_lessM_sim", vo);
	}

	@Override
	public List<StockVO> cont_rising_dayN_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".cont_rising_dayN_sim", vo);
	}

	@Override
	public List<StockVO> cont_falling_dayN_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".cont_falling_dayN_sim", vo);
	}

	@Override
	public List<StockVO> gongmaedo_rising_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".gongmaedo_rising_moreM_sim", vo);
	}

	@Override
	public List<StockVO> sinyong_rising_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".sinyong_rising_moreM_sim", vo);
	}

	@Override
	public List<StockVO> holderN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".holderN_moreM_sim", vo);
	}

	@Override
	public List<StockVO> holderKK_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".holderKK_moreM_sim", vo);
	}

	@Override
	public List<StockVO> foreign_rate_rising_dayN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_rate_rising_dayN_moreM_sim", vo);
	}

	@Override
	public List<StockVO> foreign_rate_falling_dayN_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_rate_falling_dayN_lessM_sim", vo);
	}

	@Override
	public List<StockVO> foreign_cont_buying_dayN_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_cont_buying_dayN_sim", vo);
	}

	@Override
	public List<StockVO> foreign_cont_selling_dayN_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".foreign_cont_selling_dayN_sim", vo);
	}

	@Override
	public List<StockVO> company_cont_buying_dayN_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".company_cont_buying_dayN_sim", vo);
	}

	@Override
	public List<StockVO> company_cont_selling_dayN_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".company_cont_selling_dayN_sim", vo);
	}

	@Override
	public List<StockVO> ma5_20_upward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_upward_sim", vo);
	}

	@Override
	public List<StockVO> ma5_20_downward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_downward_sim", vo);
	}

	@Override
	public List<StockVO> ma20_60_upward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma20_60_upward_sim", vo);
	}

	@Override
	public List<StockVO> ma20_60_downward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma20_60_downward_sim", vo);
	}


	@Override
	public List<StockVO> ma5_20_upward_rising_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_upward_rising_moreM_sim", vo);
	}

	@Override
	public List<StockVO> ma5_20_downward_falling_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_downward_falling_moreM_sim", vo);
	}


	@Override
	public List<StockVO> ma_arrange_positive_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma_arrange_positive_sim", vo);
	}

	@Override
	public List<StockVO> ma_arrange_negative_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma_arrange_negative_sim", vo);
	}

	@Override
	public List<StockVO> convergent_ma5_20_upward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".convergent_ma5_20_upward_sim", vo);
	}

	@Override
	public List<StockVO> convergent_ma5_20_downward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".convergent_ma5_20_downward_sim", vo);
	}

	@Override
	public List<StockVO> week_ma5_20_upward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma5_20_upward_sim", vo);
	}

	@Override
	public List<StockVO> week_ma5_20_downward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma5_20_downward_sim", vo);
	}

	@Override
	public List<StockVO> week_ma20_60_upward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma20_60_upward_sim", vo);
	}

	@Override
	public List<StockVO> week_ma20_60_downward_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".week_ma20_60_downward_sim", vo);
	}

	@Override
	public List<StockVO> ma5_20_upward_dayN_moreK_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_upward_dayN_moreK_sim", vo);
	}

	@Override
	public List<StockVO> ma5_20_downward_dayN_moreK_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".ma5_20_downward_dayN_moreK_sim", vo);
	}
	
	
	
	/* 보조 지표 */
	@Override
	public List<StockVO> macd_plus_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_plus_sim", vo);
	}

	@Override
	public List<StockVO> macd_rising_trend_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_rising_trend_sim", vo);
	}

	@Override
	public List<StockVO> macd_falling_trend_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_falling_trend_sim", vo);
	}

	@Override
	public List<StockVO> macd_golden_cross_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_golden_cross_sim", vo);
	}

	@Override
	public List<StockVO> macd_dead_cross_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".macd_dead_cross_sim", vo);
	}

	@Override
	public List<StockVO> rsi_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_moreM_sim", vo);
	}

	@Override
	public List<StockVO> rsi_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_lessM_sim", vo);
	}

	@Override
	public List<StockVO> rsi_upwardM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_upwardM_sim", vo);
	}

	@Override
	public List<StockVO> rsi_downwardM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rsi_downwardM_sim", vo);
	}

	@Override
	public List<StockVO> stocastic_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_moreM_sim", vo);
	}

	@Override
	public List<StockVO> stocastic_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_lessM_sim", vo);
	}

	@Override
	public List<StockVO> stocastic_upwardM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_upwardM_sim", vo);
	}

	@Override
	public List<StockVO> stocastic_downwardM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_downwardM_sim", vo);
	}

	@Override
	public List<StockVO> stocastic_golden_cross_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_golden_cross_sim", vo);
	}

	@Override
	public List<StockVO> stocastic_dead_cross_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".stocastic_dead_cross_sim", vo);
	}

	@Override
	public List<StockVO> deal_strength_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_moreM_sim", vo);
	}

	@Override
	public List<StockVO> deal_strength_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_lessM_sim", vo);
	}

	@Override
	public List<StockVO> deal_strength_rising_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_rising_moreM_sim", vo);
	}

	@Override
	public List<StockVO> deal_strength_falling_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".deal_strength_falling_moreM_sim", vo);
	}

	@Override
	public List<StockVO> seperation_rate_maN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".seperation_rate_maN_moreM_sim", vo);
	}

	@Override
	public List<StockVO> seperation_rate_maN_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".seperation_rate_maN_lessM_sim", vo);
	}

	@Override
	public List<StockVO> psychology_line10_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_moreM_sim", vo);
	}

	@Override
	public List<StockVO> psychology_line10_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_lessM_sim", vo);
	}

	@Override
	public List<StockVO> psychology_line10_upwardM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_upwardM_sim", vo);
	}

	@Override
	public List<StockVO> psychology_line10_downwardM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".psychology_line10_downwardM_sim", vo);
	}

	
	
	/* 고급 분석 */
	@Override
	public List<StockVO> rising_dayN_min_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_dayN_min_lessM_sim", vo);
	}

	@Override
	public List<StockVO> rising_dayN_min_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_dayN_min_moreM_sim", vo);
	}

	@Override
	public List<StockVO> falling_dayN_max_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_dayN_max_lessM_sim", vo);
	}

	@Override
	public List<StockVO> falling_dayN_max_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_dayN_max_moreM_sim", vo);
	}

	@Override
	public List<StockVO> falling_moreK_after_rising_dayN_min_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".falling_moreK_after_rising_dayN_min_moreM_sim", vo);
	}

	@Override
	public List<StockVO> rising_moreK_after_falling_dayN_max_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".rising_moreK_after_falling_dayN_max_moreM_sim", vo);
	}
	
	@Override
	public List<StockVO> volume_downrate_dayN_lessM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume_downrate_dayN_lessM_sim", vo);
	}

	@Override
	public List<StockVO> volume_uprate_dayN_moreM_sim(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".volume_uprate_dayN_moreM_sim", vo);
	}













}
