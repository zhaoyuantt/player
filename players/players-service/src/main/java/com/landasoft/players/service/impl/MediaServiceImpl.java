package com.landasoft.players.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.common.utils.IDUtils;
import com.landasoft.players.mapper.TMediaInfoMapper;
import com.landasoft.players.mapper.TMediaVisitNumMapper;
import com.landasoft.players.mypojo.MediaInfoCustom;
import com.landasoft.players.pojo.TMediaInfo;
import com.landasoft.players.pojo.TMediaInfoExample;
import com.landasoft.players.pojo.TMediaVisitNum;
import com.landasoft.players.pojo.TMediaVisitNumExample;
import com.landasoft.players.pojo.TMediaVisitNumExample.Criteria;
import com.landasoft.players.service.MediaServive;

/**
 * 视频管理接口实现
 * @author zhaoyuan
 * @date 2020,Feb 13 10:07 pm
 */
@Service
public class MediaServiceImpl implements MediaServive {
	
	private static final Logger log = Logger.getLogger(MediaServiceImpl.class);

	@Autowired
	private TMediaInfoMapper mediaInfoMapper;
	@Autowired
	private TMediaVisitNumMapper mediaVisitNumMapper;
	
	@Override
	public MyResult saveMedia(MediaInfoCustom mediaInfo) {
		
		long id = IDUtils.genItemId();
		
		//oper mediainfo
		mediaInfo.setId(id);
		mediaInfo.setState((byte) 0);
		mediaInfo.setUpdated(new Date());
		
		int mediaSaveResult = mediaInfoMapper.insert(mediaInfo);
		
		// oper media visit num
		TMediaVisitNum mediaVisitNum = new TMediaVisitNum();
		mediaVisitNum.setId(IDUtils.gen32Uuid());
		mediaVisitNum.setMediaId(id);
		mediaVisitNum.setMediaVisitNum(mediaInfo.getMediaVisitNum());
		mediaVisitNum.setCreated(new Date());
		mediaVisitNum.setUpdated(new Date());
		
		int mediaVisitNumSaveResult = mediaVisitNumMapper.insert(mediaVisitNum);
		
		if(0 < mediaSaveResult && 0 < mediaVisitNumSaveResult) {
			return MyResult.ok(mediaInfo);
		}
		
		return MyResult.build(500, "未知错误");
	}

	@Override
	public LayuiTableResult getMediaList(Integer page, Integer limit,String mediaName,String state) {
		TMediaInfoExample example = new TMediaInfoExample();
		
		example.setOrderByClause("created DESC");
		
		com.landasoft.players.pojo.TMediaInfoExample.Criteria mediaInfoExampleCriteria = example.createCriteria();
		
		//处理查询条件
		if(StringUtils.isNotEmpty(mediaName)) {
			mediaInfoExampleCriteria.andMediaNameEqualTo(mediaName);
		}
		
		if(StringUtils.isNotEmpty(state)) {
			mediaInfoExampleCriteria.andStateEqualTo(Byte.valueOf(state));
		}
		
		PageHelper.startPage(page, limit);
		
		LayuiTableResult layuiTableResult = new LayuiTableResult();
		
		List<TMediaInfo> mediaInfoList = mediaInfoMapper.selectByExample(example);
		
		List<MediaInfoCustom> mediaInfoCustoms = new ArrayList<MediaInfoCustom>();
		
		if(null != mediaInfoList && mediaInfoList.size() > 0) {
			
			for (TMediaInfo tMediaInfo : mediaInfoList) {
				MediaInfoCustom mediaInfoCustom = getMediaInfoCustomByMediaInfo(tMediaInfo);

				mediaInfoCustoms.add(mediaInfoCustom);
			}
			
		}else {
			layuiTableResult.setCode(0);
			layuiTableResult.setCount(0);
			layuiTableResult.setData(null);
			layuiTableResult.setMsg("ok");
			
			return layuiTableResult;
		}
		
		//取记录总条数
		PageInfo<TMediaInfo> pageInfo = new PageInfo<>(mediaInfoList);
		long total = pageInfo.getTotal();
		
		layuiTableResult.setCode(0);
		layuiTableResult.setCount((int)total);
		layuiTableResult.setData(mediaInfoCustoms);
		layuiTableResult.setMsg("ok");
		
		return layuiTableResult;
	}

	@Override
	public MyResult deleteMediaById(String mediaId) {
		
		if(StringUtils.isEmpty(mediaId)) {
			throw new RuntimeException("删除视频时视频Id为空");
		}
		
		TMediaInfo mediaInfo = mediaInfoMapper.selectByPrimaryKey(Long.valueOf(mediaId));
		
		if(null != mediaInfo) {
			String mediaImageUrl = mediaInfo.getMediaImageUrl();
			
			File file = new File(mediaImageUrl);
			
			//删除图片
			if(file.exists()) {
				file.delete();
			}else {
				log.error("删除图片时，图片文件不存在");
			}
			
			//删除视频基本信息
			mediaInfoMapper.deleteByPrimaryKey(Long.valueOf(mediaId));
			
			//删除视频观看次数
			TMediaVisitNumExample mediaVisitNumExample = new TMediaVisitNumExample();
			Criteria mediaVisitNumCriteria = mediaVisitNumExample.createCriteria();
			mediaVisitNumCriteria.andMediaIdEqualTo(Long.valueOf(mediaId));
		    mediaVisitNumMapper.deleteByExample(mediaVisitNumExample);
			
		}else {
			return MyResult.build(500, "未查询到视频对象");		
		}
		
		return MyResult.ok();
	}

