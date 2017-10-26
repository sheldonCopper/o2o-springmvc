/**   
 * @Title: HttpServletRequestUtil.java 
 * @Package com.imooc.o2o.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年10月1日 下午3:45:52 
 * @version V1.0    
 */
package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**   
 * @ClassName HttpServletRequestUtil   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年10月1日 下午3:45:52 
 * 
 */
public class HttpServletRequestUtil {
	
	public static int getInt(HttpServletRequest request, String key){
		
		try {
			return Integer.decode(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
		
	}

	public static long getLong(HttpServletRequest request, String key){
		
		try {
			return Long.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1;
		}
		
	}
	
	public static Double getDouble(HttpServletRequest request, String key){
		
		try {
			return Double.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return -1d;
		}
		
	}
	
	public static boolean getBoolean(HttpServletRequest request, String key){
		
		try {
			return Boolean.valueOf(request.getParameter(key));
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static String getString(HttpServletRequest request, String key){
		try {
			String result = request.getParameter(key);
			if(result != null){
				result = result.trim();
			}
			if("".equals(result)){
				result = null;
			}
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
