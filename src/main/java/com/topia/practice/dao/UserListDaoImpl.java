//package com.topia.practice.dao;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//
//import com.topia.practice.dto.UserInfo;
//
//public class UserListDaoImpl {
//	
//	private SqlSession sqlsession;
//
//	public List<UserInfo> noticeList(HashMap<String, Object> map) {
//		
//		System.out.println("Dao noticeList Start...");
//		
//		List<UserInfo> list = null;
//		list = sqlsession.selectList("UserList.List", map);
//		
//		
//		return list;
//	}
//
//}
