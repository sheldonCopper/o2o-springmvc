/**   
 * @Title: BaseTest.java 
 * @Package com.imooc.o2o 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月27日 下午3:04:13 
 * @version V1.0    
 */
package com.imooc.o2o;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**   
 * @ClassName BaseTest   
 * @Description: TODO (初始化spring和junit整合，加载springIOC容器的配置) 
 * @author Xiu.Lu 
 * @date 2017年9月27日 下午3:04:13 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class BaseTest {

}
