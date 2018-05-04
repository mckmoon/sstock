package com.oldtom.smartstock.stock.model;

import java.text.NumberFormat;

public class StockVO {


	private String basedate;	// query input parameter
	private String startdate;	// query input parameter
	private int duration;		// query input parameter
	private String targetdate; 	// query input parameter
	private int count;			// query input parameter
	private String sign;		// query input parameter		
	private float rateM;		// temporary query input parameter
	private float rateK;		// temporary query input parameter
	
	private String date;
	private String shcode;				// ���� �ڵ�
	private String hname;				// �����
	private String upcode;				// �Ҽ� �����ڵ�
	private String upname;				// �Ҽ� ������
	private int total;					// �ð��Ѿ�
	private int price;					// ����
	private int volume;					// �ŷ���
	private float diff_rate;			// ���ϴ�� �ְ�������
	private float vol_diff_rate;		// ���ϴ�� �ŷ���������
	private int sales;					// ������
	private float ic_rate;				// �ֱٿ��� ��������
	private float dy_rate;				// �ð�����
	private float f_rate;				// ���κ�����
	private float sep_rate;				// �̰ݷ�
	private float sy_rate;				// �ſ��ܰ���
	private float gm_rate;				// ���ŵ� �ŷ�����
	private float jong_diff_rate;		// �������� ���ϴ�� ������
	
	private float per;						// PBR(��)
	private float pbr;						// PBR(��)
	private float psr;						// PSR(��)
	private float spc;						// SPC(��)
	private float cr_rate;				// �ں� ������
	
	private float du_diff_rate;			// �Ⱓ �ְ� ������
	private int targetprice;			// ��ǥ���� ����
	private float tgt_diff_rate;		// base-target diff rate
	private int notice;					// �ֱ� 6���� ���� ���� ���� ����
	

	private int avg_price;
	private int min_price;
	private int max_price;
	
	private String holder;		// main holder
	
	private float macd;
	private float rsi;
	private float slowd;

	private float rate;
	private float rate1;
	private float rate2;




	public String getBasedate() {
		return basedate;
	}
	public void setBasedate(String basedate) {
		this.basedate = basedate;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
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
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getShcode() {
		return shcode;
	}
	public void setShcode(String shcode) {
		this.shcode = shcode;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}

	public String getTotal() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(total);
		
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPrice() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(price);
	}
	public int getPrice1() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getIc_rate() {
		return ic_rate;
	}
	public void setIc_rate(float ic_rate) {
		this.ic_rate = ic_rate;
	}
	public float getDy_rate() {
		return dy_rate;
	}
	public void setDy_rate(float dy_rate) {
		this.dy_rate = dy_rate;
	}


	
	public int getAvg_price() {
		return avg_price;
	}
	public void setAvg_price(int avg_price) {
		this.avg_price = avg_price;
	}
	
	public String getVolume() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(volume);
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getUpname() {
		return upname;
	}
	public void setUpname(String upname) {
		this.upname = upname;
	}


	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getTargetdate() {
		return targetdate;
	}
	public void setTargetdate(String targetdate) {
		this.targetdate = targetdate;
	}
	public int getCount() {
		return count;
	}
	public float getMacd() {
		return macd;
	}
	public float getRsi() {
		return rsi;
	}
	public float getSlowd() {
		return slowd;
	}

	public void setCount(int count) {
		this.count = count;
	}
	public void setMacd(float macd) {
		this.macd = macd;
	}
	public void setRsi(float rsi) {
		this.rsi = rsi;
	}
	public void setSlowd(float slowd) {
		this.slowd = slowd;
	}

	public int getMax_price() {
		return max_price;
	}
	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}
	public int getMin_price() {
		return min_price;
	}
	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public float getRateM() {
		return rateM;
	}
	public void setRateM(float rateM) {
		this.rateM = rateM;
	}
	public float getRateK() {
		return rateK;
	}
	public void setRateK(float rateK) {
		this.rateK = rateK;
	}

	public float getRate1() {
		return (float) (Math.round(rate1*100)/100.0);
	}
	public void setRate1(float rate1) {
		this.rate1 = rate1;
	}
	public float getRate2() {
		return (float) (Math.round(rate2*100)/100.0);
	}
	public void setRate2(float rate2) {
		this.rate2 = rate2;
	}
	public float getRate() {
		
		return (float) (Math.round(rate*100)/100.0);
	}
	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getTargetprice() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(targetprice);
	}
	public int getTargetprice1() {
		return targetprice;
	}
	public void setTargetprice(int targetprice) {
		this.targetprice = targetprice;
	}

	public String getSales() {
		NumberFormat nf = NumberFormat.getInstance();

		return nf.format(sales);
		
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getUpcode() {
		return upcode;
	}
	public void setUpcode(String upcode) {
		this.upcode = upcode;
	}
	public float getVol_diff_rate() {
		return (float) (Math.round(vol_diff_rate*100)/100.0);
		//return vol_diff_rate;
	}
	public void setVol_diff_rate(float vol_diff_rate) {
		this.vol_diff_rate = vol_diff_rate;
	}
	public float getDiff_rate() {
		return (float) (Math.round(diff_rate*100)/100.0);
		//return diff_rate;
	}
	public void setDiff_rate(float diff_rate) {
		this.diff_rate = diff_rate;
	}
	public float getTgt_diff_rate() {
		return (float) (Math.round(tgt_diff_rate*100)/100.0);
	}
	public void setTgt_diff_rate(float tgt_diff_rate) {
		this.tgt_diff_rate = tgt_diff_rate;
	}
	public int getNotice() {
		return notice;
	}
	public void setNotice(int notice) {
		this.notice = notice;
	}
	public float getDu_diff_rate() {
		return (float) (Math.round(du_diff_rate*100)/100.0);
	}
	public void setDu_diff_rate(float du_diff_rate) {
		this.du_diff_rate = du_diff_rate;
	}
	public float getF_rate() {
		return f_rate;
	}
	public float getSep_rate() {
		return sep_rate;
	}
	public float getSy_rate() {
		return sy_rate;
	}
	public float getGm_rate() {
		return gm_rate;
	}
	public float getJong_diff_rate() {
		return jong_diff_rate;
	}
	public float getPer() {
		return per;
	}
	public float getPbr() {
		return pbr;
	}
	public float getPsr() {
		return psr;
	}
	public float getSpc() {
		return spc;
	}
	public float getCr_rate() {
		return cr_rate;
	}
	public void setF_rate(float f_rate) {
		this.f_rate = f_rate;
	}
	public void setSep_rate(float sep_rate) {
		this.sep_rate = sep_rate;
	}
	public void setSy_rate(float sy_rate) {
		this.sy_rate = sy_rate;
	}
	public void setGm_rate(float gm_rate) {
		this.gm_rate = gm_rate;
	}
	public void setJong_diff_rate(float jong_diff_rate) {
		this.jong_diff_rate = jong_diff_rate;
	}
	public void setPer(float per) {
		this.per = per;
	}
	public void setPbr(float pbr) {
		this.pbr = pbr;
	}
	public void setPsr(float psr) {
		this.psr = psr;
	}
	public void setSpc(float spc) {
		this.spc = spc;
	}
	public void setCr_rate(float cr_rate) {
		this.cr_rate = cr_rate;
	}


	
}
