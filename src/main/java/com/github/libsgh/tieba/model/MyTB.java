package com.github.libsgh.tieba.model;

import java.util.Date;

/**
 * 我喜欢的贴吧
 * @author libs
 * 2018-4-8
 */
public class MyTB {
	
	private String error_code;//错误码
	
	private int fid;//贴吧id
	
	private String tbName;//贴吧名称
	
	private String url;//地址
	
	private int ex;//经验
	
	private int lv;//等级
	
	private String lvName;//等级名称
	
	private String exp;//签到获取的经验值
	
	private Date signTime;//签到时间
	
	private int countSignNum;//签到次数
	
	private String error_msg;//错误信息
	
	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getTbName() {
		return tbName;
	}

	public void setTbName(String tbName) {
		this.tbName = tbName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getEx() {
		return ex;
	}

	public void setEx(int ex) {
		this.ex = ex;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public String getLvName() {
		return lvName;
	}

	public void setLvName(String lvName) {
		this.lvName = lvName;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	public int getCountSignNum() {
		return countSignNum;
	}

	public void setCountSignNum(int countSignNum) {
		this.countSignNum = countSignNum;
	}

}
