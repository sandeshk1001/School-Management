
package admin;

import com.email.durgesh.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sandesh
 */
public class admin_admstudent extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String roll =request.getParameter("x");
            
            String drollno="";
            String dscholarno="2";
            String dname ="";
            String ddob ="";
            String daddress ="";
            String dgender="";
            String dcast="";
            String dmob="";
            String drelesion="";
            String demail="";
            String dpwd="";
            String dclass="";
            String dfname="";  
            String dfocpt=""; 
            String dmname="";  
            String dmocpt=""; 
            String dfmob="";
            String dphoto="";
            //academic dtails

            String dpschool="";
            String dpclass="";
            String dMarks="";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3309/mini_project";
                String uid="root";
                String pass="poly";
                Connection con=DriverManager.getConnection(url, uid,pass); 
                Statement ps=con.createStatement(); 
                String qry="SELECT * FROM adm_detail WHERE temp_id=? ";
                PreparedStatement ps1=con.prepareStatement(qry);
                ps1.setString(1,roll);
                ResultSet rs=ps1.executeQuery();
                while(rs.next())
                    {
                        drollno=rs.getString("temp_id");
                        //dscholarno=rs.getString("Scholar_no");
                        dname=rs.getString("std_name");   
                        ddob=rs.getString("std_DOB");
                        daddress=rs.getString("std_address");
                        dmob=rs.getString("std_Mob"); 
                        dgender=rs.getString("std_Gender");
                        dcast=rs.getString("std_Cast");
                        drelesion=rs.getString("releasion");   
                        demail=rs.getString("std_Email");
                        dpwd=rs.getString("Std_Password");
                        dclass=rs.getString("class");
                        dpschool=rs.getString("school_name");
                        dpclass=rs.getString("pclass");
                        dMarks=rs.getString("class");
                        dfname=rs.getString("Father_name");    
                        dfocpt=rs.getString("F_occupation");
                        dmname=rs.getString("Mother_name");
                        dmocpt=rs.getString("Mother_occupation"); 
                        dfmob=rs.getString("Parent_Mob"); 
                        dphoto=rs.getString("std_photo"); 
                    }   
            }catch(Exception e){}
            
            int found=0;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                String url="jdbc:mysql://localhost:3309/mini_project";
                String uid="root";
                String pass="poly";
                Connection con=DriverManager.getConnection(url, uid,pass);
                Statement ps=con.createStatement();
                String qry="INSERT INTO std_persional_detail values('"+drollno+"','"+dscholarno+"','"+dname+"','"+ddob+"','"+daddress+"','"+dgender+"','"+dcast+"','"+dmob+"','"+drelesion+"','"+demail+"','"+dpwd+"','"+dclass+"','"+dpschool+"','"+dpclass+"','"+dMarks+"','"+dfname+"','"+dfocpt+"','"+dmname+"','"+dmocpt+"','"+dfmob+"','"+dphoto+"')";
                ps.executeUpdate(qry);
                found=1;
 //....................................................Email Sender ..........................................................
                 try{
                        Email email = new Email("example@gmail.com","123");
                        //from 
                        email.setFrom(demail, "School Management");

                        email.setSubject("Conformation Your Admission");

                        email.setContent("<h1>Congratulation</h1>Mr."+dname+"<br>Your Addmission is succesfull in our School.<br>So Please Come School And Contact for Addmission Departement for Conform Addmission..<br><h5>Thank You</h5>", "text/html");

                        email.addRecipient(demail);

                        email.send();

                        //out.println("Succesfully send Email");

                    }catch(Exception e){
                    e.printStackTrace();
                    }
//................................................End Email...............................................................
                //out.println("Suucessfully");
                
            if(found==1){
                
            try{
                Class.forName("com.mysql.jdbc.Driver");
               
                 String qry1="DELETE FROM adm_detail WHERE temp_id = "+drollno;

                ps.executeUpdate(qry1);
                //out.println("Record Succefully Deleted");
                
                con.close();  

               }catch(Exception ex){
                     out.println(ex);
                 }
            }
                
            }catch(Exception ex){
                out.println(ex);
            }
       //delete the table data
        response.sendRedirect("dashboard_admin/examples/student_all.jsp");
            
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
