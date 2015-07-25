package r04_Xml;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Pojo.Player;

@Path("xml")
public class XmlRest {

	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN) 
	public String test() {
		return "xml test method works";
	}
	
	@GET
	@Path("getPlayer")
	@Produces(MediaType.APPLICATION_XML)
	public Player getPlayer() {
		Player player = new Player();
		player.setPlayerID(10);
		player.setName("Eden");
		player.setSurname("Hazard");
		player.setTeam("Chelsea");
		player.setAge(24);
		return player;
	}
	
	@GET
	@Path("getPlayersList")
	@Produces(MediaType.APPLICATION_XML)
	public List<Player> getPlayersList() {
		Player playerHazard = new Player();
		playerHazard.setPlayerID(10);
		playerHazard.setName("Eden");
		playerHazard.setSurname("Hazard");
		playerHazard.setTeam("Chelsea");
		playerHazard.setAge(24);
		
		Player playerPirlo = new Player();
		playerPirlo.setPlayerID(21);
		playerPirlo.setName("Andrea");
		playerPirlo.setSurname("Pirlo");
		playerPirlo.setTeam("Chelsea");
		playerPirlo.setAge(36);
		
		List<Player> players = new ArrayList<Player>();
		players.add(playerHazard);
		players.add(playerPirlo);
		return players;
	}
	
}
