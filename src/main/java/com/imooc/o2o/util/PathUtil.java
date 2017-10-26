/**   
 * @Title: PathUtil.java 
 * @Package com.imooc.o2o.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午2:49:16 
 * @version V1.0    
 */
package com.imooc.o2o.util;

/**   
 * @ClassName PathUtil   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午2:49:16 
 * 
 */
public class PathUtil {

	private static String seperator = System.getProperty("file.separator");
	
	public static String getImgBasePath(){
		
		String os = System.getProperty("os.name");
		
		String basePasth = "";
		
		if(os.toLowerCase().startsWith("win")){
			basePasth = "D:/Img/";
		}else{
			basePasth = "/home/xiangce/image";
		}
		basePasth = basePasth.replace("/", seperator);
		
		return basePasth;
	}
	
	public static String getShopImgPath(long shopId){
		String imgPath = "upload/item/shop/" + shopId + "/";
		return imgPath.replace("/", seperator);
		
	}
	
	public static void main(String[] args) {
		System.out.println(seperator);
	}
}
