package com.topia.practice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.UserInfoEdu;

@Repository
public class UserInfoEduDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		return tpl.insert("eduDao.insert", paramMap);
	}
	
	public Integer updateUserEdu(UserInfoEdu userInfoEdu) {
		return tpl.update("eduDao.updateUserEdu", userInfoEdu);
	}

	public List<UserInfoEdu> list(int intUserIdx) {
		return tpl.selectList("eduDao.list", intUserIdx);
	}
}
