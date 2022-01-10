package com.topia.practice.dto;

public class Image {
	private Integer imgIdx;
	private Integer userIdx;
	private String imgName;
	public Integer getImgIdx() {
		return imgIdx;
	}
	public void setImgIdx(Integer imgIdx) {
		this.imgIdx = imgIdx;
	}
	public Integer getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(Integer userIdx) {
		this.userIdx = userIdx;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	@Override
	public String toString() {
		return "Image [imgIdx=" + imgIdx + ", userIdx=" + userIdx + ", imgName=" + imgName + "]";
	}
	
}
