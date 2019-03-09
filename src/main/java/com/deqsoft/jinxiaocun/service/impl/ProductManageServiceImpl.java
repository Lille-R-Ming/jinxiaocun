package com.deqsoft.jinxiaocun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqsoft.jinxiaocun.dao.ProductDao;
import com.deqsoft.jinxiaocun.pojo.Product;
import com.deqsoft.jinxiaocun.service.ProductManageService;
import com.github.pagehelper.PageInfo;

@Service
/**
 * 
 * @author lille
 *
 */
public class ProductManageServiceImpl implements ProductManageService {
	@Autowired
	private ProductDao productDao;

	@Override
	public boolean addNewProduct(Product product) {
		// TODO Auto-generated method stub
		if(product==null) {
		return false;	
		}
		if (product.isValidity()) {
			return productDao.insertProduct(product) == 1;
		}
		return false;
	}

	@Override
	public PageInfo<Product> allProduct() {
		// TODO Auto-generated method stub
		return new PageInfo<Product>(productDao.queryAllProduct());
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		if (product.getProductName() == null) {
			return false;
		}
		if(!product.isValidity()) {
			return false;
		}
		String meaningLessString = " ";
		if ("".equals(product.getProductName().replaceAll(meaningLessString, ""))) {
			return false;
		}
		if (!product.isValidity()) {
			return false;
		}
		return productDao.updateProduct(product) == 1;
	}

}
