package com.oldtom.smartstock.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

@Service
public class BoardGroupService {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.oldtom.smartstock.mapper.boardMapper";

    public List<?> selectBoardGroupList() {
        return session.selectList(namespace+".selectBoardGroupList");
    }
    
    public void insertBoard(BoardGroupVO param) {
        if ("".equals(param.getBgparent())) {
            param.setBgparent(null);
        }
        
        if (param.getBgno() == null || "".equals(param.getBgno())) {
        	session.insert(namespace+".insertBoardGroup", param);
        } else {
        	session.insert(namespace+".updateBoardGroup", param);
        }
    }
 
    public BoardGroupVO selectBoardGroupOne(String param) {
        return session.selectOne(namespace+".selectBoardGroupOne", param);
    }

    public BoardGroupVO selectBoardGroupOne4Used(String param) {
        return session.selectOne(namespace+".selectBoardGroupOne4Used", param);
    }
    
    public void deleteBoardGroup(String param) {
    	session.delete(namespace+".deleteBoardGroup", param);
    }
    
}
