package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Member;

public class add_member_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String time = request.getParameter("time");
		String priority = request.getParameter("priority");
		String id = request.getParameter("id");
		System.out.println(name);
		
		//System.out.println("content:"+content+",,,,发布状态："+saveState+";");

		Member member=new Member(id,name,description,time,priority);
		
		try{
			if(action.equals("editmember")){
				if(member.edit_member()){
					System.out.println("success");
					response.getWriter().write("success");
				}else{
					System.out.println("failed");
					response.getWriter().write("failed");
				}
			}else{
				if(member.add_member()){
					System.out.println("success");
					response.getWriter().write("success");
				}else{
					System.out.println("failed");
					response.getWriter().write("failed");
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

