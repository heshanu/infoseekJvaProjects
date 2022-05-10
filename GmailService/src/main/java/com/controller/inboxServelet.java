package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/inbox")
public class inboxServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public inboxServelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		String tot = request.getParameter("tot");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		RequestDispatcher dispatcher = null;
		Connection connection = null;
		HttpSession session = request.getSession();
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form?useSSL=false",
					"root", "");
			PreparedStatement pst = connection
					.prepareStatement("insert into sendtable(tot,subject,message) values(?,?,?);");
			pst.setString(1, tot);
			pst.setString(2, subject);
			pst.setString(3, message);

			int row = pst.executeUpdate();

			if (rs.next()) {
				// request.setAttribute("sta", connection)
				session.setAttribute("tot", rs.getString("tot"));
				session.setAttribute("subject", rs.getString("subject"));
				session.setAttribute("message", rs.getString("message"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			}

			dispatcher = request.getRequestDispatcher("send.jsp");
			if (row > 0) {
				request.setAttribute("status", "success");

			} else {
				request.setAttribute("status", "Failed");
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
