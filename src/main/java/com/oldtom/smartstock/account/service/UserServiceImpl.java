package com.oldtom.smartstock.account.service;

import com.oldtom.smartstock.account.model.InqueryVO;
import com.oldtom.smartstock.account.model.LoginUser;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;
import com.oldtom.smartstock.account.repository.UserDAO;
import com.oldtom.smartstock.common.SearchVO;
import com.oldtom.smartstock.product.ProductVO;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
    @Autowired
    private UserDAO userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(UserVO user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.createUser(user);
        
		UserVO new_user = this.findByUsername(user.getUsername());		
		UserroleVO urole = new UserroleVO();
		urole.setUser_id(new_user.getId());
		urole.setRole_id(1);					// ROLE_USER
		urole.setExpire_date("99991231");
		userRepository.createRole(urole);

    }

    @Override
    public UserVO findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	@Override
	public void createRole(UserroleVO urole) {
		// TODO Auto-generated method stub
		userRepository.createRole(urole);
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		// user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); 
		// ��й�ȣ�� ������ �����Ѵ�.
        userRepository.updateUser(user);		
	}

	@Override
	public void confirmEmail(LoginUser user) {
		// TODO Auto-generated method stub
		userRepository.confirmEmail(user.getUsername());
		UserroleVO urole = new UserroleVO();
		urole.setUser_id(user.getId());
		urole.setRole_id(2);					// ROLE_BLUE
		urole.setExpire_date("99991231");
		userRepository.createRole(urole);
	}

	@Override
	public Integer getUserCount(SearchVO param) {
		// TODO Auto-generated method stub
		return userRepository.selectUserCount(param);
	}

	@Override
	public List<UserVO> getUserList(SearchVO param) {
		// TODO Auto-generated method stub
		return userRepository.selectUserList(param);
	}

	@Override
	public UserVO findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	
	@Override
	public void updatePassword(UserVO user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.updatePassword(user);
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(username);
	}

	@Override
	public List<UserroleVO> getUserRolesById(String id) {
		// TODO Auto-generated method stub
		return userRepository.getUserRolesById(id);
	}

	@Override
	public ProductVO getUserProduct(ProductVO product) {
		// TODO Auto-generated method stub
		return userRepository.getUserProduct(product);
	}

	@Override
	public void createInquery(InqueryVO inquery) {
		// TODO Auto-generated method stub
		userRepository.createInquery(inquery);
	}

	@Override
	public InqueryVO getInquery(long id) {
		// TODO Auto-generated method stub
		return userRepository.getInquery(id);
	}

	@Override
	public void deleteInquery(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteInquery(id);
	}

	@Override
	public List<InqueryVO> getInqueryList(SearchVO param) {
		// TODO Auto-generated method stub
		return userRepository.getInqueryList(param);
	}

	@Override
	public Integer getInqueryCount(SearchVO param) {
		// TODO Auto-generated method stub
		return userRepository.getInqueryCount(param);
	}


}
