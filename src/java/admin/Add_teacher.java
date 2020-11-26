package admin;

import com.email.durgesh.Email;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author sandesh
 */
public class Add_teacher extends HttpServlet {
    String dtid="";    
    String dtname="";  
    String dtaddress="";
    String dtdob="";
    String dtrelesion="";        
    String dtgender="";  
    String dtmob="";    
    String dtemail="";  
    String dtpwd=""; 
    
    String dtssub="";  
    String dthstd="";  
     
    
    String picname="";
    String pic="";
    String dir="";
    boolean found=false;
	private final String UPLOAD_DIRECTORY = "C:/Users/sandesh/Documents/NetBeansProjects/Mini_Project/web/image_data/teacher_images";
	private static final long serialVersionUID = 1L;
    public Add_teacher()
    {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        PrintWriter out = response.getWriter();
        boolean flag=false;
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
                                                picname= "image" + dtid;
						pic = picname + ".jpg";
                                                dir = UPLOAD_DIRECTORY +"/"+ pic ;
						item.write(new File(UPLOAD_DIRECTORY + File.separator + pic));
                                                
					}
                                        else
                                        {
                                            String fieldName = item.getFieldName();
							
							if(fieldName.equals("id"))      //rollno
							{
								String value = item.getString();
								dtid = value;
							}/*else if(fieldName.equals("scholarno"))    //scholarno
							{
								String value = item.getString();
								dscholar = value;
							}*/else if(fieldName.equals("name"))
							{
								String value = item.getString();
								dtname = value;
							}else if(fieldName.equals("dob"))
							{
								String value = item.getString();
								dtdob = value;
							}else if(fieldName.equals("address"))
							{
								String value = item.getString();
								dtaddress = value;
							}else if(fieldName.equals("gender"))
							{
								String value = item.getString();
								dtgender = value;
							}/*else if(fieldName.equals("cast"))
							{
								String value = item.getString();
								dcast = value;
							}*/else if(fieldName.equals("mob"))
							{
								String value = item.getString();
								dtmob = value;
							}else if(fieldName.equals("relesion"))
							{
								String value = item.getString();
								dtrelesion = value;
							}else if(fieldName.equals("email"))
							{
								String value = item.getString();
								dtemail = value;
							}/*else if(fieldName.equals("fname"))
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
							}*/else if(fieldName.equals("ssub"))
							{
								String value = item.getString();
								dtssub = value;
							}else if(fieldName.equals("hstd"))
							{
								String value = item.getString();
								dthstd = value;
							}else if(fieldName.equals("pwd"))
							{
								String value = item.getString();
								dtpwd = value;
							}
                                        }
                                        
				}
                                // out.println(""+dtid);
                              // this.save(); 
/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------                               
                                                            Database
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */
                                         //out.println("Successfully connected to MySql");
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
                                                       String qry="INSERT INTO teacher_detail values('"+dtid+"','"+dtname+"','"+dtmob+"','"+dtpwd+"','"+dtaddress+"','"+dtdob+"','"+dtgender+"','"+dtrelesion+"','"+dtemail+"','"+dtssub+"','"+dthstd+"','"+picname+"')";

                                                              ps.executeUpdate(qry);
                                                              out.println("1 qry");

                                                             // out.println("Success");
                                                              this.found=true;
                                                               //out.println("\n"+id);
//******************************************************************Mail Sender***************************************************************************************************************\\
                                                        try{
                                                            Email email = new Email("Sandeshk1001@gmail.com","Sandesh@1001*");
                                                            //from 
                                                            email.setFrom(dtemail, "School Management");

                                                            email.setSubject("Conformation Your Admission");

                                                            email.setContent("<h1>Congrutulation</h1>Mr."+dtname+"<br>Your  is succesfull Registered.<br>So Please Come School And Contact for Addmission Departement for Conform Addmission..<br><h5>Thank You</h5>", "text/html");

                                                            email.addRecipient(dtemail);

                                                            email.send();

                                                            //out.println("Succesfully send Email");

                                                        }catch(Exception e){
                                                        e.printStackTrace();
                                                        }
//***************************************************************end Mail Sender**************************************************************************************************************\\

                                                       ps.close();
                                                       con.close();
                                               }

                                       catch(Exception e)
                                       {

                                               //out.println("<hr/>"+e);
                                       }      

//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                              out.println("Teacher added Succesfully");
                                //response.sendRedirect("login.jsp");    
			}
                         
			catch(Exception ex)
			{
                            out.println(ex);
			}                                        
		}
		else
		{
                    out.println("Error in File Upload");
		}                             
    }
}
