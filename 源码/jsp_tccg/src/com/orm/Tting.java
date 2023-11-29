package com.orm;

public class Tting
{
	private int id;
	private int chewei_id;
	private String chexing;
	private String chepai;
	
	private String kaishishijian;
	private String jieshushijian;
	private int feiyong;
	
	private Tchewei chewei;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChewei_id() {
		return chewei_id;
	}
	public void setChewei_id(int chewei_id) {
		this.chewei_id = chewei_id;
	}
	public String getChexing() {
		return chexing;
	}
	public void setChexing(String chexing) {
		this.chexing = chexing;
	}
	public String getChepai() {
		return chepai;
	}
	public void setChepai(String chepai) {
		this.chepai = chepai;
	}
	public String getKaishishijian() {
		return kaishishijian;
	}
	public void setKaishishijian(String kaishishijian) {
		this.kaishishijian = kaishishijian;
	}
	public String getJieshushijian() {
		return jieshushijian;
	}
	public void setJieshushijian(String jieshushijian) {
		this.jieshushijian = jieshushijian;
	}
	public int getFeiyong() {
		return feiyong;
	}
	public void setFeiyong(int feiyong) {
		this.feiyong = feiyong;
	}
	public Tchewei getChewei() {
		return chewei;
	}
	public void setChewei(Tchewei chewei) {
		this.chewei = chewei;
	}
	
}
