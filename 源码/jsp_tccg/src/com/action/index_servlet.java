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
import com.service.liuService;


public class index_servlet extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException 
	{
		/*List guanggaoList=liuService.guanggaoList();
		if(guanggaoList.size()>3)
		{
			guanggaoList=guanggaoList.subList(0, 3);
		}
		req.setAttribute("guanggaoList", guanggaoList);
		
		
		List xinwenList=liuService.xinwenList();
		if(xinwenList.size()>3)
		{
			xinwenList=xinwenList.subList(0, 3);
		}
		req.setAttribute("xinwenList", xinwenList);
		*/
		
		
		List zhengceList=liuService.zhengceList();
		if(zhengceList.size()>4)
		{
			zhengceList=zhengceList.subList(0, 4);
		}
		req.getSession().setAttribute("zhengceList", zhengceList);
		
		
		List cheweiList=liuService.cheweiList();
		req.getSession().setAttribute("cheweiList", cheweiList);
		
        req.getRequestDispatcher("qiantai/index.jsp").forward(req, res);
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
