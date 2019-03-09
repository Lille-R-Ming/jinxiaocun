package com.deqsoft.jinxiaocun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deqsoft.jinxiaocun.dao.UserDao;
import com.deqsoft.jinxiaocun.pojo.User;
import com.deqsoft.jinxiaocun.service.UserManageService;

@Service
/**
 * 
 * @author lille
 *
 */
public class UserManageServiceImpl implements UserManageService {
	@Autowired
	private UserDao userDao;

	@Override
	public boolean login(String userAccount, String userPassword) {
		// TODO Auto-generated method stub
		if (!new User(userAccount,userPassword).preCheck()) {
			return false;
		}
		User temp = userDao.queryByUserAccount(userAccount);
		if (temp == null) {
			return false;
		} else if ("".equals(temp.getUserPassword())) {
			return true;
		} else {
			return temp.getUserPassword().equals(userPassword);
		}
	}

	@Override
	public String getUserName(String userAccount) {
		if (!new User(userAccount,null).preCheck()) {
			return "未登录";
		}
		// TODO Auto-generated method stub
		User temp = userDao.queryByUserAccount(userAccount);
		return temp == null ? "未登录" : temp.getUserName();
	}

	@Override
	public boolean updateUserPassword(String userAccount, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if (!new User(userAccount,oldPassword).preCheck()) {
			return false;
		}
		User temp = userDao.queryByUserAccount(userAccount);
		if (temp == null) {
			return false;
		}
		if (oldPassword.equals(temp.getUserPassword())) {
			temp.setUserPassword(newPassword);
			return userDao.updateUser(temp) == 1;
		}
		return false;
	}
}
