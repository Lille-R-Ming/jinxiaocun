package com.deqsoft.jinxiaocun.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.deqsoft.jinxiaocun.AppTest;
import com.deqsoft.jinxiaocun.pojo.Product;
import com.deqsoft.jinxiaocun.service.ProductManageService;

import junit.framework.Assert;
/**
 * 
 * @author lille
 *
 */
public class ProductManageServiceImplTest extends AppTest {
	@Autowired
	ProductManageService productManageService;
	@Test
	public void testAddNewProduct() {
		Assert.assertFalse(productManageService.addNewProduct(new Product()));
		Assert.assertFalse(productManageService.addNewProduct(new Product("aaaaaaaaaaa")));
		Assert.assertTrue(productManageService.addNewProduct(new Product("aaaaaaaaaa")));
		Assert.assertFalse(productManageService.addNewProduct(new Product("")));
	}
	
}