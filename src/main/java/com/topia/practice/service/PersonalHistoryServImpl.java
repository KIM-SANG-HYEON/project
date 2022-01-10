package com.topia.practice.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.topia.practice.HomeController;
import com.topia.practice.dao.AbstractDAO;
import com.topia.practice.dao.ImageDao;
import com.topia.practice.dao.UserInfoCareerDao;
import com.topia.practice.dao.UserInfoEduDao;
import com.topia.practice.dao.UserInfoHealthDao;
import com.topia.practice.dao.UserInfoLicenDao;
import com.topia.practice.dao.UserInfoQualifiDao;
import com.topia.practice.dao.UserInfoSkillDao;
import com.topia.practice.dao.UserInfoTrainingDao;
import com.topia.practice.dto.Image;
import com.topia.practice.dto.UserInfoHealth;
import com.topia.practice.util.Sha256;

@Service
public class PersonalHistoryServImpl implements PersonalHistoryServ {

	@Autowired
	AbstractDAO dbCon;
	@Autowired
	private UserInfoCareerDao cDao;
	@Autowired
	private UserInfoEduDao eDao;
	@Autowired
	private UserInfoLicenDao lDao;
	@Autowired
	private UserInfoQualifiDao qDao;
	@Autowired
	private UserInfoSkillDao sDao;
	@Autowired
	private UserInfoTrainingDao tDao;
	@Autowired
	private ImageDao imgDao;
	@Autowired
	private UserInfoHealthDao hDao;
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Override
	/**
	 * 기존 등록된 개인 이력카드 가져오기
	 */
	public HashMap<String, Object> userList(HashMap<String, Object> reqMap) {
		log.info("SERVICE==========ReqMap=========");
//		for(String key: reqMap.keySet()) {
//			log.info("{}: {}",key, reqMap.get(key));
//		}
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		ArrayList<Object> list;
		String totalCnt = "";
		String userCareerLength = ((String[]) reqMap.get("userCareerLength"))[0];
		//String userGender = ((String[]) reqMap.get("userGender"))[0];
		String userGender = "";
		String keywords = ((String[]) reqMap.get("keywords"))[0];
		try {
			
			 if (userCareerLength.equals("")) {
				  userCareerLength = null;
				  reqMap.put("userCareerLength", userCareerLength);
			 }
			 
			 if (keywords.equals("")) {
				 keywords = null;
				 reqMap.put("keywords", keywords);
			}else {
				reqMap.put("keywords", keywords.split(","));
			}
			
			if (!userGender.equals("")) {
				userGender = ((String[]) reqMap.get("userGender"))[0];
				reqMap.put("userGender", userGender);
			}
			
			for(String key: reqMap.keySet()) {
				log.info("{}: {}",key, reqMap.get(key));
			}
			
	
			list = (ArrayList<Object>) dbCon.selectList("personalHistory.userList", reqMap);
			totalCnt = String.valueOf(dbCon.selectOne("personalHistory.userListCount", reqMap));
			
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
			
			resMap.put("list", list);
			resMap.put("totalCnt", totalCnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("==================={}", resMap);
		return resMap;
	}

	/**
	 * 새로 작성한 개인 이력카드 등록
	 * 
	 * @param Object inputdata : map 형태의 고정데이터와 json string 형태의 유동데이터 포함
	 * @return statusNum 등록 성공여부
	 */
	@Override
	@Transactional
	public HashMap<String, Object> registerUser(Object inputdata) {

		int statusNum = 0;
		HashMap<String, Object> resMap = new HashMap<String, Object>();

		try {

			HashMap<String, Object> map = (HashMap<String, Object>) inputdata;
			String socialNum = ((String[]) map.get("userSocialSecunum"))[0]; // 주민등록번호 암호화

			String encodedSocialNum = Sha256.encrypt(socialNum);

			map.replace("userSocialSecunum", encodedSocialNum);

			// ------------------------------------ 중복 여부 확인

			ArrayList<Object> duplitedList = (ArrayList<Object>) dbCon.selectList("personalHistory.findDuplitedUserInfo", map);

			System.out.println("size : " + duplitedList.size());

			// ------------------------------------ 중복 여부 확인
			if (duplitedList.size() > 0) {

				resMap.put("errorCode", "1001");
				resMap.put("errorMsg", "중복된 사용자입니다.");

				return resMap; // 중복일 경우 에러코드 리턴
			} else {
				statusNum = (Integer) dbCon.insert("personalHistory.registerUser", map);
				// 유동형 데이터 json String -> ArrayList<HashMap<String, Object>> parsing

				String[] strList = (String[]) map.get("flexibleData");
				String listJsonStr = strList[0];

				int userIdx = (Integer) map.get("userIdx"); // 고정 데이터로 등록된 pk를 유동데이터의 fk로 사용
				log.info("=======================userIdx{}", userIdx);
				
				
				ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
				ObjectMapper mapper = new ObjectMapper();
				list = mapper.readValue(listJsonStr, ArrayList.class);

				log.info("=======================list{}", list);

				for (int i = 0; i < list.size(); i++) {
					String key = (String) list.get(i).get("tbName");
					
					Map<String, Object> paramMap = new HashMap<String, Object>();
					paramMap.putAll(list.get(i));
					paramMap.put("userIdx",userIdx);
					
					if(key.equals("edu")) {
						eDao.insert(paramMap);
					}else if(key.equals("qualifi")) {
						qDao.insert(paramMap);
					}else if(key.equals("career")) {
						cDao.insert(paramMap);
					}else if(key.equals("training")) {
						tDao.insert(paramMap);
					}else if(key.equals("licen")) {
						lDao.insert(paramMap);
					}else if(key.equals("skill")) {
						sDao.insert(paramMap);
					}else if(key.equals("health")) {
						hDao.insert(paramMap);
					}
				
				}
				
				resMap.put("userIdx", userIdx);

			}

		} catch (Exception e) {
			System.out.println("ERROR registerUserDAOImpl : " + e);
			e.printStackTrace();
		}
		log.info("============SERVICE RESMAP:{}",resMap);
		return resMap;
	}

	/**
	 * 기존 개인이력카드 등록건에 대한 수정처리
	 * 
	 * @HashMap<String,Object> inputdata : map 형태의 고정데이터와 json string 형태의 유동데이터 포함
	 * 
	 * @return statusNum 등록 성공여부
	 */
	@Override
	public int registerUserUpdate(HashMap<String, Object> inputdata) {

		int statusNum = 0;

		try {
			statusNum = (Integer) dbCon.update("personalHistory.registerUserUpdate", inputdata);

			String[] strList = (String[]) inputdata.get("flexibleData");
			String listJsonStr = strList[0];

			String[] userIdxArr = (String[]) inputdata.get("userIdx");
			String userIdx = userIdxArr[0];

			inputdata.replace("userIdx", userIdx);

			ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			ObjectMapper mapper = new ObjectMapper();
			list = mapper.readValue(listJsonStr, ArrayList.class);

			// 유동데이터 삭제처리
			// 수정건에 대해서만 로직처리로 변경하면 좋을것
			// 현재 로직 : 고정데이터 업데이트, 유동데이터 전체삭제 후 재등록
			dbCon.delete("personalHistory.deleteCareerData", inputdata);
			dbCon.delete("personalHistory.deleteEduData", inputdata);
			dbCon.delete("personalHistory.deleteLicenData", inputdata);
			dbCon.delete("personalHistory.deleteQualifiData", inputdata);
			dbCon.delete("personalHistory.deleteSkillData", inputdata);
			dbCon.delete("personalHistory.deleteTrainingData", inputdata);
			dbCon.delete("personalHistory.deleteHealthData", inputdata);

			// 유동데이터 재등록
			for (int i = 0; i < list.size(); i++) {
				String key = (String) list.get(i).get("tbName");
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.putAll(list.get(i));
				paramMap.put("userIdx",userIdx);
				
				if(key.equals("edu")) {
					eDao.insert(paramMap);
				}else if(key.equals("qualifi")) {
					qDao.insert(paramMap);
				}else if(key.equals("career")) {
					cDao.insert(paramMap);
				}else if(key.equals("training")) {
					tDao.insert(paramMap);
				}else if(key.equals("licen")) {
					lDao.insert(paramMap);
				}else if(key.equals("skill")) {
					sDao.insert(paramMap);
				}else if(key.equals("health")) {
					hDao.insert(paramMap);
				}
			
			}

		} catch (Exception e) {
			System.out.println("ERROR registerUserDAOImpl : " + e);
		}

		return statusNum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getRegisterData(Map<String, Object> reqMap)
			throws JsonParseException, JsonMappingException, IOException {
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		log.info("SERVICE==========ReqMap=========");
		for(String key: reqMap.keySet()) {
			log.info("{}: {}",key, reqMap.get(key));
		}
		String[] strList = (String[]) reqMap.get("tbNames");
		String listJsonStr = strList[0];
		String[] userIdxList = (String[]) reqMap.get("userIdx");
		String userIdx = userIdxList[0];

		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		ObjectMapper mapper = new ObjectMapper();
		list = mapper.readValue(listJsonStr, ArrayList.class);
		log.info("=======================LIST{}",list);
		// ---------------------------------------- 고정 컬럼 데이터 처리
		HashMap<String, Object> fixedMap = new HashMap<String, Object>();

		fixedMap.put("userIdx", userIdx);

		for(String key : fixedMap.keySet()) {
			log.info("관련 키 테스트 :--------: {}",key);
		}
		
		ArrayList<Object> arr = (ArrayList<Object>) dbCon.selectList("personalHistory.getRegisterData", fixedMap);
		
		System.err.println("selectList dbcon 배열 : "+arr);
		
		resMap.put("fixedData", arr);
		
		int intUserIdx = Integer.parseInt(userIdx);
		
		resMap.put("edu", eDao.list(intUserIdx));
		resMap.put("qualifi", qDao.list(intUserIdx));
		resMap.put("career", cDao.list(intUserIdx));
		resMap.put("training", tDao.list(intUserIdx));
		resMap.put("licen", lDao.list(intUserIdx));
		resMap.put("skill", sDao.list(intUserIdx));
		resMap.put("health", hDao.list(intUserIdx));
		
		System.out.println("health 확인 : " + resMap.get("health"));

		return resMap;
	}

	@Override
	public int imgInsert(MultipartFile file, String userName, Image image) throws IllegalStateException, IOException {
		String path = "D:\\Spring\\practice\\src\\main\\webapp\\resources\\upload";
		log.info("+-----OriginalFilename------+");
		log.info("{}", file.getOriginalFilename());
		log.info("+---------------------------+");

		int lastOfDot = file.getOriginalFilename().lastIndexOf(".");

		String extention = file.getOriginalFilename().substring(lastOfDot + 1);

		String savedName = userName + "." + extention;

		log.info(savedName);
		File picture = new File(path, savedName);
		file.transferTo(picture);
		image.setImgName(savedName);
		return imgDao.imgInsert(image);
	}

	@Override
	public int imgUpdate(MultipartFile file, String userName, Image image) throws IllegalStateException, IOException {
		String path = "D:\\Spring\\practice\\src\\main\\webapp\\resources\\upload";
		log.info("+-----OriginalFilename------+");
		log.info("FILE :{}", file);
		log.info("{}", file.getOriginalFilename());
		log.info("+---------------------------+");
		
		int lastOfDot = file.getOriginalFilename().lastIndexOf(".");

		String extention = file.getOriginalFilename().substring(lastOfDot + 1);

		String savedName = userName + "." + extention;

		log.info("저장할 이름 :{}",savedName);
		File picture = new File(path, savedName);
		file.transferTo(picture);
		image.setImgName(savedName);
		
		int userIdx = image.getUserIdx();
		Image result = imgDao.getUserImg(userIdx);	// 이미지를 조회해서
		if(result==null) {							// 결과가 null이면
			return imgDao.imgInsert2(image);		// 수정이 아니라 삽입을 해준다
													// return값 imgInsert2로 호출 imgInsert --> imgInsert2로 변경
		}
		return imgDao.imgUpdate(image);
	}

	public Image getUserImg(Integer userIdx) {
		return imgDao.getUserImg(userIdx);
	}

	public List<String> getUserCountByCareerDate() {
		return dbCon.selectList("personalHistory.getUserCountByCareerDate");
	}
	
	public HashMap<String, Object> excelDownload(){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<HashMap<String,Object>> list = (List<HashMap<String,Object>>) dbCon.selectList("personalHistory.getinfo");
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row;
		HSSFCell cell;
		// 키값 확인
		for(String key: list.get(0).keySet()) {
			System.out.println(key);
		}
		
		if(list.size()>0) {
			
			for(int i=0;i<list.size();i++) {
				row=sheet.createRow(i);
				cell=row.createCell(0);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_IDX")));
				cell=row.createCell(1);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_NAME")));
				cell=row.createCell(2);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_COMP")));
				cell=row.createCell(3);
				cell.setCellValue(String.valueOf(list.get(i).get("USERREGISTERDATE")));
				cell=row.createCell(4);
				cell.setCellValue(String.valueOf(list.get(i).get("USER_SEX")));
				cell=row.createCell(5);
				cell.setCellValue(String.valueOf(list.get(i).get("CAREER_DATE")));
				
				
			}
			
			File file = new File("C:\\test\\testWrite.xls");
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileOutputStream fos = null;
			
			try {
				fos = new FileOutputStream(file);
				workbook.write(fos);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(workbook != null) workbook.close();
					if(fos != null) fos.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			map.put("success", "Y");
		}else {
			map.put("success", "N");
		}
		
		return map;
	}
	
	
}
