package com.oldtom.smartstock.account.controller;


import com.oldtom.smartstock.account.model.InqueryVO;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;

import com.oldtom.smartstock.account.service.UserService;

import com.oldtom.smartstock.common.SearchVO;
import com.oldtom.smartstock.common.TempKey;

import java.util.List;


import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/")
public class UserInqueryController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserInqueryController.class);
	
    @Autowired
    private UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;

    @RequestMapping(value = "/InqueryList")
    public String UserList(SearchVO searchVO, Model model) {

        searchVO.pageCalculate( userService.getInqueryCount(searchVO) ); // startRow, endRow

        List<?> listview  = userService.getInqueryList(searchVO);
        
        model.addAttribute("list", listview);
        model.addAttribute("searchVO", searchVO);
        
        logger.debug(searchVO.getSearchType());
        //logger.debug(searchVO.getSearchTypeArr());
        
        return "admin/InqueryList";
    }


    @RequestMapping(value = "/inqueryForm")
    public String inqueryForm(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");

        
        if (id != null) {
            InqueryVO inquery = userService.getInquery(Long.parseLong(id));      
            model.addAttribute("inquery", inquery);
        }
        
        return "admin/InqueryForm";
    }
      

    

}
