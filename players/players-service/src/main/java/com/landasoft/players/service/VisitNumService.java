package com.landasoft.players.service;

import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;

import java.util.Date;

/**
 * 网站前台访问量Service接口
 * @author zhaoyuan
 * @date 2020,Jan 22 12:30 pm
 */
public interface VisitNumService {

    /**
     * Add web visit num
     */
    void saveVisit();

    /**
     * Update visit by created
     * @param created
     */
    void updateVisitByCreated(Date created);

    /**
     * 获得总访问量
     * @return
     */
    Long getTotalVisitNum();

    /**
     * 获得当天访问量
     * @param samedayDate
     * @return
     */
    Short getSamedayVisitNum(Date samedayDate);

    /**
     * 分页获取访问量数据
     * @param page
     * @param limit
     * @param created
     * @return
     */
    LayuiTableResult getVisitNumList(Integer page,Integer limit,Date created);

    /**
     * 更新某天的访问量
     * @param visitNumId
     * @param visitNum
     * @return
     */
    MyResult updateVisitNumById(String visitNumId,Short visitNum);

}
