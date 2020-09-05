package org.piotrwyrw.iridiumscoreboard;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.piotrwyrw.iridiumscoreboard.commands.MainCommand;
import org.piotrwyrw.iridiumscoreboard.config.Configuration;
import org.piotrwyrw.iridiumscoreboard.global.Messages;
import org.piotrwyrw.iridiumscoreboard.global.Texts;
import org.piotrwyrw.iridiumscoreboard.listener.ClickableSign;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreBoard;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScorePanel;
import org.piotrwyrw.iridiumscoreboard.scoreboard.ScoreUpdater;

public class IridiumScoreBoard extends JavaPlugin {
	
	static IridiumScoreBoard instance = null;
	static ScoreBoard board = null;
	static FileConfiguration panels = null;
	static File panelsFile = null;
	
	public static IridiumScoreBoard getInstance() {
		return instance;
	}
	
	public static ScoreBoard getScoreBoard() {
		return board;
	}
	
	public static FileConfiguration getPanels() {
		return panels;
	}
	
	public static File getPanelsFile() {
		return panelsFile;
	}
	
	public static void savePanels() {
		try {
			panels.save(panelsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void cancelAll() {
		Bukkit.getScheduler().cancelTasks(instance);
	}
	
	public static void startUpdater() {
		ScoreUpdater updater = new ScoreUpdater(board);
		updater.runTaskTimer(instance, 0, 20*10);
	}
	
	
	@Override
	public void onEnable() {
		if (getServer().getPluginManager().getPlugin("IridiumSkyblock") == null) {
			for (String line : Texts.no_dependency) {
				getLogger().warning(line);
			}
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		instance = this;
		board = new ScoreBoard();
		panelsFile = new File(getDataFolder(), "panels.yml");
		panels = YamlConfiguration.loadConfiguration(panelsFile);
		Configuration.readConfig();
		
		if (panels.get("scoreboard.panels") != null)
			for (String sectionstr : panels.getConfigurationSection("scoreboard.panels").getKeys(false)) {
				ConfigurationSection section = panels.getConfigurationSection("scoreboard.panels." + sectionstr);
				board.addPanel(new ScorePanel(panels.getLocation("scoreboard.panels." + sectionstr)));
			}
						
		getCommand("isb").setExecutor(new MainCommand());
		getServer().getPluginManager().registerEvents(new ClickableSign(), this);
		
		startUpdater();
		
		for (String line : Texts.enable)
			getLogger().info(line);
	}
	
	@Override
	public void onDisable() {
		cancelAll();
		
		for (String line : Texts.disable) {
			getLogger().info(line);
		}
	}
	
}