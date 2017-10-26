/**   
 * @Title: WechatAuth.java 
 * @Package com.imooc.o2o.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月27日 下午1:03:12 
 * @version V1.0    
 */
package com.imooc.o2o.entity;

import java.util.Date;

/**   
 * @ClassName WechatAuth   
 * @Description: TODO (微信账号) 
 * @author Xiu.Lu 
 * @date 2017年9月27日 下午1:03:12 
 * 
 */
public class WechatAuth {

	private Long wechatAuthId;
	
	private String openId;
	
	private Date createTime;
	
	private PersonInfo personInfo;

	public Long getWechatAuthId() {
		return wechatAuthId;
	}

	public void setWechatAuthId(Long wechatAuthId) {
		this.wechatAuthId = wechatAuthId;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
	
}
