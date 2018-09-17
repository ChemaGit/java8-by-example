package soccer;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utility.PlayerDatabase;
import utility.PlayerDatabaseException;

/**
 * Main Class of the Soccer League.
 * @author Jose Maria Nacher Fernandez
 *
 */

public class League {

	public static void main(String args[]) {
		//TODO code application code here.
		League theLeague = new League();
		
		try{
			Team[] newTeams = theLeague.createTeams("Barcelona,Real Madrid,Atletico de Madrid,Atleti de Bilbao", 11);
			
			Game[] newGames = theLeague.createGames(newTeams);
			
			System.out.println(theLeague.getLeagueAnnouncement(newGames));
			
			for(Game currGame : newGames) {
				currGame.playGame();			
				System.out.println(currGame.getDescription(currGame.getGameEvents()));
			}
			
			theLeague.showBestTeam(newTeams);
			theLeague.showBestPlayers(newTeams);
		}catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	/**
	 * Static method that returns a Team array
	 * @return
	 * @throws PlayerDatabaseException 
	 */
	public Team[] createTeams(String teamNames, int teamSize) throws PlayerDatabaseException {
		PlayerDatabase playerDB = new PlayerDatabase();				
		
		String[] tokenTeams = teamNames.split(",");
		Team[] newTeams = new Team[tokenTeams.length];	
		for(int i = 0;i < tokenTeams.length;i++) {
			newTeams[i] = new Team(tokenTeams[i], playerDB.getTeam(teamSize));
		}

		return newTeams;
	}
	
	/**
	 * Static method that returns a Game array
	 * @param teams
	 * @return
	 */
	public Game[] createGames(Team[] teams) {
		ArrayList<Game> theGames = new ArrayList<Game>();
		int daysBetweenGames = 0;
		
		for(Team homeTeam : teams){
			for(Team awayTeam : teams) {				
				if(homeTeam != awayTeam) {
					daysBetweenGames += 7;
					theGames.add(new Game(homeTeam,awayTeam,LocalDateTime.now().plusDays(daysBetweenGames)));
				}
			}
		}
		
		return (Game[])theGames.toArray(new Game[1]);
	}
	
	/**
	 * Show the Best Team in the League
	 * @param theTeams
	 */
	public void showBestTeam(Team [] theTeams) {
		Arrays.sort(theTeams);
		Team currBestTeam = theTeams[0];
		System.out.println("\n Team Points \n");
		for(Team currTeam : theTeams) {
			System.out.println("\n" + currTeam.getTeamName() + " : " + currTeam.getPointsTotal() + " : " + currTeam.getGameEventsTotal() + "\n");
		}		
		System.out.println("\nThe winner of the League is: " + currBestTeam.getTeamName() + "\n");
	}
	
	public String getLeagueAnnouncement(Game[] theGames){
		Period thePeriod = Period.between(theGames[0].getTheDateTime().toLocalDate(), 
				theGames[theGames.length - 1].getTheDateTime().toLocalDate());
		
		return "\nThe League is scheduled to run for" + thePeriod.getMonths() + 
				" month(s), and " + thePeriod.getDays() + " days(s)\n";
	}
	
	public void showBestPlayers(Team[] theTeams) {
		ArrayList<Player> thePlayers = new ArrayList<Player>();
		
		System.out.println("\nBest PLAYERS\n");
		
		for(Team currTeam : theTeams) {
			thePlayers.addAll(Arrays.asList(currTeam.getPlayerArray()));
		}
		
		Collections.sort(thePlayers, (p1, p2) -> Double.valueOf(p2.getGoalsScored()).compareTo(Double.valueOf(p1.getGoalsScored()))  );
		
		for(Player currPlayer : thePlayers) {
			System.out.println("\n" + currPlayer.getPlayerName() + " : " + currPlayer.getGoalsScored() + "\n");
		}
	}
}

/*
for(Player thePlayer : team1.getPlayerArray()) {
	if(thePlayer.getPlayerName().contains("Sabatini")) {
		System.out.println("I found my Player in Team 1, and is: " + thePlayer.getPlayerName());
	} else {
		System.out.println("I didn't find my Player in Team 1.");
	}
}

for(Player thePlayer : team2.getPlayerArray()) {
	if(thePlayer.getPlayerName().contains("Sabatini")) {
		System.out.println("I found my Player in Team 2, and is: " + thePlayer.getPlayerName());
	} else {
		System.out.println("I didn't find my Player in Team 2.");
	}
}


for(Player thePlayer : team2.getPlayerArray()) {
	if(thePlayer.getPlayerName().matches(".*Sab.*") && currGame.getGoals() != null && currGame.getGoals().length > 0) {
		System.out.println("Goal scored after " + currGame.getGoals()[0].getTheTime() + " mins by " +
				currGame.getGoals()[0].getThePlayer().getPlayerName() + " of " + 
				currGame.getGoals()[0].getTheTeam().getTeamName());	
		
		String[]completeName = thePlayer.getPlayerName().split(" ");
		String firstName = completeName[0];
		String lastName = completeName[1];
		System.out.println("Found: " + thePlayer.getPlayerName());
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
	}
}	

StringBuilder familyNameFirst = new StringBuilder();
for(Player thePlayer : team1.getPlayerArray()) {
	String[] completeName = thePlayer.getPlayerName().split(" ");
	familyNameFirst.append(completeName[1]);
	familyNameFirst.append(", ");
	familyNameFirst.append(completeName[0]);
	System.out.println(familyNameFirst);
	familyNameFirst.delete(0, familyNameFirst.length());
}*/
