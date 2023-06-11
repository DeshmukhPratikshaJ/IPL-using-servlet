package pojos;

public class Team {

	//| tname | shortname | total_players | owner | max_age
	
	private String teamName ;
	private String shortName;
	private int totalPlayers;
	private String ownerName;
	private int maxAge;
	
	public Team(String teamName, String shortName, int totalPlayers, String ownerName, int maxAge) {
		this.teamName = teamName;
		this.shortName = shortName;
		this.totalPlayers = totalPlayers;
		this.ownerName = ownerName;
		this.maxAge = maxAge;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getTotalPlayers() {
		return totalPlayers;
	}

	public void setTotalPlayers(int totalPlayers) {
		this.totalPlayers = totalPlayers;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	@Override
	public String toString() {
		return "Player [teamName=" + teamName + ", shortName=" + shortName + ", totalPlayers=" + totalPlayers
				+ ", ownerName=" + ownerName + ", maxAge=" + maxAge + "]";
	}
	
	
	
}
