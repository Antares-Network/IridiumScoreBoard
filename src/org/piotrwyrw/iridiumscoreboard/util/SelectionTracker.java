package org.piotrwyrw.iridiumscoreboard.util;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

public class SelectionTracker {
	public static Block track(Player player) {
		BlockIterator iterator = new BlockIterator(player, 5);
		Block last = null;
		while (iterator.hasNext()) {
			last = iterator.next();
			if (last.getType() == Material.AIR) continue;
			break;
		}
		return last;
	}
}
