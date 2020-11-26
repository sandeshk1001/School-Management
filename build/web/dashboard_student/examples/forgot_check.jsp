<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%! 
String userdbRoll_no;
String userdbPassword;
String userdbname;
String userdbEmail;
%>
<%
Connection con= null;
PreparedStatement ps = null;
ResultSet rs = null;

String driverName = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3309/mini_project";
String user = "root";
String dbpsw = "poly";

String rollno = request.getParameter("rollno");
String name = request.getParameter("name");



	try{
	Class.forName(driverName);
	con = DriverManager.getConnection(url, user, dbpsw);
        
        String sql = "select * from std_persional_detail where Rollno= "+rollno;
	ps = con.prepareStatement(sql);
	rs = ps.executeQuery();
	if(rs.next())
	{ 
		userdbRoll_no = rs.getString("Rollno");
		userdbEmail = rs.getString("std_Email");
		userdbname=rs.getString("std_name");
		if(rollno.equals(userdbRoll_no))
			{
                            session.setAttribute("std_name",userdbname);
                            session.setAttribute("rollno",userdbRoll_no);
                            session.setAttribute("email",userdbEmail);
                            response.sendRedirect("../../genotp"); 
			} 
	}
        else{
            out.println("roll no not found :"+rollno);
		
	%>
		<script>
		//alert("Please Enter Correct Roll Number");
		//window.open("forgot.jsp" , "_self");
		</script>
		<%

		rs.close();
		ps.close(); }
	}
	catch(SQLException sqe)
		{
		out.println(sqe);
		} 
	catch(Exception e)
		{	
			out.println("<hr/>"+e);
		}

%>

</body>
</html>