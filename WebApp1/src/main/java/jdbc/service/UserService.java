package jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.dto.UsersDTO;
import jdbc.util.JDBCUtil;
import com.surecore.serverlet.*;

public class UserService {
	public static void createUser(UsersDTO usersDTO) throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;

		register r=new register();
		String insertSQL = "insert into users(name,address,gender,username,password,town,qualification) values(?,?,?,?,?,?,?)";
		try {
			connection = JDBCUtil.getConnection();
			preset = connection.prepareStatement(insertSQL);
			preset.setString(1,usersDTO.getName());
			preset.setString(2, usersDTO.getAddress());
			preset.setString(3, usersDTO.getGender());
			preset.setString(4, usersDTO.getUsername());
			preset.setString(5, usersDTO.getPassword());
			preset.setString(6, usersDTO.getTown());
			preset.setString(7, usersDTO.getQualification());
			

			int returnValue = preset.executeUpdate();

			System.out.println(returnValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			preset.close();
			connection.close();
		}

	}


}
