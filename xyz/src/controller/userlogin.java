package controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.register_validator;


@WebServlet("/userlogin")
public class userlogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			String e=request.getParameter("email");
			String p=request.getParameter("pass");
			
		Connection conn=register_validator.getConnection();
		String query="select * from userdetails where email=? and password=?";
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setString(1,e); ps.setString(2,p);
		ResultSet rs=ps.executeQuery();
		   
		   if(rs.next()){
			 HttpSession session= request.getSession();
		   session.setAttribute("email", rs.getString("email"));
		   session.setAttribute("firstname", rs.getString("firstname"));
		   	
		   	response.sendRedirect("mental.html");
		   }
		   else
		   {
			   response.sendRedirect("login.html");
		   
		   }
		   conn.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
	}

}
