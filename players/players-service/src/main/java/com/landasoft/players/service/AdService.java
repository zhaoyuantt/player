package com.landasoft.players.service;

import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.players.pojo.TAd;

/**
 * 广告管理Service接口
 * @author zhaoyuan
 * @date 2020,Jan 6:50 pm
 */
public interface AdService {

    /**
     *
     * @param page
     * @param limit
     * @param adName
     * @param adType 广告类型 1：底部广告 ...
     * @param adState 广告类型 0：正常 1：删除
     * @return
     */
    LayuiTableResult getAdListPage(Integer page,Integer limit,String adName,Byte adType,Byte adState);

    /**
     *
     * @param ad
     * @return
     */
    MyResult saveAd(TAd ad);

    /**
     *
     * @param adId
     * @return
     */
    TAd getAdById(String adId);

    /**
     *
     * @param adId
     * @param ad
     * @return
     */
    MyResult updateAdById(String adId,TAd ad);

    /**
     *
     * @param adId
     * @return
     */
    MyResult deleteAdById(String adId);

    /**
     *
     * @param adId
     * @param operType 1:下架 2：上架
     * @return
     */
    MyResult updateStateById(Byte operType,String adId);

    /**
     *
     * @return
     */
    MyResult getAdImageList(Byte adType);
}
