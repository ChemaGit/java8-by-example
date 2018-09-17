package soccer;

public class Team implements Comparable<Team>{
	
	private String teamName;
	private Player[]playerArray;
	private int pointsTotal;
	private int gameEventsTotal;
	
	public Team() {
		
	}
	
	public Team(String teamName) {
		this.teamName = teamName;
	}
	
	public Team(String teamName, Player[] players) {
		this(teamName);
		this.playerArray = players;
	}	
	
	public void incPointsTotal(int points) {
		this.pointsTotal += points;
	}
	
	public void incGoalsTotal(int goals) {
		this.gameEventsTotal += goals;
	}
	
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Player[] getPlayerArray() {
		return playerArray;
	}
	public void setPlayerArray(Player[] playerArray) {
		this.playerArray = playerArray;
	}

	public int getPointsTotal() {
		return pointsTotal;
	}

	public void setPointsTotal(int pointsTotal) {
		this.pointsTotal = pointsTotal;
	}

	public int getGameEventsTotal() {
		return gameEventsTotal;
	}

	public void setGameEventsTotal(int gameEventsTotal) {
		this.gameEventsTotal = gameEventsTotal;
	}

	@Override
	public int compareTo(Team theTeam) {
		int returnValue = -1;
		
		if(this.getPointsTotal() < theTeam.getPointsTotal()) {
			returnValue = 1;
		} else if(this.getPointsTotal() == theTeam.getPointsTotal()){
			if(this.getGameEventsTotal() < theTeam.getGameEventsTotal()) {
				returnValue = 1;
			}
		}
		
		return returnValue;
	}
	
	
	
}
