/**   
 * @Title: ShopService.java 
 * @Package com.imooc.o2o.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午10:09:00 
 * @version V1.0    
 */
package com.imooc.o2o.service;

import java.io.InputStream;

import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.exceptions.ShopException;

/**   
 * @ClassName ShopService   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午10:09:00 
 * 
 */
public interface ShopService {

	/**
	 * 
	 * @Title: modifyShop 
	 * @Description: TODO(注册店铺信息)  
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopException  ShopExecution 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年10月23日 下午10:43:09 
	 * @version V1.0
	 */
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopException;
//	ShopExecution addShop(Shop shop, File shooImg);
	
	/**
	 * 
	 * @Title: queryByShopId 
	 * @Description: TODO(通过id获取店铺信息)  
	 * @param shopId
	 * @return  Shop 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年10月23日 下午10:43:31 
	 * @version V1.0
	 */
	Shop queryByShopId(long shopId);
	
	/**
	 * 
	 * @Title: modifyShop 
	 * @Description: TODO(更新店铺信息)  
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopException  ShopExecution 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年10月23日 下午10:43:09 
	 * @version V1.0
	 */
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream,String fileName) throws ShopException;
}
