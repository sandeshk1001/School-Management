/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

import com.email.durgesh.Email;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SANDESH
 */
public class genotp extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String To=request.getParameter("To");
        String Subject=request.getParameter("Subject");
        String Message=request.getParameter("Message");
        PrintWriter out= response.getWriter();  
        
        HttpSession session = request.getSession(true);
    
	String otpmsg = "Your One Time Password is ";
	
        int otp =  (int) Math.floor(100000 + Math.random() * 900000);
        String emailid = (String) session.getAttribute("email");
        session.setAttribute("otpcode" , otp);
	//text local coding start

	otpmsg = otpmsg + otp + " by School";
	try {
                Email email = new Email("example@gmail.com","123");
                //from 
                email.setFrom(emailid, "School Management");

                email.setSubject("Forgot Password");

                email.setContent("<h4>"+otpmsg+"</h4>", "text/html");

                email.addRecipient(emailid);
                email.send();
                //out.println("<script type=\"text/javascript\">alert('"+otpmsg+"')</script>");
                //out.println("Succesfully");
			
		out.println("otp sent successfully");
		Thread.sleep(1000);
                response.sendRedirect("dashboard_student/examples/genotp.jsp");
	}
		catch (Exception e)
		{
                    out.println("Error SMS "+e);
		//return "Error "+e;
		}
	//text local coding ends
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
