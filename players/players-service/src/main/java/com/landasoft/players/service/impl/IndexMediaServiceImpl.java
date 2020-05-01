package com.landasoft.players.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.players.mapper.TMediaInfoMapper;
import com.landasoft.players.mapper.TMediaVisitNumMapper;
import com.landasoft.players.mypojo.MediaInfoCustom;
import com.landasoft.players.pojo.TMediaInfo;
import com.landasoft.players.pojo.TMediaInfoExample;
import com.landasoft.players.pojo.TMediaVisitNum;
import com.landasoft.players.pojo.TMediaVisitNumExample;
import com.landasoft.players.service.IndexMediaService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台视频Service接口实现
 *
 * @author zhaoyaun
 * @date 2020, Feb 15 4:33 pm
 */
@Service
public class IndexMediaServiceImpl implements IndexMediaService {

    private static final Logger log = Logger.getLogger(IndexMediaServiceImpl.class);

    @Autowired
    private TMediaInfoMapper mediaInfoMapper;
    @Autowired
    private TMediaVisitNumMapper mediaVisitNumMapper;

    @Override
    public LayuiTableResult getMediaList(Integer page, Integer limit) {
        //设置查询条件
        TMediaInfoExample example = new TMediaInfoExample();

        example.setOrderByClause("created DESC");

        TMediaInfoExample.Criteria criteria = example.createCriteria();
        criteria.andStateEqualTo((byte) 0);

        PageHelper.startPage(page, limit);

        //执行查询
        List<TMediaInfo> mediaInfoList = mediaInfoMapper.selectByExample(example);

        List<MediaInfoCustom> mediaInfoCustoms = new ArrayList<>();

        LayuiTableResult layuiTableResult = new LayuiTableResult();

        if(null != mediaInfoList && 0 < mediaInfoList.size()){
            for (int i = 0; i < mediaInfoList.size(); i++) {
                TMediaInfo tMediaInfo =  mediaInfoList.get(i);
                MediaInfoCustom mediaInfoCustom = new MediaInfoCustom();
                mediaInfoCustom.setId(tMediaInfo.getId());
                mediaInfoCustom.setMediaName(tMediaInfo.getMediaName());
                mediaInfoCustom.setMediaImageUrl(tMediaInfo.getMediaImageUrl());
                mediaInfoCustom.setMediaSize(tMediaInfo.getMediaSize());
                mediaInfoCustom.setMediaUrl(tMediaInfo.getMediaUrl());
                mediaInfoCustom.setState(tMediaInfo.getState());
                mediaInfoCustom.setCreated(tMediaInfo.getCreated());
                mediaInfoCustom.setUpdated(tMediaInfo.getUpdated());

                //处理观看次数
                TMediaVisitNumExample mediaVisitNumExample = new TMediaVisitNumExample();

                TMediaVisitNumExample.Criteria mediaVisitNumCriteria = mediaVisitNumExample.createCriteria();

                mediaVisitNumCriteria.andMediaIdEqualTo(tMediaInfo.getId());

                //执行查询
                List<TMediaVisitNum> mediaVisitNumList= mediaVisitNumMapper.selectByExample(mediaVisitNumExample);

                if(null != mediaVisitNumList && 0 < mediaVisitNumList.size()){
                    TMediaVisitNum mediaVisitNum = mediaVisitNumList.get(0);
                    mediaInfoCustom.setMediaVisitNum(mediaVisitNum.getMediaVisitNum());
                }

                mediaInfoCustoms.add(mediaInfoCustom);
            }
        }else{
            layuiTableResult.setCode(0);
            layuiTableResult.setCount(0);
            layuiTableResult.setData(null);
            layuiTableResult.setMsg("未知错误");

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
    public void updateMediaVisitNumByMediaId(String mediaId) {
        if(StringUtils.isEmpty(mediaId)){
            throw new RuntimeException("更新视频观看次数时，视频Id为null");
        }

        TMediaVisitNumExample example = new TMediaVisitNumExample();
        TMediaVisitNumExample.Criteria criteria = example.createCriteria();
        criteria.andMediaIdEqualTo(Long.valueOf(mediaId));

        List<TMediaVisitNum> mediaVisitNumList = mediaVisitNumMapper.selectByExample(example);

        if(null != mediaVisitNumList && 0 < mediaVisitNumList.size()){
            for (int i = 0; i < mediaVisitNumList.size(); i++) {
                TMediaVisitNum mediaVisitNum =  mediaVisitNumList.get(i);

                Long visitNum = mediaVisitNum.getMediaVisitNum();
                mediaVisitNum.setMediaVisitNum(visitNum+1);

                int updateResult = mediaVisitNumMapper.updateByPrimaryKey(mediaVisitNum);

                if(0 < updateResult){
                    log.info("视频观看次数更新成功");
                }
            }
        }
    }
}
