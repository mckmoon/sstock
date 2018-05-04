package com.oldtom.smartstock.stock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.stock.persistence.StockDAO;

@Service
public class SimulationServiceImpl implements SimulationService {

	@Inject
	private StockDAO sdao;

	@Override
	public float kospi_rate(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		return (float) (Math.round(sdao.kospi_rate(vo)*100)/100.0);
	}

	/* 기본 분석 */
	@Override
	public List<StockVO> risingFalling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rising_dayN_moreM_sim(vo);
		}
		return sdao.falling_dayN_moreM_sim(vo);
	}

	@Override
	public List<StockVO> fluctuation(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.fluctuation_dayN_moreM_sim(vo);
		}
		return sdao.fluctuation_dayN_lessM_sim(vo);
	}


	@Override
	public List<StockVO> contRisingFalling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.cont_rising_dayN_sim(vo);
		}
		return sdao.cont_falling_dayN_sim(vo);
	}
	
	@Override
	public List<StockVO> holder(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getHolder().equals("KK")) {
			return sdao.holderKK_moreM_sim(vo);
		}
		return sdao.holderN_moreM_sim(vo);
	}


	@Override
	public List<StockVO> foreignRate(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.foreign_rate_rising_dayN_moreM_sim(vo);
		}
		return sdao.foreign_rate_falling_dayN_lessM_sim(vo);
	}
	
	@Override
	public List<StockVO> gongsin(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.gongmaedo_rising_moreM_sim(vo);
		}
		return sdao.sinyong_rising_moreM_sim(vo);
	}

	@Override
	public List<StockVO> foreignBuyingSelling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.foreign_cont_buying_dayN_sim(vo);
		}
		return sdao.foreign_cont_selling_dayN_sim(vo);
	}

	@Override
	public List<StockVO> companyBuyingSelling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.company_cont_buying_dayN_sim(vo);
		}
		return sdao.company_cont_selling_dayN_sim(vo);
	}

	
	/* 이동평균선 분석 */
	@Override
	public List<StockVO> ma520(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma5_20_upward_sim(vo);
		}
		return sdao.ma5_20_downward_sim(vo);
	}

	@Override
	public List<StockVO> ma2060(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma20_60_upward_sim(vo);
		}
		return sdao.ma20_60_downward_sim(vo);
	}

	@Override
	public List<StockVO> ma520UpwardMoreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma5_20_upward_rising_moreM_sim(vo);
	}

	@Override
	public List<StockVO> ma520DownwardMoreM(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.ma5_20_downward_falling_moreM_sim(vo);
	}
	
	@Override
	public List<StockVO> ma520MoreK(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma5_20_upward_dayN_moreK_sim(vo);
		}
		return sdao.ma5_20_downward_dayN_moreK_sim(vo);
	}

	@Override
	public List<StockVO> maArrange(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.ma_arrange_positive_sim(vo);
		}
		return sdao.ma_arrange_negative_sim(vo);
	}

	@Override
	public List<StockVO> convergentMa520(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.convergent_ma5_20_upward_sim(vo);
		}
		return sdao.convergent_ma5_20_downward_sim(vo);
	}

	@Override
	public List<StockVO> wma520(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.week_ma5_20_upward_sim(vo);
		}
		return sdao.week_ma5_20_downward_sim(vo);
	}

	@Override
	public List<StockVO> wma2060(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.week_ma20_60_upward_sim(vo);
		}
		return sdao.week_ma20_60_downward_sim(vo);
	}

	
	/* 보조지표 분석 */
	@Override
	public List<StockVO> macd_plus(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.macd_plus_sim(vo);
	}

	@Override
	public List<StockVO> macd_rising_falling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.macd_rising_trend_sim(vo);
		}
		return sdao.macd_falling_trend_sim(vo);
	}

	@Override
	public List<StockVO> macd_golden_dead(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.macd_golden_cross_sim(vo);
		}
		return sdao.macd_dead_cross_sim(vo);
	}

	@Override
	public List<StockVO> rsi(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rsi_moreM_sim(vo);
		}
		return sdao.rsi_lessM_sim(vo);
	}

	@Override
	public List<StockVO> rsi_updown(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rsi_upwardM_sim(vo);
		}
		return sdao.rsi_downwardM_sim(vo);
	}

	@Override
	public List<StockVO> stocastic_slow(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.stocastic_moreM_sim(vo);
		}
		return sdao.stocastic_lessM_sim(vo);
	}

	@Override
	public List<StockVO> stocastic_updown(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.stocastic_upwardM_sim(vo);
		}
		return sdao.stocastic_downwardM_sim(vo);
	}

	@Override
	public List<StockVO> stocastic_golden_dead(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.stocastic_golden_cross_sim(vo);
		}
		return sdao.stocastic_dead_cross_sim(vo);
	}

	@Override
	public List<StockVO> deal_strength(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.deal_strength_moreM_sim(vo);
		}
		return sdao.deal_strength_lessM_sim(vo);
	}

	@Override
	public List<StockVO> deal_strength_rising_falling(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.deal_strength_rising_moreM_sim(vo);
		}
		return sdao.deal_strength_falling_moreM_sim(vo);
	}

	@Override
	public List<StockVO> psychology_line10(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.psychology_line10_moreM_sim(vo);
		}
		return sdao.psychology_line10_lessM_sim(vo);
	}

	@Override
	public List<StockVO> psychology_line10_updown(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.psychology_line10_upwardM_sim(vo);
		}
		return sdao.psychology_line10_downwardM_sim(vo);
	}

	@Override
	public List<StockVO> seperation_rate(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.seperation_rate_maN_moreM_sim(vo);
		}
		return sdao.seperation_rate_maN_lessM_sim(vo);
	}

	
	/* 고급 분석 */
	@Override
	public List<StockVO> risingNdaysMin(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.rising_dayN_min_moreM_sim(vo);
		}
		return sdao.rising_dayN_min_lessM_sim(vo);
	}

	@Override
	public List<StockVO> fallingNdaysMax(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.falling_dayN_max_moreM_sim(vo);
		}
		return sdao.falling_dayN_max_lessM_sim(vo);
	}

	@Override
	public List<StockVO> fallingNdaysMaxPositivePole(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.rising_moreK_after_falling_dayN_max_moreM_sim(vo);
	}

	@Override
	public List<StockVO> risingNdaysMinNegativePole(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.falling_moreK_after_rising_dayN_min_moreM_sim(vo);
		
	}

	@Override
	public List<StockVO> volume_rate_ndays_avg(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		if (vo.getSign().equals("1")) {
			return sdao.volume_uprate_dayN_moreM_sim(vo);
		}
		return sdao.volume_downrate_dayN_lessM_sim(vo);
	}



}
