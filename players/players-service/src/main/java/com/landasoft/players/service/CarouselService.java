package com.landasoft.players.service;

import com.landasoft.common.pojo.LayuiTableResult;
import com.landasoft.common.pojo.MyResult;
import com.landasoft.players.pojo.TCarousel;

/**
 * 轮播图管理Service接口
 * @author zhaoyaun
 * @date 2020,Feb 19 10:53 am
 */
public interface CarouselService {

    /**
     * 分页获取轮播图列表
     * @param page   第几页
     * @param limit  每页显示多少条数据
     * @param carouselName   名称
     * @param carouselLink   跳转链接
     * @param carouselState  状态：0-正常 1：禁用
     * @return
     */
    public LayuiTableResult getCarouselList(Integer page,Integer limit,String carouselName,String carouselLink,Byte carouselState);

    /**
     * 轮播图添加
     * @param carousel
     * @return
     */
    public MyResult saveCarousel(TCarousel carousel);

    /**
     * get carousel by carousel object id
     * @param carouselId
     * @return
     */
    public TCarousel getCarouselById(String carouselId);

    /**
     * Update carousel object
     * @param carouselId
     * @param carousel
     * @return
     */
    public MyResult updateCarousel(String carouselId,TCarousel carousel);

    /**
     * Up or down carousel by carousel id
     * @param operType 1:下架 2：上架
     * @param carouselId
     * @return
     */
    MyResult updateCarouselStateById(byte operType,String carouselId);

    /**
     * Delete carousel by carousel id
     * @param carouselId
     * @return
     */
    MyResult deleteCarouselById(String carouselId);

    /**
     * 获取轮播图列表
     * @return
     */
    MyResult getCarouselList();
}
