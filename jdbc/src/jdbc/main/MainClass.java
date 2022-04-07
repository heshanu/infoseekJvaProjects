package jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import jdbc.dto.BankDTO;
import jdbc.service.BankService;
import jdbc.util.JDBCUtil;

public class MainClass {
	// Connection connection;
	public static void main(String[] args) throws Exception {
		BankDTO bank1 = new BankDTO();
//BankService.updateBank(bank1);
		//BankService.deleteBank(1L);
		List<BankDTO> banks=BankService.getBanksByStatus("A");
		//System.out.println(banks.size());
		
		for(BankDTO bankDTO:banks) {
			System.out.println(bankDTO);
		}
	}

}
