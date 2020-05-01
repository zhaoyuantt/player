package com.landasoft.players.service;

import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.players.mypojo.MediaInfoCustom;

/**
 * 视频管理接口
 * @author zhaoyuan
 * @date 2020,Feb 13 10:00 pm
 */
public interface MediaServive {

	/**
	 * 添加视频
	 * @param mediaInfo
	 * @return
	 */
	public MyResult saveMedia(MediaInfoCustom mediaInfo);
	
	/**
	 * 获取视频列表
	 * @param page   第几页
	 * @param limit   每页显示多少条数据
	 * @param mediaName   视频名称
	 * @param state   视频状态  0：正常  1：下架
	 * @return
	 */
	public LayuiTableResult getMediaList(Integer page, Integer limit,String mediaName,String state);
	
	/**
	 * 由视频Id删除视频
	 * @param mediaId
	 * @return
	 */
	public MyResult deleteMediaById(String mediaId);
	
	/**
	 * Get media object from mediaId
	 * @param mediaId
	 * @return
	 */
	public MediaInfoCustom getMediaByMediaId(String mediaId);
	
	/**
	 * Update media object from mediaId
	 * @param mediaId
	 * @param mediaInfo
	 * @return
	 */
	public MyResult updateMediaByMediaId(String mediaId,MediaInfoCustom mediaInfo);
	
	/**
	 * Up or down media
	 * @param type   1:down 2:up
	 * @param mediaId
	 * @return
	 */
	public MyResult updateMediaWithDownOrUp(int type,String mediaId);
}
