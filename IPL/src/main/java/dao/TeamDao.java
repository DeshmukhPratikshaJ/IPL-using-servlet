package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Team;

public interface TeamDao {
	List<String> getTeamNames() throws SQLException;

}
