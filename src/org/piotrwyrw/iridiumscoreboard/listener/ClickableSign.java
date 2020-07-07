package org.piotrwyrw.iridiumscoreboard.listener;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreBoard;
import org.piotrwyrw.iridiumscoreboard.util.LocationComparator;

import com.iridium.iridiumskyblock.Island;
import com.iridium.iridiumskyblock.Utils;

public class ClickableSign implements Listener {
	
	@EventHandler
	public void signClicked(PlayerInteractEvent evt) {
		
		if (evt.getAction() != Action.RIGHT_CLICK_BLOCK || !(evt.getClickedBlock().getState() instanceof Sign)) {
			return;
		}
		
		ScoreBoard sb = IridiumScoreBoard.getScoreBoard();
		List<Island> top = Utils.getTopIslands();
		int iterations = ((top.size() <= sb.count()) ? top.size() : sb.count());
		
		for (int a = 0; a < iterations; a ++) {
			Location loc = sb.scorepanels.get(a).location;
			if (LocationComparator.isSame(loc, evt.getClickedBlock().getLocation())) {
				for (int b = 0; b < Utils.getTopIslands().size(); b ++) {
					if (a == b) {
						if (!top.get(b).isVisit()) {
							evt.getPlayer().sendMessage(Messages.IS_PRIVATE);
							break;
						}
						evt.getPlayer().teleport(top.get(b).getHome());
						evt.getPlayer().sendMessage(Messages.IS_SB_TP);
					}	
				}	
			}
		}
		return;
	}
}
