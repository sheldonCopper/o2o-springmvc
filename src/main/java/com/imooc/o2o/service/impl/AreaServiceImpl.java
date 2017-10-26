/**   
 * @Title: AreaServiceImpl.java 
 * @Package com.imooc.o2o.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月28日 下午2:12:03 
 * @version V1.0    
 */
package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.dao.AreaDao;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

/**   
 * @ClassName AreaServiceImpl   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月28日 下午2:12:03 
 * 
 */
@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaDao areaDao;

	/**
	 * Title: getAreaList
	 * Description: 
	 * @return 
	 * @see com.imooc.o2o.service.AreaService#getAreaList() 
	 */

	@Override
	public List<Area> getAreaList() {
		// TODO Auto-generated method stub
		return areaDao.queryArea();
	}

}
