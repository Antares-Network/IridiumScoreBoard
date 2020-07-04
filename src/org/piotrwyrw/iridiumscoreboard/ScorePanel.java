package org.piotrwyrw.iridiumscoreboard;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;

import com.iridium.iridiumskyblock.Island;

public class ScorePanel {
	public Location location;
	
	public ScorePanel(Location location) {
		this.location = location;
	}
	
	public void updateSign(String[] values) {
		if (!(location.getBlock().getState() instanceof Sign)) return;
		
		Sign top_sign = ((Sign)location.getBlock().getState());
		
		if (values[0] != "" && values[1] != "") {
			top_sign.setLine(0, "§8- - - - - - - -");
			top_sign.setLine(1, "§3" + values[0]);
			top_sign.setLine(2, "§7" + values[1]);
			top_sign.setLine(3, top_sign.getLine(0));
			top_sign.update();
			return;
		}
		
		top_sign.setLine(0, "§8- - - - - - - -");
		top_sign.setLine(1, "");
		top_sign.setLine(2, "");
		top_sign.setLine(3, top_sign.getLine(0));
		top_sign.update();
		return;
	}
}
