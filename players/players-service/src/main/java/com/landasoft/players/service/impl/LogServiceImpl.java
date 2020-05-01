package com.landasoft.players.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.utils.IDUtils;
import com.landasoft.players.mapper.TLogMapper;
import com.landasoft.players.pojo.TLog;
import com.landasoft.players.pojo.TLogExample;
import com.landasoft.players.service.LogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 操作日志Service接口实现
 * @author zhaoyaun
 * @date 2020,Jan 20 10:50 am
 */
@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private TLogMapper logMapper;

    @Override
    public LayuiTableResult getOperlogList(Integer page, Integer limit,String operator,String operEvent) {
        TLogExample logExample = new TLogExample();
        logExample.setOrderByClause("created DESC");
        TLogExample.Criteria logExampleCriteria = logExample.createCriteria();

        if(StringUtils.isNotEmpty(operator)){
            logExampleCriteria.andOperatorEqualTo(operator);
        }
        if(StringUtils.isNotEmpty(operEvent)){
            logExampleCriteria.andOperEventLike("%"+operEvent+"%");
        }

        //设置分页条件
        PageHelper.startPage(page, limit);

        List<TLog> logList = logMapper.selectByExample(logExample);

        LayuiTableResult layuiTableResult = new LayuiTableResult();

        if(null != logList && 0 < logList.size()){
            PageInfo<TLog> pageInfo = new PageInfo<>(logList);
            long total = pageInfo.getTotal();

            layuiTableResult.setCode(0);
            layuiTableResult.setData(logList);
            layuiTableResult.setCount((int) total);
            layuiTableResult.setMsg("ok");

            return layuiTableResult;
        }else{
            layuiTableResult.setCode(0);
            layuiTableResult.setData(null);
            layuiTableResult.setCount(0);
            layuiTableResult.setMsg("ok");

            return layuiTableResult;
        }

    }

    @Override
    public void saveOperLog(String operator, String operEvent) {
        TLog log = new TLog();
        log.setId(IDUtils.gen32Uuid());
        log.setOperator(operator);
        log.setOperEvent(operEvent);
        log.setCreated(new Date());

        logMapper.insert(log);
    }
}
