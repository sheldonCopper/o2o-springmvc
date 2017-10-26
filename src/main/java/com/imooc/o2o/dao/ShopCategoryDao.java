/**   
 * @Title: ShopCategoryDao.java 
 * @Package com.imooc.o2o.dao 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年10月22日 下午10:32:50 
 * @version V1.0    
 */
package com.imooc.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.imooc.o2o.entity.ShopCategory;

/**   
 * @ClassName ShopCategoryDao   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年10月22日 下午10:32:50 
 * 
 */
public interface ShopCategoryDao {

	List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
