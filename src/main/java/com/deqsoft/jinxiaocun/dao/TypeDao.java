package com.deqsoft.jinxiaocun.dao;

import java.util.List;

import com.deqsoft.jinxiaocun.pojo.ProductType;

/**
 * 
 * @author lille
 *
 */
public interface TypeDao {
	/**
	 * 查询出所有的Type
	 * 
	 * @return 所有的Type列表
	 */
	List<ProductType> queryAllType();

	/**
	 * 添加新的Type类型
	 * 
	 * @param type
	 * @return 受影响的行数
	 */
	int addNewType(ProductType type);

	/**
	 * 删除一条记录
	 * 
	 * @param typeId 需要删除的记录的id
	 * @return 受影响的行数
	 */
	int deleteType(int typeId);
}
