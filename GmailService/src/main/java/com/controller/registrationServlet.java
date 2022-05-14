package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@WebServlet("/register")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public registrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// out.print("working");
		// doGet(request, response);
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upwd = request.getParameter("password");
		String umobile = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		JFrame parent = new JFrame();

		PrintWriter out = response.getWriter();
		out.print(uname + " ");
		out.print(uemail + " ");
		out.print(upwd + " ");
		out.print(umobile + " ");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form?useSSL=false",
					"root", "");
			PreparedStatement pst = connection
					.prepareStatement("insert into user(uname,uemail,upwd,umobile) values(?,?,?,?);");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upwd);
			pst.setString(4, umobile);

			int row = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if (row > 0) {
				request.setAttribute("status", "success");
				JOptionPane.showMessageDialog(parent, "Successfully Registered!");

			} else {
				request.setAttribute("status", "Failed");
				JOptionPane.showMessageDialog(parent, "unable to Registered!");
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
