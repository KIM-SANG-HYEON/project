//package com.topia.practice.controller;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.topia.practice.dto.UserInfo;
//import com.topia.practice.service.UserListService;
//
//@Controller
//public class UserListController {
//
//		
//	@Autowired
//	private UserListService us;
//	
//	//개인 이력 목록 
//	@RequestMapping(value="/userList" , method = RequestMethod.GET)
//	public String userSelect(UserInfo userinfo , Model model) {
//		
//		System.out.println("UserListController userSelect Start...");
//		
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		 
//		List<UserInfo> noticeList = us.noticeList(map);
//		
//		model.addAttribute("notice",noticeList);
//		
//		
//		return "list";
//		
//	}
//	
//	
	
//}
