//admision Student Entry 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
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


     PrintWriter out = response.getWriter();
        String dname=request.getParameter("name");
        
        String ddob=request.getParameter("dob");  
        String daddress=request.getParameter("address");  
        String dgender=request.getParameter("gender");  
        String dcast=request.getParameter("cast");  
        String dmob=request.getParameter("phone");  
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

        String picname="";
        //out.println(dname);
        //out.println(dname+","+ddob+","+daddress+","+dgender+","+dcast+","+dmob+","+drelesion+","+demail+","+dpwd+","+dclass+","+dfname+","+dfocpt+","+dmname+","+dmocpt+","+dfmob+","+dpschool+","+dpclass+","+dMarks+"");
        
               
        Connection con=null;
		
		ResultSet rs=null;
		Statement sm= null;

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
				Statement ps=con.createStatement();
				if (!con.isClosed())
				{
					//out.println("Successfully connected to MySql");
				}
                                String qry="INSERT INTO adm_detail(Std_name, Std_DOB, Std_Address, Std_Gender, Std_Cast, Std_Mob, releasion, Std_Email , Std_Password, class, school_name,pclass,pmarks, Father_name, F_occupation, Mother_name, Mother_occupation, Parent_Mob) values('"+dname+"','"+ddob+"','"+daddress+"','"+dgender+"','"+dcast+"','"+dmob+"','"+drelesion+"','"+demail+"','"+dpwd+"','"+dclass+"','"+dpschool+"','"+dpclass+"','"+dMarks+"','"+dfname+"','"+dfocpt+"','"+dmname+"','"+dmocpt+"','"+dfmob+"')";
                                
                              // String qry2="INSERT INTO std_perents_detail VALUES('"+droll+"','"+dfname+"','"+dfocpt+"','"+dmname+"','"+dmocpt+"','"+dfmob+"')";
//pic query 
				//String qry3="INSERT INTO std_pic_detail VALUES('"+droll+"','"+picname+"')";  

					/*ps=con.prepareStatement(qry);
                                        ps.setString(1,droll);
					ps.setString(2,picname);*/
                                       ps.executeUpdate(qry);
                                       //out.println("1 qry");
                                      // ps.executeUpdate(qry2);
                                       //out.println("2 qry");
                                     //  ps.executeUpdate(qry3);
                                      //out.println("Success");
                                    
					//out.println("\n"+id);	
                                        out.println("Your Details Enter Succesfully Waiting for Administration accept you Addmission");
                                        
                                       
				ps.close();
				con.close();
			}

		catch(Exception e)
		{
		
			out.println("<hr/>"+e);
		}
                                     
    }
}
