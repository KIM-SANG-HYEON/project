package com.topia.practice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.UserInfoSkill;

@Repository
public class UserInfoSkillDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		return tpl.insert("skillDao.insert", paramMap);
	}
	
	public Integer updateUserSkill(UserInfoSkill userInfoSkill) {
		return tpl.update("skillDao.updateUserSkill", userInfoSkill);
	}

	public List<UserInfoSkill> list(int intUserIdx) {
		return tpl.selectList("skillDao.list", intUserIdx);
	}
}
