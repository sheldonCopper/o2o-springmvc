/**   
 * @Title: AreaDaoTest.java 
 * @Package com.imooc.o2o.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月27日 下午3:03:41 
 * @version V1.0    
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

/**   
 * @ClassName AreaDaoTest   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月27日 下午3:03:41 
 * 
 */
public class AreaDaoTest extends BaseTest{

	@Autowired
	private AreaDao areaDao;
	@Autowired
	HttpServletRequest request;
	
	@Test
	public void testQueryArea(){
		List<Area>  areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}
}
