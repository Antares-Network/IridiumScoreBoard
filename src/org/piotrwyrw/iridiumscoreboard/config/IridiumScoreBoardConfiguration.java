package org.piotrwyrw.iridiumscoreboard.config;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.piotrwyrw.iridiumscoreboard.IridiumScoreBoard;
import org.piotrwyrw.iridiumscoreboard.globals.Configs;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
import org.piotrwyrw.iridiumscoreboard.globals.Signs;
import org.piotrwyrw.iridiumscoreboard.util.Fields;

public class IridiumScoreBoardConfiguration {
	public IridiumScoreBoardConfiguration() {	
		IridiumScoreBoard isb = IridiumScoreBoard.getInstance();
		FileConfiguration config = isb.getConfig();
		
		File configFile = new File(isb.getDataFolder(), "config.yml");
		if (!configFile.exists()) {
			isb.getLogger().info("\n\n---- Creating configuration file .. ----\n");
			isb.saveResource("config.yml", true);
		}
		
		if (config.get(Configs.MESSAGE_PREFIX) != null) {
			Messages.PREFIX = Fields.specialCharacterFields(config.getString(Configs.MESSAGE_PREFIX).replaceAll("\\&", "§"));
		}
		
		if (config.get(Configs.NO_PERMISSION) != null) {
			Messages.NO_PERMISSION = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.NO_PERMISSION));
		}
		
		if (config.get(Configs.NO_CONSOLE) != null) {
			Messages.NO_CONSOLE = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.NO_CONSOLE));
		}
		
		if (config.get(Configs.PANEL_ADD) != null) {
			Messages.PANEL_ADDED = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.PANEL_ADD));
		}
		
		if (config.get(Configs.PANEL_REMALL) != null) {
			Messages.REMALL_DONE = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.PANEL_REMALL));
		}
		
		if (config.get(Configs.NOT_SIGN) != null) {
			Messages.NOT_SIGN = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.NOT_SIGN));
		}
		
		if (config.get(Configs.TEST_DONE) != null) {
			Messages.TEST_DONE = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.TEST_DONE));
		}
		
		if (config.get(Configs.TEST_WRONG_BLOCK) != null) {
			Messages.TEST_WRONG_BLOCK = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.TEST_WRONG_BLOCK));
		}
		
		if (config.get(Configs.TASK_STOP) != null) {
			Messages.TASK_STOP = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.TASK_STOP));
		}
		
		if (config.get(Configs.TASK_START) != null) {
			Messages.TASK_START = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.TASK_START));
		}
		
		if (config.get(Configs.SAVED) != null) {
			Messages.SAVED = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.SAVED));
		}
		
		if (config.get(Configs.RELOAD) != null) {
			Messages.CONF_RELOAD = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.RELOAD));
		}
		
		if (config.get(Configs.RELOADING) != null) {
			Messages.CONF_RELOADING = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.RELOADING));
		}
		
		if (config.get(Configs.IS_PRIVATE) != null) {
			Messages.IS_PRIVATE = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.IS_PRIVATE));
		}
		
		if (config.get(Configs.IS_WHOOSH) != null) {
			Messages.IS_SB_TP = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.IS_WHOOSH));
		}
		
		if (config.get(Configs.RESETTING_CONF) != null) {
			Messages.RESETTING_CONF = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.RESETTING_CONF));
		}
		
		if (config.get(Configs.RESET_DONE) != null) {
			Messages.RESET_DONE = Messages.PREFIX + Fields.specialCharacterFields(config.getString(Configs.RESET_DONE));
		}
		
		if (config.get(Configs.SIGN_FORMAT) != null) {
			List<String> format = config.getStringList(Configs.SIGN_FORMAT);
			if (format.size() != 4) {
				isb.getLogger().warning("\n\n---- Expected 4 lines of sign formatting but got " + format.size() + " ----\n");
			} else {
				Signs.sign_format.clear();
				for (String str : format)
					Signs.sign_format.add(str.replaceAll("\\&", "§"));
			}
		}
		
		if (config.get(Configs.EMPTY_SIGN_FORMAT) != null) {
			List<String> format = config.getStringList(Configs.EMPTY_SIGN_FORMAT);
			if (format.size() != 4) {
				isb.getLogger().warning("\n\n---- Expected 4 lines of empty sign formatting but got " + format.size() + " ----\n");
			} else {
				Signs.empty.clear();
				for (String str : format)
					Signs.empty.add(str.replaceAll("\\&", "§"));
			}
		}
		
		isb.getLogger().info("\n\n---- Done reading configuration. ----\n");
	}
}
