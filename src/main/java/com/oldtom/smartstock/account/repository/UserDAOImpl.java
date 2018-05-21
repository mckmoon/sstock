package com.oldtom.smartstock.account.repository;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.oldtom.smartstock.account.model.InqueryVO;
import com.oldtom.smartstock.account.model.RoleVO;
import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;
import com.oldtom.smartstock.common.SearchVO;
import com.oldtom.smartstock.product.ProductVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	private SqlSession session;

	private static String namespace = "com.oldtom.smartstock.mapper.UserMapper";
	

	@Override
	public void createUser(UserVO user) {
		// TODO Auto-generated method stub
		//logger.debug(user.toString());
		if ("".equals(user.getBirth_date())) {
			user.setBirth_date("19000101");
		}
		
		session.insert(namespace+".createUser", user);

	}

	@Override
	public UserVO findByUsername(String username) {
		// TODO Auto-generated method stub
		return  session.selectOne(namespace + ".getUserByUsername", username);
	}

	@Override
	public void updateUser(UserVO user) {
		// TODO Auto-generated method stub
		//user.setPassword(encoder.encodePassword(user.getPassword(), null));
		session.update(namespace+".updateUser", user);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		//session.delete(namespace+".deleteRole", username);
		session.delete(namespace+".deleteUser", username);
	}


	@Override
	public List<RoleVO> getRolesByUsername(String username) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getRoles", username);
	}


	@Override
	public List<UserroleVO> getUserRolesById(String id) {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".getUserRoles", id);
	}
	
	@Override
	public void createRole(UserroleVO urole) {
		// TODO Auto-generated method stub
		session.insert(namespace+".createRole", urole);
	}

	@Override
	public void confirmEmail(String username) {
		// TODO Auto-generated method stub
		session.update(namespace+".confirmEmail", username);
	}

	@Override
	public ProductVO getUserProduct(ProductVO product) {
		// TODO Auto-generated method stub
		return  session.selectOne(namespace + ".getUserProduct", product);
	}

	@Override
	public Integer selectUserCount(SearchVO param) {
		// TODO Auto-generated method stub
		return session.selectOne("selectUserCount", param);
	}

	@Override
	public List<UserVO> selectUserList(SearchVO param) {
		// TODO Auto-generated method stub
		return session.selectList("selectUserList", param);
	}

	@Override
	public UserVO findById(String id) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getUserById", id);
	}

	@Override
	public void updatePassword(UserVO user) {
		// TODO Auto-generated method stub
		//user.setPassword(encoder.encodePassword(user.getPassword(), null));
		session.update(namespace+".updatePassword", user);
	}

	@Override
	public void createInquery(InqueryVO inquery) {
		// TODO Auto-generated method stub
		session.insert(namespace+".createInquery", inquery);
	}

	@Override
	public InqueryVO getInquery(long id) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace + ".getInquery", id);
	}

	@Override
	public void deleteInquery(long id) {
		// TODO Auto-generated method stub
		session.delete(namespace+".deleteInquery", id);
	}

	@Override
	public List<InqueryVO> getInqueryList(SearchVO param) {
		// TODO Auto-generated method stub
		return session.selectList("selectInqueryList", param);
	}

	@Override
	public Integer getInqueryCount(SearchVO param) {
		// TODO Auto-generated method stub
		return session.selectOne("selectInqueryCount", param);
	}





}
