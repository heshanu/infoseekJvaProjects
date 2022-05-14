package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.dto.UserDTO;
import com.dto.sendboxDTO;

@WebServlet("/sendbox")
public class sendboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public sendboxServlet() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		String tot = request.getParameter("tot");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		RequestDispatcher dispatcher = null;
		Connection connection = null;
		ResultSet rs = null;
		HttpSession session1 = request.getSession();
		JFrame parent = new JFrame();
		List<sendboxDTO> sendList = new ArrayList<sendboxDTO>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form?useSSL=false",
					"root", "");
			PreparedStatement pst = connection.prepareStatement("SELECT * FROM sendtable");
			rs = pst.executeQuery();
			while (rs.next()) {

				sendboxDTO send = new sendboxDTO();
				send.setTot(rs.getString("tot"));
				send.setSubject(rs.getString("subject"));
				send.setMessage(rs.getString("message"));
				sendList.add(send);
				request.setAttribute("sendList", sendList );
				session1.setAttribute("sendList",sendList);
				dispatcher = request.getRequestDispatcher("send.jsp");
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
