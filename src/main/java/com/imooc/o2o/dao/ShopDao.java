/**   
 * @Title: ShopDao.java 
 * @Package com.imooc.o2o.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午2:03:37 
 * @version V1.0    
 */
package com.imooc.o2o.dao;

import com.imooc.o2o.entity.Shop;

/**   
 * @ClassName ShopDao   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午2:03:37 
 * 
 */
public interface ShopDao {

	/**
	 * 
	 * @Title: insertShop 
	 * @Description: TODO(新增店铺)  
	 * @param shop
	 * @return  int 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午2:04:12 
	 * @version V1.0
	 */
	int insertShop(Shop shop);
	
	/**
	 * 
	 * @Title: updateShop 
	 * @Description: TODO(更新商铺)  
	 * @param shop
	 * @return  int 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午2:24:29 
	 * @version V1.0
	 */
	int updateShop(Shop shop);
	
	/**
	 * 
	 * @Title: queryByShopId 
	 * @Description: TODO(通过id查询店铺)  
	 * @param shopId
	 * @return  Shop 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年10月23日 下午10:21:49 
	 * @version V1.0
	 */
	Shop queryByShopId(long shopId);
}
