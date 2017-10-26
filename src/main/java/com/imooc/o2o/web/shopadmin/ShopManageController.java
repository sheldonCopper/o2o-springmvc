/**   
 * @Title: ShopManageController.java 
 * @Package com.imooc.o2o.web.shopadmin 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年10月1日 下午3:42:27 
 * @version V1.0    
 */
package com.imooc.o2o.web.shopadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.o2o.dto.ShopExecution;
import com.imooc.o2o.entity.Area;
import com.imooc.o2o.entity.PersonInfo;
import com.imooc.o2o.entity.Shop;
import com.imooc.o2o.entity.ShopCategory;
import com.imooc.o2o.enums.ShopStateEnum;
import com.imooc.o2o.exceptions.ShopException;
import com.imooc.o2o.service.AreaService;
import com.imooc.o2o.service.ShopCategoryService;
import com.imooc.o2o.service.ShopService;
import com.imooc.o2o.util.CodeUtil;
import com.imooc.o2o.util.HttpServletRequestUtil;
import com.imooc.o2o.util.ImgUtil;
import com.imooc.o2o.util.PathUtil;

/**   
 * @ClassName ShopManageController   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年10月1日 下午3:42:27 
 * 
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManageController {
	
	@Autowired
	private ShopService shopService;
	@Autowired
	private ShopCategoryService shopCategoryService;
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(value="/getshopinitinfo",method=RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> getShopInitInfo(){
		Map<String, Object> modeMap = new HashMap<String, Object>();
		
		List<ShopCategory> list= new ArrayList<ShopCategory>();
		
		List<Area> areaList= new ArrayList<Area>();
		
		try {
			list = shopCategoryService.queryShopCategory(new ShopCategory());
			
			areaList = areaService.getAreaList();
			modeMap.put("success", true);
			modeMap.put("shopCategoryList", list);
			modeMap.put("areaList", areaList);
		} catch (Exception e) {
			// TODO: handle exception
			modeMap.put("success", false);
			modeMap.put("errMsg", e.getMessage());
		}
		return modeMap;
	}
	
	
	@RequestMapping(value="/registershop",method=RequestMethod.POST)
	@ResponseBody
	private Map<String,Object> registerShop(HttpServletRequest request){
		
		Map<String, Object> modeMap = new HashMap<String, Object>();
		
		if(!CodeUtil.checkVerifyCode(request)){
			modeMap.put("success", false);
			modeMap.put("errMsg", "输入了错误的验证码");
			return modeMap;
		}
		
		//1，接收并转化相应的参数，店铺信息以及图片信息
		String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
		ObjectMapper mapper = new ObjectMapper();
		Shop shop = null;
		try {
			shop = mapper.readValue(shopStr, Shop.class);
		} catch (Exception e) {
			// TODO: handle exception
			modeMap.put("success", false);
			modeMap.put("errMsg", e.getMessage());
			return modeMap;
		}
		CommonsMultipartFile shopImg = null;
		CommonsMultipartResolver comMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(comMultipartResolver.isMultipart(request)){
			MultipartHttpServletRequest muHttpServletRequest = (MultipartHttpServletRequest)request;
			shopImg = (CommonsMultipartFile)muHttpServletRequest.getFile("shopImg");
 		}else{
 			modeMap.put("success", false);
			modeMap.put("errMsg", "上传图片不能为空");
			return modeMap;
 		}
		//2，注册店铺
		if(shop != null && shopImg != null){
			PersonInfo owner = new PersonInfo();
			owner.setUserId(1L);
			shop.setOwner(owner);
//			File shopImgFile = new File(PathUtil.getImgBasePath()+ImgUtil.getRandomFileName());
//			try {
//				shopImgFile.createNewFile();
//			} catch (Exception e) {
//				// TODO: handle exception
//				modeMap.put("success", false);
//				modeMap.put("errMsg", e.getMessage());
//				return modeMap;
//			}
//			try {
//				inputStreamToFile(shopImg.getInputStream(),shopImgFile);
//			} catch (IOException e) {
//				modeMap.put("success", false);
//				modeMap.put("errMsg", e.getMessage());
//				return modeMap;
//			}
			ShopExecution se;
			try {
				se = shopService.addShop(shop,shopImg.getInputStream(),shopImg.getOriginalFilename());
				if(se.getState() == ShopStateEnum.CHECK.getState()){
					modeMap.put("success", true);
				}else{
					modeMap.put("success", false);
					modeMap.put("errMsg", se.getStateInfo());
				}
			} catch (ShopException e) {
				modeMap.put("success", false);
				modeMap.put("errMsg", e.getMessage());
			} catch (IOException e) {
				modeMap.put("success", false);
				modeMap.put("errMsg", e.getMessage());
			}
			return modeMap;
		}else{
			modeMap.put("success", false);
			modeMap.put("errMsg", "请输入店铺信息");
			return modeMap;
		}
		//3，返回结果
	}
	
//	private static  void inputStreamToFile(InputStream ins, File file){
//		FileOutputStream os = null;
//		try {
//			os = new FileOutputStream(file);
//			int bytesRead = 0;
//			byte[] buffer = new byte[1024];
//			while ((bytesRead = ins.read(buffer)) !=-1) {
//				os.write(buffer, 0, bytesRead);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			throw new RuntimeException("调用inputStreamToFile产生异常："+e.getMessage());
//		}finally {
//			try {
//				if(os!=null){
//					os.close();
//				}
//				if(ins!=null){
//					ins.close();
//				}
//			} catch (IOException e) {
//				// TODO: handle exception
//				throw new RuntimeException("调用inputStreamToFile关闭IO产生异常："+e.getMessage());
//			}
//		}
//		
//	}
}
