package com.deqsoft.jinxiaocun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.deqsoft.jinxiaocun.pojo.User;
import com.deqsoft.jinxiaocun.service.UserManageService;

@SessionAttributes({ "userAccount", "userName" })
@Controller
/**
 * 
 * @author lille
 */
public class UserController {

	@Autowired
	private UserManageService userManageService;

	@RequestMapping(value = { "/login", "/index" })
	public String getLoginPage(@RequestParam(value = "result", required = false) String result) {

		return "login";
	}

	@RequestMapping("/homepage")
	public String getHomePage() {
		return "homepage";
	}

	@RequestMapping("/updatePwd")
	public String getUpdatePwdPage() {
		return "updatePwd";
	}

	@ResponseBody
	@RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
	public Map<String, String> validateLogin(HttpServletRequest request, User user, Map<String, Object> sessionMap) {
		Map<String, String> map = new HashMap<String, String>(4);
		HttpSession httpSession= request.getSession();
		boolean loginResult = userManageService.login(user.getUserAccount(), user.getUserPassword());
		if (loginResult) {
			httpSession.setAttribute("userName", userManageService.getUserName(user.getUserAccount()));
			httpSession.setAttribute("userAccount", user.getUserAccount());
			map.put("jumptarget", "homepage.html");
		} else {
			map.put("jumptarget", "login?result=error");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/getusername", method = RequestMethod.POST)
	public Map<String, String> getUserName(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>(4);
		try {
			Object obj=request.getSession().getAttribute("userName");
			String temp = obj.toString();
			map.put("name", temp);
		} catch (NullPointerException e) {
			map.put("name", "未登录");
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/updatapassword", method = RequestMethod.POST)
	public Map<String, String> updatePassword(@RequestParam(value = "oldPassword", required = true) String oldPassword,
			@RequestParam(value = "newPassword", required = true) String newPassword, HttpServletRequest request) {
		Map<String, String> resultMap = new HashMap<String, String>(4);
		String userAccount = null;
		try {
			userAccount = request.getSession().getAttribute("userAccount").toString();
		} catch (NullPointerException e) {

		}
		if ("".equals(userAccount) || userAccount == null) {
			resultMap.put("result", "fail");
			resultMap.put("jump", "true");
			resultMap.put("jumptarget", "login?result=outtime");
			return resultMap;
		}
		String meaningLessString = " ";
		if (oldPassword == null || oldPassword.replaceAll(meaningLessString, "").length() == 0) {
			resultMap.put("result", "fail");
			resultMap.put("jump", "false");
			resultMap.put("alert", "旧密码不能为空");
			return resultMap;
		}
		if (newPassword == null || newPassword.replace(meaningLessString, "").length() == 0) {
			resultMap.put("result", "fail");
			resultMap.put("jump", "false");
			resultMap.put("alert", "新密码不能为空");
			return resultMap;
		}
		if (userManageService.updateUserPassword(userAccount, oldPassword, newPassword)) {
			resultMap.put("result", "success");
			resultMap.put("jump", "true");
			resultMap.put("jumptarget", "login?result=updatepassword");
			return resultMap;
		}
		resultMap.put("result", "fail");
		resultMap.put("jump", "false");
		resultMap.put("alert", "失败，未知的错误");
		return resultMap;
	}
}
