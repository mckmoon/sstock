package com.oldtom.smartstock.account.controller;

import com.oldtom.smartstock.account.model.InqueryVO;
import com.oldtom.smartstock.account.model.LoginUser;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;
import com.oldtom.smartstock.account.service.SecurityService;
import com.oldtom.smartstock.account.service.UserService;
import com.oldtom.smartstock.account.validator.UserValidator;
import com.oldtom.smartstock.common.TempKey;
import com.oldtom.smartstock.product.ProductService;
import com.oldtom.smartstock.product.ProductVO;
import com.oldtom.smartstock.stock.service.TodayService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
	private ProductService productService;
	
	@Autowired
	private JavaMailSender mailSender;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserVO());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserVO userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        // �������� ���� �������� �׽�Ʈ
        userValidator.validateEmail(userForm.getUsername(), bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        model.addAttribute("email", userForm.getUsername());
        //return "redirect:/welcome";
        //return "/today/main";
        return "welcome";
    }

    @RequestMapping(value = "/terms", method = RequestMethod.GET)
    public String terms(Model model) {
        return "terms";
    }
    
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(Model model, Authentication auth) {
    	//LoginUser loginUser = (LoginUser) auth.getPrincipal();
        //model.addAttribute("email", loginUser.getUsername());
        return "welcome";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/*
		DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
			cal.add(Calendar.DATE, -3);
		else if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
			cal.add(Calendar.DATE, -2);
		else
			cal.add(Calendar.DATE, -1);
		
		String basedate = dtf.format(cal.getTime());
		model.addAttribute("basedate", basedate);
	
		model.addAttribute("ma520",service.ma520(basedate));

		model.addAttribute("ma2060",service.ma2060(basedate));
	
		model.addAttribute("ma60120",service.ma60120(basedate));

		model.addAttribute("volume",service.volume(basedate));
		*/
		
		return "home";
    }

    
    @RequestMapping("/denied")
	public String denied(Model model, Authentication auth, HttpServletRequest req, HttpServletResponse res){
	    
	 	LoginUser loginUser = (LoginUser) auth.getPrincipal(); 
 		logger.debug("Email Confirm? " + loginUser.getEmail_conf());
	 	if (loginUser.getEmail_conf().equals("n")) {

	 		model.addAttribute("email", loginUser.getUsername());
	 		return "welcome";
	 	}
	 	
	 	/*
	    AccessDeniedException ade = (AccessDeniedException) req.getAttribute(WebAttributes.ACCESS_DENIED_403);
	    logger.info("exception : {}",ade);
	    //model.addAttribute("auth", auth);
	    //model.addAttribute("errMsg", ade);
	    model.addAttribute("product_blue", productService.getProductListByRole("2"));
	    model.addAttribute("product_silver", productService.getProductListByRole("3"));
	    model.addAttribute("product_gold", productService.getProductListByRole("4"));
	    return "/board/productList";
	    */
	 	//model.addAttribute("denied", "yes");
	 	return "redirect:/product/productList?denied=yes";
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
    		messageHelper.setSubject("StockDB [중요] : 이메일 인증");
    		messageHelper.setText("StockDB 에서 발생한 이메일 인증 코드입니다.\n\n"
    				+ "인증코드 : "+code
    				+ "\n\n 감사합니다.");
    		messageHelper.setTo(email);
    			
    		mailSender.send(message);

    	} catch(Exception e) {
    		code = "0";
    	}
    	return code;
    }

    
    @RequestMapping(value = "/confEmail", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String confEmail(Model model, Authentication auth) {
        String result = "1";
    	LoginUser loginUser = null;
    	
    	try {
	    	loginUser = (LoginUser) auth.getPrincipal();
	        userService.confirmEmail(loginUser);
	        loginUser.setEmail_conf("y");
    	} catch(Exception e) {
    		result = "0";
    	}
        logger.debug("result : {}", result);
        return result;
    }
    
    @RequestMapping(value = "/recover", method = RequestMethod.GET)
    public String recover(Model model) {
        return "recover";
    }
    
    @RequestMapping(value="/recover", method=RequestMethod.POST)
    public @ResponseBody String recover(@RequestParam("email") String email) {

    	UserVO user = userService.findByUsername(email);
        if (user == null) {
            return "0";
        }
    	
    	String code = new TempKey().getKey(6, false);
    	logger.info("code : {}", code);
    	
    	try {
    		
    		MimeMessage message = mailSender.createMimeMessage();
    		MimeMessageHelper messageHelper 
    				= new MimeMessageHelper(message, true, "UTF-8");
    		
    		messageHelper.setFrom(email);
    		messageHelper.setSubject("StockDB [중요] : 암호변경");
    		messageHelper.setText("안녕하세요, 고객님! \n" + "StockDB 관리자입니다.\n\n" 
    				+ "고객님의 임시 비밀번호가 아래와 발급되었습니다.\n 로긴후 반드시 비밀번호를 재설정해주시기 바랍니다."
    				+"임시비번 : "+code);
    		messageHelper.setTo(email);
    			
    		mailSender.send(message);
    		
    		user.setPassword(code);   		// �ӽ� ��й�ȣ
    		userService.updatePassword(user);

    	} catch(Exception e) {
    		logger.debug(e.getMessage());
    		return "1";
    	}
    	return "2";
    }

    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model, Authentication auth) {
    	LoginUser loginUser = (LoginUser) auth.getPrincipal();

    	//logger.debug(securityService.findLoggedInUsername());
    	logger.debug(loginUser.getUsername());
    	UserVO user = userService.findByUsername(loginUser.getUsername());
    	
        model.addAttribute("userForm", user);

        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String profile(@ModelAttribute("userForm") UserVO userForm, BindingResult bindingResult, Model model) {
        userValidator.validateProfile(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "profile";
        }
      
        userService.updateUser(userForm);
        model.addAttribute("update", "ok");

        return "profile";
    }
    
    @RequestMapping(value = "/confirmPassword", method = RequestMethod.POST)
    public @ResponseBody String confirmPassword(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
    	
    	String result = "0";
    	logger.debug("username : {}", result);
    	if (securityService.isPasswordCorrect(username, pwd)) {
    		result = "1";
    	}
    	logger.debug("result : {}", result);
        return result;
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public @ResponseBody String changePassword(@RequestParam("username") String username, @RequestParam("pwd") String pwd) {
    	
    	String result = "1";
    	UserVO user = new UserVO();
    	user.setUsername(username);
    	user.setPassword(pwd);
    	userService.updatePassword(user);
    	
    	logger.debug("result : {}", result);
        return result;
    }
    
    // ���� ��ǰ�� �����ϸ� �ش� ROLE�� ��ȿ �Ⱓ�� �ش� ��ǰ��ŭ �������ش�.
    @RequestMapping(value = "/buyProduct", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String createRole(@RequestParam("pid") String pid) {
    	
        String result = "1";
        
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	LoginUser loginUser = (LoginUser) auth.getPrincipal();  
    	
    	ProductVO product = new ProductVO();
    	product.setId(pid);
    	product.setUser_id(loginUser.getId());   
    	
    	// ������ ��ǰ�� ���� ��ȿ �Ⱓ�� �����´�.
    	ProductVO uproduct = userService.getUserProduct(product);    	
    	
    	try {
    		// ���� �÷��� �°� ROLE ����
    		UserroleVO urole = new UserroleVO();
    		urole.setUser_id(loginUser.getId());
    		urole.setRole_id(uproduct.getRole_id());					
    		urole.setExpire_date(uproduct.getExpire_date());
    		userService.createRole(urole);
    		
    		// �߰��� ROLE�� �α� ������ �缳�� 
    		Set<GrantedAuthority> updatedAuthorities = new HashSet<>(auth.getAuthorities());
    		updatedAuthorities.add(new SimpleGrantedAuthority(uproduct.getRole_name()));
    		Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
    		SecurityContextHolder.getContext().setAuthentication(newAuth);
    		
    	} catch(Exception e) {
    		result = "0";
    		logger.debug(e.getMessage());
    	}
        logger.debug("result : {}", result);
        return result;
    }

    @RequestMapping(value = "/contact", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody String contract(@RequestParam("name") String name, @RequestParam("email") String email,
    		@RequestParam("content") String content) {

    	logger.debug(email + ":" + email + ":" + content );
    	InqueryVO inquery = new InqueryVO();
    	inquery.setName(name);
    	inquery.setEmail(email);
    	inquery.setContent(content);
    	
	    userService.createInquery(inquery);
        return "0";
    }
}
