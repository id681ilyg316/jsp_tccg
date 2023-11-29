package com.orm;

/**
 * TGuanggao entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TZhengce
{

	private String id;
	private String biaoti;
	private String neirong;
	private String fujian;
	
	private String shijian;
	
	
	
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getBiaoti()
	{
		return biaoti;
	}
	public void setBiaoti(String biaoti)
	{
		this.biaoti = biaoti;
	}
	
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public String getShijian() {
		return shijian;
	}
	public void setShijian(String shijian) {
		this.shijian = shijian;
	}
	public String getFujian()
	{
		return fujian;
	}
	public void setFujian(String fujian)
	{
		this.fujian = fujian;
	}
	
}