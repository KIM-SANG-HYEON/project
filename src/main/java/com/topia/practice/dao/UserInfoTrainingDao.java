package com.topia.practice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.UserInfoTraining;

@Repository
public class UserInfoTrainingDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		return tpl.insert("trainingDao.insert", paramMap);
	}
	
	public Integer updateUserTraining(UserInfoTraining userInfoTraining) {
		return tpl.update("trainingDao.updateUserTraining", userInfoTraining);
	}

	public List<UserInfoTraining> list(int intUserIdx) {
		return tpl.selectList("trainingDao.list", intUserIdx);
	}
}
