/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDESH
 */
public class forgot_change_pwd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String upass = null;
	String uroll = null;
	HttpSession session = request.getSession(true); 
	String rollno = (String) session.getAttribute("rollno");
	
	String pass2 = request.getParameter("pwd");
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
        Statement sm= null;

	String qry=null;
	String url=null;
	
	String server	= "127.0.0.1";
	String port 	= "3309";
	String uid	= "root";
	String pass	= "poly";
	String name 	= "mini_project";
	
	String driver="com.mysql.jdbc.Driver"; 	
	//Mysql Connection
	try 
	{
	
	    Class.forName(driver).newInstance();	//Load JDBC Driver
			
            url="jdbc:mysql://" + server + ":" +port + "/" + name;			

            con=DriverManager.getConnection(url,uid,pass);
			
            if (!con.isClosed())
		{
				//out.println("Successfully connected to MySql");
		}
			
				qry="SELECT Rollno , Std_Password FROM std_persional_detail WHERE Rollno= ? ";
				ps=con.prepareStatement(qry);
				ps.setString(1,rollno);
				rs=ps.executeQuery();
						
				int sno=1;
				int mn=2;
				while (rs.next())
				{	
					uroll = rs.getString("rollno"); 
					upass = rs.getString("Std_Password");
					sno++;
				}	
				ps.close();
				con.close();
				rs.close();	
	}

		catch(Exception e)
		{	
			out.println("<hr/>"+e);
		}
		
		//out.println(uroll + " : " +upass);
			
			try 
			{
		
				Class.forName(driver).newInstance();	//Load JDBC Driver
				
				url="jdbc:mysql://" + server + ":" +port + "/" + name;			

				con=DriverManager.getConnection(url,uid,pass);
				
				if (!con.isClosed())
				{
					//out.println("Successfully connected to MySql");
				}
				
                                qry="UPDATE  std_persional_detail SET Std_Password = ? WHERE Rollno= ? ";
				ps=con.prepareStatement(qry);
				ps.setString(1,pass2);
				ps.setString(2,rollno);
				ps.executeUpdate();
				
			ps.close();
			con.close();
			//rs.close();

			out.println("<br> password updated successfully");
			out.println("<script>alert('password updated successfully'); window.open('login_student.jsp' ,'_self');</script>");
	//<script>
	//alert("password updated successfully");
	//window.open("../User.jsp" , "_self");
	//</script>
	//<%	
			}

			catch(Exception e)
			{	
				out.println("<hr/>"+e);
			}
		
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
