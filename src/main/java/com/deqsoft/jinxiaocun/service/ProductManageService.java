package com.deqsoft.jinxiaocun.service;

import com.deqsoft.jinxiaocun.pojo.Product;

import com.github.pagehelper.PageInfo;

/**
 * 
 * @author lille
 *
 */
public interface ProductManageService {
	/**
	 * 添加一个Product
	 * 
	 * @param product
	 * @return 成功返回true
	 */
	boolean addNewProduct(Product product);

	/**
	 * 获取全部的Product
	 * 
	 * @return 分页文件格式的结果
	 */
	PageInfo<Product> allProduct();

	/**
	 * 更新一条Product的内容
	 * 
	 * @param product 更新后的Product
	 * @return 成功返回true
	 */
	boolean updateProduct(Product product);
}
