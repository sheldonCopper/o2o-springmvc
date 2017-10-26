/**   
 * @Title: ShopCategoryDaoTest.java 
 * @Package com.imooc.o2o.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年10月22日 下午10:42:54 
 * @version V1.0    
 */
package com.imooc.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.o2o.BaseTest;
import com.imooc.o2o.entity.ShopCategory;

/**   
 * @ClassName ShopCategoryDaoTest   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年10月22日 下午10:42:54 
 * 
 */
public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;
	
	@Test
	public void testQueryShopCategory(){
		List<ShopCategory> queryShopCategory = shopCategoryDao.queryShopCategory(new ShopCategory());
		assertEquals(2, queryShopCategory.size());
		
		ShopCategory s = new ShopCategory();
		ShopCategory s2 = new ShopCategory();
		
		s2.setShopCategoryId(1L); 
		s.setParent(s2);
		queryShopCategory = shopCategoryDao.queryShopCategory(s);
		assertEquals(1, queryShopCategory.size());
		System.out.println(queryShopCategory.get(0).getShopCategoryName());
	}
}
