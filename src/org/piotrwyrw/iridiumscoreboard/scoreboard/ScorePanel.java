package org.piotrwyrw.iridiumscoreboard.scoreboard;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.piotrwyrw.iridiumscoreboard.global.SignFormats;
import org.piotrwyrw.iridiumscoreboard.util.Utilities;

import com.iridium.iridiumskyblock.Island;

public class ScorePanel {
	public Location location;
	
	public ScorePanel(Location location) {
		this.location = location;
	}
	
	public void test() {
		if (!(location.getBlock().getState() instanceof Sign)) return;
		
		Sign sign = ((Sign)location.getBlock().getState());
		
		Utilities.signContent(sign, SignFormats.test.get(0), SignFormats.test.get(1), SignFormats.test.get(2), SignFormats.test.get(3));
		
	}
	
	public void updateSign(boolean empty, String owner, Island island, int top) {
		if (!(location.getBlock().getState() instanceof Sign)) return;
		
		Sign top_sign = ((Sign)location.getBlock().getState());
		List<String> content = new ArrayList<String>();
		
		if (empty) {
			for (String str : SignFormats.empty) {
				content.add(Utilities.specialCharacterFields(str));
			}
			
			Utilities.signContent(top_sign, content.get(0), content.get(1), content.get(2), content.get(3));
			return;
		}
		
		for (String str : SignFormats.sign_format) {
			content.add(Utilities.specialCharacterFields(Utilities.islandFields(str, owner, top, island)));
		}
		
		Utilities.signContent(top_sign, content.get(0), content.get(1), content.get(2), content.get(3));
	}
}
