package com.oldtom.smartstock.stock.model;

import java.text.NumberFormat;

public class FinanceVO {
	private String basedate;							// query input parameter
	private String basedate1;
	private String basedate2;
	private String basedate3;

	
	private int sales;									// query input parameter, 매출액(억)
	private float op_profit_rate;						// query input parameter, 영업이익률
	private float debt_rate;							// query input parameter, 부채비율
	private float roe;									// query input parameter, roe
	private float cash_divided_yield_rate;				// query input parameter, 현금배당수익률
	
	private int duration;								// query input parameter, 연속기간
	private float rate;									// query input parameter, 매출액 개선율
	private float rate1;								// query input parameter, 영업이익 개선율
	private float rate2;								// query input parameter, 부채 개선율
	
	private String	shcode;
	private String hname;

	private String date;
	private int op_profit;					// 영업이익
	private int net_income;					// 당기순이익
	
	private int op_cash_flow;				// 영업활동현금흐름
	private int fcf;						// FCF (슌현금흐름)
	private float roa;						// ROA
	private float capital_reserve_rate;		// 자본유보율
	private float per;						// PBR(배)
	private float pbr;						// PBR(배)
	
	public String getBasedate() {
		return basedate;
	}
	public String getSales() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(sales);
		
	}
	
	public float getOp_profit_rate() {
		return op_profit_rate;
	}
	public float getDebt_rate() {
		return debt_rate;
	}
	public float getRoe() {
		return roe;
	}
	public float getCash_divided_yield_rate() {
		return cash_divided_yield_rate;
	}
	public String getDate() {
		return date.substring(0, 7);
	}

	public String getOp_profit() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(op_profit);
		
	}	

	public String getNet_income() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(net_income);
		
	}
	
	public String getOp_cash_flow() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(op_cash_flow);
		
	}	
	
	public String getFcf() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(fcf);
		
	}	

	public float getRoa() {
		return roa;
	}
	public float getCapital_reserve_rate() {
		return capital_reserve_rate;
	}
	public float getPer() {
		return per;
	}
	public float getPbr() {
		return pbr;
	}

	
	
	public String getBasedate1() {
		return basedate1;
	}
	public String getBasedate2() {
		return basedate2;
	}
	public String getBasedate3() {
		return basedate3;
	}

	public void setBasedate(String basedate) {
		this.basedate = basedate;
	}
	public void setBasedate1(String basedate1) {
		this.basedate1 = basedate1;
	}
	public void setBasedate2(String basedate2) {
		this.basedate2 = basedate2;
	}
	public void setBasedate3(String basedate3) {
		this.basedate3 = basedate3;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
	public void setOp_profit_rate(float op_profit_rate) {
		this.op_profit_rate = op_profit_rate;
	}
	public void setDebt_rate(float debt_rate) {
		this.debt_rate = debt_rate;
	}
	public void setRoe(float roe) {
		this.roe = roe;
	}
	public void setCash_divided_yield_rate(float cash_divided_yield_rate) {
		this.cash_divided_yield_rate = cash_divided_yield_rate;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setOp_profit(int op_profit) {
		this.op_profit = op_profit;
	}
	public void setNet_income(int net_income) {
		this.net_income = net_income;
	}
	public void setOp_cash_flow(int op_cash_flow) {
		this.op_cash_flow = op_cash_flow;
	}
	public void setFcf(int fcf) {
		this.fcf = fcf;
	}
	public void setRoa(float roa) {
		this.roa = roa;
	}
	public void setCapital_reserve_rate(float capital_reserve_rate) {
		this.capital_reserve_rate = capital_reserve_rate;
	}
	public void setPer(float per) {
		this.per = per;
	}
	public void setPbr(float pbr) {
		this.pbr = pbr;
	}
	
	public String getShcode() {
		return shcode;
	}
	public String getHname() {
		return hname;
	}
	public void setShcode(String shcode) {
		this.shcode = shcode;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	
	
	public float getRate() {
		return rate;
	}
	public float getRate1() {
		return rate1;
	}
	public float getRate2() {
		return rate2;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public void setRate1(float rate1) {
		this.rate1 = rate1;
	}
	public void setRate2(float rate2) {
		this.rate2 = rate2;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDuration1() {
		return duration-1;
	}
	public int getDuration2() {
		return duration-2;
	}
	@Override
	public String toString() {
		return "FinanceVO [basedate=" + basedate + ", basedate1=" + basedate1 + ", basedate2=" + basedate2
				+ ", basedate3=" + basedate3 + ", sales=" + sales + ", op_profit_rate=" + op_profit_rate
				+ ", debt_rate=" + debt_rate + ", roe=" + roe + ", cash_divided_yield_rate=" + cash_divided_yield_rate
				+ ", duration=" + duration + ", rate=" + rate + ", rate1=" + rate1 + ", rate2=" + rate2 + "]";
	}	
	
	
}
