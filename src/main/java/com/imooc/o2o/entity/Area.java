/**   
 * @Title: Area.java 
 * @Package com.imooc.o2o.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月27日 下午12:29:24 
 * @version V1.0    
 */
package com.imooc.o2o.entity;

import java.util.Date;

/**   
 * @ClassName Area   
 * @Description: TODO (区域类) 
 * @author Xiu.Lu 
 * @date 2017年9月27日 下午12:29:24 
 * 关于int和Integer类型：基本数据类型默认会赋值为0，引用类型的为null
 */
public class Area {

	// ID
	private Integer areaId;
	// 名称
	private String areaName;
	// 权重
	private Integer priority;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date lastEditTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
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
	
}
