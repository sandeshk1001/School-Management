/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SANDESH
 */
public class remove_enquiry extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        String id =request.getParameter("x");
        String email =request.getParameter("y");
        //out.println("email :"+email+"  username :"+id);
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3309/mini_project";
                String uid="root";
                String pass="poly";
                PreparedStatement ps;
                Connection con=DriverManager.getConnection(url, uid, pass);
               String qry="DELETE FROM enquiry WHERE username= ? AND email = ?";
                //String qry="DELETE FROM std_persional_detail WHERE rollno = ? ";
               //String qry2="DELETE FROM std_pic_detail WHERE rollno = ? ";

                ps=con.prepareStatement(qry);
                ps.setString(1,id);
                ps.setString(2,email);
                ps.executeUpdate();
               
                
                ///ps=con.prepareStatement(qry2);
                //ps.setString(1,id);
                //ps.executeUpdate();
                //out.println("Delete Succesfully");
                response.sendRedirect("dashboard_admin/examples/dashboard.jsp");
                
                //out.println("Success");
                //out.println("\n"+id);	
        }catch(Exception ex){out.println("error:"+ex);}
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
