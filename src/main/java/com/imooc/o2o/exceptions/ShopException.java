/**   
 * @Title: ShopException.java 
 * @Package com.imooc.o2o.exceptions 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午10:30:14 
 * @version V1.0    
 */
package com.imooc.o2o.exceptions;

/**   
 * @ClassName ShopException   
 * @Description: TODO (这里用一句话描述这个类的作用) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午10:30:14 
 * 
 */
public class ShopException extends RuntimeException {

	/** 
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	 * @author Xiu.Lu
	 */ 
	private static final long serialVersionUID = -5411237145751527742L;

	public ShopException(String message) {
		super(message);
	}

	
}
