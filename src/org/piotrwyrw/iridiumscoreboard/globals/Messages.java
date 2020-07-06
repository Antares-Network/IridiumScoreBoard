package org.piotrwyrw.iridiumscoreboard.globals;

public class Messages {
	
	// Plugin message prefux
	public static String PREFIX = "§b§lIridiumScoreBoard§8 »§r ";
	
	// No permission message
	public static String NO_PERMISSION = PREFIX + "§cYou don't have permission to do that.";
	
	// You must be a player message
	public static String NO_CONSOLE = PREFIX + "§cYou must be a player to execute this command.";
	
	// Panel added to list message
	public static String PANEL_ADDED = PREFIX + "§aThe score panel was added to the list.";
	
	// All panels have been removed message
	public static String REMALL_DONE = PREFIX + "§aAll panels have been removed.";
	
	// Selected block is not a sign message
	public static String NOT_SIGN = PREFIX + "§cThe selected block is not a sign.";
	
	// All panels have been tested message
	public static String TEST_DONE = PREFIX + "§aAll panels have been filled with test content.";
	
	// Encountered block which is not a sign while testing message
	public static String TEST_WRONG_BLOCK = PREFIX + "§cEncountered a block which is not a sign while testing the scoreboard. Skipped.";
	
	// All tasks stoppen message
	public static String TASK_STOP = PREFIX + "§aAll update tasks have been stopped. The scoreboard won't refresh until /isbstart was called.";
	
	// Task started
	public static String TASK_START = PREFIX + "§aA new score board update process has just started.";
	
	// Saved message
	public static String SAVED = PREFIX + "§aSaved.";
	
	// Reload
	public static String CONF_RELOAD = PREFIX + "§aConfig reloaded.";
	
	// Reloading
	public static String CONF_RELOADING = PREFIX + "§7Reloading config ..";
	
	// Exception message
	public static String EXCEPTION(String details) {
		return PREFIX + "§4Error\n§c" + details;
	}
	
	// Command expected x arguments message
	public static String EXPECTED_ARGUMENTS(int count) {
		return PREFIX + "§cThis command expected §7" + count + " §carguments.";
	}
}
