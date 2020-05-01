package com.landasoft.players.service;

import com.landasoft.common.pojo.LayuiTableResult;

/**
 * 操作日志Service接口
 * @author zhaoyuan
 * @date 2020,Feb 20 10:46 am
 */
public interface LogService {

    /**
     * 查询操作日志列表
     * @param page
     * @param limit
     * @param operator
     * @param operEvent
     * @return
     */
    LayuiTableResult getOperlogList(Integer page,Integer limit,String operator,String operEvent);

    /**
     * 添加操作日志记录
     * @param operator
     * @param operEvent
     */
    void saveOperLog(String operator,String operEvent);
}
