package com.online.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.factory.CustomerDetailControllerFactory;
import com.online.model.CustomerDetails;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IsCustomerDetailController customerDetailController = CustomerDetailControllerFactory
				.getCustomerDetailController();
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		RequestDispatcher rd = null;
		String status = null;
		if (requestURI.endsWith("layout")) {
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		}

		if (requestURI.endsWith("addform")) {
			System.out.println("****From Add Page");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");
			System.out.println(sname);
			System.out.println(sage);
			System.out.println(saddress);
			CustomerDetails customerDetail = new CustomerDetails();
			customerDetail.setCustomerName(sname);
			customerDetail.setCustomerAge(Integer.parseInt(sage));
			customerDetail.setCustomerAddress(saddress);
			status = customerDetailController.save(customerDetail);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record inserted succesfully...");
				
				
				out.print("<h1>");
				out.print("Record inserted succesfully...");
				out.print("</h1>");
				
			} else if (status.equalsIgnoreCase("failure")) {
				System.out.println("Record insertion failed...");
				out.print("<h1>");
				out.print("Record insertion failed...");
				out.print("</h1>");
				
			} else {
				System.out.println("Some problem occured...");
				out.print("<h1>");
				out.print("Record insertion failed...");
				out.print("</h1>");
			}

		}
		if (requestURI.endsWith("updateform")) {
			System.out.println("****From update Page");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");
			String snumber = request.getParameter("snumber");
			System.out.println(sname);
			System.out.println(sage);
			System.out.println(saddress);
			System.out.println(snumber);
			
			CustomerDetails customerDetail = new CustomerDetails();
			customerDetail.setCustomerName(sname);
			customerDetail.setCustomerAge(Integer.parseInt(sage));
			customerDetail.setCustomerAddress(saddress);
			customerDetail.setCustomerNo(Integer.parseInt(snumber));
			status = customerDetailController.updateById(customerDetail);
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record Updated succesfully...");
				out.print("<h1>");
				out.print("Record Updated succesfully...");
				out.print("</h1>");
				
			} else if (status.equalsIgnoreCase("failure")) {
				System.out.println("Record Updation failed...");
				out.print("<h1>");
				out.print("Record Updation failed...");
				out.print("</h1>");
				
			} else {
				System.out.println("Some problem occured...");
				out.print("<h1>");
				out.print("Record Updation failed...");
				out.print("</h1>");
			}
			
		}
		if (requestURI.endsWith("searchform")) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			CustomerDetails customerDetail = new CustomerDetails();
			try {
			System.out.println("****From Searcb Page");
			String sNumber = request.getParameter("snumber");
			System.out.println("from Search Page");
			System.out.println("sNumber = "+sNumber);
			
			customerDetail=customerDetailController.findById(Integer.parseInt(sNumber));
			
			if(customerDetail != null) {
				out.print("<html> <body>");
				out.print("<br/><br/>");
				out.print("<h1> CUSTOMER DETAILS FOR CUSTOMER ID : "+sNumber+" </h1> ");
				
				out.print(" <table  border=\"2\"> ");
				out.print("<tr><td>CUSTOMER_NO</td> <td>CUSTOMER_NAME</td> <td>CUSTOMER_AGE</td> <td>CUSTOMER_ADDRESS</td></tr>");
				out.print("<tr><td>"+customerDetail.getCustomerNo()+"</td> <td>"+customerDetail.getCustomerName()+"</td> <td>"+customerDetail.getCustomerAge()+"</td> <td>"+customerDetail.getCustomerAddress()+"</td></tr>");
				out.print("</table>");
				out.print(" </body> </html>");
			}else {
				System.out.println("No Record Found...");
				out.print("<html> <body>");
				out.print("<h1>");
				out.print("No Record Found...");
				out.print("</h1>");
				out.print(" </body> </html>");
			}
			}catch(NumberFormatException ex) {
				out.print("<html> <body>");
				out.print("<h1>");
				out.print("Please provide correct number...");
				out.print("</h1>");
				out.print(" </body> </html>");
			}catch (Exception e) {
				out.print("<html> <body>");
				out.print("<h1>");
				out.print("Exception...");
				out.print("</h1>");
				out.print(" </body> </html>");
			}
			
		}

		if (requestURI.endsWith("deleteform")) {
			System.out.println("****From Delete Page");

			String snumber = request.getParameter("snumber");
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			System.out.println(snumber);
			try {
			status=customerDetailController.deleteById(Integer.parseInt(snumber));
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record deleted succesfully...");
				out.print("<h1>");
				out.print("Customer Id : "+snumber+" deleted succesfully...");
				out.print("</h1>");
				
			} else if (status.equalsIgnoreCase("failure")) {
				System.out.println("Record deletion failed...");
				out.print("<h1>");
				out.print("Record deletion failed...");
				out.print("</h1>");
				
			} else {
				System.out.println("Some problem occured...");
				out.print("<h1>");
				out.print("Record deletion failed...");
				out.print("</h1>");
			}
			}catch(NumberFormatException ex) {
				out.print("<html> <body>");
				out.print("<h1>");
				out.print("Please provide correct number...");
				out.print("</h1>");
				out.print(" </body> </html>");
			}catch (Exception e) {
				out.print("<html> <body>");
				out.print("<h1>");
				out.print("Exception...");
				out.print("</h1>");
				out.print(" </body> </html>");
			}
		}

	}
}
