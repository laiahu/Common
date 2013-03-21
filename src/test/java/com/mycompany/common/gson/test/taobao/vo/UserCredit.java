package com.mycompany.common.gson.test.taobao.vo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class UserCredit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4852986254172099211L;
	
	private int level;
	
	private int score;
	
	@SerializedName("total_num")
	private int totalNum;
	
	@SerializedName("good_num")
	private int goodNum;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	
	
}
