package org.piotrwyrw.iridiumscoreboard.config;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Configs;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Signs;

public class IridiumScoreBoardConfiguration {
	public IridiumScoreBoardConfiguration() {
		IridiumScoreBoard isb = IridiumScoreBoard.getInstance();
		FileConfiguration config = isb.getConfig();
		
		File configFile = new File(isb.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			isb.getLogger().info("---- Creating configuration file .. ----");
			isb.saveResource("config.yml", true);
		}
		
		if (config.get(Configs.MESSAGE_PREFIX) != null) {
			Messages.PREFIX = config.getString(Configs.MESSAGE_PREFIX).replaceAll("\\&", "§");
		}
		
		if (config.get(Configs.SIGN_FORMAT) != null) {
			List<String> format = config.getStringList(Configs.SIGN_FORMAT);
			if (format.size() != 4) {
				isb.getLogger().warning("---- Expected 4 lines of sign formatting but got " + format.size() + " ----");
			} else {
				Signs.sign_format.clear();
				for (String str : format)
					Signs.sign_format.add(str.replaceAll("\\&", "§"));
			}
		}
		
		isb.getLogger().info("---- Done reading configuration. ----");
	}
}
