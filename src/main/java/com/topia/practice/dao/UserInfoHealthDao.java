package com.topia.practice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.UserInfoHealth;

@Repository
public class UserInfoHealthDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		return tpl.insert("healthDao.insert", paramMap);
	}
	
	public Integer updateUserHealth(UserInfoHealth userInfoHealth) {
		return tpl.update("healthDao.updateUserHealth", userInfoHealth);
	}

	public List<UserInfoHealth> list(int intUserIdx) {
		return tpl.selectList("healthDao.list", intUserIdx);
	}
}
