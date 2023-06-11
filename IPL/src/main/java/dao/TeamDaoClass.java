package dao;

import static utils.DButils.closeConnection;
import static utils.DButils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import pojos.Team;

public class TeamDaoClass implements TeamDao {
		Connection cn;
		PreparedStatement pst1;
		
		
		public TeamDaoClass() throws SQLException {
			cn=openConnection();
			pst1=cn.prepareStatement("select shortname from teams");
			System.out.println("team dao instance created");
		}
		
		@Override
		public List<String> getTeamNames() throws SQLException{
			List<String> teamsNames=new ArrayList<>();
			
			try(ResultSet rst=pst1.executeQuery()){
				while(rst.next())
				teamsNames.add(rst.getString(1));
			}
			return teamsNames;
			
			
		}
		
		public void cleanup() throws SQLException {
			if(pst1!=null)
				pst1.close();
			closeConnection();
		}
}
