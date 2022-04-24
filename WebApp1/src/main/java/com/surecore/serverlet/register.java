package com.surecore.serverlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doget");
		String fullName = request.getParameter("fullName");

		HttpSession session = request.getSession();
		if (fullName != null) {
			session.setAttribute("sessionFullName", session);
		}
		System.out.println("session full name" + session.getAttribute("sessionFullName"));

		PrintWriter writer = response.getWriter();
		writer.print("full name" + fullName);
		writer.print("session full name" + session.getAttribute("sessionFullName") + "<br>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("dopost register");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String town = request.getParameter("town");
		String[] qualification = request.getParameterValues("qualification");

		PrintWriter writer = response.getWriter();
		// writer.print("name="+name);
		// print output show in browser
		writer.print(name + " " + address + " " + gender + " " + username + " " + password + " " + town + " " + "g1 :"
				+ qualification[0] + " " + "g2 :" + qualification[1]);

		System.out.println(name + " " + address + " " + gender + " " + username + " " + password + " " + town + " "
				+ "g1 :" + qualification[0] + " " + "g2 :" + qualification[1]);

	}

}
