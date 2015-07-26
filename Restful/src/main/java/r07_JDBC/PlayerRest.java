package r07_JDBC;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Pojo.Player;

@Path("players")
public class PlayerRest {

	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN) 
	public String test() {
		return "players test method works";
	}
	
	@GET
	@Path("getAllPlayers")
	@Produces(MediaType.APPLICATION_JSON) 
	public List<Player> getAllPlayers() {
		return new PlayerDB().getAll();
	}
	
	@GET
	@Path("findPlayerByName")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Player> getPlayersList(
			@QueryParam("name") String name) {
		return new PlayerDB().findByName(name);
	}
	
	@GET
	@Path("add")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertPlayer(
			@QueryParam("name") String name,
			@QueryParam("surname") String surname,
			@QueryParam("team") String team,
			@QueryParam("age") int age
			) {
		Player player = new Player();
		player.setName(name);
		player.setSurname(surname);
		player.setTeam(team);
		player.setAge(age);
		return new PlayerDB().insertPlayer(player) ? "success" : "failed";
	}
	
	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String deletePlayer(
			@QueryParam("playerId") int playerId
			) {
		return new PlayerDB().deletePlayer(playerId) ? "success" : "failed";
	}
	
	@GET
	@Path("update")
	@Produces(MediaType.APPLICATION_JSON)
	public String insertPlayer(
			@QueryParam("age") int playerId,
			@QueryParam("name") String name,
			@QueryParam("surname") String surname,
			@QueryParam("team") String team,
			@QueryParam("age") int age
			) {
		Player player = new Player();
		player.setName(name);
		player.setSurname(surname);
		player.setTeam(team);
		player.setAge(age);
		return new PlayerDB().updatePlayer(playerId, player) ? "success" : "failed";
	}
}
