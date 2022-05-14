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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.websocket.Session;

import com.dto.UserDTO;
import com.service.LoginService;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * System.out.println("Do Post !");
		 * 
		 * String username = request.getParameter("username"); String password =
		 * request.getParameter("password");
		 * 
		 * LoginService loginService = new LoginService(); boolean isAuthenticated =
		 * loginService.authenticateUserLogin(username, password); if(isAuthenticated) {
		 * String fullName = loginService.getFullNameByUserName(username);
		 * 
		 * UserDTO userDTO = loginService.getFullDetailsOfUser(username);
		 * 
		 * request.getSession().setAttribute("fullName", fullName);
		 * request.getSession().setAttribute("userDTO", userDTO);
		 * 
		 * response.sendRedirect("home.jsp"); }else {
		 * response.sendRedirect("login.jsp"); }
		 */

		String uname = request.getParameter("username");
		String upwd = request.getParameter("password");
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		JFrame frame = new JFrame();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form?useSSL=false",
					"root", "");
			PreparedStatement pst = connection.prepareStatement("select * from user where uname=? and upwd=?");
			pst.setString(1, uname);
			pst.setString(2, upwd);

			rs = pst.executeQuery();
			if (rs.next()) {
				// request.setAttribute("sta", connection)
				session.setAttribute("name", rs.getString("uname"));
				//int result = JOptionPane.showConfirmDialog(frame, "Record has been saved!");
				// JOptionPane.showInternalConfirmDialog(desktop, "Continue printing?");

				//System.out.println(JOptionPane.CANCEL_OPTION == result);
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("status", "failed");
				//int result = JOptionPane.showConfirmDialog(frame, "Unable to save");
				// JOptionPane.showInternalConfirmDialog(desktop, "Continue printing?");

				//System.out.println(JOptionPane.CANCEL_OPTION == result);
				dispatcher = request.getRequestDispatcher("login.jsp");
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
