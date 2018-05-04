package com.oldtom.smartstock.screen.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import com.oldtom.smartstock.stock.model.StockVO;
import org.springframework.stereotype.Repository;

@Repository
public class ScreenDAOImpl implements ScreenDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.oldtom.smartstock.mapper.ScreenMapper";
	
	@Override
	public List<StockVO> getResults(String basedate) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getResults", basedate);
	}

	@Override
	public List<StockVO> getScreen1(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen1", vo);
	}

	@Override
	public List<StockVO> getScreen2(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen2", vo);
	}
	
	@Override
	public List<StockVO> getScreen3(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen3", vo);
	}

	@Override
	public List<StockVO> getScreen4(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen4", vo);
	}

	@Override
	public List<StockVO> getScreen5(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen5", vo);
	}
	
	@Override
	public List<StockVO> getScreen6(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen6", vo);
	}
	
	@Override
	public List<StockVO> getScreen7(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen7", vo);
	}

	@Override
	public List<StockVO> getScreen8(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen8", vo);
	}
	
	@Override
	public List<StockVO> getScreen9(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen9", vo);
	}
	
	@Override
	public List<StockVO> getScreen10(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen10", vo);
	}

	@Override
	public List<StockVO> getScreen11(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen11", vo);
	}
	
	@Override
	public List<StockVO> getScreen12(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen12", vo);
	}
	
	@Override
	public List<StockVO> getScreen13(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen13", vo);
	}

	@Override
	public List<StockVO> getScreen14(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen14", vo);
	}
	
	@Override
	public List<StockVO> getScreen15(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen15", vo);
	}

	@Override
	public List<StockVO> getScreen16(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen16", vo);
	}

	@Override
	public List<StockVO> getScreen17(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen17", vo);
	}

	@Override
	public List<StockVO> getScreen18(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen18", vo);
	}

	@Override
	public List<StockVO> getScreen19(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen19", vo);
	}

	@Override
	public List<StockVO> getScreen20(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".screen20", vo);
	}

	@Override
	public List<StockVO> getProcedure(StockVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".procedure", vo);
	}
}
