package com.deqsoft.jinxiaocun.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deqsoft.jinxiaocun.pojo.Product;
import com.deqsoft.jinxiaocun.service.ProductManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller

/**
 * 
 * @author lille
 * 
 */
public class ProductController {
	@Autowired
	private ProductManageService productManageService;
	
	@RequestMapping("/inventory")
	public String getProductPage() {
		return "inventory";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getproductlist", method = RequestMethod.POST)
	public PageInfo<Product> getProductList(@RequestParam(value = "page", defaultValue = "1") String page,
			@RequestParam(value = "type", defaultValue = "page") String type) {
		Integer pageValue=0;
		try {
		pageValue=Integer.valueOf(page);
		}catch(NumberFormatException e) {
			PageHelper.startPage(1, 10);
		}
		if (FLAG_GET_ALL_PRODUCT.equals(type)) {
			PageHelper.startPage(1, 0);
		}
		else {
			PageHelper.startPage(pageValue, 10);
		}
		return productManageService.allProduct();
	}
	
	@ResponseBody
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public Map<String, Object> addProduct(Product product) {
		Map<String, Object> map = new HashMap<String, Object>(2);
		if (productManageService.addNewProduct(product)) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateproduct",method=RequestMethod.POST)
	public Map<String,Object> updateProduct(Product product){
		Map<String,Object> map=new HashMap<String,Object>(4);
	
		if("".equals(product.getProductName())) {
			map.put("result", "fail");
			map.put("reason", "空的商品名称");
		}
		else if(productManageService.updateProduct(product))
			map.put("result", "success");
		else {
			map.put("result", "fail");
			map.put("reason", "未知的错误");
		}
		return map;
	}
	/**
	 * 标识该url请求的目的是获取所有的type记录，而不是分页获取
	 */
	private final static String FLAG_GET_ALL_PRODUCT="all";
}
