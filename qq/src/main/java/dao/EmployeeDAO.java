package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Employee;

public class EmployeeDAO {

	public int registerEmployee(Employee employee) throws ClassNotFoundException {
		String INSERT_USER_SQL = "insert into employee"
				+ "(id,first_name,last_name,username,password,address,contact) values" + "(?,?,?,?,?,?,?);";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false", "root", "");
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
			preparedStatement.setInt(1, 1);
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getUsername());
			preparedStatement.setString(5, employee.getPassword());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getContact());

			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
