/**   
 * @Title: LocalAuth.java 
 * @Package com.imooc.o2o.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月27日 下午1:05:16 
 * @version V1.0    
 */
package com.imooc.o2o.entity;

import java.util.Date;

/**   
 * @ClassName LocalAuth   
 * @Description: TODO (本地账号) 
 * @author Xiu.Lu 
 * @date 2017年9月27日 下午1:05:16 
 * 
 */
public class LocalAuth {

	private Long localAuthId;
	
	private String username;
	
	private String password;
	
	private Date createTime;
	
	private Date lastEditTime;
	
	private PersonInfo personInfo;

	public Long getLocalAuthId() {
		return localAuthId;
	}

	public void setLocalAuthId(Long localAuthId) {
		this.localAuthId = localAuthId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
