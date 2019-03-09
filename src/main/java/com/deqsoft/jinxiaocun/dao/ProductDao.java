package com.deqsoft.jinxiaocun.dao;

import java.util.List;

import com.deqsoft.jinxiaocun.pojo.Product;
/**
 * 
 * @author lille
 *
 */
public interface ProductDao {
	/**
	 * 查找全部的Product
	 * @return Product列表
	 */
	List<Product> queryAllProduct();
	/**
	 * 插入一条Product记录
	 * @param product要插入的Product
	 * @return 受影响的行数
	 */
	int insertProduct(Product product);
	/**
	 * 更新一条Product记录
	 * @param product 要被更新的Product
	 * @return 受影响的行数
	 */
	int updateProduct(Product product);
	/**
	 * 获取一条Product记录
	 * @param productId 给条记录的ID，即数据库主键
	 * @return 包装后的Product数据
	 */
	Product queryById(int productId);
}
