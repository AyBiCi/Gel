package mainGel;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.entity.Player;

public class PlayerGelManager {
	private HashMap<String, GelManager> gelMan = new HashMap<String, GelManager>();
	
	public GelManager getGelManager(Player player) {
		if(DoesManagerExist(player)) {
			return gelMan.get(player.getName());
		}
		else {
			CreateGelManager(player);
			return gelMan.get(player.getName());
		}
	}
	
	private void CreateGelManager(Player player) {
		gelMan.put(player.getName(),new GelManager());
	}
	
	private boolean DoesManagerExist(Player player) {
		return gelMan.containsKey(player.getName());
	}
	public void KillAllGel() {
		for(Entry<String, GelManager> gMan : gelMan.entrySet()) {
			gMan.getValue().DeleteAllGel();
		}
	}
	
}
