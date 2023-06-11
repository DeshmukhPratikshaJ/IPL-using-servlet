package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojos.Team;

public interface PlayerDao {
	
	String addNewP(String name, Date dob, double batAvg, double wpm, String team) throws SQLException;

}
