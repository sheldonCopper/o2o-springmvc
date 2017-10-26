/**   
 * @Title: AreaController.java 
 * @Package com.imooc.o2o.web.superadmin 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月28日 下午2:23:39 
 * @version V1.0    
 */
package com.imooc.o2o.web.superadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.o2o.entity.Area;
import com.imooc.o2o.service.AreaService;

/**
 * @ClassName AreaController
 * @Description: TODO (这里用一句话描述这个类的作用)
 * @author Xiu.Lu
 * @date 2017年9月28日 下午2:23:39
 * 
 */
@Controller
@RequestMapping("/superadmin")
public class AreaController {
	
	Logger logger = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;

	@RequestMapping(value="/listarea", method = RequestMethod.GET)
	@ResponseBody
	private Map<String, Object> listArea() {
		logger.info("==========start============");
		long startTime = System.currentTimeMillis();
		Map<String, Object> modeMap = new HashMap<String, Object>();

		List<Area> areaList = new ArrayList<Area>();

		try {
			areaList = areaService.getAreaList();
			modeMap.put("rows", areaList);
			modeMap.put("total", areaList.size());
		} catch (Exception e) {
			// TODO: handle exception
			modeMap.put("success", false);
			modeMap.put("errMsg", e.toString());
		}
		logger.error("==========test error==========");
		long endTime = System.currentTimeMillis();
		logger.debug("花费时间：[{}ms]",endTime - startTime);
		logger.info("==========end============");
		return modeMap;
	}
}
