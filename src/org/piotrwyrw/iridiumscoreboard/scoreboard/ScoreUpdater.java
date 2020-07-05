package org.piotrwyrw.iridiumscoreboard.scoreboard;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.piotrwyrw.iridiumscoreboard.globals.Signs;

import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.Utils;

public class ScoreUpdater extends BukkitRunnable {

	public ScoreBoard sb = null;
	
	public ScoreUpdater(ScoreBoard sb) {
		this.sb = sb;
		
		// Clear all signs in the scoreboard
		for (ScorePanel sp : sb.scorepanels)
			sp.updateSign(true, null, null, 0);
	}
	
	@Override
	public void run() {
		
		for (ScorePanel sp : sb.scorepanels)
			sp.updateSign(true, null, null, 0);
		
		// Get new top data
		List<Island> top = Utils.getTopIslands();
		
		// How many stats should be displayed
		int stats = ((top.size() <= sb.count()) ? top.size() : sb.count());
		
		// Update the signs
		for (int i = 0; i < stats; i ++) {
			String ownerStr = null;
			
			Player player = Bukkit.getPlayer(UUID.fromString(top.get(i).getOwner()));
			if (player != null)
				ownerStr = player.getDisplayName();
			else {
				OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(top.get(i).getOwner()));
				if (offlinePlayer == null) continue;
				ownerStr = offlinePlayer.getName();
			}
			
			if (ownerStr == null) continue;
			
			//if (player == null) continue;
			
			sb.scorepanels.get(i).updateSign(false, ownerStr, top.get(i), i + 1);
		}
	}
	
}
