package com.surecore.serverlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.util.JDBCUtil;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();

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
		System.out.println("doPost login!");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Connection connection = null;
		PreparedStatement preset = null;

		String insertSQL = "insert into user(username,password) values(?,?)";
		try {
			connection = JDBCUtil.getConnection();
			preset = connection.prepareStatement(insertSQL);
			preset.setString(1, username);
			preset.setString(2, password);

			int returnValue = preset.executeUpdate();

			System.out.println(returnValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				preset.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// System.out.println(username + " " + password);

	}

}
