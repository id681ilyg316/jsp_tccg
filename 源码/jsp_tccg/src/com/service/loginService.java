package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpSession;


import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tuser;
import com.util.Util;




public class loginService
{
	public String login(String userName,String userPw,int userType)
	{
		System.out.println(userType+"UUU"); 
		
		WebContext ctx = WebContextFactory.get(); 
		 HttpSession session=ctx.getSession(); 
		 
		 String result="no";
		 
		
		
		
		if(userType==0)//系统管理员登陆
		{
			String sql="select * from t_admin where userName=? and userPw=?";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			mydb.doPstm(sql, params);
			try 
			{
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					 result="no";
				}
				else
				{
					 result="yes";
					 TAdmin admin=new TAdmin();
					 admin.setUserId(rs.getInt("userId"));
					 admin.setUserName(rs.getString("userName"));
					 admin.setUserPw(rs.getString("userPw"));
					 
					 session.setAttribute("userType", 0);
		             session.setAttribute("admin", admin);
				}
				rs.close();
			} 
			catch (SQLException e)
			{
				System.out.println("登录失败！");
				e.printStackTrace();
			}
			finally
			{
				mydb.closed();
			}
			
		}
		
		
		if(userType==1)
		{
			String sql="select * from t_user where loginname=? and loginpw=? and del='no'";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					result="no";
				}
				if(mark==true)
				{
					 result="yes";
					 
				     Tuser user=new Tuser();
					
				     user.setId(rs.getString("id"));
					 user.setLoginname(rs.getString("loginname"));
					 user.setLoginpw(rs.getString("loginpw"));
					 user.setXingming(rs.getString("xingming"));
					 
					 user.setZhuzhi(rs.getString("zhuzhi"));
					 user.setDianhua(rs.getString("dianhua"));
					 user.setDengji(rs.getString("dengji"));
					 user.setDel(rs.getString("del"));
					
					 
					 session.setAttribute("userType", 1);
		             session.setAttribute("user", user);
		             
				}
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mydb.closed();
		}
		if(userType==2)
		{
			
		}
		return result;
	}
	
	
	
	
	public String userlogin(String userName,String userPw,int userType)
	{
		WebContext ctx = WebContextFactory.get(); 
		 HttpSession session=ctx.getSession();
		    String result="no";
		
			String sql="select * from t_user where loginname=? and loginpw=? and del='no'";
			Object[] params={userName,userPw};
			DB mydb=new DB();
			try
			{
				mydb.doPstm(sql, params);
				ResultSet rs=mydb.getRs();
				boolean mark=(rs==null||!rs.next()?false:true);
				if(mark==false)
				{
					result="no";
				}
				if(mark==true)
				{
					 result="yes";
					 
				     Tuser user=new Tuser();
					
				     user.setId(rs.getString("id"));
					 user.setLoginname(rs.getString("loginname"));
					 user.setLoginpw(rs.getString("loginpw"));
					 user.setXingming(rs.getString("xingming"));
					 
					 user.setZhuzhi(rs.getString("zhuzhi"));
					 user.setDianhua(rs.getString("dianhua"));
					 user.setDengji(rs.getString("dengji"));
					 user.setDel(rs.getString("del"));
					
					 
					 session.setAttribute("userType", 1);
		             session.setAttribute("user", user);
		             
				}
				rs.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			mydb.closed();
		return result;
	}
	
	
    public String adminPwEdit(String userPwNew)
    {
		System.out.println("DDDD");
    	try 
		{
			Thread.sleep(700);
		} 
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get(); 
		HttpSession session=ctx.getSession(); 
		TAdmin admin=(TAdmin)session.getAttribute("admin");
		
		String sql="update t_admin set userPw=? where userId=?";
		Object[] params={userPwNew,admin.getUserId()};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		
		return "yes";
    }
    
    
    
    public int jisuanfeiyong(String kaishishijian,String jieshushijian,String chexing) throws Exception
    {
    	String s="入场时间:"+kaishishijian+",出场时间:"+jieshushijian+",车型："+chexing;
    	System.out.println(s);
    	//收费标准：小型1元/小时、中型2元/小时，大型3元/小时，不足一小时按照一小时计算
    	
    	int danjia=1;
    	int beishu=1;
    	int zong=0;
    	if(chexing.equals("小型"))
    	{
    		beishu=1;
    	}
    	if(chexing.equals("中型"))
    	{
    		beishu=2;
    	}
    	if(chexing.equals("大型"))
    	{
    		beishu=3;
    	}
    	Date aa=Util.newDate1(kaishishijian);
    	Date bb=Util.newDate1(jieshushijian);
    	
    	long gg=bb.getTime()-aa.getTime();
    	long fenzhong=gg/1000/60;
    	
    	if(fenzhong<60)
    	{
    		zong=danjia * 1 * beishu;
    	}
    	if(fenzhong>60 && fenzhong<120)
    	{
    		zong=danjia * 2 * beishu;
    	}
    	if(fenzhong>120 && fenzhong<180)
    	{
    		zong=danjia * 3 * beishu;
    	}
    	if(fenzhong>180 && fenzhong<240)
    	{
    		zong=danjia * 4 * beishu;
    	}
    	if(fenzhong>240 && fenzhong<300)
    	{
    		zong=danjia * 5 * beishu;
    	}
    	if(fenzhong>300 && fenzhong<360)
    	{
    		zong=danjia * 6 * beishu;
    	}
    	if(fenzhong>360 && fenzhong<420)
    	{
    		zong=danjia * 7 * beishu;
    	}
    	if(fenzhong>420 && fenzhong<480)
    	{
    		zong=danjia * 8 * beishu;
    	}
    	if(fenzhong>480 && fenzhong<540)
    	{
    		zong=danjia * 9 * beishu;
    	}
    	if(fenzhong>540 && fenzhong<600)
    	{
    		zong=danjia * 10 * beishu;
    	}
    	if(fenzhong>600)
    	{
    		zong=danjia * 10 * beishu;
    	}
    	
    	return zong;
    }
}
