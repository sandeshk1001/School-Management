package admin;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import java.time.*;
import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB

public class Add_Stud extends HttpServlet 
{
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
    String dMarks="";

    
    
    String picname="";
    String pic="";
    String dir="";
    boolean found=false;
	private final String UPLOAD_DIRECTORY = "C:/Users/sandesh/Documents/NetBeansProjects/Mini_Project/web/image_data";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Stud() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
                                            java.util.Date date = new java.util.Date();
						long timeMilli = date.getTime();    
                        
						//picname = "image" + timeMilli;
                                                picname= "image" + droll;
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
							}else if(fieldName.equals("scholarno"))    //scholarno
							{
								String value = item.getString();
								dscholar = value;
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
							}else if(fieldName.equals("mob"))
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
							}else if(fieldName.equals("Mocpt"))
							{
								String value = item.getString();
								dmocpt = value;
							}else if(fieldName.equals("fmob"))
							{
								String value = item.getString();
								dfmob = value;
							}else if(fieldName.equals("pwd"))
							{
								String value = item.getString();
								dpwd = value;
							}
                                        }
                                        
				}
                                
                                
                               this.save(); 
                                
                                response.sendRedirect("login.jsp");
                                
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
					out.println("Successfully connected to MySql");
				}
                                String qry="INSERT INTO std_persional_detail values('"+droll+"','"+dscholar+"','"+dname+"','"+ddob+"','"+daddress+"','"+dgender+"','"+dcast+"','"+dmob+"','"+drelesion+"','"+demail+"','"+dpwd+"','"+dclass+"','"+dpschool+"','"+dpclass+"','"+dMarks+"','"+dfname+"','"+dfocpt+"','"+dmname+"','"+dmocpt+"','"+dfmob+"')";
                                
//pic query 
				String qry3="INSERT INTO std_pic_detail VALUES('"+droll+"','"+picname+"')";  

					/*ps=con.prepareStatement(qry);
                                        ps.setString(1,droll);
					ps.setString(2,picname);*/
                                       ps.executeUpdate(qry);
                                       out.println("1 qry");
                                       ps.executeUpdate(qry3);
                                       out.println("Success");
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

}
