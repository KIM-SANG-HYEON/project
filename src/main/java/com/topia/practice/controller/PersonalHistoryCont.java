package com.topia.practice.controller;

// test
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.topia.practice.dto.Image;

public interface PersonalHistoryCont {
	public HashMap<String, Object> userList(HttpServletRequest request);
	public HashMap<String,Object> registerUser(HttpServletRequest request);
	public HashMap<String,Object> registerUserUpdate(HttpServletRequest request);
	public int imgInsert(MultipartFile file, String userName, Image image) throws IllegalStateException, IOException;
	HashMap<String, Object> getRegisterData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws JsonParseException, JsonMappingException, IOException;
	int imgUpdate(MultipartFile file, String userName, Image image) throws IllegalStateException, IOException;
}
