package org.piotrwyrw.iridiumscoreboard.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.piotrwyrw.iridiumscoreboard.globals.Signs;

import com.iridium.iridiumskyblock.Island;

public class ScorePanel {
	public Location location;
	
	public ScorePanel(Location location) {
		this.location = location;
	}
	
	public void updateSign(boolean empty, String owner, Island island, int top) {
		if (!(location.getBlock().getState() instanceof Sign)) return;
		
		Sign top_sign = ((Sign)location.getBlock().getState());
		
		if (empty) {
			top_sign.setLine(0, "");
			top_sign.setLine(1, "");
			top_sign.setLine(2, "");
			top_sign.setLine(3, "");
			top_sign.update();
			return;
		}
		
		List<String> content = new ArrayList<String>();
		for (String str : Signs.sign_format) {
			String nc = str;
			nc = nc.replaceAll("\\{PLAYER\\}", owner);
			nc = nc.replaceAll("\\{NUMBER\\}", String.valueOf(top));
			nc = nc.replaceAll("\\{VALUE\\}", String.valueOf(island.getValue()));
			content.add(nc);
		}
		
		top_sign.setLine(0, content.get(0));
		top_sign.setLine(1, content.get(1));
		top_sign.setLine(2, content.get(2));
		top_sign.setLine(3, content.get(3));
		top_sign.update();
	}
}
