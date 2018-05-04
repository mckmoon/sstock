package com.oldtom.smartstock.account.service;

public interface SecurityService {
	
    String findLoggedInUsername();
    void autologin(String username, String password);
    
    boolean	isPasswordCorrect(String username, String password);
    
}
