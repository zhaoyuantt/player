package com.landasoft.players.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.common.utils.IDUtils;
import com.landasoft.players.mapper.TCarouselMapper;
import com.landasoft.players.pojo.TCarousel;
import com.landasoft.players.pojo.TCarouselExample;
import com.landasoft.players.service.CarouselService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 轮播图Service接口实现
 *
 * @author zhaoyuan
 * @date 2020, Feb 19 10:59 pm
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    private static final Logger log = Logger.getLogger(CarouselServiceImpl.class);

    @Autowired
    private TCarouselMapper carouselMapper;

    @Override
    public LayuiTableResult getCarouselList(Integer page, Integer limit, String carouselName, String carouselLink, Byte carouselState) {

        //构建查询条件
        TCarouselExample carouselExample = new TCarouselExample();
        carouselExample.setOrderByClause("created DESC");
        TCarouselExample.Criteria carouselExampleCriteria = carouselExample.createCriteria();

        if (StringUtils.isNotEmpty(carouselName)) {
            carouselExampleCriteria.andCarouselNameLike("%" + carouselName + "%");
        }
        if (StringUtils.isNotEmpty(carouselLink)) {
            carouselExampleCriteria.andCarouselLinkLike("%" + carouselLink + "%");
        }
        if (null != carouselState) {
            carouselExampleCriteria.andCarouselStateEqualTo(carouselState);
        }

        //设置分页条件
        PageHelper.startPage(page, limit);

        //执行查询
        List<TCarousel> carouselList = carouselMapper.selectByExample(carouselExample);

        LayuiTableResult layuiTableResult = new LayuiTableResult();

        //处理返回结果
        if (null != carouselList && 0 < carouselList.size()) {
            //取记录总条数
            PageInfo<TCarousel> pageInfo = new PageInfo<>(carouselList);
            long total = pageInfo.getTotal();

            layuiTableResult.setCode(0);
            layuiTableResult.setCount((int) total);
            layuiTableResult.setData(carouselList);
            layuiTableResult.setMsg("ok");

            return layuiTableResult;
        }else{
            layuiTableResult.setCode(0);
            layuiTableResult.setCount(0);
            layuiTableResult.setData(null);
            layuiTableResult.setMsg("ok");

            return layuiTableResult;
        }

    }

    @Override
    public MyResult saveCarousel(TCarousel carousel) {
        //校验参数
        checkCarouselParams(carousel);

        //补全属性
        carousel.setId(IDUtils.gen32Uuid());
        carousel.setCarouselState((byte) 0);
        carousel.setCreated(new Date());
        carousel.setUpdated(new Date());

        //插入数据库
        int iResult = carouselMapper.insert(carousel);

        if (0 < iResult) {
            return MyResult.ok();
        }

        return MyResult.build(450, "未知错误");
    }

    @Override
    public TCarousel getCarouselById(String carouselId) {
        checkCarouselId(carouselId);

        TCarousel carousel = carouselMapper.selectByPrimaryKey(carouselId);

        if(null != carousel){
            return  carousel;
        }

        return null;
    }

    @Override
    public MyResult updateCarousel(String carouselId, TCarousel carousel) {
        checkCarouselId(carouselId);

        TCarousel qCarousel = carouselMapper.selectByPrimaryKey(carouselId);

        if(null != qCarousel){
            qCarousel.setCarouselName(carousel.getCarouselName());
            qCarousel.setCarouselLink(carousel.getCarouselLink());
            qCarousel.setCarouselImageDir(carousel.getCarouselImageDir());
            qCarousel.setCarouselPrice(carousel.getCarouselPrice());
            qCarousel.setCarouselSort(carousel.getCarouselSort());
            qCarousel.setUpdated(new Date());

            int uResult = carouselMapper.updateByPrimaryKey(qCarousel);

            if(0 < uResult){
                return MyResult.ok();
            }
        }

        return MyResult.build(450,"未知错误");
    }

    @Override
    public MyResult updateCarouselStateById(byte operType, String carouselId) {

        int uResult = 0;

        if(1 == operType){//下架
            TCarousel qCarousel = getCarouselById(carouselId);
            qCarousel.setCarouselState((byte) 1);

            uResult = carouselMapper.updateByPrimaryKey(qCarousel);
        } else if(2 == operType){//上架
            TCarousel qCarousel = getCarouselById(carouselId);
            qCarousel.setCarouselState((byte) 0);

            uResult = carouselMapper.updateByPrimaryKey(qCarousel);
        }else{
            throw new RuntimeException("Update carousel state oper type is null");
        }

        if(0 < uResult){
            return MyResult.ok();
        }

        return MyResult.build(450,"未知错误");
    }

    @Override
    public MyResult deleteCarouselById(String carouselId) {
        checkCarouselId(carouselId);

        int dResult = carouselMapper.deleteByPrimaryKey(carouselId);

        if(0 < dResult){
            return MyResult.ok();
        }

        return MyResult.build(450,"未知错误");
    }

    @Override
    public MyResult getCarouselList() {
        TCarouselExample carouselExample = new TCarouselExample();
        carouselExample.setOrderByClause("carousel_price DESC");
        TCarouselExample.Criteria criteria = carouselExample.createCriteria();
        criteria.andCarouselStateEqualTo((byte) 0);

        List<TCarousel> carouselList = carouselMapper.selectByExample(carouselExample);

        if(null != carouselList && 0 < carouselList.size()){
            return MyResult.ok(carouselList);
        }

        return MyResult.ok();
    }

    /**
     * 校验carouselId
     * @param carouselId
     */
    public void checkCarouselId(String carouselId){
        if(StringUtils.isEmpty(carouselId)){
            throw new RuntimeException("Get carousel object by id,carousel is null");
        }
    }

    /**
     * 参数校验 carousel object
     *
     * @param carousel
     */
    public void checkCarouselParams(TCarousel carousel) {
        if (StringUtils.isEmpty(carousel.getCarouselName())) {
            throw new RuntimeException("轮播图名称为空");
        }
        if (StringUtils.isEmpty(carousel.getCarouselLink())) {
            throw new RuntimeException("轮播图跳转链接为空");
        }
        if (StringUtils.isEmpty(carousel.getCarouselImageDir())) {
            throw new RuntimeException("轮播图图片存储路径为空");
        }
        if (null == carousel.getCarouselSort()) {
            throw new RuntimeException("轮播图排序规则为空");
        }
    }
}
