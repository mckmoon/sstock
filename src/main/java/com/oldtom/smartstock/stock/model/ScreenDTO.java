package com.oldtom.smartstock.stock.model;

public class ScreenDTO {
	
	private int sno;
	private String basedate;
	private int duration;
	
	private int total;
	private int ic_rate;
	private float dy_rate;
	
	private float ref_rate;
	private float ref_rate1;
	private float ref_rate2;
	private float ref_rate3;
	
	private int date_diff;
	private String gname;
	private String sign;
	
	private String holder;
	
	public String getBasedate() {
		return basedate;
	}
	public void setBasedate(String basedate) {
		this.basedate = basedate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getIc_rate() {
		return ic_rate;
	}
	public void setIc_rate(int ic_rate) {
		this.ic_rate = ic_rate;
	}
	public float getDy_rate() {
		return dy_rate;
	}
	public void setDy_rate(float dy_rate) {
		this.dy_rate = dy_rate;
	}
	public float getRef_rate() {
		return ref_rate;
	}
	public void setRef_rate(float ref_rate) {
		this.ref_rate = ref_rate;
	}
	public float getRef_rate1() {
		return ref_rate1;
	}
	public void setRef_rate1(float ref_rate1) {
		this.ref_rate1 = ref_rate1;
	}
	public float getRef_rate2() {
		return ref_rate2;
	}
	public void setRef_rate2(float ref_rate2) {
		this.ref_rate2 = ref_rate2;
	}
	public float getRef_rate3() {
		return ref_rate3;
	}
	public void setRef_rate3(float ref_rate3) {
		this.ref_rate3 = ref_rate3;
	}
	public int getDate_diff() {
		return date_diff;
	}
	public void setDate_diff(int date_diff) {
		this.date_diff = date_diff;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "ScreenDTO [sno=" + sno + ", basedate=" + basedate + ", duration=" + duration + ", total=" + total
				+ ", ic_rate=" + ic_rate + ", dy_rate=" + dy_rate + ", ref_rate=" + ref_rate + ", ref_rate1="
				+ ref_rate1 + ", ref_rate2=" + ref_rate2 + ", ref_rate3=" + ref_rate3 + ", date_diff=" + date_diff
				+ ", gname=" + gname + ", sign=" + sign + "]";
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	
	

}
