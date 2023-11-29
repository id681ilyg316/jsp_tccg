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
import javax.servlet.http.HttpSession;

import com.dao.DB;
import com.orm.Tuser;
import com.orm.Tyuding;
import com.service.liuService;


public class yuding_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		
		if(type.endsWith("yudingAdd"))
		{
			yudingAdd(req, res);
		}
		if(type.endsWith("yudingMine"))
		{
			yudingMine(req, res);
		}	
		if(type.endsWith("yudingDel"))
		{
			yudingDel(req, res);
		}
		
		if(type.endsWith("yudingMana"))
		{
			yudingMana(req, res);
		}
		
		if(type.endsWith("yudingShouli"))
		{
			yudingShouli(req, res);
		}
		
	}
	
	
	public void yudingAdd(HttpServletRequest req,HttpServletResponse res)
	{
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		String id=String.valueOf(new Date().getTime());
		String xingming=req.getParameter("xingming");
		String dianhua=req.getParameter("dianhua");
		String daodashi=req.getParameter("daodashi");
		
		int chewei_id=Integer.parseInt(req.getParameter("chewei_id"));
		String user_id=user.getId();
		String zt="待受理";
		
		
		String sql="insert into t_yuding values(?,?,?,?,?,?,?)";
		Object[] params={id,xingming,dianhua,daodashi,chewei_id,user_id,zt};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "预订成功");
		
		
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
        
	}
	
	
	public void yudingMine(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		Tuser user=(Tuser)session.getAttribute("user");
		
		List yudingList=new ArrayList();
		String sql="select * from t_yuding where user_id=?";
		Object[] params={user.getId()};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tyuding yuding=new Tyuding();
				
				yuding.setId(rs.getString("id"));
				yuding.setXingming(rs.getString("xingming"));
				yuding.setDianhua(rs.getString("dianhua"));
				yuding.setDaodashi(rs.getString("daodashi"));
				
				yuding.setChewei_id(rs.getInt("chewei_id"));
				yuding.setUser_id(rs.getString("user_id"));
				yuding.setZt(rs.getString("zt"));
				
				
				yuding.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
				
				yudingList.add(yuding);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yudingList", yudingList);
		req.getRequestDispatcher("admin/yuding/yudingMine.jsp").forward(req, res);
	}
	
	
	public void yudingDel(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
        String id=req.getParameter("id");
		
		String sql="delete from t_yuding where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "信息删除完毕");
		String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void yudingMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List yudingList=new ArrayList();
		String sql="select * from t_yuding order by zt desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
                Tyuding yuding=new Tyuding();
				
				yuding.setId(rs.getString("id"));
				yuding.setXingming(rs.getString("xingming"));
				yuding.setDianhua(rs.getString("dianhua"));
				yuding.setDaodashi(rs.getString("daodashi"));
				
				yuding.setChewei_id(rs.getInt("chewei_id"));
				yuding.setUser_id(rs.getString("user_id"));
				yuding.setZt(rs.getString("zt"));
				
				
				yuding.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
				
				yudingList.add(yuding);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("yudingList", yudingList);
		req.getRequestDispatcher("admin/yuding/yudingMana.jsp").forward(req, res);
	}
	
	
	public void yudingShouli(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String id=req.getParameter("id");
		
		String sql="update t_yuding set zt='已受理' where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("msg", "受理完毕");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
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
