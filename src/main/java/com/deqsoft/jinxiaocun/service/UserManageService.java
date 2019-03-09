package com.deqsoft.jinxiaocun.service;

/**
 * 
 * @author lille
 *
 */
public interface UserManageService {
	/**
	 * 用户登录
	 * 
	 * @param                     userAccount用户提供的登录名/账号
	 * @param userPassword用户提供的密码
	 * @return 成功返回true
	 */
	boolean login(String userAccount, String userPassword);

	/**
	 * 获取用户姓名/昵称
	 * 
	 * @param userAccount 用户的账号
	 * @return
	 */
	String getUserName(String userAccount);

	/**
	 * 用户修改密码
	 * @param userAccount 用户提供的账号
	 * @param oldPassword 用户提供的旧密码
	 * @param newPassword 用户要修改的新密码
	 * @return 成功返回true
	 */
	boolean updateUserPassword(String userAccount, String oldPassword, String newPassword);
}
