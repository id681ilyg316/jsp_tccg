package com.orm;

public class Tchewei
{
	private int id;
	
	private String bianhao;

	private String quyu;
	private String zt;////空闲中---已占用
	private String del;
	
	public String getBianhao()
	{
		return bianhao;
	}
	public void setBianhao(String bianhao)
	{
		this.bianhao = bianhao;
	}
	public String getDel()
	{
		return del;
	}
	public void setDel(String del)
	{
		this.del = del;
	}
	public int getId()
	{
		return id;
	}
	
	
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getQuyu()
	{
		return quyu;
	}
	public void setQuyu(String quyu)
	{
		this.quyu = quyu;
	}

}
