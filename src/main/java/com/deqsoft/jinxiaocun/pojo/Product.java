package com.deqsoft.jinxiaocun.pojo;

/**
 * 
 * @author lille
 *
 */
public class Product {
	private Integer productId;
	private Integer productTypeId;
	private String productName;
	/**
	 * 该产品的库存，即余量
	 */
	private Integer productInventory;
	private String productText;

	public Product() {
	}

	public Product(String productName) {
		super();
		this.productName = productName;
	}

	public Product(Integer productTypeId, String productName, Integer productInventory, String productText) {
		super();
		this.productTypeId = productTypeId;
		this.productName = productName;
		this.productInventory = productInventory;
		this.productText = productText;
	}

	public Product(Integer productId, Integer productTypeId, String productName, Integer productInventory,
			String productText) {
		super();
		this.productId = productId;
		this.productTypeId = productTypeId;
		this.productName = productName;
		this.productInventory = productInventory;
		this.productText = productText;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("id:").append(productId).append('\n');
		stringBuilder.append("typeId:").append(productTypeId).append('\n');
		stringBuilder.append("Name:").append(productName).append('\n');
		stringBuilder.append("Inventory:").append(productInventory).append('\n');
		stringBuilder.append("Text:").append(productText).append('\n');
		return stringBuilder.toString();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductInventory() {
		return productInventory;
	}

	public void setProductInventory(int productInventory) {
		this.productInventory = productInventory;
	}

	public String getProductText() {
		return productText;
	}

	public void setProductText(String productText) {
		this.productText = productText;
	}

	/**
	 * 字段productName的长度限制
	 */
	private final static Integer LONGEST_PRODUCT_NAME = 10;
	/**
	 * 字段productText的长度限制
	 */
	private final static Integer LONGEST_PRODUCT_TEXT = 250;
	/**
	 * 产品名的长度不应短于某个值，为零表示该字段可为空
	 */
	private final static Integer SHORTEST_PRODUCT_NAME = 1;
	/**
	 * 产品介绍的长度不应短于某个值,为零表示该字段可为空
	 */
	private final static Integer SHORTEST_PRODUCT_TEXT = 0;
	/**
	 * 产品余量不应超过某个值
	 */
	private final static Integer MAX_PRODUCT_INVENTORY = 1000000000;

	/**
	 * 判断一条Product记录是否合法有意义，非法返回false
	 * 
	 * @return
	 */

	public boolean isValidity() {
		//判断产品名的合法性
		if (SHORTEST_PRODUCT_NAME > 0 && this.productName == null) {
			return false;
		} else if (this.productName != null && this.productName.length() > LONGEST_PRODUCT_NAME) {
			return false;
		} else if(this.productName!=null&&this.productName.length()<SHORTEST_PRODUCT_NAME){
			return false;
		}
		//判断产品备注的合法性
		if (SHORTEST_PRODUCT_TEXT > 0 && this.productText == null) {
			return false;
		} else if (this.productText != null && this.productText.length() < SHORTEST_PRODUCT_TEXT) {
			return false;
		} else if(this.productText !=null && this.productText.length()>LONGEST_PRODUCT_TEXT){
			return false;
		}
		//判断产品库存的合法性
		if (this.productInventory != null && this.productInventory > MAX_PRODUCT_INVENTORY) {
			return false;
		}
		return true;
	}
}
