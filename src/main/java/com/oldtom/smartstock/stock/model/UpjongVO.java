package com.oldtom.smartstock.stock.model;

import java.text.NumberFormat;

public class UpjongVO {


	private String basedate;	// query input parameter
	private int duration;		// query input parameter
	private String gubun;			
	private String sign;		// query input parameter		
	
	private String date;
	private String upcode;
	private String upname;
	private int close;
	private int volume;
	private float vol_diff_rate;
	private float diff_rate;
	private float du_diff_rate;		// 기간 업봉주가 변화율
	public String getBasedate() {
		return basedate;
	}
	public int getDuration() {
		return duration;
	}
	public String getGubun() {
		return gubun;
	}
	public String getSign() {
		return sign;
	}
	public String getDate() {
		return date;
	}
	public String getUpcode() {
		return upcode;
	}
	public String getUpname() {
		return upname;
	}
	public int getClose() {
		return close;
	}
	public String getVolume() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(volume);
	}
	public float getVol_diff_rate() {
		return (float) (Math.round(vol_diff_rate*100)/100.0);
	}
	public float getDiff_rate() {
		return (float) (Math.round(diff_rate*100)/100.0);
	}
	public float getDu_diff_rate() {
		return (float) (Math.round(du_diff_rate*100)/100.0);
	}
	public void setBasedate(String basedate) {
		this.basedate = basedate;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setUpcode(String upcode) {
		this.upcode = upcode;
	}
	public void setUpname(String upname) {
		this.upname = upname;
	}
	public void setClose(int close) {
		this.close = close;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void setVol_diff_rate(float vol_diff_rate) {
		this.vol_diff_rate = vol_diff_rate;
	}
	public void setDiff_rate(float diff_rate) {
		this.diff_rate = diff_rate;
	}
	public void setDu_diff_rate(float du_diff_rate) {
		this.du_diff_rate = du_diff_rate;
	}
	
	

}
