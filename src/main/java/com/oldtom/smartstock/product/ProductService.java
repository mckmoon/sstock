package com.oldtom.smartstock.product;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;

import com.oldtom.smartstock.common.SearchVO;

@Service
public class ProductService {

	@Inject
	private SqlSession session;
	
	@Inject
    private DataSourceTransactionManager txManager;
    
    private static String namespace = "com.oldtom.smartstock.mapper.ProductMapper";
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    public void createProduct(ProductVO product) {
    	session.insert(namespace+".createProduct", product);
    }
    
    public ProductVO getProduct(String id) {
    	//logger.debug("id: " + id);
    	return  session.selectOne(namespace + ".getProduct", id);
    }
    
    public void updateProduct(ProductVO product) {
    	session.update(namespace+".updateProduct", product);
    }
    
    public void deleteProduct(String id) {
    	session.delete(namespace+".deleteProduct", id);
    }
    
    
    public Integer getProductCount(SearchVO param) {
    	return session.selectOne("getProductCount", param);
    }
    
    public List<ProductVO> getProductList(SearchVO param) {
    	return session.selectList("getProductList", param);
    }
    
    public List<ProductVO> getProductListByRole(String role_id) {
    	return session.selectList("getProductListByRole", role_id);
    }
}
