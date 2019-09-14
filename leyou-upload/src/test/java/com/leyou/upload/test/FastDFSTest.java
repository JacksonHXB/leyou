package com.leyou.upload.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

/**
 * @Author JacksonDemo
 * @Time 2019年8月11日 下午5:26:12
 * @Description: FastDFS分布式文件系统测试用例
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FastDFSTest {
	
//	@Autowired
//	private FastFileStorageClient storageClient;     //存储服务器客户端
//	
//	@Autowired
//	private ThumbImageConfig thumbImageConfig;    //缩略图配置对象
//	
//	/**
//	 * @throws FileNotFoundException
//	 * @Description 图片上传测试用例
//	 */
//	@Test
//	public void testUpload() throws FileNotFoundException{
//		//申明上传的文件
//		File file = new File("C:\\Users\\joedy\\Pictures\\xbx1.jpg");
//		//上传并保存图片，参数：1-上传的文件流 2-文件的大小 3-文件的后缀 4-可以不管他
//		StorePath storePath = storageClient.uploadFile(new FileInputStream(file), file.length(), "jpg", null);
//		//带分组的路径
//		System.out.println("分组路径：" + storePath.getFullPath());
//		//不带分组的路径
//		System.out.println("不带分组的路径：" + storePath.getPath());
//	}
//	
//	
//	/**
//	 * @throws FileNotFoundException
//	 * @Description 图片上传并生成缩略图测试用例
//	 */
//	@Test
//	public void testUploadAndCreateThumb() throws FileNotFoundException{
//		File file = new File("C:\\Users\\joedy\\Pictures\\xbx1.jpg");
//		//上传并生成缩略图
//		StorePath storePath = storageClient.uploadImageAndCrtThumbImage(new FileInputStream(file), file.length(), "png", null);
//		//带分组的路径
//		System.out.println("分组路径：" + storePath.getFullPath());
//		//不带分组的路径
//		System.out.println("不带分组的路径：" + storePath.getPath());
//		//获取缩略图路径
//		String path = thumbImageConfig.getThumbImagePath(storePath.getPath());
//		System.out.println("缩略图路径：" + path);
//	}
}










































