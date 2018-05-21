package com.oldtom.smartstock.account.controller;


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
public class UserAdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAdminController.class);
	
    @Autowired
    private UserService userService;
	
	@Autowired
	private JavaMailSender mailSender;

    @RequestMapping(value = "/UserList")
    public String UserList(SearchVO searchVO, Model model) {

        searchVO.pageCalculate( userService.getUserCount(searchVO) ); // startRow, endRow

        List<?> listview  = userService.getUserList(searchVO);
        
        model.addAttribute("list", listview);
        model.addAttribute("searchVO", searchVO);
        
        logger.debug(searchVO.getSearchType());
        //logger.debug(searchVO.getSearchTypeArr());
        
        return "admin/UserList";
    }


    @RequestMapping(value = "/userForm")
    public String boardForm(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");

        
        if (id != null) {
            UserVO user = userService.findById(id);      
            model.addAttribute("user", user);

            List<UserroleVO> userroles = userService.getUserRolesById(id);
            model.addAttribute("roles", userroles);
        }
        
        return "admin/UserForm";
    }
    
    /**
     * ȸ�� ���� ����.
     */
    @RequestMapping(value = "/userSave")
    public String userSave(HttpServletRequest request, UserVO user) {

    	userService.updateUser(user);

        //redirect시에는 현재위치를 기준으로...
        return "redirect:userList";
    }
    
    /**
     * ���� ���� ����.
     */
    @RequestMapping(value = "/roleSave")
    public String roleSave(HttpServletRequest request, UserroleVO urole) {
    	String id = request.getParameter("id");
    	userService.createRole(urole);

    	request.setAttribute("id", id);
        //redirect시에는 현재위치를 기준으로...
        return "redirect:userForm?id="+id;
    }
    

    @RequestMapping(value="/authEmail", method=RequestMethod.POST)
    public @ResponseBody String authEmail(@RequestParam("email") String email) {
    	String code = new TempKey().getKey(6, false);
    	logger.debug("code : {}", code);
    	try {
    		
    		MimeMessage message = mailSender.createMimeMessage();
    		MimeMessageHelper messageHelper 
    				= new MimeMessageHelper(message, true, "UTF-8");
    		
    		messageHelper.setFrom(email);
    		messageHelper.setSubject("StockDB [�̸��� ����] : Ȯ�����ּ���.");
    		messageHelper.setText("StockDB ���� ���� �̸����Դϴ�."
    				+"������ȣ : "+code+"\n �����մϴ�.");
    		messageHelper.setTo(email);
    			
    		mailSender.send(message);

    	} catch(Exception e) {
    		code = "0";
    	}
    	return code;
    }

    

}
