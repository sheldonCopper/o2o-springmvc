/**   
 * @Title: AreaDao.java 
 * @Package com.imooc.o2o.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月27日 下午2:54:26 
 * @version V1.0    
 */
package com.imooc.o2o.dao;

import java.util.List;

import com.imooc.o2o.entity.Area;

/**   
 * @ClassName AreaDao   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月27日 下午2:54:26 
 * 
 */
public interface AreaDao {

	/**
	 * 
	 * @Title: queryArea 
	 * @Description: TODO(列出区域列表)  
	 * @return  List<Area> 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月27日 下午2:55:09 
	 * @version V1.0
	 */
	List<Area> queryArea();
}
