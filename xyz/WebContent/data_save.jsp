<%@page import="db.register_validator"%>
<%@page import="java.sql.*"%>
<html>
<body background="a.jpg">
<% 
   String fn=request.getParameter("fname");
   String mn=request.getParameter("mname");
   String ln=request.getParameter("lname");
   String m=request.getParameter("mobno");
   String e=request.getParameter("email");
   String p=request.getParameter("pass");
   String cp=request.getParameter("cpass");
 
   Connection conn= register_validator.getConnection();
   String query="insert into userdetails values(?,?,?,?,?,?,?)";
   PreparedStatement ps=conn.prepareStatement(query);
   if(p.equals(cp)){
   ps.setString(1,fn);
   ps.setString(2,mn);
   ps.setString(3,ln);
   ps.setString(4,m);
   ps.setString(5,e);
   ps.setString(6,p);
   ps.setString(7,cp);
   ps.executeUpdate();
   conn.close();
   }else{
	   session.setAttribute("reply","Something Wrong Please Signup Again");
	   response.sendRedirect("register.jsp");
   }
%>
</body>
<jsp:forward page="login.html"/>   
</html>