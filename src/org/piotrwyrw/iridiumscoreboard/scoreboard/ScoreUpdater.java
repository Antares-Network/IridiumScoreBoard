package org.piotrwyrw.iridiumscoreboard.scoreboard;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.piotrwyrw.iridiumscoreboard.global.SignFormats;

import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.Utils;

public class ScoreUpdater extends BukkitRunnable {

	public ScoreBoard sb = null;
	
	public ScoreUpdater(ScoreBoard sb) {
		this.sb = sb;
		
		for (ScorePanel sp : sb.scorepanels)
			sp.updateSign(true, null, null, 0);
	}
	
	@Override
	public void run() {
		for (ScorePanel sp : sb.scorepanels)
			sp.updateSign(true, null, null, 0);
		
		List<Island> top = Utils.getTopIslands();
		
		int stats = ((top.size() <= sb.count()) ? top.size() : sb.count());
		
		for (int i = 0; i < stats; i ++) {
			String ownerStr = null;
			Player player = Bukkit.getPlayer(UUID.fromString(top.get(i).getOwner()));
			
			if (player != null) {
				ownerStr = ((CraftPlayer)player).getHandle().getDisplayName().getText();
			} else {
				OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(top.get(i).getOwner()));
				if (offlinePlayer == null) continue;
				ownerStr = offlinePlayer.getName();
			}
			
			if (ownerStr == null) continue;
			
			sb.scorepanels.get(i).updateSign(false, ownerStr, top.get(i), i + 1);
		}
	}
	
}
