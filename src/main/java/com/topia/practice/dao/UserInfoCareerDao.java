package com.topia.practice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.HomeController;
import com.topia.practice.dto.UserInfoCareer;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserInfoCareerDao {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		log.info("==================================={}",paramMap);
		return tpl.insert("careerDao.insert", paramMap);
	}
	
	public Integer updateUserCareer(UserInfoCareer userInfoCareer) {
		return tpl.update("careerDao.updateUserCareer", userInfoCareer);
	}

	public List<UserInfoCareer> list(int intUserIdx) {
		return tpl.selectList("careerDao.list", intUserIdx);
	}

}
