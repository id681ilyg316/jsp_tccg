package com.orm;

public class Tyuding
{
	private String id;
	private String xingming;
	private String dianhua;
	private String daodashi;
	
	private int chewei_id;
	private String user_id;
	private String zt;//待受理--已受理
	
	private Tchewei chewei;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getXingming() {
		return xingming;
	}


	public void setXingming(String xingming) {
		this.xingming = xingming;
	}


	public String getDianhua() {
		return dianhua;
	}


	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}


	public String getDaodashi() {
		return daodashi;
	}


	public void setDaodashi(String daodashi) {
		this.daodashi = daodashi;
	}


	public int getChewei_id() {
		return chewei_id;
	}


	public void setChewei_id(int chewei_id) {
		this.chewei_id = chewei_id;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getZt() {
		return zt;
	}


	public void setZt(String zt) {
		this.zt = zt;
	}


	public Tchewei getChewei() {
		return chewei;
	}


	public void setChewei(Tchewei chewei) {
		this.chewei = chewei;
	}
	
}
