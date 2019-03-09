package com.deqsoft.jinxiaocun.service;

import com.deqsoft.jinxiaocun.pojo.ProductType;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @author lille
 *
 */
public interface TypeManageService {
	/**
	 * 获取所有的Type列表
	 * @return
	 */
	PageInfo<ProductType> getTypeList();
	/**
	 * 添加一种Type
	 * @param productType
	 * @return 操作成功返回true
	 */
	boolean addType(ProductType productType);
	/**
	 * 删除一条Type记录
	 * @param typeId 该记录的id
	 * @return 成功返回true
	 */
	boolean deleteType(int typeId);
}
