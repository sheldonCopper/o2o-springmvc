/**   
 * @Title: ShopServiceImpl.java 
 * @Package com.imooc.o2o.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午10:09:56 
 * @version V1.0    
 */
package com.imooc.o2o.service.impl;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.o2o.dao.ShopDao;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopException;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.ImgUtil;
import com.imooc.o2o.util.PathUtil;

/**   
 * @ClassName ShopServiceImpl   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午10:09:56 
 * 
 */
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;

	/**
	 * Title: addShop
	 * Description: 
	 * @param shop
	 * @param shooImg
	 * @return 
	 * @see com.imooc.o2o.service.ShopService#addShop(com.imooc.o2o.entity.Shop, java.io.File) 
	 */

	@Override
	@Transactional
	public ShopExecution addShop(Shop shop, InputStream shopImgInputStream,String fileName) {

		//判断店铺是否空
		if(shop == null){
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}
		try {
			//添加店铺，赋值初始值
			shop.setEnableStatus(0);//审核中
			shop.setCreateTime(new Date());
			shop.setLastEditTime(new Date());
			int count = shopDao.insertShop(shop);
			if(count <= 0){
				throw new ShopException("店铺创建失败");
			}else{
				if(shopImgInputStream!=null){
					//存储图片
					try {
						addShopImg(shop,shopImgInputStream,fileName);
					} catch (Exception e) {
						throw new ShopException("addShopImg error:"+e.getMessage());
					}
					//更新店铺图片地址
					count = shopDao.updateShop(shop);
					if(count <= 0){
						throw new ShopException("更新图片地址失败哦");
					}
				}
			}
			
		} catch (Exception e) {
			throw new ShopException("addshop error:"+e.getMessage());
		}
		return new ShopExecution(ShopStateEnum.CHECK,shop);
	}

	/**
	 * @Title: addShopImg 
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param shop
	 * @param shopImg  void 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午10:23:49 
	 * @version V1.0 
	 */
	private void addShopImg(Shop shop, InputStream shopImgInputStream,String fileName) {
		// 获取shop图片目录的相对路径
		String dest = PathUtil.getShopImgPath(shop.getShopId());
		String shopImgAddr = ImgUtil.generateThumbnail(shopImgInputStream,fileName, dest);
		
		shop.setShopImg(shopImgAddr);
		
	}

	/**
	 * Title: queryByShopId
	 * Description: 
	 * @param shopId
	 * @return 
	 * @see com.imooc.o2o.service.ShopService#queryByShopId(long) 
	 */
	
	@Override
	public Shop queryByShopId(long shopId) {
		// TODO Auto-generated method stub
		return shopDao.queryByShopId(shopId);
	}

	/**
	 * Title: modifyShop
	 * Description: 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopException 
	 * @see com.imooc.o2o.service.ShopService#modifyShop(com.imooc.o2o.entity.Shop, java.io.InputStream, java.lang.String) 
	 */
	
	@Override
	public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopException {
		
		if(shop == null || shop.getShopId() == null){
			return new ShopExecution(ShopStateEnum.NULL_SHOP);
		}else{
			// 1，判断是否需要处理图片
			try{
			if(shopImgInputStream != null && fileName != null &&!"".equals(fileName)){
				Shop tempShop = shopDao.queryByShopId(shop.getShopId());
				if(tempShop.getShopImg()!=null){
					ImgUtil.deleteFileOrPath(tempShop.getShopImg());
				}
				addShop(shop, shopImgInputStream, fileName);
			}
			
			// 2，更新店铺信息
			shop.setLastEditTime(new Date());
			int effectNum = shopDao.updateShop(shop);
			if(effectNum <=0){
				return new ShopExecution(ShopStateEnum.INNER_ERROR);
			}else{
				shop = shopDao.queryByShopId(shop.getShopId());
				return new ShopExecution(ShopStateEnum.SUCCESS, shop);
			}}catch(Exception e){
				throw new ShopException(e.getMessage());
			}
		}
	}

}
