package com.deqsoft.jinxiaocun.dao;

import java.util.List;

import com.deqsoft.jinxiaocun.pojo.User;

/**
 * 
 * @author lille
 *
 */
public interface UserDao {
	/**
	 * 根据用户id查找一个用户的信息
	 * 
	 * @param id
	 * @return
	 */
	User queryById(int id);

	/**
	 * 根据用户名查找一个用户的信息
	 * 
	 * @param userAccount
	 * @return
	 */
	User queryByUserAccount(String userAccount);

	/**
	 * 更新一名用户的信息
	 * 
	 * @param user 新的用户信息
	 * @return 受影响的行数
	 */
	int updateUser(User user);

	/**
	 * 取出全部用户信息
	 * 
	 * @return
	 */
	List<User> queryAllUser();

}
