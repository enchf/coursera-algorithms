/**
 * 
 */
package coursera.algorithms.core.descriptor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Algorithm player descriptor.
 * @author Ernesto Espinosa.
 */
public class Descriptor implements Serializable {

	private static final long serialVersionUID = 752937L;
	
	private String title;
	private List<Player> players = new ArrayList<Player>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Player> getPlayers() {
		return players;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public class Player implements Serializable {
		
		private static final long serialVersionUID = 3372747867L;
		
		private String name;
		private String link;
		private String description;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getLink() {
			return link;
		}
		public void setLink(String link) {
			this.link = link;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
