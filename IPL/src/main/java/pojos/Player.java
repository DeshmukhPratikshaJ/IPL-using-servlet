package pojos;

import java.sql.Date;

public class Player {
//pid | pname  | dob | bat_avg | wpm  | team
private int playerId;
private String name;
private Date dob;
private double batAvg;
private double wpm;
private Team team;

public Player(int playerId, String name, Date dob, double batAvg, double wpm, Team team) {
	this.playerId = playerId;
	this.name = name;
	this.dob = dob;
	this.batAvg = batAvg;
	this.wpm = wpm;
	this.team = team;
}

public int getPlayerId() {
	return playerId;
}

public void setPlayerId(int playerId) {
	this.playerId = playerId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}

public double getBatAvg() {
	return batAvg;
}

public void setBatAvg(double batAvg) {
	this.batAvg = batAvg;
}

public double getWpm() {
	return wpm;
}

public void setWpm(double wpm) {
	this.wpm = wpm;
}

public Team getTeam() {
	return team;
}

public void setTeam(Team team) {
	this.team = team;
}

@Override
public String toString() {
	return "Player [playerId=" + playerId + ", name=" + name + ", dob=" + dob + ", batAvg=" + batAvg + ", wpm=" + wpm
			+ ", team=" + team + "]";
}


}
