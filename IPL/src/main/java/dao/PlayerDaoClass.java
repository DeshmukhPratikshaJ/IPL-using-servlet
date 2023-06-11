package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.Team;

import static utils.DButils.*;

public class PlayerDaoClass implements PlayerDao {
	Connection cn;
	PreparedStatement pst1;
	
	public PlayerDaoClass() throws SQLException {
		cn=openConnection();
		pst1=cn.prepareStatement("insert into players values(default,?,?,?,?,?)");
	}
	
	@Override
	public String addNewP(String name, Date dob, double batAvg, double wpm, String team) throws SQLException {
		pst1.setString(1, name);
		pst1.setDate(2, dob);
		pst1.setDouble(3, batAvg);
		pst1.setDouble(4, wpm);
		pst1.setString(5, team);
		int rowaffected=pst1.executeUpdate();
		if(rowaffected==1)
		return "player added successfully!!!!";
		else
			return "player not added";
	}
	
	public void cleanup() throws SQLException {
		if(pst1!=null)
			pst1.close();
		closeConnection();
	}
		
	}
