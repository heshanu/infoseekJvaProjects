package jdbc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.dto.BankDTO;
import jdbc.util.JDBCUtil;

public class BankService {

	public static void createBank(BankDTO bankDTO) throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;

		String insertSQL = "insert into banks(bankId,bankname,bankcode,status) values(?,?,?,?)";
		try {
			connection = JDBCUtil.getConnection();
			preset = connection.prepareStatement(insertSQL);
			preset.setLong(1, bankDTO.getBankid());
			preset.setString(2, bankDTO.getName());
			preset.setString(3, bankDTO.getCode());
			preset.setString(4, bankDTO.getStatus());

			int returnValue = preset.executeUpdate();

			System.out.println(returnValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			preset.close();
			connection.close();
		}

	}

	public static void updateBank(BankDTO bankdto) throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;

		String updateSql = "update banks set bankname?,bankcode=?,status=? where bankid=? ";
		connection = JDBCUtil.getConnection();

		try {
			preset = connection.prepareStatement(updateSql);
			preset.setString(1, bankdto.getName());
			preset.setString(2, bankdto.getCode());
			preset.setString(3, bankdto.getStatus());
			preset.setLong(4, bankdto.getBankid());

			int returnV = preset.executeUpdate();

			System.out.println(returnV);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void deleteBank(long bankId) {
		Connection connection = null;
		PreparedStatement preset = null;

		String deleteSql = "delete from banks where bankid=? ";
		connection = JDBCUtil.getConnection();

		try {
			preset = connection.prepareStatement(deleteSql);
			preset.setLong(1, bankId);

			int returnV = preset.executeUpdate();

			System.out.println(returnV);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				preset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static List<BankDTO> getAllBanks() throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<BankDTO> bankList = new ArrayList<BankDTO>();
		String selectSQL = "select * from banks ";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectSQL);
		rs = preset.executeQuery();

		while (rs.next()) {
			BankDTO bank = new BankDTO();
			bank.setBankid(rs.getLong("bankid"));
			bank.setName(rs.getString("bankname"));
			bank.setCode(rs.getString("bankcode"));
			bank.setStatus(rs.getString("status"));

			bankList.add(bank);

		}

		return bankList;
	}

	public static BankDTO getBankByBankId(long bankId) throws SQLException {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<BankDTO> bankList = new ArrayList<BankDTO>();
		String selectIdSQL = "select * from banks where bankid=?";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectIdSQL);
		preset.setLong(1, bankId);
		rs = preset.executeQuery();
		BankDTO bank = new BankDTO();
		while (rs.next()) {

			bank.setBankid(rs.getLong("bankid"));
			bank.setName(rs.getString("bankname"));
			bank.setCode(rs.getString("bankcode"));
			bank.setStatus(rs.getString("status"));

		}

		return bank;

	}

	public static List<BankDTO> getBanksByStatus(String status) throws Exception {
		Connection connection = null;
		PreparedStatement preset = null;
		ResultSet rs = null;
		List<BankDTO> bankList = new ArrayList<BankDTO>();
		String selectStatusSQL = "select * from banks where status=?";
		connection = JDBCUtil.getConnection();
		preset = connection.prepareStatement(selectStatusSQL);
		preset.setString(1, status);
		rs = preset.executeQuery();

		while (rs.next()) {
			BankDTO bank = new BankDTO();
			bank.setBankid(rs.getLong("bankid"));
			bank.setName(rs.getString("bankname"));
			bank.setCode(rs.getString("bankcode"));
			bank.setStatus(rs.getString("status"));
			bankList.add(bank);
		}

		return bankList;
		// return null;
	}
}
