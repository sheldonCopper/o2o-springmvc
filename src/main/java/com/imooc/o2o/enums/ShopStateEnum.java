/**   
 * @Title: ShopStateEnum.java 
 * @Package com.imooc.o2o.enums 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午9:56:31 
 * @version V1.0    
 */
package com.imooc.o2o.enums;

/**   
 * @ClassName ShopStateEnum   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午9:56:31 
 * 
 */
public enum ShopStateEnum {

	CHECK(0,"审核中"),
	OFFLINE(-1,"非法店铺"),
	SUCCESS(1,"操作成功"),
	PASS(2,"通过验证"),
	INNER_ERROR(-1001,"内部系统错误"),
	NULL_SHOPID(-1002,"shopId为空"),
	NULL_SHOP(-1003,"shop信息为空");
	
	private int state;
	
	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	
	public static ShopStateEnum stateOf(int state){
		for (ShopStateEnum stateEnum : values()) {
			if(stateEnum.getState() == state){
				return stateEnum;
			}
		}
		return null;
		
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	
	
}
