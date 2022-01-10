package com.topia.practice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.UserInfoLicen;

@Repository
public class UserInfoLicenDao {

	@Autowired
	private SqlSessionTemplate tpl;
	
	public Integer insert(Map<String, Object> paramMap) {
		return tpl.insert("licenDao.insert", paramMap);
	}
	
	public Integer updateUserLicen(UserInfoLicen userInfoLicen) {
		return tpl.update("licenDao.updateUserLicen", userInfoLicen);
	}

	public List<UserInfoLicen> list(int intUserIdx) {
		return tpl.selectList("licenDao.list", intUserIdx);
	}
}
