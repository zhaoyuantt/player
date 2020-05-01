package com.landasoft.players.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.landasoft.common.pojo.MyResult;
import com.landasoft.players.mapper.TAdminUserMapper;
import com.landasoft.players.pojo.TAdminUser;
import com.landasoft.players.pojo.TAdminUserExample;
import com.landasoft.players.pojo.TAdminUserExample.Criteria;
import com.landasoft.players.service.AdminUserService;
import org.springframework.util.DigestUtils;

/**
 * 后台管理用戶Service接口實現
 * @author zhaoyuan
 * @date 2020,Feb 12 4:37 pm
 */
@Service
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired
	private TAdminUserMapper adminUserMapper;
	
	@Override
	public MyResult findAdminUserByUsername(String adminUsername) {
		//TAdminUser adminUser = adminUserMapper.selectByPrimaryKey(adminUsername);
		
		TAdminUserExample example = new TAdminUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(adminUsername);
		
		List<TAdminUser> adminUserList = adminUserMapper.selectByExample(example);
		
		if(null != adminUserList && adminUserList.size() != 0) {
			return MyResult.ok(adminUserList.get(0));
		}
		return MyResult.build(500, "用戶名或密碼錯誤");
	}

	@Override
	public int saveAdminuser(TAdminUser adminUser) {
		int result = adminUserMapper.insert(adminUser);
		return result;
	}

	@Override
	public MyResult checkAdminUser(TAdminUser adminUser) {
		//verify must parameter
		if(StringUtils.isEmpty(adminUser.getUsername())){
			throw new RuntimeException("username is null");
		}
		if(StringUtils.isEmpty(adminUser.getPassword())){
			throw new RuntimeException("password is null");
		}

		String username = adminUser.getUsername();

		//execute query
		TAdminUserExample adminUserExample = new TAdminUserExample();
		Criteria adminUserExampleCriteria = adminUserExample.createCriteria();
		adminUserExampleCriteria.andUsernameEqualTo(username);
		List<TAdminUser> adminUserList = adminUserMapper.selectByExample(adminUserExample);

		//handle return result
		if(null != adminUserList && 0 < adminUserList.size()){
			TAdminUser qAdminUser = adminUserList.get(0);

			//verify password
			String oPassword = DigestUtils.md5DigestAsHex(adminUser.getPassword().getBytes());
			String qPassword = qAdminUser.getPassword();

			if(oPassword.equals(qPassword)){
				return MyResult.ok();
			}
		}

		return MyResult.build(500,"用户名或密码错误");
	}

	@Override
	public MyResult getUsernameList() {
		TAdminUserExample adminUserExample = new TAdminUserExample();
		List<TAdminUser> adminUserList = adminUserMapper.selectByExample(adminUserExample);

		List<String> usernameList = new ArrayList<>();

		if(null != adminUserList && 0 < adminUserList.size()){
			for (int i = 0; i < adminUserList.size(); i++) {
				TAdminUser adminUser =  adminUserList.get(i);
				usernameList.add(adminUser.getUsername());
			}
			return MyResult.ok(usernameList);
		}else{
			return MyResult.ok();
		}

	}

}
