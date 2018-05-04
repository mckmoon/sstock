package com.oldtom.smartstock.account.validator;

import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.service.UserService;
import com.oldtom.smartstock.common.TempKey;

import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    
	@Autowired
	private JavaMailSender mailSender;

    private final String emailRegExp = 
    		"^([a-zA-Z0-9_\\.\\+/-]+)@([a-zA-Z0-9]+)\\.([a-zA-Z\\.]{2,})$";

    private final String passRegExp = 
    		"^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,}$"; // 특수문자, 영문자, 숫자 포함 8글자 이상

    private Pattern pattern;
    private Pattern pattern2;

    

    public UserValidator() {

     // TODO Auto-generated constructor stub

     pattern = Pattern.compile(emailRegExp);
     pattern2 = Pattern.compile(passRegExp);

    }
   
   
    @Override
    public boolean supports(Class<?> aClass) {
        return UserVO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserVO user = (UserVO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");

        if (!pattern.matcher(user.getUsername()).matches()) {
        	errors.rejectValue("username", "Email.userForm.username");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth_date", "NotEmpty");
        if (user.getBirth_date().length() != 8) {
            errors.rejectValue("birth_date", "Size.userForm.birth_date");
        }
        
        if (!user.isContractAgreement()) {
        	errors.rejectValue("username", "Agree.userForm.contractAgreement");
        }
    
    }

    public void validateEmail(String email, Errors errors) {

    	try {
    		
    		MimeMessage message = mailSender.createMimeMessage();
    		MimeMessageHelper messageHelper 
    				= new MimeMessageHelper(message, true, "UTF-8");
    		
    		messageHelper.setFrom(email);
    		messageHelper.setSubject("StockDB [회원가입] : 감사합니다.");
    		messageHelper.setText("안녕하세요, 고객님! \n"
    				+ "StockDB에 가입을 환영합니다. \n");
    		messageHelper.setTo(email);
    			
    		mailSender.send(message);

    	} catch(Exception e) {
    		errors.rejectValue("contractAgreement", "ValidEmail.userForm.username");
    	}    	
    }
    
    public void validateProfile(Object o, Errors errors) {
        UserVO user = (UserVO) o;

        /*
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
		*/
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birth_date", "NotEmpty");
        if (user.getBirth_date().length() != 8) {
            errors.rejectValue("birth_date", "Size.userForm.birth_date");
        }
    
    }

}
