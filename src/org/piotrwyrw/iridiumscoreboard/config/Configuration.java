package org.piotrwyrw.iridiumscoreboard.config;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.global.ConfigPath;
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.SignFormats;
import org.piotrwyrw.iridiumscoreboard.util.Utilities;

public class Configuration {
	public static void readConfig() {	
		IridiumScoreBoard isb = IridiumScoreBoard.getInstance();
		FileConfiguration config = isb.getConfig();
		
		File configFile = new File(isb.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			isb.getLogger().info("\n\n---- Creating configuration file .. ----\n");
			isb.saveResource("config.yml", true);
		}
		
		if (config.get(ConfigPath.MESSAGE_PREFIX) != null) {
			Messages.PREFIX = Utilities.specialCharacterFields(config.getString(ConfigPath.MESSAGE_PREFIX).replaceAll("\\&", "§"));
		}
		
		if (config.get(ConfigPath.NO_PERMISSION) != null) {
			Messages.NO_PERMISSION = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.NO_PERMISSION));
		}
		
		if (config.get(ConfigPath.CONSOLE_NOT_ALLOWED) != null) {
			Messages.CONSOLE_NOT_ALLOWED = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.CONSOLE_NOT_ALLOWED));
		}
		
		if (config.get(ConfigPath.ADD_PANEL) != null) {
			Messages.ADD_PANEL = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.ADD_PANEL));
		}
		
		if (config.get(ConfigPath.CLEAR_PANELS) != null) {
			Messages.CLEAR_PANELS = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.CLEAR_PANELS));
		}
		
		if (config.get(ConfigPath.NOT_A_SIGN) != null) {
			Messages.NOT_A_SIGN = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.NOT_A_SIGN));
		}
		
		if (config.get(ConfigPath.DONE_TESTING) != null) {
			Messages.DONE_TESTING = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.DONE_TESTING));
		}
		
		if (config.get(ConfigPath.ENCOUNTERED_WRONG_BLOCK) != null) {
			Messages.ENCOUNTERED_WRONG_BLOCK = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.ENCOUNTERED_WRONG_BLOCK));
		}
		
		if (config.get(ConfigPath.STOP_TASK) != null) {
			Messages.STOP_TASK = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.STOP_TASK));
		}
		
		if (config.get(ConfigPath.START_TASK) != null) {
			Messages.START_TASK = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.START_TASK));
		}
		
		if (config.get(ConfigPath.SAVED_PANELS) != null) {
			Messages.SAVED_PANELS = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.SAVED_PANELS));
		}
		
		if (config.get(ConfigPath.RELOAD_COMPLETE) != null) {
			Messages.RELOAD_COMPLETE = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.RELOAD_COMPLETE));
		}
		
		if (config.get(ConfigPath.RELOADING) != null) {
			Messages.RELOADING = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.RELOADING));
		}
		
		if (config.get(ConfigPath.ISLAND_IS_PRIVATE) != null) {
			Messages.ISLAND_IS_PRIVATE = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.ISLAND_IS_PRIVATE));
		}
		
		if (config.get(ConfigPath.ISLAND_TELEPORT) != null) {
			Messages.ISLAND_TELEPORT = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.ISLAND_TELEPORT));
		}
		
		if (config.get(ConfigPath.RESETTING_CONFIGURATION) != null) {
			Messages.RESETTING_CONFIGURATION = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.RESETTING_CONFIGURATION));
		}
		
		if (config.get(ConfigPath.DONE_RESETTING) != null) {
			Messages.DONE_RESETTING = Messages.PREFIX + Utilities.specialCharacterFields(config.getString(ConfigPath.DONE_RESETTING));
		}
		
		if (config.get(ConfigPath.SIGN_FORMAT) != null) {
			List<String> format = config.getStringList(ConfigPath.SIGN_FORMAT);
			if (format.size() != 4) {
				isb.getLogger().warning("\n\n---- Expected 4 lines of sign formatting but got " + format.size() + " ----\n");
			} else {
				SignFormats.sign_format.clear();
				for (String str : format)
					SignFormats.sign_format.add(str.replaceAll("\\&", "§"));
			}
		}
		
		if (config.get(ConfigPath.EMPTY_SIGN_FORMAT) != null) {
			List<String> format = config.getStringList(ConfigPath.EMPTY_SIGN_FORMAT);
			if (format.size() != 4) {
				isb.getLogger().warning("\n\n---- Expected 4 lines of empty sign formatting but got " + format.size() + " ----\n");
			} else {
				SignFormats.empty.clear();
				for (String str : format)
					SignFormats.empty.add(str.replaceAll("\\&", "§"));
			}
		}
		
		isb.getLogger().info("\n\n---- Done reading configuration. ----\n");
	}
}
