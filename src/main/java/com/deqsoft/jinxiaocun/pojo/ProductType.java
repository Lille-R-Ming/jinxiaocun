package com.deqsoft.jinxiaocun.pojo;

/**
 * 
 * @author lille
 *
 */
public class ProductType {
	private String typeName;
	private Integer typeId;
	/**
	 * 类型描述
	 */
	private String typeDescribe = "";
	/**
	 * 类型备注
	 */
	private String typeText = "";

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("id:").append(typeId).append('\n');
		stringBuilder.append("Name:").append(typeName).append('\n');
		stringBuilder.append("Describe:").append(typeDescribe).append('\n');
		stringBuilder.append("typeText:").append(typeText).append('\n');
		return stringBuilder.toString();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeDescribe() {
		return typeDescribe;
	}

	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe;
	}

	public String getTypeText() {
		return typeText;
	}

	public void setTypeText(String typeText) {
		this.typeText = typeText;
	}

	/**
	 * 字段typeName(类型名)的长度限制
	 */
	public static final Integer LONGEST_TYPE_NAME = 10;
	/**
	 * 字段typeText(类型备注)的长度限制
	 */
	public static final Integer LONGEST_TYPE_TEXT = 250;
	/**
	 * 字段typeDescribe(类型描述)的长度限制
	 */
	public static final Integer LONGEST_TYPE_DESCRIBE = 250;
	/**
	 * 类型名的长度不短于某个值，为零时该字段可为空
	 */
	private static final Integer SHORTEST_TYPE_NAME = 1;
	/**
	 * 判断当前对象的合理性，各属性的字段长度是否超过阀值
	 * @return 合理返回true，否则返回false
	 */
	public boolean isValidity() {
		if (this.typeName == null && SHORTEST_TYPE_NAME > 0) {
			return false;
		} else if (this.typeName != null && this.typeName.length() > LONGEST_TYPE_NAME) {
			return false;
		} else if (this.typeName != null && this.typeName.length() < SHORTEST_TYPE_NAME) {
			return false;
		}
		if (this.typeText == null) {
			return false;
		}
		if (this.typeName.length() > LONGEST_TYPE_TEXT) {
			return false;
		}
		if (this.typeDescribe != null && this.typeDescribe.length() > LONGEST_TYPE_DESCRIBE) {
			return false;
		}
		return true;
	}
}
