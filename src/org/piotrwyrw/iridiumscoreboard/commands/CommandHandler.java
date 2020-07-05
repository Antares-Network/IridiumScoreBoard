package org.piotrwyrw.iridiumscoreboard.commands;

import org.bukkit.command.CommandSender;

public abstract class CommandHandler {
	public abstract boolean handleCommand(CommandSender sender, String[] args);
}
