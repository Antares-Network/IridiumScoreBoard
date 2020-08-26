package org.piotrwyrw.iridiumscoreboard.global;

public class Messages {
	
	public static String PREFIX = "§b§lIridiumScoreBoard§8 »§r ";
	public static String NO_PERMISSION = PREFIX + "§cYou don't have permission to do that.";
	public static String CONSOLE_NOT_ALLOWED = PREFIX + "§cYou must be a player to execute this command.";
	public static String ADD_PANEL = PREFIX + "§aThe score panel was added to the list.";
	public static String CLEAR_PANELS = PREFIX + "§aAll panels have been removed.";
	public static String NOT_A_SIGN = PREFIX + "§cThe selected block is not a sign.";
	public static String DONE_TESTING = PREFIX + "§aAll panels have been filled with test content.";
	public static String ENCOUNTERED_WRONG_BLOCK = PREFIX + "§cEncountered a block which is not a sign while testing the scoreboard. Skipped.";
	public static String STOP_TASK = PREFIX + "§aAll update tasks have been stopped. The scoreboard won't refresh until /isb start was called.";
	public static String START_TASK = PREFIX + "§aA new score board update process has just started.";
	public static String SAVED_PANELS = PREFIX + "§aSaved.";
	public static String RELOAD_COMPLETE = PREFIX + "§aConfig reloaded.";
	public static String RELOADING = PREFIX + "§7Reloading config ..";
	public static String ISLAND_IS_PRIVATE = PREFIX + "§cThis island is private.";
	public static String ISLAND_TELEPORT = PREFIX + "§aWhoosh!";
	public static String DONE_RESETTING = PREFIX + "§aConfig reset.";
	
	public static String EXCEPTION(String details) {
		return PREFIX + "§4Error\n§c" + details;
	}
	
	public static String EXPECTED_ARGUMENTS(int count) {
		return PREFIX + "§cThis command expected §7" + count + " §carguments.";
	}
}
