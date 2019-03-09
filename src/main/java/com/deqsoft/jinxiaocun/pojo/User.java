package com.deqsoft.jinxiaocun.pojo;


/**
 * 
 * @author lille
 *
 */
public class User {
	private Integer userId;
	/**
	 * 用户姓名/昵称
	 */
	private String userName;
	private Integer userSex;
	/**
	 * 用户登录名
	 */
	private String userAccount;
	private String userTel;
	private String userPlace;
	private String userEmail;
	private String userText;
	private String userPassword;
	
	public User() {}
	public User(String userAccount,String userPassword) {
		this.userAccount=userAccount;
		this.userPassword=userPassword;
	}
	public User(Integer userId, String userName, Integer userSex, String userAccount, String userTel, String userPlace,
			String userEmail, String userText, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userAccount = userAccount;
		this.userTel = userTel;
		this.userPlace = userPlace;
		this.userEmail = userEmail;
		this.userText = userText;
		this.userPassword = userPassword;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserPlace() {
		return userPlace;
	}

	public void setUserPlace(String userPlace) {
		this.userPlace = userPlace;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserText() {
		return userText;
	}

	public void setUserText(String userText) {
		this.userText = userText;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("id:").append(userId).append('\n');
		stringBuilder.append("Name:").append("".equals(userName) ? "null" : userName).append('\n');
		stringBuilder.append("Sex:").append(userSex).append('\n');
		stringBuilder.append("Account:").append(userAccount).append('\n');
		stringBuilder.append("Tel:").append("".equals(userTel) ? "null" : userTel).append('\n');
		stringBuilder.append("Place:").append("".equals(userPlace) ? "null" : userPlace).append('\n');
		stringBuilder.append("Email:").append("".equals(userEmail) ? "null" : userEmail).append('\n');
		stringBuilder.append("Text:").append("".equals(userText) ? "null" : userText).append('\n');
		stringBuilder.append("Password:").append("".equals(userPassword) ? "null" : userPassword).append('\n');
		return stringBuilder.toString();
	}

	/**
	 * 字段userAccount(用户登录名)的长度限制
	 */
	private final static Integer LONGEST_USER_ACCOUNT = 15;
	/**
	 * 字段userName(用户姓名)的长度限制
	 */
	private final static Integer LONGEST_USER_NAME = 10;
	/**
	 * 字段userText(用户备注)的长度限制
	 */
	private final static Integer LONGEST_USER_TEXT = 250;
	/**
	 * 字段userPassword(用户登录密码)的长度限制
	 */
	private final static Integer LONGEST_USER_PASSWORD = 50;

	/**
	 * 用户登陆/注册时的预校验，检查登录名是否符合格式，如果不符的话就不需要操作数据库了
	 * 
	 * @return
	 */
	public boolean preCheck() {
		if (this.userAccount == null || this.userAccount.length() > LONGEST_USER_ACCOUNT) {
			return false;
		}
		return true;
	}

	/**
	 * 修改用户信息、添加用户时使用的校验，检查数据格式是否规范
	 * 
	 * @return
	 */
	public boolean isValidity() {
		if(!this.preCheck()) {
			return false;
		}
		if(this.userName!=null&&this.userName.length()>LONGEST_USER_NAME) {
			return false;
		}
		if(this.userPassword!=null&&userPassword.length()>LONGEST_USER_PASSWORD) {
			return false;
		}
		if(this.userText!=null&&this.userText.length()>LONGEST_USER_TEXT) {
			return false;
		}
		return false;
	}
}
