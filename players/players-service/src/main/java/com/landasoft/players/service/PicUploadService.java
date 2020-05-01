package com.landasoft.players.service;

import org.springframework.web.multipart.MultipartFile;

import com.landasoft.common.pojo.LayuiUploadResult;

/**
 * 文件上传Service接口
 * @author zhaoyuan
 * @date 2020,Feb 13 8:08 pm
 */
public interface PicUploadService {

	/**
	 * 上传图片，保存到本地
	 * @param uploadFile
	 * @return
	 */
	public LayuiUploadResult picUpload(MultipartFile uploadFile);
}
