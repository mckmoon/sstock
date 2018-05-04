package com.oldtom.smartstock.product;


import com.oldtom.smartstock.account.model.UserVO;
import com.oldtom.smartstock.account.model.UserroleVO;

import com.oldtom.smartstock.account.service.UserService;

import com.oldtom.smartstock.common.SearchVO;
import com.oldtom.smartstock.common.TempKey;

import java.util.List;


import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/")
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
    @Autowired
    private ProductService service;
	

    @RequestMapping(value = "/ProductList")
    public String ProductList(SearchVO searchVO, Model model) {

        searchVO.pageCalculate( service.getProductCount(searchVO) ); // startRow, endRow

        List<?> listview  = service.getProductList(searchVO);
        
        model.addAttribute("list", listview);
        model.addAttribute("searchVO", searchVO);
        
        logger.debug(searchVO.getSearchType());
        //logger.debug(searchVO.getSearchTypeArr());
        
        return "admin/ProductList";
    }


    @RequestMapping(value = "/ProductForm")
    public String ProductForm(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");

        if (id != null) {
            ProductVO product = service.getProduct(id);      
            model.addAttribute("product", product);
        }
        else {
        	model.addAttribute("id", "0");		// 신규 상품 등록
        }
        return "admin/ProductForm";
    }
    
    /**
     * 상품 정보 저장.
     */
    @RequestMapping(value = "/ProductSave")
    public String productSave(HttpServletRequest request, ProductVO product) {
    	if (product.getId() == "") {
    		service.createProduct(product);
    	} else {
    		service.updateProduct(product);
    	}

        //redirect시에는 현재위치를 기준으로...
        return "redirect:ProductList";
    }
    
    /**
     * 상품 정보 삭제.
     */
    @RequestMapping(value = "/ProductDelete")
    public String productDelete(HttpServletRequest request, ProductVO product) {

    	service.deleteProduct(product.getId());

        //redirect시에는 현재위치를 기준으로...
        return "redirect:ProductList";
    }
}
