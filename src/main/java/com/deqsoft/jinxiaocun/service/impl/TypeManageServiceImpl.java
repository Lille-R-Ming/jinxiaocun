package com.deqsoft.jinxiaocun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqsoft.jinxiaocun.dao.TypeDao;
import com.deqsoft.jinxiaocun.pojo.ProductType;
import com.deqsoft.jinxiaocun.service.TypeManageService;
import com.github.pagehelper.PageInfo;

@Service
/**
 * 
 * @author lille
 *
 */
public class TypeManageServiceImpl implements TypeManageService {
	@Autowired
	private TypeDao typeDao;

	@Override
	public PageInfo<ProductType> getTypeList() {
		// TODO Auto-generated method stub
		return new PageInfo<ProductType>(typeDao.queryAllType());
	}

	@Override
	public boolean addType(ProductType productType) {
		// TODO Auto-generated method stub

		if (productType == null) {
			return false;
		}
		String meaningLessString = " ";
		if (productType.getTypeName().replaceAll(meaningLessString, "").length() == 0) {
			return false;
		}
		if (!productType.isValidity()) {
			return false;
		}
		return typeDao.addNewType(productType) > 0;
	}

	@Override
	public boolean deleteType(int typeId) {
		return typeDao.deleteType(typeId) > 0;
	}
}
