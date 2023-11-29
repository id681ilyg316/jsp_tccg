package com.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DB;
import com.orm.TAdmin;
import com.orm.Tchewei;

public class chewei_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
		if(type.endsWith("cheweiMana"))
		{
			cheweiMana(req, res);
		}
		if(type.endsWith("cheweiAdd"))
		{
			cheweiAdd(req, res);
		}
		if(type.endsWith("cheweiDel"))
		{
			cheweiDel(req, res);
		}
		
		if(type.endsWith("cheweiSelect"))
		{
			cheweiSelect(req, res);
		}
		if(type.endsWith("cheweiAll"))
		{
			cheweiAll(req, res);
		}
	}
	
	
	public void cheweiAdd(HttpServletRequest req,HttpServletResponse res)
	{
		String bianhao=req.getParameter("bianhao");
		String quyu=req.getParameter("quyu");
		String zt="空闲中";
		String del="no";
		String sql="insert into t_chewei(bianhao,quyu,zt,del) values(?,?,?,?)";
		Object[] params={bianhao,quyu,zt,del};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chewei?type=cheweiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void cheweiDel(HttpServletRequest req,HttpServletResponse res)
	{
		String sql="update t_chewei set del='yes' where id="+Integer.parseInt(req.getParameter("id"));
		Object[] params={};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		req.setAttribute("message", "操作成功");
		req.setAttribute("path", "chewei?type=cheweiMana");
		
        String targetURL = "/common/success.jsp";
		dispatch(targetURL, req, res);
	}

	public void cheweiMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
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
		
		req.setAttribute("cheweiList", cheweiList);
		req.getRequestDispatcher("admin/chewei/cheweiMana.jsp").forward(req, res);
	}
	
	
	
	public void cheweiSelect(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List cheweiList=new ArrayList();
		String sql="select * from t_chewei where del='no' and zt='空闲中' order by quyu";
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
		
		req.setAttribute("cheweiList", cheweiList);
		req.getRequestDispatcher("admin/chewei/cheweiSelect.jsp").forward(req, res);
	}
	
	
	
	public void cheweiAll(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
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
		
		req.setAttribute("cheweiList", cheweiList);
		req.getRequestDispatcher("qiantai/chewei/cheweiRes.jsp").forward(req, res);
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
