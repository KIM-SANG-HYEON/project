package com.topia.practice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.topia.practice.HomeController;
import com.topia.practice.dto.Image;
import com.topia.practice.service.PersonalHistoryServImpl;

@Controller
public class PersonalHistoryContImpl implements PersonalHistoryCont{
	
	@Autowired
	PersonalHistoryServImpl personalHistoryServ;
			
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Override
	@RequestMapping(value="/personalHistory/userList", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> userList(HttpServletRequest request) { 
		log.info("******************userList********************");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		Map<String,Object> reqMap = (Map<String, Object>) request.getParameterMap();
		HashMap<String,Object> unlockedReqMap = new HashMap<String,Object>();
		
		// 값 복사를 위한 루프
		log.info("==========reqMap=========");
		for( String key : reqMap.keySet() ){
			unlockedReqMap.put(key, reqMap.get(key));
			log.info("{}",key);
        }
		
		try {
//			for(String key: unlockedReqMap.keySet()) {
//				log.info("{}: {}",key, unlockedReqMap.get(key));
//			}
			resultMap = (HashMap<String, Object>)personalHistoryServ.userList(unlockedReqMap);
		} catch (Exception e) {
			System.out.println("ERROR PersonalHistoryServImpl : " + e);
		}
		for( String key : resultMap.keySet() ){
			log.info("{}",key);
        }
		return resultMap;
		
	}
	
	@Override
	@RequestMapping(value="/personalHistory/registerUser", method=RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> registerUser(HttpServletRequest request) {
		log.info("******************registerUser********************");
		// getParameterMap()으로 추출한 맵 객체는 readonly 상태이기 때문에
		// 사용 가능하도록 새로운 맵을 생성하여 값을 복사한다
		Map<String,Object> reqMap = (Map<String, Object>)request.getParameterMap();
		HashMap<String,Object> unlockedReqMap = new HashMap<String,Object>();
		HashMap<String,Object> resMap = new HashMap<String,Object>();
		
		// 값 복사를 위한 루프
		for( String key : reqMap.keySet() ){
			unlockedReqMap.put(key, reqMap.get(key));
			log.info("{} , {}",key, reqMap.get(key));
        }
		
		try {
			resMap = personalHistoryServ.registerUser(unlockedReqMap);
		} catch (Exception e) {
			System.out.println("ERROR registerUser : " + e);
		}
		log.info("==============CONTROLLER RESMAP: {}",resMap);
		return resMap;
	}
	
	@Override
	@RequestMapping(value="/personalHistory/registerUserUpdate", method=RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> registerUserUpdate(HttpServletRequest request) {
		log.info("******************registerUserUpdate********************");
		// getParameterMap()으로 추출한 맵 객체는 readonly 상태이기 때문에
		// 사용 가능하도록 새로운 맵을 생성하여 값을 복사한다
		Map<String,Object> reqMap = (Map<String, Object>)request.getParameterMap();
		HashMap<String,Object> unlockedReqMap = new HashMap<String,Object>();
		HashMap<String,Object> resMap = new HashMap<String,Object>();
		
		// 값 복사를 위한 루프
		for( String key : reqMap.keySet() ){
			unlockedReqMap.put(key, reqMap.get(key));
        }
		
		try {
			personalHistoryServ.registerUserUpdate(unlockedReqMap);
			String userIdx = (String)unlockedReqMap.get("userIdx");
			resMap.put("userIdx",userIdx);
		} catch (Exception e) {
			System.out.println("ERROR registerUserUpdate : " + e);
		}
				
		
		return resMap;
	}
	
	/**
	 * 등록된 데이터 가져오기
	 * 
	 * map -> string,array strng은 고정변수의 값들 key, val 형태로 그냥 받고
	 * 유동변수들은 key 테이블명 : val array 형태 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Override
	@RequestMapping(value="/personalHistory/getRegisterData", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> getRegisterData(HttpServletRequest request, HttpServletResponse response,Model model) throws JsonParseException, JsonMappingException, IOException {
		log.info("******************getRegisterData********************");
		Map<String,Object> reqMap = (Map<String, Object>)request.getParameterMap();
		
		HashMap<String, Object> resMap = personalHistoryServ.getRegisterData(reqMap);
		
		System.out.println("키 테스트 : ");
		
		for(String key : resMap.keySet()) {
			
			log.info("키 테스트 : {}",key);
		}
		
		System.out.println("값 테스트 : ");
		
		for(Object val : resMap.values()) {

			log.info("값 테스트 : {}",val);
			System.out.print(","+val);
		}
		
		
		return resMap;
	}
	
	@Override
	@RequestMapping(value = "/personalHistory/imgInsert", method=RequestMethod.POST)
	@ResponseBody
	public int imgInsert(MultipartFile file, String userName, Image image) throws IllegalStateException, IOException {
		log.info("*******************/imgInsert************************");
		return personalHistoryServ.imgInsert(file,userName,image);
	}
	
	@Override
	@RequestMapping(value = "/personalHistory/imgUpdate", method=RequestMethod.POST)
	@ResponseBody
	public int imgUpdate(MultipartFile file, String userName,Image image) throws IllegalStateException, IOException {
		log.info("*******************/imgUpdate************************");
		return personalHistoryServ.imgUpdate(file,userName,image);
	}
	
	@RequestMapping(value = "/personalHistory/getUserImg/{userIdx}", method=RequestMethod.GET)
	@ResponseBody
	public Image getUserImg(@PathVariable Integer userIdx) {
		log.info("*******************/getUserImg************************");
		return personalHistoryServ.getUserImg(userIdx);
	}
	
	@RequestMapping(value = "/personalHistory/getUserCountByCareerDate", method=RequestMethod.GET)
	@ResponseBody
	public List<String> getUserCountByCareerDate(){
		return personalHistoryServ.getUserCountByCareerDate();
	}
	
	@RequestMapping(value="/personalHistory/downexcel.do", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> downExcel() throws JsonParseException, JsonMappingException, IOException {
		log.info("******************ExcelDown********************");
		HashMap<String, Object> resMap = personalHistoryServ.excelDownload();
		
		return resMap;
	}
	
	
	
}
