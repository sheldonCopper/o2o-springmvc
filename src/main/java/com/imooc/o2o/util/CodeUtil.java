/**   
 * @Title: CodeUtil.java 
 * @Package com.imooc.o2o.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年10月23日 下午9:39:41 
 * @version V1.0    
 */
package com.imooc.o2o.util;

import javax.servlet.http.HttpServletRequest;

/**   
 * @ClassName CodeUtil   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年10月23日 下午9:39:41 
 * 
 */
public class CodeUtil {

	public static boolean checkVerifyCode(HttpServletRequest request){
		
		String verifyCodeExpected = (String)request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		
		if(verifyCodeActual == null || !verifyCodeActual.equals(verifyCodeExpected)){
			return false;
		}
		return true;
		
	}
}
