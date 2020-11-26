/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANDESH
 */
public class EnquiryServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
            
         String username =req.getParameter("userid");
         String emailid = req.getParameter("Emailadd");
         String enq =req.getParameter("enquiry");
          PrintWriter out = response.getWriter();
      
          Connection con=null;
          Statement st= null;
          ResultSet rs=null;
         
               try {
                   
                     Class.forName("com.mysql.jdbc.Driver");
                       System.out.println("Driver loaded");
                       con = DriverManager.getConnection("jdbc:mysql://localhost:3309/mini_project","root","poly");
                       System.out.println("connection established");
                         st=con.createStatement();
                         PreparedStatement ps= con.prepareStatement("INSERT into enquiry values(?,?,?)");
                         ps.setString(1,username);
                         ps.setString(2,emailid);
                          ps.setString(3,enq);
                         
                          int i = ps.executeUpdate();
                          if(i>0)
                          {
                              //out.println("<h1>Welcome<br/>"+username+" </h1>");
                             //out.println("<h1>Entries added Successfully </h1>");
                            // response.sendRedirect("index.");
                              out.println("<script>alert('your Equiry Registered')</script>");
                              response.sendRedirect("index.jsp");
                          }   
                           else {
                               out.println("<h1>Entries  not added Successfully </h1>");
                          }
                            con.close();
               
               }
              catch(Exception e)
                      
               { out.println(e);
                      }   
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
