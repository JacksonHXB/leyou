package com.leyou.service;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午3:39:13
 * @Description: 文件上传服务
 */
@Service
public class UploadService {
	
	private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif", "image/jpeg", "image/png");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);
	
	@Autowired
	private FastFileStorageClient storageClient;     //分布式文件管理系统客户端

	public String uploadImage(MultipartFile file) {
		String originalFilename = file.getOriginalFilename(); //获取原始路径
		try {
			//校验文件类型
			String contentType = file.getContentType();
			if (!CONTENT_TYPES.contains(contentType)) { //判断后缀名是否正确
				LOGGER.info("文件类型不合法：{}", originalFilename); //通过占位符来进行填充
				return null;
			}
			//校验文件内容
			BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
			if (bufferedImage == null) {
				LOGGER.info("文件内容不合法：{}", originalFilename);
				return null;
			}
			//保存到本地服务器，并返回本地地址
//			file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\" + originalFilename));
//			return "http://image.leyou.com/" + originalFilename;
			
			//保存到分布式文件管理系统FastDFS
			String extName = StringUtils.substringAfterLast(originalFilename, ".");    //获取扩展名
			StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extName, null);
			return "http://image.leyou.com/" + storePath.getFullPath();
		} catch (Exception e) {
			LOGGER.info("服务器内部错误：", originalFilename);
			e.printStackTrace();
		}
		return null;
	}
}



















































































