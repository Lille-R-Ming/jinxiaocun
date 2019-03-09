package com.deqsoft.jinxiaocun.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deqsoft.jinxiaocun.pojo.ProductType;
import com.deqsoft.jinxiaocun.service.TypeManageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
/**
 * 
 * @author lille
 *
 */
public class TypeController {
	@Autowired
	private TypeManageService typeManageService;

	@RequestMapping(value = "/type")
	public String getTypePage() {
		return "type";
	}

	/**
	 * 该方法用于分页请求ProductType的内容，请求方式为get，返回类型为包装成PageInfo的对象。<br>
	 * page指第几页，特殊地，当page的值为-1，即FLAG_GET_ALL_TYPE时，表示不分页，而是请求所有的内容
	 * 
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/typelist", method = RequestMethod.GET)
	public PageInfo<ProductType> getTypeList(@RequestParam(value = "page", defaultValue = "1") String page) {
		if (FLAG_GET_ALL_TYPE.equals(page)) {
			PageHelper.startPage(1, 0);
		} else {
			try {
				PageHelper.startPage(Integer.valueOf(page), 10);
			} catch (NumberFormatException e) {
				PageHelper.startPage(1, 10);
			}
		}
		
		return typeManageService.getTypeList();
	}

	@ResponseBody
	@RequestMapping(value = "/addtype")
	public Map<String, Object> addType(ProductType productType) {
		boolean result = typeManageService.addType(productType);
		Map<String, Object> map = new HashMap<String, Object>(1);
		map.put("result", Boolean.toString(result));
		return map;
	}
	@ResponseBody
	@RequestMapping(value = "/deletetype")
	public Map<String, Object> deleteType(@RequestParam(value = "typeId") int typeId) {
		Map<String, Object> map = new HashMap<String, Object>(1);
		if (typeManageService.deleteType(typeId)) {
			map.put("result", "success");
		}
		return map;
	}
	/**
	 * 标识该url请求试图获取所有的type，而不是分页请求
	 */
	private final static String FLAG_GET_ALL_TYPE = "-1";
}
