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
import com.orm.Tting;
import com.service.liuService;


public class ting_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
        String type=req.getParameter("type");
		
        if(type.endsWith("tingAdd"))
		{
			tingAdd(req, res);
		}
        if(type.endsWith("tingMana"))
		{
        	tingMana(req, res);
		}
        if(type.endsWith("tingDel"))
		{
        	tingDel(req, res);
		}
        
        if(type.endsWith("jiesuanPre"))
		{
        	jiesuanPre(req, res);
		}
        if(type.endsWith("feiyongAdd"))
		{
        	feiyongAdd(req, res);
		}
        
        if(type.endsWith("tingRes"))
		{
        	tingRes(req, res);
		}
	}
	
	
	public void tingAdd(HttpServletRequest req,HttpServletResponse res)
	{
		int id=0;
		int chewei_id=Integer.parseInt(req.getParameter("chewei_id"));
		String chexing=req.getParameter("chexing");
		String chepai=req.getParameter("chepai");
		
		String kaishishijian=req.getParameter("kaishishijian");
		String jieshushijian="";
		int feiyong=0;
		
		String sql="insert into t_ting(chewei_id,chexing,chepai,kaishishijian,jieshushijian,feiyong) values(?,?,?,?,?,?)";
		Object[] params={chewei_id,chexing,chepai,kaishishijian,jieshushijian,feiyong};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		liuService.update_chewei_zt(chewei_id, "已占用");
		
		req.setAttribute("msg", "停车信息添加完毕");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	public void tingMana(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		List tingList=new ArrayList();
		String sql="select * from t_ting order by id desc";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tting ting=new Tting();
				
				ting.setId(rs.getInt("id"));
				ting.setChewei_id(rs.getInt("chewei_id"));
				ting.setChexing(rs.getString("chexing"));
				ting.setChepai(rs.getString("chepai"));
				
				ting.setKaishishijian(rs.getString("kaishishijian"));
				ting.setJieshushijian(rs.getString("jieshushijian"));
				ting.setFeiyong(rs.getInt("feiyong"));
				
				ting.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
				
				tingList.add(ting);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("tingList", tingList);
		req.getRequestDispatcher("admin/ting/tingMana.jsp").forward(req, res);
	}
	
	
	public void tingDel(HttpServletRequest req,HttpServletResponse res)
	{
		int chewei_id=Integer.parseInt(req.getParameter("chewei_id"));
		int id=Integer.parseInt(req.getParameter("id"));
		
		String sql="delete from t_ting where id=?";
		Object[] params={id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		liuService.update_chewei_zt(chewei_id, "空闲中");
		
		req.setAttribute("msg", "信息删除完毕");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void jiesuanPre(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		Tting ting=new Tting();
		
		String sql="select * from t_ting where id=?";
		Object[] params={Integer.parseInt(req.getParameter("id"))};
		
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				
				ting.setId(rs.getInt("id"));
				ting.setChewei_id(rs.getInt("chewei_id"));
				ting.setChexing(rs.getString("chexing"));
				ting.setChepai(rs.getString("chepai"));
				
				ting.setKaishishijian(rs.getString("kaishishijian"));
				ting.setJieshushijian(rs.getString("jieshushijian"));
				ting.setFeiyong(rs.getInt("feiyong"));
				
				ting.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
				
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("ting", ting);
		req.getRequestDispatcher("admin/ting/jiesuanPre.jsp").forward(req, res);
	}
	
	
	public void feiyongAdd(HttpServletRequest req,HttpServletResponse res)
	{
		int chewei_id=Integer.parseInt(req.getParameter("chewei_id"));
		int id=Integer.parseInt(req.getParameter("id"));
		
		String jieshushijian=req.getParameter("jieshushijian");
		int feiyong=Integer.parseInt(req.getParameter("feiyong"));
		
		String sql="update t_ting set jieshushijian=?,feiyong=? where id=?";
		Object[] params={jieshushijian,feiyong,id};
		DB mydb=new DB();
		mydb.doPstm(sql, params);
		mydb.closed();
		
		liuService.update_chewei_zt(chewei_id, "空闲中");
		
		req.setAttribute("msg", "费用结算完毕");
        String targetURL = "/common/msg.jsp";
		dispatch(targetURL, req, res);
	}
	
	
	public void tingRes(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String chexing=req.getParameter("chexing");
		String chepai=req.getParameter("chepai");
		
		List tingList=new ArrayList();
		String sql="select * from t_ting where jieshushijian !='' and chexing like '%"+chexing+"%'"+" and chepai like '%"+chepai.trim()+"%'";
		Object[] params={};
		DB mydb=new DB();
		try
		{
			mydb.doPstm(sql, params);
			ResultSet rs=mydb.getRs();
			while(rs.next())
			{
				Tting ting=new Tting();
				
				ting.setId(rs.getInt("id"));
				ting.setChewei_id(rs.getInt("chewei_id"));
				ting.setChexing(rs.getString("chexing"));
				ting.setChepai(rs.getString("chepai"));
				
				ting.setKaishishijian(rs.getString("kaishishijian"));
				ting.setJieshushijian(rs.getString("jieshushijian"));
				ting.setFeiyong(rs.getInt("feiyong"));
				
				ting.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
				
				tingList.add(ting);
		    }
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		mydb.closed();
		
		req.setAttribute("tingList", tingList);
		req.getRequestDispatcher("admin/ting/tingRes.jsp").forward(req, res);
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
