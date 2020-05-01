package com.landasoft.players.service;

import com.landasoft.common.pojo.MyResult;
import com.landasoft.players.pojo.TAdminUser;

/**
 * 后台管理用戶Service接口
 * @author zhaoyuan
 * @date 2020,Feb 12 4:34 pm
 */
public interface AdminUserService {

	/**
	 * 
	 * @param adminUsername
	 * @return
	 */
	public MyResult findAdminUserByUsername(String adminUsername);
	
	/**
	 * 
	 * @param adminUser
	 * @return
	 */
	public int saveAdminuser(TAdminUser adminUser);

	/**
	 * Verify admin user information
	 * @param adminUser
	 * @return
	 */
	public MyResult checkAdminUser(TAdminUser adminUser);

	/**
	 * 获取用户名列表
	 * @return
	 */
	MyResult getUsernameList();
}
