package com.oldtom.smartstock.account.service;

import java.util.List;

import com.oldtom.smartstock.account.model.LoginUser;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;
import com.oldtom.smartstock.common.SearchVO;
import com.oldtom.smartstock.product.ProductVO;

public interface UserService {
	
    void 		save(UserVO user);

    UserVO 		findByUsername(String username);
    
    UserVO 		findById(String id);
    
    void		createRole(UserroleVO urole);
    
    public 		List<UserroleVO> getUserRolesById(String id);
    
    void 		updateUser(UserVO user);
    
    void 		updatePassword(UserVO user);
    
    void		deleteUser(String username);
    
    void 		confirmEmail(LoginUser user);
    
    public ProductVO	getUserProduct(ProductVO product);
    
    public Integer 		getUserCount(SearchVO param);
    
    public List<UserVO> getUserList(SearchVO param);
}
