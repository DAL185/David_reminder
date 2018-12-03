package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Guest_member;

public class guest_have_reminder_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String guest_name = (String) request.getSession().getAttribute("guest_name");

		System.out.println(guest_name);

		Guest_member guest_member=new Guest_member();
		try{
			if(guest_member.have_reminder(guest_name)){
				System.out.println("success");
				response.getWriter().write("success");
			}else{
				System.out.println("failed");
				response.getWriter().write("failed");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}