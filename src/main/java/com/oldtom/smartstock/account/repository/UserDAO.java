package com.oldtom.smartstock.account.repository;

import java.util.List;

import com.oldtom.smartstock.account.model.RoleVO;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;
import com.oldtom.smartstock.common.SearchVO;
import com.oldtom.smartstock.product.ProductVO;


public interface UserDAO {
	
    public void 		createUser(UserVO user);

    public UserVO		findByUsername(String username);
    
    public UserVO		findById(String id);
    
    public List<RoleVO> getRolesByUsername(String username);
    
    public List<UserroleVO> getUserRolesById(String id);

    public void			updateUser(UserVO user);
    
    public void			updatePassword(UserVO user);

    public void			deleteUser(String username);
    
    public void			createRole(UserroleVO urole);

	public void 		confirmEmail(String username);
	
	public ProductVO	getUserProduct(ProductVO product);

    public Integer 		selectUserCount(SearchVO param);
    
    public List<UserVO> selectUserList(SearchVO param);
}
