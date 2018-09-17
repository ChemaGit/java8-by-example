package utility;

import java.util.*;

import soccer.Player;

public class PlayerDatabase {

	private static String authorList ="Messi,Pepe,Luis Suarez,Neymar,Iniesta,Pique,Cristiano,Jordi Alba,"
			+ "Maradona,Cruyff,Pele,Van Basten,Koeman,Rivaldo,Ronaldino,Romario,Shuster,Stoykoch,Rummenige,Guardiola,Xavi,Puyol,"
			+ "Figo,Gullit,Reykard,Zico,Socrates,Cerezo,Roger Millar,Etoo,Kempes,Di Stefano,Gento,Beckenbauer,Arkonada,Alan Giress,Cantona,"
			+ "Platini,Laudrup,Ronaldo,Stilike,Zidane,Futre,Lineker,Littbarsky,Cannigga,Eusebio";
	private ArrayList<Player> players;
	
	public PlayerDatabase() {
		players = new ArrayList<Player>();
		String[] listTokens = authorList.split(",");
		for(int i = 0;i < listTokens.length;i++) {
			players.add(new Player(listTokens[i]));
		}
	}
	
	public Player[] getTeam(int numberOfPlayers) throws PlayerDatabaseException {
		Player[] teamPlayers = new Player[numberOfPlayers];
		for(int i = 0;i < numberOfPlayers;i++) {
			int playerIndex = (int)(Math.random() * players.size());
			try {
				teamPlayers[i] = players.get(playerIndex);
				players.remove(playerIndex);
			} catch(IndexOutOfBoundsException ie) {
				throw new PlayerDatabaseException("Not enough players in the database for the teams requested.");
			}
		}
		return teamPlayers;
	}
}
