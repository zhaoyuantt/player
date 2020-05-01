package com.landasoft.players.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.common.utils.IDUtils;
import com.landasoft.players.mapper.TAdMapper;
import com.landasoft.players.pojo.TAd;
import com.landasoft.players.pojo.TAdExample;
import com.landasoft.players.service.AdService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 广告管理Service接口实现
 * @author zhaoyuan
 * @date 2020,Jan 21 6:57 pm
 */
@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private TAdMapper adMapper;

    @Override
    public LayuiTableResult getAdListPage(Integer page, Integer limit, String adName, Byte adType, Byte adState) {

        TAdExample adExample = new TAdExample();
        adExample.setOrderByClause("created DESC");
        TAdExample.Criteria adExampleCriteria = adExample.createCriteria();

        if(StringUtils.isNotEmpty(adName)){
            adExampleCriteria.andAdNameLike("%"+adName+"%");
        }
        if(null != adType){
            adExampleCriteria.andAdTypeEqualTo(adType);
        }
        if(null != adState){
            adExampleCriteria.andAdStateEqualTo(adState);
        }

        PageHelper.startPage(page, limit);

        List<TAd> adList = adMapper.selectByExample(adExample);

        LayuiTableResult layuiTableResult = new LayuiTableResult();

        if(null != adList && 0 < adList.size()){
            PageInfo<TAd> pageInfo = new PageInfo<>(adList);
            long total = pageInfo.getTotal();

            layuiTableResult.setCode(0);
            layuiTableResult.setData(adList);
            layuiTableResult.setCount((int) total);
            layuiTableResult.setMsg("ok");

            return layuiTableResult;
        }else {
            layuiTableResult.setCode(0);
            layuiTableResult.setData(null);
            layuiTableResult.setCount(0);
            layuiTableResult.setMsg("ok");

            return layuiTableResult;
        }

    }

    @Override
    public MyResult saveAd(TAd ad) {

        checkAdParams(ad);

        ad.setId(IDUtils.gen32Uuid());
        ad.setAdState((byte) 0);
        ad.setCreated(new Date());
        ad.setUpdated(new Date());

        int iResult = adMapper.insert(ad);

        if(0 < iResult){
            return MyResult.ok();
        }

        return MyResult.build(405,"未知错误");
    }

    @Override
    public TAd getAdById(String adId) {
        checkAdId(adId);

        TAd ad = adMapper.selectByPrimaryKey(adId);

        if(null != ad){
            return ad;
        }

        return null;
    }

    @Override
    public MyResult updateAdById(String adId, TAd ad) {
        checkAdId(adId);
        checkAdParams(ad);

        TAd qAd = adMapper.selectByPrimaryKey(adId);

        if(null != qAd){
            qAd.setAdName(ad.getAdName());
            qAd.setAdLink(ad.getAdLink());
            qAd.setAdImageDir(ad.getAdImageDir());
            qAd.setAdType(ad.getAdType());
            qAd.setUpdated(new Date());

            int uResult = adMapper.updateByPrimaryKey(qAd);

            if(0 < uResult){
                return MyResult.ok();
            }
        }

        return MyResult.build(405,"未知错误");
    }

    @Override
    public MyResult deleteAdById(String adId) {
        checkAdId(adId);

        int dResult = adMapper.deleteByPrimaryKey(adId);

        if(0 < dResult){
            return MyResult.ok();
        }

        return MyResult.build(405,"未知错误");
    }

    /**
     *
     * @param operType 1:下架 2：上架
     * @param adId
     * @return
     */
    @Override
    public MyResult updateStateById(Byte operType,String adId) {
        if(null == operType){
            throw new RuntimeException("上架或者下架广告时操作类型为空");
        }

        TAd ad = getAdById(adId);

        int uResult = 0;

        if(1 == operType){
            ad.setAdState((byte) 1);
            ad.setUpdated(new Date());

            uResult = adMapper.updateByPrimaryKey(ad);
        }else if(2 == operType){
            ad.setAdState((byte) 0);
            ad.setUpdated(new Date());

            uResult = adMapper.updateByPrimaryKey(ad);
        } else {
            return MyResult.build(405,"无效的操作类型");
        }

        if(0 < uResult){
            return MyResult.ok();
        }

        return MyResult.build(405,"未知错误");
    }

    @Override
    public MyResult getAdImageList(Byte adType) {
        TAdExample adExample = new TAdExample();
        TAdExample.Criteria adExampleCriteria = adExample.createCriteria();
        adExampleCriteria.andAdStateEqualTo((byte) 0);
        adExampleCriteria.andAdTypeEqualTo(adType);

        List<TAd> adList = adMapper.selectByExample(adExample);

       //List<String> adIdList = new ArrayList<>();

        if(null != adList && 0 < adList.size()){
            /*for (int i = 0; i < adList.size(); i++) {
                TAd ad =  adList.get(i);
                adIdList.add(ad.getId());
            }*/

            return MyResult.ok(adList);
        }

        return MyResult.ok();
    }

    /**
     *
     * @param ad
     */
    void checkAdParams(TAd ad){
        if(StringUtils.isEmpty(ad.getAdName())){
            throw new RuntimeException("广告名称为空");
        }
        if(StringUtils.isEmpty(ad.getAdLink())){
            throw new RuntimeException("广告链接为空");
        }
        if(StringUtils.isEmpty(ad.getAdImageDir())){
            throw new RuntimeException("广告图片为空");
        }
        if(null == ad.getAdType()){
            throw new RuntimeException("广告方位为空");
        }
    }

    void checkAdId(String adId){
        if(StringUtils.isEmpty(adId)){
            throw new RuntimeException("广告id为空");
        }
    }
}
