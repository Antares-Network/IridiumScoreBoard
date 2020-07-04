package org.piotrwyrw.iridiumscoreboard;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.piotrwyrw.iridiumscoreboard.commands.AddPanelCommand;
import org.piotrwyrw.iridiumscoreboard.commands.ClearCommand;
import org.piotrwyrw.iridiumscoreboard.commands.SaveCommand;
import org.piotrwyrw.iridiumscoreboard.commands.StartCommand;
import org.piotrwyrw.iridiumscoreboard.commands.StopCommand;
import org.piotrwyrw.iridiumscoreboard.commands.TestPanelCommand;

public class Main extends JavaPlugin {
	
	static Main instance = null;
	static ScoreBoard board = null;
	static FileConfiguration panels = null;
	static File panelsFile = null;
	
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
		ScoreUpdater su = new ScoreUpdater(board);
		su.runTaskTimer(instance, 0, 20*10);
	}
	
	@Override
	public void onEnable() {
		
		// Check for dependeny
		if (!getServer().getPluginManager().getPlugin("IridiumSkyblock").isEnabled()) {
			Bukkit.broadcastMessage(Messages.PREFIX + "§7IridiumScoreBoard requires the IridiumSkyblock plugin to work. Install the plugin and try again.");
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
		
		// Instantiate the scoreboard
		board = new ScoreBoard();
		instance = this;
		
		// Load the panels data file
		panelsFile = new File(getDataFolder(), "panels.yml");
		panels = YamlConfiguration.loadConfiguration(panelsFile);
		
		if (panels.get("scoreboard.panels") != null)
			for (String sectionstr : panels.getConfigurationSection("scoreboard.panels").getKeys(false)) {
				ConfigurationSection section = panels.getConfigurationSection("scoreboard.panels." + sectionstr);
				board.addPanel(new ScorePanel(panels.getLocation("scoreboard.panels." + sectionstr)));
			}
				
		// Register commands
		getCommand("isbadd").setExecutor(new AddPanelCommand());
		getCommand("isbtest").setExecutor(new TestPanelCommand());
		getCommand("isbclear").setExecutor(new ClearCommand());
		getCommand("isbsave").setExecutor(new SaveCommand());
		getCommand("isbstop").setExecutor(new StopCommand());
		getCommand("isbstart").setExecutor(new StartCommand());
		
		startUpdater();
	}
	
	@Override
	public void onDisable() {
		cancelAll();
	}
	
}