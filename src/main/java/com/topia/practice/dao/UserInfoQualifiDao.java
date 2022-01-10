package com.topia.practice.dao;


import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.UserInfoQualifi;


@Repository
public class UserInfoQualifiDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		return tpl.insert("qualifiDao.insert",paramMap);
	}
	
	public Integer updateUserQulifi(UserInfoQualifi userInfoQualifi) {
		return tpl.update("qualifiDao.updateUserQulifi", userInfoQualifi);
	}

	public List<UserInfoQualifi> list(int intUserIdx) {
		return tpl.selectList("qualifiDao.list", intUserIdx);
	}
}
