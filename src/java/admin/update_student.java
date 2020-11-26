
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import static java.sql.JDBCType.NULL;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update_student extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            String drollno=request.getParameter("rollno");
            String dscholarno=request.getParameter("scholarno");
            String dname=request.getParameter("name");
            String ddob=request.getParameter("dob");
            String daddress=request.getParameter("address");
            String dgender=request.getParameter("gender");
            String dcast=request.getParameter("cast");
            String dmob=request.getParameter("mob");
            String drelesion=request.getParameter("relesion");
            String demail=request.getParameter("email");
            String dpwd=request.getParameter("pwd");
            String dclass=request.getParameter("class");

            String dfname=request.getParameter("fname");  
            String dfocpt=request.getParameter("focpt");  
            String dmname=request.getParameter("Mname");  
            String dmocpt=request.getParameter("Mocpt");  
            String dfmob=request.getParameter("fmob");
            //academic dtails

            String dpschool=request.getParameter("pschool");
            String dpclass=request.getParameter("pclass");
            String dMarks=request.getParameter("Marks");

            
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3309/mini_project";
                String uid="root";
                String pass="poly";
                PreparedStatement st;
                Connection con=DriverManager.getConnection(url, uid,pass);
                String qry="update std_persional_detail set Rollno=?,Scholar_no=?,Std_name=?,Std_DOB=?,Std_Address=?,Std_Gender=?,Std_Cast=?,Std_Mob=?,releasion=?,Std_Email=?,Std_Password=?,class=?,school_name=?,pclass=?,pmarks=?,Father_name=?,F_occupation=?,Mother_name=?,Mother_occupation=?,Parent_Mob=? where rollno="+drollno;
                  st=con.prepareStatement(qry);
                  st.setString(1,drollno);
                  st.setString(2, dscholarno);
                  st.setString(3, dname);
                  st.setString(4,ddob);
                  st.setString(5, daddress);
                  st.setString(6, dgender);
                  st.setString(7, dcast);
                  st.setString(8, dmob);
                  st.setString(9, drelesion);
                  st.setString(10, demail);
                  st.setString(11, dpwd);  
                  st.setString(12, dclass);  
                  st.setString(13, dpschool);  
                  st.setString(14, dpclass);  
                  st.setString(15, dMarks);     
                  st.setString(16, dfname);
                  st.setString(17, dfocpt);
                  st.setString(18,dmname);
                  st.setString(19, dmocpt); 
                  st.setString(20, dfmob); 
                  st.executeUpdate();
                  
                  
            
           out.println("Record Updated");
           con.close();  
                
            }catch(Exception ex){
                out.println(ex);
            }
            
           // out.println("<table>");
            //out.println("<table border=3;><tr><th>Rollno</th><td>"+drollno+"</td></tr><tr><th>Scholar No</th><td>"+dscholarno+"</td></tr><tr><th>Name</th><td>"+dname+"</td></tr><tr><th>Date of Birth</th><td>"+ddob+"</td></tr><tr><th>Address</th><td>"+daddress+"</td></tr><tr><th>Gender</th><td>"+dgender+"</td></tr><tr><th>Mobile No</th><td>"+dmob+"</td></tr>");
            //out.println("<tr><th>Cast</th><td>"+dcast+"</td></tr><tr><th>Releasion</th><td>"+drelesion+"</td></tr><tr><th>Email</th><td>"+demail+"</td></tr><tr><th>Password</th><td>"+dpwd+"</td></tr>");
            //out.println("</table>");
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
