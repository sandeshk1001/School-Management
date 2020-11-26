/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author SANDESH
 */
public class admission_std extends HttpServlet {
    String droll="";   
    String dscholar="";  
    String dname="";  
    String ddob="";  
    String daddress="";  
    String dgender="";  
    String dcast="";  
    String dmob="";  
    String drelesion="";  
    String demail="";  
    String dpwd=""; 
    
    
    //parent detals variable
    String dfname="";  
    String dfocpt="";  
    String dmname="";  
    String dmocpt="";  
    String dfmob="";
  
    //Those are missing incomplete servlet
    String dclass="";
    String dpschool="";
    String dpclass="";
    String dpmarks="";

    
    
    String picname="";
    String pic="";
    String dir="";
    boolean found=false;
	private final String UPLOAD_DIRECTORY = "C:/Users/SANDESH/Documents/NetBeansProjects/School/web/image_data";
	private static final long serialVersionUID = 1L;
 
    public admission_std() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
        {
            boolean flag=false;
                  PrintWriter out = response.getWriter();
		// TODO Auto-generated method stub
		
		if(ServletFileUpload.isMultipartContent(request))
		{
			try
			{       
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				for(FileItem item : multiparts)
				{
					if(!item.isFormField())
					{
                                            
                                            flag=true;                                            
                                            //java.util.Date date = new java.util.Date();
						//long timeMilli = date.getTime();    
                        
						//picname = "image" + timeMilli;
                                                picname= dname + droll;
						pic = picname + ".jpg";
                                                dir = UPLOAD_DIRECTORY +"/"+ pic ;
						item.write(new File(UPLOAD_DIRECTORY + File.separator + pic));
					}
                                        else
                                        {
                                            String fieldName = item.getFieldName();
							
							if(fieldName.equals("rollno"))      //rollno
							{
								String value = item.getString();
								droll = value;
							}else if(fieldName.equals("name"))
							{
								String value = item.getString();
								dname = value;
							}else if(fieldName.equals("dob"))
							{
								String value = item.getString();
								ddob = value;
							}else if(fieldName.equals("address"))
							{
								String value = item.getString();
								daddress = value;
							}else if(fieldName.equals("gender"))
							{
								String value = item.getString();
								dgender = value;
							}else if(fieldName.equals("cast"))
							{
								String value = item.getString();
								dcast = value;
							}else if(fieldName.equals("phone"))
							{
								String value = item.getString();
								dmob = value;
							}else if(fieldName.equals("relesion"))
							{
								String value = item.getString();
								drelesion = value;
							}else if(fieldName.equals("email"))
							{
								String value = item.getString();
								demail = value;
							}else if(fieldName.equals("pwd"))
							{
								String value = item.getString();
								dpwd = value;
							}else if(fieldName.equals("class"))
							{
								String value = item.getString();
								dclass = value;
							}else if(fieldName.equals("pclass"))
							{
								String value = item.getString();
								dpclass = value;
							}else if(fieldName.equals("pschool"))
							{
								String value = item.getString();
								dpschool = value;
							}else if(fieldName.equals("pmarks"))
							{
								String value = item.getString();
								dpmarks = value;
							}else if(fieldName.equals("fname"))
							{
								String value = item.getString();
								dfname = value;
							}else if(fieldName.equals("focpt"))
							{
								String value = item.getString();
								dfocpt = value;
							}else if(fieldName.equals("Mname"))
							{
								String value = item.getString();
								dmname = value;
							}else if(fieldName.equals("fmob"))
							{
								String value = item.getString();
								dfmob = value;
							}else if(fieldName.equals("Mocpt"))
							{
								String value = item.getString();
								dmocpt = value;
							}
                                        }
                                        
				}
                               this.save(); 
                               response.sendRedirect("index.jsp");                               
			}
			catch(Exception ex)
			{
                            out.println(ex);
			}                    
		}
		else
		{
		}
                                
	}
        void save(){
            
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
                                String qry="INSERT INTO adm_detail values('"+droll+"','"+dname+"','"+ddob+"','"+daddress+"','"+dgender+"','"+dcast+"','"+dmob+"','"+drelesion+"','"+demail+"','"+dpwd+"','"+dclass+"','"+dpschool+"','"+dpclass+"','"+dpmarks+"','"+dfname+"','"+dfocpt+"','"+dmname+"','"+dfmob+"','"+dmocpt+"','"+picname+"')";
                                
//pic query 
				//String qry3="INSERT INTO std_pic_detail VALUES('"+droll+"','"+picname+"')";  

					/*ps=con.prepareStatement(qry);
                                        ps.setString(1,droll);
					ps.setString(2,picname);*/
                                       ps.executeUpdate(qry);
                                       out.println("1 qry");
                                       //ps.executeUpdate(qry3);
                                       //out.println("Success");
                                       this.found=true;
					//out.println("\n"+id);	
                                        
                                        
                                       
				ps.close();
				con.close();
			}

		catch(Exception e)
		{
		
			out.println("<hr/>"+e);
		}
                
		
        }
            

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
