package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

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
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);

		IStudentService stdService = StudentServiceFactory.getStudentService();

		RequestDispatcher rd = null;
		if (requestURI.endsWith("layout")) {
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		}

		if (requestURI.endsWith("addform")) {
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");

			Student student = new Student();
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddr(saddress);

			String status = stdService.save(student);
			System.out.println(status);

			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../result.jsp");
				ServletContext context = getServletContext();
				context.setAttribute("insert", "success");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../result.jsp");
				ServletContext context = getServletContext();
				context.setAttribute("insert", "failure");
				rd.forward(request, response);
			}

		}
		if (requestURI.endsWith("searchform")) {
			String sid = request.getParameter("sid");
			Student student = stdService.findById(Integer.parseInt(sid));
			request.setAttribute("student", student);
			rd = request.getRequestDispatcher("../studentDisp.jsp");
			rd.forward(request, response);

		}
		if (requestURI.endsWith("deleteform")) {
			String sid = request.getParameter("sid");
			String status = stdService.deleteById(Integer.parseInt(sid));

			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../deleteresult.jsp");
				request.setAttribute("delete", "success");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				rd = request.getRequestDispatcher("../deleteresult.jsp");
				request.setAttribute("delete", "failure");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../deleteresult.jsp");
				request.setAttribute("delete", "notfound");
				rd.forward(request, response);
			}
		}
		if (requestURI.endsWith("editform")) {
			String sid = request.getParameter("sid");
			Student student = stdService.findById(Integer.parseInt(sid));
			if (student != null) {
				request.setAttribute("student", student);
				rd = request.getRequestDispatcher("../edit.jsp");
				rd.forward(request, response);
			}
		}

		if (requestURI.endsWith("update")) {

			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddr = request.getParameter("saddr");

			Student student = new Student();
			student.setSid(Integer.parseInt(sid));
			student.setSname(sname);
			student.setSage(Integer.parseInt(sage));
			student.setSaddr(saddr);

			String status = stdService.updateById(student);
			if (status.equals("success")) {
				request.setAttribute("status", status);
				rd = request.getRequestDispatcher("../../disp.jsp");
				rd.forward(request, response);
			}
		}
	}
}
