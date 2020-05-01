package com.landasoft.players.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.common.utils.IDUtils;
import com.landasoft.players.mapper.TVisitNumMapper;
import com.landasoft.players.pojo.TVisitNum;
import com.landasoft.players.pojo.TVisitNumExample;
import com.landasoft.players.service.VisitNumService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 网站前台访问量Service接口实现
 * @author zhaoyuan
 * @date 2020,Jan 22 12:32 pm
 */
@Service
public class VisitNumServiceImpl implements VisitNumService {

    @Autowired
    private TVisitNumMapper visitNumMapper;
    @Value("${INIT_VISIT_NUM}")
    private String INIT_VISIT_NUM;
    @Value("${INIT_SOMEDAY_VISIT_NUM}")
    private String INIT_SOMEDAY_VISIT_NUM;

    @Override
    public void saveVisit() {
        String strrandomNumeric = RandomStringUtils.randomNumeric(3);

        TVisitNum visitNum = new TVisitNum();
        visitNum.setId(IDUtils.gen32Uuid());
        visitNum.setVisitNum(Short.valueOf(strrandomNumeric));
        visitNum.setCreated(new Date());
        visitNum.setUpdated(new Date());

        int iResult = visitNumMapper.insert(visitNum);

        String apacheTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd");

        if(0 < iResult){
            System.out.println(apacheTime+"访问量初始化成功");
        }

    }

    @Override
    public void updateVisitByCreated(Date created) {
        checkVisitNumCreatedDate(created);

        TVisitNumExample visitExample = new TVisitNumExample();
        TVisitNumExample.Criteria visitExampleCriteria = visitExample.createCriteria();
        visitExampleCriteria.andCreatedEqualTo(created);

        List<TVisitNum> visitNumList = visitNumMapper.selectByExample(visitExample);

        if(null != visitNumList && 0 < visitNumList.size()){
            TVisitNum visit = visitNumList.get(0);
            Short visitNum = visit.getVisitNum();

            visit.setVisitNum((short) (visitNum+1));
            visit.setUpdated(new Date());

            int uResult = visitNumMapper.updateByPrimaryKey(visit);

            if(0 < uResult){
                String apacheTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
                System.out.println(apacheTime+"访问量更新成功");
            }
        }else {
            saveVisit();
        }

    }

    @Override
    public Long getTotalVisitNum() {
        TVisitNumExample visitExample = new TVisitNumExample();
        List<TVisitNum> visitNumList = visitNumMapper.selectByExample(visitExample);

        Long INIT_VISIT_NUM = Long.valueOf(this.INIT_VISIT_NUM);
        Long totalVisitNum = INIT_VISIT_NUM;


        if(null != visitNumList){
            for (int i = 0; i < visitNumList.size(); i++) {
                TVisitNum tVisitNum =  visitNumList.get(i);
                Short visitNum = tVisitNum.getVisitNum();
                totalVisitNum = totalVisitNum+visitNum;
            }
            return totalVisitNum;
        }

        return INIT_VISIT_NUM;
    }

    @Override
    public Short getSamedayVisitNum(Date samedayDate) {
        checkVisitNumCreatedDate(samedayDate);

        TVisitNumExample visitExample = new TVisitNumExample();
        TVisitNumExample.Criteria visitExampleCriteria = visitExample.createCriteria();
        visitExampleCriteria.andCreatedEqualTo(samedayDate);

        List<TVisitNum> visitNumList = visitNumMapper.selectByExample(visitExample);

        if(null != visitNumList && 0 < visitNumList.size()){
            //return (byte) visitList.size();
            TVisitNum tVisitNum = visitNumList.get(0);
            Short visitNum = tVisitNum.getVisitNum();
            return visitNum;
        }

        return Short.valueOf(INIT_SOMEDAY_VISIT_NUM);
    }

    @Override
    public LayuiTableResult getVisitNumList(Integer page, Integer limit, Date created) {
        TVisitNumExample visitExample = new TVisitNumExample();
        visitExample.setOrderByClause("created DESC");

        if(null != created){
            TVisitNumExample.Criteria visitExampleCriteria = visitExample.createCriteria();
            visitExampleCriteria.andCreatedEqualTo(created);
        }

        PageHelper.startPage(page, limit);

        List<TVisitNum> visitNumList = visitNumMapper.selectByExample(visitExample);

        LayuiTableResult layuiTableResult = new LayuiTableResult();

        if(null != visitNumList && 0 < visitNumList.size()){
            PageInfo<TVisitNum> pageInfo = new PageInfo<>(visitNumList);
            long total = pageInfo.getTotal();

            layuiTableResult.setCode(0);
            layuiTableResult.setData(visitNumList);
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
    public MyResult updateVisitNumById(String visitNumId, Short visitNum) {
        checkVisitNumId(visitNumId);
        if(null == visitNum){
            throw new RuntimeException("visit num is null");
        }

        TVisitNum tVisitNum = visitNumMapper.selectByPrimaryKey(visitNumId);

        if(null != tVisitNum){
            tVisitNum.setVisitNum(visitNum);
            tVisitNum.setUpdated(new Date());

            int uResult = visitNumMapper.updateByPrimaryKey(tVisitNum);

            if(0 < uResult){
                return MyResult.ok();
            }else {
                return MyResult.build(405,"未知错误");
            }
        }

        return MyResult.build(405,"未知错误");
    }

    void checkVisitNumCreatedDate(Date date){
        if(null == date){
            throw new RuntimeException("visit create date is null");
        }
    }

    void checkVisitNumId(String visitId){
        if(StringUtils.isEmpty(visitId)){
            throw new RuntimeException("visit id is null");
        }
    }
}
