package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Guest_member;

public class guest_search_member_servlet extends HttpServlet {

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		String guest_name = (String) request.getSession().getAttribute("guest_name");
		
		
		
		System.out.println(guest_name);

		Guest_member guest=new Guest_member();
		
		
		try {
			
			String res=guest.searchguest(guest_name); //对应search_guest里面的na
			
			response.getWriter().write(res);
				
			}catch(Exception e){
				e.printStackTrace();
			} 
		
	}

}