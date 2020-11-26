/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANDESH
 */
public class feedback_reg extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
         String user =req.getParameter("username");
         String email = req.getParameter("Email");
         String feed =req.getParameter("feedback");
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
                         PreparedStatement ps= con.prepareStatement("INSERT INTO feedback values (?,?,?)");
                         ps.setString(1,user);
                         ps.setString(2,email);
                          ps.setString(3,feed);
                          int i = ps.executeUpdate();
                          if(i>0)
                          {
                              //out.println("<h1>Welcome<br/>"+user+" </h1>");
                             //out.println("<h1>Entries added Successfully </h1>");
                              out.println("<Script>alert('Thanyou for Feedback');</script>");
                              response.sendRedirect("index.jsp");
                          }   
                           else {
                               out.println("<h1>Entries  not added Successfully </h1>");
                          }
                            con.close();
               
               }
              catch(Exception e)
                      
               { System.out.println(e);
                      }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
