package com.registratiion.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/registration")
public class RegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String uName=request.getParameter("userName");
		Integer uAge=Integer.parseInt(request.getParameter("userAge"));
		String uEmail=request.getParameter("userEmail");
		String uMobile=request.getParameter("userMobile");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// userage if less than 18 or greater than 30 not eligible for recruitement
		if (uAge < 19 || uAge > 30) {
			response.sendError(504, "User Age is not sufficent for this Recruitement");
		} else {
			HttpSession session =request.getSession();
			session.setAttribute("userName", uName);
			session.setAttribute("userMobile", uMobile);
			
			
			// otherwise, student is eligible for recruitment
			out.println("<html><head><title>Output</title></head>");
			out.println("<body>");
			out.println("<font color = 'red'>");
			out.println("<h2>iNeuron Consultancy Services</h2>");
			out.println("<h2>User registration Details</h2>");
			out.println("</font>");
			out.println("<table border ='1'>");
			out.println("<tr><td>User Name </td><td>" + uName + "</td></tr>");
			out.println("<tr><td>User Age </td><td>" + uAge + "</td></tr>");
			out.println("<tr><td>Email</td><td>" + uEmail + "</td></tr>");
			out.println("<tr><td>Mobile Number</td><td>" + uMobile + "</td></tr>");
			out.println("<tr><td>Registration status </td><td>REGISTERD SUCCESSFULLY</td></tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		}
		out.close();
	}

}
