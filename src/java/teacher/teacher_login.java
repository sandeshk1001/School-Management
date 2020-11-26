
package teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sandesh
 */
public class teacher_login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String s1=request.getParameter("uid");
        String s2=request.getParameter("pwd");
        
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3309/mini_project";
                String uid="root";
                String pass="poly";
                Connection con=DriverManager.getConnection(url, uid, pass);
                String qry="SELECT * FROM teacher_detail WHERE tid=? AND tpwd=?";
                PreparedStatement ps=con.prepareStatement(qry);
                ps.setString(1,s1);
                ps.setString(2,s2);
                ResultSet rs=ps.executeQuery();
                boolean found=rs.next();
                
                if(found){
                    String tname=rs.getString("tname");
                    HttpSession session=request.getSession();
                    session.setAttribute("tname", tname);
                    session.setAttribute("id", s1);
                    //response.sendRedirect("teacher_home.jsp");
                    response.sendRedirect("dashboard_teacher/examples/dashboard_teacher.jsp");
                }else{
                   out.println("Please Enter valid entry!!!!!!");   
                }
            }catch(Exception ex){
                out.println(ex);
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
