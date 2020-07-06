package org.piotrwyrw.iridiumscoreboard.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.piotrwyrw.iridiumscoreboard.globals.Signs;
import org.piotrwyrw.iridiumscoreboard.util.Fields;

import com.iridium.iridiumskyblock.Island;

public class ScorePanel {
	public Location location;
	
	public ScorePanel(Location location) {
		this.location = location;
	}
	
	public void updateSign(boolean empty, String owner, Island island, int top) {
		if (!(location.getBlock().getState() instanceof Sign)) return;
		
		Sign top_sign = ((Sign)location.getBlock().getState());
		
		List<String> content = new ArrayList<String>();
		
		if (empty) {
			for (String str : Signs.empty) {
				content.add(Fields.specialCharacterFields(str));
			}
			
			top_sign.setLine(0, content.get(0));
			top_sign.setLine(1, content.get(1));
			top_sign.setLine(2, content.get(2));
			top_sign.setLine(3, content.get(3));
			top_sign.update();
			return;
		}
		
		for (String str : Signs.sign_format) {
			content.add(Fields.specialCharacterFields(Fields.islandFields(str, owner, top, island)));
		}
		
		top_sign.setLine(0, content.get(0));
		top_sign.setLine(1, content.get(1));
		top_sign.setLine(2, content.get(2));
		top_sign.setLine(3, content.get(3));
		top_sign.update();
	}
}
