package com.oldtom.smartstock.account.service;

import com.oldtom.smartstock.account.model.LoginUser;
import com.oldtom.smartstock.account.model.RoleVO;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.repository.UserDAO;
import com.oldtom.smartstock.account.repository.UserDAOImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
    @Autowired
    private UserDAO userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    	UserVO user = userRepository.findByUsername(username);
    	
    	if ("".equals(username) || user == null)
    		return new LoginUser(username, "NA", grantedAuthorities, null, null, null, null, null, null, null, null);
				

        for (RoleVO role : userRepository.getRolesByUsername(username)){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        
        return new LoginUser(user.getUsername(), user.getPassword(), grantedAuthorities,
        					user.getId(), user.getName(), user.getNickname(), user.getBirth_date(), 
        					user.getPhone_no(), user.getAddress(), user.getEmail_conf(), user.getReg_date());
    }
}
