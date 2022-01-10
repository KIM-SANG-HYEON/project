package com.topia.practice.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.topia.practice.dto.Image;

@Repository
public class ImageDao {
	@Autowired
	private SqlSessionTemplate tpl;
	
	public int imgInsert(Image image) {
		return tpl.insert("personalHistory.imgInsert", image);
	}
	
	public int imgInsert2(Image image) { 
		return tpl.insert("personalHistory.imgInsert2", image);
	}
	
	public int imgUpdate(Image image) {
		return tpl.update("personalHistory.imgUpdate", image);
	}
	
	public Image getUserImg(Integer userIdx) {
		return tpl.selectOne("personalHistory.getUserImg", userIdx);
	}

	
}
