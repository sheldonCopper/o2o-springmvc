/**   
 * @Title: ImgUtil.java 
 * @Package com.imooc.o2o.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author Xiu.Lu
 * @date 2017年9月30日 下午2:33:30 
 * @version V1.0    
 */
package com.imooc.o2o.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**   
 * @ClassName ImgUtil   
 * @Description: TODO (处理图片工具类) 
 * @author Xiu.Lu 
 * @date 2017年9月30日 下午2:33:30 
 * 
 */
public class ImgUtil {
	
	private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	private static final Random r = new Random();
	
	private static Logger logger = LoggerFactory.getLogger(ImgUtil.class);
	
	public static File transferCommonsMultiPartFileToFile(CommonsMultipartFile cFile){
		
		File newFile = new File(cFile.getOriginalFilename());
		
		try {
			cFile.transferTo(newFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return newFile;
		
	}
	
	/**
	 * 
	 * @Title: generateThumbnail 
	 * @Description: TODO(处理缩略图，并返回新生成图片的相对路径)  
	 * @param thumbnail
	 * @param targetAddr
	 * @return  String 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午3:20:40 
	 * @version V1.0
	 */
	public static String generateThumbnail(InputStream thumbnailInputStream,String fileName, String targetAddr){
		
		String realFileName = getRandomFileName();
		
		String extension = getFileExtension(fileName);
		
		makeDirPath(targetAddr);
		
		String relativeAddr = targetAddr + realFileName + extension;
		
		File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
		logger.debug("全路径："+ PathUtil.getImgBasePath() + relativeAddr);
		try {
			Thumbnails.of(thumbnailInputStream).size(200, 200)
			.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/water.jpg")), 0.25f)
			.outputQuality(0.8f)
			.toFile(dest);
		} catch (IOException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		
		return relativeAddr;
	}

	/**
	 * @Title: makeDirPath 
	 * @Description: TODO(创建目标路径所涉及的目录)  
	 * @param targetAddr  void 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午3:04:36 
	 * @version V1.0 
	 */
	private static void makeDirPath(String targetAddr) {
		
		String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
		
		File dirPath = new File(realFileParentPath);
		
		if(!dirPath.exists()){
			dirPath.mkdirs();
		}
	}

	/**
	 * @Title: getFileExtension 
	 * @Description: TODO(获取输入文件流的扩展名，jpg或者png等)  
	 * @param thumbnail
	 * @return  String 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午3:04:34 
	 * @version V1.0 
	 */
	private static String getFileExtension(String fileName) {
		
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * @Title: getRandomFileName 
	 * @Description: TODO(生成随机文件名，当前年月日小时分钟秒钟+五位随机数)  
	 * @return  String 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年9月30日 下午3:04:32 
	 * @version V1.0 
	 */
	public static String getRandomFileName() {
		// TODO 获取随机五位数
		int rannum = r.nextInt(89999) + 10000;
		String nowTimeStr = sdf.format(new Date());
		return nowTimeStr + rannum;
	}

	public static void main(String[] args) {
		System.out.println(basePath);
		System.out.println(getRandomFileName());
//		try {
//			Thumbnails.of(new File("C:/Users/sheldon/Pictures/Feedback/image01.jpg"))
//			.size(200, 200).watermark(Positions.BOTTOM_RIGHT, 
//					ImageIO.read(new File(basePath+"/water.jpg")), 0.25f).outputQuality(0.8f)
//			.toFile("C:/Users/sheldon/Pictures/Feedback/image02.jpg");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	/**
	 * 
	 * @Title: deleteFileOrPath 
	 * @Description: TODO(
			storePath是 文件的路径还是目录的路径，
			如果storePath是文件路径则删除该文件，
			如果storePath是目录路径则删除该目录下的所有文件
		)    void 返回类型 
	 * @author Xiu.Lu
	 * @throws
	 * @date 2017年10月23日 下午10:46:32 
	 * @version V1.0
	 */
	public static void deleteFileOrPath(String storePath){
		File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
		if(fileOrPath.exists()){
			if(fileOrPath.isDirectory()){
				File files[] = fileOrPath.listFiles();
				for (int i = 0; i < files.length; i++) {
					files[i].delete();
				}
			}
			fileOrPath.delete();
		}
	}
}
