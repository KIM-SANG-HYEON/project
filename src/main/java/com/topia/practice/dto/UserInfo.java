package com.topia.practice.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
	private Integer userIdx;
	private Date userRegisterDate;
	private String userName;
	private String userSocialSecunum;
	private String userSex;
	private String userComp;
	private Date userCompEnterdate;
	private String userDept;
	private String userSpot;
	private String userArmyServ;
	private String userMaritalStatus;
	private Date userArmyServEnter;
	private Date userArmyServLeave;
	private String userArmyServPeriod;
	private String userTelnumWired;
	private String userTelnumWireless;
	private String userEmail;
	private String userZipcode;
	private String userAddress;
	private UserInfoCareer userInfoCareer;
	private UserInfoEdu userInfoEdu;
	private UserInfoLicen userInfoLicen;
	private UserInfoQualifi userInfoQualifi;
	private UserInfoSkill userInfoSkill;
	private UserInfoTraining userInfoTraining;
	private Image image;
	private UserInfoHealth userInfoHealth;
	
	
	
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public Date getUserRegisterDate() {
		return userRegisterDate;
	}
	public void setUserRegisterDate(Date userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSocialSecunum() {
		return userSocialSecunum;
	}
	public void setUserSocialSecunum(String userSocialSecunum) {
		this.userSocialSecunum = userSocialSecunum;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserComp() {
		return userComp;
	}
	public void setUserComp(String userComp) {
		this.userComp = userComp;
	}
	public Date getUserCompEnterdate() {
		return userCompEnterdate;
	}
	public void setUserCompEnterdate(Date userCompEnterdate) {
		this.userCompEnterdate = userCompEnterdate;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserSpot() {
		return userSpot;
	}
	public void setUserSpot(String userSpot) {
		this.userSpot = userSpot;
	}
	public String getUserArmyServ() {
		return userArmyServ;
	}
	public void setUserArmyServ(String userArmyServ) {
		this.userArmyServ = userArmyServ;
	}
	public String getUserMaritalStatus() {
		return userMaritalStatus;
	}
	public void setUserMaritalStatus(String userMaritalStatus) {
		this.userMaritalStatus = userMaritalStatus;
	}
	public Date getUserArmyServEnter() {
		return userArmyServEnter;
	}
	public void setUserArmyServEnter(Date userArmyServEnter) {
		this.userArmyServEnter = userArmyServEnter;
	}
	public Date getUserArmyServLeave() {
		return userArmyServLeave;
	}
	public void setUserArmyServLeave(Date userArmyServLeave) {
		this.userArmyServLeave = userArmyServLeave;
	}
	public String getUserArmyServPeriod() {
		return userArmyServPeriod;
	}
	public void setUserArmyServPeriod(String userArmyServPeriod) {
		this.userArmyServPeriod = userArmyServPeriod;
	}
	public String getUserTelnumWired() {
		return userTelnumWired;
	}
	public void setUserTelnumWired(String userTelnumWired) {
		this.userTelnumWired = userTelnumWired;
	}
	public String getUserTelnumWireless() {
		return userTelnumWireless;
	}
	public void setUserTelnumWireless(String userTelnumWireless) {
		this.userTelnumWireless = userTelnumWireless;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserZipcode() {
		return userZipcode;
	}
	public void setUserZipcode(String userZipcode) {
		this.userZipcode = userZipcode;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public UserInfoCareer getUserInfoCareer() {
		return userInfoCareer;
	}
	public void setUserInfoCareer(UserInfoCareer userInfoCareer) {
		this.userInfoCareer = userInfoCareer;
	}
	public UserInfoEdu getUserInfoEdu() {
		return userInfoEdu;
	}
	public void setUserInfoEdu(UserInfoEdu userInfoEdu) {
		this.userInfoEdu = userInfoEdu;
	}
	public UserInfoLicen getUserInfoLicen() {
		return userInfoLicen;
	}
	public void setUserInfoLicen(UserInfoLicen userInfoLicen) {
		this.userInfoLicen = userInfoLicen;
	}
	public UserInfoQualifi getUserInfoQualifi() {
		return userInfoQualifi;
	}
	public void setUserInfoQualifi(UserInfoQualifi userInfoQualifi) {
		this.userInfoQualifi = userInfoQualifi;
	}
	public UserInfoSkill getUserInfoSkill() {
		return userInfoSkill;
	}
	public void setUserInfoSkill(UserInfoSkill userInfoSkill) {
		this.userInfoSkill = userInfoSkill;
	}
	public UserInfoTraining getUserInfoTraining() {
		return userInfoTraining;
	}
	public void setUserInfoTraining(UserInfoTraining userInfoTraining) {
		this.userInfoTraining = userInfoTraining;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public UserInfoHealth getUserInfoHealth() {
		return userInfoHealth;
	}
	public void setUserInfoHealth(UserInfoHealth userInfoHealth) {
		this.userInfoHealth = userInfoHealth;
	}
	
	
}
