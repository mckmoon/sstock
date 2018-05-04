package com.oldtom.smartstock.board;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.oldtom.smartstock.board.BoardService;
import com.oldtom.smartstock.account.controller.UserController;
import com.oldtom.smartstock.board.BoardReplyVO;
import com.oldtom.smartstock.board.BoardVO;
import com.oldtom.smartstock.common.FileUtil;
import com.oldtom.smartstock.common.FileVO;
import com.oldtom.smartstock.common.SearchVO;

@Controller 
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    private BoardService boardSvc;
    @Autowired
    private BoardGroupService boardGroupSvc;

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
    /**
     * 리스트.
     */
    @RequestMapping(value = "/boardList")
    public String boardList(SearchVO searchVO, ModelMap modelMap) {
        
        BoardGroupVO bgInfo = boardGroupSvc.selectBoardGroupOne4Used(searchVO.getBgno());
        if (bgInfo == null) {
            return "board/BoardGroupFail";
        }
        
        searchVO.pageCalculate( boardSvc.selectBoardCount(searchVO) ); // startRow, endRow

        List<?> listview  = boardSvc.selectBoardList(searchVO);
        
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("searchVO", searchVO);
        modelMap.addAttribute("bgInfo", bgInfo);
        
        logger.debug(searchVO.getSearchType());
        //logger.debug(searchVO.getSearchTypeArr());
        
        return "board/BoardList";
    }
    
    /** 
     * 글 쓰기. 
     */
    @RequestMapping(value = "/boardForm")
    public String boardForm(HttpServletRequest request, ModelMap modelMap) {
        String bgno = request.getParameter("bgno");
        String brdno = request.getParameter("brdno");
        
        if (brdno != null) {
            BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
            List<?> listview = boardSvc.selectBoard8FileList(brdno);
        
            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);
            bgno = boardInfo.getBgno();
        }
        BoardGroupVO bgInfo = boardGroupSvc.selectBoardGroupOne4Used(bgno);
        if (bgInfo == null) {
            return "board/BoardGroupFail";
        }
        
        modelMap.addAttribute("bgno", bgno);
        modelMap.addAttribute("bgInfo", bgInfo);
        
        return "board/BoardForm";
    }
    
    /**
     * 글 저장.
     */
    @RequestMapping(value = "/boardSave")
    public String boardSave(HttpServletRequest request, BoardVO boardInfo) {
        String[] fileno = request.getParameterValues("fileno");
        
        FileUtil fs = new FileUtil();
        List<FileVO> filelist = fs.saveAllFiles(boardInfo.getUploadfile());

        boardSvc.insertBoard(boardInfo, filelist, fileno);

        //redirect시에는 현재위치를 기준으로...
        return "redirect:boardList?bgno=" + boardInfo.getBgno();
    }

    /**
     * 글 읽기.
     */
    @RequestMapping(value = "/boardRead")
    public String board8Read(HttpServletRequest request, ModelMap modelMap) {
        String brdno = request.getParameter("brdno");
        
        boardSvc.updateBoard8Read(brdno);
        BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
        List<?> listview = boardSvc.selectBoard8FileList(brdno);
        List<?> replylist = boardSvc.selectBoard8ReplyList(brdno);

        BoardGroupVO bgInfo = boardGroupSvc.selectBoardGroupOne4Used(boardInfo.getBgno());
        if (bgInfo == null) {
            return "board/BoardGroupFail";
        }
        
        modelMap.addAttribute("boardInfo", boardInfo);
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("replylist", replylist);
        modelMap.addAttribute("bgInfo", bgInfo);
        
        return "board/BoardRead";
    }
    
    /**
     * 글 삭제.
     */
    @RequestMapping(value = "/boardDelete")
    public String boardDelete(HttpServletRequest request) {
        String brdno = request.getParameter("brdno");
        String bgno = request.getParameter("bgno");
        
        boardSvc.deleteBoardOne(brdno);
        
        return "redirect:boardList?bgno=" + bgno;
    }

    /* ===================================================================== */
    
    /**
     * 댓글 저장.
     */
    @RequestMapping(value = "/boardReplySave")
    public String board8ReplySave(HttpServletRequest request, BoardReplyVO boardReplyInfo, ModelMap modelMap) {
        
        boardSvc.insertBoardReply(boardReplyInfo);

        modelMap.addAttribute("replyInfo", boardReplyInfo);
        
        return "board/BoardReadAjax4Reply";        
    }
    
    /**
     * 댓글 삭제.
     */
    @RequestMapping(value = "/boardReplyDelete")
    public void board8ReplyDelete(HttpServletResponse response, BoardReplyVO boardReplyInfo) {
        
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            if (!boardSvc.deleteBoard8Reply(boardReplyInfo.getReno()) ) {
                response.getWriter().print(mapper.writeValueAsString("Fail"));
            } else {
                response.getWriter().print(mapper.writeValueAsString("OK"));
            }
        } catch (IOException ex) {
            System.out.println("오류: 댓글 삭제에 문제가 발생했습니다.");
        }
    }
   
}