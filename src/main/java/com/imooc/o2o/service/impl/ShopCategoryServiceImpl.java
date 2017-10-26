/**   
 * @Title: ShopCategoryServiceImpl.java 
 * @Package com.imooc.o2o.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年10月22日 下午10:51:43 
 * @version V1.0    
 */
package com.imooc.o2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.o2o.dao.ShopCategoryDao;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.service.ShopCategoryService;

/**   
 * @ClassName ShopCategoryServiceImpl   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年10月22日 下午10:51:43 
 * 
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	/**
	 * Title: queryShopCategory
	 * Description: 
	 * @param shopCategoryCondition
	 * @return 
	 * @see com.imooc.o2o.service.ShopCategoryService#queryShopCategory(com.imooc.o2o.entity.ShopCategory) 
	 */
	@Autowired
	private ShopCategoryDao shopcaDao;

	@Override
	public List<ShopCategory> queryShopCategory(ShopCategory shopCategoryCondition) {
		// TODO Auto-generated method stub
		return shopcaDao.queryShopCategory(shopCategoryCondition);
	}

}
