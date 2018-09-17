package soccer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
	
	private Team homeTeam;
	private Team awayTeam;
	private GameEvent[] gameEvents;
	private LocalDateTime theDateTime;
	
	public Game() {
		
	}
	
	public Game(Team homeTeam, Team awayTeam, LocalDateTime theDateTime) {
		this.theDateTime = theDateTime;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}
	
	/**
	 * Method plays a game
	 */
	public void playGame() {
		ArrayList<GameEvent>eventList = new ArrayList<GameEvent>();
		GameEvent currEvent;
		
		for(int i = 0;i <= 90;i++) {
			if(Math.random() > 0.8) {
				currEvent = Math.random() > 0.6 ? new Goal() : new Possession();
				currEvent.setTheTeam(Math.random() > 0.5 ? this.homeTeam : this.awayTeam);
				int player = currEvent.getTheTeam().getPlayerArray().length;
				double ram = Math.random();
				int playerGoal = (int)(player * ram);
				Player p = currEvent.getTheTeam().getPlayerArray()[playerGoal];
				currEvent.setThePlayer(p);
				currEvent.setTheTime(i);
				eventList.add(currEvent);
			}			
		}
		this.gameEvents = new GameEvent[eventList.size()];
		eventList.toArray(this.gameEvents);
	}

	/**
	 * Method broadcasts a Game
	 * @param newGoals
	 * @return
	 */
	public String getDescription(GameEvent[] newGameEvents) {
		int homeTeamGoals = 0;
		int awayTeamGoals = 0;
		StringBuilder description = new StringBuilder();
		
		description.append("\n" + homeTeam.getTeamName() + " vs " + awayTeam.getTeamName() + "\n");
		description.append("Date " + this.theDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n");
		
		for(GameEvent currEvent : this.gameEvents) {
			
			if(currEvent instanceof Goal) {
				if(currEvent.getTheTeam() == this.homeTeam) {
					homeTeamGoals++;
					this.homeTeam.incGoalsTotal(1);
				} else {
					awayTeamGoals++;
					this.awayTeam.incGoalsTotal(1);
				}	
				currEvent.getThePlayer().incGoalsScored();
			}
			
			description.append("\n" + currEvent + " after " + currEvent.getTheTime() + " mins by " + 
					currEvent.getThePlayer().getPlayerName() + " of " + currEvent.getTheTeam().getTeamName() + "\n");
		}		
		
		if(homeTeamGoals == awayTeamGoals) {
			description.append("\nIt's a draw.\n");
			homeTeam.incPointsTotal(1);
			awayTeam.incPointsTotal(1);
		} else if(homeTeamGoals > awayTeamGoals) {
			description.append("\n" + this.homeTeam.getTeamName() + " win (" + homeTeamGoals + " - " + awayTeamGoals + ")\n");
			homeTeam.incPointsTotal(2);
		} else {
			description.append("\n" + this.awayTeam.getTeamName() + " win (" + homeTeamGoals + " - " + awayTeamGoals + ")\n");
			awayTeam.incPointsTotal(2);
		}
		
		
		
		return description.toString();
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	public GameEvent[] getGameEvents() {
		return gameEvents;
	}

	public void setGameEvents(Goal[] gameEvents) {
		this.gameEvents = gameEvents;
	}

	public LocalDateTime getTheDateTime() {
		return theDateTime;
	}

	public void setTheDateTime(LocalDateTime theDateTime) {
		this.theDateTime = theDateTime;
	}
	
	
}
