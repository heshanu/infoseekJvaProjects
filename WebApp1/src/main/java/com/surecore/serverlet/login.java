package com.surecore.serverlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

		try {
			Connection connection = JDBCUtil.getConnection();
			// Connection connection = null;
			PreparedStatement preset = null;
			ResultSet rs = null;
			int rowCount = 0;

			// register r=new register();
			String SelectSQL = "select * from usersx";
			if (username != null && password != null) {
				// System.out.println("Login success");
				preset = connection.prepareStatement(SelectSQL);
				rs = preset.executeQuery();

				while (rs.next()) {
					rowCount++;
				}
				if (rowCount >= 1) {
					System.out.println("successfuly login");
				} else {
					System.out.println("cannot find matching!");
				}

				// preset.setString(1,usersDTO.getName());
				// preset.setString(2, usersDTO.getAddress());

			}

			System.out.println(username + " " + password + " " + rowCount);

		} catch (Exception e) {
			System.out.println(e);
		}

		// System.out.println(username + " " + password);

	}

}