	@Override
	public MediaInfoCustom getMediaByMediaId(String mediaId) {
		if(StringUtils.isEmpty(mediaId)) {
			throw new RuntimeException("When get media object,mediaId is null");
		}
		
		TMediaInfo mediaInfo = mediaInfoMapper.selectByPrimaryKey(Long.valueOf(mediaId));

		if(null == mediaInfo) {
			throw new RuntimeException("Get media object is null");
		}

		MediaInfoCustom mediaInfoCustom = getMediaInfoCustomByMediaInfo(mediaInfo);
		
		return mediaInfoCustom;
	}

	@Override
	public MyResult updateMediaByMediaId(String mediaId, MediaInfoCustom mediaInfo) {
		
		if(StringUtils.isEmpty(mediaId)) {
			throw new RuntimeException("When update media object,mediaId is null");
		}
		
		//full attribute
		mediaInfo.setId(Long.valueOf(mediaId));
		//mediaInfo.setState((byte) 0);
		mediaInfo.setUpdated(new Date());

		TMediaInfo tMediaInfo = mediaInfoMapper.selectByPrimaryKey(Long.valueOf(mediaId));
		mediaInfo.setState(tMediaInfo.getState());

		int updateResult = mediaInfoMapper.updateByPrimaryKey(mediaInfo);

		TMediaVisitNumExample example = new TMediaVisitNumExample();
		Criteria criteria = example.createCriteria();
		criteria.andMediaIdEqualTo(Long.valueOf(mediaId));

		List<TMediaVisitNum> mediaVisitNumList = mediaVisitNumMapper.selectByExample(example);

		if(null != mediaVisitNumList && 0 < mediaVisitNumList.size()){
			TMediaVisitNum mediaVisitNum = mediaVisitNumList.get(0);
			mediaVisitNum.setMediaVisitNum(mediaInfo.getMediaVisitNum());
			mediaVisitNumMapper.updateByPrimaryKey(mediaVisitNum);
		}

		if(0 < updateResult) {
			return MyResult.ok();
		}
		
		return MyResult.build(500, "Is not edit success!");
	}

	/**
	 * type 1:down 2:up
	 */
	@Override
	public MyResult updateMediaWithDownOrUp(int type, String mediaId) {
		if(StringUtils.isEmpty(mediaId)) {
			throw new RuntimeException("When down or up media,mediaId is null");
		}
		if(1 != type && 2 != type) {
			throw new RuntimeException("When down or up media,oper type is null");
		}
		
		TMediaInfo mediaInfo = mediaInfoMapper.selectByPrimaryKey(Long.valueOf(mediaId));
		
		int oResult = 0;
		
		// down
		if(1 == type) {
			mediaInfo.setState((byte) 1);
			oResult = mediaInfoMapper.updateByPrimaryKey(mediaInfo);
		}
		if(2 == type) {
			mediaInfo.setState((byte) 0);
			oResult = mediaInfoMapper.updateByPrimaryKey(mediaInfo);
		}
		
		if(0 < oResult) {
			return MyResult.ok();
		}
		
		return MyResult.build(500, "未知错误");
	}

	/**
	 * By media get mediacustom
	 * @param mediaInfo
	 * @return
	 */
	MediaInfoCustom getMediaInfoCustomByMediaInfo(TMediaInfo mediaInfo){
		MediaInfoCustom mediaInfoCustom = new MediaInfoCustom();

		mediaInfoCustom.setId(mediaInfo.getId());
		mediaInfoCustom.setMediaName(mediaInfo.getMediaName());
		mediaInfoCustom.setMediaImageUrl(mediaInfo.getMediaImageUrl());
		mediaInfoCustom.setMediaSize(mediaInfo.getMediaSize());
		mediaInfoCustom.setMediaUrl(mediaInfo.getMediaUrl());
		mediaInfoCustom.setState(mediaInfo.getState());
		mediaInfoCustom.setCreated(mediaInfo.getCreated());
		mediaInfoCustom.setUpdated(mediaInfo.getUpdated());

		//观看次数
		TMediaVisitNumExample mediaVisitNumexample = new TMediaVisitNumExample();
		Criteria criteria = mediaVisitNumexample.createCriteria();
		criteria.andMediaIdEqualTo(mediaInfo.getId());

		List<TMediaVisitNum> mediaVisitNumList = mediaVisitNumMapper.selectByExample(mediaVisitNumexample);

		if(null != mediaVisitNumList && mediaVisitNumList.size() > 0) {
			TMediaVisitNum mediaVisitNum = mediaVisitNumList.get(0);
			mediaInfoCustom.setMediaVisitNum(mediaVisitNum.getMediaVisitNum());
		}

		return mediaInfoCustom;
	}

}
