package com.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dao.DB;
import com.orm.TZhengce;
import com.orm.Tchewei;
import com.orm.Tuser;


public class liuService
{
	public static void update_chewei_zt(int id,String zt)
	{
		String sql="update t_chewei set zt=? where id=?";
		Object[] params={zt,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
	}
	
	
	public static Tchewei get_chewei(int id)
	{
		Tchewei chewei=new Tchewei();
		String sql="select * from t_chewei where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				chewei.setId(rs.getInt("id"));
				chewei.setBianhao(rs.getString("bianhao"));
				chewei.setQuyu(rs.getString("quyu"));
				chewei.setZt(rs.getString("zt"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return chewei;
	}
	
	public static Tuser get_user(String id)
	{
		Tuser user=new Tuser();
		
		String sql="select * from t_user where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				user.setId(rs.getString("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setLoginpw(rs.getString("loginpw"));
				user.setXingming(rs.getString("xingming"));
				 
				user.setZhuzhi(rs.getString("zhuzhi"));
				user.setDianhua(rs.getString("dianhua"));
				user.setDengji(rs.getString("dengji"));
				user.setDel(rs.getString("del"));
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return user;
	}
	
	
	
	public static List zhengceList()
	{
		List zhengceList=new ArrayList();
		String sql="select * from t_zhengce order by id desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				TZhengce zhengce=new TZhengce();
				
				zhengce.setId(rs.getString("id"));
				zhengce.setBiaoti(rs.getString("biaoti"));
				zhengce.setNeirong(rs.getString("neirong"));
				zhengce.setFujian(rs.getString("fujian"));
				
				zhengce.setShijian(rs.getString("shijian"));
				
				zhengceList.add(zhengce);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		return zhengceList;
	}
	
	
	
	
	public static String panduan_zhanghao(String loginname)
	{
		String s="meizhan";
		
		String sql="select * from t_user where del='no' and loginname=?";
		Object[] params={loginname.trim()};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				s="yizhan";
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return s;
	}
	
	
	public static List cheweiList()
	{
		List cheweiList=new ArrayList();
		String sql="select * from t_chewei where del='no' order by quyu";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tchewei chewei=new Tchewei();
				
				chewei.setId(rs.getInt("id"));
				chewei.setBianhao(rs.getString("bianhao"));
				chewei.setQuyu(rs.getString("quyu"));
				chewei.setZt(rs.getString("zt"));
				
				cheweiList.add(chewei);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		return cheweiList;
	}
}
