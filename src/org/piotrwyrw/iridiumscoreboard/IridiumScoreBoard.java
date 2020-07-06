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
import org.piotrwyrw.iridiumscoreboard.commands.IridiumScoreBoardMainCommand;
import org.piotrwyrw.iridiumscoreboard.config.IridiumScoreBoardConfiguration;
import org.piotrwyrw.iridiumscoreboard.globals.Messages;
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
		
		instance = this;
		
		if (!getServer().getPluginManager().getPlugin("IridiumSkyblock").isEnabled()) {
			getLogger().warning(Messages.PREFIX + "§7IridiumScoreBoard requires the IridiumSkyblock plugin to work. Install the plugin and try again.");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		board = new ScoreBoard();
		
		panelsFile = new File(getDataFolder(), "panels.yml");
		panels = YamlConfiguration.loadConfiguration(panelsFile);
		
		if (panels.get("scoreboard.panels") != null)
			for (String sectionstr : panels.getConfigurationSection("scoreboard.panels").getKeys(false)) {
				ConfigurationSection section = panels.getConfigurationSection("scoreboard.panels." + sectionstr);
				board.addPanel(new ScorePanel(panels.getLocation("scoreboard.panels." + sectionstr)));
			}
		
		IridiumScoreBoardConfiguration isbc = new IridiumScoreBoardConfiguration();
				
		getCommand("isb").setExecutor(new IridiumScoreBoardMainCommand());
		
		startUpdater();
	}
	
	@Override
	public void onDisable() {
		cancelAll();
	}
	
}