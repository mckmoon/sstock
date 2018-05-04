package com.oldtom.smartstock.account.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.ui.Model;

import com.oldtom.smartstock.account.model.LoginUser;

public class UserDeniedHandler implements AccessDeniedHandler{
	  
private static final Logger logger = LoggerFactory.getLogger(UserDeniedHandler.class);
  
@Override
public void handle(HttpServletRequest req, HttpServletResponse res,
	AccessDeniedException ade) throws IOException, ServletException {
		// TODO Auto-generated method stub
		logger.debug("Exceiption : {}",ade);
		logger.debug("LocalizedMessage : {}",ade.getLocalizedMessage());
		logger.debug("Message : {}",ade.getMessage());
		//logger.debug("StackTrace : {}",ade.getStackTrace());
		req.setAttribute("errMsg",ade.getMessage());
	 	req.getRequestDispatcher("/WEB-INF/views/denied.jsp").forward(req, res);
	}
  
}
