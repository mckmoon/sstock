package com.oldtom.smartstock.board;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.oldtom.smartstock.common.FileVO;
import com.oldtom.smartstock.common.SearchVO;


@Service
public class BoardService {

	@Inject
	private SqlSession session;
	
	@Inject
    private DataSourceTransactionManager txManager;
    
    private static String namespace = "com.oldtom.smartstock.mapper.boardMapper";
        
    public Integer selectBoardCount(SearchVO param) {
        return session.selectOne("selectBoard8Count", param);
    }
    
    public List<?> selectBoardList(SearchVO param) {
        return session.selectList("selectBoard8List", param);
    }
    
    /**
     * Í∏? ???û•.
     */
    public void insertBoard(BoardVO param, List<FileVO> filelist, String[] fileno) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = txManager.getTransaction(def);
        
        try {
            if (param.getBrdno() == null || "".equals(param.getBrdno())) {
            	session.insert("insertBoard8", param);
            } else {
            	session.update("updateBoard8", param);
            }
            
            if (fileno != null) {
                HashMap<String, String[]> fparam = new HashMap<String, String[]>();
                fparam.put("fileno", fileno);
                session.insert("deleteBoard8File", fparam);
            }
            
            for (FileVO f : filelist) {
                f.setParentPK(param.getBrdno());
                session.insert("insertBoard8File", f);
            }
            txManager.commit(status);
        } catch (TransactionException ex) {
            txManager.rollback(status);
            System.out.println("?ç∞?ù¥?Ñ∞ ???û• ?ò§Î•?: " + ex.toString());
        }            
    }
 
    public BoardVO selectBoardOne(String param) {
        return session.selectOne(namespace+".selectBoard8One", param);
    }
    
    public void updateBoard8Read(String param) {
    	session.insert(namespace+".updateBoard8Read", param);
    }
    
    public void deleteBoardOne(String param) {
    	session.delete(namespace+".deleteBoard8One", param);
    }
    
    public List<?> selectBoard8FileList(String param) {
        return session.selectList(namespace+".selectBoard8FileList", param);
    }
    
    /* =============================================================== */
    public List<?> selectBoard8ReplyList(String param) {
        return session.selectList(namespace+".selectBoard8ReplyList", param);
    }
    
    /**
     * ?åìÍ∏? ???û•. 
     */
    public void insertBoardReply(BoardReplyVO param) {
        if (param.getReno() == null || "".equals(param.getReno())) {
            if (param.getReparent() != null) {
                BoardReplyVO replyInfo = session.selectOne(namespace+".selectBoard8ReplyParent", param.getReparent());
                param.setRedepth(replyInfo.getRedepth());
                param.setReorder(replyInfo.getReorder() + 1);
                session.selectOne(namespace+".updateBoard8ReplyOrder", replyInfo);
            } else {
                Integer reorder = session.selectOne(namespace+".selectBoard8ReplyMaxOrder", param.getBrdno());
                param.setReorder(reorder);
            }
            
            session.insert(namespace+".insertBoard8Reply", param);
        } else {
        	session.insert(namespace+".updateBoard8Reply", param);
        }
    }   
    
    /**
     * ?åìÍ∏? ?Ç≠?†ú.
     * ?ûê?ãù ?åìÍ∏??ù¥ ?ûà?úºÎ©? ?Ç≠?†ú ?ïà?ê®. 
     */
    public boolean deleteBoard8Reply(String param) {
        Integer cnt = session.selectOne("selectBoard8ReplyChild", param);
        
        if ( cnt > 0) {
            return false;
        }
        
        session.update("updateBoard8ReplyOrder4Delete", param);
        
        session.delete("deleteBoard8Reply", param);
        
        return true;
    }    
}
