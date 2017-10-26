/**   
 * @Title: AreaServiceTest.java 
 * @Package com.imooc.o2o.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月28日 下午2:16:54 
 * @version V1.0    
 */
package com.imooc.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.Area;

/**   
 * @ClassName AreaServiceTest   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月28日 下午2:16:54 
 * 
 */
public class AreaServiceTest extends BaseTest{

	@Autowired
	private AreaService areaService;
	
	@Test
	public void testQueryArea(){
		List<Area>  areaList = areaService.getAreaList();
		assertEquals("西苑", areaList.get(0).getAreaName());
	}
}
