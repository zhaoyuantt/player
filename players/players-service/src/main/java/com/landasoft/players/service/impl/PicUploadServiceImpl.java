package com.landasoft.players.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.landasoft.common.pojo.LayuiUploadResult;
import com.landasoft.players.service.PicUploadService;

/**
 * 文件上传Service接口实现
 * @author zhaoyuan
 * @date 2020,Feb 13 8:16 pm
 */
@Service
public class PicUploadServiceImpl implements PicUploadService{

	@Value("${IMAGE_STORAGE_DIR}")
	private String IMAGE_STORAGE_DIR;
	
	@Override
	public LayuiUploadResult picUpload(MultipartFile uploadFile) {
		
		String filename = uploadFile.getOriginalFilename();
		
		File file = new File(IMAGE_STORAGE_DIR);
		
		if(!file.exists()) {
			file.mkdir();
		}
		
		InputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		LayuiUploadResult layuiUploadResult = new LayuiUploadResult();
		
		try {
			outputStream = new FileOutputStream(file.getPath()+"\\"+filename);
			
			inputStream = uploadFile.getInputStream();
			
			int b = 0;
			
			while((b=inputStream.read())!=-1){ //读取文件 
				outputStream.write(b);
            }
			
			outputStream.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			layuiUploadResult.setCode(0);
			layuiUploadResult.setMsg("FileNotFoundException");
			return layuiUploadResult;
		} catch (IOException e) {
			e.printStackTrace();
			layuiUploadResult.setCode(0);
			layuiUploadResult.setMsg("IOException");
			return layuiUploadResult;
		} finally {
			if(null != inputStream) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != outputStream) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		layuiUploadResult.setCode(0);
		layuiUploadResult.setMsg("ok");
		
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("src", file.getPath()+"\\"+filename);
		
		layuiUploadResult.setData(map);
		
		return layuiUploadResult;
	}

}
