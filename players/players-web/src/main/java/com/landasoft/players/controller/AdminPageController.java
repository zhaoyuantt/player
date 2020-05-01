package com.landasoft.players.controller;

import com.landasoft.players.pojo.TAd;
import com.landasoft.players.pojo.TCarousel;
import com.landasoft.players.service.AdService;
import com.landasoft.players.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.landasoft.players.pojo.TMediaInfo;
import com.landasoft.players.service.MediaServive;

import javax.servlet.http.HttpServletRequest;

/**
 * 頁面跳轉Controller
 * @author zhaoyuan
 * @date 2020,Feb 12 6:27 pm
 */
@Controller
public class AdminPageController {
	
	@Autowired
	private MediaServive mediaService;
	@Autowired
	private CarouselService carouselService;
	@Autowired
	private AdService adService;

	/*
	 * @RequestMapping("/") public String showIndex() { return "index"; }
	 */
	
	/**
	 * 跳转后台管理页面首页面
	 * @param request 
	 * @return
	 */
	@RequestMapping("/admin/index")
	public ModelAndView showAdminIndexPage(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		Object username = request.getSession().getAttribute("ADMINUSER");
		modelAndView.setViewName("adminPage/index");
		modelAndView.addObject("USERINFO", username);
		return modelAndView;
	}
	
	/**
	 * 跳转到视频列表页面
	 * @return
	 */
	@RequestMapping("/admin/media/listpage")
	public ModelAndView showAdminMediaListPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/media-list");
		return modelAndView;
	}
	
	/**
	 * 跳转到视频添加页面
	 * @return
	 */
	@RequestMapping("/admin/media/addpage")
	public ModelAndView showAdminMediaAddPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/media-add");
		return modelAndView;
	}
	
	/**
	 * Jump media edit page
	 * @param mediaId
	 * @return
	 */
	@RequestMapping("/admin/media/editpage/{mediaId}")
	public ModelAndView showAdminMediaEditPage(@PathVariable String mediaId) {
		ModelAndView modelAndView = new ModelAndView();
		
		TMediaInfo mediaInfo = mediaService.getMediaByMediaId(mediaId);
		
		modelAndView.addObject("MEDIAINFO", mediaInfo);
		modelAndView.setViewName("adminPage/media-edit");
		
		return modelAndView;
	}

	/**
	 * Jump to admin login page
	 * @param redirect 用户请求的页面
	 * @return
	 */
	@RequestMapping("/admin/login")
	public ModelAndView showAdminLoginPage(@RequestParam(value = "redirect",defaultValue = "") String redirect){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/login");
		modelAndView.addObject("REDIRCT",redirect);
		return modelAndView;
	}

	/**
	 * 跳转到轮播图列表页面
	 * @return
	 */
	@RequestMapping("/admin/carousel/listpage")
	public ModelAndView showCarouselListPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/carousel-list");
		return modelAndView;
	}

	/**
	 * 跳转到轮播图添加页面
	 * @return
	 */
	@RequestMapping("/admin/carousel/addpage")
	public ModelAndView showCarouselAddPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/carousel-add");
		return modelAndView;
	}

	/**
	 * Jump carousel edit page
	 * @param carouselId
	 * @return
	 */
	@RequestMapping("/admin/carousel/editpage/{carouselId}")
	public ModelAndView showCarouselEditPage(@PathVariable String carouselId){
		ModelAndView modelAndView = new ModelAndView();

		TCarousel carousel = carouselService.getCarouselById(carouselId);

		modelAndView.setViewName("adminPage/carousel-edit");
		modelAndView.addObject("CAROUSEL",carousel);

		return modelAndView;
	}

	/**
	 * Jump to oper log page
	 * @return
	 */
	@RequestMapping("/admin/operlog/listpage")
	public ModelAndView showOperlogListPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/operlog-list");
		return modelAndView;
	}

	/**
	 * Jump to ad list
	 * @return
	 */
	@RequestMapping("/admin/ad/listpage")
	public ModelAndView showAdListPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/ad-list");
		return modelAndView;
	}

	/**
	 * 跳转到广告添加页面
	 * @return
	 */
	@RequestMapping("/admin/ad/addpage")
	public ModelAndView showAdAddPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/ad-add");
		return modelAndView;
	}

	/**
	 *
	 * @param adId
	 * @return
	 */
	@RequestMapping("/admin/ad/editpage/{adId}")
	public ModelAndView showAdEditPage(@PathVariable String adId){
		ModelAndView modelAndView = new ModelAndView();

		TAd ad = adService.getAdById(adId);

		modelAndView.setViewName("adminPage/ad-edit");
		modelAndView.addObject("AD",ad);

		return modelAndView;
	}

	/**
	 * 跳转到访问量管理页面
	 * @return
	 */
	@RequestMapping("/admin/visitnum/listpage")
	public ModelAndView showVisitNumListPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("adminPage/visitnum-list");
		return modelAndView;
	}
}
