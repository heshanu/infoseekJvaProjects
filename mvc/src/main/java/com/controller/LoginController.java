package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.service.LoginService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.print("Do post method");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginService loginservice = new LoginService();
		boolean isAuthenticated = loginservice.authenticateUserLogin(username, password);

		if (isAuthenticated) {
			String fullName = loginservice.getFullNameByUserName(username);

			UserDTO userdto = loginservice.getFullDetailsOfUser(username);

			request.getSession().setAttribute("fullName", fullName);
			request.getSession().setAttribute("userDTO", userdto);
			System.out.println("successfully Login!");
			response.sendRedirect("/Home.jsp");
		} else {
			response.sendRedirect("/Login.jsp");
		}

	}

}
