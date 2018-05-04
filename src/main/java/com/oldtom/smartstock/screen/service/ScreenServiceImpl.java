package com.oldtom.smartstock.screen.service;

import java.util.List;

import javax.inject.Inject;

import com.oldtom.smartstock.stock.model.StockVO;
import com.oldtom.smartstock.screen.persistence.ScreenDAO;
import org.springframework.stereotype.Service;

@Service
public class ScreenServiceImpl implements ScreenService {
	
	@Inject
	private ScreenDAO sdao;

	@Override
	public List<StockVO> getResults(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getResults(basedate);
	}

	@Override
	public List<StockVO> getScreen1(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen1(vo);
	}

	@Override
	public List<StockVO> getScreen2(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen2(vo);
	}

	@Override
	public List<StockVO> getScreen3(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen3(vo);
	}

	@Override
	public List<StockVO> getScreen4(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen4(vo);
	}

	@Override
	public List<StockVO> getScreen5(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen5(vo);
	}

	@Override
	public List<StockVO> getScreen6(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen6(vo);
	}

	@Override
	public List<StockVO> getScreen7(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen7(vo);
	}

	@Override
	public List<StockVO> getScreen8(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen8(vo);
	}

	@Override
	public List<StockVO> getScreen9(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen9(vo);
	}

	@Override
	public List<StockVO> getScreen10(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen10(vo);
	}

	@Override
	public List<StockVO> getScreen11(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen11(vo);
	}

	@Override
	public List<StockVO> getScreen12(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen12(vo);
	}

	@Override
	public List<StockVO> getScreen13(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen13(vo);
	}

	@Override
	public List<StockVO> getScreen14(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen14(vo);
	}

	@Override
	public List<StockVO> getScreen15(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen15(vo);
	}

	@Override
	public List<StockVO> getScreen16(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen16(vo);
	}

	@Override
	public List<StockVO> getScreen17(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen17(vo);
	}

	@Override
	public List<StockVO> getScreen18(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen18(vo);
	}

	@Override
	public List<StockVO> getScreen19(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen19(vo);
	}

	@Override
	public List<StockVO> getScreen20(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getScreen20(vo);
	}

	@Override
	public List<StockVO> getProdedure(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return sdao.getProcedure(vo);
	}

}
