package com.online.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



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

	private final String UPLOAD_DIRECTORY = "D:\\uploads";

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		RequestDispatcher rd = null;
		String status = "";

		System.out.println("requestURI : " + requestURI);

		if (requestURI.endsWith("upload")) {
			System.out.println("From Do Post File Upload");
			System.out.println("UPLOAD_DIRECTORY " + UPLOAD_DIRECTORY);
			System.out.println("File name " + request.getParameter("file"));
			System.out.println("ServletFileUpload : " + ServletFileUpload.isMultipartContent(request));

			if (ServletFileUpload.isMultipartContent(request)) {
				try {
					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

					for (FileItem item : multiparts) {
						if (!item.isFormField()) {
							String name = new File(item.getName()).getName();
							item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
						}
					}

					// File uploaded successfully
					request.setAttribute("message", "File Uploaded Successfully");
				} catch (Exception ex) {
					request.setAttribute("message", "File Upload Failed due to " + ex);
				}

			} else {
				request.setAttribute("message", "Sorry this Servlet only handles file upload request");
			}

			request.getRequestDispatcher("/FileUploadResult.jsp").forward(request, response);


		}
	}
}