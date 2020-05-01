package com.landasoft.players.service;

import com.landasoft.common.pojo.LayuiTableResult;

/**
 * 前台视频Service接口
 *
 * @author zhaoyaun
 * @date 2020, Feb 15 4:33 pm
 */
public interface IndexMediaService {

    /**
     * 前台视频列表
     *
     * @param page  第几页
     * @param limit 每页显示多少条数据
     * @return
     */
    public LayuiTableResult getMediaList(Integer page, Integer limit);

    /**
     * By mediaId update media visit num
     * @param mediaId
     */
    public void updateMediaVisitNumByMediaId(String mediaId);
}
