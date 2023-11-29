package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.TZhengce;

public class zhengce_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("zhengceAdd"))
		{
			zhengceAdd(req, res);
		}
		if(type.endsWith("zhengceMana"))
		{
			zhengceMana(req, res);
		}
		if(type.endsWith("zhengceDel"))
		{
			zhengceDel(req, res);
		}
		if(type.endsWith("zhengceDetailHou"))
		{
			zhengceDetailHou(req, res);
		}
		
		if(type.endsWith("zhengceAll"))
		{
			zhengceAll(req, res);
		}
		if(type.endsWith("zhengceDetailQian"))
		{
			zhengceDetailQian(req, res);
		}
	}
	
	
	public void zhengceAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String id=String.valueOf(new Date().getTime());
		String biaoti=req.getParameter("biaoti");
		String neirong=req.getParameter("neirong");
		String fujian=req.getParameter("fujian");
		if(fujian.equals(""))
		{
			fujian="/images/zanwu.jpg";
		}
		
		String shijian=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		
		String sql="insert into t_zhengce values(?,?,?,?,?)";
		Object[] params={id,biaoti,neirong,fujian,shijian};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	

	public void zhengceMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zhengceList=new ArrayList();
		String sql="select * from t_zhengce";
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
		
		req.setAttribute("zhengceList", zhengceList);
		req.getRequestDispatcher("admin/zhengce/zhengceMana.jsp").forward(req, res);
	}
	
	
	public void zhengceDel(HttpServletRequest req,HttpServletResponse res)
	{
		String id=req.getParameter("id");
		
		String sql="delete from t_zhengce where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "操作成功");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void zhengceDetailHou(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		TZhengce zhengce=new TZhengce();
		
		String sql="select * from t_zhengce where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			zhengce.setId(rs.getString("id"));
			zhengce.setBiaoti(rs.getString("biaoti"));
			zhengce.setNeirong(rs.getString("neirong"));
			zhengce.setFujian(rs.getString("fujian"));
			
			zhengce.setShijian(rs.getString("shijian"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zhengce", zhengce);
		req.getRequestDispatcher("admin/zhengce/zhengceDetailHou.jsp").forward(req, res);
	}
	
	
	public void zhengceAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List zhengceList=new ArrayList();
		String sql="select * from t_zhengce";
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
		
		req.setAttribute("zhengceList", zhengceList);
		req.getRequestDispatcher("qiantai/zhengce/zhengceAll.jsp").forward(req, res);
	}
	
	public void zhengceDetailQian(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		TZhengce zhengce=new TZhengce();
		
		String sql="select * from t_zhengce where id=?";
		Object[] params={id};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			rs.next();
			
			zhengce.setId(rs.getString("id"));
			zhengce.setBiaoti(rs.getString("biaoti"));
			zhengce.setNeirong(rs.getString("neirong"));
			zhengce.setFujian(rs.getString("fujian"));
			
			zhengce.setShijian(rs.getString("shijian"));
			
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("zhengce", zhengce);
		req.getRequestDispatcher("/qiantai/zhengce/zhengceDetailQian.jsp").forward(req, res);
	}
	
	
	public void dispatch(String targetURI,HttpServletRequest request,HttpServletResponse response) 
	{
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(targetURI);
		try 
		{
		    dispatch.forward(request, response);
		    return;
		} 
		catch (ServletException e) 
		{
                    e.printStackTrace();
		} 
		catch (IOException e) 
		{
			
		    e.printStackTrace();
		}
	}
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
	}
	
	public void destroy() 
	{
		
	}
}
